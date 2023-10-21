/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import esprit.enities.Job;
import esprit.services.JobService;
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


public class AfficherJobController implements Initializable {

    @FXML
    private Button supprimer;
    @FXML
    private Button mod;
 

   
   
      static int id;
      static String NomCategorie;
    static String type;
    static String metierOuProduit;
    static String description;
    static String photos;
    @FXML
    private ListView<Job> afficherjob;
    @FXML
    private ImageView btnReturn;
    @FXML
    private AnchorPane nh;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
ListView<Job> list1= afficherjob;
        JobService inter = new JobService();
        List<Job> list2 = inter.afficher();
        for (int i = 0; i < list2.size(); i++) {
            Job C = list2.get(i);
            list1.getItems().add(C);

        }  
    }    
   

    

    @FXML
    private void supprimer_job(ActionEvent event) {
        

ListView<Job> list1 = afficherjob;
JobService inter = new JobService();
int selectedIndex = list1.getSelectionModel().getSelectedIndex();

if (selectedIndex >= 0) {
    Job A = list1.getSelectionModel().getSelectedItem();
    System.out.println(A.getId());

    // Créez une boîte de dialogue de confirmation
    Alert confirmationAlert = new Alert(AlertType.CONFIRMATION);
    confirmationAlert.setTitle("Confirmation de la suppression");
    confirmationAlert.setHeaderText("Êtes-vous sûr de vouloir supprimer ce Job ?");

    // Ajoutez des boutons Oui et Non à la boîte de dialogue
    confirmationAlert.getButtonTypes().setAll(ButtonType.YES, ButtonType.NO);

    // Affichez la boîte de dialogue et attendez la réponse de l'utilisateur
    ButtonType userChoice = confirmationAlert.showAndWait().orElse(ButtonType.NO);

    if (userChoice == ButtonType.YES) {
        // Supprimez l'élément uniquement si l'utilisateur a cliqué sur Oui
        inter.supprimerJob2(A.getId());
        list1.getItems().remove(selectedIndex);
    }
} else {
    System.out.println("Veuillez sélectionner un Job à supprimer.");
}

    }

    @FXML
    private void mod(ActionEvent event) {
        
        
            ListView<Job> list = afficherjob;
        JobService inter = new JobService();
        int selectedIndex = list.getSelectionModel().getSelectedIndex();
        Job A = list.getSelectionModel().getSelectedItem();
        
          id =A.getId();
   NomCategorie=A.getNomCategorie();
   type=A.getType();
   metierOuProduit=A.getMetierOuProduit();
   description=A.getDescription();
   photos=A.getPhotos();
    
   
   
   
    

        try {

            Parent page1
                    = FXMLLoader.load(getClass().getResource("Modifierjob.fxml"));
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
                 FXMLLoader loader = new FXMLLoader(getClass().getResource("crud_job.fxml"));
        try {
            Parent root = loader.load();
            nh.getChildren().setAll(root);

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    }
    
