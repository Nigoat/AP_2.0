package View;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;
import java.sql.SQLException;

import Model.LIVRE;
import Controller.MainMVC;

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

        // Open the catalogue using the real model data.
        btnCatalogue.addActionListener(e -> {
            // Try to refresh data from DB, then open catalogue
            try {
                if (MainMVC.getM() != null) {
                    try {
                        MainMVC.getM().getall();
                    } catch (SQLException ex) {
                        // show but continue with in-memory list if present
                        JOptionPane.showMessageDialog(this,
                                "Attention: erreur lors de l'actualisation des données: " + ex.getMessage(),
                                "Erreur",
                                JOptionPane.WARNING_MESSAGE);
                    }
                    List<LIVRE> livres = MainMVC.getM().getListLivre();
                    if (livres == null) livres = Collections.emptyList();
                    View_Catalogue vc = new View_Catalogue(livres);
                    vc.setVisible(true);
                } else {
                    // Fallback empty catalogue
                    View_Catalogue vc = new View_Catalogue(Collections.<LIVRE>emptyList());
                    vc.setVisible(true);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,
                        "Erreur lors de l'ouverture du catalogue: " + ex.getMessage(),
                        "Erreur",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        // Search: ask user for ISBN or title and show View_Livre for the first match
        btnRecherche.addActionListener(e -> {
            if (MainMVC.getM() == null) {
                JOptionPane.showMessageDialog(this, "Le modèle n'est pas initialisé.", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String query = JOptionPane.showInputDialog(this, "Entrez l'ISBN ou le titre du livre:", "Recherche", JOptionPane.QUESTION_MESSAGE);
            if (query == null || query.trim().isEmpty()) {
                return; // user cancelled or empty
            }
            String q = query.trim().toLowerCase();
            LIVRE found = null;
            try {
                // ensure list is up to date
                try {
                    MainMVC.getM().getall();
                } catch (SQLException ex) {
                    // ignore, we'll search in the current list
                }
                for (LIVRE l : MainMVC.getM().getListLivre()) {
                    if (l == null) continue;
                    String isbn = l.getISBN() != null ? l.getISBN().toLowerCase() : "";
                    String titre = l.getTitre() != null ? l.getTitre().toLowerCase() : "";
                    if (isbn.equals(q) || titre.contains(q) || isbn.contains(q) || titre.equals(q)) {
                        found = l;
                        break;
                    }
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,
                        "Erreur durant la recherche: " + ex.getMessage(),
                        "Erreur",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (found != null) {
                View_Livre vl = new View_Livre(found);
                vl.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Aucun livre trouvé pour : " + query, "Résultat", JOptionPane.INFORMATION_MESSAGE);
            }
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
}
