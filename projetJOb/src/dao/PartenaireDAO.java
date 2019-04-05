/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import metier.Administrateur;
import metier.Offre;
import metier.Partenaire;

/**
 *
 * @author king9
 */
public class PartenaireDAO {
	
	 public static Boolean partconnect(int siret,String mdp ) throws ClassNotFoundException, SQLException
	    { 
	       System.out.println("ghjgjh");
	        
	        Connection cnx = Connect.getInstance().getConnection();
	        String req= "select * from partenaire where partenaire_siret=? and partenaire_mdp=?";
	        PreparedStatement pst= cnx.prepareStatement(req);
	        pst.setInt(1,siret);
	        pst.setString(2,mdp);
	       
	        ResultSet res = pst.executeQuery();
	        System.out.println(res);
	    
	        while (res.next())
	         {  return true ; }
	        
	        cnx.close();
	        pst.close();
	        return false;
	    }
    
      public static ObservableList<Partenaire> getAllPartenaires() throws ClassNotFoundException, SQLException{
    
    
    
        	 ObservableList<Partenaire> PartenaireList = FXCollections.observableArrayList();
             // constitution d'une commande basée sur une requête SQL 
             // en vue d'être exécutée sur une connexion donnée     
             String req = "select * from partenaire";
             Connection cnx = Connect.getInstance().getConnection();
           int idpartenaire ;
           String partenaire_mdp;
           int partenaire_siret;
           String partenaire_nom;
           
             PreparedStatement pst = cnx.prepareStatement(req);
             ResultSet par = pst.executeQuery();
             while(par.next()){
            	 idpartenaire = par.getInt("idpartenaire");
            	 partenaire_siret = par.getInt ("partenaire_siret");
            	 partenaire_mdp = par.getString("partenaire_mdp");
            	 partenaire_nom = par.getString("partenaire_nom");
       
                         
            	  Partenaire partenaire = new Partenaire();
            	 partenaire.setIdpartenaire(idpartenaire);
            	 partenaire.setPartenaire_siret(partenaire_siret);
            	 partenaire.setPartenaire_mdp(partenaire_mdp);
            	 partenaire.setPartenaire_nom(partenaire_nom);
            	 PartenaireList.add(partenaire);
            	 
             }
             par.close();
             pst.close();
             cnx.close();
             return PartenaireList;
    
    
}
      
      
    	public static int ajoutpartenaire(Partenaire partenaire) throws SQLException, ClassNotFoundException {
          assert partenaire!= null;
          
          Connection cnx = Connect.getInstance().getConnection();
          //Statement st = null;
          PreparedStatement pst = null;
          int nblignes = 0;
//          st = cnx.createStatement();

          /*String requeteSQL = "insert into client values ('hhh', '1234567', 'eazea', '94000', 'massy')";*/
          String requeteSQL = "INSERT INTO partenaire (partenaire_siret, partenaire_mdp, partenaire_nom) values(?, ?, ?)";

          System.out.println("beforexecute");
          pst = cnx.prepareStatement(requeteSQL);
      
          pst.setInt(1, partenaire.getPartenaire_siret());
          pst.setString(2, partenaire.getPartenaire_mdp());
          pst.setString(3, partenaire.getPartenaire_nom());
              
          try {
              nblignes = pst.executeUpdate();
          } catch (SQLException ex) {
              System.out.println(ex.getMessage());
          }
          pst.close();
          cnx.close();
          return nblignes;

      }
    	
    	 public static int supprimerPartenaire(Partenaire partenaire) throws SQLException, ClassNotFoundException {
 	        assert partenaire!= null;

 	        Connection cnx = Connect.getInstance().getConnection();
 	      
           

 	        int nblignes = 0;

 	        String req = "delete FROM partenaire where idpartenaire=?";
 	        
 	        
 	        PreparedStatement pst= cnx.prepareStatement(req);
     
 	        pst = cnx.prepareStatement(req);
 	    
 	        pst.setInt(1, partenaire.getIdpartenaire());
 	       
              
 	        try {
 	            nblignes = pst.executeUpdate();
 	        } catch (SQLException ex) {
 	            System.out.println(ex.getMessage());
 	        }
 	        pst.close();
 	        cnx.close();
 	        return nblignes;

 	    }
}
