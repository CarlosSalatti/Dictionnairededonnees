package com.example;

import com.example.controleur.AnnonceArticlePecheCtrl;
import com.example.controleur.AnnonceOffresEmployCtrl;
import com.example.controleur.AnnonceVehiculeCtrl;
import com.example.controleur.UtilisateurClientCtrl;
import com.example.controleur.UtilisateurModerateurCtrl;
import com.example.outils.DateUtil;
import java.io.IOException;
import java.util.ArrayList;

public class DictionnaireDeDonnes {
    public static void main(String[] args) throws IOException {

        // Entrees et traitement des données - Début
        try {
            //Utilisateurs Enregistrés
            //Utilisateur Moderateur
            UtilisateurModerateur moderateurUn = new UtilisateurModerateur();
            moderateurUn.setNom("Carlos ");
            moderateurUn.setPreNom("Salatti");
            moderateurUn.setId(1234.0);
            moderateurUn.setEmail("csalatti@gmail.com");
            moderateurUn.setAge(29.0);
            moderateurUn.setAdresseRue(" Saint Mathieu ");
            moderateurUn.setAdresseNumero(1055.0);
            moderateurUn.setAdresseVille("Montréal ");
            moderateurUn.setAdressePays("Canada");
            moderateurUn.setLogin("Carlos_Salatti");
            moderateurUn.setMotPasse("admin");
            moderateurUn.setTypePermission("Complete");
            moderateurUn.setTypeCharge("Moderateur");
            moderateurUn.setDateEmbauche(DateUtil.stringToDate("2015-02-02 13:00:02"));
            UtilisateurModerateurCtrl utilisateurUn = new UtilisateurModerateurCtrl();
            // Methodes qui sont pas utilisés
            //utilisateurUn.ecrire(moderateurUn);
            //utilisateurUn.lire();
            //utilisateurUn.ecrireJson(moderateurUn);
            //utilisateurUn.lireJson();
            ArrayList<UtilisateurModerateur> listeDUtilisateurModerateur = new ArrayList<>();
            listeDUtilisateurModerateur.add(moderateurUn);
            utilisateurUn.saveAsJSON(listeDUtilisateurModerateur, "utilisateurModerateur.json");
            System.out.println(utilisateurUn.readFromJSON());

            //Utilisateur Client
            UtilisateurClient clientUn = new UtilisateurClient();
            clientUn.setNom("Ingrid ");
            clientUn.setPreNom("Iucksch");
            clientUn.setId(1233.0);
            clientUn.setEmail("ingrid.eco@gmail.com");
            clientUn.setAge(34.0);
            clientUn.setAdresseRue(" Saint Catherine ");
            clientUn.setAdresseNumero(2000.0);
            clientUn.setAdresseVille("Montréal ");
            clientUn.setAdressePays("Canada");
            clientUn.setLogin("Ingrid_Eco");
            clientUn.setMotPasse("ingrid123");
            clientUn.setTypeClient("Annonceur");
            clientUn.setReputation("Bonne");
            clientUn.setDateInscription(DateUtil.stringToDate("2014-06-02 18:02:00"));
            UtilisateurClientCtrl utilisateurDeux = new UtilisateurClientCtrl();
            // Methodes qui sont pas utilisés
            //utilisateurDeux.ecrire(clientUn);
            //utilisateurDeux.lire();
            //utilisateurDeux.ecrireJson(clientUn);
            //utilisateurDeux.lireJson();
            ArrayList<UtilisateurClient> listeDUtilisateurClient = new ArrayList<>();
            listeDUtilisateurClient.add(clientUn);
            utilisateurDeux.saveAsJSON(listeDUtilisateurClient, "utilisateurClient.json");
            System.out.println(utilisateurDeux.readFromJSON());

            //Annonces Enregistrés
            //Annonce Article de pêche
            AnnonceArticlePeche annonceArticlePeche = new AnnonceArticlePeche();
            annonceArticlePeche.setCategorie("Articles de peche");
            annonceArticlePeche.setTitreAnnonce("Canne a peche");
            annonceArticlePeche.setCategoriePeche("peche a la mouche");
            annonceArticlePeche.setPrix(150.0);
            annonceArticlePeche.setTypeMateriel("Canne");
            annonceArticlePeche.setTypePoisson("Brochet");
            annonceArticlePeche.setDescription("Une nouvelle canne a peche SHIMANO pour la peche du Brochet");
            annonceArticlePeche.setDatePublication(DateUtil.stringToDate("2016-06-28 14:30:15"));
            // Methodes qui sont pas utilisés
            //annonceUn.ecrire(annonceArticlePeche);
            //annonceUn.lire();
            //annonceOn.ecrireJson(annonceArticlePeche);
            //annonceUn.lireJson();
            ArrayList<AnnonceArticlePeche> listeDAnnoncesDePeche = new ArrayList<>();
            listeDAnnoncesDePeche.add(annonceArticlePeche);
            AnnonceArticlePecheCtrl annonceUn = new AnnonceArticlePecheCtrl();
            annonceUn.saveAsJSON(listeDAnnoncesDePeche, "annoncesPeche.json");
            System.out.println(annonceUn.readFromJSON());

            //Annonce Vehicule
            AnnonceVehicule annonceVehicule = new AnnonceVehicule();
            annonceVehicule.setCategorie("Vehicules");
            annonceVehicule.setTitreAnnonce("Honda CIVIC 2010");
            annonceVehicule.setCategorieVehicule("Sedan");
            annonceVehicule.setPrix(10000);
            annonceVehicule.setAnneeVehicule(2010.0);
            annonceVehicule.setCouleur("Rouge");
            annonceVehicule.setKmRoules(123000.0);
            annonceVehicule.setMarque("Honda");
            annonceVehicule.setModele("Civic");
            annonceVehicule.setDescription("Je vends mon Honda Civic 2010, avec tout qu'il faut. Voiture comme neuf");
            annonceVehicule.setDatePublication(DateUtil.stringToDate("2016-06-25 17:31:20"));
            AnnonceVehiculeCtrl annonceDeux = new AnnonceVehiculeCtrl();
            // Methodes qui sont pas utilisés
            //annonceDeux.ecrire(annonceVehicule);
            //annonceDeux.lire();
            //annonceDeux.ecrireJson(annonceVehicule);
            //annonceDeux.lireJson();
            ArrayList<AnnonceVehicule> listeDAnnoncesDeVehicule = new ArrayList<>();
            listeDAnnoncesDeVehicule.add(annonceVehicule);
            annonceDeux.saveAsJSON(listeDAnnoncesDeVehicule, "annoncesVehicule.json");
            System.out.println(annonceDeux.readFromJSON());

            //Annonce Offre d'Employ
            AnnonceOffresEmploy annonceOffresEmploy = new AnnonceOffresEmploy();
            annonceOffresEmploy.setCategorie("Offres d Employ");
            annonceOffresEmploy.setTitreAnnonce("Oportunite pour les informaticiens");
            annonceOffresEmploy.setSalaireOffre(40000);
            annonceOffresEmploy.setTemps("Plein");
            annonceOffresEmploy.setTypeEmploy("Programmeur");
            annonceOffresEmploy.setDescription("oportunite pour les professionels de TI dans pour database manager");
            annonceOffresEmploy.setTempsExperienceRequise(2.0);
            annonceOffresEmploy.setDatePublication(DateUtil.stringToDate("2016-06-30 21:00:00"));
            annonceOffresEmploy.setPrix(0);
            AnnonceOffresEmployCtrl annonceTrois = new AnnonceOffresEmployCtrl();
            // Methodes qui sont pas utilisés
            //annonceTrois.ecrire(annonceOffresEmploy);
            //annonceTrois.lire();
            //annonceTrois.ecrireJson(annonceOffresEmploy);
            //annonceTrois.lireJson();
            ArrayList<AnnonceOffresEmploy> listeDAnnoncesDEmploy = new ArrayList<>();
            listeDAnnoncesDEmploy.add(annonceOffresEmploy);
            annonceTrois.saveAsJSON(listeDAnnoncesDEmploy, "annoncesEmploy.json");
            System.out.println(annonceTrois.readFromJSON());
            // Entrees et traitement des données - Fin

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}