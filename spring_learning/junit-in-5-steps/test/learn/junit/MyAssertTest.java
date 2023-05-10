package learn.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class MyAssertTest {

	List<String> todos = List.of("AWS", "Azure", "DevOps");
	
	@Test
	void test() {
		assertEquals(true, todos.contains("AWS"));
		assertTrue(todos.contains("AWS"), "Something went wrong");
		assertFalse(todos.contains("GCP"), "Something went wrong");
		assertEquals(3, todos.size());
		
		assertArrayEquals(new int[] {1, 2}, new int[] {1, 2});
	}
}
