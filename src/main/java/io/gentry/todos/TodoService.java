package io.gentry.todos;

import java.util.List;

/**
 * @author William Gentry
 */
public interface TodoService {

	List<Todo> findAllTodos();
	void saveAll(List<Todo> todos);
}
