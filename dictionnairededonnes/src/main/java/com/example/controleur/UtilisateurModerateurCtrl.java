package com.example.controleur;


import com.example.UtilisateurClient;
import com.example.UtilisateurModerateur;
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
public class UtilisateurModerateurCtrl extends UtilisateurCtrl {

    //Écrire un fichier JSON - Méthode pas utilisée (mais j'ai decidé de guarder le code)
    public void ecrireJson(UtilisateurModerateur a) {

        JSONObject obj = new JSONObject();
        obj.put("id", a.getId());
        obj.put("nom", a.getNom());
        obj.put("prenom", a.getPreNom());
        obj.put("age", a.getAge());
        obj.put("login", a.getLogin());
        obj.put("motPasse", a.getMotPasse());
        obj.put("rue", a.getAdresseRue());
        obj.put("adressenum", a.getAdresseNumero());
        obj.put("ville", a.getAdresseVille());
        obj.put("pays", a.getAdressePays());
        obj.put("email", a.getEmail());
        String maDate = DateUtil.dateToString(a.getDateEmbauche());
        obj.put("dateEmbauche", maDate);
        obj.put("typeCharge", a.getTypeCharge());
        obj.put("permission", a.getTypePermission());
        try {
            FileWriter file = new FileWriter("/Users/eleves/Desktop/TP1 Base de Donnees/UtilisateursModerateur.json");
            file.write(obj.toJSONString());
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
       //System.out.print(obj); //Imprimer le résultat de l'insertion dans le fichier
    }

    //Lire un fichier JSON - Méthode pas utilisée (mais j'ai decidé de guarder le code)
    public UtilisateurModerateur lireJson() throws java.text.ParseException {

        JSONParser parser = new JSONParser();
        UtilisateurModerateur utilisateur = new UtilisateurModerateur();
        try {
            Object obj = parser.parse(new FileReader("/Users/eleves/Desktop/TP1 Base de Donnees/utilisateurModerateur.json"));
            JSONObject jsonObject = (JSONObject) obj;
            String id = (String) jsonObject.get("id");
            String nom = (String) jsonObject.get("nom");
            String prenom = (String) jsonObject.get("prenom");
            String dateEmbauche = (String) jsonObject.get("dateEmbauche");
            String age = (String) jsonObject.get("age");
            String login = (String) jsonObject.get("login");
            String motPasse = (String) jsonObject.get("motPasse");
            String adresseRue = (String) jsonObject.get("rue");
            String adresseNum = (String) jsonObject.get("adresseNum");
            String ville = (String) jsonObject.get("ville");
            String pays = (String) jsonObject.get("pays");
            String email = (String) jsonObject.get("email");
            String typeCharge = (String) jsonObject.get("typeCharge");
            String permission = (String) jsonObject.get("permission");

            //utilisateur.setId((int) Double.parseDouble(id));
            utilisateur.setNom(nom);
            utilisateur.setPreNom(prenom);
            Date maDate = DateUtil.stringToDate(dateEmbauche);
            utilisateur.setDateEmbauche(maDate);
            //utilisateur.setAge(Integer.parseInt(age));
            utilisateur.setLogin(login);
            utilisateur.setMotPasse(motPasse);
            utilisateur.setAdresseRue(adresseRue);
           // utilisateur.setAdresseNumero(Integer.parseInt(adresseNum));
            utilisateur.setAdresseVille(ville);
            utilisateur.setAdressePays(pays);
            utilisateur.setEmail(email);
            utilisateur.setTypeCharge(typeCharge);
            utilisateur.setTypePermission(permission);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return utilisateur;
    }

    //Méthode pour enregistrer une liste d'Utilisateurs (objets) dans un fichier JSON
    public void saveAsJSON(ArrayList<UtilisateurModerateur> utilisateurs, String jsonFileName) throws Exception {

        JSONObject util = new JSONObject();
        for (UtilisateurModerateur utilisateur : utilisateurs) {

            JSONObject utilisateur1content = new JSONObject();
            utilisateur1content.put("id", utilisateur.getId());
            utilisateur1content.put("email", utilisateur.getEmail());
            utilisateur1content.put("motPasse", utilisateur.getMotPasse());
            utilisateur1content.put("login", utilisateur.getLogin());
            utilisateur1content.put("pays", utilisateur.getAdressePays());
            utilisateur1content.put("ville", utilisateur.getAdresseVille());
            utilisateur1content.put("rue", utilisateur.getAdresseRue());
            utilisateur1content.put("adresseNum", utilisateur.getAdresseNumero());
            utilisateur1content.put("age", utilisateur.getAge());
            utilisateur1content.put("prenom", utilisateur.getPreNom());
            utilisateur1content.put("nom", utilisateur.getNom());
            utilisateur1content.put("typeCharge", utilisateur.getTypeCharge());
            utilisateur1content.put("permission", utilisateur.getTypePermission());
            utilisateur1content.put("dateEmbauche", DateUtil.dateToString(utilisateur.getDateEmbauche()));

            JSONObject utilisateur1 = new JSONObject();
            utilisateur1.put("utilisateur", utilisateur1content);

            JSONArray listUtilisateur = new JSONArray();
            listUtilisateur.add(utilisateur1);

            util.put("utilisateurs", listUtilisateur);
        }

        FileWriter file = new FileWriter("/Users/eleves/Desktop/TP1 Base de Donnees/" + jsonFileName);
        file.write(util.toJSONString());
        file.flush();
        file.close();
    }

    public ArrayList<UtilisateurModerateur> readFromJSON() throws Exception
    {
        ArrayList<UtilisateurModerateur> Moderateur = new ArrayList<>();
        System.out.println("");
        System.out.println("Moderateurs enregistrés dans le système: ");


        JSONParser parser = new JSONParser();
        Object  obj= parser.parse(new FileReader("/Users/eleves/Desktop/TP1 Base de Donnees/utilisateurModerateur.json"));
        JSONObject jsonObjects = (JSONObject) obj;

        JSONArray   jsonAnnonces    = (JSONArray) jsonObjects.get("utilisateurs");
        Iterator<JSONObject> AnnonceIterator = jsonAnnonces.iterator();

        while (AnnonceIterator.hasNext()) {
            UtilisateurModerateur utilisateurModerateur = new UtilisateurModerateur();

            JSONObject jsonObject  = AnnonceIterator.next();
            JSONObject jsonAnnonce = (JSONObject) jsonObject.get("utilisateur");

            Double id = (Double) jsonAnnonce.get("id");
            String nom = (String) jsonAnnonce.get("nom");
            String prenom = (String) jsonAnnonce.get("prenom");
            String dateEmbauche = (String) jsonAnnonce.get("dateEmbauche");
            Double age = (Double) jsonAnnonce.get("age");
            String login = (String) jsonAnnonce.get("login");
            String motPasse = (String) jsonAnnonce.get("motPasse");
            String adresseRue = (String) jsonAnnonce.get("rue");
            Double adresseNum = (Double) jsonAnnonce.get("adresseNum");
            String ville = (String) jsonAnnonce.get("ville");
            String pays = (String) jsonAnnonce.get("pays");
            String email = (String) jsonAnnonce.get("email");
            String typeCharge = (String) jsonAnnonce.get("typeCharge");
            String permission = (String) jsonAnnonce.get("permission");

            utilisateurModerateur.setId(id);
            utilisateurModerateur.setNom(nom);
            utilisateurModerateur.setPreNom(prenom);
            Date maDate = DateUtil.stringToDate(dateEmbauche);
            utilisateurModerateur.setDateEmbauche(maDate);
            utilisateurModerateur.setAdresseRue(adresseRue);
            utilisateurModerateur.setAdresseNumero(adresseNum);
            utilisateurModerateur.setAdresseVille(ville);
            utilisateurModerateur.setAdressePays(pays);
            utilisateurModerateur.setEmail(email);
            utilisateurModerateur.setAge(age);
            utilisateurModerateur.setLogin(login);
            utilisateurModerateur.setMotPasse(motPasse);
            utilisateurModerateur.setTypePermission(permission);
            utilisateurModerateur.setTypeCharge(typeCharge);

            Moderateur.add(utilisateurModerateur);
        }
        return Moderateur;
    }

}
