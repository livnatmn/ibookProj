package boundry;

import controller.AccountController;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class ManagerGeneralUI extends WorkerGeneralUI {
	
	private JFrame frmManagerGeneralUI;
	private HideBookPanel  pnlHideBook;
	private ManageOSPanel  pnlManageOS;
	private PeriodicalReportsPanel  pnlPeridocalReports;
	private AccountController accCntrl;
	
	
	
	public ManagerGeneralUI (AccountController accCntrl)
	{
		super(accCntrl);
		frmManagerGeneralUI = super.frmWorkerGeneralUI;
		this.accCntrl=accCntrl;
		
		initialize();
		
	}

	private void initialize() {
		
		pnlPeridocalReports = new PeriodicalReportsPanel();    //  watch Periodical Reports panel
		pnlPeridocalReports.setBounds(230, 22, 501, 505); 
		pnlPeridocalReports.setVisible(false);
		frmManagerGeneralUI.getContentPane().add(pnlPeridocalReports);
		
		pnlHideBook = new HideBookPanel();    //  Hide Book panel
		pnlHideBook.setBounds(230, 22, 501, 505); 
		pnlHideBook.setVisible(false);
		frmManagerGeneralUI.getContentPane().add(pnlHideBook);
		
		pnlManageOS = new ManageOSPanel();    //  manage operating system panel
		pnlManageOS.setBounds(230, 22, 501, 505); 
		pnlManageOS.setVisible(false);
		frmManagerGeneralUI.getContentPane().add(pnlManageOS);
		
/* ************************* button of 'PeriodicalReoprts' panel *******************************/
		
		JButton btnPeriodicalReports = new JButton("Periodical Reports");
		btnPeriodicalReports.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnPeriodicalReports.setBounds(10, 162, 200, 23);
		frmManagerGeneralUI.getContentPane().add(btnPeriodicalReports);
		
		btnPeriodicalReports.addActionListener(new ActionListener() {      // show 'PeriodicalReoprts' panel if pressed
			public void actionPerformed(ActionEvent arg0) {
				pnlAddBook.setVisible(false);
				pnlRemoveBook.setVisible(false);
				pnlUpdateBook.setVisible(false);
				pnlWatchExamineReviews.setVisible(false);
				pnlPeridocalReports.setVisible(true);
				pnlHideBook.setVisible(false);
				pnlManageOS.setVisible(false);
			}
		});
		
/* ************************* button of 'HideBook' panel *******************************/
		
		JButton btnHideBook = new JButton("Hide Book");
		btnHideBook.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnHideBook.setBounds(10, 197, 200, 23);
		frmManagerGeneralUI.getContentPane().add(btnHideBook);
		
		btnHideBook.addActionListener(new ActionListener() {     
			public void actionPerformed(ActionEvent arg0) {
				pnlAddBook.setVisible(false);
				pnlRemoveBook.setVisible(false);
				pnlUpdateBook.setVisible(false);
				pnlWatchExamineReviews.setVisible(false);
				pnlPeridocalReports.setVisible(false);
				pnlHideBook.setVisible(true);
				pnlManageOS.setVisible(false);
			}
		});
		
/* ************************* button of 'ManageOS' panel *******************************/
		
		JButton btnManageOS = new JButton("Manage OS");
		btnManageOS.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnManageOS.setBounds(10, 232, 200, 23);
		frmManagerGeneralUI.getContentPane().add(btnManageOS);
		
		btnManageOS.addActionListener(new ActionListener() {   
			public void actionPerformed(ActionEvent arg0) {
				pnlAddBook.setVisible(false);
				pnlRemoveBook.setVisible(false);
				pnlUpdateBook.setVisible(false);
				pnlWatchExamineReviews.setVisible(false);
				pnlPeridocalReports.setVisible(false);
				pnlHideBook.setVisible(false);
				pnlManageOS.setVisible(true);
				
			}
		});
		/* ************************************************************************************************/
		
	}
	
}


