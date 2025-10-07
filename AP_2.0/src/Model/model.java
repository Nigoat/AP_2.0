	package Model;
	
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.util.ArrayList;
	import java.util.List;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	
	public class model {
	
	    private ArrayList<LIVRE> listLivre;
	    private ArrayList<ADHERENT> listAdherent;
	    private ArrayList<AUTEUR> listAuteur;
	
	    private final String BDD = "bbd_bibli";
	    private final String url = "jdbc:mysql://localhost:3306/" + BDD;
	    private final String user = "root";
	    private final String passwd = "";
	    private Connection conn;
	    
	    public model() throws ClassNotFoundException, SQLException {
	    	
	        listLivre = new ArrayList<>();
	        listAuteur = new ArrayList<>();
	        listAdherent = new ArrayList<>();
	        
	        Class.forName("com.mysql.jdbc.Driver");
	        conn = DriverManager.getConnection(url, user, passwd);
            System.out.println("Connexion OK");
            AUTEUR au1 = new AUTEUR("Antoine de Saint-Exupéry", null, null, null, null);
	        AUTEUR au2 = new AUTEUR("Victor Hugo", null, null, null, null);
	        AUTEUR au3 = new AUTEUR("Gustave Flaubert", null, null, null, null);
	        AUTEUR au4 = new AUTEUR("Albert Camus", null, null, null, null);
	        AUTEUR au5 = new AUTEUR("J.K. Rowling", null, null, null, null);
	
	        // ==== Adhérents ====
	        ADHERENT ad1 = new ADHERENT("Jean Dupont", null, null, null, null);
	        ADHERENT ad2 = new ADHERENT("Claire Martin", null, null, null, null);
	        ADHERENT ad3 = new ADHERENT("Luc Bernard", null, null, null, null);
	
	        // ==== Livres ====
	        listLivre.add(new LIVRE("ISBN101", "Le Petit Prince", 13.50f, ad1, au1));
	        listLivre.add(new LIVRE("ISBN102", "Les Misérables", 19.99f, ad2, au2));
	        listLivre.add(new LIVRE("ISBN103", "Madame Bovary", 16.80f, null, au3));
	        listLivre.add(new LIVRE("ISBN104", "L'Étranger", 14.00f, ad3, au4));
	        listLivre.add(new LIVRE("ISBN105", "Harry Potter à l'école des sorciers", 24.50f, null, au5));
	        listLivre.add(new LIVRE("ISBN106", "Les Misérables - Tome 2", 21.00f, ad1, au2));
	        listLivre.add(new LIVRE("ISBN107", "Le Petit Prince - Edition Collector", 15.75f, null, au1));
	
	        // ==== Ajout auteurs ====
	        listAuteur.add(au1);
	        listAuteur.add(au2);
	        listAuteur.add(au3);
	        listAuteur.add(au4);
	        listAuteur.add(au5);
	
	        // ==== Ajout adhérents ====
	        listAdherent.add(ad1);
	        listAdherent.add(ad2);
	        listAdherent.add(ad3);
	           
	            
	        ResultSet résultats;
	        String requete = "SELECT * FROM ADHERENT";
	        Statement stmt = conn.createStatement();
	        résultats = stmt.executeQuery(requete);
	        System.out.println("ok");
	        while (résultats.next()) {
	            System.out.println(résultats.getString(1) + " : " + résultats.getString(2));
	        }


	    }
	  	    
	
	
	    public void getAll() throws ClassNotFoundException, SQLException {       
	    	
	    
	        Statement stmt = conn.createStatement();
            ResultSet resultats = stmt.executeQuery("SELECT * FROM LIVRE");

            while (resultats.next()) {
                LIVRE livre = new LIVRE(resultats.getString(1),resultats.getString(2),resultats.getFloat(3),null,null);
                listLivre.add(livre);
	        }
	        
	    }
	    
	 
	    // Getters / Setters
	    public ArrayList<LIVRE> getListLivre() {
	        return listLivre;
	    }
	
	    public void setListLivre(ArrayList<LIVRE> listLivre) {
	        this.listLivre = listLivre;
	    }
	
	    public ArrayList<ADHERENT> getListAdherent() {
	        return listAdherent;
	    }
	
	    public void setListAdherent(ArrayList<ADHERENT> listAdherent) {
	        this.listAdherent = listAdherent;
	    }
	
	    public ArrayList<AUTEUR> getListAuteur() {
	        return listAuteur;
	    }
	
	    public void setListAuteur(ArrayList<AUTEUR> listAuteur) {
	        this.listAuteur = listAuteur;
	    }
	}