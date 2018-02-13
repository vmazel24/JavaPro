package impl;

import interfaces.IPersonne;

public class PersonneNotSingleton implements IPersonne {
    private String nom;

    @Override
    public void setNom(String nom_) {
        nom = nom_;
    }

    @Override
    public String getNom() {
        return nom;
    }
}
