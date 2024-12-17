/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_estructuradatos;

/**
 *
 *
 */
public class NodoArbol {
    private DatoC vuelo;
    private NodoArbol izquierdo;
    private NodoArbol derecho;

    public NodoArbol(DatoC vuelo) {
        this.vuelo = vuelo;
        this.izquierdo = null;
        this.derecho = null;
    }

    public DatoC getVuelo() {
        return vuelo;
    }

    public NodoArbol getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoArbol izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoArbol getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoArbol derecho) {
        this.derecho = derecho;
    }
}