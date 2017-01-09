package boundry;
 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import javafx.util.Pair;
import java.util.*;
import controller.*;


public class SearchBookPanel extends JPanel
	                     implements ActionListener {

	static JFrame frame;
    BookController bookCtrl;
    SearchBookController srchBookCtrl;
    String[] categoriesName;
    String[] authorsName;
    String[] langsName;
    private int chosenCatID;
    private boolean init;
    
	private JTextField tfTitle;
	private JComboBox<String> cbLanguage;
	private JComboBox<String> cbSubject;
	private JComboBox<String> cbCategory;
	private JComboBox<String> cbAuthor;
	private JRadioButton rdbtnOr;
	private JRadioButton rdbtnAnd;
	private JLabel lblSubject, lblSearchBy;
	
 
    public SearchBookPanel() {
 		init = false; // Search not initialized
    	bookCtrl = new BookController();
 		srchBookCtrl = new SearchBookController() ;
 		

	//	categoriesName = null;
	//	authorsName = null;
	//	langsName = null;

 		
    	initialize();
    }
    
    
	private void initialize() {
		setLayout(null);
        
        //Group the radio buttons.
	    ButtonGroup grpType = new ButtonGroup();
		
	    
	    
	    
	    
	    
	    
	    
	    
	    
	//    if(rdbtnRegular.isSelected() || rdbtnAdvanced.isSelected())
	//    {
	    	System.out.println("radio isSelected");
		
		//Group the radio buttons.
	    ButtonGroup grpAction = new ButtonGroup();
        
        JPanel panel = new JPanel();
        panel.setBounds(78, 279, 155, -12);
        add(panel);
        
        JPanel pnlFields = new JPanel();
        pnlFields.setBounds(0, 141, 345, 204);
        add(pnlFields);
        pnlFields.setLayout(null);
        
        tfTitle = new JTextField();
        tfTitle.setBounds(121, 11, 155, 20);
        pnlFields.add(tfTitle);
        tfTitle.setEnabled(false);
        tfTitle.setColumns(10);
        // define all
        
        JLabel lblTitle = new JLabel("Title:");
        lblTitle.setBounds(43, 14, 68, 14);
        pnlFields.add(lblTitle);
        lblTitle.setEnabled(false);
        lblTitle.setFont(new Font("Sitka Text", Font.PLAIN, 14));
        

        
        JLabel lblAuthor = new JLabel("Author:");
        lblAuthor.setBounds(43, 39, 68, 14);
        pnlFields.add(lblAuthor);
        lblAuthor.setEnabled(false);
        lblAuthor.setFont(new Font("Sitka Text", Font.PLAIN, 14));
        
        cbAuthor = new JComboBox<String>();//authorsName);
        cbAuthor.setBounds(121, 36, 155, 20);
        pnlFields.add(cbAuthor);
        cbAuthor.setEnabled(false);
        cbAuthor.setEditable(true);
        
        cbLanguage = new JComboBox<String>();//langsName);
        cbLanguage.setBounds(121, 61, 155, 20);
        pnlFields.add(cbLanguage);
        cbLanguage.setEnabled(false);
        cbLanguage.setEditable(true);
        
        JLabel lblLanguage = new JLabel("Language:");
        lblLanguage.setBounds(43, 64, 68, 14);
        pnlFields.add(lblLanguage);
        lblLanguage.setEnabled(false);
        lblLanguage.setFont(new Font("Sitka Text", Font.PLAIN, 14));
        
        JLabel lblCategory = new JLabel("Category:");
        lblCategory.setBounds(43, 89, 68, 14);
        pnlFields.add(lblCategory);
        lblCategory.setEnabled(false);
        lblCategory.setFont(new Font("Sitka Text", Font.PLAIN, 14));
        
        cbCategory = new JComboBox<String>();//categoriesName);
        cbCategory.setBounds(121, 86, 155, 20);
        pnlFields.add(cbCategory);
        cbCategory.setEnabled(false);
        cbCategory.setEditable(true);
        cbCategory.addActionListener(this);
        cbCategory.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        cbSubject = new JComboBox<String>();
        cbSubject.setBounds(121, 111, 155, 20);
        pnlFields.add(cbSubject);
        cbSubject.setEnabled(false);
        
        lblSubject = new JLabel("Subject:");
        lblSubject.setBounds(43, 114, 68, 14);
        pnlFields.add(lblSubject);
        lblSubject.setFont(new Font("Sitka Text", Font.PLAIN, 14));
        lblSubject.setEnabled(false);
        
        lblSearchBy = new JLabel("Search by:");
        lblSearchBy.setBounds(43, 140, 72, 20);
        pnlFields.add(lblSearchBy);
        lblSearchBy.setFont(new Font("Sitka Text", Font.PLAIN, 14));
        lblSearchBy.setEnabled(false);
        
        		
        		rdbtnAnd = new JRadioButton("AND");
        		rdbtnAnd.setBounds(121, 138, 58, 23);
        		pnlFields.add(rdbtnAnd);
        		rdbtnAnd.setEnabled(false);
        		grpAction.add(rdbtnAnd);
        		
        		rdbtnOr = new JRadioButton("OR");
        		rdbtnOr.setBounds(198, 138, 58, 23);
        		pnlFields.add(rdbtnOr);
        		rdbtnOr.setEnabled(false);
        		grpAction.add(rdbtnOr);
        		
        				
        				JButton btnSearch = new JButton("Search");
        				btnSearch.setBounds(131, 166, 89, 23);
        				pnlFields.add(btnSearch);
        				btnSearch.setEnabled(false);
        				btnSearch.addActionListener(new ActionListener() {
        					public void actionPerformed(ActionEvent arg0) {
        						SearchBook();
        					}
        				});
        				btnSearch.setFont(new Font("Sitka Text", Font.PLAIN, 14));
        				
        				JPanel panel_1 = new JPanel();
        				panel_1.setBounds(0, 0, 345, 143);
        				add(panel_1);
        				panel_1.setLayout(null);
        				
        				JLabel lblInst = new JLabel("Please insert book details to search:");
        				lblInst.setBounds(30, 57, 233, 20);
        				panel_1.add(lblInst);
        				lblInst.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 14));
        				
        				
        				//// define radio
        				 
        JLabel label = new JLabel("Search type:");
        label.setBounds(25, 86, 109, 20);
        panel_1.add(label);
        label.setFont(new Font("Sitka Text", Font.BOLD, 14));
        
        JLabel lblSearchTitle = new JLabel("Search for book");
        lblSearchTitle.setBounds(10, 11, 336, 20);
        panel_1.add(lblSearchTitle);
        lblSearchTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblSearchTitle.setFont(new Font("Goudy Stout", Font.PLAIN, 15));
        
        JButton btnRegular = new JButton("Regular");
        btnRegular.setBounds(66, 105, 95, 27);
        btnRegular.setFont(new Font("Sitka Text", Font.PLAIN, 14));
        panel_1.add(btnRegular);
        
        JButton btnAdvanced = new JButton("Advanced");
        btnAdvanced.setBounds(171, 105, 95, 27);
        btnAdvanced.setFont(new Font("Sitka Text", Font.PLAIN, 14));
        panel_1.add(btnAdvanced);
        btnRegular.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
    			bookCtrl.GetAllCatsAndSubs();
    			categoriesName = bookCtrl.GetCategoriesName();
    			bookCtrl.GetAllAuthors();
    			authorsName = bookCtrl.GetAuthorsName();
    			bookCtrl.GetAllLanguages();
    			langsName = bookCtrl.GetLanguagesName();
        	}
        });
	  //  }// end if
    } //init
 
    public void actionPerformed(ActionEvent e) {
        JComboBox<String> cb = (JComboBox<String>)e.getSource();
        String selection = (String)cb.getSelectedItem();
        if(!selection.equals(""))
        {
	        chosenCatID = bookCtrl.GetCategoryIDByName(selection);
	        if(chosenCatID == -1) return;
	        
	        System.out.println("chosenCatID= "+chosenCatID);
	        cbSubject.removeAllItems();
	        ArrayList<String> subName = bookCtrl.GetSubjectsByCategory(chosenCatID);
	        for(String val: subName)
	        	cbSubject.addItem(val);
			cbSubject.setEnabled(true);
			lblSubject.setEnabled(true);
        }
        else
        {
        	cbSubject.removeAllItems();
        	cbSubject.setEnabled(false);
			lblSubject.setEnabled(false);
        }
        
    }// end cbSubject actionPerformed.

    
    
	private void SearchBook()
	{
	//	boolean allowSearch = false;
		String txt="";
	//	int fieldsCount = 0;
		
		// Check if all fields are empty - a search not performed.
		if(tfTitle.getText().equals("") &&
				cbAuthor.getSelectedItem().equals("") &&
				cbLanguage.getSelectedItem().equals("") &&
				cbCategory.getSelectedItem().equals("") &&
				cbSubject.getItemCount() == 0)
		{
			EmptyFields();
		}
//		else
//		{ // at least 1 field filled for search
//			//	fieldsCount = 0;
//			
//			ArrayList<Pair<String,String>> arr_srchFlds = new ArrayList<Pair<String,String>>();
//			arr_srchFlds.clear();
//			
//			if(!tfTitle.getText().equals(""))
//				arr_srchFlds.add(new Pair<String,String>("title",tfTitle.getText()));
//
//			txt = (String)cbAuthor.getSelectedItem();
//			if(!txt.equals(""))
//				arr_srchFlds.add(new Pair<String,String>("author",txt));
//
//			txt = (String)cbLanguage.getSelectedItem();
//			if(!txt.equals(""))
//				arr_srchFlds.add(new Pair<String,String>("language",txt));
//
//			txt = (String)cbCategory.getSelectedItem();
//			if(!txt.equals(""))
//			{
//				arr_srchFlds.add(new Pair<String,String>("category",txt));
//				
//				txt = (String)cbSubject.getSelectedItem();
//				arr_srchFlds.add(new Pair<String,String>("subject",txt));
//			}
//			
//			if(arr_srchFlds.isEmpty())
//				EmptyFields();
//			else if(arr_srchFlds.size() == 1)
//			{
//				System.out.println("arr_srchFlds.size() == 1");
//				SearchByOneField(arr_srchFlds);
//			}
//			else
//			{
//				String action;
//				if(rdbtnOr.isSelected() || rdbtnAnd.isSelected())
//				{
//					action = (rdbtnOr.isSelected())? " OR " : " AND ";
//					SearchBySomeFields(arr_srchFlds, action);
//				}
//				else
//				{
//					JOptionPane.showMessageDialog(null,"You selected more then 1 field to search.\n"
//							+ "please choose search option(OR / AND).", "Search Info",JOptionPane.INFORMATION_MESSAGE);
//	
//					lblSearchBy.setEnabled(true);
//					rdbtnOr.setEnabled(true);
//					rdbtnAnd.setEnabled(true);
//					rdbtnOr.setSelected(false);
//					rdbtnAnd.setSelected(false);
//				} // end else choose action.
//			} // end else Search by some fields.
//		} // end else fields not empty.
	} // end else SearchBook function.
	
	
	private void EmptyFields()
	{
		JOptionPane.showMessageDialog(null,"Please insert any value for search.", "Search Error",JOptionPane.ERROR_MESSAGE);

		lblSearchBy.setEnabled(false);
		rdbtnOr.setEnabled(false);
		rdbtnAnd.setEnabled(false);
	}
	
	
//	private void SearchByOneField(ArrayList<Pair<String,String>> arr_srchFlds)
//	{
//		lblSearchBy.setEnabled(false);
//		rdbtnOr.setEnabled(false);
//		rdbtnOr.setSelected(false);
//		rdbtnAnd.setEnabled(false);
//		rdbtnAnd.setSelected(false);
//		
//		srchBookCtrl.SearchBookByOneFeature(arr_srchFlds);
//	}
//	
//	
//	private void SearchBySomeFields(ArrayList<Pair<String,String>> arr_srchFlds, String action)
//	{
//		srchBookCtrl.SearchBookBySomeFeatures(arr_srchFlds, action);
//		
//	}
}
