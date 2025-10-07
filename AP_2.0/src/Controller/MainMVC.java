package Controller;


import Model.*;
import View.View_Accueil;
import View.View_Catalogue;
import View.View_Livre;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.SQLException;

public class MainMVC {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // ==== Create the model ====
        model m = new model();

        // ==== Load all data (this runs your getAll method which does DB connection + INSERT + SELECT) ====
        m.getAll();

        // ==== Start Swing UI ====
        SwingUtilities.invokeLater(() -> {
            View_Accueil accueil = new View_Accueil();
            accueil.setVisible(true);

            List<LIVRE> catalogue = null;
			// Catalogue button
            accueil.addCatalogueListener(e -> {
                View_Catalogue vCatalogue = new View_Catalogue(catalogue);
                vCatalogue.setVisible(true);
            });

            // Search button
            accueil.addRechercheListener(e -> {
                String isbn = JOptionPane.showInputDialog("Entrez l'ISBN du livre :");
                boolean trouve = false;
                for (LIVRE l : catalogue) {
                    if (l.getISBN().equalsIgnoreCase(isbn)) {
                        View_Livre vLivre = new View_Livre(l);
                        vLivre.setVisible(true);
                        trouve = true;
                        break;
                    }
                }
                if (!trouve) {
                    JOptionPane.showMessageDialog(null, "Livre non trouvé !");
                }
            });

            // Quit button
            accueil.addQuitterListener(e -> System.exit(0));
        });
    }
}
