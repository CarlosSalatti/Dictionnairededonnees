package com.example;

import java.util.Date;

/**
 * Created by csalatti on 28/06/16.
 */
public class UtilisateurModerateur extends Utilisateur {

    private String typePermission;
    private String typeCharge;
    private Date dateEmbauche;

    public String getTypePermission() {
        return typePermission;
    }

    public void setTypePermission(String typePermission) {
        this.typePermission = typePermission;
    }

    public String getTypeCharge() {
        return typeCharge;
    }

    public void setTypeCharge(String typeCharge) {
        this.typeCharge = typeCharge;
    }

    public Date getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(Date dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public String toString(){
        return "Id: " + getId() + "\n" + "Nom: " + getNom() + "\n" + "Prenom: " + getPreNom() + "\n" + "Age: " + getAge() + "\n" + "Adresse: " + getAdresseNumero() + ", " + getAdresseRue() + " - " + getAdresseVille() + "/" + getAdressePays() + "\n" +
                "E-mail: " + getEmail() + "\n" + "Login: " + getLogin() + "\n" + "Mot de Passe: " + getMotPasse() + "\n" + "Type de permission: " + typePermission + "\n" + "Type de charge: " + typeCharge + "\n"+ "Date d'Embauche " + dateEmbauche;
    }
}
