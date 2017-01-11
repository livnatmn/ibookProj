package boundry;
 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import javafx.util.Pair;
import java.util.*;
import controller.*;
import enums.FontsType;


public class SearchBookPanel extends JPanel
	                     implements ActionListener {


    private String[] categoriesName;
    private String[] authorsName;
    private String[] langsName;
    private int chosenCatID;
    private boolean isStart;
    private boolean isRegularMode;
	
	static JFrame frame;
	private JPanel pnlFields;
    private JTextField tfTitle;
	private JComboBox<String> cbLanguage;
	private JComboBox<String> cbSubject;
	private JComboBox<String> cbCategory;
	private JComboBox<String> cbAuthor;
	private JRadioButton rdbtnOr;
	private JRadioButton rdbtnAnd;
	private JLabel lblSubject, lblSearchBy;
	
	private BookController bookCtrl;
    private SearchBookController srchBookCtrl;
 
    public SearchBookPanel() {
 		isStart = true;
 		isRegularMode = false;
    	bookCtrl = new BookController();
 		srchBookCtrl = new SearchBookController() ;
 		
 		InitTopPanel();
        InitBottomPanel();
    }    
    
	private void InitTopPanel() {
		setLayout(null);
        
		JPanel pnlButtons = new JPanel();
		pnlButtons.setBounds(0, 0, 345, 212);
		add(pnlButtons);
		pnlButtons.setLayout(null);
		
		JLabel label = new JLabel("Search type:");
	    label.setBounds(25, 86, 109, 20);
	    pnlButtons.add(label);
	    label.setFont(new Font("Sitka Text", Font.BOLD, 14));
		
		JLabel lblInst = new JLabel("Please insert book details to search:");
		lblInst.setBounds(30, 57, 233, 20);
		pnlButtons.add(lblInst);
		lblInst.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 14));

        JLabel lblType1 = new JLabel();
        lblType1.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 14));
        lblType1.setBounds(25, 148, 205, 20);
        pnlButtons.add(lblType1);
        
        JLabel lblType2 = new JLabel();
        lblType2.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 14));
        lblType2.setBounds(52, 166, 214, 20);
        pnlButtons.add(lblType2);
	    
        JLabel lblSearchTitle = new JLabel("Search for book");
        lblSearchTitle.setBounds(10, 11, 336, 20);
        pnlButtons.add(lblSearchTitle);
        lblSearchTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblSearchTitle.setFont(new Font("Goudy Stout", Font.PLAIN, 15));
	        
        JButton btnRegular = new JButton("Regular");
        btnRegular.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(isStart){
        			InitCombosBox();
        			isStart = false;
        		}
        		
				lblSearchBy.setEnabled(false);
				rdbtnOr.setEnabled(false);
				rdbtnAnd.setEnabled(false);
				

        		isRegularMode = true;
        		lblType1.setText("You now in REGULAR search mode.");
        		lblType2.setText("Please fill exactly one field.");
