/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.services;

import java.util.List;

/**
 *
 * @author Islem
 */
public interface Imoderateur<M> {
    public void ajouter(M m);
    public void modifier(M m);
    public void supprimer(int id);
    public M getOne(int id) ;
    public List<M> getAll();
    
}
