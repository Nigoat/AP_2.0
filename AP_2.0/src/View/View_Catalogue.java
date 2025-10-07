package View;

import javax.swing.*;
import Model.LIVRE;
import java.util.List;

public class View_Catalogue extends JFrame {
    private JTextArea textArea;

    public View_Catalogue(List<LIVRE> livres) {
        setTitle("Catalogue des Livres");
        setSize(500, 300);
        setLocationRelativeTo(null);

        textArea = new JTextArea();
        textArea.setEditable(false);

        StringBuilder sb = new StringBuilder("===== Catalogue =====\n");
        for (LIVRE l : livres) {
            sb.append("ISBN: ").append(l.getISBN())
              .append(" | ").append(l.getTitre())
              .append(" | Prix: ").append(l.getPrix()).append("€\n");
        }

        textArea.setText(sb.toString());
        add(new JScrollPane(textArea));
    }
}
