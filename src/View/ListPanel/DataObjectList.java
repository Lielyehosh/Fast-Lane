package View.ListPanel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;

import DataObject.DataObject;

@SuppressWarnings("serial")
public class DataObjectList extends JPanel {

	private JList<DataObject> list;
	private JComboBox<String> sortTypesComboBox;

	/**
	 * Create the panel.
	 */
	public DataObjectList() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		list = new JList<DataObject>();
		list.setFont(new Font("Tahoma", Font.BOLD, 15));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(list);
		
		sortTypesComboBox = new JComboBox<String>();
		sortTypesComboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPane.setColumnHeaderView(sortTypesComboBox);

	}
	
	public void setSortTypes(String[] sort_types) {
		sortTypesComboBox.removeAllItems();
		for(String s_type : sort_types) {
			sortTypesComboBox.addItem(s_type);
		}
	}
	
	public void setDataObjectListData(Vector<DataObject> DList) {
		list.setListData(DList);
	}
	
	public void addListSelectionListener(ListSelectionListener listener) {
		list.addListSelectionListener(listener);
	}
	
	public void addSortTypeSelectionListener(ItemListener listener) {
		sortTypesComboBox.addItemListener(listener);
	}
	
	public DataObject getSelectedDataObject() {
		return list.getSelectedValue();
	}
	
	public String getSelectedSortType() {
		return (String)sortTypesComboBox.getSelectedItem();
	}

	public void setListSelectionMode(boolean mode) {
		list.clearSelection();
		list.setEnabled(mode);
	}
	
	public void clearListSelection() {
		list.clearSelection();
	}
}
