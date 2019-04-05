package controller;
import java.io.IOException;
import java.sql.SQLException;
import dao.OffreDAO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import metier.Offre;
import projetjob.Main;


public class PartenaireMenucontroller {
	
	@FXML
	private Button cnxBtn;
        
	@FXML
	private Button inscriptionBtn;
    
	@FXML
	private Button retourBtn;
  
    
    
    @FXML
    private void connexion(ActionEvent actionEvent) throws SQLException, ClassNotFoundException 
    {    
       
            
                    try
                    {
                    	FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(Main.class.getClassLoader().getResource("view/PartenaireCnx.fxml"));
                        AnchorPane mainPane = (AnchorPane) loader.load();
//                    
                        Stage stage =  (Stage) cnxBtn.getScene().getWindow();
                        Scene scene = cnxBtn.getScene();
                        scene.setRoot(mainPane);
                        stage.setScene(scene);
        	        
        	         
                    }catch(IOException e)
                     {
                         System.out.print(e);
                     }
           
    	
    	
    }

    @FXML
    private void inscription(ActionEvent actionEvent) throws SQLException, ClassNotFoundException 
    {    
       
            
                  
                    	  try
                          {
                    		  FXMLLoader loader = new FXMLLoader();
                	            loader.setLocation(Main.class.getClassLoader().getResource("view/PartenaireInscri.fxml"));
                	           AnchorPane mainPane = (AnchorPane) loader.load();
                	         Stage stage =  (Stage) inscriptionBtn.getScene().getWindow();
                           Scene scene = inscriptionBtn.getScene();
                           scene.setRoot(mainPane);
                           stage.setScene(scene);
           	        
                         
              	         
                          }catch(IOException e)
                           {
                               System.out.print(e);
                           }
                 
                  
    	
    	
    }

    @FXML
    private void retour(ActionEvent actionEvent) throws SQLException, ClassNotFoundException 
    {    
       
            
                    try
                    {
                    	FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(Main.class.getClassLoader().getResource("view/Menu.fxml"));
                        AnchorPane offre= (AnchorPane) loader.load();
//                      BorderPane mainFrame = (BorderPane) loader.load();
                      
                        Stage stage =  (Stage) retourBtn.getScene().getWindow();
                        Scene scene = retourBtn.getScene();
                        scene.setRoot(offre);
                        stage.setScene(scene);
//                      
                    }catch(IOException e)
                     {
                         System.out.print(e);
                     }
           
    	
    	
    }
}
    