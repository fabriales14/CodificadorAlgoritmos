/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import libcomp.Alfabeto;
import java.util.Random;

/**
 *
 * @author Meli
 */
public class conNoDup extends BuilderHilera{

    public conNoDup(Alfabeto alfabeto) {
        super(alfabeto);
    }

    @Override
    public void BuildHilera(int largo) {

        Random rand = new Random();
        int cantSimbolos = super.alfabeto.cantidadSimbolos();
        
        if(largo > cantSimbolos)
            return;
        
        
        //hilera de los simbolos que siguen disponibles
        String simbolosDisponibles = super.alfabeto.getSimbolos();
        
        for(int i = 0; i < largo; i++){
            int randomIndex = rand.nextInt(cantSimbolos);
            
            char newChar = simbolosDisponibles.charAt(randomIndex);
            
            super.hilera += newChar;
            
            cantSimbolos--;
            
            simbolosDisponibles = simbolosDisponibles.replace(String.valueOf(newChar), "");
            
        }
        
    }
    
}
