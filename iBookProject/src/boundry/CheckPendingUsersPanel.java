package boundry;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.awt.Color;


public class CheckPendingUsersPanel extends JPanel{

	private static final long serialVersionUID = 32132111L;
	
	/* First screen attributes */

	
	private JButton btnProceed;
	private JScrollPane scrollPane;
	private JLabel lblPendingReviews;
	private JLabel lblCheckPendingUsers;
	private JTable table;
	
	/* Second screen attributes */
	private JTextField txtF_username;
	private JTextField txtF_firstname;
	private JTextField txtF_lastname;
	private JTextField txtF_id;
	private JTextField txtF_email;
	private JTextField txtF_password;
	private JLabel lblUserInformetion;
	private JButton btnApprove;
	private JButton btnDeny;
	private JLabel lblUserName;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JLabel lblId; 
	private JLabel lblEmail;
	private JLabel lblPassword;

		
	
	public CheckPendingUsersPanel() {
		setBorder(new LineBorder(new Color(0, 0, 0)));          // Constructor
		initialize();
	}
	
	
	private void initialize() {
		setLayout(null);
		
		
/* label of 'Check Pending Users'*/		
		
	    lblCheckPendingUsers = new JLabel("Check Pending Users");
		lblCheckPendingUsers.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCheckPendingUsers.setBounds(155, 32, 182, 22);
		add(lblCheckPendingUsers);
		
/*label of 'Pending Requests'*/
		
		lblPendingReviews = new JLabel("Pending Requests : ");
		lblPendingReviews.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPendingReviews.setBounds(10, 117, 125, 22);
		add(lblPendingReviews);
		
		/* scroll and Pending Requests Table */				
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 150, 243, 173);
		add(scrollPane);
		
		table = new JTable();
		table.setBorder(UIManager.getBorder("Button.border"));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"", ""},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Request number", "User Name"
			}
		));
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(90);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(130);
		scrollPane.setViewportView(table);
		
		table.addMouseListener(new MouseAdapter() {			// listener - if row has been selected , enable Proceed button
			  public void mouseClicked(MouseEvent e) {
			    if (e.getClickCount()==1) {
			    	btnProceed.setEnabled(true);
			    }
			  }
        });
/* Proceed button */	
		
		btnProceed = new JButton("Proceed");
		btnProceed.setBounds(276, 353, 89, 23);
		add(btnProceed);
		btnProceed.setEnabled(false);			// disable button until a row from the table is selected (listener)
		

		
                   /* Second panel initialize */
		
	    /* label and text field of 'User name' */	
	    lblUserName = new JLabel("User Name : ");
	    lblUserName.setBounds(42, 121, 82, 14);
	    add(lblUserName);
	    
	    txtF_username = new JTextField();
	    txtF_username.setEditable(false);
	    txtF_username.setBounds(127, 118, 86, 20);
	    add(txtF_username);
	    txtF_username.setColumns(10);
	    
	    /*label and text field of 'First name'*/
	    
	    lblFirstName = new JLabel("First Name : ");
	    lblFirstName.setBounds(42, 146, 82, 14);
	    add(lblFirstName);
	    
	    txtF_firstname = new JTextField();
	    txtF_firstname.setEditable(false);
	    txtF_firstname.setBounds(127, 143, 86, 20);
	    add(txtF_firstname);
	    txtF_firstname.setColumns(10);
	    
	    /* label and text field of 'Last name'*/	
	    
	    lblLastName = new JLabel("Last Name :");
	    lblLastName.setBounds(42, 171, 82, 14);
	    add(lblLastName);
	    
	    txtF_lastname = new JTextField();
	    txtF_lastname.setEditable(false);
	    txtF_lastname.setBounds(127, 168, 86, 20);
	    add(txtF_lastname);
	    txtF_lastname.setColumns(10);
	    
	    /* label and text field of 'ID'*/	
	    
	    lblId = new JLabel("ID : ");
	    lblId.setBounds(270, 171, 39, 14);
	    add(lblId);
	    
	    txtF_id = new JTextField();
	    txtF_id.setEditable(false);
	    txtF_id.setBounds(312, 168, 86, 20);
	    add(txtF_id);
	    txtF_id.setColumns(10);
	    
