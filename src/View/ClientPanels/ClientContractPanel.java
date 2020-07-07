package View.ClientPanels;

import javax.swing.JPanel;

import javax.swing.JSplitPane;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ClientContractPanel extends JPanel {

	private JLabel lblLicense;
	private JLabel lblContract;

	/**
	 * Create the panel.
	 */
	public ClientContractPanel() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.7);
		add(splitPane);
		
		lblLicense = new JLabel("");
		lblLicense.setHorizontalAlignment(SwingConstants.CENTER);
		splitPane.setLeftComponent(lblLicense);
		
		JPanel panel = new JPanel();
		splitPane.setRightComponent(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JButton btnOpenContract = new JButton("Open Contract");
		panel_1.add(btnOpenContract);
		btnOpenContract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openContract(e);
			}
		});
		
		lblContract = new JLabel("");
		

	}

	public void setLicenseImage(ImageIcon license_image) {
		lblLicense.setIcon(license_image);
		
	}

	public void setContractCopy(ImageIcon contract_image) {
		lblContract.setIcon(contract_image);
	}
	
	private void openContract(ActionEvent e) {
		JOptionPane.showMessageDialog((Component)e.getSource(), lblContract, "Contract", JOptionPane.OK_OPTION);	
	}
	


}
