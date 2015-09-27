package CCardApp.view;

import CCardApp.controller.CreditCardController;
import framework.view.MainFrame;

public class CreditcardFrame extends MainFrame {

	/**
	 * Dung Le 
	 */
	private static final long serialVersionUID = 54604709938475662L;

	javax.swing.JButton buttonAddNewCCard = new javax.swing.JButton();
	javax.swing.JButton buttonGenBill = new javax.swing.JButton();
	
	private CreditCardController control;
	
	public CreditcardFrame(String title) {
		super();
		control = CreditCardController.getInstance();

		frameJPanel.setBounds(0, 0, 575, 310);
		this.setTitle(title);
		buttonAddNewCCard.setText("Add Credit Card Account");
		frameJPanel.add(buttonAddNewCCard);
		buttonAddNewCCard.setBounds(24, 20, 192, 33);
		buttonGenBill.setText("Generate Monthly Bills");
		buttonGenBill.setActionCommand("jGenButton");
		frameJPanel.add(buttonGenBill);
		buttonGenBill.setBounds(240, 20, 192, 33);
		
//		buttonAddNewCCard.addActionListener(control
//				.getAddNewCreditCardListener(this));
//		buttonGenBill
//				.addActionListener(control.getGenerateBillListener(this));
		
		withdrawButton.setText("Charge");
		frameJPanel.add(withdrawButton);
		withdrawButton.setBounds(468, 164, 96, 33);
		
		model.addColumn("Name");
		model.addColumn("CC number");
		model.addColumn("Exp date");
		model.addColumn("Type");
		model.addColumn("Balance");
		rowdata = new String[8];
		
		buttonAddNewCCard.addActionListener(control.getAddNewCreditCardListener(this));
		buttonGenBill.addActionListener(control.getGenerateBillListener(this));		
		super.depositButton.addActionListener(control.getDepositListener(this));
		super.withdrawButton.addActionListener(control.getWithdrawListener(this));
		
	}

	public void updateTable(String[] data) {
		rowdata[0] = data[0]; //
		rowdata[1] = data[1];
		rowdata[2] = data[2];
		rowdata[3] = data[3];
		rowdata[4] = data[4];
		rowdata[5] = data[5];
		rowdata[6] = data[6];
		rowdata[7] = data[7];
		model.addRow(rowdata);
		infoTable.getSelectionModel().setAnchorSelectionIndex(-1);
	}

}
