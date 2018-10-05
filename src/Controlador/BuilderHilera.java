/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Alfabeto;

/**
 *
 * @author Meli
 */
public abstract class BuilderHilera {
    protected String hilera;
    protected Alfabeto alfabeto;

    public BuilderHilera(Alfabeto alfabeto) {
        this.alfabeto = alfabeto;
        hilera = "";
    }       
    
    public String getHilera(){
        return hilera;
    }
    public abstract void BuildHilera(int largo);
    
}
