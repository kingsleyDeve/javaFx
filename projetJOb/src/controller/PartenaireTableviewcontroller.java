package controller;
import java.io.IOException;
import java.sql.SQLException;

import classe.Partenaire;
import dao.OffreDAO;
import dao.PartenaireDAO;
import dao.UtilisateurDAO;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import metier.Offre;
import metier.Utilisateur;
import projetjob.Main;


public class PartenaireTableviewcontroller {
	
	 @FXML
	    private Button supprimerBtn;
	 
	 @FXML
	    private Button modifBtn;
	 
	 
	 
	 @FXML
	    private Button deconnexionBtn;
	 
	 @FXML
	    private Button ajoutBtn;
	 
	 @FXML
		private TextField txtcontrat;
	 
	 @FXML
		private TextField txtemploi;
	
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

    	  
    	 tableOffre.getSelectionModel().selectedItemProperty().addListener(
                 (observable, oldValue, newValue) -> selectItems(newValue));
    	 
    	
    	 
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
    }
   
    @FXML
   private void selectItems(Offre offre){
        if (offre != null) {
            
        	txtcontrat.setText(	offre.getType_contrat());
        	txtemploi.setText(offre.getEmploi());
        } else {
        	txtcontrat.setText(	"");
        	txtemploi.setText("");
          
        }

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
    private void ajouter(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
    	
    	if(!txtcontrat.getText().isEmpty() && !txtemploi.getText().isEmpty()) {
    	try {
           
            	Offre offre = new Offre();
           	 					
           	offre.setType_contrat(txtcontrat.getText());
           	offre.setEmploi(txtemploi.getText());
                OffreDAO.ajoutoffre(offre);
                
                tableOffre.getItems().add(offre);
                txtcontrat.clear();
                txtemploi.clear();
                tableOffre.refresh();
                
               
                
    	} catch (SQLException e){
            System.out.println("Error occurred while getting offre information from DB.\n" + e);
            throw e;
        
       }
    	}
    }
  
    
    @FXML
    private void modifier(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
    
    	if(!txtcontrat.getText().isEmpty() && !txtemploi.getText().isEmpty()) {
    	try {
           
        	Offre offre = tableOffre.getSelectionModel().getSelectedItem();
        	
        	offre.setType_contrat(txtcontrat.getText());
        	offre.setEmploi(txtemploi.getText());
            System.out.println("kkjf");
                OffreDAO.majoffre(offre);
                
               
                tableOffre.refresh();
    	} catch (SQLException e){
            System.out.println("Error occurred while getting offre information from DB.\n" + e);
            throw e;
        
       }
    	}
    }
    
    @FXML
    private void deconnexion(ActionEvent actionEvent) throws SQLException, ClassNotFoundException 
    {    
      
                    try
                    {
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(Main.class.getClassLoader().getResource("view/PartenaireCnx.fxml"));
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
    
    