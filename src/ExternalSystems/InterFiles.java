package ExternalSystems;

/**
 * - This class holds the external systems paths depends the host's operating system
 *
 */
public class InterFiles {
	// Operating system path and separator
	private static final String sep = System.getProperty("file.separator");
	private static final String project_dir = System.getProperty("user.dir") + sep;
	private static final String external_systems_dir = project_dir + "src" + sep + "ExternalSystems" + sep;

	// Default images
	private static final String default_client_license_pic = external_systems_dir + "default_client_license_pic.jpg";
	private static final String default_vehicle_license_pic = external_systems_dir + "default_vehicle_license_pic.jpg";
	private static final String default_contract_pic = external_systems_dir + "default_contract.jpg";
	private static final String default_travel_photo = external_systems_dir + "default_travel_photo.jpg";

	// Data records
	private static final String clients_records = external_systems_dir + "clients.txt";
	private static final String vehicles_records = external_systems_dir + "vehicles.txt";
	private static final String travels_records = external_systems_dir + "travels.txt";

	public static String getClientRecordsPath() {
		return clients_records;
	}

	public static String getProjectDir() {
		return project_dir;
	}

	public static String getVehicleRecordsPath() {
		return vehicles_records;
	}

	public static String getTravelRecordsPath() {
		return travels_records;
	}

	public static String getDefaultClientLiceneseImagePath() {
		return default_client_license_pic;
	}

	public static String getDefaultVehicleLiceneseImagePath() {
		return default_vehicle_license_pic;
	}

	public static String getDefaultTravelPhotoPath() {
		return default_travel_photo;
	}
	
	public static String getDefaultContractImagePath() {
		return default_contract_pic;
	}

	public static String getSeparator() {
		return sep;
	}

	
	public static String getExternalSystemsDir() {
		return external_systems_dir;
	}

}
