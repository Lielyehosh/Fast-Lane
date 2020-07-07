package View.ClientPanels;


import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.SpringLayout;

import View.Components.DataObjectField;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class ClientFieldsPanel extends JPanel implements IClientFieldsPanel {
	private DataObjectField f_id;
	private DataObjectField f_first_name;
	private DataObjectField f_last_name;
	private DataObjectField f_city;
	private DataObjectField f_email;
	private JButton btnBack;
	private JButton btnEdit;
	private JButton btnSave;

	/**
	 * Create the panel.
	 */
	public ClientFieldsPanel() {
		f_id = new DataObjectField();
		f_id.setLabel("ID number:");
		f_first_name = new DataObjectField();
		f_first_name.setLabel("First name:");
		f_last_name = new DataObjectField();
		f_last_name.setLabel("Last name:");
		f_city = new DataObjectField();
		f_city.setLabel("City:");
		f_email = new DataObjectField();
		f_email.setLabel("Email:");
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.SOUTH, f_city, 75, SpringLayout.SOUTH, f_email);
		springLayout.putConstraint(SpringLayout.SOUTH, f_email, 75, SpringLayout.SOUTH, f_last_name);
		springLayout.putConstraint(SpringLayout.SOUTH, f_last_name, 75, SpringLayout.SOUTH, f_first_name);
		springLayout.putConstraint(SpringLayout.SOUTH, f_first_name, 75, SpringLayout.SOUTH, f_id);
		springLayout.putConstraint(SpringLayout.NORTH, f_last_name, 0, SpringLayout.SOUTH, f_first_name);
		springLayout.putConstraint(SpringLayout.NORTH, f_email, 0, SpringLayout.SOUTH, f_last_name);
		springLayout.putConstraint(SpringLayout.NORTH, f_city, 0, SpringLayout.SOUTH, f_email);
		springLayout.putConstraint(SpringLayout.EAST, f_city, 0, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.EAST, f_email, 0, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.EAST, f_last_name, 0, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.EAST, f_id, 0, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.NORTH, f_first_name, 0, SpringLayout.SOUTH, f_id);
		springLayout.putConstraint(SpringLayout.EAST, f_first_name, 0, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, f_id, 75, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, f_city, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.WEST, f_email, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.WEST, f_last_name, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.WEST, f_first_name, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.NORTH, f_id, 0, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, f_id, 0, SpringLayout.WEST, this);
		setLayout(springLayout);
		add(f_id);
		add(f_first_name);
		add(f_last_name);
		add(f_email);
		add(f_city);

		btnSave = new JButton("Save");
		springLayout.putConstraint(SpringLayout.NORTH, btnSave, 10, SpringLayout.SOUTH, f_city);
		springLayout.putConstraint(SpringLayout.WEST, btnSave, -80, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, btnSave, 40, SpringLayout.SOUTH, f_city);
		springLayout.putConstraint(SpringLayout.EAST, btnSave, -5, SpringLayout.EAST, this);
		add(btnSave);

		btnBack = new JButton("Back");
		springLayout.putConstraint(SpringLayout.NORTH, btnBack, 10, SpringLayout.SOUTH, f_city);
		springLayout.putConstraint(SpringLayout.WEST, btnBack, -80, SpringLayout.WEST, btnSave);
		springLayout.putConstraint(SpringLayout.SOUTH, btnBack, 40, SpringLayout.SOUTH, f_city);
		springLayout.putConstraint(SpringLayout.EAST, btnBack, -5, SpringLayout.WEST, btnSave);
		add(btnBack);

		btnEdit = new JButton("Edit");
		springLayout.putConstraint(SpringLayout.NORTH, btnEdit, 10, SpringLayout.SOUTH, f_city);
		springLayout.putConstraint(SpringLayout.WEST, btnEdit, 5, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, btnEdit, 40, SpringLayout.SOUTH, f_city);
		springLayout.putConstraint(SpringLayout.EAST, btnEdit, 100, SpringLayout.WEST, this);
		add(btnEdit);
	}

	// getters and setters

	public void setFieldID(String data) {
		f_id.setTextField(data);
	}

	public void setFieldFirstName(String data) {
		f_first_name.setTextField(data);
	}

	public void setFieldLastName(String data) {
		f_last_name.setTextField(data);
	}

	public void setFieldCity(String data) {
		f_city.setTextField(data);
	}

	public void setFieldEmail(String data) {
		f_email.setTextField(data);
	}

	public String getFieldID() {
		return f_id.getTextField();
	}

	public String getFieldFirstName() {
		return f_first_name.getTextField();
	}

	public String getFieldLastName() {
		return f_last_name.getTextField();
	}

	public String getFieldCity() {
		return f_city.getTextField();
	}

	public String getFieldEmail() {
		return f_email.getTextField();
	}

	// --------------------------------------------------------------------------

	public String getInputData() {
		return getFieldID() + "," + getFieldFirstName() + "," + getFieldLastName() + "," + getFieldCity() + ","
				+ getFieldEmail();
	}

	public void setFieldsData(String data) {
		setFieldsData(data.split(","));
	}

	public void setFieldsData(String[] fields_data) {
		setFieldID(fields_data[0]);
		setFieldFirstName(fields_data[1]);
		setFieldLastName(fields_data[2]);
		setFieldCity(fields_data[3]);
		setFieldEmail(fields_data[4]);
	}

	public void displayFieldErrorMsg(String field, String msg) {
		switch (field) {
		case "ID":
			f_id.displayErrorMsg(msg);
			break;
		case "FirstName":
			f_first_name.displayErrorMsg(msg);
			break;
		case "LastName":
			f_last_name.displayErrorMsg(msg);
			break;
		case "City":
			f_city.displayErrorMsg(msg);
			break;
		case "Email":
			f_email.displayErrorMsg(msg);
			break;
		default:
			break;
		}
	}

	public void setTextFieldEditableMode(String field, boolean mode) {
		switch (field) {
		case "ID":
			f_id.setTextFieldEditableMode(mode);
			break;
		case "FirstName":
			f_first_name.setTextFieldEditableMode(mode);
			break;
		case "LastName":
			f_last_name.setTextFieldEditableMode(mode);
			break;
		case "City":
			f_city.setTextFieldEditableMode(mode);
			break;
		case "Email":
			f_email.setTextFieldEditableMode(mode);
			break;
		default:
			break;
		}
	}

	public void setAllTextFieldsEditableMode(boolean mode) {
		f_id.setTextFieldEditableMode(mode);
		f_first_name.setTextFieldEditableMode(mode);
		f_last_name.setTextFieldEditableMode(mode);
		f_city.setTextFieldEditableMode(mode);
		f_email.setTextFieldEditableMode(mode);
	}

	public void clearAllErrorMsgs() {
		f_id.clearErrorMsg();

		f_first_name.clearErrorMsg();

		f_last_name.clearErrorMsg();

		f_city.clearErrorMsg();

		f_email.clearErrorMsg();
	}

	public void clearErrorMsg(String field) {
		switch (field) {
		case "ID":
			f_id.clearErrorMsg();
			break;
		case "FirstName":
			f_first_name.clearErrorMsg();
			break;
		case "LastName":
			f_last_name.clearErrorMsg();
			break;
		case "City":
			f_city.clearErrorMsg();
			break;
		case "Email":
			f_email.clearErrorMsg();
			break;
		default:
			break;
		}
	}

	public void addEditBtnListener(ActionListener editBtnListener) {
		btnEdit.addActionListener(editBtnListener);
	}

	public void addSaveBtnListener(ActionListener saveBtnListener) {
		btnSave.addActionListener(saveBtnListener);
	}

	public void addBackBtnListener(ActionListener backBtnListener) {
		btnBack.addActionListener(backBtnListener);
	}


	public void setBackBtnEnableMode(boolean mode) {
		btnBack.setEnabled(mode);
	}

	public void setSaveBtnEnableMode(boolean mode) {
		btnSave.setEnabled(mode);
	}

	public void setEditBtnEnableMode(boolean mode) {
		btnEdit.setEnabled(mode);
	}

	public void updatePanel() {
		updateUI();
	}
}
