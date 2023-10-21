/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package categoryapplication;
import java.util.List;
import esprit.enities.Job;
import esprit.services.CategoryService;
import javax.activation.DataSource;
import esprit.services.JobService;






/**
 *
 * @author Lenovo
 */
public class JobMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      JobService s = new JobService();
            esprit.tools.DataSource.getInstance();

       
            
//***ajouter job
  Job j =new Job(88,"sport"," ,musculation","nour","mzahi","30");
  s.ajouterJob(j);
  
  
  
 
    // modifier job
    Job updateC = new Job();
     updateC.setType("teste le champ description");
     updateC.setMetierOuProduit("musculation ");
     updateC.setDescription("musculation ");
     updateC.setPhotos("musculation ");

     updateC.setId(1);
     
    s.modifier(updateC);
   
   //**supprimer job
  // JobService es = new JobService();
   
   //Job e1=new Job ();
    // e1.setId(1);
     // es.supprimerJob(e1);
      
      
      
      //afficher job
    JobService es = new JobService();

 System.out.println(es.afficherJobList());
     
      
       
}
}
 

    
    
