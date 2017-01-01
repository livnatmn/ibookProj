package boundry;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import controller.WorkerController;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollBar;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JSlider;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;


public class RemoveBookPanel extends JPanel{

	
	public RemoveBookPanel() {          // Constructor
	
		initialize();
	}
	
	
	private void initialize() {
		setLayout(null);
/* ___________________________________________________________________________________________________________________________ label of 'Remove Exist Book' */	
		
		JLabel lblRemoveExistBook = new JLabel("Remove Exist Book");
		lblRemoveExistBook.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRemoveExistBook.setBounds(170, 7, 166, 14);
		add(lblRemoveExistBook);
		
/* ___________________________________________________________________________________________________________________________ Remove button */				
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnRemove.setBounds(202, 205, 90, 36);
		add(btnRemove);
		btnRemove.setEnabled(false);
		
/* ___________________________________________________________________________________________________________________________ label of 'Book' */			
		
		JLabel lblBook = new JLabel("Book :");
		lblBook.setBounds(112, 142, 46, 14);
		add(lblBook);
		
/* ___________________________________________________________________________________________________________________________ combo-box of 'Book' */	
		
		String[] bookList = {"","Book 1","Book 2"};  // temp values
		JComboBox comboBox_2 = new JComboBox(bookList);
		comboBox_2.setBounds(171, 139, 155, 20);
		add(comboBox_2);	
		comboBox_2.setEnabled(false);
		
		comboBox_2.addItemListener(new ItemListener(){      // listener - if book combo box has been selected , enable remove button
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                	btnRemove.setEnabled(true);
                }
            }
        });
		
/* ___________________________________________________________________________________________________________________________ label of 'Subject' */			
		
		JLabel lblSubject = new JLabel("Subject : ");
		lblSubject.setBounds(100, 106, 72, 14);
		add(lblSubject);
		
/* ___________________________________________________________________________________________________________________________ combo-box of 'Subject' */	
		
		String[] subjectList = {"","Subject 1","Subject 2"};  // temp values
		JComboBox comboBox_1 = new JComboBox(subjectList);
		comboBox_1.setBounds(171, 103, 155, 20);
		add(comboBox_1);	
		comboBox_1.setEnabled(false);
		
		comboBox_1.addItemListener(new ItemListener(){      // listener - if subject combo box has been selected , enable book combo box
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                	comboBox_2.setEnabled(true);
                }
            }
        });
		
/* ___________________________________________________________________________________________________________________________ label of 'Category' */		
		
		JLabel lblCategory = new JLabel("Category : ");
		lblCategory.setBounds(91, 70, 72, 14);
		add(lblCategory);
		
/* ___________________________________________________________________________________________________________________________ combo-box of 'Category' */
		
		String[] categoryList = {"","category 1","category 2"};  // temp values
		JComboBox comboBox = new JComboBox(categoryList);
		comboBox.setBounds(171, 67, 155, 20);
		add(comboBox);
		
		comboBox.addItemListener(new ItemListener(){      // listener - if category combo box has been selected , enable subject combo box
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                	comboBox_1.setEnabled(true);
                }
            }
        });

/* ___________________________________________________________________________________________________________________________ */		

	}
}