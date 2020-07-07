package View.VehiclePanels;



public interface IVehicleFieldsPanel {
	public String getInputData();

	public void setFieldsData(String data) ;

	public void setFieldsData(String[] fields_data);

	public void displayFieldErrorMsg(String field, String msg);

	public void setFieldTextAreaEditableMode(String field, boolean mode) ;

	public void setAllFieldTextAreaEditableMode(boolean mode);

	public void clearErrorMsg(String field);

	public void clearAllErrorMsgs() ;

	public String getIdentifier();
	
	public String getOwnerID();
	
	public void updatePanel();
}
