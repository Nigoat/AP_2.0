package Model;


public class LIVRE {
 private String ISBN;
 private String titre;
 private float prix;
 private ADHERENT adherent; 
 private AUTEUR auteur;   


 public LIVRE(String ISBN, String titre, float prix, ADHERENT adherent, AUTEUR auteur) {
     this.ISBN = ISBN;
     this.titre = titre;
     this.prix = prix;
     this.adherent = adherent;
     this.auteur = auteur;
 }

public String getISBN() {
	return ISBN;
}

public void setISBN(String iSBN) {
	ISBN = iSBN;
}

public String getTitre() {
	return titre;
}

public void setTitre(String titre) {
	this.titre = titre;
}

public double getPrix() {
	return prix;
}

public void setPrix(float prix) {
	this.prix = prix;
}

public ADHERENT getAdherent() {
	return adherent;
}

public void setAdherent(ADHERENT adherent) {
	this.adherent = adherent;
}

public AUTEUR getAuteur() {
	return auteur;
}

public void setAuteur(AUTEUR auteur) {
	this.auteur = auteur;
}
 

}

