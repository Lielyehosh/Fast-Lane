package View.NewClientPage;

import javax.swing.JPanel;

import View.ClientPanels.ClientFieldsPanel;



import java.awt.BorderLayout;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class NewClientPage extends JPanel implements INewClientPage {
	private ClientFieldsPanel fields_panel;
	/**
	 * Create the panel.
	 */
	public NewClientPage() {
		setLayout(new BorderLayout(0, 0));
		fields_panel = new ClientFieldsPanel();
		fields_panel.setAllTextFieldsEditableMode(true);
		fields_panel.setEditBtnEnableMode(false);
		add(fields_panel);
	}
	
	public String getInputDetails() {
		return fields_panel.getInputData();
	}

	public void setSaveBtnEnableMode(boolean mode) {
		fields_panel.setSaveBtnEnableMode(mode);
	}

	public void setFieldTextAreaEditableMode(String field, boolean mode) {
		fields_panel.setTextFieldEditableMode(field, mode);
	}

	public void addSaveBtnListener(ActionListener saveBtnListener) {
		fields_panel.addSaveBtnListener(saveBtnListener);
	}

	public void addBackBtnListener(ActionListener backBtnListener) {
		fields_panel.addBackBtnListener(backBtnListener);
	}
	
	public void displayIllegalInputMsg(String field, String message) {
		fields_panel.displayFieldErrorMsg(field, message);
	}
	
	public void clearIllegalMsgs() {
		fields_panel.clearAllErrorMsgs();
	}
	
	public void updatePanel() {
		fields_panel.updatePanel();
	}

}
