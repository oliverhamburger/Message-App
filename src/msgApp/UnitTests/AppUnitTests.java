package msgApp.UnitTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import msgApp.app.App;
import msgApp.backend.model.Message;
import msgApp.backend.model.User;

class AppUnitTests {
	
	private ArrayList<User> testUsers = new ArrayList<User>();
	private ArrayList<Message> testAllMessages = new ArrayList<Message>();

	@Test
	void loadDataToAndFromDataStoreTest() {
		//setup for matching data store arraylists
		User u = new User("test", "test");
		User u1 = new User("test1", "test1");
		Message m = new Message("body", "author");
		Message m1 = new Message("the body", "the author");
		testUsers.add(u);
		testUsers.add(u1);
		testAllMessages.add(m);
		testAllMessages.add(m1);
		
		//populate class arraylists, load them to dataStore
		App.addUser(u);
		App.addUser(u1);
		App.addMessage(m);
		App.addMessage(m1);
		App.loadDataToDataStore("src/msgApp/UnitTests/userDataForTest.txt", "src/msgApp/UnitTests/messagesForTest.txt");
		
		//clear app's arraylists and then load them in from data store, then compare to setup test arraylists
		App.getUsers().clear();
		App.getMessages().clear();
		App.loadDataFromDataStore("src/msgApp/UnitTests/userDataForTest.txt", "src/msgApp/UnitTests/messagesForTest.txt");
		
		ArrayList<User> appUsers = App.getUsers();
		ArrayList<Message> appMessages = App.getMessages();
		
		//see if the user data matches
		for(int i = 0; i < testUsers.size(); i++) {
			assertEquals(testUsers.get(i).getUserName(), appUsers.get(i).getUserName());
			assertEquals(testUsers.get(i).getPassword(), appUsers.get(i).getPassword());
		}
		
		//see if the messages data matches
		for(int i = 0; i < testUsers.size(); i++) {
			assertEquals(testAllMessages.get(i).getBody(), appMessages.get(i).getBody());
			assertEquals(testAllMessages.get(i).getAuthor(), appMessages.get(i).getAuthor());
		}
		
	}

}
