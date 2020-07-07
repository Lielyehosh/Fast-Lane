package View.VehiclePage;

import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SpringLayout;
import javax.swing.event.ListSelectionListener;

import Model.Vehicles.Vehicle;
import View.TravelPanels.TravelsPanel;
import View.VehiclePanels.VehicleFieldsPanel;
import View.VehiclePanels.VehicleViewPanel;

@SuppressWarnings("serial")
public class VehiclePage extends JPanel implements IVehiclePage {
	private VehicleFieldsPanel fields_panel;
	private TravelsPanel travels_panel;
	private JSplitPane splitPane_1;
	private JPanel panel_2;
	private JButton btnOpenOwnerPage;
	private JButton btnChangeOwner;
	private VehicleViewPanel view_panel;
	
	/**
	 * Create the panel.
	 */
	public VehiclePage() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		splitPane_1 = new JSplitPane();
		add(splitPane_1);
		fields_panel = new VehicleFieldsPanel();
		splitPane_1.setLeftComponent(fields_panel);
		
		panel_2 = new JPanel();
		splitPane_1.setRightComponent(panel_2);
		SpringLayout sl_panel_2 = new SpringLayout();
		panel_2.setLayout(sl_panel_2);
		
		btnOpenOwnerPage = new JButton("Open Owner Page");
		sl_panel_2.putConstraint(SpringLayout.NORTH, btnOpenOwnerPage, 10, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, btnOpenOwnerPage, 10, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, btnOpenOwnerPage, 51, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, btnOpenOwnerPage, -10, SpringLayout.EAST, panel_2);
		panel_2.add(btnOpenOwnerPage);
		
		btnChangeOwner = new JButton("Change Owner");
		sl_panel_2.putConstraint(SpringLayout.NORTH, btnChangeOwner, 10, SpringLayout.SOUTH, btnOpenOwnerPage);
		sl_panel_2.putConstraint(SpringLayout.WEST, btnChangeOwner, 0, SpringLayout.WEST, btnOpenOwnerPage);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, btnChangeOwner, 51, SpringLayout.SOUTH, btnOpenOwnerPage);
		sl_panel_2.putConstraint(SpringLayout.EAST, btnChangeOwner, 0, SpringLayout.EAST, btnOpenOwnerPage);
		panel_2.add(btnChangeOwner);
		splitPane_1.setResizeWeight(0.7);
		
		JSplitPane splitPane = new JSplitPane();
		add(splitPane);
		travels_panel = new TravelsPanel();
		splitPane.setLeftComponent(travels_panel);
		
		view_panel = new VehicleViewPanel();
		splitPane.setRightComponent(view_panel);
		splitPane.setResizeWeight(0.5);
	}

	public void setVehicleDetails(Vehicle V) {
		fields_panel.setFieldsData(V.save());
		view_panel.setVehicleDetails(V.print());
	}
	
	public void setVehicleLicenseImage(ImageIcon image_icon) {
		view_panel.setVehicleLicenseImage(image_icon);
	}


	public void setTravelList(Vector<?> TList) {
		travels_panel.setTravels(TList);
	}

	public void setTravelSortTypes(String[] sort_types) {
		travels_panel.setTravelSortTypes(sort_types);
	}

	public void addOpenOwnerPageBtnListener(ActionListener openOwnerPageBtnListener) {
		btnOpenOwnerPage.addActionListener(openOwnerPageBtnListener);
	}

	public void addOpenTravelPageBtnListener(ActionListener openTravelPageBtnListener) {
		travels_panel.addOpenTravelPageBtnListener(openTravelPageBtnListener);
	}

	public void addChangeOwnerBtnListener(ActionListener changeOwnerBtnListener) {
		btnChangeOwner.addActionListener(changeOwnerBtnListener);
	}

	public void addTravelListSelectionListener(ListSelectionListener travelListSelectionListener) {
		travels_panel.addSelectionTravelListener(travelListSelectionListener);
	}

	public void addTravelSortTypeSelectionListener(ItemListener sortTypeSelectionListener) {
		travels_panel.addTravelSortListListener(sortTypeSelectionListener);
	}

	public String getVehicleID() {
		return fields_panel.getIdentifier();
	}
	

	public String getTravelSortType() {
		return travels_panel.getTravelSortType();
	}
	

	public String getOwnerID() {
		return fields_panel.getOwnerID();
	}

	public String getSelectedTravelIdentifier() {
		return travels_panel.getSelectedTravelIdentifier();
	}

	public void setTravelTextArea(String data) {
		travels_panel.setTravelTextArea(data);
	}

	public void setOpenTravelPageBtnMode(boolean mode) {
		travels_panel.setOpenTravelPageBtnMode(mode);
	}



	public void updatePanel() {
		travels_panel.updatePanel();
		fields_panel.updatePanel();
	}





}
