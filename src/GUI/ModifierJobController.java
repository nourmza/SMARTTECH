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
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mznou
 */
public class ModifierJobController implements Initializable {

    @FXML
    private ComboBox<String> cat_cb;
    @FXML
    private TextField fx_type;
    @FXML
    private TextField fx_metier;
    @FXML
    private TextArea fx_desc;
    @FXML
    private ImageView imagev;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //GET CATREGORIES LISTE DEROULANTE FOR JOIN !
        ObservableList<String> list = FXCollections.observableArrayList();
        CategoryService sc = new CategoryService();

        ObservableList<Category> obList = FXCollections.observableArrayList();
        obList = sc.afficherCategory2();

        cat_cb.getItems().clear();

        for (Category nameCat : obList) {
            System.out.println("hii");
            list.add(nameCat.getNomCategorie());
            System.out.println("hii" + list);

            cat_cb.setItems(list);

            FXMLLoader loader = new FXMLLoader();

            loader.setLocation(getClass().getResource("AfficherJob.fxml"));
            Stage prStage = new Stage();

            Parent root;
            try {
                root = loader.load();
                Scene scene = new Scene(root);
                prStage.setScene(scene);
                AfficherJobController irc = loader.getController();
                JobService sp = new JobService();
                int id = irc.A.getId();

                fx_type.setText(irc.A.getType());

            } catch (IOException ex) {
                Logger.getLogger(ModifierJobController.class.getName()).log(Level.SEVERE, null, ex);
            }

            // TODO
        }
    }    

    

    public void setType(String type) {
        fx_type.setText(type);
    }

    public void  setMetierOuProduit(String pri) {
        fx_metier.setText(pri);
    }

 

   public void  setDescription(String de) {
        fx_desc.setText(de);
    }
int idS;
public void setId(int id)
{
    idS=id;
    System.out.println("her id"+idS);
}

   

    @FXML
    private void ajoutArticleHandle(MouseEvent event) {
    }

    @FXML
    private void uploadimageHandler(MouseEvent event) {
    }

    @FXML
    private void modifHAndle(ActionEvent event) {

        try {

            JobService ss = new JobService();

            Job s = new Job();
            s.setDescription(fx_desc.getText());
            s.setType(fx_type.getText());
            s.setMetierOuProduit(fx_metier.getText());

      
            s.setId(idS);

            s.setPhotos(img);
            s.setNomCategorie(NomCategorie); // RUNI w jarb

            ss.modifier(s);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("succes");
            alert.setHeaderText("!!! Modification effectuer avec suucces !!!");
            alert.setContentText("succes");
            alert.showAndWait();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("AfficherJob.fxml"));
            Stage prStage = new Stage();
            Parent root;
            root = loader.load();
            Scene scene = new Scene(root);
            prStage.setScene(scene);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    String img = "";

    void setImg(String servImg) {
        img = servImg;

    }

    String NomCategorie = "";

    void setNomCategorie(String NomCategorie) {
        NomCategorie = NomCategorie;
    }

    @FXML
    private void gotoArticles(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AfficherJob.fxml"));
        Stage prStage = new Stage();
        Parent root;
        root = loader.load();
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    
}
    