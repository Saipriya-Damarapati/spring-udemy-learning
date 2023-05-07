package learn.springboot.webapp.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<>();
	private static int todosCount = 0;
	
	static {
		todos.add(new Todo(++todosCount, "Priya", "Learn AWS", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todosCount, "Ranga", "Learn DevOps", LocalDate.now().plusYears(2), false));
		todos.add(new Todo(++todosCount, "Ranga", "Learn Fullstack", LocalDate.now().plusYears(3), false));
	}

	public static List<Todo> findByUserName(String userName) {
		Predicate<? super Todo> predicate = todo -> (userName.equalsIgnoreCase(todo.getUserName()));
		return todos.stream().filter(predicate).toList();
	}
	
	public void addTodo(String userName, String description, LocalDate date, boolean done) {
		todos.add(new Todo(++todosCount, userName, description, date, done));
	}

	public void deleteByID(int id) {
		todos.removeIf(todo -> (todo.getId() == id));
	}

	public void updateById(Todo todo) {
		deleteByID(todo.getId());
		todos.add(todo);
	}

	public Todo findById(int id) {
		//return todos.stream().filter(todo -> (todo.getId() == id)).findFirst().get();
		Predicate<? super Todo> predicate = todo -> (todo.getId() == id);
		return todos.stream().filter(predicate).findFirst().get();
	}
}
