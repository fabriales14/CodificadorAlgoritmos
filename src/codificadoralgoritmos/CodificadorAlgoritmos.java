/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codificadoralgoritmos;

import Sockets.Servidor;
import Vista.Consola;
import Vista.GUI;
import Vista.GUI;

/**
 *
 * @author Meli
 */
public class CodificadorAlgoritmos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
      // GUI gui = new GUI(); 
      // gui.setVisible (true); 
       // Consola consola = new Consola();
       // consola.consola();
        Servidor  miServidor = new Servidor();
        miServidor.inicialiceServidor();
    }
    
}
