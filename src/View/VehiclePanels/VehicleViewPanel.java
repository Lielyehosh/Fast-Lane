package View.VehiclePanels;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Color;

@SuppressWarnings("serial")
public class VehicleViewPanel extends JPanel implements IVehicleViewPanel {

	private JLabel lblLicenseimage;
	private JTextPane textPane;
	private JSplitPane splitPane;

	/**
	 * Create the panel.
	 */
	public VehicleViewPanel() {
		setLayout(new BorderLayout(0, 0));
		
		splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.5);
		add(splitPane, BorderLayout.CENTER);
		lblLicenseimage = new JLabel("");
		splitPane.setRightComponent(lblLicenseimage);
		lblLicenseimage.setHorizontalAlignment(SwingConstants.CENTER);
		
		textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setForeground(Color.BLACK);
		textPane.setBackground(Color.LIGHT_GRAY);
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		splitPane.setLeftComponent(textPane);
	}
	
	public VehicleViewPanel(String data,ImageIcon image) {
		this();
		setVehicleDetails(data);
		setVehicleLicenseImage(image);
	}

	@Override
	public void setVehicleLicenseImage(ImageIcon image_icon) {
		lblLicenseimage.setIcon(image_icon);
	}
	
	public void setVehicleDetails(String data) {
		textPane.setText(data);
	}
	
	public void changeSplitPane(int orientation) {
		splitPane.setOrientation(orientation);
		splitPane.setResizeWeight(0.5);
	}

}