//		        String text = "You now in ";//{Regular} search mode.";
//		        text += (isRegularMode)? "Regular " : "Advanced ";
//		        text += "search mode.";
        	}
        });
        btnRegular.setBounds(66, 105, 95, 27);
        btnRegular.setFont(new Font("Sitka Text", Font.PLAIN, 14));
        pnlButtons.add(btnRegular);
	        
        JButton btnAdvanced = new JButton("Advanced");
        btnAdvanced.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		if(isStart){
        			InitCombosBox();
        			isStart = false;
        		}

        		lblSearchBy.setEnabled(true);
				rdbtnOr.setEnabled(true);
				rdbtnAnd.setEnabled(true);
				
				isRegularMode = false;
        		lblType1.setText("You now in ADVANCED search mode.");
        		lblType2.setText("Please fill two or more fields.");
        	}
        });
        btnAdvanced.setBounds(171, 105, 95, 27);
        btnAdvanced.setFont(new Font("Sitka Text", Font.PLAIN, 14));
        pnlButtons.add(btnAdvanced);
        
     
		
    }// end InitTopPanel
	
	private void InitBottomPanel() {
		setLayout(null);
		
		pnlFields = new JPanel();
        pnlFields.setBounds(0, 213, 345, 193);
        pnlFields.setVisible(false);
        add(pnlFields);
        pnlFields.setLayout(null);
        
        tfTitle = new JTextField();
        tfTitle.setBounds(121, 11, 155, 20);
        pnlFields.add(tfTitle);
        tfTitle.setColumns(10);
        
        JLabel lblTitle = new JLabel("Title:");
        lblTitle.setBounds(43, 14, 68, 14);
        pnlFields.add(lblTitle);
        lblTitle.setFont(new Font("Sitka Text", Font.PLAIN, 14));
        
        JLabel lblAuthor = new JLabel("Author:");
        lblAuthor.setBounds(43, 39, 68, 14);
        pnlFields.add(lblAuthor);
        lblAuthor.setFont(new Font("Sitka Text", Font.PLAIN, 14));
        
        JLabel lblLanguage = new JLabel("Language:");
        lblLanguage.setBounds(43, 64, 68, 14);
        pnlFields.add(lblLanguage);
        lblLanguage.setFont(new Font("Sitka Text", Font.PLAIN, 14));
        
        JLabel lblCategory = new JLabel("Category:");
        lblCategory.setBounds(43, 89, 68, 14);
        pnlFields.add(lblCategory);
        lblCategory.setFont(new Font("Sitka Text", Font.PLAIN, 14));
        
        lblSubject = new JLabel("Subject:");
        lblSubject.setBounds(43, 114, 68, 14);
        pnlFields.add(lblSubject);
        lblSubject.setFont(new Font("Sitka Text", Font.PLAIN, 14));
        
        lblSearchBy = new JLabel("Search by:");
        lblSearchBy.setBounds(43, 140, 72, 20);
        pnlFields.add(lblSearchBy);
        lblSearchBy.setFont(new Font("Sitka Text", Font.PLAIN, 14));
        lblSearchBy.setEnabled(false);
        
        //Group the radio buttons.
        ButtonGroup grpAction = new ButtonGroup();
        
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
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SearchBook();
			}
		});
		btnSearch.setFont(new Font("Sitka Text", Font.PLAIN, 14));
	}// end InitBottomPanel
 
	private void InitCombosBox(){
		
		// Get values from DB
		bookCtrl.GetAllCatsAndSubs();
		categoriesName = bookCtrl.GetCategoriesName();
		bookCtrl.GetAllAuthors();
		authorsName = bookCtrl.GetAuthorsName();
		bookCtrl.GetAllLanguages();
		langsName = bookCtrl.GetLanguagesName();
		
		// Init Combos-Box
		cbAuthor = new JComboBox<String>(authorsName);
        cbAuthor.setBounds(121, 36, 155, 20);
        pnlFields.add(cbAuthor);
        cbAuthor.setEditable(true);
        
		cbLanguage = new JComboBox<String>(langsName);
        cbLanguage.setBounds(121, 61, 155, 20);
        pnlFields.add(cbLanguage);
        cbLanguage.setEditable(true);
        
        cbCategory = new JComboBox<String>(categoriesName);
        cbCategory.setBounds(121, 86, 155, 20);
        pnlFields.add(cbCategory);
        cbCategory.setEditable(true);
        cbCategory.addActionListener(this);
        cbCategory.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        cbSubject = new JComboBox<String>();
        cbSubject.setBounds(121, 111, 155, 20);
        pnlFields.add(cbSubject);
        
		pnlFields.setVisible(true);
	}
	
	
	
	
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
		String str;
		HashMap<String, String> hm_fields = new HashMap<String, String>();
		hm_fields.clear();
		
		if(!tfTitle.getText().equals(""))
			hm_fields.put("title",tfTitle.getText());
		
		str = (String)cbAuthor.getSelectedItem();
		if(!str.equals("")) hm_fields.put("author",str);

		str = (String)cbLanguage.getSelectedItem();
		if(!str.equals("")) hm_fields.put("language",str);

		str = (String)cbCategory.getSelectedItem();
		if(!str.equals("")) hm_fields.put("category",str);

//		str = (String)cbSubject.getSelectedItem();
//		if(!str.equals("")) hm_fields.put("subject",str);
	
		// Print all - DEL
		for (String key: hm_fields.keySet()) {
		    System.out.println("==\nkey : " + key);
		    System.out.println("value : " + hm_fields.get(key));
		}
		
		// Verify not all fields are empty
		if(hm_fields.isEmpty())
			JOptionPane.showMessageDialog(null,"You can't start the search with empty fields.", "Search Error",JOptionPane.ERROR_MESSAGE);
		else if(isRegularMode)
			RegularSearch(hm_fields);
		else AdvancedSearch(hm_fields);
	}
    
    
    private void RegularSearch(HashMap<String, String> hm_fields)
    {
    	int size = hm_fields.size();

		if(size > 1)
		{
			JOptionPane.showMessageDialog(null,"Too many fields. Please choose only one field to search by.", "Search Error",JOptionPane.ERROR_MESSAGE);
			return;
		}
		srchBookCtrl.SearchBookByOneFeature(hm_fields);
    }
    
    
    
    
    private void AdvancedSearch(HashMap<String, String> hm_fields)
    {
    	// if !rdbtnOr.isSelected()
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		
		// IGNORE MEANWHILE
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
	*/
	
}
