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
import java.util.Scanner;

/**
 *
 * @author Pablo
 * @date 21 abr 2022
 * @authorFullName Pablo Antonio Murillo Sanchez
 */
public class ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame la ruta del fichero");
        String path = sc.nextLine();
        String contenido = leerArchivo(path);
        System.out.println(contenido);
        System.out.println("Dame el nombre del fichero de copia");
        String pathFicheroCopia="E:\\"+sc.nextLine()+".txt";
        File ficheroCopia;
        //proceso de creado de fichero copia
        if(pathFicheroCopia.isBlank()){
            pathFicheroCopia="E:\\_copy.txt";
            ficheroCopia = crearFichero(pathFicheroCopia);
        }else{
            ficheroCopia = crearFichero(pathFicheroCopia);
        }
        //escribir sobre el fichero copia el texto del fichero original
        escribirFichero(ficheroCopia,contenido);
        System.out.println(leerArchivo(pathFicheroCopia));
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
