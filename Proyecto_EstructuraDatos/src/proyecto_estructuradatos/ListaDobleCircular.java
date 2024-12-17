/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_estructuradatos;

import javax.swing.JOptionPane;

/**
 *
 * @author sebas
 */
public class ListaDobleCircular {

    private NodoDobleCircular cabeza;

    public ListaDobleCircular() {
        this.cabeza = null;
        inicializarReservas();
    }

    private void inicializarReservas() {
        // Agregar las reservas que se deseen
        DatoC reserva1 = new DatoC();
        reserva1.setOrigen("Londres");
        reserva1.setDestino("Paris");
        reserva1.setNumeroVuelo("1234");
        reserva1.setPrecio(150.0);
        agregarReserva(reserva1);

        DatoC reserva2 = new DatoC();
        reserva2.setOrigen("Peru");
        reserva2.setDestino("Brasil");
        reserva2.setNumeroVuelo("5678");
        reserva2.setPrecio(500.0);
        agregarReserva(reserva2);
    }

    public void agregarReserva(DatoC dato) {
        NodoDobleCircular nuevo = new NodoDobleCircular(dato);
        System.out.println("Agregando reserva: " + dato); // Para depuracion
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

    public void mostrarReservas() {
        if (cabeza == null) {
            JOptionPane.showMessageDialog(null, "No hay reservas disponibles.");
            return;
        }

        StringBuilder reservas = new StringBuilder();
        NodoDobleCircular actual = cabeza;

        do {
            reservas.append(actual.dato.toString()).append("\n");
            actual = actual.siguiente;
        } while (actual != cabeza);

        JOptionPane.showMessageDialog(null, reservas.toString(), "Reservas Disponibles", JOptionPane.INFORMATION_MESSAGE);
    }

    public void buscarEliminarReserva(String criterio) {
        if (cabeza == null) {
            System.out.println("No hay reservas para eliminar.");
            return;
        }

        NodoDobleCircular actual = cabeza;
        boolean encontrado = false;

        // Buscar reservas que coincidan con el criterio
        do {
            if (actual.dato.getNumeroVuelo().equals(criterio)
                    || actual.dato.getOrigen().equalsIgnoreCase(criterio)
                    || actual.dato.getDestino().equalsIgnoreCase(criterio)) {
                encontrado = true;
                confirmarEliminacion(actual);
                break;
            }
            actual = actual.siguiente;
        } while (actual != cabeza);

        if (!encontrado) {
            System.out.println("No se encontraron reservas que coincidan con el criterio.");
            return;
        }

    }

    public void confirmarEliminacion(NodoDobleCircular actual) {
        int respuesta = JOptionPane.showConfirmDialog(null,
                "Desea eliminar esta reserva " + actual.dato + "?",
                "Confirmar Eliminacion",
                JOptionPane.YES_NO_OPTION);

        if (respuesta == JOptionPane.YES_OPTION) {
            eliminarReserva(actual.dato.getNumeroVuelo());
        } else {
            JOptionPane.showMessageDialog(null, "Eliminacion cancelada.");
        }
    }

    public void eliminarReserva(String numeroVuelo) {
        if (cabeza == null) {
            JOptionPane.showMessageDialog(null, "No hay reservas para eliminar ");
            return;
        }

        NodoDobleCircular actual = cabeza;
        do {
            if (actual.dato.getNumeroVuelo().equals(numeroVuelo)) {
                if (actual.siguiente == cabeza) {
                    cabeza = null;
                } else {
                    NodoDobleCircular anterior = actual.anterior;
                    NodoDobleCircular siguiente = actual.siguiente;
                    anterior.siguiente = siguiente;
                    siguiente.anterior = anterior;
                    if (actual == cabeza) {
                        cabeza = siguiente;
                    }
                }
                JOptionPane.showMessageDialog(null, "Reserva eliminada " + actual.dato);
                return;
            }
            actual = actual.siguiente;
        } while (actual != cabeza);

        JOptionPane.showMessageDialog(null, "Reserva no encontrada ");
    }
}
