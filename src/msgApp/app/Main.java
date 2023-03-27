package msgApp.app;

import java.awt.EventQueue;

import msgApp.backend.model.User;
import msgApp.gui.ViewControler;

public class Main {
	public static void main(String[] args) {
		App.addUser(new User("macDonald", "donny"));
		App.addUser(new User("oliverHamburger","oliver"));
		App.addUser(new User("test", "test"));
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewControler.showLoginView();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
