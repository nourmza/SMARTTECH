/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import esprit.enities.Job;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author mznou
 */
public interface IJob {
    
    public void ajouterJob ( Job J);
    public void modifierJob (Job J);
    public void supprimerJob(int id);
    public List<Job>afficherJob();
    public Job getJob (int id) throws SQLException;
}
