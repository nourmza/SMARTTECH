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
public class Job {

    public Job() {
        
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Job{" + "id=" + id + ", type=" + type + ", metierOuProduit=" + metierOuProduit + ", description=" + description + ", photos=" + photos + ", NomCategorie=" + NomCategorie + '}';
    }


  

    public void setType(String type) {
        this.type = type;
    }

    public String getMetierOuProduit() {
        return metierOuProduit;
    }

    public void setMetierOuProduit(String metierOuProduit) {
        this.metierOuProduit = metierOuProduit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public String getNomCategorie() {
        return NomCategorie;
    }

    public void setNomCategorie(String NomCategorie) {
        this.NomCategorie = NomCategorie;
    }
/*
    public Job( String type, String metierOuProduit, String description, String photos, int id,String NomCategorie) {
        this.id = id;
        this.type = type;
        this.metierOuProduit = metierOuProduit;
        this.description = description;
        this.photos = photos;
        this.NomCategorie = NomCategorie;
    }*/

    public Job(int id, String type, String metierOuProduit, String description, String photos, String NomCategorie) {
        this.id = id;
        this.type = type;
        this.metierOuProduit = metierOuProduit;
        this.description = description;
        this.photos = photos;
        this.NomCategorie = NomCategorie;
    }

    public Job(String type, String metierOuProduit, String description, String photos, String NomCategorie) {
        this.type = type;
        this.metierOuProduit = metierOuProduit;
        this.description = description;
        this.photos = photos;
        this.NomCategorie = NomCategorie;
    }

 
  


    
    private int id;
    private String type;
    private String metierOuProduit;
    private String description;
    private String photos;
    private String NomCategorie;

  

 

}

    