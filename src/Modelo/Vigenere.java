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
public class Vigenere extends Algoritmo{

    @Override
    public String codificar(String mensaje, Alfabeto alfabeto) {
        
        System.out.println("Ejecutando metodo codificar de clase Vigenere");
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        JOptionPane.showMessageDialog(null, "Aquí se codificará el algoritmo de Vigenere.", "Codificación", JOptionPane.INFORMATION_MESSAGE);
        return null;

    }

    @Override
    public String decodificar(String mensaje, Alfabeto alfabeto) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        JOptionPane.showMessageDialog(null, "Aquí se decodificará el algoritmo de Vigenere.", "Decodificación", JOptionPane.INFORMATION_MESSAGE);
        return null;
    }
    
}
