package boundry;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class OrganizeInventoryBooksPanel extends JPanel {

	private JPanel panelAdd;
	private JLabel lblAdd;
	private JRadioButton rdbtnCategory;
	private JRadioButton rdbtnSubject;
	private JTextField textAdd;
	private JButton btnAdd;
	private JLabel lblNewLabel;
	private JPanel panelRemove;
	private JButton btnRemove;
	private JLabel lblRemove;    
	private JRadioButton rdbtnCategory2;
	private JRadioButton rdbtnSubject2;
	private JComboBox<String> comboBoxRmove;
	/* for testing */
	private String arrSubject[] = {"Sport","Food","Programing"};
	private String arrCatgory[] = {"Football","Baking","Drama"};
	




	public OrganizeInventoryBooksPanel() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(null);
		
		panelAdd = new JPanel();
		panelAdd.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panelAdd.setBounds(10, 75, 483, 90);
		add(panelAdd);
		panelAdd.setLayout(null);
		
		lblAdd = new JLabel("Add : ");
		lblAdd.setBounds(10, 10, 35, 16);
		lblAdd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelAdd.add(lblAdd);
		
		rdbtnCategory = new JRadioButton("Category");
		rdbtnCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(rdbtnSubject.isSelected() || rdbtnCategory.isSelected())
			    	textAdd.setEditable(true);
					else {
				    textAdd.setText(null);
					textAdd.setEditable(false);
					btnAdd.setEnabled(false);
					}
			    	if(rdbtnCategory.isSelected())
			    	     rdbtnSubject.setEnabled(false);
			    	else
			    		 rdbtnSubject.setEnabled(true);	
			}
		});
		rdbtnCategory.setBounds(65, 7, 98, 23);
		panelAdd.add(rdbtnCategory);
		
		rdbtnSubject = new JRadioButton("Subject");
		rdbtnSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(rdbtnSubject.isSelected() || rdbtnCategory.isSelected())
			    	textAdd.setEditable(true);
					else {
					textAdd.setText(null);
					textAdd.setEditable(false);
					btnAdd.setEnabled(false);
					
					}
			    	if(rdbtnSubject.isSelected())
			    		rdbtnCategory.setEnabled(false);
			    	else
			    		rdbtnCategory.setEnabled(true);	
			}
		});
		rdbtnSubject.setBounds(160, 8, 86, 23);
		panelAdd.add(rdbtnSubject);
		
		textAdd = new JTextField();
		textAdd.setEditable(false);
		textAdd.setBounds(70, 50, 86, 20);
		panelAdd.add(textAdd);
		textAdd.setColumns(10);
		
		textAdd.addKeyListener(new KeyAdapter() {   // enable save button only if there is text in 'content text area'
			@Override
			public void keyReleased(KeyEvent arg0) {
					if(!(textAdd.getText().isEmpty())) 
						btnAdd.setEnabled(true);
			        else 
			      	    btnAdd.setEnabled(false);
			}
		});
		
		
		btnAdd = new JButton("Add");
		btnAdd.setEnabled(false);
		btnAdd.setBounds(250, 50, 89, 23);
		panelAdd.add(btnAdd);
		
		lblNewLabel = new JLabel("Organize the inventory books");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(151, 11, 224, 34);
		add(lblNewLabel);
		
		panelRemove = new JPanel();
		panelRemove.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panelRemove.setBounds(10, 185, 483, 111);
		add(panelRemove);
		panelRemove.setLayout(null);
		
		
		lblRemove = new JLabel("Remove :");
		lblRemove.setBounds(10, 10, 69, 14);
		panelRemove.add(lblRemove);

		rdbtnCategory2 = new JRadioButton("Category");
		rdbtnCategory2.setBounds(65, 7, 99, 23);
		panelRemove.add(rdbtnCategory2);
		rdbtnCategory2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnSubject2.isSelected() || rdbtnCategory2.isSelected())
		    	    comboBoxRmove.setEnabled(true);
				else 
				    comboBoxRmove.setEnabled(false);
	
		    	if(rdbtnCategory2.isSelected())
		    	     rdbtnSubject2.setEnabled(false);
		    	else
		    		 rdbtnSubject2.setEnabled(true);
		    	
		    	if(rdbtnCategory2.isSelected())
		    	    for(int i=0; i < arrCatgory.length ; i++)    		
		    	        comboBoxRmove.addItem(arrCatgory[i]);
		    	else{
		    		comboBoxRmove.removeAllItems();
				    btnRemove.setEnabled(false);
				   }
			}
		});
		
		
		
		rdbtnSubject2 = new JRadioButton("Subject");
		rdbtnSubject2.setBounds(160, 6, 109, 23);
		panelRemove.add(rdbtnSubject2);
		rdbtnSubject2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				if(rdbtnSubject2.isSelected() || rdbtnCategory2.isSelected())
		    	    comboBoxRmove.setEnabled(true);
				else
					comboBoxRmove.setEnabled(false);		
				  
		    	if(rdbtnSubject2.isSelected())
		    		rdbtnCategory2.setEnabled(false);
		    	else
		    		rdbtnCategory2.setEnabled(true);
		    	
		    	if(rdbtnSubject2.isSelected())
		    	    for(int i=0; i < arrSubject.length ; i++)    		
		    	        comboBoxRmove.addItem(arrSubject[i]);
		    	else{
		    		comboBoxRmove.removeAllItems();
		    		btnRemove.setEnabled(false);
		    	   }
			}
		});
		
		comboBoxRmove = new JComboBox<String>();
		comboBoxRmove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnRemove.setEnabled(true);
			}
		});
		comboBoxRmove.setEnabled(false);
		comboBoxRmove.setBounds(70, 50, 117, 20);
		panelRemove.add(comboBoxRmove);
		
		btnRemove = new JButton("Remove");
		btnRemove.setEnabled(false);
		btnRemove.setBounds(250, 78, 89, 23);
		panelRemove.add(btnRemove);
	}

	private static final long serialVersionUID = 53211113L;
}
