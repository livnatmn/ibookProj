package boundry;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class RegistWindow {

	private JFrame frmRegistWindow;
	private RegistPanel pnlRegist;
	
	/**
	 * Create the application.
	 */	
	public RegistWindow() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistWindow = new JFrame();
		frmRegistWindow.setTitle("iBook - Registration Window");
		frmRegistWindow.getContentPane().setBackground(Color.WHITE);
		frmRegistWindow.setBounds(100, 100, 677, 513);
	//	frmRegistWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); ////
		frmRegistWindow.getContentPane().setLayout(null);

		pnlRegist = new RegistPanel();
		pnlRegist.setBounds(230, 22, 352, 333);
		pnlRegist.setVisible(true);
		frmRegistWindow.getContentPane().add(pnlRegist);
		
		JPanel panel = new JPanel();
		panel.setBounds(230, 355, 352, 31);
		frmRegistWindow.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login();
				frmRegistWindow.dispose();
			}
		});
		btnCancel.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		btnCancel.setBounds(252, 0, 84, 23);
		panel.add(btnCancel);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pnlRegist.ToSend())
				{
					new Login();
					frmRegistWindow.dispose();
				}
			}
		});
		btnSend.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		btnSend.setBounds(158, 0, 84, 23);
		panel.add(btnSend);
	//	pnlStart.setBackground(Color.YELLOW);
			
		frmRegistWindow.setVisible(true);
	
		frmRegistWindow.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		        if (JOptionPane.showConfirmDialog(frmRegistWindow, 
		            "Are you sure to close this window?", "Really Closing?", 
		            JOptionPane.YES_NO_OPTION,
		            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
			            System.exit(0); 
		        	}
		        else // NO_OPTION
		        	frmRegistWindow.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		    }
		});
	}
}
