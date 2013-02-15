import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.Twitter;

@SuppressWarnings("serial")
public class TimeLinePanel extends JPanel{

		private JPanel timeLinePanel;
		private JTextArea timeLineArea;
		private Twitter twitter = TwitterFactory.getSingleton();
		private List<Status> statuses;
		public TimeLinePanel() throws TwitterException {

		
		
		timeLinePanel = new JPanel();
		timeLineArea = new JTextArea();
		
		//friendsScrollPane = new JScrollPane(timeLineArea);
		timeLinePanel.add(timeLineArea);

		statuses = twitter.getHomeTimeline();
	    System.out.println("Showing home timeline.");
	    
	    for (Status status : statuses) {
	       timeLineArea.append(status.getUser().getName() + ":" + status.getText());
	       timeLineArea.append("\n\n");
	    }
	 
	    add(timeLineArea);
	}
	
	public void updateTimeLinePanel() throws TwitterException{
		
		timeLineArea.setText("");
		
		statuses.clear();
		
		statuses = twitter.getHomeTimeline();
	    
	    for (Status status : statuses) {
	       timeLineArea.append(status.getUser().getName() + ":" + status.getText());
	       timeLineArea.append("\n\n");
	    }
	}
}
