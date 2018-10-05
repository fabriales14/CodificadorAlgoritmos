/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Alfabeto;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Meli
 */
public class noConNoDup extends BuilderHilera{

    public noConNoDup(Alfabeto alfabeto) {
        super(alfabeto);
    }

    @Override
    public void BuildHilera(int largo) {
        
        String simbolosDisponibles = super.alfabeto.getSimbolos();
        
        if(largo > simbolosDisponibles.length())
            return;
        
        if(!ponerCaracter(largo, simbolosDisponibles))//si no logra crear una hilera
            hilera = "";
        
    }
    
    private boolean ponerCaracter(int largo, String simbolosDisponibles){
        
        Random rand = new Random();
        String simbolosError = ""; //lista de simbolos que no se han podido poner

        
        while(!simbolosDisponibles.equals("")){ //mientras hayan opciones disponibles
            //saco un random
            int randomIndex = rand.nextInt(simbolosDisponibles.length());

            //busco el char que es
            char newChar = simbolosDisponibles.charAt(randomIndex);

            //no puede ser duplicado porque no estaría en la lista de simbolosDisponibles
            //verifico que no sea consecuitivo del ultimo, si no es el primer simbolo
            if(hilera != ""){
                if(!alfabeto.esConsecutivo(hilera.charAt(hilera.length()-1), newChar)){
                    //si no es consecutivo, se pone en la hilera
                    hilera += newChar;
                }else{
                    //si sí es consecutivo, se tiene que poner en los simbolos que dan error                    
                    simbolosError += newChar;
                    
                    //se quita de los simbolos disponibles
                    simbolosDisponibles = simbolosDisponibles.replace(String.valueOf(newChar), "");
                                  
                    continue; //sigue buscando una opción que funcione
                }              
                
            }else{
                hilera += newChar;
            }
            //verifica si ya terminó
            if(hilera.length() == largo)
                return true;

            //se quita de los simbolos disponibles
            simbolosDisponibles = simbolosDisponibles.replace(String.valueOf(newChar), "");
                    
            //intenta poner el siguiente caracter
            boolean termina = ponerCaracter(largo, simbolosDisponibles+simbolosError);
                    
            if(termina)
               return true;
                
            
        }      

        //ya no hay opciones disponibles para esa posición
        
        return false;
    }
    
}
