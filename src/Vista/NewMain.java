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
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Alfabeto a = new Alfabeto(2, "Universal", "abc", " ");
        DAOAlfabetos dao = new DAOAlfabetos();
        System.out.println(dao.getAlfabetos().toString());
        dao.agregar(a);
        a = new Alfabeto(1, "Universo", "abcdefgh", " ");
        dao.modificar(1, a);
        //dao.agregar(a);
    }
    
}
