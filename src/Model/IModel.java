package Model;

import java.util.Vector;

import javax.swing.ImageIcon;

import DataObject.DataObject;
import DataObject.Exceptions.*;
import Model.Clients.Client;
import Model.Travels.Travel;
import Model.Vehicles.Vehicle;

/**
 * - This interface uses the  "Facade pattern" -
 *        The methods within this interface should solve ONLY ONE PROBLEM.
 *
 */
public interface IModel {
	
	public Vector<Client> getClientList();

	public Vector<Vehicle> getVehicleList();

	public Vector<Travel> getTravelList();

	public Client getClientByID(String iD);

	public Vehicle getVehicleByID(String iD);

	public Travel getTravelByID(String travel_id);

	public void searchClientList(String search_type, String search_input);

	public void searchVehicleList(String search_type, String search_input);

	public void searchTravelList(String search_type, String search_input);

	public String[] getClientSortTypes();

	public String[] getVehicleSortTypes();

	public String[] getTravelSortTypes();

	public String[] getClientSearchTypes();

	public String[] getVehicleSearchTypes();

	public String[] getTravelSearchTypes();

	public void initClientList();

	public void initVehicleList();

	public void initTravelList();

	public void sortClientList(String sortType);

	public void sortVehicleList(String sortType);

	public void sortTravelList(String sortType);

	public String getDataObjectDetails(DataObject data_object);

	public String addNewClient(String clientDetailsInput) throws IllegalDataException;

	public String updateClient(String client_id, String new_details) throws IllegalDataException;

	public String addNewVehicle(String vehicle_id, String owner_id) throws IllegalDataException;

	public String updateVehicleOwner(String vehicle_id, String owner_id) throws IllegalDataException;

	public ImageIcon getClientLicensePic(String client_id);

	public ImageIcon getVehicleLicensePic(String identifier);

	public ImageIcon getTravelPhoto(String identifier);

	public ImageIcon getClientContract(String client_id);
	
	public void save();

	public void sendTravelBills(String mail) throws IllegalDataException;

}