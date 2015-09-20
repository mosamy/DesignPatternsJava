

// Conversion Formula
//1km = 0.6 mile
//1 mile = 1.60km
//		
//1 pound = 0.45 kg
//1kg = 20.20 pound
//
//1 gallon = 3.78 ltr
//1 ltr = 0.26 gallon
//
//F = C * 9/5 +32
//C = (F - 32) * 5/9


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.DoubleFunction;

import javax.swing.*;

public class MetricConversionLambda extends JFrame {
	JLabel lblMile = new JLabel("Mile :");
	JLabel lblPound = new JLabel("Pound :");
	JLabel lblGallon = new JLabel("Gallon :");
	JLabel lblFar = new JLabel("Fahrenheit :");
	JLabel lblKm = new JLabel("Kilometer :");
	JLabel lblKg = new JLabel("Kilogram :");
	JLabel lblLtr = new JLabel("Liter :");
	JLabel lblCenti = new JLabel("Centigrade :");
	JButton btnConvert = new JButton("Convert");
	JButton btnClear = new JButton("Clear");
	
	public MetricConversionLambda() {
		setLayout(null);
		
		final JTextField mile = new JTextField();
		final JTextField pound = new JTextField();
		final JTextField gallon = new JTextField();
		final JTextField farhnt = new JTextField();
		final JTextField km = new JTextField();
		final JTextField kg = new JTextField();
		final JTextField ltr = new JTextField();
		final JTextField centi = new JTextField();
		
		lblMile.setBounds(30, 10, 50, 20); mile.setBounds(110, 10, 100, 20); lblKm.setBounds(250, 10, 100, 20); km.setBounds(340, 10, 100, 20);
		lblPound.setBounds(30, 30, 50, 20); pound.setBounds(110, 30, 100, 20); lblKg.setBounds(250, 30, 100, 20); kg.setBounds(340, 30, 100, 20);
		lblGallon.setBounds(30, 50, 50, 20); gallon.setBounds(110, 50, 100, 20); lblLtr.setBounds(250, 50, 100, 20); ltr.setBounds(340, 50, 100, 20);
		lblFar.setBounds(30, 70, 70, 20); farhnt.setBounds(110, 70, 100, 20); lblCenti.setBounds(250, 70, 100, 20); centi.setBounds(340, 70, 100, 20);
		btnConvert.setBounds(160, 120, 80, 20); btnClear.setBounds(260, 120, 80, 20); 
		
		add(lblMile); add(mile); add(lblKm); add(km);
		add(lblPound); add(pound); add(lblKg); add(kg);
		add(lblGallon); add(gallon); add(lblLtr); add(ltr);
		add(lblFar); add(farhnt); add(lblCenti); add(centi);
		add(btnConvert); add(btnClear);
		
		btnClear.setEnabled(false);
		
		btnConvert.addActionListener(new ActionListener() {
			
			public String converter(Double value) {
				return Double.toString(value);
			}
			
			public String LambdaConverter (DoubleFunction<Double> d, double value)
			{
				return d.apply(value).toString();
			}
			
			//@Override
			public void actionPerformed(ActionEvent arg0) {
				btnConvert.setEnabled(false);
				btnClear.setEnabled(true);
				
			
				
				if(!mile.getText().isEmpty() && km.getText().isEmpty()) {
					
					
					//String strKm = converter(Double.parseDouble(mile.getText()) * 1.6 );
					Double Mile = Double.parseDouble(mile.getText());
					String strKm = LambdaConverter((( d) -> d * 1.6), Mile);
					km.setText(strKm);
					System.out.println("inside mile -> km");
				}

				if(!km.getText().isEmpty() && mile.getText().isEmpty()) {
					
					//String strMile = converter(Double.parseDouble(km.getText()) * 0.6);
					String strMile = LambdaConverter((( d) -> d * 0.6), Double.parseDouble(km.getText()));
					mile.setText(strMile);
					System.out.println("inside km -> mile");
				}
				
				
				if(!kg.getText().isEmpty() && pound.getText().isEmpty()) {
					String strPound = converter(Double.parseDouble(kg.getText()) * 20.20);
					pound.setText(strPound);
				}
				
				if(!pound.getText().isEmpty() && kg.getText().isEmpty()) {
					String strKg = converter(Double.parseDouble(pound.getText()) * 0.45);
					kg.setText(strKg);
				}
				
				if(!ltr.getText().isEmpty() && gallon.getText().isEmpty()) {
					String strGallon = converter(Double.parseDouble(ltr.getText()) * 0.26);
					gallon.setText(strGallon);
				}

				if(!gallon.getText().isEmpty() && ltr.getText().isEmpty()) {
					String strLiter = converter(Double.parseDouble(gallon.getText()) * 3.78);
					ltr.setText(strLiter);
				}

				if(!centi.getText().isEmpty() && farhnt.getText().isEmpty()) {
					String strFarnht = converter(Double.parseDouble(centi.getText()) * 9/5 +32);
					farhnt.setText(strFarnht);
				}
				
				if(!farhnt.getText().isEmpty() && centi.getText().isEmpty()) {
					String strCenti = converter((Double.parseDouble(farhnt.getText()) -32) * 5/9);
					centi.setText(strCenti);
				}
			}
		});
		
		btnClear.addActionListener(new ActionListener() {
			
			//@Override
			public void actionPerformed(ActionEvent e) {
				btnConvert.setEnabled(true);
				
				mile.setText(null); km.setText(null);
				pound.setText(""); kg.setText("");
				gallon.setText(""); ltr.setText("");
				farhnt.setText(""); centi.setText("");
			}
		});
	}

	public static void main(String[] args) {
		MetricConversionLambda window = new MetricConversionLambda();
		window.setTitle("Metric Conversion Assistant");
		window.setVisible(true);
		window.setSize(460, 200);
		window.setLocation(500, 500);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
