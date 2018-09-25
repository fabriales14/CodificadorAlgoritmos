/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.DTOAlgoritmos;
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
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> t = new ArrayList<>();
        DTOAlgoritmos dto = new DTOAlgoritmos(0, "hola", "hola", a, t, true);
        DAOPdf daopdf = new DAOPdf();
        daopdf.guardar(dto);
        DAOTxt dao = new DAOTxt();
        dao.guardar(dto);
        DAOXml daoxml = new DAOXml();
        daoxml.guardar(dto);
    }
    
}
