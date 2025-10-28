package Controller;

import java.sql.SQLException;
import View.View_Accueil;
import Model.model;

public class MainMVC {
	private static model m;
 
	public static model getM() {
	 return m;
 }
 
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println("lancement de mon programme");
		m=new model(); 
		View_Accueil va = new View_Accueil();


	}
}
