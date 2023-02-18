/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arty.entities;

/**
 *
 * @author Dhaou Jawher
 */
public class Avis {
    private int avis_id;
    private String Avis_Type;
     private ArtCategory category;

public Avis(){}

    public Avis(int avis_id, String avis_Type) {
        this.avis_id = avis_id;
        this.Avis_Type = avis_Type;
    }

    public Avis(String avis_Type) {
        this.Avis_Type = avis_Type;
    }

    public void setAvis_id(int avis_id) {
        this.avis_id = avis_id;
    }

    public void setAvis_Type(String avis_Type) {
        this.Avis_Type = avis_Type;
    }

    public int getAvis_id() {
        return avis_id;
    }

    public String getAvis_Type() {
        return Avis_Type;
    }

    @Override
    public String toString() {
        return "Avis{" + "avis_id=" + avis_id + ", Type=" + Avis_Type + '}';
    }
}