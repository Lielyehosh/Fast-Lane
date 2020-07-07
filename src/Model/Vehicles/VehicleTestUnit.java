package Model.Vehicles;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import DataObject.Exceptions.IllegalDataException;

import DataObject.Exceptions.IllegalVehicleDataException;

class VehicleTestUnit {

	@DisplayName("Setters tests")
	@Test
	void test() {
		Vehicle V = new Vehicle();
		assertThrows(IllegalDataException.class, ()->V.setFields(null));
		assertThrows(IllegalDataException.class, ()->V.setCompany(null));
		assertThrows(IllegalDataException.class, ()->V.setModel(null));
		assertThrows(IllegalDataException.class, ()->V.setOwner_ID(null));
		assertThrows(IllegalDataException.class, ()->V.setVehicleID(null));
		assertThrows(IllegalDataException.class, ()->V.setType(null));
		// vehicle id tests
		assertThrows(IllegalVehicleDataException.class, ()->V.setVehicleID(""));
		assertThrows(IllegalVehicleDataException.class, ()->V.setVehicleID("123123123"));
		assertThrows(IllegalVehicleDataException.class, ()->V.setVehicleID("123a123"));
		assertThrows(IllegalVehicleDataException.class, ()->V.setVehicleID("abababa"));
		assertThrows(IllegalVehicleDataException.class, ()->V.setVehicleID("123123"));
		// owner id tests
		assertThrows(IllegalVehicleDataException.class, ()->V.setOwner_ID(""));
		assertThrows(IllegalVehicleDataException.class, ()->V.setOwner_ID("1231231231"));
		assertThrows(IllegalVehicleDataException.class, ()->V.setOwner_ID("1231231231a"));
		assertThrows(IllegalVehicleDataException.class, ()->V.setOwner_ID("123bb1131"));
		
	}

}
