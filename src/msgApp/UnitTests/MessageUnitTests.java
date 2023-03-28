package msgApp.UnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import msgApp.backend.model.Message;

class MessageUnitTests {

	@Test
	void messageConstructionGetersAndSetters() {
		Message m = new Message("The message body", "The Author");
		assertEquals("The message body", m.getBody());
		assertEquals("The Author", m.getAuthor());
	}
}
