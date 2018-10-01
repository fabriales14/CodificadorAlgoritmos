/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Alfabeto;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author Meli
 */
public class DAOAlfabetos implements IValidable {

    @Override
    public boolean validar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList getAlfabetos() {
        return null;
    }

    public boolean agregar(Alfabeto alfabeto) {
        return true;
    }

    public Alfabeto consultar(int id) {
        return null;
    }
}
