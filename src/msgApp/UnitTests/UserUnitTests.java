package msgApp.UnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import msgApp.backend.model.User;

class UserUnitTests {

	@Test
	void userConstructionGetersAndSetters() {
		String username = "test";
		String password = "testtest";
		User u = new User(username, password);
		assertEquals(username, u.getUserName());
		assertEquals(password, u.getPassword());
		assertEquals(u.getLoggedIn(), false);
	}
	
	@Test
	void equals() {
		User u1 = new User("test", "pass");
		User u2 = new User("test", "pass");
		User u3 = new User("lala", "baba");
		User u4 = new User("test", "best");
		User u5 = new User("mhm", "pass");
		assertTrue(u1.equals(u2));
		assertFalse(u1.equals(u3));
		assertFalse(u1.equals(u4));
		assertFalse(u1.equals(u5));
	}

}
