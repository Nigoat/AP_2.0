package Model;

public class AUTEUR {
	
	
 private String num;
 private String nom;
 private String prenom;
 private String dateNaissance;
 private String description;


 public AUTEUR(String num, String nom, String prenom, String dateNaissance, String description) {
     this.num = num;
     this.nom = nom;
     this.prenom = prenom;
     this.dateNaissance = dateNaissance;
     this.description = description;
 }
 
 public String getNum() {
	return num;
}


public void setNum(String num) {
	this.num = num;
}


public String getNom() {
	return nom;
}


public void setNom(String nom) {
	this.nom = nom;
}


public String getPrenom() {
	return prenom;
}


public void setPrenom(String prenom) {
	this.prenom = prenom;
}


public String getDateNaissance() {
	return dateNaissance;
}


public void setDateNaissance(String dateNaissance) {
	this.dateNaissance = dateNaissance;
}


public String getDescription() {
	return description;
}


public void setDescription(String description) {
	this.description = description;
}


}
