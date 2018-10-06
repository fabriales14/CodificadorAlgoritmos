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
    
    public boolean agregarAlfabeto(Alfabeto a){
        return bdAlfabetos.agregar(a);
    }
    
    public boolean modificarAlfabeto(int id, Alfabeto a){
        return bdAlfabetos.modificar(id, a);
    }
    
    public boolean eliminarAlfabeto(int id) {
        return bdAlfabetos.eliminar(id);
    }
    
    public Alfabeto consultarAlfabeto(String nombre){
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
        File folder = new File("src\\Modelo");
        File[] listOfFiles = folder.listFiles();
        for (File file: listOfFiles){
            String nombre = file.getName();
            if ("Alg".equals(nombre.substring(0, 3))){
                nombre = nombre.substring(3);
                nombre = nombre.substring(0, nombre.length()-5);
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

    public DTOAlgoritmos procesarPeticion(DTOAlgoritmos dto_algoritmos) {

        /*System.out.println("Ejecutando metodo procesarPeticion de clase Controlador");
        if (dto_algoritmos.isCodificacion()) { //pregunta si se va a codificar. en caso de false se decodificacá
            if (dto_algoritmos.getAlgoritmos().indexOf(0) >= 0) { // tiene el algoritmo 0: Vigenere
                AlgVigenere vigenere = new AlgVigenere();
                vigenere.codificar(dto_algoritmos.getEntrada(), alfabetoActual);
            }
            if (dto_algoritmos.getAlgoritmos().indexOf(1) >= 0) { // tiene el algoritmo 1: Trasposición
                AlgTransposicion transposicion = new AlgTransposicion();
                transposicion.codificar(dto_algoritmos.getEntrada(), alfabetoActual);
            }
            if (dto_algoritmos.getAlgoritmos().indexOf(2) >= 0) { // tiene el algoritmo 2: Telefonico
                AlgCodigoTelefonico codigoTelefonico = new AlgCodigoTelefonico();
                codigoTelefonico.codificar(dto_algoritmos.getEntrada(), alfabetoActual);
            }
            if (dto_algoritmos.getAlgoritmos().indexOf(3) >= 0) { // tiene el algoritmo 3: Codigo Binario
                AlgCodificacionBinaria codificacionBinaria = new AlgCodificacionBinaria();
                codificacionBinaria.codificar(dto_algoritmos.getEntrada(), alfabetoActual);
            }
            if (dto_algoritmos.getAlgoritmos().indexOf(4) >= 0) { // tiene el algoritmo 4: Palabra Clave
                AlgPalabraClave palabraClave = new AlgPalabraClave();
                palabraClave.codificar(dto_algoritmos.getEntrada(), alfabetoActual);
            }
        } else {
            if (dto_algoritmos.getAlgoritmos().indexOf(0) >= 0) { // tiene el algoritmo 0: Vigenere
                AlgVigenere vigenere = new AlgVigenere();
                vigenere.decodificar(dto_algoritmos.getEntrada(), alfabetoActual);
            }
            if (dto_algoritmos.getAlgoritmos().indexOf(1) >= 0) { // tiene el algoritmo 1: Trasposición
                AlgTransposicion transposicion = new AlgTransposicion();
                transposicion.decodificar(dto_algoritmos.getEntrada(), alfabetoActual);
            }
            if (dto_algoritmos.getAlgoritmos().indexOf(2) >= 0) { // tiene el algoritmo 2: Telefonico
                AlgCodigoTelefonico codigoTelefonico = new AlgCodigoTelefonico();
                codigoTelefonico.decodificar(dto_algoritmos.getEntrada(), alfabetoActual);
            }
            if (dto_algoritmos.getAlgoritmos().indexOf(3) >= 0) { // tiene el algoritmo 3: Codigo Binario
                AlgCodificacionBinaria codificacionBinaria = new AlgCodificacionBinaria();
                codificacionBinaria.decodificar(dto_algoritmos.getEntrada(), alfabetoActual);
            }
            if (dto_algoritmos.getAlgoritmos().indexOf(4) >= 0) { // tiene el algoritmo 4: Palabra Clave
                AlgPalabraClave palabraClave = new AlgPalabraClave();
                palabraClave.decodificar(dto_algoritmos.getEntrada(), alfabetoActual);
            }

        }
        
        dto_algoritmos.setSalida("salida");*/
        return dto_algoritmos;
    }
    
    public DTO_Comunicacion procesarPeticion(DTO_Comunicacion datos){
        predefinirAlfabeto(datos);
        for (String algoritmo : datos.getTipos_algoritmos()){
            this.algoritmo = getAlgoritmo(algoritmo);
            String salida = this.algoritmo.procesar(datos.getEntrada(), this.alfabetoActual, datos.isCodificacion());
            System.out.println(salida);
        }
        return datos;
    }

    private void predefinirAlfabeto(DTO_Comunicacion datos) {
        this.alfabetoActual = consultarAlfabeto(datos.getAlfabetos().get(0).getNombre());
    }
    
    public static StrategyAlgoritmo getAlgoritmo(String nombreAlgoritmo){
        StrategyAlgoritmo algoritmo = null;
        try {
            //recupera el paquete donde se encuentra la clase base
            String paquete = StrategyAlgoritmo.class.getPackage().getName();
            
            String laInstancia = paquete+".Alg"+nombreAlgoritmo;
             
            algoritmo = (StrategyAlgoritmo) Class.forName(laInstancia).newInstance();
        } 
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
           algoritmo = null;
        }
        return algoritmo;
    }

    @Override
    public boolean validar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void activarAlgoritmos(DTOAlgoritmos dto_algoritmos) {

    }

    private void guardar(DTOAlgoritmos dto_algoritmos) {

    }
}
