package boundry;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import controller.WorkerController;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.TextArea;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.border.LineBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import java.beans.PropertyChangeListener;
import java.text.ParseException;
import java.beans.PropertyChangeEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;


@SuppressWarnings("serial")
public class AddBookPanel extends JPanel{
	
	//private static final long serialVersionUID = 1L;
	private JTextField txtF_title;
	private JTextField txtF_author;
	private JTextField txtF_price;
	private JTextField txtF_keywords;
	private JTable table_chCategory; 
	private JTable table_chSubject;  
	
	private int count_oneChooseAtOnce=0;    // count for 'choose' buttons, so only one table will be open at once.  0=no windows is open , 1= one of the windows is already open
	
	private boolean [] CatOldArrayCheckBox = {false};    // for cancel buttons.  preserve the old state of check-box column.
	private boolean [] CatArrayCheckBox = {false};      // get the current state of check-box column.
	private int CatCountCheckBox=0;   				   // to count how many check boxes are selected(category)

	private boolean [] SubOldArrayCheckBox = {false};    // for cancel buttons.  preserve the old state of check-box column.
	private boolean [] SubArrayCheckBox = {false};      // get the current state of check-box column.
	private int SubCountCheckBox=0;   			  	   // to count how many check boxes are selected(subject)
	
	@SuppressWarnings("unused")
	String oldContent = null;    // preserve the text in 'content text area' before changes made - for Cancel button
	
	
	public AddBookPanel() {			// Constructor
	
		initialize();
	}
	
	
	@SuppressWarnings("serial") // for tables
	private void initialize() {
		setLayout(null);
/* ___________________________________________________________________________________________________________________________ label of 'Add a book' */			
		
		JLabel lblAddABook = new JLabel("Add a book");
		lblAddABook.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAddABook.setBounds(198, 3, 99, 25);
		add(lblAddABook);
		
/* ___________________________________________________________________________________________________________________________ label and text field of 'Title' */		
		
		JLabel lblTitle = new JLabel("Title :");
		lblTitle.setBounds(10, 49, 36, 14);
		add(lblTitle);
		
		txtF_title = new JTextField();
		txtF_title.setBounds(66, 46, 151, 20);
		add(txtF_title);
	    txtF_title.setColumns(10);
	

		/* ********    TextField validation    ***********/  /* hebrew??? need validation ??*/

	 //   txtF_title.addKeyListener(new KeyAdapter() {  	//  allow only digits and backspace, otherwise set editable=false & display message
	//		@Override
	//		public void keyPressed(KeyEvent tmp) {
	//			int key=tmp.getKeyCode();
				
			//	if((key>= tmp.VK_0 && key<= tmp.VK_9)||(key>= KeyEvent.VK_NUMPAD0 && key<= tmp.VK_NUMPAD9)||(key== tmp.VK_BACK_SPACE)
				//	||(key>= tmp.VK_A&& key<= tmp.VK_Z)||(key==tmp.VK_MINUS)||(key==tmp.VK_COMMA)||(key==tmp.VK_CAPS_LOCK)||(key==tmp.VK_SHIFT)
				//	||(key==tmp.VK_SPACE)||(key==tmp.VK_NUM_LOCK))
					//txtF_title.setEditable(true);
				//else{
					//txtF_title.setEditable(false);    // Don't let to write anything thats not a digit
					//JOptionPane.showMessageDialog(null,"only 0-9  A-Z  a-z  -  ,", "Input Error",JOptionPane.ERROR_MESSAGE);
					//txtF_title.setEditable(true);
				//}
			//}
		//});  
	    
/* ___________________________________________________________________________________________________________________________ label and text field of 'Author' */		
		
	    JLabel lblAuthor = new JLabel("Author :");
		lblAuthor.setBounds(10, 80, 46, 14);
		add(lblAuthor);
		
		txtF_author = new JTextField();
		txtF_author.setBounds(66, 77, 151, 20);
		add(txtF_author);
		txtF_author.setColumns(10);
		
/* ___________________________________________________________________________________________________________________________ label and text field of 'Price' & NIS */			
		
		JLabel lblPrice = new JLabel("Price : ");
		lblPrice.setBounds(301, 49, 46, 14);
		add(lblPrice);
		
		txtF_price = new JTextField();
		txtF_price.setBounds(344, 46, 86, 20);
		add(txtF_price);
		txtF_price.setColumns(10);
		
		JLabel lblNis = new JLabel("\u20AA");				// label of NIS sign 
		lblNis.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNis.setBounds(433, 47, 25, 14);
		add(lblNis);
	
		
		/* ********    TextField validation    ***********/

		txtF_price.addKeyListener(new KeyAdapter() {  	// allow only digits and backspace.  otherwise set editable=false & display message
			@Override
			public void keyPressed(KeyEvent tmp) {
		
				int key = tmp.getKeyCode();
				
				if(!((key >= tmp.VK_0 && key <= tmp.VK_9)||(key >= KeyEvent.VK_NUMPAD0 && key <= tmp.VK_NUMPAD9)||key == tmp.VK_BACK_SPACE ))
					txtF_price.setEditable(false);
				else{
					txtF_price.setEditable(true);
				}
				//else{
				//	txtF_price.setEditable(false);    // don't let to write anything thats not a digit
				//	JOptionPane.showMessageDialog(null,"Price must be a number", "Input Error",JOptionPane.ERROR_MESSAGE);
				//	txtF_price.setEditable(true);
				}
			}
		);
		
		/* ********  note label ***********/		
		JLabel lblpriceNote = new JLabel("format:  Digits only");
		lblpriceNote.setForeground(Color.GRAY);
		lblpriceNote.setBounds(344, 66, 114, 14);
		add(lblpriceNote);
		lblpriceNote.setVisible(false);
		
		txtF_price.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lblpriceNote.setVisible(true);	
			}
		});
		
		txtF_price.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				lblpriceNote.setVisible(false);	
				txtF_price.setEditable(true);
			}
		});

