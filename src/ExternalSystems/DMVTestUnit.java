package ExternalSystems;



import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DMVTestUnit {

	@DisplayName("Randomity tests")
	@Test
	/**
	 * This tests useful just to see that the DMV is choosing random values
	 */
	void test() {
		System.out.println(DMV.getVehicleProperties(""));
		System.out.println(DMV.getVehicleProperties(""));
		System.out.println(DMV.getVehicleProperties(""));
		System.out.println(DMV.getVehicleProperties(""));
		System.out.println(DMV.getVehicleProperties(""));
		System.out.println(DMV.getVehicleProperties(""));
		System.out.println(DMV.getVehicleProperties(""));
		System.out.println(DMV.getVehicleProperties(""));
	}

}
