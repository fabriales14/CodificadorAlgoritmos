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
        String mensajito = mensaje.toLowerCase();
        List<String> mensajitos = new ArrayList<>(Arrays.asList(mensajito.split(" ")));
        String palabraClave = mensajitos.get(0);
        mensajito = mensajito.substring(palabraClave.length()+1, mensajito.length());
        
        
        //System.out.print("palabraClave ");
        //System.out.println(palabraClave);
        
        //System.out.print("mensajito ");
        //System.out.println(mensajito);
        
        int banderaPalabra = 0; //bandera de n estados que permite ver en cuál letra se ubica dentro de la palabra clave
        
        List<String> listaPalabra = new ArrayList<>();  // lista que guarda cada caracter de la palabra clave
        for(int e =0; e<palabraClave.length(); e++){
            listaPalabra.add(palabraClave.substring(e, e+1));
        }
        
        for(int e=0; e<mensajito.length(); e++){
            //agarro el caracter
            String caracter = mensajito.substring(e, e+1);
            
            if (" ".equals(caracter)){
                result = result + " ";
                banderaPalabra=0;
            }
            else{
                int numeroNuevaLetra = (obtenerNumeroLetra(caracter)+obtenerNumeroLetra(palabraClave.substring(banderaPalabra,banderaPalabra+1)));
                numeroNuevaLetra=numeroNuevaLetra%26;
                banderaPalabra=(banderaPalabra+1)%palabraClave.length();
                result = result + textoLetra(numeroNuevaLetra);
            }
        }
        
        JOptionPane.showMessageDialog(null, result);
        return result;
    }

    public String decodificar(String mensaje, libcomp.Alfabeto alfabeto) {
        String result = "";
        String mensajito = mensaje.toLowerCase();
        List<String> mensajitos = new ArrayList<>(Arrays.asList(mensajito.split(" ")));
        String palabraClave = mensajitos.get(0);
        mensajito = mensajito.substring(palabraClave.length()+1, mensajito.length());
        
        //System.out.print("palabraClave ");
        //System.out.println(palabraClave);
        
        //System.out.print("mensajito ");
        //System.out.println(mensajito);
        
        int banderaPalabra = 0; //bandera de n estados que permite ver en cuál letra se ubica dentro de la palabra clave
        
        List<String> listaPalabra = new ArrayList<>();  // lista que guarda cada caracter de la palabra clave
        for(int e =0; e<palabraClave.length(); e++){
            listaPalabra.add(palabraClave.substring(e, e+1));
        }
        
        for(int e=0; e<mensajito.length(); e++){
            //agarro el caracter
            String caracter = mensajito.substring(e, e+1);
            
            if (" ".equals(caracter)){
                result = result + " ";
                banderaPalabra=0;
            }
            else{
                int numeroNuevaLetra = (obtenerNumeroLetra(caracter)-obtenerNumeroLetra(palabraClave.substring(banderaPalabra,banderaPalabra+1)))+26;
                numeroNuevaLetra=numeroNuevaLetra%26;
                banderaPalabra=(banderaPalabra+1)%palabraClave.length();
                result = result + textoLetra(numeroNuevaLetra);
            }
        }
        
        JOptionPane.showMessageDialog(null, result);
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
