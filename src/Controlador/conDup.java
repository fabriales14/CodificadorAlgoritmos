/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Alfabeto;
import java.util.Random;

/**
 *
 * @author Meli
 */
public class conDup extends BuilderHilera{

    public conDup(Alfabeto alfabeto) {
        super(alfabeto);
    }

    @Override
    public void BuildHilera(int largo) {

        Random rand = new Random();
        
        int cantSimbolos = super.alfabeto.cantidadSimbolos();
        
        for(int i = 0; i < largo; i++){
            
            int randomIndex = rand.nextInt(cantSimbolos);
            
            char newChar = super.alfabeto.getSimboloAt(randomIndex);
            
            super.hilera += newChar;
        }

    }
    
}
