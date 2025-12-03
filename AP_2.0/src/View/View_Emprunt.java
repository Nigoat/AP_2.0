package View;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class View_Emprunt extends JFrame {
    private JTextField textField;
    private JTextField textField_1;

    public View_Emprunt() {
        getContentPane().setLayout(null);
        setSize(500, 310);

        textField = new JTextField();
        textField.setBounds(131, 59, 96, 19);
        getContentPane().add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel = new JLabel("Votre n° Adhérent");
        lblNewLabel.setBounds(10, 62, 111, 13);
        getContentPane().add(lblNewLabel);

        JButton btnNewButton = new JButton("Confirmer");
        btnNewButton.setBounds(247, 58, 111, 21);
        getContentPane().add(btnNewButton);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(131, 144, 96, 19);

        
        textField_1.setEnabled(false);

        getContentPane().add(textField_1);

        JLabel lblIsbnDuLivre = new JLabel("ISBN du Livre");
        lblIsbnDuLivre.setBounds(10, 147, 111, 13);
        getContentPane().add(lblIsbnDuLivre);

        JButton btnEmprunter = new JButton("Emprunter");
        btnEmprunter.setBounds(247, 143, 111, 21);
        getContentPane().add(btnEmprunter);
        
        JButton btnQuitter = new JButton("Quitter");
        btnQuitter.setBounds(184, 215, 96, 21);
        getContentPane().add(btnQuitter);
        btnQuitter.addActionListener( e -> dispose());


        
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField_1.setEnabled(true);
            }
        });
    }
}
