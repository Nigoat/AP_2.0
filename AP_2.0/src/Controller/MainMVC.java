package Controller;

import javax.swing.SwingUtilities;
import View.View_Accueil;
import Model.model;
import java.sql.SQLException;

public class MainMVC {
    private static model m;



    public static model getM() {
        return m;
    }

    public static void main(String[] args) {
        System.out.println("lancement de mon programme");
        try {
            m = new model();
            try {
                m.getall();
            } catch (SQLException e) {
                System.err.println("Erreur lors du chargement des données: " + e.getMessage());
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    javax.swing.JOptionPane.showMessageDialog(null,
                            "Impossible d'initialiser le modèle : " + e.getMessage(),
                            "Erreur",
                            javax.swing.JOptionPane.ERROR_MESSAGE);
                    System.exit(1);
                }
            });
            return;
        }

        // show the accueil on the EDT
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                View_Accueil va = new View_Accueil();
                va.setVisible(true);
            }
        });
    }
}
