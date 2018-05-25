/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListasSE;

/**
 *
 * @author Andrés
 */
public class Nodo {
    public String nombre;
    public String hSalida;
    public String hLlegada;
    public int plataforma;
    public Nodo siguiente;

    public Nodo(String nombre,String hSalida, String hLlegada, int plataforma){
        this.nombre = nombre;
        this.hSalida = hSalida;
        this.hLlegada = hLlegada;
        this.plataforma = plataforma;
        this.siguiente = null;
    }
    
    public Nodo(Nodo n){
        this.nombre = n.nombre;
        this.siguiente = n.siguiente;      
    }
    
    public Nodo(){
      
    }
 
    
}
