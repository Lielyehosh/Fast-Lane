package View.TravelPage;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import View.ClientPanels.ClientViewPanel;
import View.TravelPanels.TravelDriverPanel;
import View.TravelPanels.TravelVehiclePanel;
import View.TravelPanels.TravelViewPanel;
import View.VehiclePanels.VehicleViewPanel;


@SuppressWarnings("serial")
public class TravelPage extends JPanel implements ITravelPage {
	private TravelDriverPanel driver_panel;
	private TravelVehiclePanel vehicle_panel;
	private TravelViewPanel travel_details;

	/**
	 * Create the panel.
	 */
	public TravelPage() {

		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setResizeWeight(0.5);
		panel.add(splitPane);

		travel_details = new TravelViewPanel();
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		add(travel_details);

		driver_panel = new TravelDriverPanel();
		splitPane.setLeftComponent(driver_panel);

		vehicle_panel = new TravelVehiclePanel();
		splitPane.setRightComponent(vehicle_panel);
	}

	public void setTravelDate(LocalDateTime date) {
		travel_details.setTravelDateTime(date);
	}

	public void addOpenVehiclePageBtnListener(ActionListener listener) {
		vehicle_panel.addOpenVehiclePageListener(listener);
	}

	public void addOpenDriverPageBtnListener(ActionListener listener) {
		driver_panel.addOpenDriverPageListener(listener);
	}

	public void addSendBillsBtnListener(ActionListener listener) {
		driver_panel.addSendBillsBtnListener(listener);
	}
	
	public void setVehiclePanel(String data, ImageIcon image_icon) {
		VehicleViewPanel panel = new VehicleViewPanel();
		panel.setVehicleDetails(data);
		panel.setVehicleLicenseImage(image_icon);
		vehicle_panel.setVehicleViewPanel(panel);
	}

	public void setDriverPanel(String data, ImageIcon image_icon) {
		driver_panel.setDriverDetails(new ClientViewPanel(data, image_icon));
	}

	
	public void setTravelPhoto(ImageIcon image_icon) {
		travel_details.setTravelPhoto(image_icon);
	}

	public void updatePanel() {
		this.updateUI();
	}


}

