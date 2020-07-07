package ExternalSystems;



import static org.junit.Assert.fail;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class ImagesTest {

	@DisplayName("Default client license image")
	@Test
	void DefaultClientLicensetest() {
		Image image = Images.getDefaultClientLicense();
		if (image == null) {
			fail("default client license returned as null");
		}
		JOptionPane.showMessageDialog(null, new ImageIcon(image), "Test Client License image", JOptionPane.DEFAULT_OPTION);
	}
	
	@DisplayName("Default vehicle license image")
	@Test
	void DefaultVehicleLicensetest() {
		Image image = Images.getDefaultVehicleLicense();
		if (image == null) {
			fail("default vehicle license returned as null");
		}
		JOptionPane.showMessageDialog(null, new ImageIcon(image), "Test Vehicle License image", JOptionPane.DEFAULT_OPTION);
	}
	
	@DisplayName("Default contract license image")
	@Test
	void DefaultContracttest() {
		Image image = Images.getDefaultContract();
		if (image == null) {
			fail("default contract returned as null");
		}
		JOptionPane.showMessageDialog(null, new ImageIcon(image), "Test Contract image", JOptionPane.DEFAULT_OPTION);
	}
	
	@DisplayName("Default travel photograph")
	@Test
	void DefaultTravelPhototest() {
		Image image = Images.getDefaultTravelPhoto();
		if (image == null) {
			fail("default travel photograph returned as null");
		}
		JOptionPane.showMessageDialog(null, new ImageIcon(image), "Test Travel Photograph", JOptionPane.DEFAULT_OPTION);
	}
}
