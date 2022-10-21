/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arty_DB;

//cette classe on l'utiliser pour Get Connection 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dhaou Jawher
 */
public class MyConnection {

    
    public String url="jdbc:mysql://localhost:3306/test";
    public String login="root";
    public String pwd="";
    static Connection cnx;
    static Statement st;
    static MyConnection instance ;
    
    public MyConnection(){
        try {
            cnx = DriverManager.getConnection(url, login, pwd);
            System.out.println("Connection avec Succeé!");
        } catch (SQLException ex) {
            //message d'erreur en rouge
            System.err.println(ex.getMessage());
        }
    }
    
    //pour utiliser lobjet statement
    public Connection getCnx(){
        return cnx;
    }
    
    public static MyConnection getInstance () 
    {
        if (instance == null){
            instance = new MyConnection () ;
        }  
        return instance ;
    } 
}