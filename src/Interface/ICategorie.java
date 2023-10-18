/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import esprit.enities.Category;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author mznou
 */
public interface ICategorie {
    public void ajouterCategorie ( Category C);
    public void modifierCategorie (Category C);
    public void supprimerCategorie(int IdCategorie);
    public List<Category>afficherCategorie();
    public List<Category>afficherCategory2();
    public Category getCategorie (int idCategorie) throws SQLException;
}
