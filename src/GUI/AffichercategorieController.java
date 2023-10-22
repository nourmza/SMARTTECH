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
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mznou
 */
public class AffichercategorieController implements Initializable {

    @FXML
    private ListView<Category> affichercategorie;


    
     static int IdCategorie;
   static String NomCategorie;
   static String DescriptionCategorie;
    @FXML
    private Button supprimer;
    @FXML
    private Button mod;
    @FXML
    private AnchorPane nh;
    @FXML
    private ImageView btnReturn;
    
  
    


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
ListView<Category> list1= affichercategorie;
        CategoryService inter = new CategoryService();
        List<Category> list2 = inter.afficher();
        for (int i = 0; i < list2.size(); i++) {
            Category C = list2.get(i);
            list1.getItems().add(C);

        }   }     

    @FXML
    private void supprimercategorie(ActionEvent event) {
 
ListView<Category> list1 = affichercategorie;
CategoryService inter = new CategoryService();
int selectedIndex = list1.getSelectionModel().getSelectedIndex();

if (selectedIndex >= 0) {
    Category A = list1.getSelectionModel().getSelectedItem();
    System.out.println(A.getIdCategorie());

    // Créez une boîte de dialogue de confirmation
    Alert confirmationAlert = new Alert(AlertType.CONFIRMATION);
    confirmationAlert.setTitle("Confirmation de la suppression");
    confirmationAlert.setHeaderText("Êtes-vous sûr de vouloir supprimer cette catégorie ?");

    // Ajoutez des boutons Oui et Non à la boîte de dialogue
    confirmationAlert.getButtonTypes().setAll(ButtonType.YES, ButtonType.NO);

    // Affichez la boîte de dialogue et attendez la réponse de l'utilisateur
    ButtonType userChoice = confirmationAlert.showAndWait().orElse(ButtonType.NO);

    if (userChoice == ButtonType.YES) {
        // Supprimez l'élément uniquement si l'utilisateur a cliqué sur Oui
        inter.supprimer_category(A.getIdCategorie());
        list1.getItems().remove(selectedIndex);
    }
} else {
    
      Alert confirmationAlert = new Alert(AlertType.CONFIRMATION);

  //  System.out.println("Veuillez sélectionner une catégorie à supprimer.");
      confirmationAlert.setHeaderText("Veuillez sélectionner une categorie à supprimer.?");

    // Ajoutez des boutons Oui et Non à la boîte de dialogue
    confirmationAlert.getButtonTypes().setAll(ButtonType.YES, ButtonType.NO);

    // Affichez la boîte de dialogue et attendez la réponse de l'utilisateur
    ButtonType userChoice = confirmationAlert.showAndWait().orElse(ButtonType.NO);

}

    }

    @FXML
    private void mod(ActionEvent event) {
        
           ListView<Category> list = affichercategorie;
        CategoryService inter = new CategoryService();
        int selectedIndex = list.getSelectionModel().getSelectedIndex();
        Category A = list.getSelectionModel().getSelectedItem();
        
             IdCategorie=A.getIdCategorie();
   NomCategorie=A.getNomCategorie();
   DescriptionCategorie=A.getDescriptionCategorie();
    
    

        try {

            Parent page1
                    = FXMLLoader.load(getClass().getResource("Modifiercategorie.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Location_categoryController.class.getName()).log(Level.SEVERE, null, ex);

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
  