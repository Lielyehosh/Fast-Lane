package Command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import DataObject.DataObject;
import Model.IModel;
import View.IView;
import View.ListPanel.DataObjectListPage;


/**
 * @author Liel
 *	- Create new "Data object list page"
 *	- Initialize the listeners and the data (the list,the search types and the sort types)
 * 
 */
public class OpenClientListPageCommand extends OpenPageCommand {
	
	public OpenClientListPageCommand(IView view,IModel model) {
		super(view,model);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void execute() {
		DataObjectListPage Page = new DataObjectListPage();
		M.initClientList();
		Page.setListData((Vector) M.getClientList());
		Page.setSearchTypes(M.getClientSearchTypes());
		Page.setSortTypes(M.getClientSortTypes());
		Page.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				DataObject d = Page.getSelectedDataObject();
				if (d != null) {
					Page.setTextArea(M.getDataObjectDetails(d));
					Page.setOpenPageBtnEnableMode(true);
				} else {
					Page.setTextArea("");
					Page.setOpenPageBtnEnableMode(false);
				}
			}
		});
		Page.addSortSelectionListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				M.sortClientList(Page.getSelectedSortType());
				Page.updatePanel();
			}
		});
		Page.addSearchBtnListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String search_type = Page.getSearchType();
				String search_input = Page.getSearchFieldInput();
				M.initClientList();
				M.searchClientList(search_type, search_input);
				Page.updatePanel();
			}
		});
		Page.addOpenPageBtnListener(e -> new OpenClientPageCommand(V, M,Page.getSelectedDataObjectIdentifier()).execute());
		V.setCenterPanel(Page);
	}
	
	
	

}
