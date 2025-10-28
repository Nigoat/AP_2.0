package View;

import javax.swing.*;
import java.awt.Font;
import java.text.DecimalFormat;

import Model.LIVRE;

public class View_Livre extends JFrame {
    private JTextArea textArea;

    public View_Livre(LIVRE livre) {
        setTitle("Détails du Livre");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));

        StringBuilder sb = new StringBuilder();
        sb.append("===== Détails du Livre =====\n\n");

        if (livre == null) {
            sb.append("Aucun livre fourni.\n");
        } else {
            sb.append("ISBN: ").append(safeString(livre.getISBN())).append("\n");
            sb.append("Titre: ").append(safeString(livre.getTitre())).append("\n");

            // Format price with two decimals
            String prixStr;
            try {
                double prix = livre.getPrix();
                DecimalFormat df = new DecimalFormat("#0.00");
                prixStr = df.format(prix) + " €";
            } catch (Exception e) {
                prixStr = "N/A";
            }
            sb.append("Prix: ").append(prixStr).append("\n\n");

            // Emprunteur and Auteur are domain objects; display their toString() safely
            sb.append("Adhérent: ").append(safeString(livre.getEmprunteur())).append("\n");
            sb.append("Auteur: ").append(safeString(livre.getAuteur())).append("\n");
        }

        textArea.setText(sb.toString());
        add(new JScrollPane(textArea));

        pack();
        setLocationRelativeTo(null);
    }

    private String safeString(Object o) {
        if (o == null) return "N/A";
        String s = o.toString().trim();
        return s.isEmpty() ? "N/A" : s;
    }
}
