
package controller;

import java.io.IOException;
import java.sql.SQLException;

import dao.PartenaireDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import projetjob.Main;

public class Menucontroller {
	
@FXML
private Button administrateur;

@FXML
private Button jeune;

@FXML
private Button partenaire;

	
@FXML
private void menupartenaire(ActionEvent actionEvent) throws SQLException, ClassNotFoundException 
{    
   
        
                try
                {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(Main.class.getClassLoader().getResource("view/PartenaireMenu.fxml"));
                    AnchorPane mainpane= (AnchorPane) loader.load();
                    Stage stage =  (Stage) partenaire.getScene().getWindow();
                    Scene scene = partenaire.getScene();
                    scene.setRoot(mainpane);
                    stage.setScene(scene);
                }catch(IOException e)
                 {
                     System.out.print(e);
                 }
       
	
	
}

@FXML
private void menuadministrateur(ActionEvent actionEvent) throws SQLException, ClassNotFoundException 
{    
   
        
                try
                {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(Main.class.getClassLoader().getResource("view/AdministrateurMenu.fxml"));
                    AnchorPane offre= (AnchorPane) loader.load();
//                  BorderPane mainFrame = (BorderPane) loader.load();
                    System.out.println(offre.getId());
                    Stage stage =  (Stage) administrateur.getScene().getWindow();
                    Scene scene = administrateur.getScene();
                    scene.setRoot(offre);
                    stage.setScene(scene);
                }catch(IOException e)
                 {
                     System.out.print(e);
                 }
       
	
	
}

@FXML
private void menujeune(ActionEvent actionEvent) throws SQLException, ClassNotFoundException 
{    
   
        
                try
                {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(Main.class.getClassLoader().getResource("view/JeuneMenu.fxml"));
                    AnchorPane offre= (AnchorPane) loader.load();
//                  BorderPane mainFrame = (BorderPane) loader.load();
                    System.out.println(offre.getId());
                    Stage stage =  (Stage) partenaire.getScene().getWindow();
                    Scene scene = partenaire.getScene();
                    scene.setRoot(offre);
                    stage.setScene(scene);
                }catch(IOException e)
                 {
                     System.out.print(e);
                 }
       
	
	
}


}
