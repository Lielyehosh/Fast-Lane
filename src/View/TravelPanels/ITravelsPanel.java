package View.TravelPanels;

import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.event.ListSelectionListener;

public interface ITravelsPanel {
	public void setTravels(Vector<?> TList);

	public void setTravelSortTypes(String[] travelSortTypes);

	public void addSelectionTravelListener(ListSelectionListener selectionTravelListener);

	public void addOpenTravelPageBtnListener(ActionListener openTravelPageListener);

	public void addTravelSortListListener(ItemListener selectedTravelSortType);

	public void setTravelTextArea(String data);

	public String getTravelSortType();

	public String getSelectedTravelIdentifier();

	public void setOpenTravelPageBtnMode(boolean mode);

	public void setListSelectionMode(boolean mode);

	public void updatePanel();

}
