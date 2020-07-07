package View.TravelPanels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class TravelViewPanel extends JPanel {

	private JLabel lblDatetime;
	private JLabel lblTravelphoto;

	/**
	 * Create the panel.
	 */
	public TravelViewPanel() {
		setLayout(new BorderLayout(0, 0));
		
		lblTravelphoto = new JLabel("");
		lblTravelphoto.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblTravelphoto, BorderLayout.CENTER);
		
		lblDatetime = new JLabel("DateTime");
		lblDatetime.setForeground(Color.RED);
		lblDatetime.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblDatetime.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblDatetime, BorderLayout.SOUTH);

	}
	
	public void setTravelPhoto(ImageIcon image_icon) {
		lblTravelphoto.setIcon(image_icon);
	}
	
	public void setTravelDateTime(LocalDateTime date) {
		lblDatetime.setText(date.format(DateTimeFormatter.ofPattern("MMM dd - YYYY    HH:mm")));
	}

}
