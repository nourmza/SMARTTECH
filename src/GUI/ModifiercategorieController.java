/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import esprit.enities.Category;
import esprit.services.CategoryService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author mznou
 */
public class ModifiercategorieController implements Initializable {
private ListView<Category> affichercategorie;
    @FXML
    private TextField fx_nom;
    @FXML
    private TextArea fx_description;
    @FXML
    private Button modifier;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         fx_nom.setText(AffichercategorieController.NomCategorie);
         fx_description.setText(AffichercategorieController.DescriptionCategorie);
         
    }    

    @FXML
    private void modifier(ActionEvent event) {
        
        CategoryService inter = new CategoryService();
        String NomCategorie = fx_nom.getText();        
        String DescriptionCategorie = fx_description.getText();
        
     
        Category A = new Category(AffichercategorieController.IdCategorie,NomCategorie,DescriptionCategorie);
                
        inter.modifier(A);
    }
    
}
