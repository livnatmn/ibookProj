package boundry;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class InsertPaymentPanel extends JPanel {
	
	public InsertPaymentPanel() {
		initialize();
	}
	
	private void initialize() {
		setLayout(null);

		JLabel lblTitle = new JLabel("Payment Methods");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(43, 136, 355, 22);
		lblTitle.setFont(new Font("Goudy Stout", Font.PLAIN, 15));
		add(lblTitle);
	}
}
