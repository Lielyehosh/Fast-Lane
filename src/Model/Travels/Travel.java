package Model.Travels;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import DataObject.DataObject;
import DataObject.Exceptions.IllegalDataException;
import DataObject.Exceptions.IllegalTravelDataException;

public class Travel implements DataObject {
	private String vehicleID;
	private String driverID;
	private LocalDateTime date;
	private static DateTimeFormatter print_format = DateTimeFormatter.ofPattern("dd/MM/YYYY-HH:mm");
	private static DateTimeFormatter save_format = DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm");
	private static final int Num_Of_Fields = 3;

	public Travel() {

	}

	public String getVehicleID() {
		return vehicleID;
	}

	public String getDriverID() {
		return driverID;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setVehicleID(String vehicleID) throws IllegalDataException {
		if (vehicleID == null) {
			throw new IllegalDataException("vehicleID is null");
		} else if (vehicleID.matches("\\d{8}") == false && vehicleID.matches("\\d{7}") == false) {
			throw new IllegalTravelDataException("Vehicle ID", "Vehicle ID is illegal");
		}
		this.vehicleID = vehicleID;
	}

	public void setDriverID(String driverID) throws IllegalDataException {
		if (driverID == null) {
			throw new IllegalDataException("driverID is null");
		} else if (driverID.matches("\\d{9}") == false) {
			throw new IllegalTravelDataException("Driver ID", "Driver ID is illegal");
		}
		this.driverID = driverID;
	}

	public void setDate(LocalDateTime date) throws IllegalDataException {
		this.date = date;
	}

	/**
	 * @param date: Format is "day,month,year,hour,minute"
	 * @throws IllegalDataException
	 */
	public void setDate(String date) throws IllegalDataException {
		String[] fields = date.split("-");
		if (fields.length != 5) {
			throw new IllegalDataException("Missing date fields");
		}
		int day = Integer.parseInt(fields[0]);
		if (day <= 0) {
			throw new IllegalTravelDataException("Date", "Day is illegal ");
		}
		int month = Integer.parseInt(fields[1]);
		if (month <= 0) {
			throw new IllegalTravelDataException("Date", "Month is illegal ");
		}
		int year = Integer.parseInt(fields[2]);
		if (year <= 0) {
			throw new IllegalTravelDataException("Date", "Year is illegal ");
		}
		int hour = Integer.parseInt(fields[3]);
		if (hour < 0 || hour > 23) {
			throw new IllegalTravelDataException("Date", "Hour is illegal ");
		}
		int min = Integer.parseInt(fields[4]);
		if (min < 0 || min > 59) {
			throw new IllegalTravelDataException("Date", "Minute is illegal ");
		}
		try {
			setDate(LocalDateTime.of(year, month, day, hour, min));
		} catch (DateTimeException e) {
			throw new IllegalTravelDataException("Date",e.getMessage());
		}
	}

	@Override
	public String toString() {
		return date.format(print_format) + "  " + getVehicleID() + "-" + getDriverID();
	}

	@Override
	public String print() {
		return "Date: " + date.format(print_format) + "\n" + "Vehicle ID number: " + getVehicleID() + "\n"
				+ "Driver ID number: " + getDriverID();
	}
	
	@Override
	public String save() {
		return getVehicleID() + "," + getDriverID() + "," + date.format(save_format);
	}
	
	@Override
	public void load(String data) throws IllegalDataException {
		if (data == null) {
			throw new IllegalDataException("data is null");
		}
		String[] fields = data.split(",");
		if (fields.length != Num_Of_Fields) {
			throw new IllegalDataException("Missing fields");
		}
		setDriverID(fields[0]);
		setVehicleID(fields[1]);
		setDate(fields[2]);
	}

	@Override
	public String getIdentifier() {
		return date.toString() + getVehicleID();
	}

}
