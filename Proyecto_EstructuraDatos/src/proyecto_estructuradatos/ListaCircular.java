/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_estructuradatos;

/**
 *
 * @author sebas
 */
public class ListaCircular {
    private NodoC cabeza;
    private NodoC cola;

    public ListaCircular() {
        this.cabeza = null;
        this.cola = null;
    }

    public void agregarVuelo(DatoC dato) {
        NodoC nuevoNodo = new NodoC(dato);
        
        if (cabeza == null) {
            
            cabeza = nuevoNodo;
            cola = nuevoNodo;
            cabeza.setSiguiente(cabeza);  
        } else {
            
            cola.setSiguiente(nuevoNodo);
            nuevoNodo.setSiguiente(cabeza);
            cola = nuevoNodo;  
        }
    }

    public void mostrarVuelos() {
        if (cabeza == null) {
            System.out.println("No hay vuelos registrados");
            return;
        }

        NodoC actual = cabeza;
        do {
            System.out.println(actual.getDato());
            actual = actual.getSiguiente();
        } while (actual != cabeza);  
    }

    public DatoC buscarVuelo(String numeroVuelo) {
        if (cabeza == null) {
            System.out.println("No hay vuelos registrados.");
            return null;
        }

        NodoC actual = cabeza;
        do {
            if (actual.getDato().getNumeroVuelo().equals(numeroVuelo)) {
                return actual.getDato();  
            }
            actual = actual.getSiguiente();
        } while (actual != cabeza);  

        System.out.println("Vuelo con número " + numeroVuelo + " no encontrado.");
        return null;  
    }
}


