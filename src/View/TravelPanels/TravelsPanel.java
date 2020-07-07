package View.TravelPanels;

import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import View.ListPanel.*;

@SuppressWarnings("serial")
public class TravelsPanel extends JPanel implements ITravelsPanel {
	private DataObjectList travel_list;
	private JTextArea travelTextArea;
	private JButton btnOpenTravelPage;

	/**
	 * Create the panel.
	 */
	public TravelsPanel() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		travel_list = new DataObjectList();
		springLayout.putConstraint(SpringLayout.NORTH, travel_list, 0, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, travel_list, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, travel_list, 212, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, travel_list, 0, SpringLayout.EAST, this);
		travel_list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if (travel_list.getSelectedDataObject() == null) {
					setOpenTravelPageBtnMode(false);
				} else {
					setOpenTravelPageBtnMode(true);
				}

			}
		});
		add(travel_list);

		JScrollPane scrollPane = new JScrollPane();
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 20, SpringLayout.SOUTH, travel_list);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, 200, SpringLayout.SOUTH, travel_list);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, 300, SpringLayout.WEST, this);
		add(scrollPane);

		travelTextArea = new JTextArea();
		travelTextArea.setEditable(false);
		scrollPane.setViewportView(travelTextArea);

		btnOpenTravelPage = new JButton("Open Travel Page");
		springLayout.putConstraint(SpringLayout.NORTH, btnOpenTravelPage, 20, SpringLayout.SOUTH, travel_list);
		springLayout.putConstraint(SpringLayout.WEST, btnOpenTravelPage, 20, SpringLayout.EAST, scrollPane);
		springLayout.putConstraint(SpringLayout.SOUTH, btnOpenTravelPage, 60, SpringLayout.SOUTH, travel_list);
		springLayout.putConstraint(SpringLayout.EAST, btnOpenTravelPage, -20, SpringLayout.EAST, this);
		add(btnOpenTravelPage);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void setTravels(Vector TList) {
		travel_list.setDataObjectListData(TList);
	}

	public void setTravelSortTypes(String[] travelSortTypes) {
		travel_list.setSortTypes(travelSortTypes);
	}

	public void addSelectionTravelListener(ListSelectionListener selectionTravelListener) {
		travel_list.addListSelectionListener(selectionTravelListener);
	}

	public void addOpenTravelPageBtnListener(ActionListener openTravelPageListener) {
		btnOpenTravelPage.addActionListener(openTravelPageListener);
	}

	public void addTravelSortListListener(ItemListener selectedTravelSortType) {
		travel_list.addSortTypeSelectionListener(selectedTravelSortType);
	}

	public void setTravelTextArea(String data) {
		travelTextArea.setText(data);
	}

	public String getTravelSortType() {
		return travel_list.getSelectedSortType();
	}

	public String getSelectedTravelIdentifier() {
		return travel_list.getSelectedDataObject().getIdentifier();
	}

	public void setOpenTravelPageBtnMode(boolean mode) {
		btnOpenTravelPage.setEnabled(mode);
	}

	public void setListSelectionMode(boolean mode) {
		travel_list.setListSelectionMode(mode);
	}

	public void updatePanel() {
		travel_list.clearListSelection();
		setOpenTravelPageBtnMode(false);
		updateUI();
	}
}
