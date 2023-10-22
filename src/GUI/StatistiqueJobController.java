/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import esprit.enities.Job;
import esprit.services.JobService;
import esprit.tools.DataSource;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author mznou
 */
public class StatistiqueJobController implements Initializable {
private BarChart<String, Number> Statique;

    @FXML
    private AnchorPane chartHolder;
    private ArrayList<Job> lsComm = new ArrayList<>(new JobService().afficherJobArrayList());
    

private Statement st;
    private ResultSet rs;
    private Connection cnx;
        ObservableList<PieChart.Data>data=FXCollections.observableArrayList();
    @FXML
    private PieChart stat_job;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
Connection cnx=DataSource.getInstance().getConnection();
            stat();   
    }    



    private void stat() {
          try{
           // String query ="select COUNT(*),reservation_voyage.travel_class from voyage INNER JOIN reservation_voyage on reservation_voyage.voyage_id =voyage.id GROUP BY travel_class;";
           //String query ="select COUNT(*),`prix`  from voyage GROUP BY `destination`;";
           String query ="select COUNT(*),`NomCategorie` from job GROUP BY `NomCategorie`;";

           PreparedStatement PreparedStatement = cnx.prepareStatement(query);
             rs = PreparedStatement.executeQuery();
             while (rs.next()){               
               data.add(new PieChart.Data(rs.getString("NomCategorie"),rs.getInt("COUNT(*)")));
            }  
             
        } catch (SQLException ex) {
              System.out.println(ex.getMessage());
        }
        
         stat_job.setTitle("**Statistiques Des Job par categorie **");
        stat_job.setLegendSide(Side.LEFT);
        stat_job.setData(data);
    }

    @FXML
    private void Retour(ActionEvent event) {
        
                     FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherJob.fxml"));
        try {
            Parent root = loader.load();
            chartHolder.getChildren().setAll(root);

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
}
