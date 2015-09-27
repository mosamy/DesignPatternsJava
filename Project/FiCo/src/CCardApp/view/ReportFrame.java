package CCardApp.view;

import java.awt.*;
import java.util.List;

import javax.swing.*;

import framework.view.IGUI;
import framework.view.MainFrame;

public class ReportFrame extends javax.swing.JDialog implements IGUI {

	private MainFrame parentframe;

	public ReportFrame(MainFrame parent) {
		this.parentframe = parent;

		setLocationRelativeTo(null); // at middle of screen 
		setTitle("Monthly Report");
		
		getContentPane().setLayout(null);
		setSize(405, 367);
		setVisible(false);
		getContentPane().add(JScrollPane1);
		JScrollPane1.setBounds(24, 24, 358, 240);
		JScrollPane1.getViewport().add(JTextField1);
		JTextField1.setBounds(0, 0, 355, 237);
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(156, 276, 96, 24);

		SymAction lSymAction = new SymAction();
		JButton_OK.addActionListener(lSymAction);
	}

	public void displayReport(List<String[]> report) {
		StringBuffer acctInfo = new StringBuffer();

		for (String[] str : report) {
			for (int i = 0; i < str.length; i++)
				acctInfo.append(str[i]).append(System.getProperty("\n"));
			acctInfo.append("\n");

		}
		JTextField1.setText(acctInfo.toString());
	}

	javax.swing.JScrollPane JScrollPane1 = new javax.swing.JScrollPane();
	javax.swing.JTextField JTextField1 = new javax.swing.JTextField();
	javax.swing.JButton JButton_OK = new javax.swing.JButton();

	class SymAction implements java.awt.event.ActionListener {
		public void actionPerformed(java.awt.event.ActionEvent event) {
			Object object = event.getSource();
			if (object == JButton_OK)
				JButtonOK_actionPerformed(event);
		}
	}

	void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {
		dispose();

	}
}
