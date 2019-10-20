package io.gentry.springcidemo;

import io.gentry.todos.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(MockitoExtension.class)
public class SpringCiDemoApplicationTests {

	private TodoService todoService;
	private TodoController todoController;
	private TodoRepository todoRepository;

	private MockMvc mockMvc;

	private static List<Todo> todos = new ArrayList<>();

	@BeforeAll
	static void initTodos() {
		for (int i = 1; i <=100; i++) {
			todos.add(new Todo("Title " + i, "Description " + i, i % 2 == 0));
		}
	}

	@BeforeEach
	void init() {
		todoRepository = mock(TodoRepository.class);
		todoService = spy(new TodoServiceImpl(todoRepository));
		todoController = new TodoController(todoService);
		mockMvc = MockMvcBuilders.standaloneSetup(todoController).build();
	}


	@Test
	void service_ShouldReturnAllTodos() {
		when(todoRepository.findAll()).thenReturn(todos);
		assertThat(todoService.findAllTodos()).isNotNull();
		assertThat(todoService.findAllTodos().size()).isEqualTo(100);
		verify(todoRepository, times(2)).findAll();
	}

	@Test
	void service_ShouldBatchCreateTodo() {
		todoService.saveAll(todos);
		verify(todoRepository, times(1)).saveAll(todos);
	}

	@Test
	void controller_ShouldBeOk() throws Exception {
		when(todoRepository.findAll()).thenReturn(todos);
		final MockHttpServletResponse response = mockMvc.perform(get("/")).andReturn().getResponse();
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
		verify(todoService, times(1)).findAllTodos();
	}
}