/* ___________________________________________________________________________________________________________________________ label and text field of 'Key words' */	
		
		JLabel lblKeyWords = new JLabel("Key words : ");
		lblKeyWords.setBounds(10, 111, 86, 14);
		add(lblKeyWords);
		
		txtF_keywords = new JTextField();
		txtF_keywords.setBounds(86, 108, 217, 20);
		add(txtF_keywords);
		txtF_keywords.setColumns(10);
	
		
		/* ********  note label ***********/		
		JLabel lblKeyWNote = new JLabel("format:  Words separated by a comma");
		lblKeyWNote.setForeground(Color.GRAY);
		lblKeyWNote.setBounds(86, 128, 261, 14);
		add(lblKeyWNote);
		lblKeyWNote.setVisible(false);
		
		txtF_keywords.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lblKeyWNote.setVisible(true);	
			}
		});
		
		txtF_keywords.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				lblKeyWNote.setVisible(false);	
			}
		});

/* ___________________________________________________________________________________________________________________________ SUBJECT */		
		
		/* ************************* Cancel and Save buttons ***********************************/	
				
		JButton btnCancel_chSubject = new JButton("Cancel");
		btnCancel_chSubject.setBounds(241, 280, 89, 23);
		add(btnCancel_chSubject);
		btnCancel_chSubject.setVisible(false);
				
		JButton btnSave_chSubject = new JButton("Save");
		btnSave_chSubject.setBounds(347, 280, 89, 23);
		add(btnSave_chSubject);
		btnSave_chSubject.setVisible(false);
		btnSave_chSubject.setEnabled(false);       // disabled.  will  be enable only if at least one check box is selected
		
		
		/* ************************ 'Choose a subject' table ************************************/	
				
		JScrollPane scrollPane_subTable = new JScrollPane();
		scrollPane_subTable.setBorder(new LineBorder(new Color(130, 135, 144), 2));
		scrollPane_subTable.setBounds(196, 146, 280, 131);
		add(scrollPane_subTable);
				
		table_chSubject = new JTable();
		table_chSubject.setRowSelectionAllowed(false);
		scrollPane_subTable.setViewportView(table_chSubject);
		table_chSubject.setModel(new DefaultTableModel(
		
		new Object[][] {{null, null, null},	{null, null, null},	{null, null, null},	{null, null, null},	{null, null, null},
						{null, null, null},	{null, null, null},	{null, null, null},	{null, null, null},	},
					
		new String[] {"Category", "Subject", ""	}
		)
		
		{
			Class[] columnTypes = new Class[] {	Object.class, Object.class, Boolean.class};
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
		});
		
		table_chSubject.getColumnModel().getColumn(0).setResizable(false);
		table_chSubject.getColumnModel().getColumn(0).setPreferredWidth(100);
		table_chSubject.getColumnModel().getColumn(0).setMaxWidth(100);
		table_chSubject.getColumnModel().getColumn(1).setMaxWidth(100);
		table_chSubject.getColumnModel().getColumn(2).setResizable(false);
		table_chSubject.getColumnModel().getColumn(2).setPreferredWidth(50);
		table_chSubject.getColumnModel().getColumn(2).setMaxWidth(100);
		table_chSubject.setVisible(false);
		scrollPane_subTable.setVisible(false);               // hide table if 'save category' button has not been pressed yet
				
		for(int i=0;i<table_chSubject.getRowCount();i++){   // initialize column 2 (check-boxes) in table to 'false'
			table_chSubject.setValueAt(false, i, 2);
		}
		
		
		/* ****************** enable save only when at least one check box is selected ***********************/
				   
		SubArrayCheckBox = new boolean[table_chSubject.getRowCount()]; // array for current check-boxes column state
		SubOldArrayCheckBox=new boolean[table_chSubject.getRowCount()]; // array for cancel button
						   
		table_chSubject.getModel().addTableModelListener(new TableModelListener() {  // tableChanged listener.  also update the table column to the current state
			public void tableChanged(TableModelEvent e) {
			            	   
				int row1 = e.getFirstRow();
				int column1 = e.getColumn();
			            	   	            	    
		   	    if (column1 == 2) {   // if a change happened in the check boxes column
			            	    
		   	    	TableModel model1 = (TableModel) e.getSource();
			        Boolean checked1 = (Boolean) model1.getValueAt(row1, 2);
		   	        SubArrayCheckBox[row1]=checked1;    // update the changed cell state in the SubArrayCheckBox
			            	        
		   	  	    for(int i=0;i<SubArrayCheckBox.length;i++)
		   	  	    	if(SubArrayCheckBox[i] == true)   // count how many check-boxes are selected
		   	  	    		SubCountCheckBox++;
			            	  	    
			       	    if(SubCountCheckBox > 0){   // if there are selected check-boxes -> enable save button
			       	    	btnSave_chSubject.setEnabled(true);
			       	        SubCountCheckBox=0;
			       	      }
			   	  	    else{
			   	  	    	btnSave_chSubject.setEnabled(false);
			   	  	    	SubCountCheckBox=0;
			       	  	    }
			    }
			}
		});
			   
		/* ************************* Cancel and Save buttons listeners ***********************************/
				
	    btnSave_chSubject.addActionListener(new ActionListener() {   // if save button pressed
	    	public void actionPerformed(ActionEvent arg0) {
	    		table_chSubject.setVisible(false);   // hide table,save button,cancel button
			    scrollPane_subTable.setVisible(false);
				btnSave_chSubject.setVisible(false);
				btnCancel_chSubject.setVisible(false);
				count_oneChooseAtOnce=0;   // sign that subject panel isn't open anymore -> we can press on category,subject,content
		   	}
		});
		
	    btnCancel_chSubject.addActionListener(new ActionListener() {   // if cancel button pressed
			public void actionPerformed(ActionEvent arg0) {
				table_chSubject.setVisible(false);   // hide table,save button,cancel button
				scrollPane_subTable.setVisible(false);
				btnSave_chSubject.setVisible(false);
				btnCancel_chSubject.setVisible(false);
				count_oneChooseAtOnce=0;   // sign that subject panel isn't open anymore -> we can press on category,subject,content
		   				
			    for(int i=0;i<SubArrayCheckBox.length;i++){   // ignore the changes in the check-box column and preserve the old state
			    	SubArrayCheckBox[i] = SubOldArrayCheckBox[i];
		   			table_chSubject.setValueAt(SubOldArrayCheckBox[i], i, 2);
		   		}
		   			    
		/*  System.out.println("----table (not arrays!) --------");          //print to check
	   		for(int i=0;i<SubArrayCheckBox.length;i++){
  				System.out.println(table_chSubject.getValueAt(i, 2));
  		     }
	   	*/
		    }
		});	

			    
		/* ************************* label and choose button of 'Subjects' ***********************************/
		   		
		JLabel lblSubjects = new JLabel("Subjects :");
		lblSubjects.setBounds(10, 196, 63, 14);
		add(lblSubjects);	
		
		JButton btnChooseSubject = new JButton("Choose");
		btnChooseSubject.addActionListener(new ActionListener() {   // if choose button pressed
			public void actionPerformed(ActionEvent e) {
		   				
				if( count_oneChooseAtOnce==0 )   //  no other panel (category,subject,content) is opened already
				  { 
					scrollPane_subTable.setVisible(true);    
					table_chSubject.setVisible(true);   // show table,save button,cancel button
					btnSave_chSubject.setVisible(true);
					btnCancel_chSubject.setVisible(true);
					count_oneChooseAtOnce=1;   // sign that subject panel is open -> we can't open another panel (category,subject,content)
		   					
		   					
		   			for(int i=0;i<SubArrayCheckBox.length;i++)   // load current check box state (before next changes) to SubOldArrayCheckBox
		   				SubOldArrayCheckBox[i] = SubArrayCheckBox[i];
		   		  }
		   			    
				/*  System.out.println("----table (not arrays!) --------");          //print to check
		   		for(int i=0;i<SubArrayCheckBox.length;i++){
	  				System.out.println(table_chSubject.getValueAt(i, 2));
	  		     }
		        */
		   }
		});
		   	
		btnChooseSubject.setBounds(86, 194, 90, 20);
		add(btnChooseSubject);
		btnChooseSubject.setEnabled(false);
			    
