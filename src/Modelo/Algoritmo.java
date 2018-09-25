/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Meli
 */
public abstract class Algoritmo {
    
    public abstract String codificar(String mensaje, Alfabeto alfabeto);
    
    public abstract String decodificar(String mensaje, Alfabeto alfabeto);
    
}
