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

    @Override
    public String toString() {
        return "Job{" + "id=" + id + ", type=" + type + ", metierOuProduit=" + metierOuProduit + ", description=" + description + ", photos=" + photos + '}';
    }

    public Job(int id, String type, String metierOuProduit, String description, String photos) {
        this.id = id;
        this.type = type;
        this.metierOuProduit = metierOuProduit;
        this.description = description;
        this.photos = photos;
    }
    public Job( String type, String metierOuProduit, String description, String photos) {
        
        this.type = type;
        this.metierOuProduit = metierOuProduit;
        this.description = description;
        this.photos = photos;
    }
    private int id;
    private String type;
    private String metierOuProduit;
    private String description;
    private String photos;
    //private Category cat;

    public void setID(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}

    
