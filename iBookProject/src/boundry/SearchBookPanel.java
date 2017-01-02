package boundry;
 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
import java.text.SimpleDateFormat;
	 
	/* ComboBoxDemo2.java requires no other files. */
public class SearchBookPanel extends JPanel
	                     implements ActionListener {
    static JFrame frame;
    String currentPattern;
    
	private JTextField tfTitle;
	private JTextField tfAuthor;
	private JComboBox cbLanguage;
	private JComboBox cbSubject;
	private JComboBox cbCategory;
 
    public SearchBookPanel() {
    	initialize();
    }
    
    
	private void initialize() {	
        String[] Categories = {
                 "",
                 "Category111",
                 "Category222",
                 "Category333"
                 };
 
        currentPattern = Categories[0];
        setLayout(null);
 

		JLabel lblSearchTitle = new JLabel("Search for book");
		lblSearchTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchTitle.setFont(new Font("Goudy Stout", Font.PLAIN, 15));
		lblSearchTitle.setBounds(0, 21, 336, 20);
		add(lblSearchTitle);
		
		JLabel lblInst = new JLabel("Please insert book details to search:");
		lblInst.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 14));
		lblInst.setBounds(20, 67, 233, 20);
		add(lblInst);
		
		tfTitle = new JTextField();
		tfTitle.setColumns(10);
		tfTitle.setBounds(98, 123, 155, 20);
		add(tfTitle);
		
		tfAuthor = new JTextField();
		tfAuthor.setText("");
		tfAuthor.setColumns(10);
		tfAuthor.setBounds(98, 148, 155, 20);
		add(tfAuthor);
		
		cbLanguage = new JComboBox();
		cbLanguage.setEditable(true);
		cbLanguage.setBounds(98, 173, 155, 20);
		add(cbLanguage);
		
		cbSubject = new JComboBox();
		cbSubject.setEnabled(false);
		cbSubject.setBounds(98, 223, 155, 20);
		add(cbSubject);
		
		JLabel lblSubject = new JLabel("Subject:");
		lblSubject.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		lblSubject.setEnabled(false);
		lblSubject.setBounds(20, 226, 68, 14);
		add(lblSubject);
		
		JRadioButton rdbtnOr = new JRadioButton("OR");
		rdbtnOr.setEnabled(false);
		rdbtnOr.setBounds(176, 248, 58, 23);
		add(rdbtnOr);
		
		JRadioButton rdbtnAnd = new JRadioButton("AND");
		rdbtnAnd.setSelected(true);
		rdbtnAnd.setEnabled(false);
		rdbtnAnd.setBounds(98, 250, 58, 23);
		add(rdbtnAnd);
		
		JLabel lblSearchBy = new JLabel("Search by:");
		lblSearchBy.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		lblSearchBy.setEnabled(false);
		lblSearchBy.setBounds(20, 252, 72, 20);
		add(lblSearchBy);
		
		JLabel lblCategory = new JLabel("Category:");
		lblCategory.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		lblCategory.setBounds(20, 201, 68, 14);
		add(lblCategory);
		
		JLabel lblLanguage = new JLabel("Language:");
		lblLanguage.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		lblLanguage.setBounds(20, 176, 68, 14);
		add(lblLanguage);
		
		JLabel lblAuthor = new JLabel("Author:");
		lblAuthor.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		lblAuthor.setBounds(20, 151, 68, 14);
		add(lblAuthor);
		
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		lblTitle.setBounds(20, 126, 68, 14);
		add(lblTitle);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SearchBook();
			}
		});
		btnSearch.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		btnSearch.setBounds(108, 278, 89, 23);
		add(btnSearch);
               
    //    setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        cbCategory = new JComboBox(Categories);
        cbCategory.setBounds(98, 198, 155, 21);
        add(cbCategory);
        cbCategory.setEditable(true);
        cbCategory.addActionListener(this);
        cbCategory.setAlignmentX(Component.LEFT_ALIGNMENT);
 
    } //constructor
 
    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox)e.getSource();
        String newSelection = (String)cb.getSelectedItem();
        cbSubject.addItem(newSelection);
		cbSubject.setEnabled(true);
        
    }

    
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("ComboBoxDemo2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Create and set up the content pane.
        JComponent newContentPane = new SearchBookPanel();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    

	private void SearchBook(){
		// Check if all fields are empty - a search not performed.
		if(tfTitle.getText().equals("") &&
				tfAuthor.getText().equals("") &&
				cbLanguage.getItemCount() == 0 &&
				cbCategory.getItemCount() == 0 &&
				cbSubject.getItemCount() == 0)
			JOptionPane.showMessageDialog(null,"Please insert any value for search.", "Search Error",JOptionPane.ERROR_MESSAGE);
		
	}
    
    
}
