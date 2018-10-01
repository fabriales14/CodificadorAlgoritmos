/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JTextArea;
import libcomp.OBJ_Comp;
import libcomp.TipoAccion;

/**
 *
 * @author melissavillalobos
 */
public class Servidor {
    private ServerSocket servidor;   // objeto que se encarga de atender peticiones externas
    private  int PUERTO = 5000; // numero de puerto por donde va a atender peticiones

   // la conexion de escritura del servidor
    private OutputStream conexionSalida;
    private ObjectOutputStream flujoSalida;

    // la conexion de lectura del servidor
    private InputStream conexionEntrada;
    private ObjectInputStream flujoEntrada;


    // socket que contiene la conexion con el cliente
    private Socket cliente;         // el proceso cliente que esta atendiendo...

    private AdmServidor adm = new AdmServidor();

    public int getPUERTO() {
        return PUERTO;
    }

    public void setPUERTO(int PUERTO) {
        this.PUERTO = PUERTO;
    }

   public void inicialiceServidor() throws ClassNotFoundException{
        try {
            servidor = new ServerSocket(PUERTO);
            while (true){
                System.out.println("Esperando una solicitud de un cliente...");
                cliente = servidor.accept();  // acepta la solicitud de un cliente

                System.out.println("Estableciendo canal de escritura...");
                // se establece DE PRIMERO  el canal de comunicacion-Escritura
                conexionSalida =  cliente.getOutputStream();
                flujoSalida = new ObjectOutputStream(conexionSalida);

                System.out.println("Estableciendo canal de lectura ...");
                // se establece DE SEGUNDO el canal de comunicacion-Lectura
                conexionEntrada = cliente.getInputStream();
                flujoEntrada = new ObjectInputStream(conexionEntrada);
                OBJ_Comp objeto = (OBJ_Comp) flujoEntrada.readObject();
                // atender la peticion...
                
                System.out.println("Atendiendo peticion...");
                procesePeticion(objeto);

                System.out.println("Desconectando...");
                flujoEntrada.close();
                flujoSalida.close();
                cliente.close();
            }
        } catch (IOException ex) {
            System.out.println("Problemas creando el servidor en el puerto "+ PUERTO);
        }
    }

private void procesePeticion(OBJ_Comp objeto) throws IOException, ClassNotFoundException {
    System.out.println(objeto.getDatoEntrada().getEntrada());
    // detectar lo que le enviaron...
    if (objeto.getAccion() == TipoAccion.Enviar_Datos){
        System.out.println("Atendiendo peticion...");
        objeto.getDatoEntrada();
        adm.recibir();
    }
    if (objeto.getAccion() == TipoAccion.Recibir_Datos){
        System.out.println("Atendiendo peticion 2...");
        objeto.setDatoEntrada(adm.enviar());
    }
    
    // flujoSalida.writeObject(objeto);
    }
}
