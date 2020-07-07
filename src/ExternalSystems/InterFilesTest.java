package ExternalSystems;


import org.junit.jupiter.api.Test;

class InterFilesTest {

	@Test
	void test() {

		System.out.println();
		System.out.println("Directory locations:");
		System.out.println("System separator:\t\t" + InterFiles.getSeparator());
		System.out.println("Project directory:\t\t" + InterFiles.getProjectDir());
		System.out.println("External systems directory:\t" + InterFiles.getExternalSystemsDir());

	
		System.out.println();
		System.out.println("Records locations:");
		System.out.println("Client records file:\t\t" + InterFiles.getClientRecordsPath());
		System.out.println("vehicle records file:\t\t" + InterFiles.getVehicleRecordsPath());
		System.out.println("travel records file:\t\t" + InterFiles.getTravelRecordsPath());
		

		System.out.println();
		System.out.println("Default images locations:");
		System.out.println("Client default license:\t\t" + InterFiles.getDefaultClientLiceneseImagePath());
		System.out.println("Vehicle default license:\t" + InterFiles.getDefaultVehicleLiceneseImagePath());
		System.out.println("Travel default photo:\t\t" + InterFiles.getDefaultTravelPhotoPath());
		System.out.println("Default contract:\t\t" + InterFiles.getDefaultContractImagePath());
		
	
		
	}
	


}
