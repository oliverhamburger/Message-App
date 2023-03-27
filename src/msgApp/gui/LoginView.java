package msgApp.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import msgApp.app.App;
import msgApp.backend.model.User;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class LoginView extends JFrame {

	private JPanel contentPane;
	private JTextField password;
	private JTextField userName;

	/**
	 * Create the frame.
	 */
	public LoginView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		password = new JTextField();
		password.setBounds(177, 102, 167, 20);
		contentPane.add(password);
		password.setColumns(10);
		
		JLabel passwordLabel = new JLabel("password");
		passwordLabel.setBounds(54, 105, 89, 14);
		contentPane.add(passwordLabel);
		
		JLabel usernameLabel = new JLabel("User Name");
		usernameLabel.setBounds(54, 48, 104, 14);
		contentPane.add(usernameLabel);
		
		userName = new JTextField();
		userName.setBounds(177, 45, 167, 20);
		contentPane.add(userName);
		userName.setColumns(10);
		
		JLabel loginFeedback = new JLabel("");
		loginFeedback.setBounds(54, 158, 327, 14);
		contentPane.add(loginFeedback);
		
		JButton LoginButton = new JButton("Login");
		LoginButton.setBounds(78, 212, 104, 23);
		contentPane.add(LoginButton);
		LoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean loginSuccessfull = false;
				
				/*loop through the users in App.java and see if the username an password combo given by the user matches one in the database
				 * This should be refactored into a single function call from App.java that passes in username and password combo
				 */
				ArrayList<User> users = App.getUsers();
				User curr;
				for(int i = 0; i < users.size(); i++) {
					curr = users.get(i);
					if((curr.getUserName().equals(userName.getText())) && (curr.getPassword().equals(password.getText()))) {
						loginSuccessfull = true;
						curr.setLoggedin(true);
						App.setUser(i, curr);
						//Loads user login page with their user data displayed
						ViewControler.showAccountLoggedInView(curr);
						
						//For debuging
						App.displayData();
					}
				}
				if(loginSuccessfull == false) {
					//username and password is incorrect, ask them to try again
					loginFeedback.setText("Username and password combo is incorrect, try again");
				}else{
					//username and password was correct, reset the label for the next sign in when the user is logged out
					loginFeedback.setText("");
				}
				//For debuging
				App.displayData();
			}
		});
		
		JButton CreateAccountButton = new JButton("Create Account");
		CreateAccountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginFeedback.setText("");
				ViewControler.showCreateAccountView();
			}
		});
		
		CreateAccountButton.setBounds(242, 212, 135, 23);
		contentPane.add(CreateAccountButton);
	
	}
}
