package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import classe.Partenaire;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import metier.Offre;
import metier.Utilisateur;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this tofflate file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import metier.Offre;

/**
 *
 * @author king9
 */

public class OffreDAO {


     public static ObservableList<Offre> getAllOffres() throws ClassNotFoundException, SQLException{
    
    
    
        	 ObservableList<Offre> OffreList = FXCollections.observableArrayList();
             // constitution d'une commande basée sur une requête SQL 
             // en vue d'être exécutée sur une connexion donnée     
             String req = "select * from offre";
             Connection cnx = Connect.getInstance().getConnection();
           int id ;
           String type_contrat;
           String emploi; 
          
           
             PreparedStatement pst = cnx.prepareStatement(req);
             

             ResultSet off = pst.executeQuery();
             while(off.next()){
            	 id = off.getInt("idoffre");
            	 type_contrat = off.getString("type_contrat");
            	 emploi = off.getString("emploi");
         
               
                         
            	 Offre offre = new Offre();
            	 offre.setIdoffre(id);
            	 offre.setType_contrat(type_contrat);
            	 offre.setEmploi(emploi);
                 
             
            	 OffreList.add(offre);
            	 
             }
             off.close();
             pst.close();
             cnx.close();
             return OffreList;
             
    
}
           
     
    
     
  
  
       
     
     public static int supprimerOffre(Offre offre) throws SQLException, ClassNotFoundException {
	        assert offre!= null;

	        Connection cnx = Connect.getInstance().getConnection();
	      
          

	        int nblignes = 0;

	        String req = "delete FROM offre where idoffre=?";
	        
	        
	        PreparedStatement pst= cnx.prepareStatement(req);
    
	        pst = cnx.prepareStatement(req);
	    
	        pst.setInt(1, offre.getIdoffre());
	       
             
	        try {
	            nblignes = pst.executeUpdate();
	        } catch (SQLException ex) {
	            System.out.println(ex.getMessage());
	        }
	        pst.close();
	        cnx.close();
	        return nblignes;

	    }
     

	public static int ajoutoffre(Offre offre) throws SQLException, ClassNotFoundException {
        assert offre!= null;
        
        Connection cnx = Connect.getInstance().getConnection();
        //Statement st = null;
        PreparedStatement pst = null;
        int nblignes = 0;
//        st = cnx.createStatement();

        /*String requeteSQL = "insert into client values ('hhh', '1234567', 'eazea', '94000', 'massy')";*/
        String requeteSQL = "INSERT INTO offre (type_contrat, emploi) values(?, ?)";

        System.out.println("beforexecute");
        pst = cnx.prepareStatement(requeteSQL);
    
        pst.setString(1, offre.getType_contrat());
        pst.setString(2, offre.getEmploi());
       
            
        try {
            nblignes = pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        pst.close();
        cnx.close();
        return nblignes;

    }
     
	public static void majoffre(Offre offre) throws SQLException, ClassNotFoundException {
        assert offre!= null;
        
        Connection cnx = Connect.getInstance().getConnection();
        //Statement st = null;
        PreparedStatement pst = null;
       
//        st = cnx.createStatement();

        /*String requeteSQL = "insert into client values ('hhh', '1234567', 'eazea', '94000', 'massy')";*/
        String requeteSQL = "update offre set type_contrat= ?, emploi= ? where idoffre= ?";

        System.out.println("beforexecute");
        pst = cnx.prepareStatement(requeteSQL);
    
        pst.setString(1, offre.getType_contrat());
        pst.setString(2, offre.getEmploi());
        pst.setInt(3, offre.getIdoffre());
            
        try {
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      

    }
     
	

     
}