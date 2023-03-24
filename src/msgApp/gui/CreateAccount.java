package msgApp.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateAccount extends JFrame {

	private JPanel contentPane;
	private JTextField email;
	private JTextField username;
	private JTextField password;	

	/**
	 * Create the frame.
	 */
	public CreateAccount() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel createAccLabel = new JLabel("Create New Account");
		createAccLabel.setBounds(146, 11, 147, 14);
		contentPane.add(createAccLabel);
		
		email = new JTextField();
		email.setBounds(230, 57, 86, 20);
		contentPane.add(email);
		email.setColumns(10);
		
		username = new JTextField();
		username.setBounds(230, 103, 86, 20);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setBounds(230, 157, 86, 20);
		contentPane.add(password);
		password.setColumns(10);
		
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setBounds(97, 106, 101, 14);
		contentPane.add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(97, 160, 86, 14);
		contentPane.add(passwordLabel);
		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setBounds(112, 60, 46, 14);
		contentPane.add(emailLabel);
		
		JButton createAccount = new JButton("Create Account");
		createAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//verify credentials, if verified load the login view to login ViewControler.showLoginView()
			}
		});
		createAccount.setBounds(112, 206, 181, 23);
		contentPane.add(createAccount);
	}

}
