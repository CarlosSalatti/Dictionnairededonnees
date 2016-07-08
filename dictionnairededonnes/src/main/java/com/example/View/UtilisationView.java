package com.example.View;

import com.example.Utilisateur;

/**
 * Created by eleves on 2016-05-19.
 */
public class UtilisationView
{
    /**
     *
     * @param UserUn
     */
    public void show (Utilisateur UserUn)
    {
        System.out.println(UserUn.getNom());
        System.out.print(UserUn.getPreNom());
        System.out.println(UserUn.getId());
        System.out.println(UserUn.getEmail());
        System.out.println(UserUn.getAge());
        System.out.println(UserUn.getAdresseNumero());
        System.out.println(UserUn.getAdresseRue());
        System.out.println(UserUn.getAdresseVille());
        System.out.println(UserUn.getAdressePays());
    }
}
