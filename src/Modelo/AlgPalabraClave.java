/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Bryan
 */
public class AlgPalabraClave extends StrategyAlgoritmo{
    String Palabra_Clave = "";

    public void setPalabra_Clave(String Palabra_Clave) {
        this.Palabra_Clave = Palabra_Clave;
    }
    
    public String codificar(String mensaje, libcomp.Alfabeto alfabeto) {
        String result = "";
        String simbolos = alfabeto.getSimbolos();
        List<String> palabras = new ArrayList<>(Arrays.asList(mensaje.split(" ")));
        
        for (String palabra : palabras){
            for (int i=0; i<palabra.length(); i++){
                for (int j=0; j<Palabra_Clave.length(); j++){
                    int pos = simbolos.indexOf(palabra.charAt(i))+1 + simbolos.indexOf(Palabra_Clave.charAt(j))+1;
                    if (pos > simbolos.length()){
                        pos -= simbolos.length();
                    }
                    result += getCharAt(pos, simbolos);
                    i++;
                    if (i >= palabra.length()){
                        j = Palabra_Clave.length();
                    }
                } i--;
            } result += " "; 
        }
        return result;
    }
    
    public char getCharAt(int index, String simbolos){
        return simbolos.charAt(index-1);
    }

    public String decodificar(String mensaje, libcomp.Alfabeto alfabeto) {
        String result = "";
        String simbolos = alfabeto.getSimbolos();
        List<String> palabras = new ArrayList<>(Arrays.asList(mensaje.split(" ")));
        
        for (String palabra : palabras){
            for (int i=0; i<palabra.length(); i++){
                for (int j=0; j<Palabra_Clave.length(); j++){
                    int pos = (simbolos.indexOf(palabra.charAt(i))+1) - (simbolos.indexOf(Palabra_Clave.charAt(j))+1);
                    if (pos <= 0){
                        pos += simbolos.length();
                    }
                    result += getCharAt(pos, simbolos);
                    i++;
                    if (i >= palabra.length()){
                        j = Palabra_Clave.length();
                    }
                } i--;
            } result += " "; 
        }
        return result;
    }
    
//        List<String> listaLetras = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q","r","s","t","u","v","w","x","y","z"," ");        
    
    public int obtenerNumeroLetra(String letra){        
        List<String> listaLetras = Arrays.asList("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z");
        int[] listaNumero = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26};
        int index = listaLetras.indexOf(letra);
        return listaNumero[index];
    }
    
    public String textoLetra(int numero){ //funcion que sirve para convertir el número en la letra que corresponde
        List<String> listaLetras = Arrays.asList("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z");                
        return listaLetras.get(numero-1);
    }

    @Override
    public String procesar(String mensaje, libcomp.Alfabeto alfabeto, boolean codificar) {
        if (codificar){
            return codificar(mensaje,alfabeto);
        }return decodificar(mensaje, alfabeto);
    }
}
