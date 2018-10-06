

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import libcomp.Alfabeto;

/**
 *
 * @author Meli
 */
public abstract class StrategyAlgoritmo {
    
    public abstract String procesar(String mensaje, Alfabeto alfabeto, boolean codificar);
    
}
