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
 * @author Meli
 */
public class AlgCodigoTelefonico extends StrategyAlgoritmo{

    public String codificar(String mensaje, libcomp.Alfabeto alfabeto) {
        String mensajito = mensaje.toLowerCase();
        String result="";

        for(int i=0 ; i<mensajito.length(); i++ ){
            result = result + codigoTelf(mensajito.substring(i, i+1));
        }
        
        //System.out.println(result);
        JOptionPane.showMessageDialog(null, result);
        return result;

    }

    public String decodificar(String mensaje, libcomp.Alfabeto alfabeto) {
        String result="";
        String mensajito = mensaje.toLowerCase();

        List<String> mensajitos = new ArrayList<String>(Arrays.asList(mensajito.split(" ")));

        for(String s: mensajitos){
            result= result + obtenerLetra(s);
        }

        //System.out.println(result);
        JOptionPane.showMessageDialog(null, result);
        return result;
    }
    
    
    
    public String codigoTelf(String entrada){ //la entrada puede ser una letra o un código
        String result=null;
        List<String> listaLetras= Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q","r","s","t","u","v","w","x","y","z"," ");        
        List<String> listaCode = Arrays.asList("21 ", "22 ", "23 ", "31 ", "32 ", "33 ", "41 ", "42 ", "43 ", "51 ", "52 ", "53 ", "61 ", "62 ", "63 ", "71 ", "72 ","73 ","74 ",
                "81 ","82 ","83 ","91 ","92 ","93 ","94 "," * ");
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

    public String obtenerLetra(String entrada){ //la entrada puede ser una letra o un código
        String result="";
        List<String> listaLetras= Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q","r","s","t","u","v","w","x","y","z"," ");        
        List<String> listaCode = Arrays.asList("21", "22", "23", "31", "32", "33", "41", "42", "43", "51", "52", "53", "61", "62", "63", "71", "72","73","74",
                "81","82","83","91","92","93","94","*");
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

    @Override
    public String procesar(String mensaje, libcomp.Alfabeto alfabeto, boolean codificar){
        if (codificar){
            return codificar(mensaje,alfabeto);
        }return decodificar(mensaje, alfabeto);
    }

}
