/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.entities;

/**
 *
 * @author Islem
 */
public class User {
     private int id;
    private String nom;
    private String prenom;
    private String username;
    private String role;
    private String pw;
    
    public User(){
        
    }

    public User(int id) {
        this.id = id;
    }

    public User(int id, String nom, String prenom, String username,String role ,String pw) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.role=role;
        this.pw = pw;
    }

    public User(String nom, String prenom, String username,String role,String pw) {
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.role=role;
        this.pw = pw;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "user{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", username=" + username + ",role=" + role + ", pw=" + pw + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
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
        final User other = (User) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
  
    
}

    

