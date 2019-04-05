package controller;
import java.io.IOException;
import java.sql.SQLException;

import dao.OffreDAO;
import dao.PartenaireDAO;

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

import projetjob.Main;


public class JeuneTableviewcontroller {
	
	
	
    @FXML
    private TableView<Offre> tableOffre;
    
    @FXML
    private TableColumn<Offre, Integer> id;
    
    @FXML
    private TableColumn<Offre, String> type_contrat;
    
    @FXML
    private TableColumn<Offre, String> emploi;
    
    @FXML
    private Button retourBtn;    
    
  
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
    }
   
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

    
}