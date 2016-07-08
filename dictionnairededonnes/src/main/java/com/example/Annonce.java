package com.example;

import java.util.Date;

/**
 * Created by eleves on 2016-05-12.
 */
public class Annonce {

    private String titreAnnonce;
    private String categorie;
    private Date datePublication;
    private String description;
    private double prix;

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getTitreAnnonce() {
        return titreAnnonce;
    }

    public void setTitreAnnonce(String titreAnnonce) {
        this.titreAnnonce = titreAnnonce;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Date getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString(){
        return "Titre Annonce: " + titreAnnonce + "\n" + "Categorie: " + categorie + "\n"  ;
    }
}
