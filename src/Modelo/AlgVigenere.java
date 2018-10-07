package Modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package Modelo;
import javax.swing.JOptionPane;
import libcomp.Alfabeto;

/**
 *
 * @author Meli
 */
public class AlgVigenere extends StrategyAlgoritmo {

    int numero_Vigenere = 0;

    public void setNumero_Vigenere(int numero_Vigenere) {
        this.numero_Vigenere = numero_Vigenere;
    }

    public String codificar(String mensaje, Alfabeto alfabeto) {
        String simbolos = alfabeto.getSimbolos();
        String result = "";

        for (int i = 0; i < mensaje.length(); i++) {
            char letra = mensaje.charAt(i);
            if (letra == ' ') {
                result += " ";
            } else {
                if (i % 2 == 0) {
                    int despTotal = simbolos.indexOf(letra);
                    int desp1 = Integer.parseInt(Integer.toString(numero_Vigenere).substring(0, 1));
                    while (desp1 > 0){
                        despTotal++;
                        if (despTotal == simbolos.length()){
                            despTotal = 0;
                        }
                        desp1--;
                    }
                    char nuevaLetra = simbolos.charAt(despTotal);
                    result += nuevaLetra;
                } else {
                    int despTotal = simbolos.indexOf(letra);
                    int desp2 = Integer.parseInt(Integer.toString(numero_Vigenere).substring(1, 2));
                    while (desp2 > 0){
                        despTotal++;
                        if (despTotal == simbolos.length()){
                            despTotal = 0;
                        }
                        desp2--;
                    }
                    char nuevaLetra = simbolos.charAt(despTotal);
                    result += nuevaLetra;
                }
            }
        }
        return result;

    }

    public String decodificar(String mensaje, Alfabeto alfabeto) {
        String simbolos = alfabeto.getSimbolos();
        String result = "";

        for (int i = 0; i < mensaje.length(); i++) {
            char letra = mensaje.charAt(i);
            if (letra == ' ') {
                result += " ";
            } else {
                if (i % 2 == 0) {
                    int despTotal = simbolos.indexOf(letra);
                    int desp1 = Integer.parseInt(Integer.toString(numero_Vigenere).substring(0, 1));
                    while (desp1 > 0){
                        despTotal--;
                        if (despTotal < 0){
                            despTotal = simbolos.length()-1;
                        }
                        desp1--;
                    }
                    char nuevaLetra = simbolos.charAt(despTotal);
                    result += nuevaLetra;
                } else {
                    int despTotal = simbolos.indexOf(letra);
                    int desp2 = Integer.parseInt(Integer.toString(numero_Vigenere).substring(1, 2));
                    while (desp2 > 0){
                        despTotal--;
                        if (despTotal < 0){
                            despTotal = simbolos.length()-1;
                        }
                        desp2--;
                    }
                    char nuevaLetra = simbolos.charAt(despTotal);
                    result += nuevaLetra;
                }
            }
        }
        return result;
    }

    @Override
    public String procesar(String mensaje, Alfabeto alfabeto, boolean codificar) {
        if (codificar) {
            return codificar(mensaje, alfabeto);
        }
        return decodificar(mensaje, alfabeto);
    }

}
