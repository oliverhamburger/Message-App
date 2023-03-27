package msgApp.backend.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Message implements Serializable{
	
	private static Date date;
	private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  

	private String body;
	private String dateCreated;
	private String author;
	
	public Message(String body, String author) {
		this.author = author;
		this.body = body;
		date = new Date();
		this.dateCreated = formatter.format(date);
	}
	
	public String getBody() {
		return this.body;
	}
	
	public String getDateCreated() {
		return this.dateCreated;
	}
	
	public String getAuthor() {
		return this.author;
	}

}
