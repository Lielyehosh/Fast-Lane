package View.ListPanel;

import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.event.ListSelectionListener;

import DataObject.DataObject;

import java.awt.BorderLayout;
import javax.swing.event.ListSelectionEvent;

/**
 * - This class is an implementation of the "data object list page" interface -
 * It contains three components: 1. DOList - the component that display the list
 * (can be replaced to table or other collection component) 2. searchBox - the
 * component that provide the search field the the search bottom 3. textArea -
 * the component that provide the details of a selected data object
 *
 */
@SuppressWarnings("serial")
public class DataObjectListPage extends JPanel implements IDataObjectListPage {

	private DataObjectList DOList;
	private SearchBox searchBox;
	private DataObjectTextArea textArea;
	private JPanel panel;

	/**
	 * Create the panel.
	 */
	public DataObjectListPage() {
		setSize(1144, 623);
		setLayout(new BorderLayout(0, 0));

		panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		DOList = new DataObjectList();
		DOList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if (DOList.getSelectedDataObject() == null) {
					setOpenPageBtnEnableMode(false);
				} else {
					setOpenPageBtnEnableMode(true);
				}
			}
		});
		sl_panel.putConstraint(SpringLayout.NORTH, DOList, 80, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, DOList, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, DOList, -10, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, DOList, 800, SpringLayout.WEST, panel);
		panel.add(DOList);
		textArea = new DataObjectTextArea();
		sl_panel.putConstraint(SpringLayout.WEST, textArea, 10, SpringLayout.EAST, DOList);
		sl_panel.putConstraint(SpringLayout.EAST, textArea, -10, SpringLayout.EAST, panel);
		panel.add(textArea);
		searchBox = new SearchBox();
		sl_panel.putConstraint(SpringLayout.NORTH, textArea, 20, SpringLayout.SOUTH, searchBox);
		sl_panel.putConstraint(SpringLayout.SOUTH, textArea, 400, SpringLayout.SOUTH, searchBox);
		sl_panel.putConstraint(SpringLayout.NORTH, searchBox, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, searchBox, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, searchBox, -20, SpringLayout.NORTH, DOList);
		sl_panel.putConstraint(SpringLayout.EAST, searchBox, -10, SpringLayout.EAST, panel);
		panel.add(searchBox);
		setOpenPageBtnEnableMode(false);
	}

	@Override
	public void setTextArea(String data) {
		textArea.setTextArea(data);
	}

	@Override
	public void setSortTypes(String[] sort_types) {
		DOList.setSortTypes(sort_types);
	}

	@Override
	public void setSearchTypes(String[] search_types) {
		searchBox.setSearchTypes(search_types);
	}

	@Override
	public void setListData(Vector<DataObject> DList) {
		DOList.setDataObjectListData(DList);
	}

	@Override
	public void setOpenPageBtnEnableMode(boolean mode) {
		textArea.setOpenPageBtnEnabledMode(mode);
	}

	@Override
	public void updatePanel() {
		this.doLayout();
		this.updateUI();
	}

	@Override
	public DataObject getSelectedDataObject() {
		return DOList.getSelectedDataObject();
	}

	@Override
	public String getSelectedDataObjectIdentifier() {
		return DOList.getSelectedDataObject().getIdentifier();
	}

	@Override
	public String getSelectedSortType() {
		return DOList.getSelectedSortType();
	}

	@Override
	public String getSearchFieldInput() {
		return searchBox.getSearchInput();
	}

	@Override
	public String getSearchType() {
		return searchBox.getSearchType();
	}

	@Override
	public void addSortSelectionListener(ItemListener sortSelectionListener) {
		DOList.addSortTypeSelectionListener(sortSelectionListener);

	}

	@Override
	public void addOpenPageBtnListener(ActionListener openPageBtnListener) {
		textArea.addOpenPageBtnListener(openPageBtnListener);

	}

	@Override
	public void addSearchBtnListener(ActionListener searchBtnListener) {
		searchBox.addSearchBtnListener(searchBtnListener);

	}

	@Override
	public void addListSelectionListener(ListSelectionListener listSelectionListener) {
		DOList.addListSelectionListener(listSelectionListener);

	}

}
