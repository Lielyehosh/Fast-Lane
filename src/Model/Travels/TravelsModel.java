package Model.Travels;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Vector;
import java.util.function.Predicate;

import javax.swing.ImageIcon;

import DataObject.Exceptions.IllegalDataException;
import ExternalSystems.Database;

public class TravelsModel {
	private static TravelsModel M;
	protected Vector<Travel> travel_list;
	protected String[] sort_types = { "Vehicle ID", "Driver ID", "Date" };
	protected String[] search_types = { "Vehicle ID", "Driver ID", "Year" };
	protected HashMap<String, Travel> TMap;

	private TravelsModel() {
		travel_list = new Vector<Travel>();
		TMap = new HashMap<String, Travel>();
		loadData();
	}

	public static TravelsModel getModel() {
		if (M == null) {
			M = new TravelsModel();
		}
		return M;
	}

	// Save and load methods

	public void loadData() {
		Vector<String> t_lines = Database.loadData("travels");
		for (String line : t_lines) {
			try {
				createTravel(line);
			} catch (IllegalDataException e) {
				e.printStackTrace();

			}
		}
	}

	public void saveData() {
		Collection<Travel> TList = TMap.values();
		Vector<String> travels_data = new Vector<String>();
		for (Travel T : TList) {
			travels_data.add(T.save());
		}
		Database.saveData("travels", travels_data);
	}

	// Create new travel

	private Travel createTravel(String line) throws IllegalDataException {
		Travel T = new Travel();
		T.load(line);
		TMap.put(T.getIdentifier(), T);
		return T;
	}

	public Travel getTravelByID(String travel_id) {
		return TMap.get(travel_id);
	}

	public ImageIcon getTravelPhoto(String travel_id) {
		return new ImageIcon(Database.getTravelPhotograph(travel_id));
	}

	// List methods

	public Vector<Travel> getList() {
		return travel_list;
	}

	public void search(String search_type, String search_input) {
		switch (search_type) {
		case "Vehicle ID":
			searchBy(new Predicate<Travel>() {
				public boolean test(Travel t) {
					return t.getVehicleID().startsWith(search_input);
				}
			});
			break;
		case "Driver ID":
			searchBy(new Predicate<Travel>() {
				public boolean test(Travel t) {
					return t.getDriverID().startsWith(search_input);
				}
			});
			break;
		case "Year":
			searchBy(new Predicate<Travel>() {
				@Override
				public boolean test(Travel t) {
				return t.getDate().getYear() == Integer.parseInt(search_input);
			}
			});
			break;
		default:
			break;
		}
	}

	private void searchBy(Predicate<Travel> P) {
		Vector<Travel> Temp = new Vector<Travel>();
		for (Travel T : travel_list) {
			if (P.test(T)) {
				Temp.addElement(T);
			}
		}
		travel_list.retainAll(Temp);
		Temp.clear();
	}
	
	public String[] getSortTypes() {
		return sort_types;
	}

	public String[] getSearchTypes() {
		return search_types;
	}

	public void initList() {
		travel_list.clear();
		travel_list.addAll(TMap.values());
	}

	public void sortList(String sortType) {
		switch (sortType) {
		case "Driver ID":
			travel_list.sort(new Comparator<Travel>() {
				@Override
				public int compare(Travel o1, Travel o2) {
					return o1.getDriverID().compareTo(o2.getDriverID());
				}
			});
			break;
		case "Vehicle ID":
			travel_list.sort(new Comparator<Travel>() {
				@Override
				public int compare(Travel o1, Travel o2) {
					return o1.getVehicleID().compareTo(o2.getVehicleID());
				}
			});
			break;
		case "Date":
			travel_list.sort(new Comparator<Travel>() {
				@Override
				public int compare(Travel o1, Travel o2) {
					return o1.getDate().compareTo(o2.getDate());
				}
			});
			break;
		default:
			break;
		}
	}
	
	

}
