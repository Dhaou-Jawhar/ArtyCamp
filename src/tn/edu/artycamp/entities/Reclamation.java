/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.artycamp.entities;

import java.sql.Date;
import java.time.LocalDate;
import javafx.scene.control.DatePicker;
//import java.util.Objects;


/**
 *
 * @author user
 */
public class Reclamation {
    private int id;
    private Date date;
    private String msg;
    private String object;
    private User user;
    private int idU;
    public Reclamation(String rIdu, String rMessage, String rObject, String rDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Reclamation(String Date, String Msg, String Object, int intidU) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Reclamation(LocalDate rdate, String Msg, String Object, int intidU) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Reclamation(int idrec, int iduserec, String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*public Reclamation(int i, int parseInt, int i0, String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

    public Reclamation(String text, int iduserec, String text0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Reclamation(int id, String msg, String object, int idU) {
        this.id = id;
        this.msg = msg;
        this.object = object;
        this.idU = idU;
    }

    public Reclamation(String msg, String object, int idU) {
        this.msg = msg;
        this.object = object;
        this.idU = idU;
    }

    

    public int getIdU() {
        return idU;
    }

    public void setIdU(int idU) {
        this.idU = idU;
    }
   
    public Reclamation() {
    }
/* public void ajouterUser(Utilisateur u ){
        this.user = u;
    }*/
    public Reclamation(int id, Date date, String msg, String object, User user) {
        this.id = id;
        this.date = date;
        this.msg = msg;
        this.object = object;
        this.user = user;
    }

    public Reclamation(int id, String object, int idU) {
        this.id = id;
        this.object = object;
        this.idU = idU;
    }

    public Reclamation(int id, Date date, String msg, String object, int idU) {
        this.id = id;
        this.date = date;
        this.msg = msg;
        this.object = object;
        this.idU = idU;
    }

    public Reclamation(Date date, String msg, String object, User user) {
        this.date = date;
        this.msg = msg;
        this.object = object;
        this.user = user;
    }

    public Reclamation(Date date, String msg, String object, int idU) {
        this.date = date;
        this.msg = msg;
        this.object = object;
        this.idU = idU;
    }

    public Reclamation(String msg, String object, User user) {
        this.msg = msg;
        this.object = object;
        this.user = user;
    }

    public Reclamation(String msg, String object) {
        this.msg = msg;
        this.object = object;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getMsg() {
        return msg;
    }

    public String getObject() {
        return object;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "id=" + id + ", date=" + date + ", msg=" + msg + ", object=" + object + ",  idU=" + idU + '}';
    }

   
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reclamation other = (Reclamation) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public void setDate(DatePicker idagenda) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

   
}
