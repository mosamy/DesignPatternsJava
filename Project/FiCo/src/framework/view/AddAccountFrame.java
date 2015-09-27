package framework.view;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddAccountFrame extends javax.swing.JDialog implements IGUI {

	private MainFrame parentframe;
	

	
	private JLabel nameLabel = new JLabel();
	private JLabel streetJLabel = new JLabel();
	private JLabel cityLabel = new JLabel();
	private JLabel stateJLabel = new JLabel();
	private JLabel zipLabel = new JLabel();
	protected JLabel birthDateLabel = new JLabel();
	protected JLabel numOfEnployeeLabel = new JLabel();
	protected JLabel emailLabel = new JLabel();
	
	protected JTextField nameTextField = new JTextField();
	protected JTextField streetTextField = new JTextField();
	protected JTextField cityTextField = new JTextField();
	protected JTextField stateTextField = new JTextField();
	protected JTextField zipTextField = new JTextField();
	

	protected JButton JButton_OK = new JButton();
	protected JButton JButton_Cancel = new JButton();
	
	protected JTextField emailTextField = new JTextField();
	
	protected JTextField txtfieldExpDate = new javax.swing.JTextField();
	
	public AddAccountFrame(MainFrame parent)
	{
		this.parentframe = parent;
		
		getContentPane().setLayout(null);
		setSize(301,400);
		setVisible(false);
		setLocationRelativeTo(null); // at middle of screen 
		
		
		nameLabel.setText("Name");
		getContentPane().add(nameLabel);
		nameLabel.setForeground(java.awt.Color.black);
		nameLabel.setBounds(12,108,48,24);
		
		streetJLabel.setText("Street");
		getContentPane().add(streetJLabel);
		streetJLabel.setForeground(java.awt.Color.black);
		streetJLabel.setBounds(12,132,48,24);
		
		cityLabel.setText("City");
		getContentPane().add(cityLabel);
		cityLabel.setForeground(java.awt.Color.black);
		cityLabel.setBounds(12,156,48,24);
		
		stateJLabel.setText("State");
		getContentPane().add(stateJLabel);
		stateJLabel.setForeground(java.awt.Color.black);
		stateJLabel.setBounds(12,180,48,24);
		
		zipLabel.setText("Zip");
		getContentPane().add(zipLabel);
		zipLabel.setForeground(java.awt.Color.black);
		zipLabel.setBounds(12,204,48,24);
		
		getContentPane().add(nameTextField);
		nameTextField.setBounds(100,108,156,20);
		
		getContentPane().add(streetTextField);
		streetTextField.setBounds(100,132,156,20);

		getContentPane().add(cityTextField);
		cityTextField.setBounds(100,156,156,20);
		
		getContentPane().add(stateTextField);
		stateTextField.setBounds(100,180,156,20);
				
		getContentPane().add(zipTextField);
		zipTextField.setBounds(100,204,156,20);
		
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(48,312,84,24);
		
		JButton_Cancel.setText("Cancel");
		JButton_Cancel.setActionCommand("Cancel");
		getContentPane().add(JButton_Cancel);
		JButton_Cancel.setBounds(156,312,84,24);
		
		emailLabel.setText("Email");
		getContentPane().add(emailLabel);
		emailLabel.setForeground(java.awt.Color.black);
		emailLabel.setBounds(12, 252, 96, 24);
		
		getContentPane().add(emailTextField);
		emailTextField.setBounds(100, 252, 156, 20);
	
		SymAction lSymAction = new SymAction();
		JButton_Cancel.addActionListener(lSymAction);
		
	}
	
	class SymAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event)
		{
		
			JButtonCalcel_actionPerformed(event);
		}
	}
	
	public String[] getAccountInfo(){
		String [] fields = new String [7];
		fields[0] = nameTextField.getText();
		fields[1] = streetTextField.getText();
		fields[2] = cityTextField.getText();
		fields[3] = stateTextField.getText();
		fields[4] = zipTextField.getText();
		fields[5] = emailTextField.getText();
		fields[6] = txtfieldExpDate.getText();
		return fields;
	}
	void JButtonCalcel_actionPerformed(ActionEvent event)
	{
		dispose();
	}

}

