package View.MainPage;

import java.awt.event.ActionListener;

public interface IMainPage {
	public void setTitle(String title);
	
	public void addClientListBtnListener(ActionListener clientListBtnListener);
	public void addVehicleListBtnListener(ActionListener vehicleListBtnListener);
	public void addTravelListBtnListener(ActionListener travelListBtnListener);
	public void addCreateNewClientBtnListener(ActionListener createNewClientBtnListener);
	
	public void updatePanel();
}
