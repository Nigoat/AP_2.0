package View;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;
import java.sql.SQLException;

import Model.LIVRE;
import Controller.MainMVC;
import java.awt.event.ActionEvent;

public class View_Accueil extends JFrame {
    private JButton btnCatalogue;
    private JButton btnRecherche;
    private JButton btnQuitter;
    private JButton btnCompte;
    private JButton btnEmprunt;

    public View_Accueil() {
        setTitle("Accueil Bibliothèque");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JLabel label = new JLabel("📚 Bienvenue dans la Bibliothèque");
        label.setBounds(148, 23, 250, 20);

        btnCatalogue = new JButton("Voir le Catalogue");
        btnCatalogue.setBounds(79, 69, 157, 21);

        btnRecherche = new JButton("Rechercher un Livre");
        btnRecherche.setBounds(246, 69, 154, 21);

        panel.setLayout(null);

        panel.add(label);
        panel.add(btnCatalogue);
        panel.add(btnRecherche);

        getContentPane().add(panel);

        btnQuitter = new JButton("Quitter");
        btnQuitter.setBounds(181, 211, 111, 21);
        panel.add(btnQuitter);

        btnCompte = new JButton("Mon compte");
        btnCompte.setBounds(79, 118, 157, 21);
        panel.add(btnCompte);

        btnEmprunt = new JButton("Emprunter un livre");
        btnEmprunt.setBounds(246, 118, 154, 21);
        panel.add(btnEmprunt);

        btnQuitter.addActionListener(e -> dispose());

        btnCompte.addActionListener(e -> {

                View_Compte vc = new View_Compte(); 
                vc.setVisible(true);

        });
       
        btnEmprunt.addActionListener(e -> {

            View_Emprunt ve = new View_Emprunt(); 
            ve.setVisible(true);

    });

        // Action : ouvrir le catalogue
        btnCatalogue.addActionListener(e -> {
            try {
                if (MainMVC.getM() != null) {
                    try {
                        MainMVC.getM().getall();
                    } catch (SQLException ex) {
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

        // Action : rechercher un livre
        btnRecherche.addActionListener(e -> {
            if (MainMVC.getM() == null) {
                JOptionPane.showMessageDialog(this, "Le modèle n'est pas initialisé.", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String query = JOptionPane.showInputDialog(this, "Entrez l'ISBN ou le titre du livre:", "Recherche", JOptionPane.QUESTION_MESSAGE);
            if (query == null || query.trim().isEmpty()) {
                return;
            }
            String q = query.trim().toLowerCase();
            LIVRE found = null;
            try {
                try {
                    MainMVC.getM().getall();
                } catch (SQLException ex) {
                    // Ignore silently
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

        setSize(500, 310);
        setLocationRelativeTo(null);
    }

    // Listeners externes (optionnels)
    public void addCatalogueListener(ActionListener listener) {
        btnCatalogue.addActionListener(listener);
    }

    public void addRechercheListener(ActionListener listener) {
        btnRecherche.addActionListener(listener);
    }

    public void addQuitterListener(ActionListener listener) {
        btnQuitter.addActionListener(listener);
    }

    public void addCompteLister(ActionListener listener) {
        btnCompte.addActionListener(listener);
    }
    
    public void addEmpruntLister(ActionListener listener) {
        btnCompte.addActionListener(listener);
    }
    
}
