/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import esprit.enities.Job;
import esprit.services.JobService;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author mznou
 */
public class StatController implements Initializable {

    @FXML
    private PieChart idpiechart;
    @FXML
    private Label caption;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          JobService jobService = new JobService();
        ObservableList<Job> jobList = jobService.afficherJobList();
        List<Job> jobData = new ArrayList<Job>();

        for (int i = 0; i < jobList.size(); i++) {
            jobData.add(jobList.get(i));
        }

        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Sante", jobData.stream().filter(e -> "sante".equalsIgnoreCase(e.getNomCategorie())).count()),
                new PieChart.Data("Enseignement", jobData.stream().filter(e -> "enseignement".equalsIgnoreCase(e.getNomCategorie())).count()),
                new PieChart.Data("Restauration", jobData.stream().filter(e -> "restauration".equalsIgnoreCase(e.getNomCategorie())).count()));

        idpiechart.setData(pieChartData);
        idpiechart.setTitle("Categorie");

        for (final PieChart.Data data : idpiechart.getData()) {
            data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        caption.setLayoutX(e.getSceneX());
                        caption.setLayoutY(e.getSceneY());
                        float percentage = (float) data.getPieValue() * 100 / jobData.size();
                        String formattedString = String.format("%.2f", percentage);

                        caption.setText(String.format("%.1f%%", percentage));
                    }
                });
        }
    }
}