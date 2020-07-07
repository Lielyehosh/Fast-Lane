package Command;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import DataObject.Exceptions.IllegalDataException;
import Model.IModel;
import Model.Travels.Travel;
import View.IView;
import View.TravelPage.TravelPage;

public class OpenTravelPageCommand extends OpenPageCommand {
	protected Travel travel;

	public OpenTravelPageCommand(IView view, IModel model, String travel_id) {
		super(view, model);
		travel = M.getTravelByID(travel_id);
	}

	@Override
	public void execute() {
		TravelPage Page = new TravelPage();
		String vehicle_id = travel.getVehicleID();
		String driver_id = travel.getDriverID();
		Page.setVehiclePanel(M.getDataObjectDetails(M.getVehicleByID(vehicle_id)), M.getVehicleLicensePic(vehicle_id));
		Page.setDriverPanel(M.getDataObjectDetails(M.getClientByID(driver_id)), M.getClientLicensePic(driver_id));
		Page.setTravelDate(travel.getDate());
		Page.addOpenDriverPageBtnListener(e -> new OpenClientPageCommand(V, M, driver_id).execute());
		Page.addOpenVehiclePageBtnListener(e -> new OpenVehiclePageCommand(V, M, vehicle_id).execute());
		Page.addSendBillsBtnListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String mail = JOptionPane.showInputDialog((Component) arg0.getSource(), "Enter a mail addres", "Bills",
						JOptionPane.OK_CANCEL_OPTION);
				if (mail != null) {
					try {
						M.sendTravelBills(mail);// 
						JOptionPane.showMessageDialog(null, "Bills have been sent", "Success", JOptionPane.INFORMATION_MESSAGE);
					} catch (IllegalDataException e) {
						JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		Page.setTravelPhoto(M.getTravelPhoto(travel.getIdentifier()));
		V.setCenterPanel(Page);

	}

}
