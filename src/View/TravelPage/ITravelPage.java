package View.TravelPage;

import java.awt.event.ActionListener;
import java.time.LocalDateTime;

import javax.swing.ImageIcon;




public interface ITravelPage {
	public void setTravelDate(LocalDateTime date);
	public void addOpenVehiclePageBtnListener(ActionListener listener);
	public void addOpenDriverPageBtnListener(ActionListener listener);
	public void addSendBillsBtnListener(ActionListener listener);
	public void setVehiclePanel(String data,ImageIcon image_icon);
	public void setDriverPanel(String data,ImageIcon image_icon);
	public void setTravelPhoto(ImageIcon image_icon);
	
	public void updatePanel();
	
}
