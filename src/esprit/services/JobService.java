
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


public class JobService {

 Connection cnx=DataSource.getInstance().getConnection();
   
        
  public void ajouterJob(Job J) {
        String req = "INSERT INTO `job`(`type`, `metierOuproduit`, `description`, `photos`) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);

            ps.setString(1, J.getType());
            ps.setString(2, J.getMetierOuProduit());
             ps.setString(3, J.getDescription());
              ps.setString(4, J.getPhotos());
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
   public void modifier(Job J) {

        try {
            String req = "UPDATE `job` SET `type`=?,`metierOuproduit`=?,`description`=?,`photos`=? WHERE id=?";
            PreparedStatement st = cnx.prepareStatement(req);

            st.setString(1, J.getType());
            st.setString(2, J.getMetierOuProduit());
            st.setString(3, J.getDescription());
            st.setString(4, J.getPhotos());
            st.setInt(5, J.getId());
            st.executeUpdate();
            System.out.println("Job Modifié avec succès");
        } catch (SQLException ex) {
            System.out.println(ex);
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
                
                 
                
                job.add(E);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(JobService.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         return job ;
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

   
        
        
        
        