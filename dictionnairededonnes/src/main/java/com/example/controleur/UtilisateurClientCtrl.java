package com.example.controleur;


import com.example.AnnonceVehicule;
import com.example.Utilisateur;
import com.example.UtilisateurClient;
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
public class UtilisateurClientCtrl extends UtilisateurCtrl {

    //Écrire un fichier JSON - Méthode pas utilisée (mais j'ai decidé de guarder le code)
    public void ecrireJson(UtilisateurClient a) {

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
        obj.put("reputation", a.getReputation());
        obj.put("typeClient", a.getTypeClient());
        String maDate = DateUtil.dateToString(a.getDateInscription());
        obj.put("dateInscription", maDate);

        try {
            FileWriter file = new FileWriter("/Users/eleves/Desktop/TP1 Base de Donnees/UtilisateursClient.json");
            file.write(obj.toJSONString());
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.print(obj); //Imprimer le résultat de l'insertion dans le fichier
    }

    //Lire un fichier JSON - Méthode pas utilisée (mais j'ai decidé de guarder le code)
    public UtilisateurClient lireJson() throws java.text.ParseException {

        JSONParser parser = new JSONParser();
        UtilisateurClient utilisateur = new UtilisateurClient();
        try {
            Object obj = parser.parse(new FileReader("/Users/eleves/Desktop/TP1 Base de Donnees/Annonces.json"));
            JSONObject jsonObject = (JSONObject) obj;
            String id = (String) jsonObject.get("id");
            String nom = (String) jsonObject.get("nom");
            String prenom = (String) jsonObject.get("prenom");
            String dateInscription = (String) jsonObject.get("dateInscription");
            String age = (String) jsonObject.get("age");
            String login = (String) jsonObject.get("login");
            String motPasse = (String) jsonObject.get("motPasse");
            String adresseRue = (String) jsonObject.get("rue");
            String adresseNum = (String) jsonObject.get("adresseNum");
            String ville = (String) jsonObject.get("ville");
            String pays = (String) jsonObject.get("pays");
            String email = (String) jsonObject.get("email");
            String reputation = (String) jsonObject.get("reputation");
            String typeClient = (String) jsonObject.get("typeClient");

            //utilisateur.setId((int) Double.parseDouble(id));
            utilisateur.setNom(nom);
            utilisateur.setPreNom(prenom);
            Date maDate = DateUtil.stringToDate(dateInscription);
            utilisateur.setDateInscription(maDate);
            utilisateur.setAdresseRue(adresseRue);
            //utilisateur.setAdresseNumero(Integer.parseInt(adresseNum));
            utilisateur.setAdresseVille(ville);
            utilisateur.setAdressePays(pays);
            utilisateur.setEmail(email);
            //utilisateur.setAge(Integer.parseInt(age));
            utilisateur.setLogin(login);
            utilisateur.setMotPasse(motPasse);
            utilisateur.setReputation(reputation);
            utilisateur.setTypeClient(typeClient);
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
    public void saveAsJSON(ArrayList<UtilisateurClient> utilisateurs, String jsonFileName) throws Exception {


        JSONObject util = new JSONObject();
        for (UtilisateurClient utilisateur : utilisateurs) {

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
            utilisateur1content.put("typeClient", utilisateur.getTypeClient());
            utilisateur1content.put("reputation", utilisateur.getReputation());
            utilisateur1content.put("dateInscription", DateUtil.dateToString(utilisateur.getDateInscription()));

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

    public ArrayList<UtilisateurClient> readFromJSON() throws Exception
    {
        ArrayList<UtilisateurClient> Clients = new ArrayList<>();
        System.out.println("");
        System.out.println("Clients enregistrés dans le système: ");


        JSONParser parser = new JSONParser();
        Object  obj= parser.parse(new FileReader("/Users/eleves/Desktop/TP1 Base de Donnees/utilisateurClient.json"));
        JSONObject jsonObjects = (JSONObject) obj;

        JSONArray   jsonAnnonces    = (JSONArray) jsonObjects.get("utilisateurs");
        Iterator<JSONObject> AnnonceIterator = jsonAnnonces.iterator();

        while (AnnonceIterator.hasNext()) {
            UtilisateurClient utilisateurClient = new UtilisateurClient();

            JSONObject jsonObject  = AnnonceIterator.next();
            JSONObject jsonAnnonce = (JSONObject) jsonObject.get("utilisateur");

            Double id = (Double) jsonAnnonce.get("id");
            String nom = (String) jsonAnnonce.get("nom");
            String prenom = (String) jsonAnnonce.get("prenom");
            String dateInscription = (String) jsonAnnonce.get("dateInscription");
            Double age = (Double) jsonAnnonce.get("age");
            String login = (String) jsonAnnonce.get("login");
            String motPasse = (String) jsonAnnonce.get("motPasse");
            String adresseRue = (String) jsonAnnonce.get("rue");
            Double adresseNum = (Double) jsonAnnonce.get("adresseNum");
            String ville = (String) jsonAnnonce.get("ville");
            String pays = (String) jsonAnnonce.get("pays");
            String email = (String) jsonAnnonce.get("email");
            String reputation = (String) jsonAnnonce.get("reputation");
            String typeClient = (String) jsonAnnonce.get("typeClient");

            utilisateurClient.setId(id);
            utilisateurClient.setNom(nom);
            utilisateurClient.setPreNom(prenom);
            Date maDate = DateUtil.stringToDate(dateInscription);
            utilisateurClient.setDateInscription(maDate);
            utilisateurClient.setAdresseRue(adresseRue);
            utilisateurClient.setAdresseNumero(adresseNum);
            utilisateurClient.setAdresseVille(ville);
            utilisateurClient.setAdressePays(pays);
            utilisateurClient.setEmail(email);
            utilisateurClient.setAge(age);
            utilisateurClient.setLogin(login);
            utilisateurClient.setMotPasse(motPasse);
            utilisateurClient.setReputation(reputation);
            utilisateurClient.setTypeClient(typeClient);

            Clients.add(utilisateurClient);
        }
        return Clients;
    }



}
