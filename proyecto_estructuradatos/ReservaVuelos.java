/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_estructuradatos;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class ReservaVuelos {

    //Estructura de pilas
    private NodoP arriba;
    private int maximo;
    private int tamannio;

    public ReservaVuelos() {
        this.arriba = null;
        this.maximo = 5;
        this.tamannio = 0;
        mostrarMenu();
    }

    public void apilar(String numeroVuelo, String origen, String destino, double precio) {
        NodoP nuevoNodo = new NodoP(numeroVuelo, origen, destino, precio);
        if (tamannio >= maximo) {
            desapilar();
        }
        nuevoNodo.siguiente = arriba;
        arriba = nuevoNodo;
        tamannio++;
    }

    public void desapilar() {
        if (arriba != null) {
            arriba = arriba.siguiente;
            tamannio--;
        }
    }

    public void mostrarUltimoVuelo() {
        NodoP actual = arriba;
        if (actual == null) {
            JOptionPane.showMessageDialog(null, "No existen vuelos consultados ");
        }
        while (actual != null) {
            JOptionPane.showMessageDialog(null, actual.toString());
            actual = actual.siguiente;
        }
    }

    public void consultarVuelos() {
        JOptionPane.showMessageDialog(null,
                "1. HD123, Shangai, Moscu, $300.00\n"
                + "2. FK456, Londres, Madrid, $150.00\n"
                + "3. UW852, Pekín, Tokio, $400.00\n"
                + "4. KA753, Sídney, Melbourne, $200.00\n"
                + "5. KY951, Toronto, Miami, $250.00\n"
        );
    }

    public void reservarVuelo(String numeroVuelo) {
        switch (numeroVuelo) {
            case "HD123":
                apilar("HD123", "Shangai", "Moscu", 300.00);
                JOptionPane.showMessageDialog(null, "Reserva realizada para: HD123, Shangai, Moscu, 300.00");
                break;
            case "FK456":
                apilar("FK456", "Londres", "Madrid", 150.00);
                JOptionPane.showMessageDialog(null, "Reserva realizada para: FK456, Londres, Madrid, 150.00");
                break;
            case "UW852":
                apilar("UW852", "Pekín", "Tokio", 400.00);
                JOptionPane.showMessageDialog(null, "Reserva realizada para: UW852, Pekín, Tokio, 400.00");
                break;
            case "KA753":
                apilar("KA753", "Sídney", "Melbourne", 200.00);
                JOptionPane.showMessageDialog(null, "Reserva realizada para: KA753, Sídney, Melbourne, 200.00");
                break;
            case "KY951":
                apilar("KY951", "Toronto", "Miami", 250.00);
                JOptionPane.showMessageDialog(null, "Reserva realizada para: KY951, Toronto, Miami, 250.00");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Vuelo no encontrado ");
                break;
        }
    }

    public void mostrarMenu() {
        String opcion = "";
        Cola cola = new Cola();

        while (!opcion.equals("7")) {
            opcion = JOptionPane.showInputDialog(null,
                    "1. Consultar Vuelos Disponibles\n"
                    + "2. Reservar Vuelo\n"
                    + "3. Mostrar Últimos Vuelos Consultados\n"
                    + "4. Mostrar Reservas Ya Creadas\n"
                    + "5. Mostrar lista de pasajeros\n"
                    + "6. Mostrar lista de vuelos\n"
                    + "7. Navegar Reservas\n"
                    + "8. \n"
                    + "9. Salir\n"
                    + "Seleccione una opción\n"
            );

            switch (opcion) {
                case "1":
                    consultarVuelos();
                    break;
                case "2":
                    String numeroVuelo = JOptionPane.showInputDialog("Ingrese el número de vuelo a reservar ");
                    reservarVuelo(numeroVuelo);
                    break;
                case "3":
                    mostrarUltimoVuelo();
                    break;
                case "4":
                    DatoC datoVuelo = new DatoC();
                    datoVuelo.setOrigen("Nueva York");
                    datoVuelo.setDestino("Toronto");
                    datoVuelo.setNumeroVuelo("12-E");
                    datoVuelo.setPrecio(200);
                    cola.encolar(datoVuelo);
                    cola.imprimirCola();
                    break;
                case "5":
                    ListaPasajeros listaPasajeros = new ListaPasajeros();

                    listaPasajeros.agregarPasajero(new Pasajero("Keren Cassa", "12345678", "Espanola"));
                    listaPasajeros.agregarPasajero(new Pasajero("Gerardo Montero", "87654321", "Paraguayo"));
                    listaPasajeros.agregarPasajero(new Pasajero("Jemi Moreira", "11223344", "Colombiana"));
                    System.out.println("Lista de pasajeros registrados:");
                    listaPasajeros.mostrarPasajeros();

                    String documentoBusqueda = "87654321";
                    Pasajero pasajeroEncontrado = listaPasajeros.buscarPasajero(documentoBusqueda);
                    if (pasajeroEncontrado != null) {
                        System.out.println("\nPasajero encontrado:");
                        System.out.println(pasajeroEncontrado);
                    } else {
                        System.out.println("\nNo se encontró un pasajero con el documento: " + documentoBusqueda);
                    }
                    break;

                case "6":
                    ListaDobleCircular lista = new ListaDobleCircular();
                    lista.mostrarMenu();

                    break;

                case "7":
                    ListaCircular listaC = new ListaCircular();
                    listaC.navegarReservas();

                case "9":
                    int confirm = JOptionPane.showConfirmDialog(null,
                            "Desea salir \nPerder sus reservas no confirmadas.",
                            "Confirmar Salida",
                            JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(null, "Saliendo del sistema.");
                        System.exit(0);
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida. Intente de nuevo.");
            }
        }
    }
}
