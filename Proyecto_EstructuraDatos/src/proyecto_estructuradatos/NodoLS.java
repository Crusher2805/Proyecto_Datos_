/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_estructuradatos;

/**
 *
 *
 */
public class NodoLS {

    Pasajero pasajero;
    NodoLS siguiente;

    public NodoLS(Pasajero pasajero) {
        this.pasajero = pasajero;
        this.siguiente = null;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public NodoLS getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoLS siguiente) {
        this.siguiente = siguiente;
    }
    

}
