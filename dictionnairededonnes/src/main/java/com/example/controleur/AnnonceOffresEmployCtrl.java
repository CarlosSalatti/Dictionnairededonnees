package com.example.controleur;

import com.example.Annonce;
import com.example.AnnonceArticlePeche;
import com.example.AnnonceOffresEmploy;
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
public class AnnonceOffresEmployCtrl extends AnnonceCtrl {

    //Écrire un fichier JSON - Méthode pas utilisée (mais j'ai decidé de guarder le code)
    public void ecrireJson(AnnonceOffresEmploy a) throws IOException {
        String path = PropertiesUtil.getValue("pathFichierJsonAnnonces");

        JSONObject obj = new JSONObject();
        obj.put("titreAnnonce", a.getTitreAnnonce());
        obj.put("description", a.getDescription());
        obj.put("categorie", a.getCategorie());
        obj.put("prix", a.getPrix());
        String maDate = DateUtil.dateToString(a.getDatePublication());
        obj.put("datePublication", maDate);
        obj.put("salaire",  a.getSalaireOffre());
        obj.put("temps",  a.getTemps());
        obj.put("tempsRequise",  a.getTempsExperienceRequise());
        obj.put("typeEmploy",  a.getTypeEmploy());
        try {
            FileWriter file = new FileWriter(path + "annoncesEmploy.json");
            file.write(obj.toJSONString());
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.print(obj); //Imprimer le résultat de l'insertion dans le fichier
    }
    //Lire un fichier JSON - Méthode pas utilisée (mais j'ai decidé de guarder le code)
    public Annonce lireJson() throws java.text.ParseException, IOException {
        String path = PropertiesUtil.getValue("pathFichierJsonAnnonces");

        JSONParser parser = new JSONParser();
        AnnonceOffresEmploy annonce = new AnnonceOffresEmploy();
        try {
            Object obj = parser.parse(new FileReader(path + "annoncesEmploy.json"));
            JSONObject jsonObject = (JSONObject) obj;
            String prixAnnonce = (String) jsonObject.get("prix");
            String titreAnnonce = (String) jsonObject.get("titreAnnonce");
            String description = (String) jsonObject.get("description");
            String categorie = (String) jsonObject.get("categorie");
            String datePublication = (String) jsonObject.get("datePublication");
            String salaire = (String) jsonObject.get("salaire");
            String temps = (String) jsonObject.get("temps");
            String tempsRequise = (String) jsonObject.get("tempsRequise");
            String typeEmploy = (String) jsonObject.get("typeEmploy");

            annonce.setPrix(Double.parseDouble(prixAnnonce));
            annonce.setTitreAnnonce(titreAnnonce);
            annonce.setDescription(description);
            annonce.setCategorie(categorie);
            Date maDate = DateUtil.stringToDate(datePublication);
            annonce.setDatePublication(maDate);
            annonce.setSalaireOffre(Double.parseDouble(salaire));
            annonce.setTemps(temps);
           // annonce.setTempsExperienceRequise(Integer.parseInt(tempsRequise));
            annonce.setTypeEmploy(typeEmploy);
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
    public void saveAsJSON (ArrayList<AnnonceOffresEmploy> annonces, String jsonFileName) throws Exception {
        String path = PropertiesUtil.getValue("pathFichierJsonAnnonces");

        JSONObject annoncese = new JSONObject();
        for (AnnonceOffresEmploy annonce : annonces) {

            JSONObject annonce1Content = new JSONObject();
            annonce1Content.put("titre", annonce.getTitreAnnonce());
            annonce1Content.put("categorie", annonce.getCategorie().toString());
            annonce1Content.put("prix", annonce.getPrix());
            annonce1Content.put("datePublication", DateUtil.dateToString(annonce.getDatePublication()));
            annonce1Content.put("description", annonce.getDescription());
            annonce1Content.put("salaireOfrre", annonce.getSalaireOffre());
            annonce1Content.put("temps", annonce.getTemps());
            annonce1Content.put("experienceRequise", annonce.getTempsExperienceRequise());
            annonce1Content.put("typeEmploy", annonce.getTypeEmploy());

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

    public ArrayList<AnnonceOffresEmploy> readFromJSON() throws Exception
    {
        String path = PropertiesUtil.getValue("pathFichierJsonAnnonces");
        ArrayList<AnnonceOffresEmploy> Employ = new ArrayList<>();
        System.out.println("");
        System.out.println("Offres d'employs enregistrés dans le système: ");


        JSONParser parser = new JSONParser();
        Object  obj= parser.parse(new FileReader(path + "annoncesEmploy.json"));
        JSONObject jsonObjects = (JSONObject) obj;

        JSONArray   jsonAnnonces    = (JSONArray) jsonObjects.get("annonces");
        Iterator<JSONObject> AnnonceIterator = jsonAnnonces.iterator();

        while (AnnonceIterator.hasNext()) {
            AnnonceOffresEmploy offresDEmploy = new AnnonceOffresEmploy();

            JSONObject jsonObject  = AnnonceIterator.next();
            JSONObject jsonAnnonce = (JSONObject) jsonObject.get("annonce");


            Double prixAnnonce = (Double) jsonAnnonce.get("prix");
            String titreAnnonce = (String) jsonAnnonce.get("titre");
            String description = (String) jsonAnnonce.get("description");
            String categorie = (String) jsonAnnonce.get("categorie");
            String datePublication = (String) jsonAnnonce.get("datePublication");
            Double salaire = (Double) jsonAnnonce.get("salaireOfrre");
            String temps = (String) jsonAnnonce.get("temps");
            Double tempsRequise = (Double) jsonAnnonce.get("experienceRequise");
            String typeEmploy = (String) jsonAnnonce.get("typeEmploy");

            offresDEmploy.setPrix(prixAnnonce);
            offresDEmploy.setTitreAnnonce(titreAnnonce);
            offresDEmploy.setDescription(description);
            offresDEmploy.setCategorie(categorie);
            Date maDate = DateUtil.stringToDate(datePublication);
            offresDEmploy.setDatePublication(maDate);


            offresDEmploy.setSalaireOffre(salaire);
            offresDEmploy.setTemps(temps);
            offresDEmploy.setTempsExperienceRequise(tempsRequise);
            offresDEmploy.setTypeEmploy(typeEmploy);

            Employ.add(offresDEmploy);
        }
        return Employ;
    }

}
