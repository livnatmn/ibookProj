package boundry;

import controller.AccountController;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LibrarianGeneralUI extends WorkerGeneralUI {
	
	private JFrame frmLibrarianGeneralUI;
	private CheckPendingUsersPanel pnlCheckPendingUsers;
	private ArrangePaymentPanel pnlArrangePayment;
	private UpdateUserInfoPanel pnlUpdateUserInfo;
	private OrganizeInventoryBooksPanel pnlOrganizeBooks;
    private AccountController accCntrl;
	
	
	/* Create the application. */
	public LibrarianGeneralUI(AccountController accCntrl) {
		super(accCntrl);
		frmLibrarianGeneralUI = super.frmWorkerGeneralUI;
		this.accCntrl=accCntrl;
		//sbscrptnCntrl=new SubscriptionController();
	
		initialize();
	}
	



	/* Initialize the contents of the frame.*/
	private void initialize() {
	
	
	
/*-*********************** Create new Check Pending Users Panel & Button *******************************/	
	
	pnlCheckPendingUsers = new CheckPendingUsersPanel();                   
	pnlCheckPendingUsers.setBounds(230, 22, 501, 505);
	pnlCheckPendingUsers.setVisible(false);
	frmLibrarianGeneralUI.getContentPane().add(pnlCheckPendingUsers);
	
	JButton btncheckpenduser = new JButton("Check Pending Users");
	btncheckpenduser.setFont(new Font("Tahoma", Font.BOLD, 13));
	btncheckpenduser.setBounds(20, 450, 179, 23);
	frmLibrarianGeneralUI.getContentPane().add(btncheckpenduser);
	
	btncheckpenduser.addActionListener(new ActionListener() {       
		public void actionPerformed(ActionEvent arg0) {
			pnlAddBook.setVisible(false);
			pnlRemoveBook.setVisible(false);
			pnlUpdateBook.setVisible(false);
			//frmLibrarianGeneralUI.setVisible(false);
			pnlWatchExamineReviews.setVisible(false);
			pnlArrangePayment.setVisible(false);
			pnlCheckPendingUsers.setVisible(true);
			pnlUpdateUserInfo.setVisible(false);
			pnlOrganizeBooks.setVisible(false);
		}
	});
	
/*-******************** Create Arrange Payment Panel & Button ******************************/
	
	pnlArrangePayment = new ArrangePaymentPanel();                       
	pnlArrangePayment.setBounds(230, 22, 501, 505);
	pnlArrangePayment.setVisible(false);
	frmLibrarianGeneralUI.getContentPane().add(pnlArrangePayment);
	
	JButton btnArrangePayment = new JButton("Arrange Payment");
	btnArrangePayment.setFont(new Font("Tahoma", Font.BOLD, 13));
	btnArrangePayment.setBounds(20, 480, 179, 23);
	frmLibrarianGeneralUI.getContentPane().add(btnArrangePayment);

	
	btnArrangePayment.addActionListener(new ActionListener() {           
		public void actionPerformed(ActionEvent arg0) {
			pnlAddBook.setVisible(false);
			pnlRemoveBook.setVisible(false);
			pnlUpdateBook.setVisible(false);
			//frmLibrarianGeneralUI.setVisible(false);
			pnlWatchExamineReviews.setVisible(false);
			pnlCheckPendingUsers.setVisible(false);
			pnlArrangePayment.setVisible(true);
			pnlUpdateUserInfo.setVisible(false);
			pnlOrganizeBooks.setVisible(false);
		}
	});
	
/*-************************** Update User Information Panel & Button *********************************/
	
	pnlUpdateUserInfo = new UpdateUserInfoPanel();                       
	pnlUpdateUserInfo.setBounds(230, 22, 501, 505);
	pnlUpdateUserInfo.setVisible(false);
	frmLibrarianGeneralUI.getContentPane().add(pnlUpdateUserInfo);
	
	JButton btnUpdateUser = new JButton("Update User Information");
	btnUpdateUser.setFont(new Font("Tahoma", Font.BOLD, 13));
	btnUpdateUser.setBounds(20, 510, 179, 23);
	frmLibrarianGeneralUI.getContentPane().add(btnUpdateUser);
	
	
	btnUpdateUser.setVisible(true);
	//System.out.println("test");
	btnUpdateUser.addActionListener(new ActionListener() {           
		public void actionPerformed(ActionEvent arg0) {
			pnlAddBook.setVisible(false);
			pnlRemoveBook.setVisible(false);
			pnlUpdateBook.setVisible(false);
			pnlWatchExamineReviews.setVisible(false);
			//frmLibrarianGeneralUI.setVisible(false);
			pnlCheckPendingUsers.setVisible(false);
			pnlArrangePayment.setVisible(false);
			pnlUpdateUserInfo.setVisible(true);
			pnlOrganizeBooks.setVisible(false);
		}
	});
	
/*-************************Organize the inventory books Panel & Button *********************************/
	
	pnlOrganizeBooks = new OrganizeInventoryBooksPanel();                       
	pnlOrganizeBooks.setBounds(230, 22, 501, 505);
	pnlOrganizeBooks.setVisible(false);
	frmLibrarianGeneralUI.getContentPane().add(pnlOrganizeBooks);
	
	JButton btnOrganizeInventory  = new JButton("Organize inventory books");
	btnOrganizeInventory.setFont(new Font("Tahoma", Font.BOLD, 13));
	btnOrganizeInventory.setBounds(20, 540, 179, 23);
	frmLibrarianGeneralUI.getContentPane().add(btnOrganizeInventory);
	
	
	btnOrganizeInventory.setVisible(true);
	//System.out.println("test");
	btnOrganizeInventory.addActionListener(new ActionListener() {           
		public void actionPerformed(ActionEvent arg0) {
			pnlAddBook.setVisible(false);
			pnlRemoveBook.setVisible(false);
			pnlUpdateBook.setVisible(false);
			pnlWatchExamineReviews.setVisible(false);
			//frmLibrarianGeneralUI.setVisible(false);
			pnlCheckPendingUsers.setVisible(false);
			pnlArrangePayment.setVisible(false);
			pnlUpdateUserInfo.setVisible(false);
			pnlOrganizeBooks.setVisible(true);
			
		}
	});
	
	
	
	
	
  
	
 /*________________________ Add action listener on buttons of workeFream __________________________*/
   
	   btnAddbook.addActionListener(new ActionListener() {           // show 'Add a book' panel if pressed
		public void actionPerformed(ActionEvent arg0) {
//			pnlAddBook.setVisible(true);
//			pnlRemoveBook.setVisible(false);
//			pnlUpdateBook.setVisible(false);
//			pnlWatchExamineReviews.setVisible(false);
			//frmLibrarianGeneralUI.setVisible(false);
			pnlCheckPendingUsers.setVisible(false);
			pnlArrangePayment.setVisible(false);
			pnlUpdateUserInfo.setVisible(false);
			pnlOrganizeBooks.setVisible(false);
			
			// user's
			pnlSrchBook.setVisible(false);
			pnlSrchReviews.setVisible(false);
			pnlStart.setVisible(false);
			pnlPayment.setVisible(false);
		}
	});
	   
		btnRemoveBook.addActionListener(new ActionListener() {       // show 'Remove exist book' panel if pressed
			public void actionPerformed(ActionEvent arg0) {
//				pnlAddBook.setVisible(false);
//				pnlRemoveBook.setVisible(true);
//				pnlUpdateBook.setVisible(false);
//				pnlWatchExamineReviews.setVisible(false);
				//frmLibrarianGeneralUI.setVisible(false);
				pnlCheckPendingUsers.setVisible(false);
				pnlArrangePayment.setVisible(false);
				pnlUpdateUserInfo.setVisible(false);
				pnlOrganizeBooks.setVisible(false);

				// user's
				pnlSrchBook.setVisible(false);
				pnlSrchReviews.setVisible(false);
				pnlStart.setVisible(false);
				pnlPayment.setVisible(false);
			}
		});
		
		btnUpdateBook.addActionListener(new ActionListener() {      // show 'Update book information' panel if pressed
			public void actionPerformed(ActionEvent arg0) {
//				pnlAddBook.setVisible(false);
//				pnlRemoveBook.setVisible(false);
//				pnlUpdateBook.setVisible(true);
//				pnlWatchExamineReviews.setVisible(false);
				//frmLibrarianGeneralUI.setVisible(false);
				pnlCheckPendingUsers.setVisible(false);
				pnlArrangePayment.setVisible(false);
				pnlUpdateUserInfo.setVisible(false);
				pnlOrganizeBooks.setVisible(false);

				// user's
				pnlSrchBook.setVisible(false);
				pnlSrchReviews.setVisible(false);
				pnlStart.setVisible(false);
				pnlPayment.setVisible(false);
			}
		});
		
		btnWatchReviews.addActionListener(new ActionListener() {      // show 'Watch new reviews' panel if pressed
			public void actionPerformed(ActionEvent arg0) {
//				pnlAddBook.setVisible(false);
//				pnlRemoveBook.setVisible(false);
//				pnlUpdateBook.setVisible(false);
//				pnlWatchExamineReviews.setVisible(true);
				////frmLibrarianGeneralUI.setVisible(true);
				pnlCheckPendingUsers.setVisible(false);
				pnlArrangePayment.setVisible(false);
				pnlUpdateUserInfo.setVisible(false);
				pnlOrganizeBooks.setVisible(false);

				// user's
				pnlSrchBook.setVisible(false);
				pnlSrchReviews.setVisible(false);
				pnlStart.setVisible(false);
				pnlPayment.setVisible(false);
			}
		});
		
		
		// ### user's actions ###
		
		btnSrchBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pnlCheckPendingUsers.setVisible(false);
				pnlArrangePayment.setVisible(false);
				pnlUpdateUserInfo.setVisible(false);
				pnlOrganizeBooks.setVisible(false);
			}
		});
		
		btnSearchReviews.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pnlCheckPendingUsers.setVisible(false);
				pnlArrangePayment.setVisible(false);
				pnlUpdateUserInfo.setVisible(false);
				pnlOrganizeBooks.setVisible(false);
			}
		});
		
		btnInsertPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlCheckPendingUsers.setVisible(false);
				pnlArrangePayment.setVisible(false);
				pnlUpdateUserInfo.setVisible(false);
				pnlOrganizeBooks.setVisible(false);
			}
		});
	}
	
}
	


