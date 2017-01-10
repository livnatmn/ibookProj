package boundry;

import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HideBookPanel extends JPanel {
	private JTextField txtF_Title;
	private JTextField txtF_BookID;
	private JTextField txtF_Author;

	/**
	 * Create the panel.
	 */
	public HideBookPanel() {
		initialize();
	}

	
	private void initialize() {
		setLayout(null);
		
		

		JButton btnHideBookSearch = new JButton("Search");
	
		btnHideBookSearch.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnHideBookSearch.setBounds(302, 89, 87, 23);
		add(btnHideBookSearch);
		btnHideBookSearch.setVisible(true);
		btnHideBookSearch.setEnabled(false);
		
		JLabel lblHideBook = new JLabel("Hide Book");
		lblHideBook.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblHideBook.setBounds(209, 11, 123, 14);
		add(lblHideBook);
		
		 /* _________________________________________________________________ label of 'Book' */			
		
		JLabel lblHideBookBook = new JLabel("Book :");
		lblHideBookBook.setBounds(47, 130, 46, 14);
		add(lblHideBookBook);
		lblHideBookBook.setVisible(true);
		
        /* _________________________________________________________________ combo-box of 'Book' */	
		
		String[] booksList3 = {"","Booka 1","Booka 2"};  // temp values
		JComboBox comboBox_HideBook_Books = new JComboBox(booksList3);
		comboBox_HideBook_Books.setBounds(112, 127, 155, 20);
		add(comboBox_HideBook_Books);
		comboBox_HideBook_Books.setEnabled(false);
		comboBox_HideBook_Books.setVisible(true);
		
		comboBox_HideBook_Books.addItemListener(new ItemListener(){      // listener - if subject combo box has been selected , enable book combo box
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                	btnHideBookSearch.setEnabled(true);
                }
            }
        });
		
		
	    /* _________________________________________________________________ label of 'Subject' */
		
		JLabel lblHideBookSubject = new JLabel("Subject : ");
		lblHideBookSubject.setBounds(47, 94, 72, 14);
		add(lblHideBookSubject);
		lblHideBookSubject.setVisible(true);
        /* _________________________________________________________________ combo-box of 'Subject' */
		
		String[] SubjectsList3 = {"","Subjecta 1","Subjecta 2"};  // temp values
		JComboBox comboBox_HideBook_Subjects = new JComboBox(SubjectsList3);
		comboBox_HideBook_Subjects.setBounds(112, 91, 155, 20);
		add(comboBox_HideBook_Subjects);
		comboBox_HideBook_Subjects.setEnabled(false);
		comboBox_HideBook_Subjects.setVisible(true);
		
		comboBox_HideBook_Subjects.addItemListener(new ItemListener(){      // listener - if subject combo box has been selected , enable book combo box
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                	comboBox_HideBook_Books.setEnabled(true);
                }
            }
        });
		
        /* ________________________________________________________________ label of 'Category' */
		
		JLabel lblHideBookCategory = new JLabel("Category : ");
		lblHideBookCategory.setBounds(39, 58, 72, 14);
		add(lblHideBookCategory);
		lblHideBookCategory.setVisible(true);
		
        /* ________________________________________________________________ combo-box of 'Category' */
		
		String[] CategoriesList3 = {"","categorya 1","categorya 2"};  // temp values
		JComboBox comboBox_HideBook_Categories = new JComboBox(CategoriesList3);
		comboBox_HideBook_Categories.setBounds(112, 55, 155, 20);
		add(comboBox_HideBook_Categories);
		comboBox_HideBook_Categories.setVisible(true);
		
		comboBox_HideBook_Categories.addItemListener(new ItemListener(){      // listener - if category combo box has been selected , enable subject combo box
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                	comboBox_HideBook_Subjects.setEnabled(true);
                }
            }
        });
		 /* ________________________________________________________________ */
			
		
		 /* ____________________________________________________________________________________________________________________ */
		 /* ____________________________________________________________________________________________________________________ */
		 /* ____________________________________________________________________________________________________________________ */
		
		JLabel lblBookDetails = new JLabel("Book Details :");
		lblBookDetails.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBookDetails.setBounds(47, 208, 123, 14);
		add(lblBookDetails);
		lblBookDetails.setVisible(false);
		
		txtF_Title = new JTextField();
		txtF_Title.setBounds(112, 245, 123, 20);
		add(txtF_Title);
		txtF_Title.setColumns(10);
		txtF_Title.setVisible(false);
		
		txtF_BookID = new JTextField();
		txtF_BookID.setBounds(112, 276, 123, 20);
		add(txtF_BookID);
		txtF_BookID.setColumns(10);
		txtF_BookID.setVisible(false);
		
		txtF_Author = new JTextField();
		txtF_Author.setBounds(112, 308, 123, 20);
		add(txtF_Author);
		txtF_Author.setColumns(10);
		txtF_Author.setVisible(false);
		
		JLabel lblTitle = new JLabel("Title : ");
		lblTitle.setBounds(47, 248, 46, 14);
		add(lblTitle);
		lblTitle.setVisible(false);
		
		JLabel lblBookID = new JLabel("Book ID : ");
		lblBookID.setBounds(47, 279, 72, 14);
		add(lblBookID);
		lblBookID.setVisible(false);
		
		JLabel lblAuthor = new JLabel("Author : ");
		lblAuthor.setBounds(47, 311, 46, 14);
		add(lblAuthor);
		lblAuthor.setVisible(false);
		
		JButton btnDisplay = new JButton("Display");
		btnDisplay.setBounds(380, 428, 89, 23);
		add(btnDisplay);
		btnDisplay.setVisible(false);
		
		JButton btnHide = new JButton("Hide");
		btnHide.setBounds(281, 428, 89, 23);
		add(btnHide);
		btnHide.setVisible(false);
	
		
		
		btnHideBookSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblBookDetails.setVisible(true);
				txtF_Title.setVisible(true);
				txtF_BookID.setVisible(true);
				txtF_Author.setVisible(true);
				lblTitle.setVisible(true);
				lblBookID.setVisible(true);
				lblAuthor.setVisible(true);
				btnDisplay.setVisible(true);
				btnHide.setVisible(true);
			}
		});
	}
}
