/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import libcomp.DTO_Comunicacion;

/**
 *
 * @author Meli
 */
public interface IPersistencia {
    public boolean guardar(DTO_Comunicacion dto_algoritmos);
}
