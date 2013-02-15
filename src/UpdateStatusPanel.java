import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import twitter4j.*;

@SuppressWarnings("serial")
public class UpdateStatusPanel extends JPanel{
	
	
	private Twitter twitter = TwitterFactory.getSingleton();
	
	private JTextArea updatePane;
	private JPanel UpdatePanel;
	@SuppressWarnings("unused")
	private Status status;
	
	public UpdateStatusPanel() throws TwitterException{
		
		UpdatePanel = new JPanel();
		UpdatePanel.setLayout(new FlowLayout());
		
		updatePane = new JTextArea("");
		updatePane.setRows(5);
		updatePane.setColumns(66);
				
		UpdatePanel.add(updatePane);

		add(UpdatePanel);
}
	public void updateStatus(){
		
		String latestStatus = updatePane.getText();
		try {
			status = twitter.updateStatus(latestStatus );
			updatePane.setText("");
		} catch (TwitterException e) {
			e.printStackTrace();
		}
		
	}
}
