package ExternalSystems;

import java.util.Random;

/**
 * -External System-
 *
 */
public class DMV {
	private static String[] records = { "Car,Mazda,3", "Car,Mazda,2", "Car,Mazda,6", "Car,Mazda,313",
			"Car,Toyota,Yaris", "Car,Honda,Civic","Bike,Honda,livo","Car,Honda,Civic","Truck,DAF,XF Euro 6" };


	/*
	 * Properties format: "Type,Company,Model"
	 */
	public static String getVehicleProperties(String vehicleID) {
		Random r = new Random();
		return records[r.nextInt(records.length)];
	}

}
