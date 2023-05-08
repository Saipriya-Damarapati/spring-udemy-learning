package learn.restapi.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class UserResource {
	
	private UserDaoService userDaoService;
	
	public UserResource(UserDaoService userDaoService) {
		super();
		this.userDaoService = userDaoService;
	}

	@GetMapping(path = "/users")
	public List<User> retrieveAllUsers() {
		return userDaoService.findAll();
	}
	
	@GetMapping(path = "/users/{id}")
	public User retrieveUserById(@PathVariable int id) {
		User user = userDaoService.findOne(id);
		
		if(user == null) {
			throw new UserNotFoundException("id:" + id);
		}
		return user;
	}
	
	@PostMapping(path = "/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = userDaoService.save(user);
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
		User user = userDaoService.findOne(id);
		if(user == null) {
			throw new UserNotFoundException("id:" + id);
		}
		userDaoService.delete(user);
	}
	
}
