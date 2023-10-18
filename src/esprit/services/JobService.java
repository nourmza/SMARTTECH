
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.services;

/**
 *
 * @author Lenovo
 */

import esprit.enities.Job;
import esprit.tools.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import esprit.tools.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class JobService {

 Connection cnx=DataSource.getInstance().getConnection();
   ObservableList<Job>obListCat = FXCollections.observableArrayList();
ObservableList<Job>obList = FXCollections.observableArrayList();

        
  public void ajouterJob(Job J) {
        String req = "INSERT INTO `job`(`type`, `metierOuproduit`, `description`, `photos`,`IdCategorie`) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);

            ps.setString(1, J.getType());
            ps.setString(2, J.getMetierOuProduit());
             ps.setString(3, J.getDescription());
              ps.setString(4, J.getPhotos());
               ps.setInt(5, J.getIdCategorie());

            ps.executeUpdate();
            System.out.println("job ajoutée avec succès!");
        } catch (SQLException ex) {
            Logger.getLogger(JobService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   public void supprimerJob( Job J ) {
                try {
            String req = "DELETE FROM `job` WHERE ID=+id";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
            System.out.println("job supprimer avec succés");
             } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
   
   
     public void supprimerJob2( int id ) {
        try {
            String req = "DELETE FROM `job` WHERE id=?";
            PreparedStatement st = cnx.prepareStatement(req);
            st.setInt(1, id);
            st.executeUpdate();
            System.out.println("Job supprimer avec succès");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
     }
   public void modifier(Job J) {
    try {
        String req = "UPDATE `job` SET `type`=?, `metierOuproduit`=?, `description`=?, `photos`=?, `IdCategorie`=? WHERE id=?";
        PreparedStatement st = cnx.prepareStatement(req);

        st.setString(1, J.getType());
        st.setString(2, J.getMetierOuProduit());
        st.setString(3, J.getDescription());
        st.setString(4, J.getPhotos());
        st.setInt(5, J.getIdCategorie());
        st.setInt(6, J.getId());

        int rowsAffected = st.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Job Modifié avec succès");
        } else {
            System.out.println("Aucune modification effectuée pour le Job avec l'ID " + J.getId());
        }
    } catch (SQLException ex) {
        // Gérez l'exception en fonction de vos besoins, par exemple, en imprimant la trace de l'exception.
        ex.printStackTrace();
    }
}

   public List<Job> afficher(){
        List<Job> job  = new ArrayList<>();
         //1
         String req = "SELECT * FROM job ";
        try {
            //2
            Statement st = cnx.createStatement();
            //3
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Job E = new Job ();
                E.setType(rs.getString("Type"));
                E.setMetierOuProduit(rs.getString("MetierOuProduit"));
                E.setDescription(rs.getString("Description"));
                E.setPhotos(rs.getString("Photos"));
            
              
                
                E.setId(rs.getInt("Id"));
                                E.setIdCategorie(rs.getInt("IdCategorie"));

                 
                
                job.add(E);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(JobService.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         return job ;
    }

    public List<Job> afficherjob(){
        List<Job> job = new ArrayList<>();
         //1
         String req = "SELECT * FROM job";
        try {
            //2
            Statement st = cnx.createStatement();
            //3
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Job E = new Job ();
                E.setType(rs.getString("Type"));
                E.setMetierOuProduit(rs.getString("MetierOuProduit"));
                E.setDescription(rs.getString("Description"));
                E.setPhotos(rs.getString("Photos"));
            
              
                
                E.setId(rs.getInt("Id"));
                E.setIdCategorie(rs.getInt("IdCategorie"));

                job.add(E);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CategoryService.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         return job ;
    }
    /*
    
    public ObservableList<Category> afficherCategory2() {
        String sql = "SELECT * FROM category";
        List<Category> listeCatg = new ArrayList<>();

        try {
            Statement statement = cnx.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                int IdCategorie = result.getInt(1);
                String DescriptionCategorie = result.getString(2);
                String NomCategorie=result.getString(3);
                Category c = new Category(IdCategorie, DescriptionCategorie,NomCategorie);
                obList.add(c);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return obList;
    }
*/
    
   
   /*
   public ObservableList<Job> afficherJob2() {
        String sql = "SELECT * FROM job";
        List<Job> listeJob = new ArrayList<>();

        try {
            Statement statement = cnx.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                int id = result.getInt(1);
                String type = result.getString(2);
                String metierOuProduit = result.getString(3);
                String description =  result.getString(4);
                String photos = result.getString(5);
                int IdCategorie = result.getInt(6);

                Job s = new Job(id, type, metierOuProduit, description, photos, IdCategorie);
                obList.add(s);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return obList;
    }
   
   */
   
   public boolean getArticle(Job s) {
        try {
            PreparedStatement ps;
            ps = cnx.prepareStatement("SELECT * FROM Job WHERE id = ?");
            ps.setString(1, s.getDescription());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                //System.out.println(rs.getString("ServLib"));
                return true; 
            } else {
                return false;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return false;
   }

   //jointure
    public ObservableList<Job> getJobByCategorie() {
        String sql ="select * from job J"
                + "JOIN Category C ON C.IdCategorie=J.IdCategorie";
        List<Job> listeJob = new ArrayList<>();

        try {
            Statement statement = cnx.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                int id = result.getInt(1);
                String type = result.getString(2);
                String metierOuProduit = result.getString(3);
                String description = result.getString(4);
                String photos = result.getString(5);
                int IdCategorie= result.getInt(6);

                Job s = new Job(type, metierOuProduit, description, photos, id,IdCategorie);
                obListCat.add(s);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return obListCat;
    }
}

    
            
   
            

 
 
 
 
 
 
 
 
 
 
 
         // public void ajouterjob (Job j){
       
        
           // try {
            //String req = "INSERT INTO `Job`( `type`,`metierOuproduit','description','photos') VALUES ('"+j.getType()+"','"+j.getMetierOuProduit()+"','"+j.getDescription()+"','"+j.getPhotos()+"')";
              //      Statement st = cnx.createStatement();
            
          
          //  st.executeUpdate(req);
            //System.out.println("Job added successfully");
            //}
            //catch (SQLException ex) {
           //System.out.println("failed!"); 
       // }

   
        
        
        
        