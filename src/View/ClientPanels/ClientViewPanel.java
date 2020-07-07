package View.ClientPanels;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class ClientViewPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ClientViewPanel(String data,ImageIcon image_icon) {
		setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.5);
		add(splitPane);
		
		JLabel lblLicense = new JLabel("");
		lblLicense.setHorizontalAlignment(SwingConstants.CENTER);
		lblLicense.setIcon(image_icon);
		splitPane.setRightComponent(lblLicense);
		
		JTextPane txtrDfs = new JTextPane();
		txtrDfs.setForeground(Color.BLACK);
		txtrDfs.setBackground(Color.LIGHT_GRAY);
		txtrDfs.setText(data);
		txtrDfs.setFont(new Font("Courier New", Font.BOLD, 12));
		txtrDfs.setEditable(false);
		splitPane.setLeftComponent(txtrDfs);

	}

}
