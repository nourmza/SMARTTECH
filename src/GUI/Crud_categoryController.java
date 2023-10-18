/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mznou
 */
public class Crud_categoryController implements Initializable {

    @FXML
    private Button affichercategorie;
    @FXML
    private Button ajoutercategory;
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
    private void affichercategorie(ActionEvent event) {
         try {

Parent page1 =
FXMLLoader.load(getClass().getResource("Affichercategorie.fxml"));
Scene scene = new Scene(page1);
Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
stage.setScene(scene);
stage.show();
} catch (IOException ex) {
Logger.getLogger(Location_categoryController.class.getName()).log(Level.SEVERE,null, ex);


} 
    }

    @FXML
    private void ajoutercategory(ActionEvent event) {
          try {

Parent page1 =
FXMLLoader.load(getClass().getResource("ajoutercategorie.fxml"));
Scene scene = new Scene(page1);
Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
stage.setScene(scene);
stage.show();
} catch (IOException ex) {
Logger.getLogger(Location_categoryController.class.getName()).log(Level.SEVERE,null, ex);


    }
}

    @FXML
    private void returnTo(MouseEvent event) {
        
                 FXMLLoader loader = new FXMLLoader(getClass().getResource("location_category.fxml"));
        try {
            Parent root = loader.load();
            nh.getChildren().setAll(root);

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
}
