package msgApp.backend.model;

import java.util.ArrayList;

public class User {
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
	
	
	public void setLoggedin(boolean inOrOut) {
		this.loggedIn = inOrOut;
	}
	
	@Override
	public boolean equals(Object o) {
		User other = (User) o;
		if((this.userName == other.userName) && (this.password == other.password)) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Username: " + this.userName + "\nLoggedIn: " + Boolean.toString(this.loggedIn);
	}

}
