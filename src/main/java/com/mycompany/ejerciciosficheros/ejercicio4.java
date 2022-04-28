/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.ejerciciosficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Pablo
 * @date 28 abr 2022
 * @authorFullName Pablo Antonio Murillo Sanchez
 */
public class ejercicio4 {
    public static void main(String[] args) {
        switch(args[0]){
            case "jcopytext" :
                if(args.length==3)
                    escribirFichero(args[2],leerArchivo(args[1]));
                else
                    escribirFichero(crearFichero("E:\\_copy.txt"),leerArchivo(args[1]));
                break;
            case "jtype" : leerArchivo(args[1]); break;
            case "jwc" : 
                if(args.length==3)
                    conteoConOpcion(args[1], args[2]);
                else
                    conteo(args[1]);
            break;
            default: System.out.println("Opcion incorrecta!!!");
        }
    }
    public static void conteoConOpcion(String opcion, String path){
        switch(opcion){
            case "-l": System.out.print("Numero de lineas: "+contarLineas(path)); break;
            case "-c":  System.out.print("Numero de caracteres: "+leerArchivo(path).length()); break;
            case "-w": System.out.print("Numero de palabras: "+contarPalabras(path)); break;
            default : System.out.print("Error"); 
        }
    }
    public static void conteo(String path){
        System.out.println("Numero de lineas: "+contarLineas(path));
        System.out.println("Numero de palabras: "+leerArchivo(path).length());
        System.out.print("Numero de palabras: "+contarPalabras(path));
    }
    public static String leerArchivo(String path){
        String linea;
        String text="";
        BufferedReader br;
        try{
            br = new BufferedReader(new FileReader(path));
            linea = br.readLine();
            while(linea!=null){
                text+=linea+"\n";
                linea=br.readLine();
            }
        }catch(IOException ex){
            System.out.println("Fichero no encontrado");
        }
        return text;
    }
    public static int contarPalabras(String path){
        int nroPalabras=0;
        String contenido = leerArchivo(path);
        for (int i = 0; i < contenido.length()-1; i++) {
            if(contenido.charAt(i)==' ' || contenido.charAt(i)=='\n' || contenido.charAt(i)=='\t')
                if(contenido.charAt(i+1)!=' ' || contenido.charAt(i+1)!='\n' || contenido.charAt(i+1)!='\t')
                nroPalabras++;
        }
        return nroPalabras;
    }
    public static int contarLineas(String path){
        int nroLineas=0;
        String contenido = leerArchivo(path);
        for (int i = 0; i < contenido.length(); i++) {
            if(contenido.charAt(i)=='\n')
                nroLineas++;
        }
        return nroLineas;
    }
    public static File crearFichero(String path){
        File ficheroCopia= new File(path);
        if(ficheroCopia.exists()){
            System.out.println("Error, fichero existente");
        }else{
            try{
                if(ficheroCopia.createNewFile())
                    System.out.println("fichero creado correctamente");
                else
                    System.out.println("No se ha podido crear el fichero");
            } catch(IOException ioe){
                System.out.println("error!!!");
            }
        }
        return ficheroCopia;
    }
    //en un determinada ruta
    public static void escribirFichero(String path, String contenido){
        BufferedWriter bw = null;
        
        try{
            bw = new BufferedWriter(new FileWriter(path));
            bw.write(contenido);
        }catch(IOException e){
            System.out.println("ERROR");
        }finally{
            try{
                bw.close();
            }catch(IOException e){
                System.out.println("error al cerrar el fichero");
            }
        }
    }
    //en un determinado archivo
    public static void escribirFichero(File file, String contenido){
        BufferedWriter bw = null;
        try{
            bw = new BufferedWriter(new FileWriter(file));
            bw.write(contenido);
        }catch(IOException e){
            System.out.println("error");
        }finally{
            try{
                bw.close();
            }catch(IOException e){
                System.out.println("error");
            }
        }
    }
}
