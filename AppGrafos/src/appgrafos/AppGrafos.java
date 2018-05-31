/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appgrafos;
import GrafoDirigido.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author Andrés Sanabria y Erick Salazar
 */
public class AppGrafos {

    public static String inputPathA = System.getProperty("user.dir") + "\\files\\aeropuertos.txt";
    public static String inputPathH = System.getProperty("user.dir") + "\\files\\horas.txt";
    public static String[] names = new String[10];
    public static String[] hours = new String[10];

           
    public static void main(String[] args) {
        Random rnd = new Random();

        GrafoD aeropuertos = new GrafoD();
        leerAeropuertos();
        leerHoras();
       
        for (int i = 0; i < 10; i++) {
            aeropuertos.insertarVertice(names[i]);
        }

        
        for (int i = 0; i < 100; i++) {
            aeropuertos.agregarArista(names[rnd.nextInt(10)], names[rnd.nextInt(10)], hours[rnd.nextInt(10)], hours[rnd.nextInt(10)], rnd.nextInt(1000));
        }
        
        
               

        
        System.out.println("Los aeropuertos en el grafo son:");
        aeropuertos.mostrar();
        System.out.println();
        
        for (int i = 0; i < 10; i++) {
            System.out.println();
            System.out.println("Vuelos programados en " + names[i] +": ");
            aeropuertos.getNodo(aeropuertos.getIndex(names[i])).aristas.mostrar();
        }
        
        
        
    }
    
    public static void leerAeropuertos(){
        BufferedReader br = null;
        int pos =0;
        //Lectura de archivo.txt y creación de la lista.
        try {      
            File inputFile = new File(inputPathA);
            br = new BufferedReader(new FileReader(inputFile));   
            String line = br.readLine();
            
            while (line != null) {
                names[pos] = line;
                line = br.readLine();    
                pos++;
            }
            br.close();

        } 
        catch (IOException | NumberFormatException e) {
            System.out.println("El archivo no se ha encontrado o su formato no es válido");
        }       
    }
    
    public static void leerHoras(){
        BufferedReader br = null;
        int pos =0;
        //Lectura de archivo.txt y creación de la lista.
        try {      
            File inputFile = new File(inputPathH);
            br = new BufferedReader(new FileReader(inputFile));   
            String line = br.readLine();
            
            while (line != null) {
                hours[pos] = line;
                line = br.readLine();    
                pos++;
            }
            br.close();

        } 
        catch (IOException | NumberFormatException e) {
            System.out.println("El archivo no se ha encontrado o su formato no es válido");
        }       
    }
    
    
}
