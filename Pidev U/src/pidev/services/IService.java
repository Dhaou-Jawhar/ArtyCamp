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
public interface IService<T> {
    public void ajouteru(T t);
    public void modifieru(T t, int id);
    public void supprimeru(int id);
    public T getOneu(int id) ;
    public List<T> getAllu();
    
}
