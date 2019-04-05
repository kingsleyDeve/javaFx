package controller;

import java.io.IOException;
import java.sql.SQLException;

import dao.AdministrateurDAO;
import dao.JeuneDAO;
import dao.PartenaireDAO;
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
import metier.Jeune;
import metier.Partenaire;
import projetjob.Main;

/**
 *
 * @author king9
 */
public class JeuneInscricontroller {
    
  
    @FXML
    private Button retourBtn;
    
    @FXML
    private Button validerBtn;
    
    @FXML
    private TextField login;
    
    @FXML
    private TextField nom;
    
    @FXML
    private TextField prenom;
    
    
    @FXML
    private TextField jeunemdp;
    
  
    
    @FXML
    private void retour(ActionEvent actionEvent) throws SQLException, ClassNotFoundException 
    {    
      
                    try
                    {
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(Main.class.getClassLoader().getResource("view/JeuneMenu.fxml"));
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
    	
    	if(!login.getText().isEmpty() && !jeunemdp.getText().isEmpty() && !nom.getText().isEmpty() && !prenom.getText().isEmpty()) {
    	try {
           
            	Jeune jeune = new Jeune();
            	
           	jeune.setLogin(login.getText());
           	jeune.setJeune_mdp(jeunemdp.getText());
           	jeune.setNom(nom.getText());
           	jeune.setPrenom(prenom.getText());


                JeuneDAO.ajoutjeune(jeune);
      
                nom.clear();
                prenom.clear();
                login.clear();
                jeunemdp.clear();
                
             

                
    	} catch (SQLException e){
            System.out.println("Error occurred while getting offre information from DB.\n" + e);
            throw e;
        
       }
    	}
    }
    

}