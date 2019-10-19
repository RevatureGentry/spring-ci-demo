package io.gentry.todos;

import javax.persistence.*;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * @author William Gentry
 */
@Entity
@Table
public class Todo {

	@Id
	@GeneratedValue
	private int id;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "completed")
	private boolean completed;

	public Todo() {
	}

	public Todo(String title, String description, boolean completed) {
		this.title = title;
		this.description = description;
		this.completed = completed;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Todo todo = (Todo) o;
		return id == todo.id &&
						completed == todo.completed &&
						Objects.equals(title, todo.title) &&
						Objects.equals(description, todo.description);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, title, description, completed);
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", Todo.class.getSimpleName() + "[", "]")
						.add("id=" + id)
						.add("title='" + title + "'")
						.add("description='" + description + "'")
						.add("completed=" + completed)
						.toString();
	}
}
