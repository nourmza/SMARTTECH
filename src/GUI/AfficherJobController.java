/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import esprit.enities.Job;
import esprit.services.JobService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Callback;

import javafx.scene.control.Label;


/**
 * FXML Controller class
 *
 * @author mznou
 */
public class AfficherJobController implements Initializable {

    
    

    ObservableList<Job> obList;
    JobService a;
    Button btn;
    Button btnEx;
    Button btnModi;
    Job A = new Job();
    private TableColumn<Job, Void> colModifBtn;
    private TableColumn<Job, Void> colSuppBtn;
    @FXML
    private TableView<Job> tableview;
    @FXML
    private TableColumn<Job, String> ft_type;
    @FXML
    private TableColumn<Job, String> ft_metier;
    @FXML
    private TableColumn<Job, String> ft_desc;
    @FXML
    private TableColumn<Job, String> ft_nomcategorie;
    @FXML
    private Button btnAjouter;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colSuppBtn = new TableColumn<>("Supprimer");
        tableview.getColumns().add(colSuppBtn);

        colModifBtn = new TableColumn<>("Modifier");
        tableview.getColumns().add(colModifBtn);

       
        a = new JobService();
        obList = a.afficherJob2();
        
      
        ft_type.setCellValueFactory(new PropertyValueFactory<>("type"));

        ft_metier.setCellValueFactory(new PropertyValueFactory<>("metierOuProduit"));
        ft_desc.setCellValueFactory(new PropertyValueFactory<>("description"));

        ft_nomcategorie.setCellValueFactory(new PropertyValueFactory<>("NomCategorie"));

        tableview.setItems(obList);

        addButtonModifToTable();

        addButtonDeleteToTable();

         
    }    

    public void Afficher() {
        tableview.refresh();
        obList.clear();

        //  obList   = a.getArticleByCategorie();
        obList = a.afficherJob2();

        ft_type.setCellValueFactory(new PropertyValueFactory<>("type"));
        ft_metier.setCellValueFactory(new PropertyValueFactory<>("metierOuProduit"));
        ft_desc.setCellValueFactory(new PropertyValueFactory<>("description"));
        ft_nomcategorie.setCellValueFactory(new PropertyValueFactory<>("NomCategorie"));

        tableview.setItems(obList);
    }
    @FXML
    private void gotoAjouter(ActionEvent event) {
    }

    private void addButtonModifToTable() {
Callback<TableColumn<Job, Void>, TableCell<Job, Void>> cellFactory = new Callback<TableColumn<Job, Void>, TableCell<Job, Void>>() {
            public TableCell<Job, Void> call(final TableColumn<Job, Void> param) {

                final TableCell<Job, Void> cell = new TableCell<Job, Void>() {

                    {

                        btn = new Button("Modifier");

                        btn.setOnAction((ActionEvent event) -> {

                            try {

                                A = tableview.getSelectionModel().getSelectedItem();

                                FXMLLoader loader = new FXMLLoader(getClass().getResource("modifierJob.fxml"));
                                Parent root = loader.load();
                                ModifierJobController controller = loader.getController();
                             
                                controller.setType(A.getType());
                                controller.setDescription(A.getDescription());
                     
                                controller.setId(A.getId());
                                controller.setImg(A.getPhotos());
                                controller.setMetierOuProduit(A.getMetierOuProduit());
                                controller.setNomCategorie(A.getNomCategorie());
                                Stage stage = new Stage();
                                stage.setScene(new Scene(root));
                                stage.show();

                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        });

                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };

        colModifBtn.setCellFactory(cellFactory);

    }

    Button btnSupprimer;

    private void addButtonDeleteToTable() {
Callback<TableColumn<Job, Void>, TableCell<Job, Void>> cellFactory = new Callback<TableColumn<Job, Void>, TableCell<Job, Void>>() {
            @Override
            public TableCell<Job, Void> call(final TableColumn<Job, Void> param) {

                final TableCell<Job, Void> cell = new TableCell<Job, Void>() {


                    { 

                        btnSupprimer = new Button("Supprimer");
                         btnSupprimer = new Button("Supprimer");
                        btnSupprimer.setOnAction((ActionEvent event) -> {
                            
                             
                              A = tableview.getSelectionModel().getSelectedItem();
                              showConfirmation(A);
                              
                        });

                   
                        
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);  
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btnSupprimer);
                        }
                    }
                };
                return cell;    
            }
        };

        colSuppBtn.setCellFactory(cellFactory);


        
        
        
   
      }
    
    private Label label;
    private void showConfirmation(Job A) {
        
 
      Alert alert = new Alert(AlertType.CONFIRMATION);
      alert.setTitle("Suppression");
      alert.setHeaderText("Voullez vous vraiment supprimer??");
      alert.setContentText("Job peut etre effacer");
 
      // option != null.
      Optional<ButtonType> option = alert.showAndWait();
 
      if (option.get() == null) {
         this.label.setText("pas selection!");
      } else if (option.get() == ButtonType.OK) {
          System.out.println(A.getId());
          a.supprimerJob(A);
          obList.clear();
          Afficher();
      } else if (option.get() == ButtonType.CANCEL) {
         this.label.setText("Exit!");
      } else {
         this.label.setText("-");
      }
   }

}

