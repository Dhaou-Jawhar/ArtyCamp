/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.artycamp.services;

import java.sql.SQLException;
import java.util.List;
import tn.edu.artycamp.entities.Reclamation;


/**
 *
 * @author user
 * @param <T>
 */
public interface IService <T>{
    public void ajouter(T ra)throws SQLException;
    public void supprimer(int id);
    public void modifier(T ra);
    public List<T> getAll();
    public T getOne(T id);
    //List<Reclamation> rechercheReclamationParUser(int iduser);
    //public void ajouterk(T rv);
}
