import javax.swing.JPanel;

import twitter4j.Location;
import twitter4j.ResponseList;
import twitter4j.Trend;
import twitter4j.Trends;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;


public class TrendsList extends JPanel {

	private Twitter twitter = new TwitterFactory().getSingleton();
	private ResponseList<Trends> dailyTrends;
	
	public TrendsList(){
		
		   try {

			               twitter = new TwitterFactory().getInstance();

			               Trends trends = twitter.getPlaceTrends(2450022);

			               System.out.println("Showing trends");

			               

			                   System.out.println(" " + trends.getTrends() + "\n");

			               

			               System.out.println("done.");

			               System.exit(0);

			           } catch (TwitterException te) {

			               te.printStackTrace();

			               System.out.println("Failed to get trends: " + te.getMessage());

			               System.exit(-1);
			           }

 
		
		
	}
	
}
