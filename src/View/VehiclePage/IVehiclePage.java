package View.VehiclePage;

import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.event.ListSelectionListener;

import Model.Vehicles.Vehicle;



public interface IVehiclePage {
	// Initialize
	public void setVehicleDetails(Vehicle V);
	public void setTravelList(Vector<?> TList);
	public void setTravelSortTypes(String[] sort_types);
	
	// Listeners
	public void addOpenOwnerPageBtnListener(ActionListener openOwnerPageBtnListener);
	public void addOpenTravelPageBtnListener(ActionListener openTravelPageBtnListener);
	public void addChangeOwnerBtnListener(ActionListener changeOwnerBtnListener);
	public void addTravelListSelectionListener(ListSelectionListener travelListSelectionListener);
	public void addTravelSortTypeSelectionListener(ItemListener sortTypeSelectionListener);
	

	
	public String getVehicleID();
	public String getTravelSortType();
	public String getOwnerID();
	public String getSelectedTravelIdentifier();
	
	
	public void setTravelTextArea(String data);
	public void setOpenTravelPageBtnMode(boolean b);
	
	
	
	public void updatePanel();
}
