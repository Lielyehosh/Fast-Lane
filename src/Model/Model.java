package Model;

import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;

import DataObject.DataObject;
import DataObject.Exceptions.IllegalDataException;
import DataObject.Exceptions.IllegalVehicleDataException;
import ExternalSystems.Database;
import Model.Clients.Client;
import Model.Clients.ClientsModel;
import Model.Travels.Travel;
import Model.Travels.TravelsModel;
import Model.Vehicles.Vehicle;
import Model.Vehicles.VehiclesModel;

public class Model implements IModel {
	private ClientsModel CModel;
	private VehiclesModel VModel;
	private TravelsModel TModel;

	public Model() throws IllegalDataException {
		CModel = ClientsModel.getModel();
		VModel = VehiclesModel.getModel();
		TModel = TravelsModel.getModel();
	}

	public Vector<Client> getClientList() {
		return CModel.getList();
	}

	public Vector<Vehicle> getVehicleList() {
		return VModel.getList();
	}

	public Vector<Travel> getTravelList() {
		return TModel.getList();
	}

	public Client getClientByID(String iD) {
		return CModel.getClient(iD);
	}

	public Vehicle getVehicleByID(String iD) {
		return VModel.getVehicle(iD);
	}

	public Travel getTravelByID(String travel_id) {
		return TModel.getTravelByID(travel_id);
	}

	public void searchClientList(String search_type, String search_input) {
		CModel.search(search_type, search_input);
	}

	public void searchVehicleList(String search_type, String search_input) {
		VModel.search(search_type, search_input);
	}

	public void searchTravelList(String search_type, String search_input) {
		TModel.search(search_type, search_input);
	}

	public String[] getClientSortTypes() {
		return CModel.getSortTypes();
	}

	public String[] getVehicleSortTypes() {
		return VModel.getSortTypes();
	}

	public String[] getTravelSortTypes() {
		return TModel.getSortTypes();
	}

	public String[] getClientSearchTypes() {
		return CModel.getSearchTypes();
	}

	public String[] getVehicleSearchTypes() {
		return VModel.getSearchTypes();
	}

	public String[] getTravelSearchTypes() {
		return TModel.getSearchTypes();
	}

	public void initClientList() {
		CModel.initList();
	}

	public void initVehicleList() {
		VModel.initList();
	}

	public void initTravelList() {
		TModel.initList();
	}

	public void sortClientList(String sortType) {
		CModel.sortList(sortType);
	}

	public void sortVehicleList(String sortType) {
		VModel.sortList(sortType);
	}

	public void sortTravelList(String sortType) {
		TModel.sortList(sortType);
	}

	public String getDataObjectDetails(DataObject data_object) {
		return data_object.print();
	}

	public String updateClient(String client_id, String new_details) throws IllegalDataException {
		return CModel.updateClient(client_id, new_details);
	}

	public String addNewClient(String clientDetailsInput) throws IllegalDataException {
		return CModel.addNewClient(clientDetailsInput);
	}

	public String addNewVehicle(String vehicle_id, String owner_id) throws IllegalDataException {
		if (CModel.getClient(owner_id) == null) {
			throw new IllegalVehicleDataException("OwnerID", "Owner doesn't exist");
		} else if (VModel.getVehicle(vehicle_id) != null) {
			throw new IllegalVehicleDataException("VehicleID", "This vehicle is already exist");
		}
		return VModel.addNewVehicle(vehicle_id, owner_id);
	}

	public String updateVehicleOwner(String vehicle_id, String owner_id) throws IllegalDataException {
		if (CModel.getClient(owner_id) == null) {
			// Validate client's instance
			throw new IllegalVehicleDataException("OwnerID", "Owner doesn't exist");
		}
		return VModel.updateVehicleOwnerID(vehicle_id, owner_id);
	}

	public ImageIcon getVehicleLicensePic(String identifier) {
		return VModel.getVehicleLicensePic(identifier);
	}

	public ImageIcon getClientLicensePic(String client_id) {
		return CModel.getClientLicensePic(client_id);
	}

	public ImageIcon getTravelPhoto(String identifier) {
		return new ImageIcon(Database.getTravelPhotograph(identifier));
	}

	public ImageIcon getClientContract(String client_id) {
		return new ImageIcon(Database.getClientContract(client_id));
	}

	public void save() {
		CModel.saveData();
		VModel.saveData();
	}

	public void sendTravelBills(String mail) throws IllegalDataException {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";
		Pattern pat = Pattern.compile(emailRegex);
		if (pat.matcher(mail).matches() == false) {
			throw new IllegalDataException("Illegal mail address");
		}
	}

}
