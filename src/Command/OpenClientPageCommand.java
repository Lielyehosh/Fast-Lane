package Command;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import DataObject.DataObject;
import DataObject.Exceptions.IllegalClientDataException;
import DataObject.Exceptions.IllegalDataException;
import Model.IModel;
import Model.Clients.Client;
import View.ClientPage.ClientPage;
import View.IView;

public class OpenClientPageCommand extends OpenPageCommand {
	protected Client client;

	public OpenClientPageCommand(IView view, IModel model, String client_id) {
		super(view, model);
		client = M.getClientByID(client_id);
	}

	@Override
	public void execute() {
		ClientPage Page = new ClientPage();
		// Fill the client's data
		Page.setClientFields(client);
		M.initVehicleList();
		M.searchVehicleList("Owner ID", client.getClientID());
		Page.setVehicleSortTypes(M.getVehicleSortTypes());
		Page.setClientVehicles(M.getVehicleList());
		M.initTravelList();
		M.searchTravelList("Driver ID", client.getClientID());
		Page.setTravelSortTypes(M.getTravelSortTypes());
		M.initTravelList();
		M.searchTravelList("Driver ID", client.getClientID());
		Page.setClientTravels(M.getTravelList());
		Page.setEditMode(false);
		Page.setLicensePic(M.getClientLicensePic(client.getClientID()));
		Page.setContractPic(M.getClientContract(client.getClientID()));
		Page.updatePanel();

		Page.addAddNewVehicleBtnListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String msg = "Please enter the vehicle ID";
				String vehicle_id = JOptionPane.showInputDialog((Component) e.getSource(),msg , "Add Vehicle", JOptionPane.OK_CANCEL_OPTION);
				if (vehicle_id != null) {
					try {
						M.addNewVehicle(vehicle_id, client.getIdentifier());
						JOptionPane.showMessageDialog(null, "The vehicle was added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
						Page.updatePanel();
					} catch (IllegalDataException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					} 
				}
			}
		});
		Page.addOpenTravelPageBtnListener(
				e -> new OpenTravelPageCommand(V, M, Page.getSelectedTravelIdentifier()).execute());
		Page.addOpenVehiclePageBtnListener(
				e -> new OpenVehiclePageCommand(V, M, Page.getSelectedVehicleIdentifier()).execute());
		Page.addVehicleSortListListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				M.sortVehicleList(Page.getVehicleSortType());
				Page.updatePanel();
			}
		});
		Page.addTravelSortListListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				M.sortTravelList(Page.getTravelSortType());
				Page.updatePanel();
			}
		});
		Page.addSelectionVehicleListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				DataObject vehicle = M.getVehicleByID(Page.getSelectedVehicleIdentifier());
				if (vehicle != null) {
					Page.setVehicleTextArea(M.getDataObjectDetails(vehicle));
					Page.setOpenVehiclePageBtnMode(true);
				} else {
					Page.setVehicleTextArea("");
					Page.setOpenVehiclePageBtnMode(false);
				}
			}
		});
		Page.addSelectionTravelListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				DataObject travel = M.getVehicleByID(Page.getSelectedTravelIdentifier());
				if (travel != null) {
					Page.setTravelTextArea(M.getDataObjectDetails(travel));
					Page.setOpenTravelPageBtnMode(true);
				} else {
					Page.setTravelTextArea("");
					Page.setOpenTravelPageBtnMode(false);
				}

			}
		});
		Page.addEditBtnListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Page.setEditMode(true);
			}
		});
		Page.addBackBtnListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Page.setClientFields(client);
				Page.setEditMode(false);
				Page.updatePanel();
			}
		});
		Page.addSaveBtnListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String client_details = Page.getEditDetailsInput();
				try {
					M.updateClient(client.getClientID(), client_details);
					Page.setEditMode(false);
					Page.clearIllegalMsgs();
					Page.updatePanel();
				} catch (IllegalClientDataException ex) {
					Page.clearIllegalMsgs();
					Page.displayIllegalInputMsg(ex.getField(), ex.getMessage());
				} catch (IllegalDataException exep) {
					exep.printStackTrace();
				}
			}
		});
		Page.addRemoveVehicleBtnListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "The request was denied due to lack of permissions", "No premission warning", JOptionPane.WARNING_MESSAGE);
			}
		});

		V.setCenterPanel(Page);
	}

}
