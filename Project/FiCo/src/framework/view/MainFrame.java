package framework.view;

import java.awt.BorderLayout;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.sun.xml.internal.bind.unmarshaller.InfosetScanner;

import BankApp.BankApplication;
import CCardApp.CCreditApplication;
import framework.controller.AppLoader;
import framework.controller.IApp;

public class MainFrame extends JFrame implements IGUI {

	protected String accountnr, clientName, street, city, zip, state, email, 
	accountType, clientType, amountDeposit;

	// Common Button
	protected JButton depositButton = new JButton("Deposit");
	// text "Withdraw/Charge should be set on their side
	protected JButton withdrawButton = new JButton();//for Bank : Withdraw, for Credit card: Charge
	protected JButton exitButton = new javax.swing.JButton("Exit");
	
	protected JPanel frameJPanel = new JPanel();
	
	protected SymAction lSymAction = new SymAction();
	
	public JTable infoTable;
	public DefaultTableModel model;
	private JScrollPane infoJScrollPane;
	
	
	protected String rowdata[];
	
	public MainFrame() {

		
		// position x,y, width, height of Controller should be parsed from xml file (later)
		setSize(600, 350);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		this.frameJPanel.setLayout(null);
		getContentPane().add(BorderLayout.CENTER, frameJPanel);
		frameJPanel.setBounds(0, 0, 575, 310);
		
		depositButton.setBounds(468, 104, 96, 33);
		frameJPanel.add(depositButton);
		
		withdrawButton.setBounds(468, 164, 96, 33);
		frameJPanel.add(withdrawButton);
		
		
		// set Table info
		infoJScrollPane = new JScrollPane();
		model = new DefaultTableModel();
		infoTable = new JTable(model);
		infoTable.setBounds(0, 0, 420, 0);
		frameJPanel.add(infoJScrollPane);
		infoJScrollPane.setBounds(12, 92, 444, 160);
		infoJScrollPane.getViewport().add(infoTable);
		
		rowdata = new String[9];
		
		exitButton.setBounds(468, 224, 96, 33);
		frameJPanel.add(exitButton);
		
		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);

		exitButton.addActionListener(lSymAction);
		
	}

	class SymWindow extends WindowAdapter {
		
		@Override
		public void windowClosing(WindowEvent event) {
			Object object = event.getSource();
			if (object == MainFrame.this)
				System.exit(0);
		}
	}
	
	class SymAction implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent event) {
			Object object = event.getSource();
			if (object == exitButton)
				exitButton_actionPerformed(event);
		}
	}
	
	
	void exitButton_actionPerformed(java.awt.event.ActionEvent event) {
		System.exit(0);
	}
}
