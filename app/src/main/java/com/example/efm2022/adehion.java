package com.example.efm2022;

import java.io.Serializable;

public class adehion implements Serializable {
    private  int code;
 private  String nom;
 private  String tele;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }
}
