package com.example;

import java.util.Date;

/**
 * Created by csalatti on 28/06/16.
 */
public class UtilisateurClient extends Utilisateur {

    private String typeClient;
    private String reputation;
    private Date dateInscription;

    public String getTypeClient() {
        return typeClient;
    }

    public void setTypeClient(String typeClient) {
        this.typeClient = typeClient;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    public String getReputation() {
        return reputation;
    }

    public void setReputation(String reputation) {
        this.reputation = reputation;
    }


    public String toString(){
        return "Id: " + getId() + "\n" + "Nom: " + getNom() + "\n" + "Prenom: " + getPreNom() + "\n" + "Age: " + getAge() + "\n" + "Adresse: " + getAdresseNumero() + ", " + getAdresseRue() + " - " + getAdresseVille() + "/" + getAdressePays() + "\n" +
                "E-mail: " + getEmail() + "\n" + "Login: " + getLogin() + "\n" + "Mot de Passe: " + getMotPasse() + "\n" + "Type de Client: " + typeClient + "\n" + "Reputation: " + reputation + "\n"+ "Date de Inscription " + dateInscription;
    }
}



