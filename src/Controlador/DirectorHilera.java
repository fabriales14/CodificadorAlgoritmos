/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author Meli
 */
public class DirectorHilera {
    private BuilderHilera builder;

    public DirectorHilera(BuilderHilera builder) {
        this.builder = builder;
    }
    
    public void BuildHilera(int largo){
        builder.BuildHilera(largo);
    }
    
    public String getHilera(){
        return builder.getHilera();
    }    
    
}
