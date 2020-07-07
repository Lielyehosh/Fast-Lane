package View.ClientPanels;

import java.awt.event.ActionListener;


public interface IClientFieldsPanel {
	// Initializing methods
	public void setFieldsData(String data);
	public void setFieldsData(String[] fields_data);
	public void displayFieldErrorMsg(String field, String msg);

	// Events listeners methods
	public void addEditBtnListener(ActionListener editBtnListener);
	public void addSaveBtnListener(ActionListener saveBtnListener);
	public void addBackBtnListener(ActionListener backBtnListener);

	// Changing state methods
	public void setTextFieldEditableMode(String field, boolean mode);
	public void setAllTextFieldsEditableMode(boolean mode);
	public void setBackBtnEnableMode(boolean mode);
	public void setSaveBtnEnableMode(boolean mode);
	public void setEditBtnEnableMode(boolean mode);
	
	// Getters methods
	public String getInputData();

	// Updating Page methods
	public void clearAllErrorMsgs();
	public void clearErrorMsg(String field);
	public void updatePanel();
}
