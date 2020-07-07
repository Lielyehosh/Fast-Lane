package View.ClientPanels;

import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.event.ListSelectionListener;


public interface IClientVehiclesPanel {

	public void setClientVehicles(Vector<?> VList);
	public void setVehicleSortTypes(String[] vehicleSortTypes);
	
	// Listeners
	public void addSelectionVehicleListener(ListSelectionListener selectionVehicleListener);
	public void addAddNewVehicleBtnListener(ActionListener addVehicleBtnListener);
	public void addRemoveVehicleBtnListener(ActionListener addVehicleBtnListener);
	public void addOpenVehiclePageBtnListener(ActionListener openVehiclePageListener);
	public void addVehicleSortListListener(ItemListener selectedVehicleSortType);

	public void setVehicleTextArea(String data);

	public String getVehicleSortType();
	public String getSelectedVehicleIdentifier();

	public void setAddNewVehicleBtnMode(boolean mode);
	public void setRemoveVehicleBtnMode(boolean mode);
	public void setOpenVehiclePageBtnMode(boolean mode);
	public void setListSelectionMode(boolean mode);
	
	public void updatePanel();
	
}
