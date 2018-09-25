/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.IValidable;

/**
 *
 * @author Meli
 */
public class Alfabeto implements IValidable{
    private int id;
    private String nombre;
    private String simbolos;
    private String simbolos_ignorados;

    public Alfabeto(int id, String nombre, String simbolos, String simbolos_ignorados) {
        this.id = id;
        this.nombre = nombre;
        this.simbolos = simbolos;
        this.simbolos_ignorados = simbolos_ignorados;
    }

    @Override
    public boolean validar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
