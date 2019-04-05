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

import javax.print.attribute.HashAttributeSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import metier.Administrateur;
import metier.Offre;

/**
 *
 * @author king9
 */
public class AdministrateurDAO {
    
    public static Boolean adminconnect(int siret,String mdp ) throws ClassNotFoundException, SQLException
    { 
       System.out.println("ghjgjh");
        
        Connection cnx = Connect.getInstance().getConnection();
        String req= "select * from administrateur where administrateur_siret=? and administrateur_mdp=?";
 
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
    
      public static ObservableList<Administrateur> getAllAdministrateurs() throws ClassNotFoundException, SQLException{
    
    
    
        	 ObservableList<Administrateur> AdministrateurList = FXCollections.observableArrayList();

                 // constitution d'une commande basée sur une requête SQL 
             // en vue d'être exécutée sur une connexion donnée     
             String req = "select * from administrateur";
             Connection cnx = Connect.getInstance().getConnection();
           int idadministrateur ;
           int administrateur_siret ;
           String administrateur_mdp ;
          
             PreparedStatement pst = cnx.prepareStatement(req);
             

             ResultSet adr = pst.executeQuery();
             while(adr.next()){
            	 idadministrateur = adr.getInt("idadministrateur");
            	 administrateur_siret = adr.getInt("administrateur_siret");
            	 administrateur_mdp = adr.getString("administrateur_mdp");
                
                 
            	  Administrateur administrateur = new Administrateur();
            	 administrateur.setIdadministrateur(idadministrateur);
            	 administrateur.setAdministrateur_siret(administrateur_siret);
            	 administrateur.setAdministrateur_mdp(administrateur_mdp);
                

            	 AdministrateurList.add(administrateur);
            	 
             }
             adr.close();
             pst.close();
             cnx.close();
             return AdministrateurList;
         
    }
      
  	public static int ajoutadmin(Administrateur administrateur) throws SQLException, ClassNotFoundException {
        assert administrateur!= null;
        
        Connection cnx = Connect.getInstance().getConnection();
        //Statement st = null;
        PreparedStatement pst = null;
        int nblignes = 0;
//        st = cnx.createStatement();

        /*String requeteSQL = "insert into client values ('hhh', '1234567', 'eazea', '94000', 'massy')";*/
        String requeteSQL = "INSERT INTO administrateur (administrateur_siret, administrateur_mdp) values(?, ?)";

        System.out.println("beforexecute");
        pst = cnx.prepareStatement(requeteSQL);
    
        pst.setInt(1, administrateur.getAdministrateur_siret());
        pst.setString(2,  administrateur.getAdministrateur_mdp());
       
            
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