/*label and text field of 'Email'*/	
	    
	    lblEmail = new JLabel("Email : ");
	    lblEmail.setBounds(260, 146, 61, 14);
	    add(lblEmail);
	    
	    txtF_email = new JTextField();
	    txtF_email.setEditable(false);
	    txtF_email.setBounds(312, 143, 86, 20);
	    add(txtF_email);
	    txtF_email.setColumns(10);
	    
/* label and text field of 'Password'*/	
	    
	    lblPassword = new JLabel("Password : ");
	    lblPassword.setBounds(238, 121, 83, 14);
	    add(lblPassword);
	    
	    txtF_password = new JTextField();
	    txtF_password.setEditable(false);
	    txtF_password.setBounds(312, 118, 86, 20);
	    add(txtF_password);
	    txtF_password.setColumns(10);
	    
/*approve and deny buttons*/	
	    
	    btnApprove = new JButton("Approve");
	    btnApprove.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
                   setFirstPanel();
				
	    	}
	    });
	    btnApprove.setBounds(124, 319, 89, 23);
	    add(btnApprove);
	    
	    
	    btnDeny = new JButton("Deny");
	    btnDeny.setBounds(309, 319, 89, 23);
	    add(btnDeny);
	    btnDeny.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e) {
                setFirstPanel();
	    		}
	    });
	    
	    
	    lblUserInformetion = new JLabel("User Informetion");
	    lblUserInformetion.setFont(new Font("Tahoma", Font.BOLD, 14));
	    lblUserInformetion.setBounds(168, 38, 156, 31);
	    add(lblUserInformetion);
	    

		
		btnProceed.addActionListener(new ActionListener() {			// listener - if button pressed, open User Request window
			public void actionPerformed(ActionEvent arg0) {
				setSecondPanel();
			}
		});
		
		setFirstPanel();
	
	}
	
	/* this method set all the relevant component of first panel visible */ 
	private void setFirstPanel()
	{
		btnProceed.setVisible(true);
		scrollPane.setVisible(true);
		lblPendingReviews.setVisible(true);
		lblCheckPendingUsers.setVisible(true);
		
		lblUserInformetion.setVisible(false);
		btnApprove.setVisible(false);
		btnDeny.setVisible(false);
		lblPassword.setVisible(false);
		txtF_password.setVisible(false);
		txtF_email.setVisible(false);
		lblEmail.setVisible(false);
		txtF_id.setVisible(false);
		lblId.setVisible(false);
		txtF_lastname.setVisible(false);
		lblLastName.setVisible(false);
		txtF_firstname.setVisible(false);
		lblFirstName.setVisible(false);
		txtF_username.setVisible(false);
		lblUserName.setVisible(false);
		
	}
	/* this method set all the relevant component of second panel visible */ 
	private void setSecondPanel()
	{
		btnProceed.setVisible(false);
		scrollPane.setVisible(false);
		lblPendingReviews.setVisible(false);
		lblCheckPendingUsers.setVisible(false);
		
		lblUserInformetion.setVisible(true);
		btnApprove.setVisible(true);
		btnDeny.setVisible(true);
		lblPassword.setVisible(true);
		txtF_password.setVisible(true);
		txtF_email.setVisible(true);
		lblEmail.setVisible(true);
		txtF_id.setVisible(true);
		lblId.setVisible(true);
		txtF_lastname.setVisible(true);
		lblLastName.setVisible(true);
		txtF_firstname.setVisible(true);
		lblFirstName.setVisible(true);
		txtF_username.setVisible(true);
		lblUserName.setVisible(true);
		
	}
	
}
