package boundry;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;


public class Watch_Examine_ReviewsPanel extends JPanel{

	private JTextField textF_Date;
	private JTextField textF_BookName;
	private JTextField textF_Reviewer;
	
	private static final long serialVersionUID = 1L;
	private JTable table_pendReviews;
	private JScrollPane scrollPane_PendRevTable;	
	
	public Watch_Examine_ReviewsPanel() {          // Constructor
	
		initialize();
	}
	
	
	private void initialize() {
		setLayout(null);
		 
/* ___________________________________________________________________________________________________________________________ EXAMINING REVIEW */
		
		/* *********************** label of '(Watch New Reviews)' *****************************/	
		
		JLabel lbl_WatchNewReviews2 = new JLabel("(Watch New Reviews)\t");
		lbl_WatchNewReviews2.setBounds(3, 3, 132, 14);
		add(lbl_WatchNewReviews2);
		lbl_WatchNewReviews2.setVisible(false);		
		
		/* ************************ label of 'Examining Review' *******************************/		    
	    
		JLabel lblExamineReview = new JLabel(" Examining Review");
	    lblExamineReview.setFont(new Font("Tahoma", Font.BOLD, 16));
	    lblExamineReview.setBounds(172, 0, 182, 33);
	    add(lblExamineReview);
	    lblExamineReview.setVisible(false);
	    
	    /* *********************** label and textField of 'Book name' *************************/
	    
	    JLabel lblBookName = new JLabel("Book name : ");
	    lblBookName.setBounds(21, 50, 77, 14);
	    add(lblBookName);
	    lblBookName.setVisible(false);
	    
	    textF_BookName = new JTextField();
	    textF_BookName.setEditable(false);
	    textF_BookName.setBounds(98, 47, 158, 20);
	    add(textF_BookName);
	    textF_BookName.setColumns(10);
	    textF_BookName.setVisible(false);
	    
        /* *********************** label and textField of 'Date' *****************************/	
	   
	    JLabel lblDate = new JLabel("Date :");
	    lblDate.setBounds(288, 50, 46, 14);
	    add(lblDate);
	    lblDate.setVisible(false);
	    
	    textF_Date = new JTextField();
	    textF_Date.setEditable(false);
	    textF_Date.setBounds(328, 47, 86, 20);
	    add(textF_Date);
	    textF_Date.setColumns(10);
	    textF_Date.setVisible(false);
	    
        /* ********************** label and textField of 'Reviewer' **************************/	    
	    
	    JLabel lblReviwer = new JLabel("Reviewer : ");
	    lblReviwer.setBounds(21, 86, 77, 14);
	    add(lblReviwer);
	    lblReviwer.setVisible(false);
	    
	    textF_Reviewer = new JTextField();
	    textF_Reviewer.setEditable(false);
	    textF_Reviewer.setBounds(98, 83, 158, 20);
	    add(textF_Reviewer);
	    textF_Reviewer.setColumns(10);
	    textF_Reviewer.setVisible(false);
	    
        /* ******************* scroll,text area and label of the Review **********************/	  
	    
	    JScrollPane scrollPane_review = new JScrollPane();
	    scrollPane_review.setBounds(10, 117, 480, 129);
	    add(scrollPane_review);
	    scrollPane_review.setVisible(false);
	    
	    JTextArea textArea_review = new JTextArea();
	    scrollPane_review.setViewportView(textArea_review);
	    textArea_review.setLineWrap(true);
	    textArea_review.setVisible(false);
	    
	    JLabel lblNote = new JLabel("** If you choose to edit the review, you may delete only.");
	    lblNote.setBounds(14, 246, 393, 14);
	    add(lblNote);
	    lblNote.setVisible(false);
	    
        /* *********************** 'Approve' 'Deny' 'Cancel' buttons ***********listeners down********************/  
	    
	    JButton btnApprove = new JButton("Approve");
	    btnApprove.setBounds(138, 285, 89, 23);
	    add(btnApprove);
	    btnApprove.setVisible(false);
	      
	    JButton btnDeny = new JButton("Deny");
	    btnDeny.setBounds(272, 285, 89, 23);
	    add(btnDeny);
	    btnDeny.setVisible(false);
	    
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(9, 471, 89, 23);
		add(btnCancel);
		btnCancel.setVisible(false);
/* ___________________________________________________________________________________________________________________________ END EXAMINING REVIEW */		


	    
/* ___________________________________________________________________________________________________________________________ WATCH PENDING REVIEWS */	
	    
	    
        /* ************************ label of 'Watch New Reviews' ******************************/		
		
		JLabel lblWatchNewReviews = new JLabel("Watch New Reviews");
		lblWatchNewReviews.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblWatchNewReviews.setBounds(168, 7, 182, 14);
		add(lblWatchNewReviews);
		
        /* ************************ label of 'Pending Reviews' ********************************/		
	
		JLabel lblPendingReviews = new JLabel("Pending Reviews : ");
		lblPendingReviews.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPendingReviews.setBounds(10, 37, 125, 22);
		add(lblPendingReviews);
		
        /* ****************************** Proceed button **************************************/		
		
		JButton btnProceed = new JButton("Proceed");
		btnProceed.addActionListener(new ActionListener() {   // listener - if button pressed, open Examining review window
			public void actionPerformed(ActionEvent arg0) {
				lblWatchNewReviews.setVisible(false);
				lblPendingReviews.setVisible(false);
				scrollPane_PendRevTable.setVisible(false);   // hide label,scroll,table of pending reviews and proceed button
				table_pendReviews.setVisible(false);
				btnProceed.setVisible(false);
				
				lbl_WatchNewReviews2.setVisible(true);	  // show examining review 
				lblExamineReview.setVisible(true);
				lblBookName.setVisible(true);
				textF_BookName.setVisible(true);
				lblDate.setVisible(true);
				textF_Date.setVisible(true);
				lblReviwer.setVisible(true);
				textF_Reviewer.setVisible(true);
				scrollPane_review.setVisible(true);
				textArea_review.setVisible(true);
				lblNote.setVisible(true);
				btnApprove.setVisible(true);
				btnDeny.setVisible(true);
				btnCancel.setVisible(true);
			}
		});
		btnProceed.setBounds(395, 285, 95, 32);
		add(btnProceed);
		btnProceed.setEnabled(false);			// disable button until a row from the table is selected (listener)
		
		
        /* ******************* scroll and Pending Reviews Table *******************************/	
		
		scrollPane_PendRevTable = new JScrollPane();
		scrollPane_PendRevTable.setBounds(10, 70, 481, 204);
		add(scrollPane_PendRevTable);
		
		table_pendReviews = new JTable();
		table_pendReviews.setBorder(UIManager.getBorder("Button.border"));
		table_pendReviews.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_pendReviews.setModel(new DefaultTableModel(
		
		new Object[][] {{"", "", null},	{null, null, null},	{null, null, null},	{null, null, null},	{null, null, null},	{null, null, null},
						{null, null, null},	{null, null, null},	{null, null, null},	{null, null, null},	{null, null, null},	},
		
		new String[] {"Book Name", "Reviewer", "Date"}
		) 
		
		{
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {	String.class, String.class, String.class};
				public Class getColumnClass(int columnIndex) { return columnTypes[columnIndex];
			}
		});
		
		table_pendReviews.getColumnModel().getColumn(0).setPreferredWidth(157);
		table_pendReviews.getColumnModel().getColumn(1).setPreferredWidth(151);
		table_pendReviews.getColumnModel().getColumn(2).setPreferredWidth(54);
		scrollPane_PendRevTable.setViewportView(table_pendReviews);
		
		table_pendReviews.addMouseListener(new MouseAdapter() {			// listener - if row has been selected , enable Proceed button
			  public void mouseClicked(MouseEvent e) {
			    if (e.getClickCount()==1) {
			    	btnProceed.setEnabled(true);
			    }
			  }
        });
        
/* ___________________________________________________________________________________________________________________________ END WATCH PENDING REVIEWS */	
	
	
		
		/* ******************EXAMINING REVIEW - approve,deny,cancel buttons listeners ****************/
		
	      btnApprove.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		lblWatchNewReviews.setVisible(true);
				lblPendingReviews.setVisible(true);
				scrollPane_PendRevTable.setVisible(true);   // hide label,scroll,table of pending reviews and proceed button
				table_pendReviews.setVisible(true);
				btnProceed.setVisible(true);
				
				lbl_WatchNewReviews2.setVisible(false);	  // show examining review 
				lblExamineReview.setVisible(false);
				lblBookName.setVisible(false);
				textF_BookName.setVisible(false);
				lblDate.setVisible(false);
				textF_Date.setVisible(false);
				lblReviwer.setVisible(false);
				textF_Reviewer.setVisible(false);
				scrollPane_review.setVisible(false);
				textArea_review.setVisible(false);
				lblNote.setVisible(false);
				btnApprove.setVisible(false);
				btnDeny.setVisible(false);
				btnCancel.setVisible(false);
	    	}
	    });
	      
	      btnDeny.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    	lblWatchNewReviews.setVisible(true);
				lblPendingReviews.setVisible(true);
				scrollPane_PendRevTable.setVisible(true);   // hide label,scroll,table of pending reviews and proceed button
				table_pendReviews.setVisible(true);
				btnProceed.setVisible(true);
					
				lbl_WatchNewReviews2.setVisible(false);	  // show examining review 
				lblExamineReview.setVisible(false);
				lblBookName.setVisible(false);
				textF_BookName.setVisible(false);
				lblDate.setVisible(false);
				textF_Date.setVisible(false);
				lblReviwer.setVisible(false);
				textF_Reviewer.setVisible(false);
				scrollPane_review.setVisible(false);
				textArea_review.setVisible(false);
				lblNote.setVisible(false);
				btnApprove.setVisible(false);
				btnDeny.setVisible(false);
				btnCancel.setVisible(false);
		    }
		});
	      
	      btnCancel.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    	lblWatchNewReviews.setVisible(true);
				lblPendingReviews.setVisible(true);
				scrollPane_PendRevTable.setVisible(true);   // hide label,scroll,table of pending reviews and proceed button
				table_pendReviews.setVisible(true);
				btnProceed.setVisible(true);
					
				lbl_WatchNewReviews2.setVisible(false);	  // show examining review 
				lblExamineReview.setVisible(false);
				lblBookName.setVisible(false);
				textF_BookName.setVisible(false);
				lblDate.setVisible(false);
				textF_Date.setVisible(false);
				lblReviwer.setVisible(false);
				textF_Reviewer.setVisible(false);
				scrollPane_review.setVisible(false);
				textArea_review.setVisible(false);
				lblNote.setVisible(false);
				btnApprove.setVisible(false);
				btnDeny.setVisible(false);
				btnCancel.setVisible(false);
		    }
		});
	      
	      /* *****************************************************************************************/
	}
}