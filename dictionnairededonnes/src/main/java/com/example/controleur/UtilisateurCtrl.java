package com.example.controleur;


/**
 * Created by eleves on 2016-05-12.
 */

public class UtilisateurCtrl {









    /*

    !!! J'ai decidé de guarder toutes les méthodes de la classe de base

    //Écrire un fichier JSON - Méthode pas utilisée (mais j'ai decidé de guarder le code)
    public void ecrireJson(Utilisateur a) {

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

        String maDate = DateUtil.dateToString(a.getDateInscription());
        obj.put("dateInscription", maDate);

        try {
            FileWriter file = new FileWriter("/Users/eleves/Desktop/TP1 Base de Donnees/Utilisateurs.json");
            file.write(obj.toJSONString());
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.print(obj); //Imprimer le résultat de l'insertion dans le fichier
    }

    //Lire un fichier JSON - Méthode pas utilisée (mais j'ai decidé de guarder le code)
    public Utilisateur lireJson() throws java.text.ParseException {

        JSONParser parser = new JSONParser();
        Utilisateur utilisateur = new Utilisateur();
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
            utilisateur.setId((int) Double.parseDouble(id));
            utilisateur.setNom(nom);
            utilisateur.setPreNom(prenom);
            utilisateur.setDateInscription(maDate);
            utilisateur.setAdresseRue(adresseRue);
            utilisateur.setAdresseNumero(Integer.parseInt(adresseNum));
            utilisateur.setAdresseVille(ville);
            utilisateur.setAdressePays(pays);
            utilisateur.setEmail(email);
            utilisateur.setAge(Integer.parseInt(age));
            utilisateur.setLogin(login);
            utilisateur.setMotPasse(motPasse);

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
    public void saveAsJSON(ArrayList<Utilisateur> utilisateurs, String jsonFileName) throws Exception {


        JSONObject util = new JSONObject();
        for (Utilisateur utilisateur : utilisateurs) {

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

    public void readFromJSON() throws ParseException,Exception
    {
        ArrayList<Utilisateur> annonces = new ArrayList<Utilisateur>();

        JSONParser parser = new JSONParser();

        try{
            Object obj = parser.parse(new FileReader("/Users/eleves/Desktop/TP1 Base de Donnees/utilisateur.json"));

            JSONObject jsonObject = (JSONObject) obj;

            JSONArray jAnnonces = (JSONArray) jsonObject.get("utilisateurs");

            for(int i=0;i<jAnnonces.size();i++){
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
