package boundry;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ManageOSPanel extends JPanel {
	private JTextField txtF_UserID;

	/**
	 * Create the panel.
	 */
	public ManageOSPanel() {
		initialize();
	}

	
	private void initialize() {
		setLayout(null);
		
		JLabel lblManageOpertaingSystem = new JLabel("Manage Opertaing System");
		lblManageOpertaingSystem.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblManageOpertaingSystem.setBounds(148, 21, 245, 25);
		add(lblManageOpertaingSystem);
		
		JLabel lblPleaseInsertUser = new JLabel("Please insert user ID to search : ");
		lblPleaseInsertUser.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPleaseInsertUser.setBounds(26, 71, 220, 14);
		add(lblPleaseInsertUser);
		
		JLabel lblUserId = new JLabel("User ID : ");
		lblUserId.setBounds(26, 104, 61, 14);
		add(lblUserId);
		
		txtF_UserID = new JTextField();
		txtF_UserID.setBounds(82, 101, 98, 20);
		add(txtF_UserID);
		txtF_UserID.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(203, 100, 89, 23);
		add(btnSearch);
		btnSearch.setEnabled(false);
		
		
		
		JButton btnChPermissions = new JButton("Change Permissions");
		btnChPermissions.setBounds(47, 191, 154, 23);
		add(btnChPermissions);
		btnChPermissions.setVisible(false);
		
		JButton btnBanAccount = new JButton("Ban account");
		btnBanAccount.setBounds(47, 238, 154, 23);
		add(btnBanAccount);
		btnBanAccount.setVisible(false);
		
		JButton btnAllowAccount = new JButton("Allow account");
		btnAllowAccount.setBounds(47, 288, 154, 23);
		add(btnAllowAccount);
		btnAllowAccount.setVisible(false);
		
		JRadioButton rdbtn_ReadOnly = new JRadioButton("Read Only");
		rdbtn_ReadOnly.setBounds(222, 179, 109, 23);
		add(rdbtn_ReadOnly);
		rdbtn_ReadOnly.setVisible(false);
		
		JRadioButton rdbtn_BuyRead = new JRadioButton("Buy & Read");
		rdbtn_BuyRead.setBounds(222, 204, 109, 23);
		add(rdbtn_BuyRead);
		rdbtn_BuyRead.setVisible(false);
		
			
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(401, 440, 89, 23);
		add(btnSave);
		btnSave.setVisible(false);
		btnSave.setEnabled(false);
		
		
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				btnChPermissions.setVisible(true);
				btnBanAccount.setVisible(true);
				btnAllowAccount.setVisible(true);
				btnSave.setVisible(true);
			}
		});
		
		btnChPermissions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtn_ReadOnly.setVisible(true);
				rdbtn_BuyRead.setVisible(true);
				
			}
		});
		
		btnBanAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtn_ReadOnly.setVisible(false);
				rdbtn_BuyRead.setVisible(false);
			}
		});
		
		btnAllowAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtn_ReadOnly.setVisible(false);
				rdbtn_BuyRead.setVisible(false);
			}
		});
		
		txtF_UserID.addKeyListener(new KeyAdapter() { 
			@Override
			public void keyReleased(KeyEvent arg0) {
					if(!(txtF_UserID.getText().isEmpty())) {
						btnSearch.setEnabled(true);
				    }else {
				    	btnSearch.setEnabled(false);
				    }
				}
			});
		
		rdbtn_ReadOnly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtn_BuyRead.setSelected(false);
				btnSave.setEnabled(true);
			}
		});
		
		rdbtn_BuyRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtn_ReadOnly.setSelected(false);
				btnSave.setEnabled(true);
			}
		});
	
		
	}
}
