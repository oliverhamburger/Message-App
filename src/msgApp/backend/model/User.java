package msgApp.backend.model;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable{
	private String userName;
	private String password;
	private boolean loggedIn;
	private ArrayList<Message> messages;
	
	public User(String userName, String password) {
		messages = new ArrayList<Message>();
		this.userName = userName;
		this.password = password;
		this.loggedIn = false;
	}
	
	public String getUserName() {
		return this.userName;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public boolean getLoggedIn() {
		return this.loggedIn;
	}
	
	public ArrayList<Message> getMessages(){
		return this.messages;
	}
	
	public void setLoggedin(boolean inOrOut) {
		this.loggedIn = inOrOut;
	}
	
	public void addMessage(Message mesage) {
		this.messages.add(mesage);
	}
	
	@Override
	public boolean equals(Object o) {
		User other = (User) o;
		if((this.userName.equals(other.userName)) && (this.password.equals(other.password))) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Username: " + this.userName + "\nLoggedIn: " + Boolean.toString(this.loggedIn) + "\nNumber of messages: " + Integer.toString(this.messages.size()) + "\n\n";
	}

}
