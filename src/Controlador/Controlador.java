/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.AlgCodificacionBinaria;
import Modelo.AlgCodigoTelefonico;
import Modelo.IPersistencia;
import Modelo.AlgPalabraClave;
import Modelo.StrategyAlgoritmo;
import Modelo.AlgTransposicion;
import Modelo.AlgVigenere;
import Modelo.DAOPdf;
import Modelo.DAOTxt;
import Modelo.DAOXml;
import java.io.File;
import java.util.ArrayList;
import libcomp.Alfabeto;
import libcomp.DTO_Comunicacion;

/**
 *
 * @author Meli
 */
public class Controlador implements IValidable {

    private Alfabeto alfabetoActual;
    private IPersistencia DTO;
    private StrategyAlgoritmo algoritmo;
    private DAOAlfabetos bdAlfabetos = new DAOAlfabetos();

    public ArrayList cargarAlfabetos() {
        return bdAlfabetos.getAlfabetos();
    }

    public boolean agregarAlfabeto(Alfabeto a) {
        return bdAlfabetos.agregar(a);
    }

    public boolean modificarAlfabeto(int id, Alfabeto a) {
        return bdAlfabetos.modificar(id, a);
    }

    public boolean eliminarAlfabeto(int id) {
        return bdAlfabetos.eliminar(id);
    }

    public Alfabeto consultarAlfabeto(String nombre) {

        return bdAlfabetos.consultar(nombre);
    }

    public ArrayList cargarSalidas() {
        ArrayList salidas = new ArrayList();
        salidas.add("TXT");
        salidas.add("PDF");
        salidas.add("XML");
        return salidas;
    }

    public ArrayList cargarAlgoritmos() {
        ArrayList<String> archivos = new ArrayList<>();
        File folder = new File("src/Modelo");
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            String nombre = file.getName();
            if ("Alg".equals(nombre.substring(0, 3))) {
                nombre = nombre.substring(3);
                nombre = nombre.substring(0, nombre.length() - 5);
                archivos.add(nombre);
            }
        }
        return archivos;
    }

    public File[] cargarBitacoras() {
        File folder = new File("Bitacora");
        File[] listOfFiles = folder.listFiles();
        return listOfFiles;
    }

    public DTO_Comunicacion procesarPeticion(DTO_Comunicacion datos) {
        predefinirAlfabeto(datos);
        for (String algoritmo : datos.getTipos_algoritmos()) {
            this.algoritmo = getAlgoritmo(algoritmo);
            if (this.algoritmo instanceof AlgVigenere) {
                ((AlgVigenere) this.algoritmo).setNumero_Vigenere(datos.getAlg_vigenere());
            }
            if (this.algoritmo instanceof AlgPalabraClave) {
                ((AlgPalabraClave) this.algoritmo).setPalabra_Clave(datos.getPalabra_clave());
            }
            String salida = this.algoritmo.procesar(datos.getEntrada(), this.alfabetoActual, datos.isCodificacion());
            datos.getSalida().add(salida);
        }
        guardar(datos);
        return datos;
    }

    private void predefinirAlfabeto(DTO_Comunicacion datos) {

        this.alfabetoActual = consultarAlfabeto(datos.getAlfabetos().get(0).getNombre());
        System.out.println("Alfabeto es : " + datos.getAlfabetos().get(0).getNombre());
    }

    public static StrategyAlgoritmo getAlgoritmo(String nombreAlgoritmo) {
        StrategyAlgoritmo algoritmo = null;
        try {
            //recupera el paquete donde se encuentra la clase base
            String paquete = StrategyAlgoritmo.class.getPackage().getName();

            String laInstancia = paquete + ".Alg" + nombreAlgoritmo;

            algoritmo = (StrategyAlgoritmo) Class.forName(laInstancia).newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            algoritmo = null;
        }
        return algoritmo;
    }

    @Override
    public boolean validar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void guardar(DTO_Comunicacion dto_algoritmos) {
        for (int salida : dto_algoritmos.getTipos_salida()) {
            switch (salida) {
                case 0:
                    DAOTxt txt = new DAOTxt();
                    txt.guardar(dto_algoritmos);
                    break;
                case 1:
                    DAOPdf pdf = new DAOPdf();
                    pdf.guardar(dto_algoritmos);
                    break;
                case 2:
                    DAOXml xml = new DAOXml();
                    xml.guardar(dto_algoritmos);
                    break;
                default:
                    break;
            }
        }
    }
}
