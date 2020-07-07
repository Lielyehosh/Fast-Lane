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
import DataObject.Exceptions.IllegalDataException;
import Model.IModel;
import Model.Vehicles.Vehicle;
import View.IView;
import View.VehiclePage.VehiclePage;

public class OpenVehiclePageCommand extends OpenPageCommand {
	protected Vehicle vehicle;

	public OpenVehiclePageCommand(IView view, IModel model, String vehicle_id) {
		super(view, model);
		vehicle = M.getVehicleByID(vehicle_id);
	}

	@Override
	public void execute() {
		VehiclePage Page = new VehiclePage();
		Page.setVehicleDetails(vehicle);
		M.initTravelList();
		M.searchTravelList("Vehicle ID", vehicle.getVehicleID());
		Page.setTravelList(M.getTravelList());
		Page.setTravelSortTypes(M.getTravelSortTypes());
		Page.addTravelSortTypeSelectionListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				M.sortTravelList(Page.getTravelSortType());
				Page.updatePanel();
			}
		});
		Page.setVehicleLicenseImage(M.getVehicleLicensePic(vehicle.getIdentifier()));
		Page.addOpenOwnerPageBtnListener(e -> new OpenClientPageCommand(V, M, vehicle.getOwner_ID()).execute());
		Page.addOpenTravelPageBtnListener(e -> new OpenTravelPageCommand(V, M, Page.getSelectedTravelIdentifier()).execute());
		Page.addChangeOwnerBtnListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent e) {
				String msg = "Please enter the owner ID";
				String owner_id = JOptionPane.showInputDialog((Component) e.getSource(), msg, "Change Owner",
						JOptionPane.OK_CANCEL_OPTION);
				if (owner_id != null) {
					try {
						M.updateVehicleOwner(vehicle.getIdentifier(), owner_id);
						JOptionPane.showMessageDialog(null, "The vehicle's owner has been changed", "Success",
								JOptionPane.INFORMATION_MESSAGE);
						Page.updatePanel();
					} catch (IllegalDataException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}

				}

			}
		});
		Page.addTravelListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				String travel_id = Page.getSelectedTravelIdentifier();
				DataObject travel = M.getTravelByID(travel_id);
				if (travel != null) {
					Page.setTravelTextArea(M.getDataObjectDetails(travel));
					Page.setOpenTravelPageBtnMode(true);
				} else {
					Page.setTravelTextArea("");
					Page.setOpenTravelPageBtnMode(false);
				}

			}
		});
		Page.updatePanel();
		V.setCenterPanel(Page);

	}

}
