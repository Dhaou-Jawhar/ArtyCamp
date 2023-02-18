/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arty_main;

import Arty.entities.ArtCategory;
import Arty.entities.ArtVIP;
import Arty.entities.Avis;
import Arty.services.GestionArtVIP;
import Arty.services.GestionAvis;
import Arty.services.GestionCategory;
import Arty_DB.MyConnection;


/**
 *
 * @author Dhaou Jawher
 */
public class Arty_main {
    public static void main(String[] args) {
        // TODO code application logic here
        MyConnection mc = new MyConnection();
        GestionAvis a = new GestionAvis();
        GestionArtVIP v = new GestionArtVIP();
        GestionCategory ct = new GestionCategory();
        
        
       // System.out.println(v.getOne(2));
        //System.out.println(v.GetAll());
        
        
        
      //  ArtVIP v1 = new ArtVIP("Space","Space Peace","E124");
      //  v1.setIdCategory(14);
        
      //  ArtCategory cat = new ArtCategory("NFT","NFT Logo");
      //  ct.ajouter(cat);      
        
    }
    
}
