package boundry;

import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import controller.AccountController;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class UserWindow {
	protected JFrame frmUserWindow;
	protected JPanel pnlStart;
	protected JPanel pnlSrchBook;
	protected JPanel pnlSrchReviews;
	protected InsertPaymentPanel pnlPayment;
	protected AccountController accCntrl;
	
	protected JButton btnSrchBook;
	protected JButton btnSearchReviews;
	protected JButton btnLogout;
	protected JButton btnInsertPayment;

	public UserWindow(AccountController accCntrl) {
		this.accCntrl = accCntrl;
		initialize();
	}
	

	private void initialize() {
		frmUserWindow = new JFrame();
		frmUserWindow.setTitle("iBook - User Window");
		frmUserWindow.getContentPane().setBackground(Color.WHITE);
		frmUserWindow.setBounds(100, 100, 677, 855);
		frmUserWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUserWindow.getContentPane().setLayout(null);

		JLabel lblSignPic = new JLabel("");
		lblSignPic.setHorizontalAlignment(SwingConstants.CENTER);
		Image img = new ImageIcon(this.getClass().getResource("/logo2.jpg")).getImage();
		lblSignPic.setIcon(new ImageIcon(img));
		lblSignPic.setForeground(Color.WHITE);
		lblSignPic.setBackground(Color.WHITE);
		lblSignPic.setBounds(10, 11, 210, 204);
		frmUserWindow.getContentPane().add(lblSignPic);
		
		pnlSrchBook = new SearchBookPanel();
		pnlSrchBook.setBounds(230, 22, 352, 430);
		pnlSrchBook.setVisible(false);
		frmUserWindow.getContentPane().add(pnlSrchBook);
			
		pnlSrchReviews = new SearchReviewsPanel();
		pnlSrchReviews.setBounds(230, 22, 352, 430);
		pnlSrchReviews.setVisible(false);
		frmUserWindow.getContentPane().add(pnlSrchReviews);
		
		pnlStart = new WelcomePanel(accCntrl.usr.GetUserName());
		pnlStart.setBounds(230, 22, 352, 430);
		pnlStart.setVisible(true);
		frmUserWindow.getContentPane().add(pnlStart);
		
		btnSrchBook = new JButton("Search Book");
		btnSrchBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pnlSrchBook.setVisible(true);
				pnlSrchReviews.setVisible(false);
				pnlPayment.setVisible(false);
				pnlStart.setVisible(false);
			}
		});
		btnSrchBook.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnSrchBook.setBounds(20, 240, 179, 23);
		frmUserWindow.getContentPane().add(btnSrchBook);
		
		btnSearchReviews = new JButton("Search Reviews");
		btnSearchReviews.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pnlSrchBook.setVisible(false);
				pnlSrchReviews.setVisible(true);
				pnlPayment.setVisible(false);
				pnlStart.setVisible(false);
			}
		});
		btnSearchReviews.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnSearchReviews.setBounds(20, 270, 179, 23);
		pnlSrchReviews.setVisible(false);
		frmUserWindow.getContentPane().add(btnSearchReviews);
		
		pnlPayment = new InsertPaymentPanel();
		pnlPayment.setBounds(230, 22, 352, 430);
		pnlPayment.setVisible(false);
		frmUserWindow.getContentPane().add(pnlPayment);
			
		btnInsertPayment = new JButton("Insert payment");
		btnInsertPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlSrchBook.setVisible(false);
				pnlSrchReviews.setVisible(false);
				pnlPayment.setVisible(true);
				pnlStart.setVisible(false);
			}
		});
		btnInsertPayment.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnInsertPayment.setBounds(20, 300, 179, 23);
		frmUserWindow.getContentPane().add(btnInsertPayment);
		
		btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LogingOut();
				
				new Login();
				frmUserWindow.dispose();
			}
		});
		btnLogout.setBounds(10, 209, 74, 23);
		frmUserWindow.getContentPane().add(btnLogout);
		
		frmUserWindow.setVisible(true);
		frmUserWindow.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		        if (JOptionPane.showConfirmDialog(frmUserWindow, 
		            "Are you sure to close this window?", "Really Closing?", 
		            JOptionPane.YES_NO_OPTION,
		            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
			    		LogingOut();
			            System.exit(0); 
		        	}
		        else // NO_OPTION
		        	frmUserWindow.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		    }
		});
	}
	
	private void LogingOut(){
		// update connected = false
		accCntrl.usr.SetConnect(false);
		accCntrl.UpdateConnected(accCntrl.usr.GetUserName(), false);
	}
}
