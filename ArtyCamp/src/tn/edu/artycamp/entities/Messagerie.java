/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.artycamp.entities;

import java.sql.Date;

/**
 *
 * @author user
 */
public class Messagerie {
    private int idmsg;
    private Utilisateur expediteur;
    private Utilisateur recepteur;
    private String msg;
    private boolean vu;
    private int idU;
    private int idex;
    private int idrec;

    public Messagerie() {
    }

    public Messagerie(String msg) {
        this.msg = msg;
    }

    public Messagerie(int idmsg, Utilisateur expediteur, Utilisateur recepteur, String msg, boolean vu, int idU, int idex, int idrec) {
        this.idmsg = idmsg;
        this.expediteur = expediteur;
        this.recepteur = recepteur;
        this.msg = msg;
        this.vu = vu;
        this.idU = idU;
        this.idex = idex;
        this.idrec = idrec;
    }

    public Messagerie(int idmsg, String msg, boolean vu, int idex, int idrec) {
        this.idmsg = idmsg;
        this.msg = msg;
        this.vu = vu;
        this.idex = idex;
        this.idrec = idrec;
    }

    public Messagerie(int idmsg, String msg, boolean vu, int idU, int idex, int idrec) {
        this.idmsg = idmsg;
        this.msg = msg;
        this.vu = vu;
        this.idU = idU;
        this.idex = idex;
        this.idrec = idrec;
    }

    public Messagerie(String msg, boolean vu) {
        this.msg = msg;
        this.vu = vu;
    }

    public Utilisateur getExpediteur() {
        return expediteur;
    }

    public void setExpediteur(Utilisateur expediteur) {
        this.expediteur = expediteur;
    }

    public Utilisateur getRecepteur() {
        return recepteur;
    }

    public void setRecepteur(Utilisateur recepteur) {
        this.recepteur = recepteur;
    }

    public int getIdU() {
        return idU;
    }

    public void setIdU(int idU) {
        this.idU = idU;
    }

    public int getIdex() {
        return idex;
    }

    public void setIdex(int idex) {
        this.idex = idex;
    }

    public int getIdrec() {
        return idrec;
    }

    public void setIdrec(int idrec) {
        this.idrec = idrec;
    }

    public int getIdmsg() {
        return idmsg;
    }

    public String getMsg() {
        return msg;
    }

    public boolean isVu() {
        return vu;
    }

    public void setIdmsg(int idmsg) {
        this.idmsg = idmsg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setVu(boolean vu) {
        this.vu = vu;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.idmsg;
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
        final Messagerie other = (Messagerie) obj;
        if (this.idmsg != other.idmsg) {
            return false;
        }
        return true;
    }

    /*@Override
    public String toString() {
        return "Messagerie{" + "idmsg=" + idmsg + ", msg=" + msg + ", vu=" + vu + '}';
    }*/

    @Override
    public String toString() {
        return "Messagerie{" + "idmsg=" + idmsg + ", expediteur=" + expediteur + ", recepteur=" + recepteur + ", msg=" + msg + ", vu=" + vu + ", idU=" + idU + ", idex=" + idex + ", idrec=" + idrec + '}';
    }
    
    
    
}
