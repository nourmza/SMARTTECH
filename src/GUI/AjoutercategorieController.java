/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import esprit.enities.Category;
import esprit.services.CategoryService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

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
    @FXML
    private ImageView btnReturn;
    @FXML
    private AnchorPane nh;

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
            (DescriptionCategorie.length()==0)
       
       
   {Alert alert = new Alert(Alert.AlertType.INFORMATION);
   alert.setTitle("information Dialog");
   alert.setHeaderText(null);
   
   alert.setContentText("erreur donner une DescriptionCategorie");
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

    @FXML
    private void returnTo(MouseEvent event) {
        
                 FXMLLoader loader = new FXMLLoader(getClass().getResource("crud_category.fxml"));
        try {
            Parent root = loader.load();
            nh.getChildren().setAll(root);

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
   
    }
    

