package io.gentry.todos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author William Gentry
 */
@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {
}
