package View.ListPanel;

import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.event.ListSelectionListener;


import DataObject.DataObject;

public interface IDataObjectListPage {
		// Initialize methods
		public void setSortTypes(String[] sort_types);
		public void setSearchTypes(String[] search_types);
		public void setListData(Vector<DataObject> DList);
		
		// Event listeners
		public void addSortSelectionListener(ItemListener sortSelectionListener);
		public void addOpenPageBtnListener(ActionListener openPageBtnListener);
		public void addSearchBtnListener(ActionListener searchBtnListener);
		public void addListSelectionListener(ListSelectionListener listSelectionListener);

		// Update methods (change state)
		public void setTextArea(String data);
		public void setOpenPageBtnEnableMode(boolean mode);
		public void updatePanel();

		// Getters methods
		public DataObject getSelectedDataObject();
		public String getSelectedDataObjectIdentifier();
		public String getSelectedSortType();
		public String getSearchFieldInput();
		public String getSearchType();		
}
