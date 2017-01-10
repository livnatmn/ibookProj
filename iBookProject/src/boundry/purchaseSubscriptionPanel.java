package boundry;
import controller.*;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.SwingConstants;
import enums.subscriptionEnum;
import controller.AccountController;
import controller.SubscriptionController;
import entity.Subscription;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.time.*;
import java.util.Calendar;
import java.util.Date;
import java.sql.*;

public class purchaseSubscriptionPanel extends JPanel {
	private JTextField tfMothlyPrice;
	private JTextField tfMothlyDueDate;
	private JTextField tfYearlyPrice;
	private JTextField tfYearlyDurDate;
	private JRadioButton rdbtnMonthly;
	private JRadioButton rdbtnYearly;
	private AccountController accCntrl;
	private SubscriptionController sbscrptnCntrl;
	private JPanel pnlprchsSub;
	private String dateStr;
	private Subscription[] subArr;
	
	 
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	/**
	 * Create the panel.
	 * @param pnlprchsSub 
	 */
	public purchaseSubscriptionPanel(AccountController accCntrl, JPanel pnlprchsSub) {
		this.accCntrl=accCntrl;
		this.pnlprchsSub=pnlprchsSub;
		sbscrptnCntrl=new SubscriptionController();
		initialize();
	}
		

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(){
		setLayout(null);
		
		rdbtnMonthly = new JRadioButton("monthly");
		rdbtnMonthly.setBounds(0, 100, 73, 23);
		add(rdbtnMonthly);

		
		JLabel lblPurchaseSubscription = new JLabel("PURCHASE SUBSCRIPTION");
		lblPurchaseSubscription.setBounds(0, 11, 382, 22);
		lblPurchaseSubscription.setHorizontalAlignment(SwingConstants.CENTER);
		lblPurchaseSubscription.setFont(new Font("Goudy Stout", Font.PLAIN, 15));
		add(lblPurchaseSubscription);
		
		rdbtnYearly = new JRadioButton("yearly");
		rdbtnYearly.setBounds(0, 136, 73, 23);
		add(rdbtnYearly);
		
		JButton btnPurchase = new JButton("purchase");


		btnPurchase.setBounds(129, 182, 89, 23);
		add(btnPurchase);
		
		JLabel lblPrice = new JLabel("price:");
		lblPrice.setBounds(80, 76, 85, 14);
		add(lblPrice);
		
		tfMothlyPrice = new JTextField();
		tfMothlyPrice.setEditable(false);
		tfMothlyPrice.setBounds(79, 101, 86, 20);
		add(tfMothlyPrice);
		tfMothlyPrice.setColumns(10);
		
		JLabel lblDuedate = new JLabel("dueDate:");
		lblDuedate.setBounds(194, 76, 73, 14);
		add(lblDuedate);
		
		tfMothlyDueDate = new JTextField();
		tfMothlyDueDate.setEditable(false);
		tfMothlyDueDate.setBounds(197, 101, 86, 20);
		add(tfMothlyDueDate);
		tfMothlyDueDate.setColumns(10);
		
		tfYearlyPrice = new JTextField();
		tfYearlyPrice.setEditable(false);
		tfYearlyPrice.setBounds(79, 137, 86, 20);
		add(tfYearlyPrice);
		tfYearlyPrice.setColumns(10);
		
		tfYearlyDurDate = new JTextField();
		tfYearlyDurDate.setEditable(false);
		tfYearlyDurDate.setBounds(197, 137, 86, 20);
		add(tfYearlyDurDate);
		tfYearlyDurDate.setColumns(10);
		
		JLabel lblPleaseChooseType = new JLabel("Please choose type of subscription:");
		lblPleaseChooseType.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 14));
		lblPleaseChooseType.setBounds(10, 44, 233, 20);
		add(lblPleaseChooseType);
		
		/*Save yearly subscription details*/
		//if(sbscrptnCntrl.getSubscriptionDetails(subscriptionEnum.subscription.monthly.ordinal()))
			subArr=sbscrptnCntrl.GetSubArr();

		rdbtnMonthly.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(rdbtnMonthly.isSelected())
				{
				//clear all other fields
				emptyYearlyFields();
				
				//get the price
				tfMothlyPrice.setText(Integer.toString(subArr[0].GetSubscriptionPrice()));
				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.MONTH, 1);
				//SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				
				dateStr=formatter.format(cal.getTime());
				
				tfMothlyDueDate.setText(formatter.format(cal.getTime()));
				}
				else
				{
					emptyMonthlyFields();
				}
			}
		});
		
		rdbtnYearly.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(rdbtnYearly.isSelected())
				{
				//clear all other fields
				emptyMonthlyFields();
				//get the price
				tfYearlyPrice.setText(Integer.toString(subArr[1].GetSubscriptionPrice()));
				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.YEAR, 1);
				dateStr=formatter.format(cal.getTime());
				tfYearlyDurDate.setText(formatter.format(cal.getTime()));
				}
				else
				{
					emptyYearlyFields();
				}
			}
		});	
		
		btnPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(accCntrl.usr.GetSubscriptionID()!=0){
					JOptionPane.showMessageDialog(pnlprchsSub, "you already purchased subscription!", "subscription error", JOptionPane.ERROR_MESSAGE);
					btnPurchase.setEnabled(false);
				}//if
				else
				{
					int subscriptionID = 0;
					if(!rdbtnMonthly.isSelected() && !rdbtnYearly.isSelected())
					{
						JOptionPane.showMessageDialog(pnlprchsSub, "please choose subsription option", "subscription error", JOptionPane.WARNING_MESSAGE);
					}
					else {
					if(rdbtnYearly.isSelected())
						subscriptionID=subscriptionEnum.subscription.yearly.ordinal();
					
					if(rdbtnMonthly.isSelected())
						subscriptionID=subscriptionEnum.subscription.monthly.ordinal();
					
					
					sbscrptnCntrl.UpdateUserSubscription(accCntrl.usr.GetUserName(),subscriptionID,dateStr);
					JOptionPane.showMessageDialog(pnlprchsSub, "congradulation! you subscribed successfully!", "subscribed successfully", JOptionPane.PLAIN_MESSAGE);
					btnPurchase.setEnabled(false);
					}

				}
			}
		});
		
	}
	private void emptyMonthlyFields()
	{
		rdbtnMonthly.setSelected(false);
		tfMothlyPrice.setText("");
		tfMothlyDueDate.setText("");
	}
	
	private void emptyYearlyFields()
	{
		rdbtnYearly.setSelected(false);
		tfYearlyDurDate.setText("");
		tfYearlyPrice.setText("");
	}
}
