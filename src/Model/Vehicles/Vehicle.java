package Model.Vehicles;

import DataObject.DataObject;
import DataObject.Exceptions.IllegalDataException;
import DataObject.Exceptions.IllegalVehicleDataException;

public class Vehicle implements DataObject {
	protected String vehicle_ID;
	protected String owner_ID;
	protected String type;
	protected String company;
	protected String model;
	private static final int Num_of_fields = 5;

	public Vehicle() {

	}

	public void setFields(String[] fields) throws IllegalDataException {
		if (fields == null)
		{
			throw new IllegalDataException("fields is null");
		}
		if (fields.length != Num_of_fields) {
			throw new IllegalDataException("Illegal vehicle data input - Missing fields");
		}
		setVehicleID(fields[0]);
		setOwner_ID(fields[1]);
		setType(fields[2]);
		setCompany(fields[3]);
		setModel(fields[4]);
	}

	public String getCompany() {
		return company;
	}

	public String getModel() {
		return model;
	}

	public String getVehicleID() {
		return vehicle_ID;
	}

	public String getOwner_ID() {
		return owner_ID;
	}

	public String getType() {
		return type;
	}

	public void setOwner_ID(String owner_ID) throws IllegalDataException {
		if (owner_ID == null) {
			throw new IllegalDataException("Owner ID is null");
		} else if (owner_ID.isEmpty()) {
			throw new IllegalVehicleDataException("OwnerID", "Missing owner ID");
		} else if (owner_ID.matches("\\d{9}") == false) {
			throw new IllegalVehicleDataException("OwnerID", "Illegal owner ID");
		}
		this.owner_ID = owner_ID;
	}

	public void setType(String type) throws IllegalDataException {
		if (type == null) {
			throw new IllegalDataException("Type is null");
		} else if (type.isEmpty()) {
			throw new IllegalVehicleDataException("Type", "Missing type");
		}
		this.type = type;
	}

	public void setVehicleID(String iD) throws IllegalDataException {
		if (iD == null) {
			throw new IllegalDataException("Vehicle ID is null");
		} else if (iD.isEmpty()) {
			throw new IllegalVehicleDataException("VehicleID", "Missing Vehicle ID");
		} else if (iD.matches("\\d{7}") == false && iD.matches("\\d{8}") == false) {
			throw new IllegalVehicleDataException("VehicleID", "Vehicle ID is illegal");
		}
		vehicle_ID = iD;

	}

	public void setCompany(String company) throws IllegalDataException {
		if (company == null) {
			throw new IllegalDataException("Company is null");
		} else if (company.isEmpty()) {
			throw new IllegalVehicleDataException("Company", "Missing company name");
		}
		this.company = company;
	}

	public void setModel(String model) throws IllegalDataException {
		if (model == null) {
			throw new IllegalDataException("Model is null");
		} else if (model.isEmpty()) {
			throw new IllegalVehicleDataException("Model", "Missing model");
		}
		this.model = model;
	}

	public void loadData(String vehicle_data) throws IllegalDataException {
		if (vehicle_data == null) {
			throw new IllegalDataException("vehicle_data is null");
		}
		String[] fields = vehicle_data.split(",");
		setFields(fields);
	}

	public String toString() {
		return getVehicleID() + " - " + getOwner_ID() + " - " + getType() + " - " + getCompany();
	}

	public String print() {
		return "License number: " + getVehicleID() + "\n" + "Owner ID: " + getOwner_ID() + "\n" + "Type: " + getType()
				+ "\n" + "Company: " + getCompany() + "\n" + "Model: " + getModel();
	}

	@Override
	public String save() {
		return getVehicleID() + "," + getOwner_ID() + "," + getType() + "," + getCompany() + "," + getModel();
	}

	@Override
	public String getIdentifier() {
		return getVehicleID();
	}

	@Override
	public void load(String data) {
		// TODO Auto-generated method stub

	}

}