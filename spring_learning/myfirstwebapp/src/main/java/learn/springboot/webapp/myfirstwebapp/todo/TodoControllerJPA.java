package learn.springboot.webapp.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
//this adds data from the session to the modelmap in all the requests handled by this controller
@SessionAttributes("name")
public class TodoControllerJPA {

	private TodoRepository todoRepository;
	
	public TodoControllerJPA(TodoRepository todoRepository) {
		super();
		this.todoRepository = todoRepository;
	}

	// list-todos
	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		String userName = getLoggedInUserName();
		List<Todo> todos = todoRepository.findByUserName(userName);
		model.put("todos", todos);
		return "listTodos";
	}
	
	// add-todo using form-backing object
	// create a default todo object and map it to model because we have added modelAttribute on the form
	@RequestMapping(value = "add-todo", method = RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		String userName = (String) model.get("name");
		Todo todo = new Todo(0, userName, "Default description", LocalDate.now().plusMonths(2), false);
		model.put("todo", todo);
		return "todo";
	}
	// 2-way binding, default todo object before the page is loaded
	// and todo object with the details entered in the page comes as part of post request
	@RequestMapping(value = "add-todo", method = RequestMethod.POST)
	public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		todo.setUserName(getLoggedInUserName());
		todoRepository.save(todo);
		return "redirect:list-todos"; // this redirects to the mentioned action
	}
	
	@RequestMapping(value = "delete-todo")
	public String deleteTodo(@RequestParam int id) {
		todoRepository.deleteById(id);
		return "redirect:list-todos";
	}
	
	@RequestMapping(value = "update-todo", method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		Optional<Todo> todo = todoRepository.findById(id);
		if(todo.isPresent()) {
			model.put("todo", todo.get());
		}
		return "todo";
	}
	
	@RequestMapping(value = "update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		todo.setUserName(getLoggedInUserName());
		todoRepository.save(todo);
		return "redirect:list-todos"; // this redirects to the mentioned action
	}
	
	private String getLoggedInUserName() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
}
