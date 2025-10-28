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

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        System.out.println("lancement de mon programme");
        m = new model();

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
