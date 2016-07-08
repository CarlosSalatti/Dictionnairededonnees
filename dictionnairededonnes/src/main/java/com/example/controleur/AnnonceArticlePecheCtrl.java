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

/**
 * Created by eleves on 16-06-29.
 */

public class AnnonceArticlePecheCtrl extends AnnonceCtrl {


    /**
     *
     * @param a
     * @throws IOException
     */

    //Écrire un fichier JSON - Méthode pas utilisée (mais j'ai decidé de guarder le code)
    public void ecrireJson(AnnonceArticlePeche a) throws IOException {

        String path = PropertiesUtil.getValue("pathFichierJsonAnnonces");
        JSONObject obj = new JSONObject();
        obj.put("titreAnnonce", a.getTitreAnnonce());
        obj.put("description", a.getDescription());
        obj.put("categorie", a.getCategorie());
        obj.put("prix", a.getPrix());
        String maDate = DateUtil.dateToString(a.getDatePublication());
        obj.put("datePublication", maDate);
        obj.put("typeMateriel", a.getTypeMateriel());
        obj.put("poisson", a.getTypePoisson());
        obj.put("categoriePeche", a.getCategoriePeche());
        try {
            FileWriter file = new FileWriter(path + "annoncesPeche.json");
            file.write(obj.toJSONString());
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.print(obj); //Imprimer le résultat de l'insertion dans le fichier
    }

    @Override
    public Annonce lireJson() throws IOException, java.text.ParseException, ParseException {

      super.lireJson();

       AnnonceArticlePeche annonce = new AnnonceArticlePeche();

       String typeMateriel = (String) jsonObject.get("typeMateriel");
       String poisson = (String) jsonObject.get("poisson");
       String categoriePeche = (String) jsonObject.get("categoriePeche");

        annonce.setTypeMateriel(typeMateriel);
        annonce.setCategoriePeche(categoriePeche);
        annonce.setTypePoisson(poisson);

        return annonce;

    }







    //Méthode pour enregistrer une liste d'Annonces (objets) dans un fichier JSON
    @Override
    public void saveAsJSON(ArrayList<AnnonceArticlePeche> annonces, String jsonFileName) throws Exception {

        String path = PropertiesUtil.getValue("pathFichierJsonAnnonces");
        JSONObject annoncese = new JSONObject();
        for (AnnonceArticlePeche annonce : annonces) {

            JSONObject annonce1Content = new JSONObject();
            annonce1Content.put("titre", annonce.getTitreAnnonce());
            annonce1Content.put("categorie", annonce.getCategorie().toString());
            annonce1Content.put("prix", annonce.getPrix());
            annonce1Content.put("datePublication", DateUtil.dateToString(annonce.getDatePublication()));
            annonce1Content.put("description", annonce.getDescription());
            annonce1Content.put("categoriePeche", annonce.getCategoriePeche());
            annonce1Content.put("typePoisson", annonce.getTypePoisson());
            annonce1Content.put("typeMateriel", annonce.getTypeMateriel());

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

    public ArrayList<AnnonceArticlePeche> readFromJSON() throws Exception
    {
        String path = PropertiesUtil.getValue("pathFichierJsonAnnonces");
        ArrayList<AnnonceArticlePeche> Peches = new ArrayList<>();
        System.out.println("");
        System.out.println("Articles de pêche enregistrés dans le système: ");

        JSONParser parser = new JSONParser();
        Object  obj= parser.parse(new FileReader(path + "annoncesPeche.json"));
        JSONObject jsonObjects = (JSONObject) obj;

        JSONArray   jsonAnnonces    = (JSONArray) jsonObjects.get("annonces");
        Iterator<JSONObject> AnnonceIterator = jsonAnnonces.iterator();

        while (AnnonceIterator.hasNext()) {
            AnnonceArticlePeche articlesPeche = new AnnonceArticlePeche();

            JSONObject jsonObject  = AnnonceIterator.next();
            JSONObject jsonAnnonce = (JSONObject) jsonObject.get("annonce");

            String categoriePeche = (String) jsonAnnonce.get("categoriePeche");
            String poisson = (String) jsonAnnonce.get("typePoisson");
            Double prixAnnonce = (Double) jsonAnnonce.get("prix");
            String categorie = (String) jsonAnnonce.get("categorie");
            String description = (String) jsonAnnonce.get("description");
            String datePublication = (String) jsonAnnonce.get("datePublication");
            String titreAnnonce = (String) jsonAnnonce.get("titre");
            String typeMateriel = (String) jsonAnnonce.get("typeMateriel");

            articlesPeche.setPrix(prixAnnonce);
            articlesPeche.setTitreAnnonce(titreAnnonce);
            articlesPeche.setDescription(description);
            articlesPeche.setCategorie(categorie);
            Date maDate = DateUtil.stringToDate(datePublication);
            articlesPeche.setDatePublication(maDate);
            articlesPeche.setTypeMateriel(typeMateriel);
            articlesPeche.setCategoriePeche(categoriePeche);
            articlesPeche.setTypePoisson(poisson);
            Peches.add(articlesPeche);
        }
        return Peches;
    }
}