package View.TravelPanels;

import javax.swing.JPanel;
import java.awt.BorderLayout;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JSplitPane;

@SuppressWarnings("serial")
public class TravelDriverPanel extends JPanel {

	private JPanel panel;
	private JButton btnOpenDriverPage;
	private JButton btnSendBills;

	/**
	 * Create the panel.
	 */
	public TravelDriverPanel() {
		setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		panel.add(splitPane, BorderLayout.SOUTH);
		
		btnOpenDriverPage = new JButton("Open Driver Page");
		splitPane.setRightComponent(btnOpenDriverPage);
		
		btnSendBills = new JButton("Send bills");
		splitPane.setLeftComponent(btnSendBills);
		

	}

	public void setDriverDetails(JPanel driver_panel) {
		panel.add(driver_panel, BorderLayout.CENTER);
	}
	
	public void addOpenDriverPageListener(ActionListener listener) {
		btnOpenDriverPage.addActionListener(listener);
	}
	
	public void addSendBillsBtnListener(ActionListener listener) {
		btnSendBills.addActionListener(listener);
	}
	
}
