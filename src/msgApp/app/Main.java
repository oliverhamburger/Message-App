package msgApp.app;

import java.awt.EventQueue;

import msgApp.backend.model.User;
import msgApp.gui.ViewControler;

public class Main {
	public static void main(String[] args) {
		App.loadDataFromDataStore();
		ViewControler.showLoginView();


	}

}
