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
public class CodificacionBinaria extends Algoritmo{

    @Override
    public String codificar(String mensaje, Alfabeto alfabeto) {
        String mensajito = mensaje.toLowerCase();
        String result="";

        for(int i=0 ; i<mensajito.length(); i++ ){
            result = result + codigoBin(mensajito.substring(i, i+1));
        }
        
        System.out.println(result);
        JOptionPane.showMessageDialog(null, result);
        return result;

    }

    @Override
    public String decodificar(String mensaje, Alfabeto alfabeto) {
        String result="";
        String mensajito = mensaje.toLowerCase();

        List<String> mensajitos = new ArrayList<>(Arrays.asList(mensajito.split(" ")));

        for(String s: mensajitos){
            System.out.println(s);
            result= result + obtenerLetra(s);
        }

        System.out.println(result);
        JOptionPane.showMessageDialog(null, result);
        return result;
    }
    
    
    public String codigoBin(String entrada){ //la entrada puede ser una letra o un código
        String result="";
        List<String> listaLetras= Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q","r","s","t","u","v","w","x","y","z"," ");        
        List<String> listaCode = Arrays.asList("00000 ", "00001 ", "00010 ", "00011 ", "00100 ", "00101 ", "00110 ", "00111 ", "01000 ", "01001 ", "01010 ", "01011 ", "01100 ", "01101 ",
                "01110 ", "01111 ", "10000 ","10001 ","10010 ", "10011 ","10100 ","10101 ","10110 ","10111 ","11000 ","11001 "," * ");
        if(listaCode.contains(entrada)){//si la lista tiene la letra
            int indice = listaCode.indexOf(entrada);
            System.out.println(indice);
            result = listaLetras.get(indice);
        }
        else if(listaLetras.contains(entrada)){//si la lista tiene la letra
            int indice = listaLetras.indexOf(entrada);
            System.out.println(indice);
            result = listaCode.get(indice);
        }
        System.out.println(result);
        return result;
    }
    
    public String obtenerLetra(String entrada){ //la entrada puede ser una letra o un código
        String result="";
        List<String> listaLetras= Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q","r","s","t","u","v","w","x","y","z"," ");        
        List<String> listaCode = Arrays.asList("00000", "00001", "00010", "00011", "00100", "00101", "00110", "00111", "01000", "01001", "01010", "01011", "01100", "01101",
                "01110", "01111", "10000","10001","10010", "10011","10100","10101","10110","10111","11000","11001","*");
        if(listaCode.contains(entrada)){//si la lista tiene la letra
            int indice = listaCode.indexOf(entrada);
            System.out.println(indice);
            result = listaLetras.get(indice);
        }
        else if(listaLetras.contains(entrada)){//si la lista tiene la letra
            int indice = listaLetras.indexOf(entrada);
            System.out.println(indice);
            result = listaCode.get(indice);
        }
        return result;
    }


    
}
