package ExternalSystems;

import java.awt.Image;
import java.util.Vector;

/**
 * - Images its a temporary class, It can be replaced as an 'images database'
 * without reflecting the system - Same as Images class, DMV and the inner files
 * can be replaced as well.
 */
public class Database {

	/**
	 * Communicating with external files.
	 */
	public static Vector<String> loadData(String type) {
		/**
		 * Input: "type" of the data is to be loaded Output: Vector which contains all
		 * the records of this "type" data
		 */
		switch (type) {
		case "clients":
			return FileUtils.fileReader(InterFiles.getClientRecordsPath());
		case "vehicles":
			return FileUtils.fileReader(InterFiles.getVehicleRecordsPath());
		case "travels":
			return FileUtils.fileReader(InterFiles.getTravelRecordsPath());
		default:
			return null;
		}
	}

	/**
	 * Communicating with Images.
	 */
	public static Image getClientLicenseCopy(String client_id) {
		return Images.getDefaultClientLicense();
	}

	/**
	 * Communicating with Images.
	 */
	public static Image getVehicleLicenseCopy(String vehicle_id) {
		return Images.getDefaultVehicleLicense();
	}

	/**
	 * Communicating with DMV.
	 */
	public static String getNewVehicleProperties(String vehicle_id) {
		/**
		 * This method gets as an input some vehicle id. The Database ask the DMV for
		 * the details of this vehicle: - Vehicle's company (For example "Toyota") -
		 * Vehicle's type (For example "Car") - Vehicle's model (For example "Yaris")
		 * Those details return as a String to the object who call this method.
		 */
		return DMV.getVehicleProperties(vehicle_id);
	}

	/**
	 * Communicating with external files AND CAN BE CHANGE SOME DATA.
	 */
	public static void saveData(String type, Vector<String> data_lines) {
		switch (type) {
		case "clients":
			FileUtils.fileWriter(InterFiles.getClientRecordsPath(), data_lines);
			break;
		case "vehicles":
			FileUtils.fileWriter(InterFiles.getVehicleRecordsPath(), data_lines);
			break;
		default:
			break;
		}
	}

	/**
	 * Communicating with Images.
	 */
	public static Image getTravelPhotograph(String travel_id) {
		return Images.getDefaultTravelPhoto();
	}

	/**
	 * Communicating with Images.
	 */
	public static Image getClientContract(String client_id) {
		return Images.getDefaultContract();
	}

}
