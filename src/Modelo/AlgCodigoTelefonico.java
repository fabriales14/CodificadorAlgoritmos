/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Meli
 */
public class AlgCodigoTelefonico extends StrategyAlgoritmo {

    public String codificar(String mensaje, libcomp.Alfabeto alfabeto) {
        HashMap digitos = asignarNumeros(alfabeto);
        String result = "";

        for (int i = 0; i < mensaje.length(); i++) {
            char letra = mensaje.charAt(i);
            if (alfabeto.getSimbolos_ignorados().indexOf(letra) != -1) {
                result += "* ";
            } else {
                String codigo = getKeyFromValue(digitos, String.valueOf(letra));
                result += codigo + " ";
            }
        }

        return result;

    }

    public String decodificar(String mensaje, libcomp.Alfabeto alfabeto) {
        HashMap digitos = asignarNumeros(alfabeto);
        String result = "";

        List<String> numeros = new ArrayList<String>(Arrays.asList(mensaje.split(" ")));

        for (String s : numeros) {
            if (!"*".equals(s)){
                result += digitos.get(s);
            } else {
                result += " ";
            }
        }

        return result;
    }

    public HashMap asignarNumeros(libcomp.Alfabeto alfabeto) {
        String simbolos = alfabeto.getSimbolos();
        int tam = simbolos.length(); //longitud de simbolos
        if (tam > 90){
            JOptionPane.showMessageDialog(null, "Alfabeto no soportado para CodTel");
            return null;
        }
        int cont = 1;
        HashMap<String,String> digitos = new HashMap();
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j <= 9; j++) {
                String key = String.valueOf(j);
                key += String.valueOf(cont);
                digitos.put(key, String.valueOf(simbolos.charAt(i)));
                i++;
                if (i >= tam) {
                    break;
                }
            }cont++;
        }
        return digitos;
    }

    public String getKeyFromValue(HashMap hashMap, String value) {
        for (Object o : hashMap.keySet()) {
            if (hashMap.get(o).equals(value)) {
                return (String) o;
            }
        }
        return null;
    }

    public String codigoTelf(String entrada) { //la entrada puede ser una letra o un código
        String result = null;
        List<String> listaLetras = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", " ");
        List<String> listaCode = Arrays.asList("21 ", "22 ", "23 ", "31 ", "32 ", "33 ", "41 ", "42 ", "43 ", "51 ", "52 ", "53 ", "61 ", "62 ", "63 ", "71 ", "72 ", "73 ", "74 ",
                "81 ", "82 ", "83 ", "91 ", "92 ", "93 ", "94 ", " * ");
        if (listaCode.contains(entrada)) {//si la lista tiene la letra
            int indice = listaCode.indexOf(entrada);
           
            result = listaLetras.get(indice);
        } else if (listaLetras.contains(entrada)) {//si la lista tiene la letra
            int indice = listaLetras.indexOf(entrada);
            result = listaCode.get(indice);
        }
        return result;
    }

    public String obtenerLetra(String entrada) { //la entrada puede ser una letra o un código
        String result = "";
        List<String> listaLetras = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", " ");
        List<String> listaCode = Arrays.asList("21", "22", "23", "31", "32", "33", "41", "42", "43", "51", "52", "53", "61", "62", "63", "71", "72", "73", "74",
                "81", "82", "83", "91", "92", "93", "94", "*");
        if (listaCode.contains(entrada)) {//si la lista tiene la letra
            int indice = listaCode.indexOf(entrada);
            result = listaLetras.get(indice);
        } else if (listaLetras.contains(entrada)) {//si la lista tiene la letra
            int indice = listaLetras.indexOf(entrada);
            result = listaCode.get(indice);
        }
        return result;
    }

    @Override
    public String procesar(String mensaje, libcomp.Alfabeto alfabeto, boolean codificar) {
        if (codificar) {
            return codificar(mensaje, alfabeto);
        }
        return decodificar(mensaje, alfabeto);
    }

}
