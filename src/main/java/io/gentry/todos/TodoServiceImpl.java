package io.gentry.todos;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author William Gentry
 */
@Service
public class TodoServiceImpl implements TodoService {

	private final TodoRepository todoRepository;

	public TodoServiceImpl(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	@Override
	public List<Todo> findAllTodos() {
		return todoRepository.findAll();
	}

	@Override
	public void saveAll(List<Todo> todos) {
		todoRepository.saveAll(todos);
	}
}