/* ___________________________________________________________________________________________________________________________ END SUBJECT */		

			    
/* ___________________________________________________________________________________________________________________________ CATEGORY */			
		
		/* ************************* Cancel and Save buttons ***********************************/	
		
		JButton btnCancel_chCategory = new JButton("Cancel");
		btnCancel_chCategory.setBounds(241, 280, 89, 23);
		add(btnCancel_chCategory);
		btnCancel_chCategory.setVisible(false);
		
	    JButton btnSave_chCategory = new JButton("Save");
	    btnSave_chCategory.setBounds(347, 280, 89, 23);
	    add(btnSave_chCategory);
	    btnSave_chCategory.setVisible(false);
	    btnSave_chCategory.setEnabled(false);       // disabled.  will  be enable only if at least one check box is selected

	    
        /* ************************ 'Choose a category' table ************************************/	
			    
		JScrollPane scrollPane_catTable = new JScrollPane();
	    scrollPane_catTable.setBorder(new LineBorder(new Color(130, 135, 144), 2));
	    scrollPane_catTable.setBounds(196, 146, 280, 131);
		add(scrollPane_catTable);
		
		table_chCategory = new JTable();
		table_chCategory.setRowSelectionAllowed(false);
		scrollPane_catTable.setViewportView(table_chCategory);
		table_chCategory.setModel(new DefaultTableModel(
				
		new Object[][] {{null, null},{null, null},{null, null},	{null, null},{null, null},{null, null},{null, null},{null, null},{null, null},},
		
		new String[] {"Category", "" }
		)
		
		{
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] { Object.class, Boolean.class};
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
		});
		
		table_chCategory.getColumnModel().getColumn(0).setResizable(false);
		table_chCategory.getColumnModel().getColumn(0).setPreferredWidth(145);
		table_chCategory.getColumnModel().getColumn(1).setResizable(false);
		table_chCategory.getColumnModel().getColumn(1).setPreferredWidth(70);
		table_chCategory.getColumnModel().getColumn(1).setMaxWidth(50);
		table_chCategory.setVisible(false);
		scrollPane_catTable.setVisible(false);               // hide table if 'choose category' button has not been pressed yet
		
		for(int i=0;i<table_chCategory.getRowCount();i++){   // initialize column 1 (check-boxes) in table to 'false'
			table_chCategory.setValueAt(false, i, 1);
		}
		
		
		/* ****************** enable save only when at least one check box is selected ***********************/
		   
		CatArrayCheckBox = new boolean[table_chCategory.getRowCount()]; // array for current check-boxes column state
		CatOldArrayCheckBox=new boolean[table_chCategory.getRowCount()]; // array for cancel button
				   
		table_chCategory.getModel().addTableModelListener(new TableModelListener() {   // tableChanged listener.  also update the table column to the current state
			public void tableChanged(TableModelEvent e) {
	            	   
				int row = e.getFirstRow();
        	    int column = e.getColumn();
	            	   	            	    
	            if (column == 1) {   // if a change happened in the check boxes column
	            	    
	               	TableModel model = (TableModel) e.getSource();
	                Boolean checked = (Boolean) model.getValueAt(row, 1);
	                CatArrayCheckBox[row]=checked;    // update the changed cell state in the CatArrayCheckBox
	            	        
	            	for(int i=0;i<CatArrayCheckBox.length;i++)
	       	            if(CatArrayCheckBox[i] == true)   // count how many check-boxes are selected
	       	                CatCountCheckBox++;
	            	  	    
	            	  	if(CatCountCheckBox > 0){    // if there are selected check-boxes -> enable save button
	            	  	   	btnSave_chCategory.setEnabled(true);
	            	  	    CatCountCheckBox=0;
	            	  	  }
	            	  	else{
	            	  	   	btnSave_chCategory.setEnabled(false);
	            	  	   	CatCountCheckBox=0;
	            	  	    }
	            }
	       	}
	    });
		   
		/* ************************* Cancel and Save buttons listeners ***********************************/
			
		btnSave_chCategory.addActionListener(new ActionListener() {   // if save button pressed
			public void actionPerformed(ActionEvent arg0) {
				table_chCategory.setVisible(false);      // hide table,save button,cancel button
				scrollPane_catTable.setVisible(false);
				btnSave_chCategory.setVisible(false);
				btnCancel_chCategory.setVisible(false);
				count_oneChooseAtOnce=0;   // sign that category panel isn't open anymore -> we can press on category,subject,content
				btnChooseSubject.setEnabled(true); // only when a category is chosen, enable subject button
			}
		});
		
		btnCancel_chCategory.addActionListener(new ActionListener() {   // if cancel button pressed
			public void actionPerformed(ActionEvent arg0) {
		   		table_chCategory.setVisible(false);   // hide table,save button,cancel button
		   		scrollPane_catTable.setVisible(false);
		   		btnSave_chCategory.setVisible(false);
		   		btnCancel_chCategory.setVisible(false);
		   		count_oneChooseAtOnce=0;   // sign that category panel isn't open anymore -> we can press on category,subject,content
		   				
		   	    for(int i=0;i<CatArrayCheckBox.length;i++){   // ignore the changes in the check-box column and preserve the old state
		   	    	CatArrayCheckBox[i] = CatOldArrayCheckBox[i];
		   			table_chCategory.setValueAt(CatOldArrayCheckBox[i], i, 1);
		   		}
		   			    
	   /*  System.out.println("----table (not arrays!) --------");          //print to check
	   	   for(int i=0;i<CatArrayCheckBox.length;i++){
   		       System.out.println(table_chCategory.getValueAt(i, 1));
   		    }
	   */
		   }
	   });	
		   		
	  
	   /* ************************* label and button of 'category' ***********************************/
		   		
  	   JLabel lblCategories = new JLabel("Categories : ");
	   lblCategories.setBounds(10, 167, 76, 14);
	   add(lblCategories);
		
	   JButton btnChooseCategory = new JButton("Choose");
	   btnChooseCategory.addActionListener(new ActionListener() {     // if choose button pressed
		   public void actionPerformed(ActionEvent e) {
		   				
		       if( count_oneChooseAtOnce==0 )   //  no other panel (category,subject,content) is opened already
				 { 
		   		   table_chCategory.setVisible(true);   // show table,save button,cancel button
		   		   scrollPane_catTable.setVisible(true);
		   		   btnSave_chCategory.setVisible(true);
		   		   btnCancel_chCategory.setVisible(true);
		   		   count_oneChooseAtOnce=1;   // sign that category panel is open -> we can't open another panel (category,subject,content)
		   					
		   					
		   		   for(int i=0;i<CatArrayCheckBox.length;i++)      // load current check box state (before next changes) to CatOldArrayCheckBox
		   		       CatOldArrayCheckBox[i] = CatArrayCheckBox[i];
		   		 }
		   			    
		/*  System.out.println("----table (not arrays!) --------");          //print to check
			for(int i=0;i<CatArrayCheckBox.length;i++){
	   		    System.out.println(table_chCategory.getValueAt(i, 1));
	   		 }
		*/
		    }
		});
		   	
		btnChooseCategory.setBounds(86, 164, 90, 20);
		add(btnChooseCategory);
  		
