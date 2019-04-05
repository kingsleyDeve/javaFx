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
public class Partenaire {
private IntegerProperty  idpartenaire;
private IntegerProperty partenaire_siret;
private StringProperty partenaire_mdp;
private StringProperty partenaire_nom;
private IntegerProperty idadresse;
private IntegerProperty idoffre;

public Partenaire() {

    this.idpartenaire = new SimpleIntegerProperty();
   this.partenaire_siret= new SimpleIntegerProperty();
   this.partenaire_mdp= new SimpleStringProperty();
   this.partenaire_nom= new SimpleStringProperty();
    this.idadresse = new SimpleIntegerProperty();
   

    
   
}   

    public IntegerProperty getIdpartenaireProp() {
        return idpartenaire;
    }

    public void setIdpartenaire(IntegerProperty idpartenaire) {
        this.idpartenaire = idpartenaire;
    }
    
    

    public IntegerProperty getPartenaire_siretProp() {
        return partenaire_siret;
    }

    public void setPartenaire_siret(IntegerProperty partenaire_siret) {
        this.partenaire_siret = partenaire_siret;
    }

    public StringProperty getPartenaire_mdpProperty() {
        return partenaire_mdp;
    }

    public void setPartenaire_mdp(StringProperty partenaire_mdp) {
        this.partenaire_mdp = partenaire_mdp;
    }

    public StringProperty getPartenaire_nomProperty() {
        return partenaire_nom;
    }

    public void setPartenaire_nom(StringProperty partenaire_nom) {
        this.partenaire_nom = partenaire_nom;
    }
    
    public IntegerProperty getIdadresseProp() {
        return idadresse;
    }

    public void setIdadresse(IntegerProperty idadresse) {
        this.idadresse = idadresse;
    }

    
    
    public int getIdpartenaire() {
        return idpartenaire.get();
    }
    public void setIdpartenaire(int idpartenaire) {
        this.idpartenaire.set(idpartenaire);
    }
    
    public int getPartenaire_siret() {
        return partenaire_siret.get();
    }
    public void setPartenaire_siret(int partenaire_siret) {
        this.partenaire_siret.set(partenaire_siret);
    }
    
    public String getPartenaire_mdp() {
        return partenaire_mdp.get();
    }
    public void setPartenaire_mdp(String partenaire_mdp) {
        this.partenaire_mdp.set(partenaire_mdp);
    }
    
    public String getPartenaire_nom() {
        return partenaire_nom.get();
    }
    public void setPartenaire_nom(String partenaire_nom) {
        this.partenaire_nom.set(partenaire_nom);
    }
    
public int getIdadresse() {
    return idadresse.get();
}
public void setIdadresse(int idadresse) {
    this.idadresse.set(idadresse);
}

    

    @Override
    public String toString() {
        return "Partenaire{" + "idpartenaire=" + idpartenaire + ", partenaire_siret=" + partenaire_siret + ", partenaire_mdp=" + partenaire_mdp + ", partenaire_nom=" + partenaire_nom +'}';
    }

}