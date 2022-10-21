/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.artycamp.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author msi
 */
public class DataSource {
      private Connection cnx;
    private static DataSource instance;
    
    // **********   remode  ***************
    /* 
    public String url="jdbc:mysql://remotemysql.com:3306/tcPmjQHMA8";
    public String login="tcPmjQHMA8";
    public String pwd="cHyEAAZjdg";
    */
    private String url = "jdbc:mysql://localhost:3306/artycamp_bd";
    private String user = "root";
    private String password = "";
    
    public DataSource(){
        try {
            cnx = DriverManager.getConnection(url, user, password);
            System.out.println("connected to DB !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static DataSource getInstance(){
        if(instance == null){
            instance = new DataSource();
        }
        return instance;
    }
    
    public Connection getConnection(){
        return this.cnx;
    }
}
