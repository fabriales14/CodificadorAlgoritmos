/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.DTOAlgoritmos;

/**
 *
 * @author Meli
 */
public interface IPersistencia {
    public boolean guardar(DTOAlgoritmos dto_algoritmos);
}
