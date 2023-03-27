package msgApp.app;

import java.util.ArrayList;

import msgApp.backend.model.Message;
import msgApp.backend.model.User;

public class App {
	
	private static ArrayList<User> users = new ArrayList<User>();
	private static ArrayList<Message> allMessages = new ArrayList<Message>();
	
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
	
	public static String getFeed() {
		String toReturn = "";
		
		for(int i = allMessages.size()-1; i >= 0; i--) {
			toReturn += "Date & Time: " + allMessages.get(i).getDateCreated() + "\n";
			toReturn += "From: " + allMessages.get(i).getAuthor() + "\n";
			toReturn += allMessages.get(i).getBody() + "\n\n\n";
		}
		
		return toReturn;
	}
	
	public static void displayData() {
		for(User user: users) {
			System.out.println(user);
		}
	}

	public static void addMessageToAllMessagesList(Message m) {
		allMessages.add(m);
	}
	
}
