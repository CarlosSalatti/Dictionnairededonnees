package com.example;

/**
 * Created by csalatti on 28/06/16.
 */
public class AnnonceOffresEmploy extends Annonce {

    private String typeEmploy;
    private double SalaireOffre;
    private String temps; //si le travail est à temps plein ou partiel.

    public Double getTempsExperienceRequise() {
        return tempsExperienceRequise;
    }

    public void setTempsExperienceRequise(Double tempsExperienceRequise) {
        this.tempsExperienceRequise = tempsExperienceRequise;
    }

    private Double tempsExperienceRequise;

    public String getTypeEmploy() {
        return typeEmploy;
    }

    public void setTypeEmploy(String typeEmploy) {
        this.typeEmploy = typeEmploy;
    }

    public double getSalaireOffre() {
        return SalaireOffre;
    }

    public void setSalaireOffre(double salaireOffre) {
        SalaireOffre = salaireOffre;
    }

    public String getTemps() {
        return temps;
    }

    public void setTemps(String temps) {
        this.temps = temps;
    }

    public String toString(){
        return "Titre Annonce: " + getTitreAnnonce() + "\n" + "Categorie: " + getCategorie() + "\n" + "Date de Publication: " + getDatePublication() + "\n" + "Description: " + getDescription() + "\n" + "Prix: CAD "
                + getPrix() + "\n" + "Type Employ: " + typeEmploy + "\n" + "Salaire Offre: " + SalaireOffre + "\n" + "Temps de travail: " + temps + "\n" + "Experience requise: " + tempsExperienceRequise + "\n";
    }

}
