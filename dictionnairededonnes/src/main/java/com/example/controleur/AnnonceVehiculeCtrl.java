package com.example.controleur;

import com.example.Annonce;

import com.example.AnnonceOffresEmploy;
import com.example.AnnonceVehicule;
import com.example.outils.DateUtil;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 * Created by eleves on 16-06-29.
 */
public class AnnonceVehiculeCtrl extends AnnonceCtrl {

    //Écrire un fichier JSON - Méthode pas utilisée (mais j'ai decidé de guarder le code)
    public void ecrireJson(AnnonceVehicule a) {

        JSONObject obj = new JSONObject();
        obj.put("titreAnnonce", a.getTitreAnnonce());
        obj.put("description", a.getDescription());
        obj.put("categorie", a.getCategorie());
        obj.put("prix", a.getPrix());
        String maDate = DateUtil.dateToString(a.getDatePublication());
        obj.put("datePublication", maDate);
        obj.put("annee", a.getAnneeVehicule());
        obj.put("categorieVehicule", a.getCategorieVehicule());
        obj.put("couleur", a.getCouleur());
        obj.put("kmRoules", a.getKmRoules());
        obj.put("marque", a.getMarque());
        obj.put("modele", a.getModele());
        try {
            FileWriter file = new FileWriter("/Users/eleves/Desktop/TP1 Base de Donnees/annoncesVehicule.json");
            file.write(obj.toJSONString());
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.print(obj); //Imprimer le résultat de l'insertion dans le fichier
    }

    //Lire un fichier JSON - Méthode pas utilisée (mais j'ai decidé de guarder le code)
    public Annonce lireJson() throws java.text.ParseException {

        JSONParser parser = new JSONParser();
        AnnonceVehicule annonce = new AnnonceVehicule();
        try {
            Object obj = parser.parse(new FileReader("/Users/eleves/Desktop/TP1 Base de Donnees/Annonces.json"));
            JSONObject jsonObject = (JSONObject) obj;
            String prixAnnonce = (String) jsonObject.get("prix");
            String titreAnnonce = (String) jsonObject.get("titreAnnonce");
            String description = (String) jsonObject.get("description");
            String categorie = (String) jsonObject.get("categorie");
            String datePublication = (String) jsonObject.get("datePublication");
            String annee = (String) jsonObject.get("annee");
            String categorieVehicule = (String) jsonObject.get("categorieVehicule");
            String marque = (String) jsonObject.get("marque");
            String modele = (String) jsonObject.get("modele");
            String kmRoules = (String) jsonObject.get("kmRoules");

            annonce.setPrix(Double.parseDouble(prixAnnonce));
            annonce.setTitreAnnonce(titreAnnonce);
            annonce.setDescription(description);
            annonce.setCategorie(categorie);
            Date maDate = DateUtil.stringToDate(datePublication);
            annonce.setDatePublication(maDate);
            //annonce.setAnneeVehicule((int) Double.parseDouble(annee));
            annonce.setCategorieVehicule(categorieVehicule);
            //annonce.setKmRoules(Integer.parseInt(kmRoules));
            annonce.setModele(modele);
            annonce.setMarque(marque);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return annonce;
    }

    //Méthode pour enregistrer une liste d'Annonces (objets) dans un fichier JSON
    public void saveAsJSON (ArrayList<AnnonceVehicule> annonces, String jsonFileName) throws Exception {

        JSONObject annoncese = new JSONObject();
        for (AnnonceVehicule annonce : annonces) {

            JSONObject annonce1Content = new JSONObject();
            annonce1Content.put("titre", annonce.getTitreAnnonce());
            annonce1Content.put("categorie", annonce.getCategorie().toString());
            annonce1Content.put("prix", annonce.getPrix());
            annonce1Content.put("datePublication", DateUtil.dateToString(annonce.getDatePublication()));
            annonce1Content.put("description", annonce.getDescription());
            annonce1Content.put("anneeVehicule", annonce.getAnneeVehicule());
            annonce1Content.put("categorieVehicule", annonce.getCategorieVehicule());
            annonce1Content.put("couleur", annonce.getCouleur());
            annonce1Content.put("kmRoules", annonce.getKmRoules());
            annonce1Content.put("marque", annonce.getMarque());
            annonce1Content.put("modele", annonce.getModele());

            JSONObject annonce1 = new JSONObject();
            annonce1.put("annonce", annonce1Content);

            JSONArray listAnnonce = new JSONArray();
            listAnnonce.add(annonce1);

            annoncese.put("annonces", listAnnonce);

        }

        FileWriter file = new FileWriter("/Users/eleves/Desktop/TP1 Base de Donnees/" + jsonFileName);
        file.write(annoncese.toJSONString());
        file.flush();
        file.close();

    }

    public ArrayList<AnnonceVehicule> readFromJSON() throws Exception
    {
        ArrayList<AnnonceVehicule> Vehicule = new ArrayList<>();
        System.out.println("");
        System.out.println("Annonces de Vehicules enregistrés dans le système: ");


        JSONParser parser = new JSONParser();
        Object  obj= parser.parse(new FileReader("/Users/eleves/Desktop/TP1 Base de Donnees/annoncesVehicule.json"));
        JSONObject jsonObjects = (JSONObject) obj;

        JSONArray   jsonAnnonces    = (JSONArray) jsonObjects.get("annonces");
        Iterator<JSONObject> AnnonceIterator = jsonAnnonces.iterator();

        while (AnnonceIterator.hasNext()) {
            AnnonceVehicule annonceVehicule = new AnnonceVehicule();

            JSONObject jsonObject  = AnnonceIterator.next();
            JSONObject jsonAnnonce = (JSONObject) jsonObject.get("annonce");

            Double prixAnnonce = (Double) jsonAnnonce.get("prix");
            String titreAnnonce = (String) jsonAnnonce.get("titre");
            String description = (String) jsonAnnonce.get("description");
            String categorie = (String) jsonAnnonce.get("categorie");
            String datePublication = (String) jsonAnnonce.get("datePublication");
            Double annee = (Double) jsonAnnonce.get("anneeVehicule");
            String categorieVehicule = (String) jsonAnnonce.get("categorieVehicule");
            String marque = (String) jsonAnnonce.get("marque");
            String modele = (String) jsonAnnonce.get("modele");
            String couleur = (String) jsonAnnonce.get("couleur");
            Double kmRoules = (Double) jsonAnnonce.get("kmRoules");

            annonceVehicule.setPrix(prixAnnonce);
            annonceVehicule.setTitreAnnonce(titreAnnonce);
            annonceVehicule.setDescription(description);
            annonceVehicule.setCategorie(categorie);
            Date maDate = DateUtil.stringToDate(datePublication);
            annonceVehicule.setDatePublication(maDate);
            annonceVehicule.setAnneeVehicule(annee);
            annonceVehicule.setCategorieVehicule(categorieVehicule);
            annonceVehicule.setKmRoules(kmRoules);
            annonceVehicule.setModele(modele);
            annonceVehicule.setMarque(marque);
            annonceVehicule.setMarque(couleur);

            Vehicule.add(annonceVehicule);
        }
        return Vehicule;
    }

}
