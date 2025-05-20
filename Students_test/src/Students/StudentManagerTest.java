package Students;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentManagerTest {

	StudentManager SM;
	
	@BeforeEach
	void setUp() throws Exception {
		SM = new StudentManager();
	}

	@Test
	void testAddStudent() {
		SM.addStudent("a");
		assertTrue(SM.hasStudent("a"));
	}
	
	@Test
	void testAddStudent_dup() {
		SM.addStudent("b");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
	        SM.addStudent("b");
	    });
		System.out.println(e.getMessage());
	}

	@Test
	void testRemoveStudent() {
		SM.addStudent("c");
		assertTrue(SM.hasStudent("c"));
		SM.removeStudent("c");
		assertFalse(SM.hasStudent("c"));
	}
	
	@Test
	void testRemoveStudent_dup() {
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
	        SM.removeStudent("d");
	    });
		System.out.println(e.getMessage());
	}

	@Test
	void testHasStudent() {
		 assertFalse(SM.hasStudent("e"));

		 SM.addStudent("e");
		 assertTrue(SM.hasStudent("e"));

		 SM.removeStudent("e");
		 assertFalse(SM.hasStudent("e"));
	}

}
