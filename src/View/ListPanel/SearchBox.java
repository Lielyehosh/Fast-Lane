package View.ListPanel;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class SearchBox extends JPanel {
	private JTextField SearchInputTextField;
	private JButton btnSearch;
	private JComboBox<String> searchTypesComboBox;

	/**
	 * Create the panel.
	 */
	public SearchBox() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);

		SearchInputTextField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, SearchInputTextField, 0, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, SearchInputTextField, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, SearchInputTextField, 0, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, SearchInputTextField, -350, SpringLayout.EAST, this);
		add(SearchInputTextField);
		SearchInputTextField.setColumns(10);

		btnSearch = new JButton("Search");
		springLayout.putConstraint(SpringLayout.NORTH, btnSearch, 0, SpringLayout.NORTH, SearchInputTextField);
		springLayout.putConstraint(SpringLayout.SOUTH, btnSearch, 0, SpringLayout.SOUTH, SearchInputTextField);
		springLayout.putConstraint(SpringLayout.EAST, btnSearch, 0, SpringLayout.EAST, this);
		add(btnSearch);

		searchTypesComboBox = new JComboBox<String>();
		springLayout.putConstraint(SpringLayout.WEST, btnSearch, 6, SpringLayout.EAST, searchTypesComboBox);
		springLayout.putConstraint(SpringLayout.NORTH, searchTypesComboBox, 0, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, searchTypesComboBox, 6, SpringLayout.EAST, SearchInputTextField);
		springLayout.putConstraint(SpringLayout.SOUTH, searchTypesComboBox, 0, SpringLayout.SOUTH,
				SearchInputTextField);
		springLayout.putConstraint(SpringLayout.EAST, searchTypesComboBox, -165, SpringLayout.EAST, this);
		add(searchTypesComboBox);

	}

	public void setSearchTypes(String[] search_types) {
		for (String s_type : search_types) {
			searchTypesComboBox.addItem(s_type);
		}
	}
	
	public String getSearchType() {
		return (String)searchTypesComboBox.getSelectedItem();
	}
	
	public String getSearchInput() {
		return SearchInputTextField.getText();
	}
	
	public void addSearchBtnListener(ActionListener searchBtnListener) {
		btnSearch.addActionListener(searchBtnListener);
		SearchInputTextField.addActionListener(searchBtnListener);
	}
}
