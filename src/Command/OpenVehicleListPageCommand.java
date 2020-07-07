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
import View.ListPanel.DataObjectListPage;
import View.IView;

public class OpenVehicleListPageCommand extends OpenPageCommand {

	public OpenVehicleListPageCommand(IView view,IModel model) {
		super(view,model);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void execute() {
		DataObjectListPage Page = new DataObjectListPage();
		M.initVehicleList();
		Page.setListData((Vector) M.getVehicleList());
		Page.setSearchTypes(M.getVehicleSearchTypes());
		Page.setSortTypes(M.getVehicleSortTypes());
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
				M.sortVehicleList(Page.getSelectedSortType());
				Page.updatePanel();
			}
		});
		Page.addSearchBtnListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String search_type = Page.getSearchType();
				String search_input = Page.getSearchFieldInput();
				M.initVehicleList();
				M.searchVehicleList(search_type, search_input);
				Page.updatePanel();
			}
		});
		Page.addOpenPageBtnListener(e-> new OpenVehiclePageCommand(V, M,Page.getSelectedDataObjectIdentifier()).execute());
		V.setCenterPanel(Page);

	}

}
