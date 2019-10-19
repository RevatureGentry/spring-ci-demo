package io.gentry.springcidemo;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpringCiDemoApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void failingTest() {
		throw new RuntimeException();
	}
}
