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
    private User expediteur;
    private User recepteur;
    private String msg;
    private String Nomex;
    private String Nomrec;
    private boolean vu;
    private int idU;
    private int idex;
    private int idrec;

    public Messagerie() {
    }

    public Messagerie(String msg) {
        this.msg = msg;
    }

    public Messagerie(int idmsg, User expediteur, User recepteur, String msg, boolean vu, int idU, int idex, int idrec) {
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

    public Messagerie(String msg, boolean vu, int idU, int idex, int idrec) {
        this.msg = msg;
        this.vu = vu;
        this.idU = idU;
        this.idex = idex;
        this.idrec = idrec;
    }

   public Messagerie(String msg, String Nomex, String Nomrec, boolean vu) {
        this.msg = msg;
        this.Nomex = Nomex;
        this.Nomrec = Nomrec;
        this.vu = vu;
    }

    public String getNomex() {
        return Nomex;
    }

    public void setNomex(String Nomex) {
        this.Nomex = Nomex;
    }

    public String getNomrec() {
        return Nomrec;
    }

    public void setNomrec(String Nomrec) {
        this.Nomrec = Nomrec;
    }
    public Messagerie(String msg, boolean vu) {
        this.msg = msg;
        this.vu = vu;
    }

    public Messagerie(int i, String hsdksk, int i0, int i1, int i2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Messagerie(String hsdksk, int i, int i0, int i1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public User getExpediteur() {
        return expediteur;
    }

    public void setExpediteur(User expediteur) {
        this.expediteur = expediteur;
    }

    public User getRecepteur() {
        return recepteur;
    }
    public void setRecepteur(User recepteur) {
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

    @Override
    public String toString() {
        return "Messagerie{" + "idmsg=" + idmsg + ", msg=" + msg + ", vu=" + vu + ", idU=" + idU + ", idex=" + idex + ", idrec=" + idrec + '}';
    }
    
    
    
}
