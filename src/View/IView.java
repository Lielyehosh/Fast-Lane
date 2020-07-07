package View;


import java.awt.event.ActionListener;

import javax.swing.JPanel;

public interface IView {
	
	// Update methods (change state)
	public void setCenterPanel(JPanel panel);
	public void displayDialogMsg(String msg);

	// Initialize methods
	public void setTitle(String title);

	// Add listeners methods
	public void addMainBtnListener(ActionListener mainBtnListener);
	
	// Getters methods
	public JPanel getCenterPanel();

	
}
