package View.TravelPanels;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JPanel;

import View.VehiclePanels.VehicleViewPanel;

@SuppressWarnings("serial")
public class TravelVehiclePanel extends JPanel {
	private JPanel panel;
	private JButton btnOpenVehiclePage;

	/**
	 * Create the panel.
	 */
	public TravelVehiclePanel() {
		setLayout(new BorderLayout(0, 0));

		btnOpenVehiclePage = new JButton("Open Vehicle Page");
		add(btnOpenVehiclePage, BorderLayout.NORTH);

		panel = new VehicleViewPanel();
		add(panel, BorderLayout.CENTER);

	}

	public void setVehicleViewPanel(JPanel vehicle_panel) {
		panel = vehicle_panel;
		add(panel, BorderLayout.CENTER);
	}

	public void addOpenVehiclePageListener(ActionListener listener) {
		btnOpenVehiclePage.addActionListener(listener);
	}

}
