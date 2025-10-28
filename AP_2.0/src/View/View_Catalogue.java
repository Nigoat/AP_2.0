package View;

import javax.swing.*;
import java.awt.Font;
import java.text.DecimalFormat;
import java.util.List;

import Model.LIVRE;

public class View_Catalogue extends JFrame {
    private JTextArea textArea;

    public View_Catalogue(List<LIVRE> livres) {
        setTitle("Catalogue des Livres");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));

        StringBuilder sb = new StringBuilder();
        sb.append("===== Catalogue =====\n\n");

        if (livres == null || livres.isEmpty()) {
            sb.append("Aucun livre dans le catalogue.\n");
        } else {
            DecimalFormat df = new DecimalFormat("#0.00");
            for (LIVRE l : livres) {
                String isbn = safeString(l != null ? l.getISBN() : null);
                String titre = safeString(l != null ? l.getTitre() : null);

                String prixStr;
                try {
                    double prix = l.getPrix();
                    prixStr = df.format(prix) + " €";
                } catch (Exception e) {
                    prixStr = "N/A";
                }

                String line = String.format("ISBN: %-15s | %-35s | Prix: %8s", truncate(isbn, 15), truncate(titre, 35), prixStr);
                sb.append(line).append("\n\n");
            }
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

    private String truncate(String s, int max) {
        if (s == null) return "N/A";
        if (s.length() <= max) return s;
        return s.substring(0, max - 3) + "...";
    }
}
