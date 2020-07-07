package View.NewClientPage;

import java.awt.event.ActionListener;

public interface INewClientPage {
	
	// Add listeners methods
	public void addSaveBtnListener(ActionListener saveBtnListener);
	public void addBackBtnListener(ActionListener backBtnListener);

	// Update methods (change state)
	public void setSaveBtnEnableMode(boolean mode);
	public void setFieldTextAreaEditableMode(String field,boolean mode);
	public void displayIllegalInputMsg(String field, String message);
	public void clearIllegalMsgs();
	public void updatePanel();

	// Getters methods
	public String getInputDetails();
	
}
