/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_estructuradatos;

/**
 *
 * 
 */
public class ArbolB {
    private NodoArbol raiz;

    public ArbolB() {
        this.raiz = null;
    }

    // Método para insertar un vuelo en el árbol
    public void insertarVuelo(DatoC vuelo) {
        raiz = insertarRecursivo(raiz, vuelo);
    }

    private NodoArbol insertarRecursivo(NodoArbol nodo, DatoC vuelo) {
        if (nodo == null) {
            return new NodoArbol(vuelo); // Crear un nuevo nodo con el vuelo
        }

        // Comparar las fechas y horas de salida
        if (vuelo.getFechaHoraSalida().isBefore(nodo.getVuelo().getFechaHoraSalida())) {
            nodo.setIzquierdo(insertarRecursivo(nodo.getIzquierdo(), vuelo));
        } else {
            nodo.setDerecho(insertarRecursivo(nodo.getDerecho(), vuelo));
        }

        return nodo;
    }

    // Método para recorrer el árbol en enorden
    public void mostrarVuelosOrdenados() {
        if (raiz == null) {
            System.out.println("No hay vuelos registrados.");
            return;
        }
        mostrarenOrden(raiz);
    }

    private void mostrarenOrden(NodoArbol nodo) {
        if (nodo != null) {
            mostrarenOrden(nodo.getIzquierdo());
            System.out.println(nodo.getVuelo());
            mostrarenOrden(nodo.getDerecho());
        }
    }
}