/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.DTOAlgoritmos;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.jfr.events.FileWriteEvent;

/**
 *
 * @author Meli
 */
public class DAOTxt implements IPersistencia {

    @Override
    public boolean guardar(DTOAlgoritmos dto_algoritmos) {
        File archivoTxt = new File("Bitacora/DAOTxt.txt");
        //escritura
        try {
            FileWriter fw = new FileWriter(archivoTxt, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            bw.newLine();
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); //define formato para fecha y hora
            // inserta en archivo txt
            pw.append("Fecha: " + sdf.format(cal.getTime()) + " ");
            pw.append("Entrada: " + dto_algoritmos.getEntrada() + " ");
            pw.append("Algoritmo: "); //falta nombre algoritmo, no me quedo claro el manejo
            if (dto_algoritmos.isCodificacion()) {
                pw.append("en codificacion ");
            } else {
                pw.append("en decodificacion ");
            }
            pw.append("Salida: " + dto_algoritmos.getSalida());
            pw.close();
            bw.close();
        } catch (IOException ex) {
            return false;
        }
        return true;
    }

}
