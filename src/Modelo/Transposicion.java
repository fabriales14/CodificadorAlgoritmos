/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.swing.JOptionPane;

/**
 *
 * @author Meli
 */
public class Transposicion extends Algoritmo{

    @Override
    public String codificar(String mensaje, Alfabeto alfabeto) {
        String result = "";
        String[] palabras = mensaje.split(" ");
        
        for(String m : palabras){
            String palabraVuelta = new StringBuilder(m).reverse().toString();
            result = result + palabraVuelta + " ";
        }
        
        System.out.println(result);
        JOptionPane.showMessageDialog(null, result);
        return result;
    }
    
    public String tomaPalabra(String frase){
        return null;
    }
    
    public boolean es1palabra(String frase){
        return true;
    }

    @Override
    public String decodificar(String mensaje, Alfabeto alfabeto) {
        String result = "";
        String[] palabras = mensaje.split(" ");
        
        for(String m : palabras){
            String palabraVuelta = new StringBuilder(m).reverse().toString();
            result = result + palabraVuelta + " ";
        }
        
        System.out.println(result);
        JOptionPane.showMessageDialog(null, result);
        return result;
    }
    
}
