/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.stage.Window;

import esprit.enities.Job;
import esprit.services.CategoryService;
import esprit.services.JobService;
import esprit.tools.DataSource;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.ProcessBuilder.Redirect.Type;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;




/**
 * FXML Controller class
 *
 * @author mznou
 */


public class AfficherJobController implements Initializable {

    @FXML
    private Button supprimer;
    @FXML
    private Button mod;
 

   
   
      static int id;
      static String NomCategorie;
    static String type;
    static String metierOuProduit;
    static String description;
    static String photos;
    @FXML
    private ListView<Job> afficherjob;
    @FXML
    private ImageView btnReturn;
    @FXML
    private AnchorPane nh;
    private ComboBox<String> StatV;
    @FXML
    private Button stat;
    @FXML
    private Button Search;
    @FXML
    private TextField txtsearch;
    @FXML
    private Button triDSC;
    @FXML
    private Button excel;
    @FXML
    private ImageView qrcode;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
            
ListView<Job> list1= afficherjob;
        JobService inter = new JobService();
        List<Job> list2 = inter.afficher();
        for (int i = 0; i < list2.size(); i++) {
            Job C = list2.get(i);
            list1.getItems().add(C);

        }  
       
    }    
   

    

    @FXML
    private void supprimer_job(ActionEvent event) {
        

ListView<Job> list1 = afficherjob;
JobService inter = new JobService();
int selectedIndex = list1.getSelectionModel().getSelectedIndex();

if (selectedIndex >= 0) {
    Job A = list1.getSelectionModel().getSelectedItem();
    System.out.println(A.getId());

    // Créez une boîte de dialogue de confirmation
    Alert confirmationAlert = new Alert(AlertType.CONFIRMATION);
    confirmationAlert.setTitle("Confirmation de la suppression");
    confirmationAlert.setHeaderText("Êtes-vous sûr de vouloir supprimer ce Job ?");

    // Ajoutez des boutons Oui et Non à la boîte de dialogue
    confirmationAlert.getButtonTypes().setAll(ButtonType.YES, ButtonType.NO);

    // Affichez la boîte de dialogue et attendez la réponse de l'utilisateur
    ButtonType userChoice = confirmationAlert.showAndWait().orElse(ButtonType.NO);

    if (userChoice == ButtonType.YES) {
        // Supprimez l'élément uniquement si l'utilisateur a cliqué sur Oui
        inter.supprimerJob2(A.getId());
        list1.getItems().remove(selectedIndex);
    }
} else {
        Alert confirmationAlert = new Alert(AlertType.CONFIRMATION);

   // confirmationAlert.setTitle("Veuillez sélectionner un Job à supprimer.");
       confirmationAlert.setHeaderText("Veuillez sélectionner un Job à supprimer.?");
    // Ajoutez des boutons Oui et Non à la boîte de dialogue
    confirmationAlert.getButtonTypes().setAll(ButtonType.YES, ButtonType.NO);

    // Affichez la boîte de dialogue et attendez la réponse de l'utilisateur
    ButtonType userChoice = confirmationAlert.showAndWait().orElse(ButtonType.NO);

}

    }

    @FXML
    private void mod(ActionEvent event) {
        
        
            ListView<Job> list = afficherjob;
        JobService inter = new JobService();
        int selectedIndex = list.getSelectionModel().getSelectedIndex();
        Job A = list.getSelectionModel().getSelectedItem();
        
          id =A.getId();
   NomCategorie=A.getNomCategorie();
   type=A.getType();
   metierOuProduit=A.getMetierOuProduit();
   description=A.getDescription();
   photos=A.getPhotos();
    
   
   
   
    

        try {

            Parent page1
                    = FXMLLoader.load(getClass().getResource("Modifierjob.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Location_categoryController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @FXML
    private void returnTo(MouseEvent event) {
                 FXMLLoader loader = new FXMLLoader(getClass().getResource("crud_job.fxml"));
        try {
            Parent root = loader.load();
            nh.getChildren().setAll(root);

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
/*
    @FXML
        
         private void Statistique(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Statistique.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                StatistiqueController c = loader.getController();
                c.start();
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();

    }*/

    @FXML
    private void gotostat(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("statistique.fxml"));
            Parent root = loader.load();
            
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            
            // Si vous souhaitez fermer la fenêtre actuelle après avoir ouvert la nouvelle fenêtre
            Node source = (Node) event.getSource();
            Window theStage = source.getScene().getWindow();
            theStage.hide();
            
        } catch (IOException ex) {
            Logger.getLogger(AfficherJobController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


            ObservableList<Job> ProduitListSearch;

    @FXML
    private void Search(ActionEvent event) {
        
                 JobService st= new  JobService();
        ProduitListSearch = st.likeByJob(txtsearch.getText());
        afficherjob.setItems(ProduitListSearch);
    }
        private ListView<Job> listViewCurrentStore; // Notez le changement de TableView à ListView


    @FXML
 private void triDSC(ActionEvent event) throws WriterException, FileNotFoundException {
    JobService jobService = new JobService();

    // Récupération de la liste triée
    ObservableList<Job> sortedJobs = jobService.TriTypeAs();

    // Mise à jour des éléments affichés dans le ListView
    afficherjob.setItems(sortedJobs);
    }


    @FXML
    private void excelmth(ActionEvent event) {
        
 Connection cnx=DataSource.getInstance().getConnection();

        try {

            String filename = "C:\\Users\\mznou\\Desktop\\smartech\\smartech\\data.xls";
            HSSFWorkbook hwb = new HSSFWorkbook();
            HSSFSheet sheet = hwb.createSheet("new sheet");

            HSSFRow rowhead = sheet.createRow((short) 0);
            rowhead.createCell((short) 0).setCellValue("type");
            rowhead.createCell((short) 1).setCellValue("metierOuProduit");
            rowhead.createCell((short) 2).setCellValue("description");
            rowhead.createCell((short) 3).setCellValue("photos");
            rowhead.createCell((short) 4).setCellValue("NomCategorie");

            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery("select * from job");
            int i = 1;
            while (rs.next()) {
                HSSFRow row = sheet.createRow((short) i);   

                row.createCell((short) 0).setCellValue(rs.getString("type"));
                row.createCell((short) 1).setCellValue(rs.getString("metierOuProduit"));
                row.createCell((short) 2).setCellValue(rs.getString("description"));
                row.createCell((short) 3).setCellValue(rs.getString("photos"));
                row.createCell((short) 4).setCellValue(rs.getString("NomCategorie"));
                i++;
            }
            FileOutputStream fileOut = new FileOutputStream(filename);
            hwb.write(fileOut);
            fileOut.close();
            System.out.println("Your excel file has been generated!");
            File file = new File(filename);
            if (file.exists()) {
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(file);
                }
            }

        } catch (Exception ex) {
            System.out.println(ex);

        }
    }
          //  public ListView<Job> tblViewCurrentStore;

 @FXML
private void QR(ActionEvent event) throws WriterException {
    Job pt = afficherjob.getSelectionModel().getSelectedItem();
    System.out.println(pt.getNomCategorie());

    String value = pt.getNomCategorie();
    String path = "C:\\Users\\mznou\\Desktop\\smartech\\smartech\\QRCODE\\" + value + ".png";
    String charset = "UTF-8";

    Map<EncodeHintType, Object> hintMap = new HashMap<>();
    hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
    try {
        createQR(value, path, charset, hintMap, 200, 200);
        System.out.println("QR Code Generated!!! ");

        InputStream stream = new FileInputStream(path);
        Image image = new Image(stream);
        qrcode.setImage(image);
    } catch (IOException ex) {
        Logger.getLogger(AfficherJobController.class.getName()).log(Level.SEVERE, null, ex);
    }
}
 //methode de qrcode
     public static void createQR(String data, String path,
                                String charset, Map hashMap,
                                int height, int width)
        throws WriterException, IOException
    {
 
        BitMatrix matrix = new MultiFormatWriter().encode(
            new String(data.getBytes(charset), charset),
            BarcodeFormat.QR_CODE, width, height);
 
        MatrixToImageWriter.writeToFile(
            matrix,
            path.substring(path.lastIndexOf('.') + 1),
            new File(path));
    }



    }

