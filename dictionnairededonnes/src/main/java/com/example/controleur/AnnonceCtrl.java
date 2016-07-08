package com.example.controleur;


import com.example.Annonce;
import com.example.AnnonceArticlePeche;
import com.example.outils.DateUtil;
import com.example.outils.PropertiesUtil;

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

public class AnnonceCtrl {

    protected JSONObject jsonObject = null;

    //Lire un fichier JSON - Méthode pas utilisée (mais j'ai decidé de guarder le code)
    public Annonce lireJson() throws java.text.ParseException, IOException, ParseException {
        String path = PropertiesUtil.getValue("pathFichierJsonAnnonces");

        JSONParser parser = new JSONParser();
        Annonce annonce = new Annonce();
        Object obj = parser.parse(new FileReader(path + "annoncesPeche.json"));
        jsonObject = (JSONObject) obj;
        String prixAnnonce = (String) jsonObject.get("prix");
        String titreAnnonce = (String) jsonObject.get("titreAnnonce");
        String description = (String) jsonObject.get("description");
        String categorie = (String) jsonObject.get("categorie");
        String datePublication = (String) jsonObject.get("datePublication");

        annonce.setPrix(Double.parseDouble(prixAnnonce));
        annonce.setTitreAnnonce(titreAnnonce);
        annonce.setDescription(description);
        annonce.setCategorie(categorie);
        Date maDate = DateUtil.stringToDate(datePublication);
        annonce.setDatePublication(maDate);

        return annonce;
    }


    //Méthode pour enregistrer une liste d'Annonces (objets) dans un fichier JSON
    public void saveAsJSON(ArrayList<Annonce> annonces, String jsonFileName) throws Exception {

        String path = PropertiesUtil.getValue("pathFichierJsonAnnonces");
        JSONObject annoncese = new JSONObject();
        for (Annonce annonce : annonces) {

            JSONObject annonce1Content = new JSONObject();
            annonce1Content.put("titre", annonce.getTitreAnnonce());
            annonce1Content.put("categorie", annonce.getCategorie().toString());
            annonce1Content.put("prix", annonce.getPrix());
            annonce1Content.put("datePublication", DateUtil.dateToString(annonce.getDatePublication()));
            annonce1Content.put("description", annonce.getDescription());

            JSONObject annonce1 = new JSONObject();
            annonce1.put("annonce", annonce1Content);

            JSONArray listAnnonce = new JSONArray();
            listAnnonce.add(annonce1);

            annoncese.put("annonces", listAnnonce);
        }

        FileWriter file = new FileWriter(path + jsonFileName);
        file.write(annoncese.toJSONString());
        file.flush();
        file.close();
    }
















    /*

    !!! J'ai decidé de guarder toutes les méthodes de la classe de base

    //Écrire un fichier JSON - Méthode pas utilisée (mais j'ai decidé de guarder le code)
    public void ecrireJson(Annonce a) {

        JSONObject obj = new JSONObject();
        obj.put("titreAnnonce", a.getTitreAnnonce());
        obj.put("description", a.getDescription());
        obj.put("categorie", a.getCategorie());
        obj.put("prix", a.getPrix());
        String maDate = DateUtil.dateToString(a.getDatePublication());
        obj.put("datePublication", maDate);

        try {
            FileWriter file = new FileWriter("/Users/eleves/Desktop/TP1 Base de Donnees/annonces.json");
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
        Annonce annonce = new Annonce();
        try {
            Object obj = parser.parse(new FileReader("/Users/eleves/Desktop/TP1 Base de Donnees/annonces.json"));
            JSONObject jsonObject = (JSONObject) obj;
            String prixAnnonce = (String) jsonObject.get("prix");
            String titreAnnonce = (String) jsonObject.get("titreAnnonce");
            String description = (String) jsonObject.get("description");
            String categorie = (String) jsonObject.get("categorie");
            String datePublication = (String) jsonObject.get("datePublication");


            annonce.setPrix(Double.parseDouble(prixAnnonce));
            annonce.setTitreAnnonce(titreAnnonce);
            annonce.setDescription(description);
            annonce.setCategorie(categorie);
            Date maDate = DateUtil.stringToDate(datePublication);
            annonce.setDatePublication(maDate);

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
    public void saveAsJSON(ArrayList<Annonce> annonces, String jsonFileName) throws Exception {

        JSONObject annoncese = new JSONObject();
        for (Annonce annonce : annonces) {

            JSONObject annonce1Content = new JSONObject();
            annonce1Content.put("titre", annonce.getTitreAnnonce());
            annonce1Content.put("categorie", annonce.getCategorie().toString());
            annonce1Content.put("prix", annonce.getPrix());
            annonce1Content.put("datePublication", DateUtil.dateToString(annonce.getDatePublication()));
            annonce1Content.put("description", annonce.getDescription());

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

    public void readFromJSON() throws ParseException, Exception {
        ArrayList<Annonce> annonces = new ArrayList<Annonce>();

        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("/Users/eleves/Desktop/TP1 Base de Donnees/annonces.json"));

            JSONObject jsonObject = (JSONObject) obj;

            JSONArray jAnnonces = (JSONArray) jsonObject.get("annonces");

            for (int i = 0; i < jAnnonces.size(); i++) {
                System.out.println(jAnnonces.get(i));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        } catch (org.json.simple.parser.ParseException e)

        {
            e.printStackTrace();
        }

    }
    */
}
