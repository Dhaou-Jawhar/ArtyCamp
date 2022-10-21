/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Objects;



/**
 *
 * @author Ben Nasr
 */
public class Event {
    private int id;
    private String nomEv;
    private String description;
    private String dateDeb;
    private String dateFin;

    public Event() {
    }

    public Event(int id, String nomEv, String description, String dateDeb, String dateFin) {
        this.id = id;
        this.nomEv = nomEv;
        this.description = description;
        this.dateDeb = dateDeb;
        this.dateFin = dateFin;
    }
 
     public Event(String nomEv, String description, String dateDeb, String dateFin) {
        this.nomEv = nomEv;
        this.description = description;
        this.dateDeb = dateDeb;
        this.dateFin = dateFin;
    }
     public Event(int id) {
        this.id = id;
        
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id;
        hash = 59 * hash + Objects.hashCode(this.nomEv);
        hash = 59 * hash + Objects.hashCode(this.description);
        hash = 59 * hash + Objects.hashCode(this.dateDeb);
        hash = 59 * hash + Objects.hashCode(this.dateFin);
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
        final Event other = (Event) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nomEv, other.nomEv)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.dateDeb, other.dateDeb)) {
            return false;
        }
        if (!Objects.equals(this.dateFin, other.dateFin)) {
            return false;
        }
        return true;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNomEv(String nomEv) {
        this.nomEv = nomEv;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateDeb(String dateDeb) {
        this.dateDeb = dateDeb;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public int getId() {
        return id;
    }

    public String getNomEv() {
        return nomEv;
    }

    public String getDescription() {
        return description;
    }

    public String getDateDeb() {
        return dateDeb;
    }

    public String getDateFin() {
        return dateFin;
    }
     
     
     
}
