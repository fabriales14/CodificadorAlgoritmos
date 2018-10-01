/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.DAOAlfabetos;
import Controlador.DTOAlgoritmos;
import Modelo.Alfabeto;
import Modelo.DAOPdf;
import Modelo.DAOTxt;
import Modelo.DAOXml;
import Modelo.Transposicion;
import Sockets.Servidor;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
        //Inicializa el servidor
        Servidor  miServidor = new Servidor();
        miServidor.inicialiceServidor();
        
        Alfabeto a = new Alfabeto(1, "Universal", "abcdefg", " ");
        DAOAlfabetos dao = new DAOAlfabetos();
        dao.agregar(a);
        
    }
    
}
