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


public class ArrangePaymentPanel extends JPanel{

	private static final long serialVersionUID = 23568974L;
	
	/* First screen attributes */
	
	private JTable table;
	private JButton btnProceed;
	private JLabel lblPaymentArrange;
	private JLabel lblPendingRequests;
	private JScrollPane scrollPane;
	
	/* Second screen attributes */
	
	private JLabel lblCreditInfo;
	private JLabel lblUserName;
	private JTextField txtUserName;
	private JLabel lblCreditNumber;
	private JTextField txtCrdNum;
	private JButton btnApprove;
	private JButton btnDeny;
	private JLabel lblValidityNumber;
	private JTextField textValidity;
	private JTextField textDueDate;
	private JTextField textFirstName;
	private JTextField textLastName;
	private JTextField textID;
	private JLabel lblDueDate;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JLabel lblId;


	
	public ArrangePaymentPanel() {
		
		setBorder(new LineBorder(new Color(0, 0, 0)));          // Constructor
		initialize();
	}
	
	
	private void initialize() {
		setLayout(null);
		
		
	           	/** initialize the first screen **/
		
/* label of 'Check Pending Users' */	
		
		lblPaymentArrange = new JLabel("Payment arrangement requests");
		lblPaymentArrange.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPaymentArrange.setBounds(122, 29, 274, 22);
		add(lblPaymentArrange);
		
/* label of 'Pending Requests' */	
		
	lblPendingRequests = new JLabel("Pending Requests : ");
		lblPendingRequests.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPendingRequests.setBounds(50, 131, 135, 22);
		add(lblPendingRequests);

/* scroll and Pending Requests Table */		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 164, 281, 142);
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
			},
			new String[] {
				"Request number", "User Name"
			}
		));
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(95);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(156);
		scrollPane.setViewportView(table);
		
		table.addMouseListener(new MouseAdapter() {			// listener - if row has been selected , enable Proceed button
			  public void mouseClicked(MouseEvent e) {
			    if (e.getClickCount()==1) {
			    	btnProceed.setEnabled(true);
			    }
			  }
        });			
/*----------------------- Proceed button ----------------------------*/			
		btnProceed = new JButton("Proceed");
		btnProceed.setEnabled(false);
		btnProceed.setBounds(318, 345, 89, 23);
		add(btnProceed);
		
/**__________ initialize the second screen ___________**/		
			
		
/* Credit info label */
		
		lblCreditInfo = new JLabel("Crdit Informetion");
		lblCreditInfo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCreditInfo.setBounds(189, 40, 146, 37);
		add(lblCreditInfo);
		
		lblUserName = new JLabel("User name :");
		lblUserName.setBounds(40, 136, 86, 14);
		add(lblUserName);
		
		txtUserName = new JTextField();
		txtUserName.setEditable(false);
		txtUserName.setEnabled(false);
		txtUserName.setBounds(160, 136, 86, 20);
		add(txtUserName);
		txtUserName.setColumns(10);
		
		lblCreditNumber = new JLabel("Credit card Number :");
		lblCreditNumber.setBounds(40, 166, 135, 14);
		add(lblCreditNumber);
		
		txtCrdNum = new JTextField();
		txtCrdNum.setEditable(false);
		txtCrdNum.setEnabled(false);
		txtCrdNum.setBounds(160, 166, 86, 20);
		add(txtCrdNum);
		txtCrdNum.setColumns(10);
		
		btnApprove = new JButton("Approve");
		btnApprove.setBounds(120, 400, 89, 23);
		add(btnApprove);
		
		btnDeny = new JButton("Deny");
		btnDeny.setBounds(320, 400, 89, 23);
		add(btnDeny);
		
		lblValidityNumber = new JLabel("Validity number :");
		lblValidityNumber.setBounds(40, 196, 110, 14);
		add(lblValidityNumber);
		
		textValidity = new JTextField();
		textValidity.setEditable(false);
		textValidity.setBounds(160, 196, 86, 20);
		add(textValidity);
		textValidity.setColumns(10);
		
		lblDueDate = new JLabel("Due date :");
		lblDueDate.setBounds(40, 226, 86, 14);
		add(lblDueDate);
		
		textDueDate = new JTextField();
		textDueDate.setEditable(false);
		textDueDate.setBounds(160, 226, 86, 20);
		add(textDueDate);
		textDueDate.setColumns(10);
		
		lblFirstName = new JLabel("First name :");
		lblFirstName.setBounds(280, 136, 69, 14);
		add(lblFirstName);
		
		textFirstName = new JTextField();
		textFirstName.setEditable(false);
		textFirstName.setBounds(360, 136, 86, 20);
		add(textFirstName);
		textFirstName.setColumns(10);
		
		lblLastName = new JLabel("Last name :");
		lblLastName.setBounds(280, 166, 74, 14);
		add(lblLastName);
		
		textLastName = new JTextField();
		textLastName.setEditable(false);
		textLastName.setBounds(360, 166, 86, 20);
		add(textLastName);
		textLastName.setColumns(10);
		
	    lblId = new JLabel("ID :");
		lblId.setBounds(280, 196, 46, 14);
		add(lblId);
		
		textID = new JTextField();
		textID.setEditable(false);
		textID.setBounds(360, 196, 86, 20);
		add(textID);
		textID.setColumns(10);
		
		
		btnApprove.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
	              setFirstPanel(); 
			}
		});
		btnDeny.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
	              setFirstPanel(); 
			}
		});
		
		btnProceed.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
	              setSecondPanel(); 
			}
		});

	setFirstPanel();
	}
	
private void setFirstPanel (){

             table.setVisible(true);
        btnProceed.setVisible(true);
 lblPaymentArrange.setVisible(true);
lblPendingRequests.setVisible(true);
        scrollPane.setVisible(true);

  lblCreditInfo.setVisible(false);
    lblUserName.setVisible(false);
    txtUserName.setVisible(false);
      txtCrdNum.setVisible(false);
lblCreditNumber.setVisible(false);
     btnApprove.setVisible(false);
        btnDeny.setVisible(false);
lblValidityNumber.setVisible(false);
     textValidity.setVisible(false);
      textDueDate.setVisible(false);
    textFirstName.setVisible(false);
     textLastName.setVisible(false);
           textID.setVisible(false);
       lblDueDate.setVisible(false);
     lblFirstName.setVisible(false);
      lblLastName.setVisible(false);
            lblId.setVisible(false);
}
	
	private void setSecondPanel(){

		               table.setVisible(false);
	              btnProceed.setVisible(false);
	       lblPaymentArrange.setVisible(false);
	      lblPendingRequests.setVisible(false);
	              scrollPane.setVisible(false);

	           lblCreditInfo.setVisible(true);
	             lblUserName.setVisible(true);
	             txtUserName.setVisible(true);
	               txtCrdNum.setVisible(true);
	         lblCreditNumber.setVisible(true);
	              btnApprove.setVisible(true);
	                 btnDeny.setVisible(true);
lblValidityNumber.setVisible(true);
     textValidity.setVisible(true);
      textDueDate.setVisible(true);
    textFirstName.setVisible(true);
     textLastName.setVisible(true);
           textID.setVisible(true);
       lblDueDate.setVisible(true);
     lblFirstName.setVisible(true);
      lblLastName.setVisible(true);
            lblId.setVisible(true);
	}
}