/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artycampJDBC;

/**
 *
 * @author msi
 */
import java.sql.SQLException;
import tn.edu.artycamp.Services.ServiceArticleArtiste;
import tn.edu.artycamp.entities.ArticleArtiste;
import tn.edu.artycamp.entities.AvisArticle;
import tn.edu.artycamp.entities.CategorieArticles;
import tn.edu.artycamp.services.ServiceAvisArticle;
import tn.edu.artycamp.services.ServiceCategorieArticles;
import tn.edu.artycamp.tools.DataSource;

public class Main {

    public static void main(String[] args) throws SQLException {
        DataSource.getInstance();
        ServiceArticleArtiste pcd = new ServiceArticleArtiste();
        ServiceAvisArticle rs = new ServiceAvisArticle();
        ServiceCategorieArticles es = new ServiceCategorieArticles();

        /**
         * *** test methode ajouter Article    ****
         */
        /* ArticleArtiste t = new ArticleArtiste(2,"cv","sEZ","VZA");
        pcd.ajouter(t); */
        //idCategorie,nomA,discriptionA,imageh
        /**
         * *** test methode afficher Article    ****
         */
        //System.out.println(pcd.AfficherArticles());
        /**
         * *** test methode supprimer Article    ****
         */
        //pcd.supprimer(1);
        /**
         * *** test methode Modifier Article    ****
         */
        /* ArticleArtiste t = new ArticleArtiste("ZiZO","ZAZA",223);
         pcd.modifier(t,2); */
        /**
         * *** test methode SearchById ArticleArtiste    ****
         */
        //System.out.println(pcd.SearchById(3));
        /*  -------------------------------------------------------------------------- */
        /**
         * ********** Ajouter AvisArticle   *********
         */
        /* AvisArticle t = new AvisArticle(5,"Trés Bien");
         rs.ajouter(t);*/
        /**
         * ********** Supprimer AvisArticle   *********
         */
        //rs.supprimer(2);
        /**
         * *** test methode Modifier AvisArticle   ****
         */
        /* AvisArticle t = new AvisArticle(9,"Assez bien");
         rs.modifier(t,1);
         */
        /**
         * *** test methode afficher AvisArticle    ****
         */
        //System.out.println(rs.AfficherAvis());
        /**
         * *** test methode SearchById AvisArticle    ****
         */
        // System.out.println(rs.SearchById(1));
        
        /* ------------------------------------------------------------------------------  */
        
        /**
         * ********** test Ajouter CategorieArticle   *********
         */
        /* CategorieArticles t = new CategorieArticles("teinte","joo");
         es.ajouter(t);*/
      
        /**
         * *** test methode afficher CategorieArticle    ****
         */
        //System.out.println(es.AfficherCategorie());
        
        /**
         * ********** Supprimer Categorie Article   *********
         */
        //es.supprimer(3);
        
        /* *** test methode Modifier Categorie Article   ****
         */
        // CategorieArticles t = new CategorieArticles("design","Tito");
         //es.modifier(t,2);
         
         /* *** test methode SearchById CategorieArticles    ****
         */
         //System.out.println(es.SearchById(1));
        

    }
}
