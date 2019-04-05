/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author king9
 */
public class Jeune {
     private IntegerProperty  idjeune;
    
     private StringProperty login; 
     private StringProperty nom; 
     private StringProperty prenom; 
     private StringProperty jeune_mdp; 
     
     
     public Jeune() {

    this.idjeune = new SimpleIntegerProperty();
    this.login= new SimpleStringProperty();
    this.nom= new SimpleStringProperty();
    this.prenom = new SimpleStringProperty();
    this.jeune_mdp = new SimpleStringProperty();
   
}   

    public IntegerProperty getIdjeuneProp() {
        return idjeune;
    }

    public void setIdjeunePro(IntegerProperty idjeune) {
        this.idjeune = idjeune;
    }

    public StringProperty getLoginProperty() {
        return login;
    }

    public void setLogin(StringProperty login) {
        this.login = login;
    }

    public StringProperty getNomProperty() {
        return nom;
    }

    public void setNom(StringProperty nom) {
        this.nom = nom;
    }

    public StringProperty getPrenomProperty() {
        return prenom;
    }

    public void setPrenom(StringProperty prenom) {
        this.prenom = prenom;
    }

    public StringProperty getJeune_mdpProperty() {
        return jeune_mdp;
    }

    public void setJeune_mdp(StringProperty jeune_mdp) {
        this.jeune_mdp = jeune_mdp;
    }

    
    
    public int getIdjeune() {
        return idjeune.get();
    }
    public void setIdjeune(int idformation) {
        this.idjeune.set(idformation);
    }
    
    public String getLogin() {
        return login.get();
    }
    public void setLogin(String login) {
        this.login.set(login);
    }
      
    public String getNom() {
        return nom.get();
    }
    public void setNom(String nom) {
        this.nom.set(nom);
    }
    
    public String getPrenom() {
        return prenom.get();
    }
    public void setPrenom(String prenom) {
        this.prenom.set(prenom);
    }
    public String getJeune_mdp() {
        return jeune_mdp.get();
    }
    public void setJeune_mdp(String jeune_mdp) {
        this.jeune_mdp.set(jeune_mdp);
    }
    
    @Override
    public String toString() {
        return "Jeune{" + "idjeune=" + idjeune +", login=" + login + ", nom=" + nom + ", prenom=" + prenom + ", jeune_mdp=" + jeune_mdp + '}';
    }
     
     
     
     
}
