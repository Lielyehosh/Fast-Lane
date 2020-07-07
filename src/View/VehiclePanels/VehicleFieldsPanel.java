package View.VehiclePanels;



import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.SpringLayout;

import View.Components.DataObjectField;

@SuppressWarnings("serial")
public class VehicleFieldsPanel extends JPanel implements IVehicleFieldsPanel {
	DataObjectField f_vehicle_id;
	DataObjectField f_owner_id;
	DataObjectField f_type;
	DataObjectField f_company;
	DataObjectField f_model;
	private JPanel panel;

	/**
	 * Create the panel.
	 */
	public VehicleFieldsPanel() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);

		panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -60, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, panel, 0, SpringLayout.EAST, this);
		add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		f_vehicle_id = new DataObjectField();
		panel.add(f_vehicle_id);
		f_vehicle_id.setLabel("Vehicle ID:");
		f_owner_id = new DataObjectField();
		panel.add(f_owner_id);
		f_owner_id.setLabel("Owner ID:");
		f_company = new DataObjectField();
		panel.add(f_company);
		f_company.setLabel("Company:");
		f_model = new DataObjectField();
		panel.add(f_model);
		f_model.setLabel("Model:");
		f_type = new DataObjectField();
		panel.add(f_type);
		f_type.setLabel("Type:");
	}

	public String getInputData() {
		return f_vehicle_id.getTextField() + "," + f_owner_id.getTextField() + "," + f_type.getTextField() + ","
				+ f_company.getTextField() + "," + f_model.getTextField();
	}

	public void setFieldsData(String data) {
		setFieldsData(data.split(","));
	}

	public void setFieldsData(String[] fields_data) {
		f_vehicle_id.setTextField(fields_data[0]);
		f_owner_id.setTextField(fields_data[1]);
		f_type.setTextField(fields_data[2]);
		f_company.setTextField(fields_data[3]);
		f_model.setTextField(fields_data[4]);
	}

	public void displayFieldErrorMsg(String field, String msg) {
		// field - {"Vehicle ID", "Owner ID", "Type", "Company","Model"}
		switch (field) {
		case "Vehicle ID":
			f_vehicle_id.displayErrorMsg(msg);
			break;
		case "Owner ID":
			f_owner_id.displayErrorMsg(msg);
			break;
		case "Company":
			f_company.displayErrorMsg(msg);
			break;
		case "Type":
			f_type.displayErrorMsg(msg);
			break;
		case "Model":
			f_model.displayErrorMsg(msg);
			break;
		default:
			break;
		}
	}

	public void setFieldTextAreaEditableMode(String field, boolean mode) {
		// field - {"Vehicle ID", "Owner ID", "Type", "Company","Model"}
		switch (field) {
		case "Vehicle ID":
			f_vehicle_id.setTextFieldEditableMode(mode);
			break;
		case "Owner ID":
			f_owner_id.setTextFieldEditableMode(mode);
			break;
		case "Company":
			f_company.setTextFieldEditableMode(mode);
			break;
		case "Type":
			f_type.setTextFieldEditableMode(mode);
			break;
		case "Model":
			f_model.setTextFieldEditableMode(mode);
			break;
		default:
			break;
		}
	}

	public void setAllFieldTextAreaEditableMode(boolean mode) {
		f_vehicle_id.setTextFieldEditableMode(mode);
		f_owner_id.setTextFieldEditableMode(mode);
		f_company.setTextFieldEditableMode(mode);
		;
		f_type.setTextFieldEditableMode(mode);
		f_model.setTextFieldEditableMode(mode);
	}

	public void clearErrorMsg(String field) {
		switch (field) {
		case "Vehicle ID":
			f_vehicle_id.clearErrorMsg();
			break;
		case "Owner ID":
			f_owner_id.clearErrorMsg();
			break;
		case "Company":
			f_company.clearErrorMsg();
			break;
		case "Type":
			f_type.clearErrorMsg();
			break;
		case "Model":
			f_model.clearErrorMsg();
		}
	}

	public void clearAllErrorMsgs() {
		f_vehicle_id.clearErrorMsg();
		f_owner_id.clearErrorMsg();
		f_company.clearErrorMsg();
		f_type.clearErrorMsg();
		f_model.clearErrorMsg();
	}

	public String getIdentifier() {
		return f_vehicle_id.getTextField();
	}

	public String getOwnerID() {
		return f_owner_id.getTextField();
	}

	public void updatePanel() {
		updateUI();
	}


	public void setOwnerIDFieldTextArea(String owner_id) {
		f_owner_id.setTextField(owner_id);
	}

}
