import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ScrollPaneConstants;
import twitter4j.TwitterException;
import twitter4j.User;

@SuppressWarnings("serial")
public class TProject extends JPanel{
    
	private static JFrame frame;
	
	private JButton updateStatusButton;
	
	private JScrollPane scrollPane;
	private JScrollPane timeLineScrollPane;
	private JScrollPane friendScrollPane;
	private JScrollPane followerScrollPane;
	
	private UpdateStatusPanel updatePanel;
	private TimeLinePanel updateTimeLinePanel;
	
	
	private FriendsList FriendsList;
	private FollowersList FollowersList;
	
	private JTabbedPane twitterTabs;
	
	private ButtonListener listener;
	
	private JList<User> friends;
	
		
	public TProject() throws TwitterException{
	
		setTwitterGUI();
		
		frame.pack();
		frame.setVisible(true);
	}


	private void setTwitterGUI() throws TwitterException {
		frame = new JFrame("Twitter App");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		listener = new ButtonListener();		
		
		twitterTabs = new JTabbedPane();
		
		
		
		JPanel UpdatePanel = new JPanel();
		JPanel TimeLinePanel = new JPanel();
		JPanel FriendsListPanel = new JPanel();
		JPanel FollowersListPanel = new JPanel();
		
		//frame.setLayout(new BorderLayout());
		JPanel gridPanel = new JPanel();
		gridPanel.setLayout(new BorderLayout());
	
		updateTimeLinePanel = new TimeLinePanel();
		updatePanel = new UpdateStatusPanel();
		FriendsList = new FriendsList();
		FollowersList = new FollowersList();
		//TrendsList trendsList = new TrendsList();
		
		friendScrollPane = new JScrollPane(FriendsList);
		followerScrollPane = new JScrollPane(FollowersList);
		
		updateStatusButton = new JButton("Update Status");
		updateStatusButton.addActionListener(listener);	
		
		updatePanel.add(updateStatusButton);
		
		scrollPane = new JScrollPane(updatePanel);
		scrollPane.setSize(150,150);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		timeLineScrollPane = new JScrollPane(updateTimeLinePanel);
		timeLineScrollPane.setSize(150,150);
		timeLineScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		timeLineScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
				
		UpdatePanel.add(scrollPane);	
		TimeLinePanel.add(timeLineScrollPane);
		FriendsListPanel.add(friendScrollPane);
		FollowersListPanel.add(followerScrollPane);
		
		//twitterTabs.addTab ("Profile");
		twitterTabs.addTab("Tweets", UpdatePanel);
		twitterTabs.addTab("Timeline", TimeLinePanel);
		twitterTabs.addTab("Friends", FriendsListPanel);
		twitterTabs.addTab("Followers", FollowersListPanel);
				
		frame.getContentPane().add(twitterTabs);
		
	}
		

	
	public static void main(String[] args) throws TwitterException{
		new TProject();
	}
	
	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if (updateStatusButton == e.getSource()){
				updatePanel.updateStatus();
				frame.repaint();
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e2) {
				
					e2.printStackTrace();
				}
				
				try {
					updateTimeLinePanel.updateTimeLinePanel();
					frame.repaint();
				} catch (TwitterException e1) {
					e1.printStackTrace();
				}
				
				}
				frame.repaint();
			}
			
		}
}

	