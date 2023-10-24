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
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.PieChart;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author mznou
 */
public class StatistiqueController implements Initializable {

    @FXML
    private PieChart pieChart;
    @FXML
    private ImageView btnReturn;

         ObservableList<PieChart.Data>data=FXCollections.observableArrayList();
    @FXML
    private AnchorPane nh;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
                   JobService rs= new JobService();
           ArrayList<Job> list = (ArrayList<Job>) rs.afficherJobArrayList();
           int nbAccepted=0;
           int nbRefused=0;
           int nbPending=0;
           for(int i =0;i<list.size();i++)
           {
               if (list.get(i).getNomCategorie().equals("sante"))
                   nbPending++;
               else if (list.get(i).getNomCategorie().equals("enseignement"))
                   nbAccepted++;
               else if (list.get(i).getNomCategorie().equals("restauration"))
                       nbRefused++;
           }
        // Creating a list of PieChart.Data objects
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("sante", nbAccepted),
                new PieChart.Data("enseignement", nbRefused),
                new PieChart.Data("restauration", nbPending));

        // Adding the PieChart.Data list to the PieChart object
        pieChart.setData(pieChartData);

        // Setting the title of the PieChart object
        pieChart.setTitle("Statistique par Categorie");

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
