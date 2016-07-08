package com.example;

/**
 * Created by csalatti on 28/06/16.
 */
public class AnnonceVehicule extends Annonce {

    private Double anneeVehicule;
    private Double kmRoules;
    private String marque;
    private String modele;
    private String couleur;
    private String categorieVehicule;

    public Double getAnneeVehicule() {
        return anneeVehicule;
    }

    public void setAnneeVehicule(Double anneeVehicule) {
        this.anneeVehicule = anneeVehicule;
    }

    public Double getKmRoules() {
        return kmRoules;
    }

    public void setKmRoules(Double kmRoules) {
        this.kmRoules = kmRoules;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getCategorieVehicule() {
        return categorieVehicule;
    }

    public void setCategorieVehicule(String categorieVehicule) {
        this.categorieVehicule = categorieVehicule;
    }

    public String toString(){
        return "Titre Annonce: " + getTitreAnnonce() + "\n" + "Categorie: " + getCategorie() + "\n" + "Date de Publication: " + getDatePublication() + "\n" + "Description: " + getDescription() + "\n" + "Prix: CAD "
                + getPrix() + "\n" + "Année du vehicule: " + anneeVehicule + "\n" + "Km roulés: " + kmRoules + "\n" + "Marque: " + marque + "\n" + "Modèle: " + modele + "\n" + "Couleur: " + couleur + "\n" + "Categorie du Vehicule: " + categorieVehicule + "\n";
    }

}
