package View.ListPanel;

import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class DataObjectTextArea extends JPanel {

	private JTextPane textPane;
	private JButton btnOpenPage;

	/**
	 * Create the panel.
	 */
	public DataObjectTextArea() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JScrollPane scrollPane = new JScrollPane();
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 0, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -47, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, 0, SpringLayout.EAST, this);
		add(scrollPane);
		
		textPane = new JTextPane();
		textPane.setFont(new Font("Tahoma", Font.BOLD, 14));
		textPane.setBackground(Color.LIGHT_GRAY);
		textPane.setEditable(false);
		scrollPane.setViewportView(textPane);
		
		btnOpenPage = new JButton("Open Page");
		springLayout.putConstraint(SpringLayout.NORTH, btnOpenPage, 3, SpringLayout.SOUTH, scrollPane);
		springLayout.putConstraint(SpringLayout.WEST, btnOpenPage, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, btnOpenPage, -10, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, btnOpenPage, 0, SpringLayout.EAST, scrollPane);
		add(btnOpenPage);

	}
	
	public void setTextArea(String data) {
		textPane.setText(data);
	}
	
	public void clearTextArea() {
		textPane.setText("");;
	}
	
	public void addOpenPageBtnListener(ActionListener BtnListener) {
		btnOpenPage.addActionListener(BtnListener);
	}
	
	public void setOpenPageBtnEnabledMode(boolean mode) {
		btnOpenPage.setEnabled(mode);
	}
}