/* ___________________________________________________________________________________________________________________________ END CATEGORY */
		   		

/* ___________________________________________________________________________________________________________________________ CONTENT */			   		
				
		/* ************************* cancel and save buttons ***********************************/	
				
		JButton btnCancel_Content = new JButton("Cancel");
		btnCancel_Content.setBounds(241, 280, 89, 23);
		add(btnCancel_Content);
		btnCancel_Content.setVisible(false);
				
		JButton btnSave_Content = new JButton("Save");
		btnSave_Content.setBounds(347, 280, 89, 23);
		add(btnSave_Content);
		btnSave_Content.setVisible(false);
		btnSave_Content.setEnabled(false);			// disabled. will  be enable only if there is text in 'content text area'

		
		/* ************************ 'Write content' text area and scroll **********************/	
					    
		JScrollPane scrollPane_contentArea = new JScrollPane();
		scrollPane_contentArea.setBorder(new LineBorder(new Color(130, 135, 144), 2));
		scrollPane_contentArea.setBounds(196, 146, 280, 131);
		add(scrollPane_contentArea);
					    
		JTextArea textAreaContent = new JTextArea();
		textAreaContent.setLineWrap(true);
		scrollPane_contentArea.setViewportView(textAreaContent);
		textAreaContent.setVisible(false);
		scrollPane_contentArea.setVisible(false);
		
		textAreaContent.addKeyListener(new KeyAdapter() {   // enable save button only if there is text in 'content text area'
			@Override
			public void keyReleased(KeyEvent arg0) {
					if(!(textAreaContent.getText().isEmpty())) {
					btnSave_Content.setEnabled(true);
			    }else {
			    	btnSave_Content.setEnabled(false);
			    }
			}
		});
		
		/* ************************* Cancel and Save buttons listeners ***********************************/
						
		btnSave_Content.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textAreaContent.setVisible(false);      // hide textArea,save button,cancel button
				scrollPane_contentArea.setVisible(false);
				btnSave_Content.setVisible(false);
				btnCancel_Content.setVisible(false);
				count_oneChooseAtOnce=0;   // sign that content panel isn't open anymore -> we can press on category,subject,content
			}
		});
					
				
		btnCancel_Content.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textAreaContent.setVisible(false);      // hide textArea,save button,cancel button
				scrollPane_contentArea.setVisible(false);
				btnSave_Content.setVisible(false);
				btnCancel_Content.setVisible(false);
				count_oneChooseAtOnce=0;   // sign that content panel isn't open anymore -> we can press on category,subject,content
				
				textAreaContent.setText(oldContent);   // ignore changes in content text area. 
			}
		});	    
				
		/* ************************* label and button of 'Content' ***********************************/
		
		JLabel lblContent = new JLabel("Content : ");
		lblContent.setBounds(10, 225, 63, 14);
		add(lblContent);
				
		JButton btnContent = new JButton("Write");
		btnContent.addActionListener(new ActionListener() {     // if Write button pressed
			public void actionPerformed(ActionEvent arg0) {
				if( count_oneChooseAtOnce==0 )   //  no other panel (category,subject,content) is opened already
				 {  textAreaContent.setVisible(true);   // show textArea,save button,cancel button
				 	scrollPane_contentArea.setVisible(true);
				   	btnSave_Content.setVisible(true);
				   	btnCancel_Content.setVisible(true);
				   	count_oneChooseAtOnce=1;   // sign that content panel is open -> we can't open another panel (category,subject,content)
				   	
				   	oldContent = textAreaContent.getText();   // preserve the text of 'content text area' before changes
				 }
		}});
		
		btnContent.setBounds(86, 222, 90, 20);
		add(btnContent);
						   		
