package controller;
import java.io.IOException;
import java.sql.SQLException;
import dao.OffreDAO;
import dao.PartenaireDAO;
import dao.UtilisateurDAO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import metier.Offre;
import metier.Partenaire;
import metier.Utilisateur;
import projetjob.Main;


public class AdministrateurTableviewcontroller {
	
	
	
	    @FXML
	    private TextField recherche;
	    
	    @FXML
	    private Button supprimerBtn;
	 
	    @FXML
	    private Button cdiBtn;
	 
	    @FXML
	    private Button deconnexionBtn;
	    
	    @FXML
	    private TableView<Offre> tableOffre;
	    
	    @FXML
	    private TableColumn<Offre, Integer> id;
	    
	    @FXML
	    private TableColumn<Offre, String> type_contrat;
	    
	    @FXML
	    private TableColumn<Offre, String> emploi;
	    
	        
	    
	  
	    @FXML
	    private void initialize () {

	    	  
	    	
	    	 
	    	try {
				ObservableList<Offre> offreData = OffreDAO.getAllOffres();
				tableOffre.setItems(offreData);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	 id.setCellValueFactory(cellData -> cellData.getValue().getIdoffreProp().asObject());
	    	  type_contrat.setCellValueFactory(cellData -> cellData.getValue().getType_contratProperty());
	    	  emploi.setCellValueFactory(cellData -> cellData.getValue().getEmploiProperty());
	   
	    	  tableOffre.getItems().size();
	    	  
	    }
    
    @FXML
    private void supprimer(ActionEvent actionEvent) throws SQLException, ClassNotFoundException 
    {    
        
          
            	
        	 
        	 try {
                 
                 
        	      
             	Offre offre = tableOffre.getSelectionModel().getSelectedItem();
             	
             	System.out.println(offre);
             	OffreDAO.supprimerOffre(offre);
             	tableOffre.getItems().remove(offre);
             	
             	tableOffre.refresh();
             	} catch (SQLException e){
                  System.out.println("Error occurred while getting employees information from DB.\n" + e);
                  throw e;
              
             }

    	 
    }
    
    @FXML
    private void deconnexion(ActionEvent actionEvent) throws SQLException, ClassNotFoundException 
    {    
      
                    try
                    {
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(Main.class.getClassLoader().getResource("view/AdministrateurCnx.fxml"));
                        AnchorPane mainPane = (AnchorPane) loader.load();
//                    
                        Stage stage =  (Stage) deconnexionBtn.getScene().getWindow();
                        Scene scene = deconnexionBtn.getScene();
                        scene.setRoot(mainPane);
                        stage.setScene(scene);
//                    
                      
                    }catch(IOException e)
                     {
                         System.out.print(e);
                     }
                }
    
    
  

  
}
    
    
     
           
     
 



