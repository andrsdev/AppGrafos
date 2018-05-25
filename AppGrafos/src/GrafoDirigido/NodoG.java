/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GrafoDirigido;
import ListasSE.*;

/**
 *
 * @author Andrés
 */
public class NodoG {
    public String nombre;
    public ListaSE aristas;
    public NodoG siguiente;
    
    public NodoG(String nombre){
        this.nombre = nombre;
        this.aristas = new ListaSE();
        this.siguiente = null;
    }
    
    public NodoG(NodoG n){
        this.nombre = n.nombre;
        this.aristas = n.aristas;
        this.siguiente = n.siguiente;      
    }
    
    public NodoG(){
      
    }
    
}
