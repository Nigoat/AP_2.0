package View;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;
import Model.LIVRE;

public class View_Accueil extends JFrame {
    private JButton btnCatalogue;
    private JButton btnRecherche;
    private JButton btnQuitter;

    public View_Accueil() {
        setTitle("Accueil Bibliothèque");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JLabel label = new JLabel("📚 Bienvenue dans la Bibliothèque");
        btnCatalogue = new JButton("Voir le Catalogue");
        btnRecherche = new JButton("Rechercher un Livre");
        btnQuitter = new JButton("Quitter");

        panel.add(label);
        panel.add(btnCatalogue);
        panel.add(btnRecherche);
        panel.add(btnQuitter);

        add(panel);

        // Minimal behavior: open the corresponding view when the buttons are clicked.
        // Catalogue opens View_Catalogue with an (empty) list if no model is available.
        btnCatalogue.addActionListener(e -> {
            List<LIVRE> empty = Collections.emptyList();
            View_Catalogue vc = new View_Catalogue(empty);
            vc.showWindow();
        });

        // Recherche opens View_Livre with null (the View_Livre handles null safely).
        btnRecherche.addActionListener(e -> {
            View_Livre vl = new View_Livre(null);
            vl.showWindow();
        });

        // Quit simply closes the window
        btnQuitter.addActionListener(e -> dispose());

        pack();
        setLocationRelativeTo(null);
    }

    // Méthodes pour brancher les boutons (kept so controllers can attach extra listeners)
    public void addCatalogueListener(ActionListener listener) {
        btnCatalogue.addActionListener(listener);
    }

    public void addRechercheListener(ActionListener listener) {
        btnRecherche.addActionListener(listener);
    }

    public void addQuitterListener(ActionListener listener) {
        btnQuitter.addActionListener(listener);
    }

    // Show window helper (keeps behavior consistent with other views)
    public void showWindow() {
        SwingUtilities.invokeLater(() -> setVisible(true));
    }
}
