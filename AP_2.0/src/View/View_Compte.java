package View;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class View_Compte extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JButton btnQuitter;
	private JButton btnNewButton;
	public View_Compte() {
		getContentPane().setLayout(null);
		setSize(500, 310); 
		
		
		JLabel lblNewLabel = new JLabel("Mon Compte");
		lblNewLabel.setBounds(187, 10, 71, 13);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(49, 58, 96, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(173, 58, 96, 19);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(293, 58, 96, 19);
		getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(49, 106, 96, 19);
		getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(173, 106, 96, 19);
		getContentPane().add(textField_4);
		
		btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(173, 232, 85, 21);
		getContentPane().add(btnQuitter);
		btnQuitter.addActionListener(e -> dispose());
		
		JLabel lblNewLabel_1_1 = new JLabel("Nom");
		lblNewLabel_1_1.setBounds(72, 35, 45, 13);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Prenom");
		lblNewLabel_1_2.setBounds(199, 35, 45, 13);
		getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Age");
		lblNewLabel_1_3.setBounds(319, 35, 45, 13);
		getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Nombre de livre ");
		lblNewLabel_1_4.setBounds(49, 87, 96, 13);
		getContentPane().add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Mail");
		lblNewLabel_1_5.setBounds(199, 87, 45, 13);
		getContentPane().add(lblNewLabel_1_5);
		
		btnNewButton = new JButton("Valider changements");
		btnNewButton.setBounds(150, 184, 156, 21);
		getContentPane().add(btnNewButton);
	}
	}


