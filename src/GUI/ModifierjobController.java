/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import esprit.enities.Category;
import esprit.enities.Job;
import esprit.services.CategoryService;
import esprit.services.JobService;
import java.io.File;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mznou
 */
public class ModifierjobController implements Initializable {

    @FXML
    private AnchorPane nh;
    @FXML
    private TextField fx_type;
    @FXML
    private TextField fx_metier;
    @FXML
    private TextArea fx_desc;
    @FXML
    private ImageView imagev;
    @FXML
    private Label file_path;
    @FXML
    private Button modifier_job;
    @FXML
    private TextField catid;
    @FXML
    private ImageView btnReturn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          fx_type.setText(AfficherJobController.type);
         fx_metier.setText(AfficherJobController.metierOuProduit);
         fx_desc.setText(AfficherJobController.description);
         catid.setText(Integer.toString(AfficherJobController.IdCategorie));


    }    

    @FXML
    private void uploadimageHandler(MouseEvent event) {
        
         FileChooser open = new FileChooser();
        Stage stage = (Stage) nh.getScene().getWindow();
        File file = open.showOpenDialog(stage);
        if (file != null) {
            String path = file.getName();
            file_path.setText(path);
            Image image = new Image(file.toURI().toString(), 500, 500, false, true);
            imagev.setImage(image);
        } else {
            System.out.println("NO DATA EXIST!");
        }
   
    }

   @FXML
private void modifier(ActionEvent event) {
    // Instanciez le service de Job
    JobService jobService = new JobService();

    // Récupérez les données à partir des champs de texte et du champ IdCategorie
    String type = fx_type.getText();
    String metierOuProduit = fx_metier.getText();
    String description = fx_desc.getText();

    // Assurez-vous que le champ IdCategorie est un nombre valide
    int IdCategorie;
    try {
        IdCategorie = Integer.parseInt(catid.getText());
    } catch (NumberFormatException e) {
        IdCategorie = -1; // Valeur par défaut en cas d'erreur
    }

    // Validez les champs avant de procéder à la modification
    if (type.isEmpty() || metierOuProduit.isEmpty() || description.isEmpty() || IdCategorie < 1) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez remplir tous les champs correctement.");
        alert.show();
    } else {
        // Créez un nouvel objet Job
        Job modifiedJob = new Job(AfficherJobController.id, type, metierOuProduit, description, file_path.getText(), IdCategorie);
        
        // Appelez la méthode de service pour effectuer la modification
        jobService.modifier(modifiedJob);
        
        // Affichez un message de confirmation
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Job modifié avec succès !");
        alert.show();
    }
}



   @FXML
    private void returnTo(MouseEvent event) {
        
                 FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherJob.fxml"));
        try {
            Parent root = loader.load();
            nh.getChildren().setAll(root);

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
}