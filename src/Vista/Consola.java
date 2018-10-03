/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;
import Controlador.Controlador;
import Controlador.DTOAlgoritmos;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/**
 *
 * @author melissavillalobos
 */
public class Consola {
   
    public void consola(){
      //Se carga el controlador
        Controlador controlador = new Controlador();
        Scanner entradaUsuarioScanner = new Scanner(System.in); 
        System.out.print("Codificador y decodificador de frases \n");
        System.out.print("\n");
        System.out.print("Escoja el alfabeto que desea: \n");
        ArrayList alfabetos = controlador.cargarAlfabetos();
        //Se cargan los alfabetos
        for(Object alfabeto : alfabetos) {
                System.out.println(alfabetos.indexOf(alfabeto) +"." + alfabeto.toString()+ "\n");
        }
        
        System.out.print("Ingrese el numero del alfabeto que desea: \n");
        String cbAlfabeto = entradaUsuarioScanner.nextLine();
        System.out.println("\nIngrese la frase que desea que sea evaluada: \n");
        String vFraseOrigen = entradaUsuarioScanner.nextLine();
        System.out.println("\nIngrese los numeros de los tipos de algoritmo que desea,separados por una coma: \n");
       //Se cargan los algoritmos
        ArrayList Tipoalgoritmos = controlador.cargarAlgoritmos();
        for(Object algoritmo : Tipoalgoritmos) {
                System.out.println(Tipoalgoritmos.indexOf(algoritmo) + "." +algoritmo.toString());
        }        
        String entradaAlgoritmos = entradaUsuarioScanner.nextLine();
        System.out.println("\nIngrese los numeros de los tipos de salida que desea,separados por una coma: \n");
        //Se cargan las salidas
        ArrayList Tiposalidas = controlador.cargarSalidas();
        for(Object salida : Tiposalidas) {
                System.out.println(Tiposalidas.indexOf(salida)+"."+salida.toString());
        }
        String SalidasAlgoritmos = entradaUsuarioScanner.nextLine();
        System.out.println("\nDesea codificar? Ingrese 1 para si y 0 para no \n");
        String codificar = entradaUsuarioScanner.nextLine();
        Boolean codif;
        if (Integer.parseInt(codificar.toString())==1){
            codif= true;
        }
        else{ 
            codif=false;
        }
        
        String resultados= "";
        // Se cargan los datos al controlador
        ArrayList<String> algoritmos = new ArrayList<String>(Arrays.asList(entradaAlgoritmos.toString().split(",")));
        ArrayList<String> salidas = new ArrayList<String>(Arrays.asList(SalidasAlgoritmos.split(",")));
        ArrayList<Integer> lAlgoritmos = new ArrayList<Integer>(algoritmos.size()) ;
        for (String myInt : algoritmos) 
            { 
              lAlgoritmos.add(Integer.valueOf(myInt)); 
            }
        ArrayList<Integer> lSalidas = new ArrayList<Integer>(salidas.size()) ;
        for (String myInt : salidas) 
            { 
              lSalidas.add(Integer.valueOf(myInt)); 
            }   
        
    //    DTOAlgoritmos DTO = new DTOAlgoritmos(Integer.parseInt(cbAlfabeto),vFraseOrigen,resultados,lAlgoritmos,lSalidas, codif);
    //    controlador.procesarPeticion(DTO);
        System.out.println("Se procesa el texto");
    }
    
}
