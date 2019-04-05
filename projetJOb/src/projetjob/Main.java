/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjob;


//import dao.OffreDAO;
import dao.PartenaireDAO;
import java.io.IOException;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


/**
 *
 * @author king9
 */

public class Main extends Application 
{
    private Stage       primaryStage;
    private AnchorPane  rootL;
    
    @Override
    public void start(Stage primaryStage)
    {
        primaryStage.setTitle("Kingsley");
        this.primaryStage = primaryStage;
        
        
        try
        {
            FXMLLoader acc = new FXMLLoader();
            acc.setLocation(Main.class.getClassLoader().getResource("view/menu.fxml"));
            rootL = (AnchorPane)acc.load();
            Scene scene = new Scene(rootL);
            this.primaryStage.setScene(scene);
            this.primaryStage.show();
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }
}

/*
public class Ppebts {
  
 public static void main(String[] args) throws ClassNotFoundException, SQLException{
     
 /*    ObservableList<Jeune> listeJeune = JeuneDAO.getAllJeunes();
             for(Jeune jeune1 : listeJeune )
                 System.out.println(jeune1);
 
 ObservableList<Adresse> listeAdresse = AdresseDAO.getAllAdresses();
             for(Adresse adresse1 : listeAdresse )
                 System.out.println(adresse1);
 
  ObservableList<Offre> listeOffre = OffreDAO.getAllOffres();
             for(Offre offre1 : listeOffre )
                 System.out.println(offre1);
 
  ObservableList<Administrateur> listeAdministrateur = AdministrateurDAO.getAllAdministrateurs();
             for(Administrateur admin : listeAdministrateur )
                 System.out.println(admin);
    
              ObservableList<Formation> listeFormation = FormationDAO.getAllFormations();
             for(Formation form : listeFormation )
                 System.out.println(form);
 
 ObservableList<Partenaire> listePartenaire = PartenaireDAO.getAllPartenaires();
             for(Partenaire part : listePartenaire )
                 System.out.println(part);
 
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("views/connection.fxml"));
            AnchorPane AnchorPane_Clients = (AnchorPane) loader.load();
//          BorderPane mainFrame = (BorderPane) loader.load();
            Stage stage =  (Stage) bt_AccueilClient.getScene().getWindow();
            Scene scene = bt_AccueilClient.getScene();
            scene.setRoot(AnchorPane_Clients);
            stage.setScene(scene);
    }   
}
*/