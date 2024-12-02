/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package  proyecto_estructuradatos;

/**
 *
 * @author sebas
 */
public class Cola {
    private NodoC frente;  
    private NodoC fin;     

    public Cola() {
        this.frente = null;
        this.fin = null;
    }

    
    public void encolar(DatoC dato) {
        NodoC nuevoNodo = new NodoC(dato);
        if (fin != null) {
            fin.setSiguiente(nuevoNodo); 
        }
        fin = nuevoNodo; 
        if (frente == null) {
            frente = nuevoNodo; 
        }
    }

    
    public void desencolar() {
        if (frente != null) {
            frente = frente.getSiguiente();
            if (frente == null) {
                fin = null; 
            }
        }
    }

 
    public void imprimirCola() {
        NodoC actual = frente;
        while (actual != null) {
            System.out.print(actual.getDato());
            actual = actual.getSiguiente();
        }
        System.out.println();
    }

   
}
