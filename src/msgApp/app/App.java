package msgApp.app;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import msgApp.backend.model.Message;
import msgApp.backend.model.User;

public class App {
	
	private static ArrayList<User> users = new ArrayList<User>();
	private static ArrayList<Message> allMessages = new ArrayList<Message>();
	
	public static void loadDataFromDataStore(String userDataPath, String messagesPath) {
		//read the data from userData.txt into users arraylist
		try{
		    FileInputStream readData = new FileInputStream(userDataPath);
		    ObjectInputStream readStream = new ObjectInputStream(readData);

		    users = (ArrayList<User>) readStream.readObject();
		    
		    readStream.close();
		}catch (Exception e) {
		    e.printStackTrace();
		}
		
		//read the data from messages.txt into messages arraylist
		try{
		    FileInputStream readData = new FileInputStream(messagesPath);
		    ObjectInputStream readStream = new ObjectInputStream(readData);

		    allMessages = (ArrayList<Message>) readStream.readObject();
		    
		    readStream.close();
		}catch (Exception e) {
		    e.printStackTrace();
		}
	}
	
	public static ArrayList<User> getUsers(){
		return users;
	}
	
	public static ArrayList<Message> getMessages(){
		return allMessages;
	} 
	
	public static void setUser(int i, User u) {
		users.set(i, u);
	}
	
	public static void addUser(User user) {
		users.add(user);
	}
	
	public static void addMessage(Message m) {
		allMessages.add(m);
	}
	
	public static void loadDataToDataStore(String userDataPath, String messagesPath) {
		//write users data into userData.txt
		try{
		    FileOutputStream writeData = new FileOutputStream(userDataPath);
		    ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

		    writeStream.writeObject(users);
		    writeStream.flush();
		    writeStream.close();

		}catch (IOException e) {
		    e.printStackTrace();
		}
		
		//write message data into messages.txt
		try{
		    FileOutputStream writeData = new FileOutputStream(messagesPath);
		    ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

		    writeStream.writeObject(allMessages);
		    writeStream.flush();
		    writeStream.close();

		}catch (IOException e) {
		    e.printStackTrace();
		}
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
