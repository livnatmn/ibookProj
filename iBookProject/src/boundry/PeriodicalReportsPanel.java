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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
	import java.awt.event.ActionEvent;
	import controller.WorkerController;
	import javax.swing.JComboBox;
	import java.awt.FlowLayout;
	import java.awt.BorderLayout;
	import javax.swing.BoxLayout;
	import javax.swing.ComboBoxModel;

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
import javax.swing.JList;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.AbstractListModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


	public class PeriodicalReportsPanel extends JPanel{
		private JTextField txtF_UserRepUserId;
		private JTable tableAbs;
		private JTable tableComp;
		private JTextField txtF_AbsBookName;
		private JTextField txtF_CompBookName;

		
		
		public PeriodicalReportsPanel() {          // Constructor
		
			initialize();
		}
		
		
		@SuppressWarnings({ "rawtypes", "serial", "unchecked" })
		private void initialize() {
			setLayout(null);
			
			/* ******************************************************************/
			/* *********** Popularity report - comparative rank *****************/
			/* ******************************************************************/
			
			
	        /* _________________________________________________________________ label of 'Book' */			
			
			JLabel lblCompBook = new JLabel("Book :");
			lblCompBook.setBounds(209, 127, 46, 14);
			add(lblCompBook);
			lblCompBook.setVisible(false);
			
	        /* _________________________________________________________________ combo-box of 'Book' */	
			
			String[] booksList3 = {"","Booka 1","Booka 2"};  // temp values
			JComboBox comboBox_Comp_Books = new JComboBox(booksList3);
			comboBox_Comp_Books.setBounds(260, 124, 155, 20);
			add(comboBox_Comp_Books);
			comboBox_Comp_Books.setEnabled(false);
			comboBox_Comp_Books.setVisible(false);
			
		    /* _________________________________________________________________ label of 'Subject' */
			
			JLabel lblCompSubject = new JLabel("Subject : ");
			lblCompSubject.setBounds(195, 91, 72, 14);
			add(lblCompSubject);
			lblCompSubject.setVisible(false);
	        /* _________________________________________________________________ combo-box of 'Subject' */
			
			String[] SubjectsList3 = {"","Subjecta 1","Subjecta 2"};  // temp values
			JComboBox comboBox_Comp_Subjects = new JComboBox(SubjectsList3);
			comboBox_Comp_Subjects.setBounds(260, 88, 155, 20);
			add(comboBox_Comp_Subjects);
			comboBox_Comp_Subjects.setEnabled(false);
			comboBox_Comp_Subjects.setVisible(false);
			
			comboBox_Comp_Subjects.addItemListener(new ItemListener(){      // listener - if subject combo box has been selected , enable book combo box
	            @Override
	            public void itemStateChanged(ItemEvent e) {
	                if(e.getStateChange() == ItemEvent.SELECTED){
	                	comboBox_Comp_Books.setEnabled(true);
	                }
	            }
	        });
			
	        /* ________________________________________________________________ label of 'Category' */
			
			JLabel lblCompCategory = new JLabel("Category : ");
			lblCompCategory.setBounds(187, 55, 72, 14);
			add(lblCompCategory);
			lblCompCategory.setVisible(false);
			
	        /* ________________________________________________________________ combo-box of 'Category' */
			
			String[] CategoriesList3 = {"","categorya 1","categorya 2"};  // temp values
			JComboBox comboBox_Comp_Categories = new JComboBox(CategoriesList3);
			comboBox_Comp_Categories.setBounds(260, 52, 155, 20);
			add(comboBox_Comp_Categories);
			comboBox_Comp_Categories.setVisible(false);
			
			comboBox_Comp_Categories.addItemListener(new ItemListener(){      // listener - if category combo box has been selected , enable subject combo box
	            @Override
	            public void itemStateChanged(ItemEvent e) {
	                if(e.getStateChange() == ItemEvent.SELECTED){
	                	comboBox_Comp_Subjects.setEnabled(true);
	                }
	            }
	        });
			 /* ________________________________________________________________ */
			
			JButton btnCompSearch = new JButton("Search");
			btnCompSearch.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnCompSearch.setBounds(300, 161, 87, 23);
			add(btnCompSearch);
			btnCompSearch.setVisible(false);
			btnCompSearch.setEnabled(false);
			
			 /* ________________________________________________________________ */
			JLabel lblComparativeRankPopularity = new JLabel("Comparative rank popularity of:");
			lblComparativeRankPopularity.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblComparativeRankPopularity.setBounds(251, 208, 194, 14);
			add(lblComparativeRankPopularity);
			lblComparativeRankPopularity.setVisible(false);
			
			txtF_CompBookName = new JTextField();
			txtF_CompBookName.setEnabled(false);
			txtF_CompBookName.setBounds(239, 225, 194, 20);
			add(txtF_CompBookName);
			txtF_CompBookName.setColumns(10);
			txtF_CompBookName.setEditable(false);
			txtF_CompBookName.setVisible(false);
			
			 /* ________________________________________________________________ */
			JScrollPane scrollPaneComp = new JScrollPane();
			scrollPaneComp.setBounds(191, 251, 293, 237);
			add(scrollPaneComp);
			scrollPaneComp.setVisible(false);
			
			tableComp = new JTable();
			scrollPaneComp.setViewportView(tableComp);
			tableComp.setModel(new DefaultTableModel(
				new Object[][] {
					{null, ""},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
				},
				new String[] {
					"Book Name", "Rank"
				}
			));
			tableComp.getColumnModel().getColumn(0).setResizable(false);
			tableComp.getColumnModel().getColumn(0).setPreferredWidth(137);
			tableComp.getColumnModel().getColumn(1).setResizable(false);
			tableComp.getColumnModel().getColumn(1).setPreferredWidth(103);
			tableComp.setVisible(false);			
			/* ******************************************************************/
			
			comboBox_Comp_Books.addItemListener(new ItemListener(){      // listener - if book combo box has been selected , enable search button
	            @Override
	            public void itemStateChanged(ItemEvent e) {
	                if(e.getStateChange() == ItemEvent.SELECTED){
	                	btnCompSearch.setEnabled(true);
	                }
	            }
	        });
			
			btnCompSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					lblComparativeRankPopularity.setVisible(true);
					txtF_CompBookName.setVisible(true);
					scrollPaneComp.setVisible(true);
					tableComp.setVisible(true);
				}
			});
			
			/* ******************************************************************/
			/* ************* Popularity report - absolute rank ******************/
			/* ******************************************************************/
			
			
	        /* _________________________________________________________________ label of 'Book' */			
			
			JLabel lblAbsBook = new JLabel("Book :");
			lblAbsBook.setBounds(209, 127, 46, 14);
			add(lblAbsBook);
			lblAbsBook.setVisible(false);
			
	        /* _________________________________________________________________ combo-box of 'Book' */	
			
			String[] booksList2 = {"","Book 1","Book 2"};  // temp values
			JComboBox comboBox_Abs_Books = new JComboBox(booksList2);
			comboBox_Abs_Books.setBounds(260, 124, 155, 20);
			add(comboBox_Abs_Books);
			comboBox_Abs_Books.setEnabled(false);
			comboBox_Abs_Books.setVisible(false);
			
		    /* _________________________________________________________________ label of 'Subject' */
			
			JLabel lblAbsSubject = new JLabel("Subject : ");
			lblAbsSubject.setBounds(195, 91, 72, 14);
			add(lblAbsSubject);
			lblAbsSubject.setVisible(false);
	        /* _________________________________________________________________ combo-box of 'Subject' */
			
			String[] SubjectsList2 = {"","Subject 1","Subject 2"};  // temp values
			JComboBox comboBox_Abs_Subjects = new JComboBox(SubjectsList2);
			comboBox_Abs_Subjects.setBounds(260, 88, 155, 20);
			add(comboBox_Abs_Subjects);
			comboBox_Abs_Subjects.setEnabled(false);
			comboBox_Abs_Subjects.setVisible(false);
			
			comboBox_Abs_Subjects.addItemListener(new ItemListener(){      // listener - if subject combo box has been selected , enable book combo box
	            @Override
	            public void itemStateChanged(ItemEvent e) {
	                if(e.getStateChange() == ItemEvent.SELECTED){
	                	comboBox_Abs_Books.setEnabled(true);
	                }
	            }
	        });
			
	        /* ________________________________________________________________ label of 'Category' */
			
			JLabel lblAbsCategory = new JLabel("Category : ");
			lblAbsCategory.setBounds(187, 55, 72, 14);
			add(lblAbsCategory);
			lblAbsCategory.setVisible(false);
			
	        /* ________________________________________________________________ combo-box of 'Category' */
			
			String[] CategoriesList2 = {"","category 1","category 2"};  // temp values
			JComboBox comboBox_Abs_Categories = new JComboBox(CategoriesList2);
			comboBox_Abs_Categories.setBounds(260, 52, 155, 20);
			add(comboBox_Abs_Categories);
			comboBox_Abs_Categories.setVisible(false);
			
			comboBox_Abs_Categories.addItemListener(new ItemListener(){      // listener - if category combo box has been selected , enable subject combo box
	            @Override
	            public void itemStateChanged(ItemEvent e) {
	                if(e.getStateChange() == ItemEvent.SELECTED){
	                	comboBox_Abs_Subjects.setEnabled(true);
	                }
	            }
	        });
			 /* ________________________________________________________________ */
			
			JButton btnAbsSearch = new JButton("Search");
			btnAbsSearch.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnAbsSearch.setBounds(300, 161, 87, 23);
			add(btnAbsSearch);
			btnAbsSearch.setVisible(false);
			btnAbsSearch.setEnabled(false);
			
			 /* ________________________________________________________________ */
			JLabel lblAbsoluteRankPopularity = new JLabel("Absolute rank popularity of:");
			lblAbsoluteRankPopularity.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblAbsoluteRankPopularity.setBounds(259, 208, 174, 14);
			add(lblAbsoluteRankPopularity);
			lblAbsoluteRankPopularity.setVisible(false);
			
			txtF_AbsBookName = new JTextField();
			txtF_AbsBookName.setEditable(false);
			txtF_AbsBookName.setEnabled(false);
			txtF_AbsBookName.setBounds(239, 225, 193, 20);
			add(txtF_AbsBookName);
			txtF_AbsBookName.setColumns(10);
			txtF_AbsBookName.setVisible(false);
			 /* ________________________________________________________________ */
			JScrollPane scrollPaneAbs = new JScrollPane();
			scrollPaneAbs.setBounds(191, 251, 293, 237);
			add(scrollPaneAbs);
			scrollPaneAbs.setVisible(false);
			
			tableAbs = new JTable();
			scrollPaneAbs.setViewportView(tableAbs);
			tableAbs.setModel(new DefaultTableModel(
				new Object[][] {
					{null, ""},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
				},
				new String[] {
					"Book Name", "Rank"
				}
			));
			tableAbs.getColumnModel().getColumn(0).setResizable(false);
			tableAbs.getColumnModel().getColumn(0).setPreferredWidth(137);
			tableAbs.getColumnModel().getColumn(1).setResizable(false);
			tableAbs.getColumnModel().getColumn(1).setPreferredWidth(103);
			tableAbs.setVisible(false);			
			/* ******************************************************************/
			
			comboBox_Abs_Books.addItemListener(new ItemListener(){      // listener - if book combo box has been selected , enable search button
	            @Override
	            public void itemStateChanged(ItemEvent e) {
	                if(e.getStateChange() == ItemEvent.SELECTED){
	                	btnAbsSearch.setEnabled(true);
	                }
	            }
	        });
			
			btnAbsSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					lblAbsoluteRankPopularity.setVisible(true);
					txtF_AbsBookName.setVisible(true);
					scrollPaneAbs.setVisible(true);
					tableAbs.setVisible(true);
				}
			});
			/* ******************************************************************/
			/* ************************* Book Report ****************************/
			/* ******************************************************************/
			
			
			JButton btnBookRepSearch = new JButton("Search");
			btnBookRepSearch.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnBookRepSearch.setBounds(300, 161, 87, 23);
			add(btnBookRepSearch);
			btnBookRepSearch.setVisible(false);
			btnBookRepSearch.setEnabled(false);
			
	        /* _________________________________________________________________ label of 'Book' */			
			
			JLabel lblBookRepBook = new JLabel("Book :");
			lblBookRepBook.setBounds(209, 127, 46, 14);
			add(lblBookRepBook);
			lblBookRepBook.setVisible(false);
			
	        /* _________________________________________________________________ combo-box of 'Book' */	
			
			String[] booksList = {"","Book 1","Book 2"};  // temp values
			JComboBox comboBox_BookRep_Books = new JComboBox(booksList);
			comboBox_BookRep_Books.setBounds(260, 124, 155, 20);
			add(comboBox_BookRep_Books);
			comboBox_BookRep_Books.setEnabled(false);
			comboBox_BookRep_Books.setVisible(false);
			
			comboBox_BookRep_Books.addItemListener(new ItemListener(){      // listener - if book combo box has been selected , enable search button
	            @Override
	            public void itemStateChanged(ItemEvent e) {
	                if(e.getStateChange() == ItemEvent.SELECTED){
	                	btnBookRepSearch.setEnabled(true);
	                }
	            }
	        });
			
	        /* _________________________________________________________________ label of 'Subject' */
			
			JLabel lblBookRepSubject = new JLabel("Subject : ");
			lblBookRepSubject.setBounds(195, 91, 72, 14);
			add(lblBookRepSubject);
			lblBookRepSubject.setVisible(false);
	        /* _________________________________________________________________ combo-box of 'Subject' */
			
			String[] SubjectsList = {"","Subject 1","Subject 2"};  // temp values
			JComboBox comboBox_BookRep_Subjects = new JComboBox(SubjectsList);
			comboBox_BookRep_Subjects.setBounds(260, 88, 155, 20);
			add(comboBox_BookRep_Subjects);
			comboBox_BookRep_Subjects.setEnabled(false);
			comboBox_BookRep_Subjects.setVisible(false);
			
			comboBox_BookRep_Subjects.addItemListener(new ItemListener(){      // listener - if subject combo box has been selected , enable book combo box
	            @Override
	            public void itemStateChanged(ItemEvent e) {
	                if(e.getStateChange() == ItemEvent.SELECTED){
	                	comboBox_BookRep_Books.setEnabled(true);
	                }
	            }
	        });
			
	        /* ________________________________________________________________ label of 'Category' */
			
			JLabel lblBookRepCategory = new JLabel("Category : ");
			lblBookRepCategory.setBounds(187, 55, 72, 14);
			add(lblBookRepCategory);
			lblBookRepCategory.setVisible(false);
			
	        /* ________________________________________________________________ combo-box of 'Category' */
			
			String[] CategoriesList = {"","category 1","category 2"};  // temp values
			JComboBox comboBox_BookRep_Categories = new JComboBox(CategoriesList);
			comboBox_BookRep_Categories.setBounds(260, 52, 155, 20);
			add(comboBox_BookRep_Categories);
			comboBox_BookRep_Categories.setVisible(false);
			
			comboBox_BookRep_Categories.addItemListener(new ItemListener(){      // listener - if category combo box has been selected , enable subject combo box
	            @Override
	            public void itemStateChanged(ItemEvent e) {
	                if(e.getStateChange() == ItemEvent.SELECTED){
	                	comboBox_BookRep_Subjects.setEnabled(true);
	                }
	            }
	        });
			
			/* ******************************************************************/
			/* ************************* User Report ****************************/
			/* ******************************************************************/
			
			JLabel lblUserRepList = new JLabel("Read Book List :");
			lblUserRepList.setBounds(191, 94, 121, 14);
			add(lblUserRepList);
			lblUserRepList.setVisible(false);
			
			JList listUserRep = new JList();
			listUserRep.setModel(new AbstractListModel() {
				String[] values = new String[] {"adi", "hallel"};
				public int getSize() {
					return values.length;
				}
				public Object getElementAt(int index) {
					return values[index];
				}
			});
			listUserRep.setBorder(new LineBorder(new Color(0, 0, 0)));
			listUserRep.setBounds(191, 120, 293, 125);
			add(listUserRep);
			listUserRep.setVisible(false);
			/* ******************************************************************/
			
			JLabel lblIUserRepUserId = new JLabel("Insert User ID :");
			lblIUserRepUserId.setBounds(191, 55, 87, 14);
			add(lblIUserRepUserId);
			lblIUserRepUserId.setVisible(false);
			
			txtF_UserRepUserId = new JTextField();
			txtF_UserRepUserId.setBounds(283, 51, 86, 20);
			add(txtF_UserRepUserId);
			txtF_UserRepUserId.setColumns(10);
			txtF_UserRepUserId.setVisible(false);
			
						
			JButton btnUserRepSearch = new JButton("Search");
			btnUserRepSearch.setBounds(379, 51, 89, 23);
			add(btnUserRepSearch);
			btnUserRepSearch.setVisible(false);
			btnUserRepSearch.setEnabled(false);
			
			btnUserRepSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lblUserRepList.setVisible(true);
					listUserRep.setVisible(true);
						
					
				}
			});
			
			txtF_UserRepUserId.addKeyListener(new KeyAdapter() { 
			@Override
			public void keyReleased(KeyEvent arg0) {
					if(!(txtF_UserRepUserId.getText().isEmpty())) {
						btnUserRepSearch.setEnabled(true);
				    }else {
				    	btnUserRepSearch.setEnabled(false);
				    }
				}
			});
			
			/* ******************************************************************/
			/* ********************** Periodical Report *************************/
			/* ******************************************************************/
			
			JLabel lblPeriodRepSelectType = new JLabel("Select Type");
			lblPeriodRepSelectType.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblPeriodRepSelectType.setBounds(10, 165, 77, 14);
			add(lblPeriodRepSelectType);
			lblPeriodRepSelectType.setVisible(false);
			
			JButton btnAbsRank = new JButton("Absolute Rank");
			btnAbsRank.setBounds(10, 190, 146, 23);
			add(btnAbsRank);
			btnAbsRank.setVisible(false);
			
			JButton btnCompRank = new JButton("Comparative Rank");
			btnCompRank.setBounds(9, 224, 147, 23);
			add(btnCompRank);
			btnCompRank.setVisible(false);
			
		
			/* ******************************************************************/
			/* *************************Main panel*******************************/
			/* ******************************************************************/
			JLabel lblPreidocalReports = new JLabel("Preidocal Reports");
			lblPreidocalReports.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblPreidocalReports.setBounds(10, 11, 175, 29);
			add(lblPreidocalReports);
			
			JLabel lblUserReport = new JLabel("User Report");
			lblUserReport.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblUserReport.setBounds(286, 5, 104, 41);
			add(lblUserReport);
			lblUserReport.setVisible(false);
			
			JLabel lblBookReport = new JLabel("Book Report");
			lblBookReport.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblBookReport.setBounds(283, 7, 104, 36);
			add(lblBookReport);
			lblBookReport.setVisible(false);
			
			JLabel lblPopularityReport = new JLabel("Popularity Report");
			lblPopularityReport.setBounds(285, 5, 104, 14);
			add(lblPopularityReport);
			lblPopularityReport.setVisible(false);
			
			JLabel lblAbsoluteRank = new JLabel("Absolute Rank");
			lblAbsoluteRank.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblAbsoluteRank.setBounds(279, 9, 143, 39);
			add(lblAbsoluteRank);
			lblAbsoluteRank.setVisible(false);
			
			
			JLabel lblComparativeRank = new JLabel("Comparative Rank");
			lblComparativeRank.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblComparativeRank.setBounds(267, 11, 140, 35);
			add(lblComparativeRank);
			lblComparativeRank.setVisible(false);
			
			JButton btnUserReport = new JButton("User Report");
			btnUserReport.setBounds(10, 51, 146, 23);
			add(btnUserReport);
			
			btnUserReport.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					lblUserReport.setVisible(true);
					lblBookReport.setVisible(false);
					lblPopularityReport.setVisible(false);
					lblAbsoluteRank.setVisible(false);
					lblComparativeRank.setVisible(false);
					
					lblIUserRepUserId.setVisible(true);
					txtF_UserRepUserId.setVisible(true);
					btnUserRepSearch.setVisible(true);
					
					lblPeriodRepSelectType.setVisible(false);
					btnAbsRank.setVisible(false);
					btnCompRank.setVisible(false);
					
					btnBookRepSearch.setVisible(false);
					lblBookRepBook.setVisible(false);
					comboBox_BookRep_Books.setVisible(false);
					lblBookRepSubject.setVisible(false);
					comboBox_BookRep_Subjects.setVisible(false);
					lblBookRepCategory.setVisible(false);
					comboBox_BookRep_Categories.setVisible(false);
					
					lblAbsBook.setVisible(false);
					comboBox_Abs_Books.setVisible(false);
					lblAbsSubject.setVisible(false);
					comboBox_Abs_Subjects.setVisible(false);
					lblAbsCategory.setVisible(false);
					comboBox_Abs_Categories.setVisible(false);
					btnAbsSearch.setVisible(false);
					lblAbsoluteRankPopularity.setVisible(false);
					txtF_AbsBookName.setVisible(false);
					scrollPaneAbs.setVisible(false);
					tableAbs.setVisible(false);	
					
					lblCompBook.setVisible(false);
					comboBox_Comp_Books.setVisible(false);
					lblCompSubject.setVisible(false);
					comboBox_Comp_Subjects.setVisible(false);
					lblCompCategory.setVisible(false);
					comboBox_Comp_Categories.setVisible(false);
					btnCompSearch.setVisible(false);
					lblComparativeRankPopularity.setVisible(false);
					txtF_CompBookName.setVisible(false);
					scrollPaneComp.setVisible(false);
					tableComp.setVisible(false);
				}
			});
			
			JButton btnBookReport = new JButton("Book Report");
			btnBookReport.setBounds(10, 85, 146, 23);
			add(btnBookReport);
			
			btnBookReport.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					lblUserReport.setVisible(false);
					lblBookReport.setVisible(true);
					lblPopularityReport.setVisible(false);
					lblAbsoluteRank.setVisible(false);
					lblComparativeRank.setVisible(false);
					
					btnBookRepSearch.setVisible(true);
					lblBookRepBook.setVisible(true);
					comboBox_BookRep_Books.setVisible(true);
					lblBookRepSubject.setVisible(true);
					comboBox_BookRep_Subjects.setVisible(true);
					lblBookRepCategory.setVisible(true);
					comboBox_BookRep_Categories.setVisible(true);
					
					lblUserRepList.setVisible(false);
					listUserRep.setVisible(false);
					lblIUserRepUserId.setVisible(false);
					txtF_UserRepUserId.setVisible(false);
					btnUserRepSearch.setVisible(false);
					
					
					lblPeriodRepSelectType.setVisible(false);
					btnAbsRank.setVisible(false);
					btnCompRank.setVisible(false);
					btnAbsRank.setVisible(false);
					btnCompRank.setVisible(false);

					lblAbsBook.setVisible(false);
					comboBox_Abs_Books.setVisible(false);
					lblAbsSubject.setVisible(false);
					comboBox_Abs_Subjects.setVisible(false);
					lblAbsCategory.setVisible(false);
					comboBox_Abs_Categories.setVisible(false);
					btnAbsSearch.setVisible(false);
					lblAbsoluteRankPopularity.setVisible(false);
					txtF_AbsBookName.setVisible(false);
					scrollPaneAbs.setVisible(false);
					tableAbs.setVisible(false);	
					
					lblCompBook.setVisible(false);
					comboBox_Comp_Books.setVisible(false);
					lblCompSubject.setVisible(false);
					comboBox_Comp_Subjects.setVisible(false);
					lblCompCategory.setVisible(false);
					comboBox_Comp_Categories.setVisible(false);
					btnCompSearch.setVisible(false);
					lblComparativeRankPopularity.setVisible(false);
					txtF_CompBookName.setVisible(false);
					scrollPaneComp.setVisible(false);
					tableComp.setVisible(false);
					
				}
			});
			
			
			
			JButton btnPopularityReport = new JButton("Popularity Report");
			btnPopularityReport.setBounds(10, 117, 146, 23);
			add(btnPopularityReport);
		
			
			
			btnPopularityReport.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					lblUserReport.setVisible(false);
					lblBookReport.setVisible(false);
					lblPopularityReport.setVisible(true);
					lblAbsoluteRank.setVisible(false);
					lblComparativeRank.setVisible(false);
					
					lblPeriodRepSelectType.setVisible(true);
					btnAbsRank.setVisible(true);
					btnCompRank.setVisible(true);
					
					lblUserRepList.setVisible(false);
					listUserRep.setVisible(false);
					lblIUserRepUserId.setVisible(false);
					txtF_UserRepUserId.setVisible(false);
					btnUserRepSearch.setVisible(false);
					
					btnBookRepSearch.setVisible(false);
					lblBookRepBook.setVisible(false);
					comboBox_BookRep_Books.setVisible(false);
					lblBookRepSubject.setVisible(false);
					comboBox_BookRep_Subjects.setVisible(false);
					lblBookRepCategory.setVisible(false);
					comboBox_BookRep_Categories.setVisible(false);
					
					lblAbsBook.setVisible(false);
					comboBox_Abs_Books.setVisible(false);
					lblAbsSubject.setVisible(false);
					comboBox_Abs_Subjects.setVisible(false);
					lblAbsCategory.setVisible(false);
					comboBox_Abs_Categories.setVisible(false);
					btnAbsSearch.setVisible(false);
					lblAbsoluteRankPopularity.setVisible(false);
					txtF_AbsBookName.setVisible(false);
					scrollPaneAbs.setVisible(false);
					tableAbs.setVisible(false);	
					
					lblCompBook.setVisible(false);
					comboBox_Comp_Books.setVisible(false);
					lblCompSubject.setVisible(false);
					comboBox_Comp_Subjects.setVisible(false);
					lblCompCategory.setVisible(false);
					comboBox_Comp_Categories.setVisible(false);
					btnCompSearch.setVisible(false);
					lblComparativeRankPopularity.setVisible(false);
					txtF_CompBookName.setVisible(false);
					scrollPaneComp.setVisible(false);
					tableComp.setVisible(false);;
				}
			});
			
			btnCompRank.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lblCompBook.setVisible(true);
					comboBox_Comp_Books.setVisible(true);
					lblCompSubject.setVisible(true);
					comboBox_Comp_Subjects.setVisible(true);
					lblCompCategory.setVisible(true);
					comboBox_Comp_Categories.setVisible(true);
					btnCompSearch.setVisible(true);
					lblComparativeRankPopularity.setVisible(false);
					txtF_CompBookName.setVisible(false);
					scrollPaneComp.setVisible(false);
					tableComp.setVisible(false);
					
					
					lblAbsBook.setVisible(false);
					comboBox_Abs_Books.setVisible(false);
					lblAbsSubject.setVisible(false);
					comboBox_Abs_Subjects.setVisible(false);
					lblAbsCategory.setVisible(false);
					comboBox_Abs_Categories.setVisible(false);
					btnAbsSearch.setVisible(false);
					lblAbsoluteRankPopularity.setVisible(false);
					txtF_AbsBookName.setVisible(false);
					scrollPaneAbs.setVisible(false);
					tableAbs.setVisible(false);	
					
					lblIUserRepUserId.setVisible(false);
					txtF_UserRepUserId.setVisible(false);
					btnUserRepSearch.setVisible(false);
					
					lblPeriodRepSelectType.setVisible(true);
					btnAbsRank.setVisible(true);
					btnCompRank.setVisible(true);
					
					btnBookRepSearch.setVisible(false);
					lblBookRepBook.setVisible(false);
					comboBox_BookRep_Books.setVisible(false);
					lblBookRepSubject.setVisible(false);
					comboBox_BookRep_Subjects.setVisible(false);
					lblBookRepCategory.setVisible(false);
					comboBox_BookRep_Categories.setVisible(false);
				
					
					lblAbsoluteRank.setVisible(false);
					lblComparativeRank.setVisible(true);
					
					
				}
			});
			
			
			btnAbsRank.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lblAbsBook.setVisible(true);
					comboBox_Abs_Books.setVisible(true);
					lblAbsSubject.setVisible(true);
					comboBox_Abs_Subjects.setVisible(true);
					lblAbsCategory.setVisible(true);
					comboBox_Abs_Categories.setVisible(true);
					btnAbsSearch.setVisible(true);
					txtF_AbsBookName.setVisible(false);
					scrollPaneAbs.setVisible(false);
					tableAbs.setVisible(false);	
					
					lblIUserRepUserId.setVisible(false);
					txtF_UserRepUserId.setVisible(false);
					btnUserRepSearch.setVisible(false);
					
					lblPeriodRepSelectType.setVisible(true);
					btnAbsRank.setVisible(true);
					btnCompRank.setVisible(true);
					
					btnBookRepSearch.setVisible(false);
					lblBookRepBook.setVisible(false);
					comboBox_BookRep_Books.setVisible(false);
					lblBookRepSubject.setVisible(false);
					comboBox_BookRep_Subjects.setVisible(false);
					lblBookRepCategory.setVisible(false);
					comboBox_BookRep_Categories.setVisible(false);
					
					
					lblCompBook.setVisible(false);
					comboBox_Comp_Books.setVisible(false);
					lblCompSubject.setVisible(false);
					comboBox_Comp_Subjects.setVisible(false);
					lblCompCategory.setVisible(false);
					comboBox_Comp_Categories.setVisible(false);
					btnCompSearch.setVisible(false);
					lblComparativeRankPopularity.setVisible(false);
					txtF_CompBookName.setVisible(false);
					scrollPaneComp.setVisible(false);
					tableComp.setVisible(false);
					
					lblAbsoluteRank.setVisible(true);
					lblComparativeRank.setVisible(false);
					
				}
			});
					
			/* ******************************************************************/
			/* ******************************************************************/
			/* ******************************************************************/
		
		
			
		}
	}