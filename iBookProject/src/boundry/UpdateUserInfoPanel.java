package boundry;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;


public class UpdateUserInfoPanel extends JPanel{

	private static final long serialVersionUID = 1231234L;
	/* first screen */
	
	private JLabel lblFindUser;
	private JButton btnSearch;
	private JTextField txtUsername;
	private JLabel lblUserName; 
	
	/* second screen */
	
	private JTextField txtUserName2;
	private JTextField txtID;
	private JTextField txtPassword;
	private JTextField txtEmail;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtPrivillege;
    private JPanel panel;     
    private JLabel lblUserName2;
    private JLabel lblID;
    private JLabel lblPassword;
    private JLabel lblEmail;
    private JLabel lblFirstname;
    private JLabel lblLastname;
    private JLabel lblPrivillege;
    private JButton btnCancel;
    private JButton btnUpdate;

	
	public UpdateUserInfoPanel(){
		setBorder(new LineBorder(new Color(0, 0, 0)));          // Constructor
		initialize();
	}
	
	
	private void initialize() {
		setLayout(null);
		
		
	           	/* initialize the first screen */
		
/* label of 'Check Pending Users' */	
		
		lblFindUser = new JLabel("Find User to Edit");
		lblFindUser.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFindUser.setBounds(173, 30, 147, 23);
		add(lblFindUser);
/* __________________________________________________________  */		
		
		lblUserName = new JLabel("User Name:");
		lblUserName.setBounds(43, 87, 86, 14);
		add(lblUserName);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(120, 84, 86, 20);
		add(txtUsername);
		txtUsername.setColumns(10);	
		
		txtUsername.addKeyListener(new KeyAdapter() {   // enable save button only if there is text in 'content text area'
			@Override
			public void keyReleased(KeyEvent arg0) {
					if(!(txtUsername.getText().isEmpty())) {
						btnSearch.setEnabled(true);
			    }else {
			    	btnSearch.setEnabled(false);
			    }
			}
		});
	
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setSecondPanel();
			}
		});
		btnSearch.setBounds(231, 83, 89, 23);
		add(btnSearch);
		btnSearch.setEnabled(false);
		
		
		/* __________________________________________________________  */		
			
		panel = new JPanel();
		panel.setBorder(new LineBorder(Color.DARK_GRAY));
		panel.setBounds(30, 153, 444, 158);
		add(panel);
		panel.setLayout(null);
		
		/* __________________________________________________________  */	
		lblUserName2 = new JLabel("User Name :");
		lblUserName2.setBounds(10, 9, 98, 14);
		panel.add(lblUserName2);
		
		txtUserName2 = new JTextField();
		txtUserName2.setBounds(84, 6, 86, 20);
		panel.add(txtUserName2);
		txtUserName2.setColumns(10);
		
		/* __________________________________________________________  */	
		lblID = new JLabel("ID :");
		lblID.setBounds(230, 9, 46, 14);
		panel.add(lblID);
		
		txtID = new JTextField();
		txtID.setBounds(304, 6, 86, 20);
		panel.add(txtID);
		txtID.setColumns(10);
		
		/* __________________________________________________________  */	
		lblPassword = new JLabel("Password :");
		lblPassword.setBounds(10, 50, 98, 14);
		panel.add(lblPassword);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(84, 47, 86, 20);
		panel.add(txtPassword);
		txtPassword.setColumns(10);
		
		/* __________________________________________________________  */	
		lblEmail = new JLabel("Email :");
		lblEmail.setBounds(10, 91, 46, 14);
		panel.add(lblEmail);
				
		txtEmail = new JTextField();
		txtEmail.setBounds(84, 88, 86, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		/* __________________________________________________________  */	
		
		lblFirstname = new JLabel("First Name :");
		lblFirstname.setBounds(230, 50, 106, 14);
		panel.add(lblFirstname);
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(304, 47, 86, 20);
		panel.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		/* __________________________________________________________  */	
				
		lblLastname = new JLabel("Last Name :");
		lblLastname.setBounds(230, 91, 106, 14);
		panel.add(lblLastname);
		
		txtLastName = new JTextField();
		txtLastName.setBounds(304, 88, 86, 20);
		panel.add(txtLastName);
		txtLastName.setColumns(10);
		
		/* __________________________________________________________  */	
		
		lblPrivillege = new JLabel("Privillege :");
		lblPrivillege.setBounds(10, 132, 68, 14);
		panel.add(lblPrivillege);
		
		txtPrivillege = new JTextField();
		txtPrivillege.setBounds(84, 129, 86, 20);
		panel.add(txtPrivillege);
		txtPrivillege.setColumns(10);
		
		/* __________________________________________________________  */	
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setFirstPanel();
			}
		});
		btnCancel.setBounds(385, 322, 89, 23);
		add(btnCancel);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setFirstPanel();
			}
		});
		btnUpdate.setBounds(290, 322, 89, 23);
		add(btnUpdate);
		
		/* __________________________________________________________  */	
		
		

		setFirstPanel();
	}
	
	private void setFirstPanel()
	{

	lblFindUser.setVisible(true);
	  btnSearch.setVisible(true);
	txtUsername.setVisible(true);
	lblUserName.setVisible(true); 
	
	txtUsername.setText("");
	
	lblFindUser.setEnabled(true);
	txtUsername.setEnabled(true);
	lblUserName.setEnabled(true);
	

   txtUserName2.setVisible(false);
          txtID.setVisible(false);
    txtPassword.setVisible(false);
       txtEmail.setVisible(false);
   txtFirstName.setVisible(false);
    txtLastName.setVisible(false);
  txtPrivillege.setVisible(false);    
   lblUserName2.setVisible(false);
          lblID.setVisible(false);
    lblPassword.setVisible(false);
       lblEmail.setVisible(false);
   lblFirstname.setVisible(false);
    lblLastname.setVisible(false);
  lblPrivillege.setVisible(false);
      btnCancel.setVisible(false);
      btnUpdate.setVisible(false);
	}
	
	private void setSecondPanel()
	{

	  btnSearch.setEnabled(false);
	txtUsername.setEnabled(false);
	lblUserName.setEnabled(false); 

   txtUserName2.setVisible(true);
          txtID.setVisible(true);
    txtPassword.setVisible(true);
       txtEmail.setVisible(true);
   txtFirstName.setVisible(true);
    txtLastName.setVisible(true);
  txtPrivillege.setVisible(true);    
   lblUserName2.setVisible(true);
          lblID.setVisible(true);
    lblPassword.setVisible(true);
       lblEmail.setVisible(true);
   lblFirstname.setVisible(true);
    lblLastname.setVisible(true);
  lblPrivillege.setVisible(true);
      btnCancel.setVisible(true);
      btnUpdate.setVisible(true);
	}
}