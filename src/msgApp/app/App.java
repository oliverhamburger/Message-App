package msgApp.app;

import java.util.ArrayList;

import msgApp.backend.model.User;

public class App {
	
	private static ArrayList<User> users = new ArrayList<User>();
	
	public static void loadDataFromDataStore() {
		//load the data from userData.txt into users arraylist
	}
	
	public static ArrayList<User> getUsers(){
		return users;
	}
	
	public static void setUser(int i, User u) {
		users.set(i, u);
	}
	
	public static void addUser(User user) {
		users.add(user);
	}
	
	public static void loadDataToDataStore() {
		//load the users arraylist into userData.txt
	}
	
	public static void displayData() {
		for(User user: users) {
			System.out.println(user);
		}
	}
	
}
