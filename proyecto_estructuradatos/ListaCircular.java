/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_estructuradatos;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class ListaCircular {

    private NodoC cabeza;
    private NodoC cola;

    public ListaCircular() {
        this.cabeza = null;
        this.cola = null;
        inicializarReservas();

    }

     
    private void inicializarReservas() {
        DatoC reserva1 = new DatoC();
        reserva1.setOrigen("Londres");
        reserva1.setDestino("Paris");
        reserva1.setNumeroVuelo("1234");
        reserva1.setPrecio(150.0);
        agregarVuelo(reserva1);

        DatoC reserva2 = new DatoC();
        reserva2.setOrigen("Peru");
        reserva2.setDestino("Brasil");
        reserva2.setNumeroVuelo("5678");
        reserva2.setPrecio(500.0);
        agregarVuelo(reserva2);
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
            JOptionPane.showMessageDialog(null, "No hay vuelos registrados");
            return;
        }

        NodoC actual = cabeza;
        StringBuilder sb = new StringBuilder("Vuelos registrados:\n");
        do {
            sb.append(actual.getDato()).append("\n");
            actual = actual.getSiguiente();
        } while (actual != cabeza);

        JOptionPane.showMessageDialog(null, sb.toString());
    }

    public DatoC buscarVuelo(String numeroVuelo) {
        if (cabeza == null) {
            JOptionPane.showMessageDialog(null, "No hay vuelos registrados.");
            return null;
        }

        NodoC actual = cabeza;
        do {
            if (actual.getDato().getNumeroVuelo().equals(numeroVuelo)) {
                return actual.getDato();
            }
            actual = actual.getSiguiente();
        } while (actual != cabeza);

        JOptionPane.showMessageDialog(null, "Vuelo con número " + numeroVuelo + " no encontrado.");
        return null;
    }

    public void navegarReservas() {
        if (cabeza == null) {
            System.out.println("No hay reservas.");
            return;
        }

        NodoC actual = cabeza;
        String opcion = "";

        while (!opcion.equals("3")) {
            System.out.println("Reserva actual: " + actual.getDato());
            opcion = JOptionPane.showInputDialog(null,
                    "1. Siguiente Reserva\n"
                    + "2. Reserva Anterior\n"
                    + "3. Salir\n"
                    + "Seleccione una opción\n"
            );

            switch (opcion) {
                case "1":
                    actual = actual.getSiguiente(); // Avanza a la siguiente reserva
                    break;
                case "2":
                    // Retroceder a la reserva anterior
                    NodoC temp = cabeza;
                    while (temp.getSiguiente() != actual) {
                        temp = temp.getSiguiente();
                    }
                    actual = temp; // Mover al nodo anterior
                    break;
                case "3":
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Ingrese una opción válida");
            }
        }
    }

}
