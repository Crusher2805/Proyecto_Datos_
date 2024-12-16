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
    private List<DatoC> vuelos;
    

    public ListaCircular() {
        this.cabeza = null;
        this.cola = null;
        this.vuelos = new ArrayList<>();
    }

    public void agregarVuelo(DatoC dato) {
        vuelos.add(dato); 
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

    public List<DatoC> buscarVuelosPorOrigen(String origen) {
        return buscarVuelosPorOrigenRecursivo(origen, 0);
    }

    private List<DatoC> buscarVuelosPorOrigenRecursivo(String origen, int index) {
        List<DatoC> resultados = new ArrayList<>();
        if (index >= vuelos.size()) {
            return resultados;
        }
        DatoC vueloActual = vuelos.get(index);
        if (vueloActual.getOrigen().equalsIgnoreCase(origen)) {
            resultados.add(vueloActual); // Agregar vuelo si coincide con el origen
        }
        // Llamada recursiva para el siguiente índice
        resultados.addAll(buscarVuelosPorOrigenRecursivo(origen, index + 1));
        return resultados;
    }

    // Metodo recursivo para buscar vuelos por destino
    public List<DatoC> buscarVuelosPorDestino(String destino) {
        return buscarVuelosPorDestinoRecursivo(destino, 0);
    }

    private List<DatoC> buscarVuelosPorDestinoRecursivo(String destino, int index) {
        List<DatoC> resultados = new ArrayList<>();
        if (index >= vuelos.size()) {
            return resultados;
        }
        DatoC vueloActual = vuelos.get(index);
        if (vueloActual.getDestino().equalsIgnoreCase(destino)) {
            resultados.add(vueloActual); // Agregar vuelo si coincide con el destino
        }
        // Llamada recursiva para el siguiente índice
        resultados.addAll(buscarVuelosPorDestinoRecursivo(destino, index + 1));
        return resultados;
    }

    // Metodo recursivo para buscar un vuelo por numero
    public DatoC buscarVueloPorNumero(String numeroVuelo) {
        return buscarVueloPorNumeroRecursivo(numeroVuelo, 0);
    }

    private DatoC buscarVueloPorNumeroRecursivo(String numeroVuelo, int index) {
        if (index >= vuelos.size()) {
            return null;
        }
        DatoC vueloActual = vuelos.get(index);
        if (vueloActual.getNumeroVuelo().equalsIgnoreCase(numeroVuelo)) {
            return vueloActual; // Retornar el vuelo si coincide
        }

        // Llamada recursiva para el siguiente índice
        return buscarVueloPorNumeroRecursivo(numeroVuelo, index + 1);
    }

}