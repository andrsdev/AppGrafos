/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appgrafos;
import GrafoDirigido.*;
import java.util.Random;

/**
 *
 * @author Andrés Sanabria y Erick Salazar
 */
public class AppGrafos {

    public static void main(String[] args) {
        Random rnd = new Random();
        String[] names = new String[10];
        String[] hours = new String[10];

        GrafoD aeropuertos = new GrafoD();


        names[0] = "Aeropuerto La Aurora";
        names[1] = "New York Airport";
        names[2] = "México D.F. Azteca";
        names[3] = "Chicago Airport";
        names[4] = "Los Angeles AR";
        names[5] = "AR de Machupichu";
        names[6] = "Aeropuerto de Arenal";
        names[7] = "AR Internacinal";
        names[8] = "Mundo Maya AR";
        names[9] = "Aeropuerto De Bahía";

        hours[0] = "7:15am";
        hours[1] = "8:45am";
        hours[2] = "9:00am";
        hours[3] = "9:30am";
        hours[4] = "11:15am";
        hours[5] = "12:30pm";
        hours[6] = "4:00pm";
        hours[7] = "6:10pm";
        hours[8] = "8:00pm";
        hours[9] = "9:20pm";
       
       
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
    
}
