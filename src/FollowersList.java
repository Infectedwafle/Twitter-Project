import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;


public class FollowersList extends JPanel {

	private JTextArea FollowersArea;
	private Twitter twitter = TwitterFactory.getSingleton();
	private List<User> friends;
	
	public FollowersList() throws TwitterException{
		new JPanel();
		FollowersArea = new JTextArea();
		
		System.out.println("test\n\n");
		
		friends = twitter.getFollowersList(1155288308, -1);
		
		System.out.println(friends.size());
		
		for(User user : friends){
			//friends2.add(user.getName());
			FollowersArea.append(user.getName() + "\n");
		}
		
		//FollowersPanel.add(FollowersArea);
		
		add(FollowersArea);
	}
}

