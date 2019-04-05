/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.sql.Date;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author king9
 */
public class Offre {
    private IntegerProperty  idoffre;
    private StringProperty type_contrat; 
    private StringProperty emploi;
    private IntegerProperty  idpartenaire;
   
    private ObjectProperty<Date> creationOffre;


public Offre() {

   this.idoffre = new SimpleIntegerProperty();
   this.type_contrat= new SimpleStringProperty();
   this.emploi= new SimpleStringProperty();
   this.idpartenaire = new SimpleIntegerProperty();
   this.creationOffre = new SimpleObjectProperty<Date>();  
   
}   


    

    public void setIdoffre(IntegerProperty idoffre) {
        this.idoffre = idoffre;
    }
    
    public IntegerProperty getIdoffreProp() {
        return idoffre;
    }
    
    public void setCreationOffre(ObjectProperty<Date> creationOffre){
        this.creationOffre = creationOffre;
    }
    public ObjectProperty<Date> getCreationOffre(){
        return creationOffre;
    }
    
    public void setType_contrat(StringProperty type_contrat) {
        this.type_contrat = type_contrat;
    }
    public StringProperty getType_contratProperty() {
        return type_contrat;
    }

    public void setEmploi(StringProperty emploi) {
        this.emploi = emploi;
    }
    public StringProperty getEmploiProperty() {
        return emploi;
    }
    
    public IntegerProperty getIdpartenaireProp() {
        return idpartenaire;
    }
    public void setIdpartenaire(IntegerProperty idpartenaire) {
        this.idpartenaire = idpartenaire;
    }
    
    public int getIdoffre() {
        return idoffre.get();
    }
    public void setIdoffre(int idoffre) {
        this.idoffre.set(idoffre);
    }
    
    public String getType_contrat() {
        return type_contrat.get();
    }
    public void setType_contrat(String type_contrat) {
        this.type_contrat.set(type_contrat);
    }
    
    public String getEmploi() {
        return emploi.get();
    }
    public void setEmploi(String emploi) {
        this.emploi.set(emploi);
    }
  
    
public int getIdpartenaire() {
    return idpartenaire.get();
}
public void setIdpartenaire(int idpartenaire) {
    this.idpartenaire.set(idpartenaire);
}
   
    
    

    @Override
    public String toString() {
        return "Offre{" + "idoffre=" + idoffre + ", type_contrat=" + type_contrat + ", emploi=" + emploi + ", idpartenaire=" + idpartenaire + '}';
    }
    
}

