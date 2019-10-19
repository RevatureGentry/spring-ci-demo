package io.gentry.todos;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author William Gentry
 */
@RestController
public class TodoController {

	private final TodoService todoService;

	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}

	@GetMapping("/")
	public ResponseEntity<List<Todo>> getAllTodos() {
		List<Todo> todos = todoService.findAllTodos();
		if (todos != null && !todos.isEmpty()) {
			return ResponseEntity.ok(todos);
		}
		return ResponseEntity.noContent().build();
	}
}
