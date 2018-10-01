/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.ArrayList;

/**
 *
 * @author Meli
 */
public class DTOAlgoritmos {
    private int alfabeto;
    private String entrada;
    private String salida;
    private ArrayList<Integer> algoritmos; // {}
    private ArrayList<Integer> tipos_salida; // {}
    private boolean codificacion;

    public DTOAlgoritmos(int alfabeto, String entrada, String salida, ArrayList<Integer> algoritmos,
            ArrayList<Integer> tipos_salida, boolean codificacion) {
        this.alfabeto = alfabeto;
        this.entrada = entrada;
        this.salida = salida;
        this.algoritmos = algoritmos;
        this.tipos_salida = tipos_salida;
        this.codificacion = codificacion;
    }

    public int getAlfabeto() {
        return alfabeto;
    }

    public void setAlfabeto(int alfabeto) {
        this.alfabeto = alfabeto;
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }

    public ArrayList<Integer> getAlgoritmos() {
        return algoritmos;
    }

    public void setAlgoritmos(ArrayList<Integer> algoritmos) {
        this.algoritmos = algoritmos;
    }

    public ArrayList<Integer> getTipos_salida() {
        return tipos_salida;
    }

    public void setTipos_salida(ArrayList<Integer> tipos_salida) {
        this.tipos_salida = tipos_salida;
    }

    public boolean isCodificacion() {
        return codificacion;
    }

    public void setCodificacion(boolean codificacion) {
        this.codificacion = codificacion;
    }
    
    
}
