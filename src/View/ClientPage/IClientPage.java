package View.ClientPage;

import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.event.ListSelectionListener;

import Model.Clients.Client;



/**
 * - This interface is an API of the Client page.
 * - It provides 4 types of methods:
 * 		1. Initialize methods - setters of the page data
 * 		2. Add listeners methods - adders to the page components
 * 		3. Getters methods - getters of the current state of the page
 * 		4. Update methods - methods that change the page state (updates)
 *
 */
public interface IClientPage {
	
	// Initialize methods
	public void setClientFields(Client C);
	public void setClientVehicles(Vector<?> VList);
	public void setClientTravels(Vector<?> TList);
	public void setVehicleSortTypes(String[] vehicleSortTypes);
	public void setTravelSortTypes(String[] travelSortTypes);
	public void setLicensePic(ImageIcon image);
	public void setContractPic(ImageIcon contract_image);
	
	// Events listeners methods
	public void addSelectionVehicleListener(ListSelectionListener selectionVehicleListener);
	public void addSelectionTravelListener(ListSelectionListener selectionTravelListener);
	public void addEditBtnListener(ActionListener editBtnListener);
	public void addSaveBtnListener(ActionListener saveBtnListener);
	public void addBackBtnListener(ActionListener backBtnListener);
	public void addAddNewVehicleBtnListener(ActionListener addVehicleBtnListener);
	public void addRemoveVehicleBtnListener(ActionListener removeVehicleBtnListener);
	public void addOpenVehiclePageBtnListener(ActionListener openVehiclePageListener);
	public void addOpenTravelPageBtnListener(ActionListener openTravelPageListener);
	public void addVehicleSortListListener(ItemListener selectedVehicleSortType);
	public void addTravelSortListListener(ItemListener selectedTravelSortType);
	
	// Getters methods
	public String getTravelSortType();
	public String getVehicleSortType();
	public String getClientID();
	public String getSelectedVehicleIdentifier();
	public String getSelectedTravelIdentifier();
	public String getEditDetailsInput();
	
	// Update methods (change state)
	public void displayIllegalInputMsg(String field, String message);
	public void clearIllegalMsgs();
	public void setEditMode(boolean mode);
	public void setVehicleTextArea(String data);
	public void setTravelTextArea(String data);
	public void setBackBtnEnableMode(boolean mode);
	public void setAddNewVehicleBtnMode(boolean mode);
	public void setOpenVehiclePageBtnMode(boolean mode);
	public void setOpenTravelPageBtnMode(boolean mode);
	public void setSaveBtnEnableMode(boolean mode);
	public void setEditBtnEnableMode(boolean mode);
	public void updatePanel();
}
