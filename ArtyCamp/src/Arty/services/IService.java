/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arty.services;

import java.util.List;

/**
 *
 * @author Dhaou Jawher
 */
public interface IService<Art> {
    
   public void ajouter(Art a);
   public void supprimer(int NFT_id);
   public void modifier(Art a, int NFT_id);
   public List<Art> afficher();
   public Art getOne(int artID);
   public List<Art> getAll();   
}