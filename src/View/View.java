package View;

import java.awt.BorderLayout;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JButton;

@SuppressWarnings("serial")
public class View extends JFrame implements IView{

	private JPanel contentPane;
	private JPanel centerPanel;
	private JButton btnBackToMain;

	

	/**
	 * Create the frame.
	 */
	public View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 817, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		btnBackToMain = new JButton("Back to main page");
		contentPane.add(btnBackToMain, BorderLayout.SOUTH);
		
		
	}
	
	
	public void setCenterPanel(JPanel panel) {
		if (centerPanel != null)
			contentPane.remove(centerPanel);
		centerPanel = panel;
		contentPane.add(centerPanel,BorderLayout.CENTER);
		
		this.setVisible(true);
	}
	
	

	public void setTitle(String title) {
		super.setTitle(title);
	}
	
	public void addMainBtnListener(ActionListener mainBtnListener) {
		btnBackToMain.addActionListener(mainBtnListener);
	}

	public void displayDialogMsg(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}

	public JPanel getCenterPanel() {
		return centerPanel;
	}

}
