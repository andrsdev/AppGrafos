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
public class GrafoD {
    NodoG vertice;
    int orden;
    
    public GrafoD(){
        vertice = null;
        orden = 0;
    }
    
    public boolean estaVacia(){
        return vertice == null;
    }
    
    
    //Inserta un nuevo vertice en el grafo
    public void insertarVertice(String nombre){
        if(estaVacia()){
            vertice = new NodoG(nombre);
            orden++;
        }else if(!encontrado(nombre)) {
            NodoG nuevo = new NodoG(nombre);            
            nuevo.siguiente = vertice;
            vertice = nuevo;  
            orden++;
        } 
    }
    
        
    //Inserta un nuevo vertice en el grafo
    public void agregarArista(String nombre1, String nombre2, String hSalida, String hLlegada, int plataforma){
   
        int indexN1 = getIndex(nombre1);     
        this.getNodo(indexN1).aristas.insertar(nombre2, hSalida, hLlegada, plataforma);

    }
    
    
    public void eliminarArista(String nombre1, String nombre2){
   
        int indexN1 = getIndex(nombre1);     
        this.getNodo(indexN1).aristas.eliminar(nombre2);

    }
    
    //Elimina un vertice del grafo
    public void eliminarVertice(NodoG n){
        if (n!= null){
            NodoG aux = vertice;
            NodoG anterior = null;
            while(aux != null && aux.nombre != n.nombre){
                anterior = aux;
                aux = aux.siguiente;
            }

            if (aux != null && anterior != null){
                anterior.siguiente = aux.siguiente; 
                orden--;
            }else if (anterior == null){
                vertice = aux.siguiente;
                orden--;
            }else{
                anterior.siguiente = null; 
                orden--;
            }
        }
    
    }
    
    
    //Devuelve una copia de un nodo por medio de su índice
    public NodoG getNodo(int index){
        NodoG aux = vertice; 
        if(index<orden){
            for (int i = 0; i < index; i++) {
                aux = aux.siguiente;
            }
            NodoG r = new NodoG(aux);
            return r;
        } else{
            return null;
        }      
    }
    
    //Modifica los valores de un nodo por medio de su índice
    public void setNodo(int index, Nodo n){
        NodoG aux = vertice; 
        if(index<orden){
            for (int i = 0; i < index; i++) {  
                aux = aux.siguiente;
            }
            aux.nombre = n.nombre;
        }     
    }
    
    //Verifica si un vertice ya existe en el grafo.
    public boolean encontrado(String nombre){
        NodoG aux = vertice;        
        while(aux != null){
            if(aux.nombre == nombre){
                return true;
            }               
            aux = aux.siguiente;
        }
        
        return false;
    }
    
    //Obtiene el index de un vertice en el grafo
    public int getIndex(String nombre){
        NodoG aux = vertice;        
        int index = 0;
        while(aux != null){
            if(aux.nombre == nombre){
                return index;
            }               
            index++;
            aux = aux.siguiente;
        }
        
        return -1;
    }
    
    
    //Muestra la lista con los contes de cada nodo
    public void mostrar(){
        NodoG aux = vertice;
        while(aux != null){
            System.out.print(aux.nombre + ", ");
            aux = aux.siguiente;
        }
    }
    
    
    
    
    
}
