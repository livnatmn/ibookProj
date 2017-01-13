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
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButtonMenuItem;

import java.awt.Canvas;
import java.awt.Panel;
import java.awt.Checkbox;
import java.awt.ScrollPane;
import java.awt.TextArea;
import java.awt.List;
import javax.swing.JProgressBar;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JDesktopPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;


public class PresentBookPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private JTable table_pendReviews;
	private JScrollPane scrollPane_PendRevTable;	
	
	
	public PresentBookPanel() {    
		initialize();
	}
	
	
	private void initialize() {
		setLayout(null);
	    
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(9, 471, 89, 23);
		add(btnCancel);
		btnCancel.setVisible(false);

		JLabel lblWatchNewReviews = new JLabel("Watch New Reviews");
		lblWatchNewReviews.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblWatchNewReviews.setBounds(168, 7, 182, 14);
		add(lblWatchNewReviews);
		
		JLabel lblPendingReviews = new JLabel("Pending Reviews : ");
		lblPendingReviews.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPendingReviews.setBounds(10, 37, 125, 22);
		add(lblPendingReviews);
		
		JButton btnProceed = new JButton("Proceed");
		btnProceed.addActionListener(new ActionListener() {   // listener - if button pressed, open Examining review window
			public void actionPerformed(ActionEvent arg0) {
				System.out.println();
			}
		});
		btnProceed.setBounds(40, 285, 95, 32);
		add(btnProceed);
		btnProceed.setEnabled(false);			// disable button until a row from the table is selected (listener)
		
		
        /* ******************* scroll and Pending Reviews Table *******************************/	
		
		scrollPane_PendRevTable = new JScrollPane();
		scrollPane_PendRevTable.setBounds(10, 70, 481, 204);
		add(scrollPane_PendRevTable);
		
		table_pendReviews = new JTable();
		table_pendReviews.setBorder(UIManager.getBorder("Button.border"));
		table_pendReviews.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_pendReviews.setModel(new DefaultTableModel(
		
		new Object[][] {{"hey", "there", "fagi"},	{null, null, null},	{null, null, null},	{null, null, null},	{null, null, null},	{null, null, null},
						{null, null, null},	{null, null, null},	{null, null, null},	{null, null, null},	{null, null, null},	},
		
		new String[] {"Book Name", "Authors", "Price"}
		) 
		
		{
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {	String.class, String.class, String.class};
				public Class getColumnClass(int columnIndex) { return columnTypes[columnIndex];
			}
		});
		
		table_pendReviews.getColumnModel().getColumn(0).setPreferredWidth(157);
		table_pendReviews.getColumnModel().getColumn(1).setPreferredWidth(151);
		table_pendReviews.getColumnModel().getColumn(2).setPreferredWidth(54);
		scrollPane_PendRevTable.setViewportView(table_pendReviews);
		
		table_pendReviews.addMouseListener(new MouseAdapter() {			// listener - if row has been selected , enable Proceed button
			  public void mouseClicked(MouseEvent e) {
			    if (e.getClickCount()==1) {
			    	btnProceed.setEnabled(true);
			    	System.out.println("row pressed!");
			    }
			  }
        });
	      
	      btnCancel.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    	lblWatchNewReviews.setVisible(true);
				lblPendingReviews.setVisible(true);
				scrollPane_PendRevTable.setVisible(true);   // hide label,scroll,table of pending reviews and proceed button
				table_pendReviews.setVisible(true);
				btnProceed.setVisible(true);
				btnCancel.setVisible(false);
		    }
		});
	}
}