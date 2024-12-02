/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package  proyecto_estructuradatos;

/**
 *
 * @author sebas
 */
public class NodoC {
    private DatoC dato;
    private NodoC siguiente;

    public NodoC(DatoC dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public DatoC getDato() {
        return dato;
    }

    public void setDato(DatoC dato) {
        this.dato = dato;
    }

    public NodoC getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoC siguiente) {
        this.siguiente = siguiente;
    }
    
    
}
