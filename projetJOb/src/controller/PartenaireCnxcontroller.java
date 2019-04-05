/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.SQLException;

import dao.AdministrateurDAO;
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
import projetjob.Main;

/**
 *
 * @author king9
 */
public class PartenaireCnxcontroller {
    
    @FXML
    private TextField cnxid;
    
    @FXML
    private TextField cnxmdp;
    
    @FXML
    private Button cnxbtn;
    
    @FXML
    private Button retourBtn;
    
    
    @FXML
    private void connexion(ActionEvent actionEvent) throws SQLException, ClassNotFoundException 
    {    
        if(!cnxid.getText().equals("") && !cnxmdp.getText().equals(""))
        {
            
            
                if( PartenaireDAO.partconnect(Integer.parseInt(cnxid.getText()),cnxmdp.getText()))
                {
                    try
                    {
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(Main.class.getClassLoader().getResource("view/PartenaireTableview.fxml"));
                        AnchorPane mainPane = (AnchorPane) loader.load();
                        Stage stage =  (Stage) cnxbtn.getScene().getWindow();
                        Scene scene = cnxbtn.getScene();
                        scene.setRoot(mainPane);
                        stage.setScene(scene);
                    }catch(IOException e)
                     {
                         System.out.print(e);
                     }
                    
                }
        }
           
      } 
    
    @FXML
    private void retour(ActionEvent actionEvent) throws SQLException, ClassNotFoundException 
    {    
      
                    try
                    {
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(Main.class.getClassLoader().getResource("view/PartenaireMenu.fxml"));
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
}
           
        
        
    
    
    

