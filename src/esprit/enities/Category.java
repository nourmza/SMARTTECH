/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.enities;

/**
 *
 * @author Lenovo
 */
public class Category {

    public String getDescriptionCategorie;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.IdCategorie;
        return hash;
    }

   

    
        
   private int IdCategorie;
   private String NomCategorie;
   private String DescriptionCategorie;

    public Category(String NomCategorie, String DescriptionCategorie) {
        this.NomCategorie = NomCategorie;
        this.DescriptionCategorie = DescriptionCategorie;
    }
     public Category(String NomCategorie, String DescriptionCategorie , int IdCategorie) {
       this.NomCategorie = NomCategorie;
        this.DescriptionCategorie = DescriptionCategorie;
        this.IdCategorie = IdCategorie;
     }


    @Override
    public String toString() {
        return "Category{" + "IdCategorie=" + IdCategorie + ", NomCategorie=" + NomCategorie + ", DescriptionCategorie=" + DescriptionCategorie + '}';
    }

    public void setIdCategorie(int IdCategorie) {
        this.IdCategorie = IdCategorie;
    }

    public void setNomCategorie(String NomCategorie) {
        this.NomCategorie = NomCategorie;
    }

    public void setDescriptionCategorie(String DescriptionCategorie) {
        this.DescriptionCategorie = DescriptionCategorie;
    }

    public int getIdCategorie() {
        return IdCategorie;
    }

    public String getNomCategorie() {
        return NomCategorie;
    }

    public String getDescriptionCategorie() {
        return DescriptionCategorie;
    }

    public Category() {
    }
    

    

}