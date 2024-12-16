/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_estructuradatos;

/**
 *
 *
 */
public class ListaPasajeros {
    
    // Estructura lista enlazada simple 

    private NodoLS cabeza;
    

    public ListaPasajeros() {
        this.cabeza = null;
    }

    public void agregarPasajero(Pasajero pasajero) {
        NodoLS nuevoNodo = new NodoLS(pasajero);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            NodoLS actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
    }

    public void mostrarPasajeros() {
        if (cabeza == null) {
            System.out.println("No hay pasajeros registrados ");
            return;
        }
        NodoLS actual = cabeza;
        while (actual != null) {
            System.out.println(actual.pasajero);
            actual = actual.siguiente;
        }
    }

    public Pasajero buscarPasajero(String ID) {
        NodoLS actual = cabeza;
        while (actual != null) {
            if (actual.pasajero.getDocumentoIdentidad().equals(ID)) {
                return actual.pasajero;
            }
            actual = actual.siguiente;
        }
        return null;
    }
}
