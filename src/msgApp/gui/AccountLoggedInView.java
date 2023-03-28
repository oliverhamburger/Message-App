package msgApp.gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import msgApp.app.App;
import msgApp.backend.model.User;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;
import javax.swing.JProgressBar;

public class AccountLoggedInView extends JFrame {

	private JPanel contentPane;
	
	private User currUser;
	
	private JTextArea feed;
	
	public AccountLoggedInView(User user) {
		//sets the current user
		this.currUser = user;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel welcomeLabel = new JLabel("");
		welcomeLabel.setBounds(10, 11, 414, 14);
		contentPane.add(welcomeLabel);
		welcomeLabel.setText("Welcome back " + currUser.getUserName());
		JButton logoutButton = new JButton("Logout");
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*loop through the users in App.java and find the current user that is logged in and log them out
				 * This should be refactored into a single function call from App.java that passes in the user object
				 */
				ArrayList<User> users = App.getUsers();
				User curr;
				for(int i = 0; i < users.size(); i++) {
					curr = users.get(i);
					if(curr.equals(currUser)) {
						curr.setLoggedin(false);
						App.setUser(i, curr);
						ViewControler.showLoginView();
					}
				}
				//load the data to the datastore
				App.loadDataToDataStore("src/msgApp/data/userData.txt", "src/msgApp/data/messages.txt");
			}
		});
		logoutButton.setBounds(10, 227, 89, 23);
		contentPane.add(logoutButton);
		
		feed = new JTextArea();
		feed.setEditable(false);
		feed.setBounds(10, 36, 414, 171);
		contentPane.add(feed);
		
		feed.setText(App.getFeed());
		
		JScrollPane scrollPane = new JScrollPane(feed);
		scrollPane.setBounds(10, 36, 414, 171);
		contentPane.add(scrollPane);
		
		JButton createMessage = new JButton("Add Message");
		createMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//reset feed text so the feed is not duplicated
				feed.setText("");				
				ViewControler.showCreateMessageView(user);
			}
		});
		createMessage.setBounds(275, 227, 137, 23);
		contentPane.add(createMessage);
		
		JButton refresh = new JButton("Refresh");
		refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//load the data to the datastore
				App.loadDataFromDataStore("src/msgApp/data/userData.txt", "src/msgApp/data/messages.txt");
				feed.setText(App.getFeed());
			}
		});
		refresh.setBounds(144, 227, 89, 23);
		contentPane.add(refresh);
	}
}
