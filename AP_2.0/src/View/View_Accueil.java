package View;

import javax.swing.*;
import java.awt.event.ActionListener;

public class View_Accueil extends JFrame {
    private JButton btnCatalogue;
    private JButton btnRecherche;
    private JButton btnQuitter;

    public View_Accueil() {
        setTitle("Accueil Bibliothèque");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

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
    }

    // Méthodes pour brancher les boutons
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
