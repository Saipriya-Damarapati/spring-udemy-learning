package learn.restapi.restfulwebservices.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;
import learn.restapi.restfulwebservices.user.post.Post;
import learn.restapi.restfulwebservices.user.post.PostRepository;

@RestController
@RequestMapping("/jpa")
public class UserResourceJPA {
	
	private UserRepository userRepository;
	private PostRepository postRepository;
	
	public UserResourceJPA(UserRepository userRepository, PostRepository postRepository) {
		super();
		this.userRepository = userRepository;
		this.postRepository = postRepository;
	}

	@GetMapping(path = "/users")
	public List<User> retrieveAllUsers() {
		return userRepository.findAll();
	}
	
	@GetMapping(path = "/users/{id}")
	public EntityModel<User> retrieveUserById(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);
		
		if(user.isEmpty()) {
			throw new UserNotFoundException("id:" + id);
		}
		
		EntityModel<User> entityModel = EntityModel.of(user.get());
		WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(methodOn(this.getClass()).retrieveAllUsers());
		entityModel.add(link.withRel("all-users"));
		
		return entityModel;
	}
	
	@PostMapping(path = "/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = userRepository.save(user);
		// /users/4 => /users/{id}, user.getId()
		URI location = ServletUriComponentsBuilder.fromCurrentRequest() // to get the url from the current request
									.path("/{id}")						// append id
									.buildAndExpand(savedUser.getId())	// replace the value of id
									.toUri();							// convert to uri
		// location - /users/{id}
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(path = "/users/{id}")
	public void deleteUserById(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);
		if(user.isEmpty()) {
			throw new UserNotFoundException("id:" + id);
		}
		userRepository.delete(user.get());
	}
	
	@GetMapping(path = "/users/{id}/posts")
	public List<Post> retrievePostsForUser(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);
		
		if(user.isEmpty()) {
			throw new UserNotFoundException("id:" + id);
		}
		
		return user.get().getPosts();
	}
	
	@GetMapping(path = "/users/{userId}/posts/{postId}")
	public Post retrievePostsForUser(@PathVariable int userId, @PathVariable int postId) {
		Optional<Post> post = postRepository.findById(postId);
		
		if(post.isEmpty()) {
			throw new UserNotFoundException("id:" + postId);
		}
		
		return post.get();
	}
	
	@PostMapping(path = "/users/{id}/posts")
	public ResponseEntity<Object> createPostForUser(@PathVariable int id, @Valid @RequestBody Post post) {
		Optional<User> user = userRepository.findById(id);
		if(user.isEmpty()) {
			throw new UserNotFoundException("id:" + id);
		}
		post.setUser(user.get());
		Post savedPost = postRepository.save(post);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest() // to get the url from the current request
									.path("/{id}")						// append id
									.buildAndExpand(savedPost.getId())	// replace the value of id
									.toUri();							// convert to uri
		
		return ResponseEntity.created(location).build();
	}
	
}
