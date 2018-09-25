/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.DTOAlgoritmos;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Meli
 */
public class DAOPdf implements IPersistencia {

    @Override
    public boolean guardar(DTOAlgoritmos dto_algoritmos) {
        File f = new File("Bitacora/DAOPdf.pdf");
        if (f.exists() && !f.isDirectory()) {
            Document document = new Document();
            try {
                PdfReader reader = new PdfReader("Bitacora/DAOPdf.pdf");
                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(new File("Bitacora/DAOPdfSalida.pdf")));
                document.open();
                PdfContentByte cb = writer.getDirectContent();
                for (int i = 0; i < reader.getNumberOfPages(); i++) {
                    PdfImportedPage page = writer.getImportedPage(reader, i + 1);
                    document.newPage();
                    cb.addTemplate(page, 0, 0);
                }
                document.newPage();
                Paragraph p = new Paragraph();
                Calendar cal = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); //define formato para fecha y hora
                p.add("Fecha: " + sdf.format(cal.getTime()) + '\n');
                p.add("Entrada: " + dto_algoritmos.getEntrada() + '\n');
                p.add("Algoritmo: ");
                if (dto_algoritmos.isCodificacion()) {
                    p.add("en codificacion\n");
                } else {
                    p.add("en decodificacion\n");
                }
                p.add("Salida: " + dto_algoritmos.getSalida());
                p.setAlignment(Element.ALIGN_CENTER);
                document.add(p);
                document.close();
                f.delete();
                File f2 = new File("Bitacora/DAOPdfSalida.pdf");
                f2.renameTo(f);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(DAOPdf.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException | DocumentException ex) {
                Logger.getLogger(DAOPdf.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            Document document = new Document();
            try {
                PdfWriter.getInstance(document, new FileOutputStream(new File("DAOPdf.pdf")));
                document.open();
                Paragraph p = new Paragraph();
                Calendar cal = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); //define formato para fecha y hora
                p.add("Fecha: " + sdf.format(cal.getTime()) + '\n');
                p.add("Entrada: " + dto_algoritmos.getEntrada() + '\n');
                p.add("Algoritmo: ");
                if (dto_algoritmos.isCodificacion()) {
                    p.add("en codificacion\n");
                } else {
                    p.add("en decodificacion\n");
                }
                p.add("Salida: " + dto_algoritmos.getSalida());
                p.setAlignment(Element.ALIGN_CENTER);
                document.add(p);
                document.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(DAOPdf.class.getName()).log(Level.SEVERE, null, ex);
            } catch (DocumentException | IOException ex) {
                Logger.getLogger(DAOPdf.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return true;
    }

}
