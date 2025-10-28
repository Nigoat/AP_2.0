package View;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.CardLayout;

public class View_Accueil extends JFrame {
    private JButton btnCatalogue;
    private JButton btnRecherche;
    private JButton btnQuitter;

    // CardLayout stuff
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private boolean showingHome = true;

    public View_Accueil() {
        setTitle("Accueil Bibliothèque");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Card container: HOME = the original page, EMPTY = nothing (blank panel)
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // HOME panel (original content)
        JPanel homePanel = new JPanel();
        JLabel label = new JLabel("📚 Bienvenue dans la Bibliothèque");
        btnCatalogue = new JButton("Voir le Catalogue");
        btnRecherche = new JButton("Rechercher un Livre");
        btnQuitter = new JButton("Quitter");

        homePanel.add(label);
        homePanel.add(btnCatalogue);
        homePanel.add(btnRecherche);
        homePanel.add(btnQuitter);

        // EMPTY panel: intentionally blank (nothing more)
        JPanel emptyPanel = new JPanel();

        cardPanel.add(homePanel, "HOME");
        cardPanel.add(emptyPanel, "EMPTY");

        add(cardPanel);

        // Minimal behavior: toggle between HOME and EMPTY when Catalogue or Recherche is clicked
        btnCatalogue.addActionListener(e -> toggleCard());
        btnRecherche.addActionListener(e -> toggleCard());

        // Quit simply closes the window
        btnQuitter.addActionListener(e -> dispose());
    }

    // Méthodes pour brancher les boutons (left as-is so external controller can attach listeners)
    public void addCatalogueListener(ActionListener listener) {
        btnCatalogue.addActionListener(listener);
    }

    public void addRechercheListener(ActionListener listener) {
        btnRecherche.addActionListener(listener);
    }

    public void addQuitterListener(ActionListener listener) {
        btnQuitter.addActionListener(listener);
    }

    // Internal toggle: show EMPTY if HOME is shown, otherwise show HOME.
    private void toggleCard() {
        if (showingHome) {
            cardLayout.show(cardPanel, "EMPTY");
        } else {
            cardLayout.show(cardPanel, "HOME");
        }
        showingHome = !showingHome;
    }
}
