/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_estructuradatos;

import javax.swing.JOptionPane;

public class ReservaVuelos {

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

        while (!opcion.equals("4")) { 
            opcion = JOptionPane.showInputDialog(null, 
                "1. Consultar Vuelos Disponibles\n"
                + "2. Reservar Vuelo\n"
                + "3. Mostrar Últimos Vuelos Consultados\n"
                + "4. Salir\n"
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
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema ");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Intente de nuevo ");
            }
        }
    }
}