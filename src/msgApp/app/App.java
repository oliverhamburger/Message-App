package msgApp.app;

import java.util.ArrayList;

import msgApp.backend.model.User;

public class App {
	
	static private ArrayList<User> users = new ArrayList<User>();
	
	static public void loadDataFromDataStore() {
		//load the data from userData.txt into users arraylist
	}
	
	static public ArrayList<User> getUsers(){
		return users;
	}
	
	static public void setUser(int i, User u) {
		users.set(i, u);
	}
	
	static public void addUser(User user) {
		users.add(user);
	}
	
	static public void loadDataToDataStore() {
		//load the users arraylist into userData.txt
	}
	
}
