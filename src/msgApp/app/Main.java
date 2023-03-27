package msgApp.app;

import java.awt.EventQueue;

import msgApp.backend.model.User;
import msgApp.gui.ViewControler;

public class Main {
	public static void main(String[] args) {
		//Sample Users for debugging
		App.addUser(new User("macDonald", "donny"));
		App.addUser(new User("oliverHamburger","oliver"));
		App.addUser(new User("test", "test"));
		
		App.loadDataFromDataStore();
		ViewControler.showLoginView();


	}

}
