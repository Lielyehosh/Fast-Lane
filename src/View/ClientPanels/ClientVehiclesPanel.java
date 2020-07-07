package View.ClientPanels;

import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import javax.swing.event.ListSelectionListener;

import View.ListPanel.DataObjectList;

@SuppressWarnings("serial")
public class ClientVehiclesPanel extends JPanel implements IClientVehiclesPanel {
	private DataObjectList vehicle_list;
	private JTextArea vehicleTextArea;
	private JButton btnAddNewVehicle;
	private JButton btnRemoveVehicle;
	private JButton btnOpenVehiclePage;

	/**
	 * Create the panel.
	 */
	public ClientVehiclesPanel() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		vehicle_list = new DataObjectList();
		springLayout.putConstraint(SpringLayout.NORTH, vehicle_list, 0, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, vehicle_list, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, vehicle_list, 212, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, vehicle_list, 0, SpringLayout.EAST, this);
		add(vehicle_list);

		JScrollPane scrollPane = new JScrollPane();
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 20, SpringLayout.SOUTH, vehicle_list);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, 200, SpringLayout.SOUTH, vehicle_list);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, 300, SpringLayout.WEST, this);
		add(scrollPane);

		vehicleTextArea = new JTextArea();
		vehicleTextArea.setEditable(false);
		scrollPane.setViewportView(vehicleTextArea);

		btnAddNewVehicle = new JButton("Add new vehicle");
		springLayout.putConstraint(SpringLayout.NORTH, btnAddNewVehicle, 20, SpringLayout.SOUTH, vehicle_list);
		springLayout.putConstraint(SpringLayout.WEST, btnAddNewVehicle, 20, SpringLayout.EAST, scrollPane);
		springLayout.putConstraint(SpringLayout.SOUTH, btnAddNewVehicle, 60, SpringLayout.SOUTH, vehicle_list);
		springLayout.putConstraint(SpringLayout.EAST, btnAddNewVehicle, 180, SpringLayout.EAST, scrollPane);
		add(btnAddNewVehicle);

		btnRemoveVehicle = new JButton("Remove Vehicle");
		springLayout.putConstraint(SpringLayout.NORTH, btnRemoveVehicle, 20, SpringLayout.SOUTH, btnAddNewVehicle);
		springLayout.putConstraint(SpringLayout.WEST, btnRemoveVehicle, 20, SpringLayout.EAST, scrollPane);
		springLayout.putConstraint(SpringLayout.SOUTH, btnRemoveVehicle, 60, SpringLayout.SOUTH, btnAddNewVehicle);
		springLayout.putConstraint(SpringLayout.EAST, btnRemoveVehicle, 180, SpringLayout.EAST, scrollPane);
		add(btnRemoveVehicle);

		btnOpenVehiclePage = new JButton("Open Vehicle Page");
		springLayout.putConstraint(SpringLayout.NORTH, btnOpenVehiclePage, 20, SpringLayout.SOUTH, btnRemoveVehicle);
		springLayout.putConstraint(SpringLayout.WEST, btnOpenVehiclePage, 20, SpringLayout.EAST, scrollPane);
		springLayout.putConstraint(SpringLayout.SOUTH, btnOpenVehiclePage, 60, SpringLayout.SOUTH, btnRemoveVehicle);
		springLayout.putConstraint(SpringLayout.EAST, btnOpenVehiclePage, 180, SpringLayout.EAST, scrollPane);
		add(btnOpenVehiclePage);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void setClientVehicles(Vector VList) {
		vehicle_list.setDataObjectListData(VList);
	}

	public void setVehicleSortTypes(String[] vehicleSortTypes) {
		vehicle_list.setSortTypes(vehicleSortTypes);
	}

	public void addSelectionVehicleListener(ListSelectionListener selectionVehicleListener) {
		vehicle_list.addListSelectionListener(selectionVehicleListener);
	}

	public void addAddNewVehicleBtnListener(ActionListener addVehicleBtnListener) {
		btnAddNewVehicle.addActionListener(addVehicleBtnListener);
	}

	public void addRemoveVehicleBtnListener(ActionListener addVehicleBtnListener) {
		btnRemoveVehicle.addActionListener(addVehicleBtnListener);
	}

	public void addOpenVehiclePageBtnListener(ActionListener openVehiclePageListener) {
		btnOpenVehiclePage.addActionListener(openVehiclePageListener);
	}

	public void addVehicleSortListListener(ItemListener selectedVehicleSortType) {
		vehicle_list.addSortTypeSelectionListener(selectedVehicleSortType);
	}

	public void setVehicleTextArea(String data) {
		vehicleTextArea.setText(data);
	}

	public String getVehicleSortType() {
		return vehicle_list.getSelectedSortType();
	}

	public String getSelectedVehicleIdentifier() {
		return vehicle_list.getSelectedDataObject().getIdentifier();
	}

	public void setAddNewVehicleBtnMode(boolean mode) {
		btnAddNewVehicle.setEnabled(mode);
	}

	public void setRemoveVehicleBtnMode(boolean mode) {
		btnRemoveVehicle.setEnabled(mode);
	}

	public void setOpenVehiclePageBtnMode(boolean mode) {
		btnOpenVehiclePage.setEnabled(mode);
	}
	
	public void setListSelectionMode(boolean mode) {
		vehicle_list.setListSelectionMode(mode);
	}
	
	public void updatePanel() {
		vehicle_list.clearListSelection();
		updateUI();
	}

}
