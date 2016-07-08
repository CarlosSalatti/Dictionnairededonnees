package com.example.View;

import com.example.Annonce;

/**
 * Created by eleves on 2016-05-19.
 */
public class AnnonceView {

    public void show (Annonce AnnonceUn)
    {
        System.out.println(AnnonceUn.getTitreAnnonce());
        System.out.println(AnnonceUn.getDescription());
        System.out.println(AnnonceUn.getDatePublication());
        System.out.println(AnnonceUn.getPrix());
       // System.out.println(AnnonceUn.getImgAnn());
    }
}
