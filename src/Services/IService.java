/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.util.List;
import java.util.Observable;
import javafx.collections.ObservableList;

/**
 *
 * @author Ben Nasr
 
 */
public interface IService<T> {
    public void ajouter(T t);
    public void modifier(T t);
    public void supprimer(T t);
    public T getOne(int id);
    public ObservableList<T> getAll();
    
}
