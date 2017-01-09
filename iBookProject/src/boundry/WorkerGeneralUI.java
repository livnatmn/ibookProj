package boundry;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;

import javax.swing.SwingConstants;

import controller.AccountController;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;

public class WorkerGeneralUI {

	protected JFrame frmWorkerGeneralUI;
	protected JPanel pnlAddBook;
	protected JPanel pnlRemoveBook;
	protected JPanel pnlUpdateBook;
	protected JPanel pnlWatchExamineReviews;
	protected JButton btnAddbook;
	protected JButton btnRemoveBook;
	protected JButton btnUpdateBook;
	protected JButton btnWatchReviews;
	private AccountController accCntrl;

	
/*	public static void main(String[] args) {			
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WorkerGeneralUI window = new WorkerGeneralUI();
					window.frmWorkerGeneralUI.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
	
	public WorkerGeneralUI(AccountController accCntrl) {   /*** Create the application. */
		this.accCntrl = accCntrl;
		initialize();
	}

	
	private void initialize() {				/*** Initialize the content of the frame. */
		
		frmWorkerGeneralUI = new JFrame();
		frmWorkerGeneralUI.setTitle("iBook - Librarian Window");
		frmWorkerGeneralUI.getContentPane().setBackground(Color.WHITE);
		frmWorkerGeneralUI.setBounds(100, 100, 750, 898);
		frmWorkerGeneralUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWorkerGeneralUI.getContentPane().setLayout(null); 
		frmWorkerGeneralUI.setVisible(true);
		
		
		frmWorkerGeneralUI.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		        if (JOptionPane.showConfirmDialog(frmWorkerGeneralUI, 
		            "Are you sure to close this window?", "Really Closing?", 
		            JOptionPane.YES_NO_OPTION,
		            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
			    		LogingOut();
			            System.exit(0); 
		        	}
		        else // NO_OPTION
		        	frmWorkerGeneralUI.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		    }
		});
		
		
		JLabel lblSignPic = new JLabel("");
		lblSignPic.setHorizontalAlignment(SwingConstants.CENTER);
		Image img = new ImageIcon(this.getClass().getResource("/logo2.jpg")).getImage();
		lblSignPic.setIcon(new ImageIcon(img));
		lblSignPic.setForeground(Color.WHITE);
		lblSignPic.setBackground(Color.WHITE);
		lblSignPic.setBounds(10, 11, 210, 204);
		frmWorkerGeneralUI.getContentPane().add(lblSignPic);
		
		JPanel pnlStart = new WelcomePanel(accCntrl.usr.GetUserName());
		pnlStart.setBounds(230, 22, 352, 430);
		pnlStart.setVisible(true);
		frmWorkerGeneralUI.getContentPane().add(pnlStart);
		
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
		btnAddbook.setBounds(20, 243, 179, 23);
		frmWorkerGeneralUI.getContentPane().add(btnAddbook);
		
		btnAddbook.addActionListener(new ActionListener() {           // show 'Add a book' panel if pressed
			public void actionPerformed(ActionEvent arg0) {
				pnlStart.setVisible(false);
				pnlAddBook.setVisible(true);
				pnlRemoveBook.setVisible(false);
				pnlUpdateBook.setVisible(false);
				pnlWatchExamineReviews.setVisible(false);
			}
		});
		
		/* ************************* button of 'Remove exist book' panel ********************************/
		
		btnRemoveBook = new JButton("Remove exist book");
		btnRemoveBook.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnRemoveBook.setBounds(20, 277, 181, 23);
		frmWorkerGeneralUI.getContentPane().add(btnRemoveBook);
		
		btnRemoveBook.addActionListener(new ActionListener() {       // show 'Remove exist book' panel if pressed
			public void actionPerformed(ActionEvent arg0) {
				pnlStart.setVisible(false);
				pnlAddBook.setVisible(false);
				pnlRemoveBook.setVisible(true);
				pnlUpdateBook.setVisible(false);
				pnlWatchExamineReviews.setVisible(false);
			}
		});
		
		/* ********************** button of 'Update book information' panel *****************************/
	
		btnUpdateBook = new JButton("Update book");
		btnUpdateBook.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnUpdateBook.setBounds(20, 313, 179, 23);
		frmWorkerGeneralUI.getContentPane().add(btnUpdateBook);
		
		btnUpdateBook.addActionListener(new ActionListener() {      // show 'Update book information' panel if pressed
			public void actionPerformed(ActionEvent arg0) {
				pnlStart.setVisible(false);
				pnlAddBook.setVisible(false);
				pnlRemoveBook.setVisible(false);
				pnlUpdateBook.setVisible(true);
				pnlWatchExamineReviews.setVisible(false);
			}
		});
		
		/* ************************* button of 'WatchExamineReviews' panel *******************************/
	
		btnWatchReviews = new JButton("Watch new reviews");
		btnWatchReviews.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnWatchReviews.setBounds(20, 347, 179, 23);
		frmWorkerGeneralUI.getContentPane().add(btnWatchReviews);
		
		btnWatchReviews.addActionListener(new ActionListener() {      // show 'Watch new reviews' panel if pressed
			public void actionPerformed(ActionEvent arg0) {
				pnlStart.setVisible(false);
				pnlAddBook.setVisible(false);
				pnlRemoveBook.setVisible(false);
				pnlUpdateBook.setVisible(false);
				pnlWatchExamineReviews.setVisible(true);
			}
		});
		
		/* ************************************************************************************************/
	
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LogingOut();
				
				new Login();
				frmWorkerGeneralUI.dispose();
			}
		});
		btnLogout.setBounds(10, 206, 74, 23);
		frmWorkerGeneralUI.getContentPane().add(btnLogout);
		
	}
	
	
	
	private void LogingOut(){
		// update connected = false
		accCntrl.usr.SetConnect(false);
		accCntrl.UpdateConnected(accCntrl.usr.GetUserName(), false);
	}
}