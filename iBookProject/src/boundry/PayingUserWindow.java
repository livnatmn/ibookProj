package boundry;

import controller.AccountController;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;

public class PayingUserWindow extends UserWindow {

	private JFrame frmPayingUserWindow;
	private JPanel pnlprchsSub;
	private JButton btnPurchaseSubscription;

	public PayingUserWindow(AccountController accCntrl) {
		super(accCntrl);
		frmPayingUserWindow = super.frmUserWindow;
		payingInitialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void payingInitialize() {
		
		pnlprchsSub = new purchaseSubscriptionPanel(accCntrl,pnlprchsSub);
		pnlprchsSub.setBounds(230, 22, 352, 430);
		pnlprchsSub.setVisible(false);
		frmPayingUserWindow.getContentPane().add(pnlprchsSub);
			
		btnPurchaseSubscription = new JButton("buy subscription");
		btnPurchaseSubscription.setEnabled(true);
		btnPurchaseSubscription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlprchsSub.setVisible(true);
				
				// user's
				pnlSrchBook.setVisible(false);
				pnlSrchReviews.setVisible(false);
				pnlPayment.setVisible(false);
				pnlStart.setVisible(false);
			
			}
		});
		btnPurchaseSubscription.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnPurchaseSubscription.setBounds(20, 347, 179, 23);
		pnlprchsSub.setVisible(false);
		frmPayingUserWindow.getContentPane().add(btnPurchaseSubscription);
		
		
		// ## user's handlers
		btnSrchBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pnlprchsSub.setVisible(false);
			}
		});
		
		
		btnSearchReviews.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pnlprchsSub.setVisible(false);
			}
		});
		
		btnInsertPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlprchsSub.setVisible(false);
			}
		});
	}
	
}
