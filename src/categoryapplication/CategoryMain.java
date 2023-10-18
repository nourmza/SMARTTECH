/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package categoryapplication;

import esprit.enities.Category;
import esprit.services.CategoryService;
import esprit.tools.DataSource;

public class CategoryMain {

    public static void main(String[] args) {
        DataSource instance = DataSource.getInstance();
    

         //Add a new Category
        // Category C = new Category("nom Categorie", " description Categorie");
         //CategoryService c1 = new CategoryService(); 
         //c1.ajouterCategory(C);
         


//*ajouter category
Category C = new Category ("nom Categorie", " description Categorie");
CategoryService r1 = new CategoryService();  
r1.ajouterCategory(C);

//Afficher category
CategoryService es = new CategoryService();

 //System.out.println(es.afficher());
 
 
  //System.out.println(es.afficherCategory2());
 // es.getCategorie(C);
}
}

       // Category C =new Category();
        // C.setDescriptionCategorie("mzahi");    
        //C.setNomCategorie("nour");
            
            
      
        
        

   

 //CategoryService s = new CategoryService();
//
 //s.modifier(updateC);
 //tester modifier
   //CategoryService c2 = new CategoryService();
   // Category updateC = new Category();
     //updateC.setDescriptionCategorie("teste le champ description");
     //updateC.setNomCategorie("musculation ");
     
// updateC.setIdCategorie(1);
 //c2.modifier(updateC);
//}
//}

 
 

//tester supprimer
//*Category C =new Category();
 //CategoryService c2= new CategoryService();
 //c2.supprimer_category(1);
   // }
//*}




