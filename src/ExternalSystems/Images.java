package ExternalSystems;

import java.awt.Image;
import java.awt.Toolkit;


/**
 * *EXTERNAL SYSTEM*
 *
 */
public class Images {
	private static Image default_vehicle_license= getImageByPath(InterFiles.getDefaultVehicleLiceneseImagePath());;
	private static Image default_client_license= getImageByPath(InterFiles.getDefaultClientLiceneseImagePath());;
	private static Image default_travel_photo = getImageByPath(InterFiles.getDefaultTravelPhotoPath());
	private static Image default_contract = getImageByPath(InterFiles.getDefaultContractImagePath());

	

	public static Image getDefaultClientLicense() {
		return default_client_license;
	}

	public static Image getDefaultVehicleLicense() {
		return default_vehicle_license;
	}
	
	public static Image getDefaultTravelPhoto() {
		return default_travel_photo;
	}
	
	public static Image getDefaultContract() {
		return default_contract;
	}

	public static Image getImageByPath(String path) {
		return Toolkit.getDefaultToolkit().createImage(path);
	}

}
