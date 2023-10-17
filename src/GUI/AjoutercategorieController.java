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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author mznou
 */
public class AjoutercategorieController implements Initializable {

    @FXML
    private TextField fx_nom;
    @FXML
    private TextArea fx_description;
    @FXML
    private Button ajouter;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouter(ActionEvent event) {
        
  

   String NomCategorie=fx_nom.getText();
   
   String DescriptionCategorie=fx_description.getText();
   
   
   
   
   if (NomCategorie.length()==0)
       
       
   {Alert alert = new Alert(Alert.AlertType.INFORMATION);
   alert.setTitle("information Dialog");
   alert.setHeaderText(null);
   
   alert.setContentText("erreur donner une nom categorie");
   alert.show();
   } else if 
            (NomCategorie.length()==0)
       
       
   {Alert alert = new Alert(Alert.AlertType.INFORMATION);
   alert.setTitle("information Dialog");
   alert.setHeaderText(null);
   
   alert.setContentText("erreur donner une nom categorie");
   alert.show();
   }
   else 
   {
           Category C = new Category (NomCategorie,DescriptionCategorie);
           CategoryService c1 = new CategoryService();
           c1.ajouterCategory(C);
           Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
           alert .setTitle("information dialog");
           alert.setHeaderText(null);
           alert.setContentText("Categorie insérer avec succes !");
           alert.show();
           }
   
   }
   
    }
    

