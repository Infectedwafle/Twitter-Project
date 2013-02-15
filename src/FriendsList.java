import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;


@SuppressWarnings("serial")
public class FriendsList extends JPanel{

	private JTextArea FriendsArea;
	private Twitter twitter = TwitterFactory.getSingleton();
	private List<User> friends;
	
	public FriendsList() throws TwitterException{
		
		new JPanel();
		FriendsArea = new JTextArea();
		
		System.out.println("test\n\n");
		
		friends = twitter.getFriendsList(1155288308, -1);
		
		System.out.println(friends.size());
		
		for(User user : friends){
			//friends2.add(user.getName());
			FriendsArea.append(user.getName() + "\n");
		}
		
		//FollowersPanel.add(FollowersArea);
		
		add(FriendsArea);
	}

}
