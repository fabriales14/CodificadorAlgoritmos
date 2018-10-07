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
            if (letra == ' '){
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
    
    
    /*public String codigoBin(String entrada){ //la entrada puede ser una letra o un código
        String result="";
        List<String> listaLetras= Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q","r","s","t","u","v","w","x","y","z"," ");        
        List<String> listaCode = Arrays.asList("00000 ", "00001 ", "00010 ", "00011 ", "00100 ", "00101 ", "00110 ", "00111 ", "01000 ", "01001 ", "01010 ", "01011 ", "01100 ", "01101 ",
                "01110 ", "01111 ", "10000 ","10001 ","10010 ", "10011 ","10100 ","10101 ","10110 ","10111 ","11000 ","11001 "," * ");
        if(listaCode.contains(entrada)){//si la lista tiene la letra
            int indice = listaCode.indexOf(entrada);
            //System.out.println(indice);
            result = listaLetras.get(indice);
        }
        else if(listaLetras.contains(entrada)){//si la lista tiene la letra
            int indice = listaLetras.indexOf(entrada);
            //System.out.println(indice);
            result = listaCode.get(indice);
        }
        //System.out.println(result);
        return result;
    }
    
    public String obtenerLetra(String entrada){ //la entrada puede ser una letra o un código
        String result="";
        List<String> listaLetras= Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q","r","s","t","u","v","w","x","y","z"," ");        
        List<String> listaCode = Arrays.asList("00000", "00001", "00010", "00011", "00100", "00101", "00110", "00111", "01000", "01001", "01010", "01011", "01100", "01101",
                "01110", "01111", "10000","10001","10010", "10011","10100","10101","10110","10111","11000","11001","*");
        if(listaCode.contains(entrada)){//si la lista tiene la letra
            int indice = listaCode.indexOf(entrada);
            //System.out.println(indice);
            result = listaLetras.get(indice);
        }
        else if(listaLetras.contains(entrada)){//si la lista tiene la letra
            int indice = listaLetras.indexOf(entrada);
            //System.out.println(indice);
            result = listaCode.get(indice);
        }
        return result;
    }*/

    @Override
    public String procesar(String mensaje, libcomp.Alfabeto alfabeto, boolean codificar){
        if (codificar){
            return codificar(mensaje,alfabeto);
        }return decodificar(mensaje, alfabeto);
    }
}
