package View.ClientPage;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.event.ListSelectionListener;

import Model.Clients.Client;
import View.ClientPanels.ClientContractPanel;
import View.ClientPanels.ClientFieldsPanel;
import View.ClientPanels.ClientVehiclesPanel;
import View.TravelPanels.TravelsPanel;

@SuppressWarnings("serial")
public class ClientPage extends JPanel implements IClientPage {

	private ClientFieldsPanel fields_panel;
	private ClientVehiclesPanel vehicles_panel;
	private TravelsPanel travels_panel;
	private JSplitPane splitPane;
	private JSplitPane splitPane_1;
	private ClientContractPanel contract_panel;
	private JPanel panel;

	/**
	 * Create the panel.
	 */
	public ClientPage() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		splitPane_1 = new JSplitPane();
		add(splitPane_1);
		fields_panel = new ClientFieldsPanel();
		splitPane_1.setLeftComponent(fields_panel);

		fields_panel.setFieldsData(" , , , , ");

		splitPane = new JSplitPane();
		add(splitPane);
		travels_panel = new TravelsPanel();
		splitPane.setLeftComponent(travels_panel);
		vehicles_panel = new ClientVehiclesPanel();

		splitPane.setRightComponent(vehicles_panel);
		splitPane.setResizeWeight(0.5);
		splitPane_1.setResizeWeight(0.5);

		panel = new JPanel();
		splitPane_1.setRightComponent(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		contract_panel = new ClientContractPanel();
		panel.add(contract_panel);

	}

	public void setLicensePic(ImageIcon license_image) {
		contract_panel.setLicenseImage(license_image);
	}

	public void setContractPic(ImageIcon contract_image) {
		contract_panel.setContractCopy(contract_image);
	}

	public void setClientFields(Client C) {
		fields_panel.setFieldsData(C.save());
	}

	public void setClientVehicles(Vector<?> VList) {
		vehicles_panel.setClientVehicles(VList);
	}

	public void setClientTravels(Vector<?> TList) {
		travels_panel.setTravels(TList);
	}

	public void setVehicleSortTypes(String[] vehicleSortTypes) {
		vehicles_panel.setVehicleSortTypes(vehicleSortTypes);
	}

	public void setTravelSortTypes(String[] travelSortTypes) {
		travels_panel.setTravelSortTypes(travelSortTypes);
	}

	public void addSelectionVehicleListener(ListSelectionListener selectionVehicleListener) {
		vehicles_panel.addSelectionVehicleListener(selectionVehicleListener);
	}

	public void addSelectionTravelListener(ListSelectionListener selectionTravelListener) {
		travels_panel.addSelectionTravelListener(selectionTravelListener);
	}

	public void addEditBtnListener(ActionListener editBtnListener) {
		fields_panel.addEditBtnListener(editBtnListener);
	}

	public void addSaveBtnListener(ActionListener saveBtnListener) {
		fields_panel.addSaveBtnListener(saveBtnListener);
	}

	public void addBackBtnListener(ActionListener backBtnListener) {
		fields_panel.addBackBtnListener(backBtnListener);
	}

	public void addAddNewVehicleBtnListener(ActionListener addVehicleBtnListener) {
		vehicles_panel.addAddNewVehicleBtnListener(addVehicleBtnListener);
	}

	public void addRemoveVehicleBtnListener(ActionListener removeVehicleBtnListener) {
		vehicles_panel.addRemoveVehicleBtnListener(removeVehicleBtnListener);
	}

	public void addOpenVehiclePageBtnListener(ActionListener openVehiclePageListener) {
		vehicles_panel.addOpenVehiclePageBtnListener(openVehiclePageListener);
	}

	public void addOpenTravelPageBtnListener(ActionListener openTravelPageListener) {
		travels_panel.addOpenTravelPageBtnListener(openTravelPageListener);
	}

	public void addVehicleSortListListener(ItemListener selectedVehicleSortType) {
		vehicles_panel.addVehicleSortListListener(selectedVehicleSortType);
	}

	public void addTravelSortListListener(ItemListener selectedTravelSortType) {
		travels_panel.addTravelSortListListener(selectedTravelSortType);
	}

	public void setVehicleTextArea(String data) {
		vehicles_panel.setVehicleTextArea(data);
	}

	public void setTravelTextArea(String data) {
		travels_panel.setTravelTextArea(data);
	}

	public String getTravelSortType() {
		return travels_panel.getTravelSortType();
	}

	public String getVehicleSortType() {
		return vehicles_panel.getVehicleSortType();
	}

	public String getClientID() {
		return fields_panel.getFieldID();
	}

	public String getSelectedVehicleIdentifier() {
		return vehicles_panel.getSelectedVehicleIdentifier();
	}

	public String getSelectedTravelIdentifier() {
		return travels_panel.getSelectedTravelIdentifier();
	}

	public String getEditDetailsInput() {
		return fields_panel.getInputData();
	}

	public void displayIllegalInputMsg(String field, String message) {
		fields_panel.displayFieldErrorMsg(field, message);
	}

	public void clearIllegalMsgs() {
		fields_panel.clearAllErrorMsgs();
	}

	public void setEditMode(boolean mode) {
		fields_panel.setBackBtnEnableMode(mode);
		fields_panel.setSaveBtnEnableMode(mode);
		fields_panel.setAllTextFieldsEditableMode(mode);
		fields_panel.setTextFieldEditableMode("ID", false);
		fields_panel.setEditBtnEnableMode(!mode);
		vehicles_panel.setAddNewVehicleBtnMode(!mode);
		vehicles_panel.setOpenVehiclePageBtnMode(!mode);
		vehicles_panel.setRemoveVehicleBtnMode(!mode);
		vehicles_panel.setListSelectionMode(!mode);
		travels_panel.setOpenTravelPageBtnMode(!mode);
		travels_panel.setListSelectionMode(!mode);
	}

	public void setBackBtnEnableMode(boolean mode) {
		fields_panel.setBackBtnEnableMode(mode);
	}

	public void setAddNewVehicleBtnMode(boolean mode) {
		vehicles_panel.setAddNewVehicleBtnMode(mode);
	}

	public void setOpenVehiclePageBtnMode(boolean mode) {
		vehicles_panel.setOpenVehiclePageBtnMode(mode);
	}

	public void setOpenTravelPageBtnMode(boolean mode) {
		travels_panel.setOpenTravelPageBtnMode(mode);
	}

	public void setSaveBtnEnableMode(boolean mode) {
		fields_panel.setSaveBtnEnableMode(mode);
	}

	public void setEditBtnEnableMode(boolean mode) {
		fields_panel.setEditBtnEnableMode(mode);
	}

	public void updatePanel() {
		vehicles_panel.updatePanel();
		travels_panel.updatePanel();
		fields_panel.updatePanel();
		setOpenTravelPageBtnMode(false);
		setOpenVehiclePageBtnMode(false);

	}
}
