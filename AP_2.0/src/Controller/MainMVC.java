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

        // Create and show the view on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            View_Accueil va = new View_Accueil();
            // If View_Accueil provides showWindow(), prefer that; otherwise this is equivalent to setVisible(true)
            va.setVisible(true);
        });
    }
}
