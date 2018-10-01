/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets;

import Controlador.Controlador;
import java.util.ArrayList;
import libcomp.Alfabeto;
import libcomp.DTO_Comunicacion;

/**
 *
 * @author melissavillalobos
 */
public class AdmServidor {
    private Controlador controlador;
    public void recibir()
    {
        System.out.println("aqui estoy");
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
