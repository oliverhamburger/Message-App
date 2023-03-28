package msgApp.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import msgApp.app.App;
import msgApp.backend.model.Message;
import msgApp.backend.model.User;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class CreateMessageView extends JFrame {

	private JPanel contentPane;

	public CreateMessageView(User user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea messageBody = new JTextArea();
		messageBody.setBounds(10, 11, 414, 205);
		contentPane.add(messageBody);
		
		JButton addMessage = new JButton("Post Message");
		addMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Create the message
				Message m = new Message(messageBody.getText(), user.getUserName());
				
				//add the message to the current user
				user.addMessage(m);
				
				//add the message to the message list in the data store
				App.addMessageToAllMessagesList(m);
				
				//update the user with the newly added message to the data store
				ArrayList<User> users = App.getUsers();
				User curr;
				for(int i = 0; i < users.size(); i++) {
					curr = users.get(i);
					if(curr.equals(user)) {
						App.setUser(i, curr);
						
						//load the data to the datastore
						App.loadDataToDataStore("src/msgApp/data/userData.txt", "src/msgApp/data/messages.txt");
						
						ViewControler.showAccountLoggedInView(user);
					}
				}
			}
		});
		addMessage.setBounds(10, 227, 155, 23);
		contentPane.add(addMessage);
	}

}
