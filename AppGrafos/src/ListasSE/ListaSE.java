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
public class ListaSE {
    public Nodo cabeza;
    int lenght;
    
    public ListaSE(){
        cabeza = null;
        lenght = 0;
    }
    
    public boolean estaVacia(){
        return cabeza == null;
    }
    
    
    //Inserta un nuevo nodo en la cabeza de la lista
    public void insertar(String nombre,String hSalida, String hLlegada, int plataforma){
        if(estaVacia()){
            cabeza = new Nodo(nombre, hSalida, hLlegada, plataforma);
            lenght++;
        }else if(!encontrado(nombre)) {
            Nodo nuevo = new Nodo(nombre, hSalida, hLlegada, plataforma);            
            nuevo.siguiente = cabeza;
            cabeza = nuevo;   
            lenght++;
        } 
    }
    
    //Elimina un nodo de la lista
    public void eliminar(String n){
        if (n!= null){
            Nodo aux = cabeza;
            Nodo anterior = null;
            while(aux != null && aux.nombre != n){
                anterior = aux;
                aux = aux.siguiente;
            }

            if (aux != null && anterior != null){
                anterior.siguiente = aux.siguiente; 
            }else if (anterior == null){
                cabeza = aux.siguiente;
            }else{
                anterior.siguiente = null;    
            }
        }
    
    }
    
    
    //Devuelve una copia de un nodo por medio de su índice
    public Nodo getNodo(int index){
        Nodo aux = cabeza; 
        if(index<lenght){
            for (int i = 0; i < index; i++) {
                aux = aux.siguiente;
            }
            Nodo r = new Nodo(aux);
            return r;
        } else{
            return null;
        }      
    }
    
    //Modifica los valores de un nodo por medio de su índice
    public void setNodo(int index, Nodo n){
        Nodo aux = cabeza; 
        if(index<lenght){
            for (int i = 0; i < index; i++) {  
                aux = aux.siguiente;
            }
            aux.nombre = n.nombre;
        }     
    }
    
    //Verifica si un nodo ya existe denro de la lista. Si ya existe, se suma
    //Al conteo de ese nodo.
    public boolean encontrado(String nombre){
        Nodo aux = cabeza;        
        while(aux != null){
            if(aux.nombre == nombre){

                return true;
            }               
            aux = aux.siguiente;
        }
        
        return false;
    }
    
    
    //Muestra la lista con los contes de cada nodo
    public void mostrar(){
        
        String alignFormat1 = "| %-2d | %-24s | %-14s | %-15s | %-10s |%n";
        System.out.format("+----|--------------------------+----------------+-----------------+------------+%n");
        System.out.format("| No | Destino                  | Hora de Salida | Hora de Llegada | Plataforma |%n");
        System.out.format("+----|--------------------------+----------------+-----------------+------------+%n");
             
        Nodo aux = cabeza;  
        int cont = 0;
        while(aux != null){
            cont++;
            System.out.format(alignFormat1,
                    cont,
                    aux.nombre,
                    aux.hSalida,
                    aux.hLlegada,
                    "P-" + aux.plataforma                
            );   
            
            aux = aux.siguiente;
        }
        

        System.out.format("+----|--------------------------+----------------+-----------------+------------+%n");
    }
    
}
