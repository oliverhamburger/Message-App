package msgApp.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ViewControler extends JFrame {

	private JPanel contentPane;
	
	static private LoginView loginView = new LoginView();
	static private CreateAccount createAccountView = new CreateAccount();
	
	public static void showCreateAccountView() {
		createAccountView.setVisible(true);
		loginView.dispose();
	}
	
	public static void showLoginView() {
		loginView.setVisible(true);
		createAccountView.dispose();
	}

}
