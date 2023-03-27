package msgApp.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import msgApp.app.App;
import msgApp.backend.model.User;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateAccountView extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField password;	

	/**
	 * Create the frame.
	 */
	public CreateAccountView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel createAccLabel = new JLabel("Create New Account");
		createAccLabel.setBounds(146, 11, 147, 14);
		contentPane.add(createAccLabel);
		
		username = new JTextField();
		username.setBounds(230, 44, 86, 20);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setBounds(230, 97, 86, 20);
		contentPane.add(password);
		password.setColumns(10);
		
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setBounds(97, 47, 101, 14);
		contentPane.add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(97, 97, 86, 14);
		contentPane.add(passwordLabel);
		
		JButton createAccount = new JButton("Create Account");
		createAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User newUser = new User(username.getText(), password.getText());
				App.addUser(newUser);
				ViewControler.showLoginView();
			}
		});
		createAccount.setBounds(112, 206, 181, 23);
		contentPane.add(createAccount);
	}

}
