/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.artycamp.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author user
 */
public class DataSource {
    static DataSource instance;
   public String url="jdbc:mysql://remotemysql.com:3306/tcPmjQHMA8";
    public String user="tcPmjQHMA8";
    public String password="cHyEAAZjdg";
   /* private String url = "jdbc:mysql://localhost:3306/artycamp";
    private String user = "root";
    private String password = "";*/
  /*
            
  */
    static Connection cnx;
    static Statement st;
    public DataSource(){
         try{
         cnx = DriverManager.getConnection(url, user, password);
         System.out.println("Connected !");
     }catch(SQLException ex){
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
        return cnx;
}
}