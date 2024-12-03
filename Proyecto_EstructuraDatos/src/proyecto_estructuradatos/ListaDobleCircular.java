/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_estructuradatos;

/**
 *
 * @author sebas
 */
public class ListaDobleCircular {
    private NodoDobleCircular cabeza;

    public ListaDobleCircular() {
        this.cabeza = null;
    }

    public void agregarReserva(DatoC dato) {
    NodoDobleCircular nuevo = new NodoDobleCircular(dato);
    System.out.println("Agregando reserva: " + dato); // Para depuración
    if (cabeza == null) {
        cabeza = nuevo;
        cabeza.setSiguiente(cabeza);
        cabeza.setAnterior(cabeza);
    } else {
        NodoDobleCircular ultimo = cabeza.getAnterior();
        ultimo.setSiguiente(nuevo);
        nuevo.setAnterior(ultimo);
        nuevo.setSiguiente(cabeza);
        cabeza.setAnterior(nuevo);
    }
}


    public void mostrarReservasAdelante() {
        if (cabeza == null) {
            System.out.println("No hay vuelos.");
            return;
        }
        NodoDobleCircular actual = cabeza;
        do {
            System.out.println(actual.getDato());
            actual = actual.getSiguiente();
        } while (actual != cabeza);
    }

    public void mostrarReservasAtras() {
    if (cabeza == null) {
        System.out.println("No hay vuelos.");
        return;
    }
    NodoDobleCircular actual = cabeza.getAnterior(); 
    do {
        System.out.println(actual.getDato());
        actual = actual.getAnterior();
    } while (actual != cabeza);
}

}

