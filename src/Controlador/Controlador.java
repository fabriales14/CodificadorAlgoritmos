/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Alfabeto;
import Modelo.Algoritmo;
import Modelo.CodigoTelefonico;
import Modelo.IPersistencia;
import Modelo.Transposicion;
import Modelo.Vigenere;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Meli
 */
public class Controlador implements IValidable {

    private Alfabeto alfabetoActual;
    private IPersistencia DTO;
    private Algoritmo algoritmo;
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

    public ArrayList cargarSalidas() {
        ArrayList salidas = new ArrayList();
        salidas.add("TXT");
        salidas.add("PDF");
        salidas.add("XML");
        return salidas;
    }

    public ArrayList cargarAlgoritmos() {
        
        ArrayList algoritmos = new ArrayList();
        algoritmos.add("Vigénere");
        algoritmos.add("Transposición");
        algoritmos.add("Código Telefónico");
        return algoritmos;
    }

    public File[] cargarBitacoras() {
        File folder = new File("Bitacora");
        File[] listOfFiles = folder.listFiles();
        return listOfFiles;
    }

    public void procesarPeticion(DTOAlgoritmos dto_algoritmos) {

        System.out.println("Ejecutando metodo procesarPeticion de clase Controlador");

        if (dto_algoritmos.isCodificacion()) { //pregunta si se va a codificar. en caso de false se decodificacá
            if (dto_algoritmos.getAlgoritmos().indexOf(0) >= 0) { // tiene el algoritmo 0: Vigenere
                Vigenere vigenere = new Vigenere();
                vigenere.codificar(dto_algoritmos.getEntrada(), alfabetoActual);
            }
            if (dto_algoritmos.getAlgoritmos().indexOf(1) >= 0) { // tiene el algoritmo 1: Trasposición
                Transposicion transposicion = new Transposicion();
                transposicion.codificar(dto_algoritmos.getEntrada(), alfabetoActual);
            }
            if (dto_algoritmos.getAlgoritmos().indexOf(2) >= 0) { // tiene el algoritmo 2: Telefonico
                CodigoTelefonico codigoTelefonico = new CodigoTelefonico();
                codigoTelefonico.codificar(dto_algoritmos.getEntrada(), alfabetoActual);
            }
        } else {
            if (dto_algoritmos.getAlgoritmos().indexOf(0) >= 0) { // tiene el algoritmo 0: Vigenere
                Vigenere vigenere = new Vigenere();
                vigenere.decodificar(dto_algoritmos.getEntrada(), alfabetoActual);
            }
            if (dto_algoritmos.getAlgoritmos().indexOf(1) >= 0) { // tiene el algoritmo 1: Trasposición
                Transposicion transposicion = new Transposicion();
                transposicion.decodificar(dto_algoritmos.getEntrada(), alfabetoActual);
            }
            if (dto_algoritmos.getAlgoritmos().indexOf(2) >= 0) { // tiene el algoritmo 2: Telefonico
                CodigoTelefonico codigoTelefonico = new CodigoTelefonico();
                codigoTelefonico.decodificar(dto_algoritmos.getEntrada(), alfabetoActual);
            }

        }
    }

    private void predefinirAlfabeto(DTOAlgoritmos dto_algoritmos) {

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
