/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_estructuradatos;

/**
 *
 * @author sebas
 */
public class NodoDobleCircular {
    public DatoC dato;
    public NodoDobleCircular siguiente;
    public NodoDobleCircular anterior;

    public NodoDobleCircular(DatoC dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }

    public DatoC getDato() {
        return dato;
    }

    public void setDato(DatoC dato) {
        this.dato = dato;
    }

    public NodoDobleCircular getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDobleCircular siguiente) {
        this.siguiente = siguiente;
    }

    public NodoDobleCircular getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDobleCircular anterior) {
        this.anterior = anterior;
    }
}

