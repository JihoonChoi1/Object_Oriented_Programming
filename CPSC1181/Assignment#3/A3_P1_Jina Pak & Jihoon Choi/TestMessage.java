import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * A JUnit test class to ensure all of the methods in Message class works intentionally and correctly.
 * 
 * @author Jina Pak
 * @author Jihoon Choi
 * @since 2022-10-02
 */
class TestMessage {
	
	@Test
	void testConstructor() {
		try {
			Message message = new Message(null, "Jihoon", "Hi", Message.Status.unread);
			fail("Expected an NullPointerException");
		}
		catch(NullPointerException e) {}
		
		try {
			Message message = new Message("Jina", null, "Hi", Message.Status.unread);
			fail("Expected an NullPointerException");
		}
		catch(NullPointerException e) {}
		
		try {
			Message message = new Message("Jina", "Jihoon", null, Message.Status.unread);
			fail("Expected an NullPointerException");
		}
		catch(NullPointerException e) {}
		
		try {
			Message message = new Message("Jina", "Jihoon", "Hi", null);
			fail("Expected an NullPointerException");
		}
		catch(NullPointerException e) {}
		
		try {
			Message message = new Message(null, null, null, null);
			fail("Expected an NullPointerException");
		}
		catch(NullPointerException e) {}
		
		try {
			Message message = new Message(null, "Jina", "Hi");
			fail("Expected an NullPointerException");
		}
		catch(NullPointerException e) {}
		
		try {
			Message message = new Message(null, "Jina", "Hi");
			fail("Expected an NullPointerException");
		}
		catch(NullPointerException e) {}
		
		try {
			Message message = new Message("Jihoon", null, "Hi");
			fail("Expected an NullPointerException");
		}
		catch(NullPointerException e) {}
		
		try {
			Message message = new Message("Jihoon", "Jina", null);
			fail("Expected an NullPointerException");
		}
		catch(NullPointerException e) {}
		
		try {
			Message message = new Message(null, null, null);
			fail("Expected an NullPointerException");
		}
		catch(NullPointerException e) {}
		
		Message message = new Message("Jihoon", "Jina", "Hi");
		assertEquals(Message.Status.unread, message.getStatus());
		Message a = new Message("Jihoon", "Jina", "Hi", Message.Status.read);
		assertEquals(Message.Status.read, a.getStatus());
	}
	
	@Test
	void testGetSender() {
		Message message = new Message("Jihoon", "Jina", "Hi");
		assertEquals("Jihoon", message.getSender());
		Message a = new Message("", "Jina", "Hi");
		assertEquals("", a.getSender());
	}
	
	@Test
	void testGetRecipient() {
		Message message = new Message("Jihoon", "Jina", "Hi");
		assertEquals("Jina", message.getRecipient());
		Message a = new Message("Jihoon", "", "Hi");
		assertEquals("", a.getRecipient());
	}
	
	@Test
	void testGetText() {
		Message message = new Message("Jihoon", "Jina", "Hi");
		assertEquals("Hi", message.getText());
		Message a = new Message("Jihoon", "Jina", "");
		assertEquals("", a.getText());
	}
	
	@Test
	void testGetStatus() {
		Message message = new Message("Jihoon", "Jina", "Hi");
		assertEquals(Message.Status.unread, message.getStatus());
		Message a = new Message("Jihoon", "Jina", "Hi", Message.Status.read);
		assertEquals(Message.Status.read, a.getStatus());
		Message b = new Message("Jihoon", "Jina", "Hi", Message.Status.trash);
		assertEquals(Message.Status.trash, b.getStatus());
		Message c = new Message("Jihoon", "Jina", "Hi", Message.Status.unread);
		assertEquals(Message.Status.unread, c.getStatus());
	}
	
	@Test
	void testSetStatus() {
		Message message = new Message("Jihoon", "Jina", "Hi");
		try {
			message.setStatus(null);
			fail("Expected NullPointerException");
		}
		catch(NullPointerException e) {}
		
		message.setStatus(Message.Status.read);
		assertEquals(Message.Status.read, message.getStatus());
		message.setStatus(Message.Status.trash);
		assertEquals(Message.Status.trash, message.getStatus());
		message.setStatus(Message.Status.unread);
		assertEquals(Message.Status.unread, message.getStatus());
	}
}
