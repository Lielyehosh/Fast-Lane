package View.Components;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class DataObjectField extends JPanel {
	private JTextField textField;
	private JLabel lblLabel;
	private JLabel lblMsg;

	/**
	 * Create the panel.
	 */
	public DataObjectField() {
		setSize(559,72);
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		lblLabel = new JLabel("Label1");
		springLayout.putConstraint(SpringLayout.NORTH, lblLabel, 0, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblLabel, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblLabel, 35, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, lblLabel, 151, SpringLayout.WEST, this);
		lblLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		add(lblLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		springLayout.putConstraint(SpringLayout.WEST, textField, 5, SpringLayout.EAST, lblLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, textField, -35, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, textField, 0, SpringLayout.EAST, this);
		textField.setEditable(false);
		springLayout.putConstraint(SpringLayout.NORTH, textField, 0, SpringLayout.NORTH, this);
		textField.setColumns(10);
		add(textField);
		
		lblMsg = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, lblMsg, 0, SpringLayout.SOUTH, lblLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, lblMsg, -5, SpringLayout.SOUTH, this);
		lblMsg.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMsg.setHorizontalAlignment(SwingConstants.CENTER);
		springLayout.putConstraint(SpringLayout.WEST, lblMsg, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, lblMsg, 0, SpringLayout.EAST, this);
		lblMsg.setForeground(Color.RED);
		add(lblMsg);
		
	}
	

	public String getTextField() {
		return textField.getText();
	}

	public String getLabel() {
		return lblLabel.getText();
	}

	public void setTextField(String textField) {
		this.textField.setText(textField);
	}

	public void setLabel(String lblLabel) {
		this.lblLabel.setText(lblLabel);
	}
	
	public void setTextFieldEditableMode(boolean mode) {
		textField.setEditable(mode);
	}

	public void paintLabel(Color c) {
		lblLabel.setForeground(c);
	}
	
	public void displayErrorMsg(String msg) {
		paintLabel(Color.RED);
		lblMsg.setText(msg);
	}
	
	public void clearErrorMsg() {
		paintLabel(Color.BLACK);
		lblMsg.setText("");
	}
	
}
