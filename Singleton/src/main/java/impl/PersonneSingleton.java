package impl;

import annotations.Singleton;
import interfaces.IPersonne;

@Singleton
public class PersonneSingleton implements IPersonne {

    private String nom;

    @Override
    public String getNom(){
            return nom;
        }

    @Override
    public void setNom(String nom_){
            this.nom = nom_;
        }

}
