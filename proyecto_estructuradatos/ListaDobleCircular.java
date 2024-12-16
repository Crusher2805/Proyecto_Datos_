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

       public void mostrarMenu() {
        String opcion = "";

        while (!opcion.equals("3")) {
            opcion = JOptionPane.showInputDialog(null,
                     "1. Mostrar Reservas Adelante\n"
                    + "2. Mostrar Reservas Atrás\n"
                    + "3. Salir\n"
                    + "Seleccione una opción\n"
            );

            switch (opcion) {
                case "1":
                   mostrarReservasAdelante();
                case "2":
                    mostrarReservasAtras();
                    break;
                case "3":
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida. Ingrese una opcion valida");
            }
        }
    }

}

