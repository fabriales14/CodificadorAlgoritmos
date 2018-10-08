/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Bryan
 */
public class AlgCodificacionBinaria extends StrategyAlgoritmo{  
    
    public String codificar(String mensaje, libcomp.Alfabeto alfabeto) {
        String simbolos = alfabeto.getSimbolos();
        String result="";

        for(int i=0 ; i<mensaje.length(); i++ ){
            char letra = mensaje.charAt(i);
            if (alfabeto.getSimbolos_ignorados().indexOf(letra) != -1){
                result += "* ";               
            } else {
                int index = simbolos.indexOf(letra);
                result += Integer.toBinaryString(index) + " ";
            }
        }
        return result;
    }

    public String decodificar(String mensaje, libcomp.Alfabeto alfabeto) {
        String simbolos = alfabeto.getSimbolos();
        String result="";

        List<String> binarios = new ArrayList<>(Arrays.asList(mensaje.split(" ")));

        for(String s: binarios){
            if (!"*".equals(s)){
                int number = Integer.parseInt(s, 2);
                char letra = simbolos.charAt(number);
                result += letra;
            } else {
                result += " ";
            }
        }
        return result;
    }
  
    @Override
    public String procesar(String mensaje, libcomp.Alfabeto alfabeto, boolean codificar){
        if (codificar){
            return codificar(mensaje,alfabeto);
        }return decodificar(mensaje, alfabeto);
    }
}
