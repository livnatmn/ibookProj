package boundry;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import controller.AccountController;

public class WorkerGeneralUI extends UserWindow{

	protected JFrame frmWorkerGeneralUI;
	protected JPanel pnlAddBook;
	protected JPanel pnlRemoveBook;
	protected JPanel pnlUpdateBook;
	protected JPanel pnlWatchExamineReviews;
	protected JButton btnAddbook;
	protected JButton btnRemoveBook;
	protected JButton btnUpdateBook;
	protected JButton btnWatchReviews;
	
	public WorkerGeneralUI(AccountController accCntrl) {   /*** Create the application. */
		super(accCntrl);
		frmWorkerGeneralUI = super.frmUserWindow;
		initialize();
	}

	private void initialize() {				/*** Initialize the content of the frame. */
		pnlAddBook = new AddBookPanel();                              //  add a book panel
		pnlAddBook.setBounds(230, 22, 501, 505);  
		pnlAddBook.setVisible(false);
		frmWorkerGeneralUI.getContentPane().add(pnlAddBook);
		
		pnlRemoveBook = new RemoveBookPanel();                        //  remove exist book panel
		pnlRemoveBook.setBounds(230, 22, 501, 505); 
		pnlRemoveBook.setVisible(false);
		frmWorkerGeneralUI.getContentPane().add(pnlRemoveBook);
	    
	    pnlUpdateBook = new UpdateBookPanel();                        //  update book information panel
		pnlUpdateBook.setBounds(230, 22, 501, 505); 
		pnlUpdateBook.setVisible(false);
		frmWorkerGeneralUI.getContentPane().add(pnlUpdateBook);

		pnlWatchExamineReviews = new Watch_Examine_ReviewsPanel();    //  watch new reviews & examining reviews panels
		pnlWatchExamineReviews.setBounds(230, 22, 501, 505); 
		pnlWatchExamineReviews.setVisible(false);
		frmWorkerGeneralUI.getContentPane().add(pnlWatchExamineReviews);
		
		
		/* ***************************** button of 'Add a book' panel **********************************/
		
		btnAddbook = new JButton("Add a book");
		btnAddbook.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnAddbook.setBounds(20, 330, 179, 23);
		frmWorkerGeneralUI.getContentPane().add(btnAddbook);
		
		btnAddbook.addActionListener(new ActionListener() {           // show 'Add a book' panel if pressed
			public void actionPerformed(ActionEvent arg0) {
				pnlAddBook.setVisible(true);
				pnlRemoveBook.setVisible(false);
				pnlUpdateBook.setVisible(false);
				pnlWatchExamineReviews.setVisible(false);
				
				// user's
				pnlSrchBook.setVisible(false);
				pnlSrchReviews.setVisible(false);
				pnlStart.setVisible(false);
				pnlPayment.setVisible(false);
			}
		});
		
		/* ************************* button of 'Remove exist book' panel ********************************/
		
		btnRemoveBook = new JButton("Remove exist book");
		btnRemoveBook.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnRemoveBook.setBounds(20, 360, 179, 23);
		frmWorkerGeneralUI.getContentPane().add(btnRemoveBook);
		
		btnRemoveBook.addActionListener(new ActionListener() {       // show 'Remove exist book' panel if pressed
			public void actionPerformed(ActionEvent arg0) {
				pnlAddBook.setVisible(false);
				pnlRemoveBook.setVisible(true);
				pnlUpdateBook.setVisible(false);
				pnlWatchExamineReviews.setVisible(false);

				// user's
				pnlSrchBook.setVisible(false);
				pnlSrchReviews.setVisible(false);
				pnlStart.setVisible(false);
				pnlPayment.setVisible(false);
			}
		});
		
		/* ********************** button of 'Update book information' panel *****************************/
	
		btnUpdateBook = new JButton("Update book");
		btnUpdateBook.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnUpdateBook.setBounds(20, 390, 179, 23);
		frmWorkerGeneralUI.getContentPane().add(btnUpdateBook);
		
		btnUpdateBook.addActionListener(new ActionListener() {      // show 'Update book information' panel if pressed
			public void actionPerformed(ActionEvent arg0) {
				pnlAddBook.setVisible(false);
				pnlRemoveBook.setVisible(false);
				pnlUpdateBook.setVisible(true);
				pnlWatchExamineReviews.setVisible(false);

				// user's
				pnlSrchBook.setVisible(false);
				pnlSrchReviews.setVisible(false);
				pnlStart.setVisible(false);
				pnlPayment.setVisible(false);
			}
		});
		
		/* ************************* button of 'WatchExamineReviews' panel *******************************/
	
		btnWatchReviews = new JButton("Watch new reviews");
		btnWatchReviews.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnWatchReviews.setBounds(20, 420, 179, 23);
		frmWorkerGeneralUI.getContentPane().add(btnWatchReviews);
		
		btnWatchReviews.addActionListener(new ActionListener() {      // show 'Watch new reviews' panel if pressed
			public void actionPerformed(ActionEvent arg0) {
				pnlAddBook.setVisible(false);
				pnlRemoveBook.setVisible(false);
				pnlUpdateBook.setVisible(false);
				pnlWatchExamineReviews.setVisible(true);

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

				pnlAddBook.setVisible(false);
				pnlRemoveBook.setVisible(false);
				pnlUpdateBook.setVisible(false);
				pnlWatchExamineReviews.setVisible(false);
				

			}
		});
		
		btnSearchReviews.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				pnlAddBook.setVisible(false);
				pnlRemoveBook.setVisible(false);
				pnlUpdateBook.setVisible(false);
				pnlWatchExamineReviews.setVisible(false);
				
			}
		});
		
		btnInsertPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				pnlAddBook.setVisible(false);
				pnlRemoveBook.setVisible(false);
				pnlUpdateBook.setVisible(false);
				pnlWatchExamineReviews.setVisible(false);
				
			}
		});
	}
	
}