/* ___________________________________________________________________________________________________________________________ END CONTENT */
		   		
		
/* ___________________________________________________________________________________________________________________________ label,combo-box of 'Format' and 'Upload file' button */		
		
		JLabel lblFormat = new JLabel("Format : ");
		lblFormat.setBounds(10, 332, 56, 14);
		add(lblFormat);
		
		JButton btnUploadFile = new JButton("Upload file");
		btnUploadFile.setBounds(186, 329, 99, 20);
		add(btnUploadFile);
		btnUploadFile.setEnabled(false);
		
		
		String[] formatTypes = {"","doc","pdf","fb2"};  // temp values
		JComboBox comboBoxFormat = new JComboBox(formatTypes);
		comboBoxFormat.setBounds(86, 329, 90, 20);
		add(comboBoxFormat);	
		
		comboBoxFormat.addItemListener(new ItemListener(){      // listener - if format combo box has been selected , enable 'Upload file' button
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                	btnUploadFile.setEnabled(true);
                }
            }
        });
		
/* ___________________________________________________________________________________________________________________________ label and check-boxes of 'Language' */		
		
		JLabel lblLanguage = new JLabel("Language : ");
		lblLanguage.setBounds(10, 360, 70, 14);
		add(lblLanguage);
		
		JCheckBox checkboxHebrew = new JCheckBox("Hebrew");
		checkboxHebrew.setBounds(83, 356, 70, 23);
		add(checkboxHebrew);
		
		JCheckBox checkboxEnglish = new JCheckBox("English");
		checkboxEnglish.setBounds(156, 356, 70, 23);
		add(checkboxEnglish);
		
		JCheckBox checkboxRussian = new JCheckBox("Russian");
		checkboxRussian.setBounds(228, 356, 76, 23);
		add(checkboxRussian);
		
		JCheckBox checkboxArabic = new JCheckBox("Arabic");
		checkboxArabic.setBounds(301, 356, 72, 23);
		add(checkboxArabic);
		
/* ___________________________________________________________________________________________________________________________ label,scroll and text area of 'Summary' */			
		
		JLabel lblSummary = new JLabel("Summary :");
		lblSummary.setBounds(10, 395, 70, 14);
		add(lblSummary);
		
		JScrollPane scrollPane_summary = new JScrollPane();
		scrollPane_summary.setBounds(86, 395, 299, 102);
		add(scrollPane_summary);
		
		JTextArea textAreaSummary = new JTextArea();
		scrollPane_summary.setViewportView(textAreaSummary);
		textAreaSummary.setLineWrap(true);
		
/* ___________________________________________________________________________________________________________________________ button of 'ADD' */				
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setBounds(413, 458, 63, 39);
		add(btnAdd);
		
/* ___________________________________________________________________________________________________________________________ */
	

	}
}
