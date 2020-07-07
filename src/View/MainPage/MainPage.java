package View.MainPage;

import javax.swing.JPanel;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.SpringLayout;
import javax.swing.SwingConstants;


import java.awt.Font;

@SuppressWarnings("serial")
public class MainPage extends JPanel implements IMainPage {

	private JLabel lblTitle;
	private JButton btnClientList;
	private JButton btnVehicleList;
	private JButton btnTravelList;
	private JButton btnAddNewClient;

	public MainPage() {
		setBackground(Color.LIGHT_GRAY);

		btnClientList = new JButton("Client List Page");
		btnClientList.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnClientList.setToolTipText("Open the client list page");

		lblTitle = new JLabel("Main Page");
		lblTitle.setFont(new Font("Sylfaen", Font.BOLD, 20));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);

		btnVehicleList = new JButton("Vehicle List Page");
		btnVehicleList.setFont(new Font("Tahoma", Font.PLAIN, 15));

		btnTravelList = new JButton("Travel List Page");
		btnTravelList.setFont(new Font("Tahoma", Font.PLAIN, 15));
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.EAST, btnVehicleList, -250, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.WEST, btnTravelList, 250, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, btnTravelList, -250, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.WEST, btnVehicleList, 250, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.NORTH, btnTravelList, 20, SpringLayout.SOUTH, btnVehicleList);
		springLayout.putConstraint(SpringLayout.SOUTH, btnTravelList, 80, SpringLayout.SOUTH, btnVehicleList);
		springLayout.putConstraint(SpringLayout.NORTH, btnVehicleList, 20, SpringLayout.SOUTH, btnClientList);
		springLayout.putConstraint(SpringLayout.SOUTH, btnVehicleList, 80, SpringLayout.SOUTH, btnClientList);
		springLayout.putConstraint(SpringLayout.NORTH, btnClientList, 20, SpringLayout.SOUTH, lblTitle);
		springLayout.putConstraint(SpringLayout.WEST, btnClientList, 250, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, btnClientList, 80, SpringLayout.SOUTH, lblTitle);
		springLayout.putConstraint(SpringLayout.EAST, btnClientList, -250, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.NORTH, lblTitle, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblTitle, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, lblTitle, -10, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblTitle, 50, SpringLayout.NORTH, this);
		setLayout(springLayout);

		btnAddNewClient = new JButton("Add New Client");
		btnAddNewClient.setFont(new Font("Tahoma", Font.PLAIN, 15));
		springLayout.putConstraint(SpringLayout.NORTH, btnAddNewClient, 20, SpringLayout.SOUTH, btnTravelList);
		springLayout.putConstraint(SpringLayout.WEST, btnAddNewClient, 250, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, btnAddNewClient, 80, SpringLayout.SOUTH, btnTravelList);
		springLayout.putConstraint(SpringLayout.EAST, btnAddNewClient, -250, SpringLayout.EAST, this);
		add(btnAddNewClient);
		add(btnTravelList);
		add(btnVehicleList);
		add(lblTitle);
		add(btnClientList);
		

	}

	public void setTitle(String title) {
		lblTitle.setText(title);
	}

	public void addClientListBtnListener(ActionListener clientsBtnListener) {
		btnClientList.addActionListener(clientsBtnListener);
	}

	public void addVehicleListBtnListener(ActionListener vehiclesBtnListener) {
		btnVehicleList.addActionListener(vehiclesBtnListener);
	}

	public void addTravelListBtnListener(ActionListener travelsBtnListener) {
		btnTravelList.addActionListener(travelsBtnListener);
	}

	public void addCreateNewClientBtnListener(ActionListener createNewClientBtnListener) {
		btnAddNewClient.addActionListener(createNewClientBtnListener);
	}
	
	public void updatePanel() {
		super.updateUI();
	}

}
