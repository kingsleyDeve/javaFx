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
public class Administrateur {
 
    private IntegerProperty  idadministrateur;
    private IntegerProperty administrateur_siret; 
    private StringProperty administrateur_mdp; 
   
    
    public Administrateur() {

    this.idadministrateur = new SimpleIntegerProperty();
   this.administrateur_siret= new SimpleIntegerProperty();
   this.administrateur_mdp= new SimpleStringProperty();
    
}   

    public IntegerProperty getIdadministrateurProp() {
        return idadministrateur;
    }

    public void setIdadministrateur(IntegerProperty idadministrateur) {
        this.idadministrateur = idadministrateur;
    }

    public IntegerProperty getAdministrateur_siretProp() {
        return administrateur_siret;
    }

    public void setAdministrateur_siret(IntegerProperty administrateur_siret) {
        this.administrateur_siret = administrateur_siret;
    }

    public StringProperty getAdministrateur_mdpProperty() {
        return administrateur_mdp;
    }

    public void setAdministrateur_mdp(StringProperty administrateur_mdp) {
        this.administrateur_mdp = administrateur_mdp;
    }

    

   
    public int getIdadministrateur() {
        return idadministrateur.get();
    }
    public void setIdadministrateur(int idadministrateur) {
        this.idadministrateur.set(idadministrateur);
    }
    
    public int getAdministrateur_siret() {
        return administrateur_siret.get();
    }
    public void setAdministrateur_siret(int administrateur_siret) {
        this.administrateur_siret.set(administrateur_siret);
    }
    
    public String getAdministrateur_mdp() {
        return administrateur_mdp.get();
    }
    public void setAdministrateur_mdp(String administrateur_mdp) {
        this.administrateur_mdp.set(administrateur_mdp);
    }
    
  
    @Override
    public String toString() {
        return "Administrateur{" + "idadministrateur=" + idadministrateur + ", administrateur_siret=" + administrateur_siret + ", administrateur_mdp=" + administrateur_mdp + '}';
    }
    
    
}
