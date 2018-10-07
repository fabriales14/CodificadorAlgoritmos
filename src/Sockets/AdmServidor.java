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
        if(dto.getSelectedMezcla() == 0)
            dto = controlador.procesarPeticion(dto);
        else{            
            controlador.cambiarDirector(dto);
            dto.getSalida().add(controlador.construirHilera(dto));
        }          

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
