package Model.Travels;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import DataObject.Exceptions.IllegalDataException;
import DataObject.Exceptions.IllegalTravelDataException;

class TravelTestUnit {

	@DisplayName("setters tests")
	@Test
	void Setterstest() {
		Travel T = new Travel();
		assertThrows(IllegalDataException.class,()->T.setVehicleID(null));
		assertThrows(IllegalTravelDataException.class,()->T.setVehicleID(""));
		assertThrows(IllegalTravelDataException.class,()->T.setVehicleID("1231231a"));
		assertThrows(IllegalDataException.class,()->T.setDriverID(null));
		assertThrows(IllegalTravelDataException.class,()->T.setDriverID(""));
		assertThrows(IllegalTravelDataException.class,()->T.setDriverID("1231231231"));
		assertThrows(IllegalTravelDataException.class,()->T.setDriverID("123a12312"));
		assertThrows(IllegalTravelDataException.class,()->T.setDate("12-1-1990-00-60"));
		assertThrows(IllegalTravelDataException.class,()->T.setDate("11-13-1990-1-00"));
		assertThrows(IllegalTravelDataException.class,()->T.setDate("12-1-0-1-2"));
		assertThrows(IllegalTravelDataException.class,()->T.setDate("12-1-0-24-2"));
		assertThrows(IllegalTravelDataException.class,()->T.setDate("32-1-1990-23-2"));
	}

}
