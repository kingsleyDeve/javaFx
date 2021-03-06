package controller;

import java.io.IOException;
import java.sql.SQLException;

import dao.AdministrateurDAO;
import dao.OffreDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import metier.Administrateur;
import metier.Offre;
import projetjob.Main;

/**
 *
 * @author king9
 */
public class AdministrateurInscricontroller {
    
  
    @FXML
    private Button retourBtn;
    
    @FXML
    private Button validerBtn;
    
    @FXML
    private TextField adminsiret;
    
    @FXML
    private TextField adminmdp;
    
    @FXML
    private void retour(ActionEvent actionEvent) throws SQLException, ClassNotFoundException 
    {    
      
                    try
                    {
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(Main.class.getClassLoader().getResource("view/AdministrateurMenu.fxml"));
                        AnchorPane mainPane = (AnchorPane) loader.load();
//                    
                        Stage stage =  (Stage) retourBtn.getScene().getWindow();
                        Scene scene = retourBtn.getScene();
                        scene.setRoot(mainPane);
                        stage.setScene(scene);
//                    
                      
                    }catch(IOException e)
                     {
                         System.out.print(e);
                     }
                }
    
    @FXML
    public void  valider(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
    	
    	if(!adminsiret.getText().isEmpty() && !adminmdp.getText().isEmpty()) {
    	try {
           
            	Administrateur administrateur = new Administrateur();
            	
           	administrateur.setAdministrateur_siret(Integer.parseInt(adminsiret.getText()));
           	administrateur.setAdministrateur_mdp(adminmdp.getText());
                AdministrateurDAO.ajoutadmin(administrateur);
      
             
                adminsiret.clear();
                adminmdp.clear();
                
            
                
    	} catch (SQLException e){
            System.out.println("Error occurred while getting offre information from DB.\n" + e);
            throw e;
        
       }
    	}
    }
      
    

}