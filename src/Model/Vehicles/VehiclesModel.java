package Model.Vehicles;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Vector;
import java.util.function.Predicate;

import javax.swing.ImageIcon;

import DataObject.Exceptions.IllegalDataException;
import DataObject.Exceptions.IllegalVehicleDataException;
import ExternalSystems.Database;

public class VehiclesModel {
	private static VehiclesModel M;

	protected String[] sort_types = { "Vehicle ID", "Owner ID", "Type", "Company", "Model" };
	protected String[] search_types = { "Vehicle ID", "Owner ID", "Type", "Company", "Model" };
	protected Vector<Vehicle> vehicle_list;
	protected HashMap<String, Vehicle> VMap;
	protected final static int Num_Of_Fields = 5;

	private VehiclesModel() {
		vehicle_list = new Vector<Vehicle>();
		VMap = new HashMap<String, Vehicle>();
		loadData();
	}

	public static VehiclesModel getModel() {
		if (M == null) {
			M = new VehiclesModel();
		}
		return M;
	}

	// ------------------------------------------

	/**
	 * @param P: A condition for reducing the list
	 */
	private void searchBy(Predicate<Vehicle> P) {
		Vector<Vehicle> Temp = new Vector<Vehicle>();
		for (Vehicle V : vehicle_list) {
			if (P.test(V)) {
				Temp.addElement(V);
			}
		}
		vehicle_list.retainAll(Temp);
		Temp.clear();
	}

	/**
	 * @param vehicle_data - Create a new vehicle object, and add it to the vehicle
	 *                     map.
	 * @throws IllegalDataException
	 */
	private Vehicle createVehicle(String vehicle_data) throws IllegalDataException {
		Vehicle V = new Vehicle();
		V.loadData(vehicle_data);
		if (VMap.containsKey(V.getIdentifier())) {
			throw new IllegalVehicleDataException("VehicleID", "Vehicle is already exist");
		}
		return V;
	}

	private void addVehicle(Vehicle V) {
		VMap.put(V.getIdentifier(), V);
	}

	// --------------------------------------------
	// -----API methods------
	// --------------------------------------------

	/**
	 * @param vehicle_ID
	 * @param owner_ID   - Update the vehicle's owner ID (doesn't know if the owner
	 *                   exist or not)
	 * @throws IllegalDataException
	 */
	public String updateVehicleOwnerID(String vehicle_ID, String owner_ID) throws IllegalDataException {
		if (vehicle_ID == null) {
			throw new IllegalDataException("vehicle_ID is null");
		} else if (owner_ID == null) {
			throw new IllegalDataException("owner_ID is null");
		} else if (VMap.containsKey(vehicle_ID) == false) {
			throw new IllegalVehicleDataException("VehicleID", "Vehicle ID doesn't exist");
		} 
		getVehicle(vehicle_ID).setOwner_ID(owner_ID);
		return vehicle_ID;
	}

	public String addNewVehicle(String vehicle_id, String owner_id) throws IllegalDataException {
		if (VMap.containsKey(vehicle_id)) {
			throw new IllegalVehicleDataException("VehicleID", "This vehicle is already exist");
		} else if (vehicle_id.length() != 7) {
			throw new IllegalVehicleDataException("VehicleID", "Length is illegal");
		} else if (vehicle_id.matches("\\d{7}") == false) {
			throw new IllegalVehicleDataException("VehicleID", "Vehicle ID is illegal");
		}
		String vehicle_details = vehicle_id + "," + owner_id + "," + Database.getNewVehicleProperties(vehicle_id);
		addVehicle(createVehicle(vehicle_details));
		return vehicle_id;
	}

	/**
	 * - This method load all of the vehicles in the system - VMap: Contains all the
	 * vehicles objects in the system
	 */
	public void initList() {
		vehicle_list.clear();
		vehicle_list.addAll(VMap.values());
	}

	/**
	 * Load the clients records Database is an external system
	 * 
	 */
	public void loadData() {
		Vector<String> v_lines = Database.loadData("vehicles");
		for (String line : v_lines) {
			try {
				addVehicle(createVehicle(line));
			} catch (IllegalDataException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Save the clients records
	 */
	public void saveData() {
		Collection<Vehicle> VList = VMap.values();
		Vector<String> vehicles_data = new Vector<String>();
		for (Vehicle V : VList) {
			vehicles_data.add(V.save());
		}
		Database.saveData("vehicles", vehicles_data);
	}

	public Vehicle getVehicle(String iD) {
		if (VMap.containsKey(iD))
			return VMap.get(iD);
		else
			return null;
	}

	public ImageIcon getVehicleLicensePic(String vehicle_id) {
		return new ImageIcon(Database.getVehicleLicenseCopy(vehicle_id));
	}
	
	public String[] getSortTypes() {
		return sort_types;
	}

	public String[] getSearchTypes() {
		return search_types;
	}

	/**
	 * @return The working list
	 */
	public Vector<Vehicle> getList() {
		return vehicle_list;
	}

	/**
	 * @param search_type
	 * @param search_input - This function creates the predicate of the search, and
	 *                     calls the search method.
	 */
	public void search(String search_type, String search_input) {
		switch (search_type) {
		case "Vehicle ID":
			searchBy(new Predicate<Vehicle>() {
				public boolean test(Vehicle t) {
					return t.getVehicleID().startsWith(search_input);
				}
			});
			break;
		case "Owner ID":
			searchBy(new Predicate<Vehicle>() {
				public boolean test(Vehicle t) {
					return t.getOwner_ID().startsWith(search_input);
				}
			});
			break;
		case "Type":
			searchBy(new Predicate<Vehicle>() {
				public boolean test(Vehicle t) {
					return t.getType().toLowerCase().startsWith(search_input);
				}
			});
			break;
		case "Company":
			searchBy(new Predicate<Vehicle>() {
				public boolean test(Vehicle t) {
					return t.getCompany().startsWith(search_input);
				}
			});
			break;
		case "Model":
			searchBy(new Predicate<Vehicle>() {
				public boolean test(Vehicle t) {
					return t.getModel().startsWith(search_input);
				}
			});
			break;
		default:
			break;
		}
	}

	/**
	 * @param sort_type
	 */
	public void sortList(String sort_type) {
		switch (sort_type) {
		case "Vehicle ID":
			vehicle_list.sort(new Comparator<Vehicle>() {
				public int compare(Vehicle o1, Vehicle o2) {
					return o1.getVehicleID().compareTo(o2.getVehicleID());
				}
			});
			break;
		case "Owner ID":
			vehicle_list.sort(new Comparator<Vehicle>() {
				public int compare(Vehicle o1, Vehicle o2) {
					return o1.getOwner_ID().compareTo(o2.getOwner_ID());
				}
			});
			break;
		case "Type":
			vehicle_list.sort(new Comparator<Vehicle>() {
				public int compare(Vehicle o1, Vehicle o2) {
					return o1.getType().compareToIgnoreCase(o2.getType());
				}
			});
			break;
		case "Company":
			vehicle_list.sort(new Comparator<Vehicle>() {
				public int compare(Vehicle o1, Vehicle o2) {
					return o1.getCompany().compareToIgnoreCase(o2.getCompany());
				}
			});
			break;
		case "Model":
			vehicle_list.sort(new Comparator<Vehicle>() {
				public int compare(Vehicle o1, Vehicle o2) {
					return o1.getModel().compareToIgnoreCase(o2.getModel());
				}
			});
			break;
		default:
			break;
		}

	}

}
