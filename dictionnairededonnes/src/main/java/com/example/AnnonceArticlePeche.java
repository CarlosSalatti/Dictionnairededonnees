package com.example;

/**
 * Created by csalatti on 28/06/16.
 */
public class AnnonceArticlePeche extends Annonce {

    private String categoriePeche;
    private String typeMateriel;
    private String typePoisson;

    public String getCategoriePeche() {
        return categoriePeche;
    }

    public void setCategoriePeche(String categoriePeche) {
        this.categoriePeche = categoriePeche;
    }

    public String getTypeMateriel() {
        return typeMateriel;
    }

    public void setTypeMateriel(String typeMateriel) {
        this.typeMateriel = typeMateriel;
    }

    public String getTypePoisson() {
        return typePoisson;
    }

    public void setTypePoisson(String typePoisson) {
        this.typePoisson = typePoisson;
    }

    public String toString(){
        return "Titre Annonce: " + getTitreAnnonce() + "\n" + "Categorie: " + getCategorie() + "\n" + "Date de Publication: " + getDatePublication() + "\n" + "Description: " + getDescription() + "\n" + "Prix: CAD "
                + getPrix() + "\n" + "Categorie de pêche: " + categoriePeche + "\n" + "Type de materiel: " + typeMateriel + "\n" + "Type de poisson: " + typePoisson + "\n";
    }

}

