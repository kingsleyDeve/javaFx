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
import metier.Jeune;
import metier.Partenaire;

/**
 *
 * @author king9
 */
public class JeuneDAO {
	
	public static Boolean jeuneconnect(String login, String mdp ) throws ClassNotFoundException, SQLException
    { 
       System.out.println("ghjgjh");
        
        Connection cnx = Connect.getInstance().getConnection();
        String req= "select * from jeune where login=? and jeune_mdp=?";
        PreparedStatement pst= cnx.prepareStatement(req);
        pst.setString(1,login);
        pst.setString(2,mdp);
       
        ResultSet res = pst.executeQuery();
        System.out.println(res);
    
        while (res.next())
         {  return true ; }
        
        cnx.close();
        pst.close();
        return false;
    }
    
    
    public static ObservableList<Jeune> getAllJeunes() throws ClassNotFoundException, SQLException{
    
    
        	 ObservableList<Jeune> UserList = FXCollections.observableArrayList();
             // constitution d'une commande basée sur une requête SQL 
             // en vue d'être exécutée sur une connexion donnée     
             String req = "select * from jeune";
             Connection cnx = Connect.getInstance().getConnection();
           int idjeune ;
           String nom ;
           String prenom ;
             PreparedStatement pst = cnx.prepareStatement(req);
             

             ResultSet jeu = pst.executeQuery();
             while(jeu.next()){
            	 idjeune = jeu.getInt("idjeune");
            	 nom = jeu.getString("nom");
            	 prenom = jeu.getString("prenom");
            	  Jeune user = new Jeune();
            	 user.setIdjeune(idjeune);
            	 user.setNom(nom);
            	 user.setPrenom(prenom);
            	 UserList.add(user);
            	 
             }
             jeu.close();
             pst.close();
             cnx.close();
             return UserList;
         
    }
    
    public static int ajoutjeune(Jeune jeune) throws SQLException, ClassNotFoundException {
        assert jeune!= null;
        
        Connection cnx = Connect.getInstance().getConnection();
        //Statement st = null;
        PreparedStatement pst = null;
        int nblignes = 0;
//        st = cnx.createStatement();

        /*String requeteSQL = "insert into client values ('hhh', '1234567', 'eazea', '94000', 'massy')";*/
        String requeteSQL = "INSERT INTO jeune (login, jeune_mdp, nom, prenom) values(?, ?, ?, ?)";

        System.out.println("beforexecute");
        pst = cnx.prepareStatement(requeteSQL);
    
        pst.setString(1, jeune.getLogin());
        pst.setString(2, jeune.getJeune_mdp());
        pst.setString(3, jeune.getNom());
        pst.setString(4, jeune.getPrenom());
            
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
