package framework.view;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TransactionFrame extends JDialog implements IGUI{
	private MainFrame parentframe;
	private String accnr;

	private JLabel amountLabel = new JLabel();
	private JLabel dateLabel = new JLabel();
	
	protected JTextField amountTextField = new JTextField();
	protected JTextField dateTextField = new JTextField();
	protected JButton JButton_OK = new JButton();
	protected JButton JButton_Cancel = new JButton();
	

	
	
	public TransactionFrame(MainFrame parent, String title, String aaccnr) {
		this.parentframe = parent;
		this.setTitle(title);
		
		getContentPane().setLayout(null);
		setSize(300,200);
		setVisible(false);
		setLocationRelativeTo(null);
		
		amountLabel.setText("Amount");
		getContentPane().add(amountLabel);
		amountLabel.setForeground(java.awt.Color.black);
		amountLabel.setBounds(12,50,58,24);
		
		dateLabel.setText("Date");
		getContentPane().add(dateLabel);
		dateLabel.setForeground(java.awt.Color.black);
		dateLabel.setBounds(12,82,48,24);
		
		getContentPane().add(amountTextField);
		amountTextField.setBounds(84,50,156,20);
		
		getContentPane().add(dateTextField);
		dateTextField.setBounds(84,82,156,20);
		
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(12,106,84,24);
		
		JButton_Cancel.setText("Cancel");
		JButton_Cancel.setActionCommand("Cancel");
		getContentPane().add(JButton_Cancel);
		JButton_Cancel.setBounds(100,106,84,24);
		
	}


}
