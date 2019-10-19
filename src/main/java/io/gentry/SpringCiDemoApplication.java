package io.gentry;

import io.gentry.todos.Todo;
import io.gentry.todos.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringCiDemoApplication {

	@Autowired
	private TodoService todoService;

	public static void main(String[] args) {
		SpringApplication.run(SpringCiDemoApplication.class, args);
	}

	@PostConstruct
	public void initDb() {
		List<Todo> todos = new ArrayList<>();
		for (int i = 1; i <= 100; i++) {
			todos.add(new Todo("Title " + i, "Description " + i, i % 2 == 0));
		}
		todoService.saveAll(todos);
	}

}
