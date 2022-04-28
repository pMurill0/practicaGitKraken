/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.ejerciciosficheros;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Pablo
 * @date 21 abr 2022
 * @authorFullName Pablo Antonio Murillo Sanchez
 */
public class ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame la ruta del fichero");
        String path = sc.nextLine();
        System.out.print(leerArchivo(path));
        //cambios para segundo commit
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
}
