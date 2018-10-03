/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets;

import java.util.ArrayList;
import libcomp.Alfabeto;
import libcomp.DTO_Comunicacion;
import Controlador.*;
/**
 *
 * @author melissavillalobos
 */
public class AdmServidor {
    private Controlador controlador;
    public DTO_Comunicacion recibir(DTO_Comunicacion dto)
    {
        int selectedAlfabeto = dto.getSelectedAlfabeto();
        String entrada = dto.getEntrada();
        boolean codificacion = dto.isCodificacion();
        int extension = dto.getExtension();
        ArrayList<Alfabeto> alfabetos= null; // quitar
        int selectedMezcla = dto.getSelectedMezcla();
        ArrayList<Integer> algoritmos = dto.getAlgoritmos();
        ArrayList<Integer> tipos_salidas = dto.getTipos_salida();
        DTOAlgoritmos DTOAlgoritmos = new DTOAlgoritmos(alfabetos, entrada, algoritmos, tipos_salidas, codificacion, extension, selectedAlfabeto, selectedMezcla);
        DTOAlgoritmos = controlador.procesarPeticion(DTOAlgoritmos);
        //cambiar esta parte.
        ArrayList<String> salidas = new ArrayList();
        salidas.add(DTOAlgoritmos.getSalida());
        dto.setSalida(salidas);
        System.out.println(dto.getSalida().get(0));// cambiar
        return dto;
    }
    
    public DTO_Comunicacion enviar(){
        controlador= new Controlador();
        ArrayList<Alfabeto> alfabeto = controlador.cargarAlfabetos();
        ArrayList<String> salidas = controlador.cargarSalidas();
        ArrayList<String> algoritmos = controlador.cargarAlgoritmos();
        
        DTO_Comunicacion dto = new DTO_Comunicacion(alfabeto, salidas, algoritmos, null);
        return dto;
    }
    
}
