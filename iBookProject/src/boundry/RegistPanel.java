package boundry;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

import controller.AccountController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistPanel extends JPanel{
	private JTextField tfNumberID;
	private JTextField tfFirstName;
	private JTextField tfUserName;
	private JTextField tfPassword;
	private JTextField tfEmail;
	private JTextField tfRePassword;
	private JTextField tfLastName;
	private AccountController accCntrl;
	
	public RegistPanel() {
		accCntrl = new AccountController();
		initialize();
	}
	
	private void initialize() {				
		setLayout(null);
		
		JLabel lblTitle = new JLabel("Registration");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Goudy Stout", Font.PLAIN, 15));
		lblTitle.setBounds(0, 21, 336, 20);
		add(lblTitle);
		
		JLabel lblInst = new JLabel("Please insert your details:");
		lblInst.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 14));
		lblInst.setBounds(20, 67, 233, 20);
		add(lblInst);
		
		JLabel lblNumID = new JLabel("ID number:");
		lblNumID.setBounds(29, 116, 82, 19);
		add(lblNumID);
		lblNumID.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		
		tfNumberID = new JTextField();
		tfNumberID.setBounds(161, 115, 174, 20);
		add(tfNumberID);
		tfNumberID.setColumns(10);
		
		JLabel lblName = new JLabel("Fisrt name:");
		lblName.setBounds(29, 149, 122, 14);
		add(lblName);
		lblName.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		
		JLabel lblpassword = new JLabel("Password:");
		lblpassword.setBounds(30, 238, 82, 19);
		add(lblpassword);
		lblpassword.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		
		JLabel lblEmail = new JLabel("Email address:");
		lblEmail.setBounds(29, 299, 122, 19);
		add(lblEmail);
		lblEmail.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		
		tfFirstName = new JTextField();
		tfFirstName.setBounds(161, 146, 175, 20);
		add(tfFirstName);
		tfFirstName.setColumns(10);
		
		tfPassword = new JPasswordField();
		tfPassword.setBounds(162, 237, 174, 20);
		add(tfPassword);
		tfPassword.setColumns(10);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(161, 298, 174, 20);
		add(tfEmail);
		tfEmail.setColumns(10);
		
		tfRePassword = new JPasswordField();
		tfRePassword.setColumns(10 );
		tfRePassword.setBounds(161, 268, 174, 20);
		add(tfRePassword);
		
		JLabel lblRepeatPass = new JLabel("Confirm password:");
		lblRepeatPass.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		lblRepeatPass.setBounds(10, 269, 145, 19);
		add(lblRepeatPass);
		
		tfLastName = new JTextField();
		tfLastName.setColumns(10);
		tfLastName.setBounds(161, 174, 175, 20);
		add(tfLastName);
		
		JLabel lblLastName = new JLabel("Last name:");
		lblLastName.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		lblLastName.setBounds(29, 177, 122, 14);
		add(lblLastName);
		
		JLabel lblUserName = new JLabel("User name:");
		lblUserName.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		lblUserName.setBounds(30, 206, 82, 19);
		add(lblUserName);
		
		tfUserName = new JTextField();
		tfUserName.setColumns(10);
		tfUserName.setBounds(162, 205, 174, 20);
		add(tfUserName);
	}
	
	private boolean CheckFields()
	{
		String id = tfNumberID.getText();
		String firstName = tfFirstName.getText();
		String lastName = tfLastName.getText();
		String userName = tfUserName.getText();
		String pass = tfPassword.getText();
		String rePass = tfRePassword.getText();
		String mail = tfEmail.getText();
		
		if(id.equals("") || firstName.equals("") || lastName.equals("") ||
				userName.equals("") || pass.equals("") || rePass.equals("") || mail.equals(""))
		{
			JOptionPane.showMessageDialog(null,"Please fill all the given fields.", "Registration Error",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		if(!id.matches("[.0-9]+"))
		{
			JOptionPane.showMessageDialog(null,"ID number must contain only digits.", "Search Error",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		if(!pass.equals(rePass))
		{
			JOptionPane.showMessageDialog(null,"Your passwords are not matching.", "Search Error",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		return true;
	}
	

	private boolean CheckPersonIDExistance()
	{
		// Check is user ID already exist in DB.
		return accCntrl.IsPersonIDExist(tfNumberID.getText());
		
	}
	
	private int CountAccounts()
	{
		// 
		return accCntrl.CountPersonAccounts(tfNumberID.getText());
		
	}
	
	public boolean ToSend()
	{
		boolean flag = false;
		
		if(CheckFields())
		{
			flag = true;
			if(CheckPersonIDExistance()) // ID exist in DB
			{
				if(CountAccounts() > 0)
				{	
					JOptionPane.showMessageDialog(null,"Already got user account,"
							+ "no allow to open new account.", "Registration Error",JOptionPane.ERROR_MESSAGE);
					flag = false;
				}				
			}
			else
			{
				// insert person details
				accCntrl.InsertPeraonDetails(tfNumberID.getText(),tfFirstName.getText(),
						tfLastName.getText(),tfEmail.getText());
			}
			// This person does not have another user account.
			if(flag)
				JOptionPane.showMessageDialog(null,"Your details successfully sent for validity.", "Registration Success",JOptionPane.INFORMATION_MESSAGE);
		}
		
		return flag;
	}// end ToSend function.
	
}
