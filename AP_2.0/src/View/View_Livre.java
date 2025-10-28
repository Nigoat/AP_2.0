package View;

import javax.swing.*;
import Model.LIVRE;

public class View_Livre extends JFrame {
    private JTextArea textArea;

    public View_Livre(LIVRE livre) {
        setTitle("Détails du Livre");
        setSize(400, 200);
        setLocationRelativeTo(null);

        textArea = new JTextArea();
        textArea.setEditable(false);

        StringBuilder sb = new StringBuilder();
        sb.append("===== Détails du Livre =====\n");
        sb.append("ISBN: ").append(livre.getISBN()).append("\n");
        sb.append("Titre: ").append(livre.getTitre()).append("\n");
        sb.append("Prix: ").append(livre.getPrix()).append(" €\n");
        sb.append("Adhérent: ").append(livre.getEmprunteur()).append("\n");
        sb.append("Auteur: ").append(livre.getAuteur()).append("\n");

        textArea.setText(sb.toString());
        add(new JScrollPane(textArea));
    }
}
