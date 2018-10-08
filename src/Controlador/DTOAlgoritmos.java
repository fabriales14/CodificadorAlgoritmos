/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.ArrayList;
import libcomp.Alfabeto;

/**
 *
 * @author Meli
 */
public class DTOAlgoritmos {
   
    int selectedAlfabeto;
    String entrada;
    ArrayList<String> salida;
    ArrayList<Integer> tipos_salida; // {}
    boolean codificacion;
    int extension;
    ArrayList<Alfabeto> alfabetos;
    int selectedMezcla;
    ArrayList<String> tipos_algoritmos;
    ArrayList<String> tipos_salidas;
    int alg_vigenere;
    String palabra_clave;
    boolean generar;
    
    public  DTOAlgoritmos(ArrayList<Alfabeto> alfabetos, String entrada, ArrayList<String> tipos_algoritmos,
            ArrayList<Integer> tipos_salida, boolean codificacion, int extension, int selectedAlfabeto,int selectedMezcla,
            int alg_vigenere, String palabra_clave) {
        // Datos cliente -servidor
        this.alfabetos = alfabetos;
        this.entrada = entrada;
        this.tipos_algoritmos = tipos_algoritmos;
        this.tipos_salida = tipos_salida;
        this.codificacion = codificacion;
        this.extension = extension;
        this.selectedAlfabeto = selectedAlfabeto;
        this.selectedMezcla = selectedMezcla;
        this.alg_vigenere = alg_vigenere;
        this.palabra_clave = palabra_clave;
        this.salida = new ArrayList<>();
    }
    public DTOAlgoritmos(ArrayList<Alfabeto> alfabetos, ArrayList<String> tipos_salidas,ArrayList<String> tipos_algoritmos,
            ArrayList<String> salida){
        //Datos servidor - cliente
        this.alfabetos = alfabetos;
        this.tipos_algoritmos = tipos_algoritmos;
        this.tipos_salidas = tipos_salidas;
        this.salida = salida;
    }
    
    public DTOAlgoritmos(int selectedMezcla, int extension, Alfabeto alfabeto){
        this.selectedMezcla = selectedMezcla;
        this.alfabetos = new ArrayList<>();
        this.alfabetos.add(alfabeto);
        this.salida = new ArrayList<>();
        this.extension = extension;
    }

    public void setGenerar(boolean generar) {
        this.generar = generar;
    }

    public boolean isGenerar() {
        return generar;
    }
    
    
    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public ArrayList<String> getSalida() {
        return salida;
    }

    public void setSalida(ArrayList<String> salida) {
        this.salida = salida;
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

    public int getExtension() {
        return extension;
    }

    public void setExtension(int extension) {
        this.extension = extension;
    }

    public int getSelectedAlfabeto() {
        return selectedAlfabeto;
    }

    public void setSelectedAlfabeto(int selectedAlfabeto) {
        this.selectedAlfabeto = selectedAlfabeto;
    }

    public ArrayList<Alfabeto> getAlfabetos() {
        return alfabetos;
    }

    public void setAlfabetos(ArrayList<Alfabeto> alfabetos) {
        this.alfabetos = alfabetos;
    }

    public int getSelectedMezcla() {
        return selectedMezcla;
    }

    public void setSelectedMecla(int selectedMecla) {
        this.selectedMezcla = selectedMecla;
    }

    public ArrayList<String> getTipos_algoritmos() {
        return tipos_algoritmos;
    }

    public void setTipos_algoritmos(ArrayList<String> tipos_algoritmos) {
        this.tipos_algoritmos = tipos_algoritmos;
    }

    public ArrayList<String> getTipos_salidas() {
        return tipos_salidas;
    }

    public void setTipos_salidas(ArrayList<String> tipos_salidas) {
        this.tipos_salidas = tipos_salidas;
    }

    public int getAlg_vigenere() {
        return alg_vigenere;
    }

    public void setAlg_vigenere(int alg_vigenere) {
        this.alg_vigenere = alg_vigenere;
    }

    public String getPalabra_clave() {
        return palabra_clave;
    }

    public void setPalabra_clave(String palabra_clave) {
        this.palabra_clave = palabra_clave;
    }
}
