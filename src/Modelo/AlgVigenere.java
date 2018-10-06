package Modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package Modelo;

import javax.swing.JOptionPane;
import libcomp.Alfabeto;

/**
 *
 * @author Meli
 */
public class AlgVigenere extends StrategyAlgoritmo{

    public String codificar(String mensaje, Alfabeto alfabeto) {
                String cifras = mensaje.substring(0, 2);
        
        
        String cifra1 = cifras.substring(0,1);
        String cifra2 = cifras.substring(1,2);
        int isCifra = 0;
        
        String mensajito = mensaje.substring(3, mensaje.length());
        String result = "";
        
        
        //char[] pruebita = Character.toChars(66);//SUCCESS
                
        
        while(!mensajito.isEmpty()){
            
            //tomamos la letra de la cabeza
            char letra = mensajito.charAt(0);
            
            //numero del char
            int num = (int)letra;
            //transformamos la letra, hay que validar si es may o min
            if(Character.isLowerCase(letra)){//si es min
                //ahora sumamos
                if(isCifra%2==0){
                    num = num + Integer.valueOf(cifra1);
                    if(num>122){ //si la letra es mayor de 90
                        num = num - 26;
                    }
                }
                else{
                    num = num + Integer.valueOf(cifra2);
                    if(num>122){ //si la letra es mayor de 90
                        num = num - 26;
                    }
                }
                char[] tmp = Character.toChars(num);
                letra = tmp[0];
                
            }
            else if (Character.isUpperCase(letra)){ //si es may
                //ahora sumamos
                if(isCifra%2==0){
                    num = num + Integer.valueOf(cifra1);
                    if(num>90){ //si la letra es mayor de 90
                        num = num - 26;
                    }
                }
                else{
                    num = num + Integer.valueOf(cifra2);
                    if(num>90){ //si la letra es mayor de 90
                        num = num - 26;
                    }
                }
                char[] tmp = Character.toChars(num);               
                letra = tmp[0];
            }
            else if (letra==' '){
                letra = ' ';
            }
            isCifra++; 
            //concatenamos la letra
            result= result + letra;
                
            mensajito= mensajito.substring(1, mensajito.length());
        }
        
        //System.out.println(result);
        JOptionPane.showMessageDialog(null, result);
        return result;

    }

    public String decodificar(String mensaje, Alfabeto alfabeto) {
        String cifras = mensaje.substring(0, 2);
        String cifra1 = cifras.substring(0,1);
        String cifra2 = cifras.substring(1,2);
        int isCifra = 0;
        
        String mensajito = mensaje.substring(3, mensaje.length());
        String result = "";              
        
        while(!mensajito.isEmpty()){
            
            //tomamos la letra de la cabeza
            char letra = mensajito.charAt(0);
            //numero del char
            int num = (int)letra;
            //transformamos la letra, hay que validar si es may o min
            if(Character.isLowerCase(letra)){//si es min
                //ahora sumamos
                if(isCifra%2==0){
                    num = num - Integer.valueOf(cifra1);
                    if(num<97){ //si la letra es mayor de 90
                        num = num + 26;
                    }
                }
                else{
                    num = num - Integer.valueOf(cifra2);
                    if(num<97){ //si la letra es mayor de 90
                        num = num + 26;
                    }
                }
                char[] tmp = Character.toChars(num);
                letra = tmp[0];
                
            }
            else if (Character.isUpperCase(letra)){ //si es may
                //ahora sumamos
                if(isCifra%2==0){
                    num = num - Integer.valueOf(cifra1);
                    if(num<65){ //si la letra es mayor de 90
                        num = num + 26;
                    }
                }
                else{
                    num = num - Integer.valueOf(cifra2);
                    if(num<65){ //si la letra es mayor de 90
                        num = num + 26;
                    }
                }
                char[] tmp = Character.toChars(num);               
                letra = tmp[0];
            }
            else if (letra==' '){
                letra = ' ';
            }
            isCifra++; 
            //concatenamos la letra
            result= result + letra;
                
            mensajito= mensajito.substring(1, mensajito.length());
        }
        
        //System.out.println(result);
        JOptionPane.showMessageDialog(null, result);
        return result;
    }
    
    
    @Override
    public String procesar(String mensaje, Alfabeto alfabeto, boolean codificar){
        if (codificar){
            return codificar(mensaje,alfabeto);
        }return decodificar(mensaje, alfabeto);
    }
    
}
