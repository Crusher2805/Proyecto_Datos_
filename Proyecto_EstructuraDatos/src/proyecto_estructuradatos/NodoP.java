/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_estructuradatos;


public class NodoP {

    String numeroVuelo;
    String origen;
    String destino;
    double precio;
    NodoP siguiente;

    public NodoP(String numeroVuelo, String origen, String destino, double precio) {
        this.numeroVuelo = numeroVuelo;
        this.origen = origen;
        this.destino = destino;
        this.precio = precio;
        this.siguiente = null;
    }

    @Override
    public String toString() {
        return "Vuelo: " + numeroVuelo + " Origen: " + origen + " Destino " + destino + " Precio: " + precio;
    }

}
