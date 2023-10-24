/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



package esprit.services;

import Interface.ICategorie;
import esprit.enities.Category;
import esprit.tools.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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


/**
 *
 * @author Lenovo
 */
public class CategoryService  implements ICategorie {
    
Connection cnx=DataSource.getInstance().getConnection();
    
    ObservableList<Category>obList = FXCollections.observableArrayList();

  
    public String ajouterCategory (Category C){
        
        
            try {
            String req = "INSERT INTO `Category`( `DescriptionCategorie` , `NomCategorie`) VALUES ('"+C.getDescriptionCategorie()+"','"+C.getNomCategorie()+"')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Category Added successfully!");
            }
            catch (SQLException ex) {
           System.out.println("failed!"); 
        }
return C.getNomCategorie();
           }
    
    
    
    public void modifier(Category C) {

        try {
            String req = "UPDATE `Category` SET `NomCategorie`=? ,`DescriptionCategorie`=? WHERE IdCategorie=?";
            PreparedStatement st = cnx.prepareStatement(req);

            st.setString(2, C.getDescriptionCategorie());
            st.setString(1, C.getNomCategorie());
        
            st.setInt(3, C.getIdCategorie());
            st.executeUpdate();
            System.out.println("Categorie Modifié avec succès");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    public void supprimer_category( int IdCategorie) {
        try {
            String req = "DELETE FROM `category` WHERE IdCategorie=?";
            PreparedStatement st = cnx.prepareStatement(req);
            st.setInt(1, IdCategorie);
            st.executeUpdate();
            System.out.println("categorie supprimer avec succès");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    public List<Category> afficher(){
        List<Category> categorie = new ArrayList<>();
         //1
         String req = "SELECT * FROM category";
        try {
            //2
            Statement st = cnx.createStatement();
            //3
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Category E = new Category ();
                                E.setIdCategorie(rs.getInt("IdCategorie"));

                                 E.setNomCategorie(rs.getString("NomCategorie"));

                E.setDescriptionCategorie(rs.getString("DescriptionCategorie"));
            
              
                
                
                 
                
                categorie.add(E);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CategoryService.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         return categorie ;
    }
    
    
    public ObservableList<Category> afficherCategory2() {
        String sql = "SELECT * FROM category";
        List<Category> listeCatg = new ArrayList<>();

        try {
            Statement statement = cnx.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                int IdCategorie = result.getInt(1);
                String DescriptionCategorie = result.getString(3);
                String NomCategorie=result.getString(2);
                Category c = new Category(IdCategorie,NomCategorie,DescriptionCategorie);
                obList.add(c);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return obList;
    }
public ObservableList<String> fetchAllCategoryNames() {
    ObservableList<String> categoryNames = FXCollections.observableArrayList();
    String query = "SELECT DISTINCT NomCategorie FROM category";
    try {
        Statement st = cnx.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            categoryNames.add(rs.getString("NomCategorie"));
        }
    } catch (SQLException ex) {
        Logger.getLogger(CategoryService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return categoryNames;
}

    
    public boolean getCategorie(Category c) {
        try {
            PreparedStatement ps;
            ps = cnx.prepareStatement("SELECT * FROM category WHERE NomCategorie = ?");
            ps.setString(1, c.getNomCategorie());
            ps.setString(2,c.getDescriptionCategorie());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println(rs.getString("NomCategorie"));
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return false;
    }

    
       public int nbvente(Category p){
          int id=p.getIdCategorie();
     int x = 0;
     int  v= 0;
     
           try{
               
             String req = "SELECT COUNT(*) as nbr FROM `category` where IdCategorie ='" + id + "'";
     
               Statement ste = cnx.createStatement();
              ResultSet rs=ste.executeQuery(req);
              while (rs.next())
              {v=rs.getInt("nbr");
 }
                       
     }catch(SQLException ex) {
            System.out.println("erreur");
                    }

   return v;
   


}
            public ObservableList<Category> likeByCategory(String a) {
     
        ObservableList<Category> listData = FXCollections.observableArrayList();
        try {
            String sql = "select * from category where idCategorie like '%"+a+"%' or NomCategorie like '%"+a+"%'   ";
            ResultSet rs = cnx.createStatement().executeQuery(sql);
            while (rs.next()) {  
                Category u = new Category();
                
               u.setIdCategorie(rs.getInt("idCategorie"));  
      u.setNomCategorie(rs.getString("NomCategorie"));
   
      
       
        
                listData.add(u);
            }
        } catch (Exception ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listData;
    }
     


}


       

   
   

    







          
   
    