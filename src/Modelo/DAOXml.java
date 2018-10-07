/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.DTOAlgoritmos;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import libcomp.DTO_Comunicacion;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 *
 * @author Meli
 */
public class DAOXml implements IPersistencia {

    // falta implementar 
    @Override
    public boolean guardar(DTO_Comunicacion dto_algoritmos) {
        //escritura
        try {
            File f = new File("Bitacora/DAOXml.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc;
            if (f.exists() && !f.isDirectory()) {
                doc = builder.parse(new FileInputStream("Bitacora/DAOXml.xml"));
                Node root = doc.getFirstChild();
                //Element rootElement = doc.createElement("BitacoraXML");
                //doc.appendChild(rootElement);
                // body elements
                Element body = doc.createElement("Elemento");
                root.appendChild(body);
                Element fecha = doc.createElement("Fecha");
                Calendar cal = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); //define formato para fecha y hora
                fecha.appendChild(doc.createTextNode(sdf.format(cal.getTime())));
                body.appendChild(fecha);
                Element entrada = doc.createElement("Entrada");
                entrada.appendChild(doc.createTextNode(dto_algoritmos.getEntrada()));
                body.appendChild(entrada);
                Element algoritmo = doc.createElement("Algoritmos");
                for (int i = 0; i < dto_algoritmos.getTipos_algoritmos().size(); i++) {
                    algoritmo.appendChild(doc.createTextNode(dto_algoritmos.getTipos_algoritmos().get(i)+ ": " + dto_algoritmos.getSalida().get(i)));
                    body.appendChild(algoritmo);
                }
                Element codifica = doc.createElement("Codifica");
                codifica.appendChild(doc.createTextNode(String.valueOf(dto_algoritmos.isCodificacion())));
                body.appendChild(codifica);
            }else{
                doc = builder.newDocument();
                Element root = doc.createElement("BitacoraXML");
                doc.appendChild(root);
            }
            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("Bitacora/DAOXml.xml"));

            // Output to console for testing
            // StreamResult result = new StreamResult(System.out);
            transformer.transform(source, result);

            System.out.println("File saved!");
        } catch (ParserConfigurationException | TransformerException | SAXException | IOException ex) {
            Logger.getLogger(DAOXml.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

}
