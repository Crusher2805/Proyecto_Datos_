/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_estructuradatos;

import javax.swing.JOptionPane;
import java.time.LocalDateTime;
import java.util.Arrays;

public class ReservaVuelos {
    // Estructura de pilas
    private NodoP arriba;
    private int maximo;
    private int tamannio;

    // Sistema de reservas aéreas
    private SistemaReservasAereas sistema;

    public ReservaVuelos() {
        this.arriba = null;
        this.maximo = 5;
        this.tamannio = 0;
        // Inicialización de los aeropuertos
        this.sistema = new SistemaReservasAereas();
        mostrarMenu();
    }

    // Funciones de la pila
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
            JOptionPane.showMessageDialog(null, "No existen vuelos consultados.");
        }
        while (actual != null) {
            JOptionPane.showMessageDialog(null, actual.toString());
            actual = actual.siguiente;
        }
    }

    public void consultarVuelos() {
        sistema.mostrarAeropuertos();
    }

    // Funciones del sistema de reservas aéreas
    public void agregarVuelo() {
        try {
            String origen = JOptionPane.showInputDialog("Ingrese el número de aeropuerto de origen (0 a " + (sistema.getAeropuertos().size() - 1) + ")");
            String destino = JOptionPane.showInputDialog("Ingrese el número de aeropuerto de destino (0 a " + (sistema.getAeropuertos().size() - 1) + ")");
            String precioStr = JOptionPane.showInputDialog("Ingrese el precio del vuelo");
            String tiempoStr = JOptionPane.showInputDialog("Ingrese el tiempo del vuelo");

            int origenIdx = Integer.parseInt(origen);
            int destinoIdx = Integer.parseInt(destino);
            int precio = Integer.parseInt(precioStr); 
            int tiempo = Integer.parseInt(tiempoStr); 

            if (origenIdx < 0 || origenIdx >= sistema.getAeropuertos().size() || destinoIdx < 0 || destinoIdx >= sistema.getAeropuertos().size()) {
                JOptionPane.showMessageDialog(null, "Índices fuera de rango. Intente de nuevo.");
                return;
            }

            sistema.agregarVueloPrecio(origenIdx, destinoIdx, precio);  // Agregar vuelo con precio
            sistema.agregarVueloTiempo(origenIdx, destinoIdx, tiempo); // Agregar vuelo con tiempo
            JOptionPane.showMessageDialog(null, "Vuelo agregado exitosamente: Precio " + sistema.obtenerPrecio(origenIdx, destinoIdx));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese solo números válidos.");
        }
    }

    public void reservarVuelo(String numeroVuelo, String origen, String destino) {
        try {
            int origenIdx = Integer.parseInt(origen);
            int destinoIdx = Integer.parseInt(destino);
            int precio = sistema.obtenerPrecio(origenIdx, destinoIdx);

            apilar(numeroVuelo, origen, destino, precio);
            JOptionPane.showMessageDialog(null, "Vuelo " + numeroVuelo + " reservado de " + sistema.getAeropuertos().get(origenIdx) + " a " + sistema.getAeropuertos().get(destinoIdx));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese solo números válidos para los índices.");
        }
    }

    public void mostrarMatriz() {
        String tipo = JOptionPane.showInputDialog(null, "¿Desea ver la matriz de Precios o de Tiempos?");
        if (tipo.equalsIgnoreCase("Precios")) {
            sistema.mostrarMatriz("Precios");
        } else if (tipo.equalsIgnoreCase("Tiempos")) {
            sistema.mostrarMatriz("Tiempos");
        } else {
            JOptionPane.showMessageDialog(null, "Opción no válida.");
        }
    }
    
    private void ordenarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            Arrays.sort(matriz[i]);  // Ordenar cada fila de manera ascendente
        }
    }

    public void mostrarMenu() {
        String opcion = "";
        Cola cola = new Cola();

        while (!opcion.equals("12")) {
            opcion = JOptionPane.showInputDialog(null,
                    "1. Consultar Vuelos Disponibles\n"
                    + "2. Reservar Vuelo\n"
                    + "3. Mostrar Últimos Vuelos Consultados\n"
                    + "4. Mostrar Reservas Ya Creadas\n"
                    + "5. Mostrar lista de pasajeros\n"
                    + "6. Eliminar Vuelos\n"
                    + "7. Navegar Reservas\n"
                    + "8. Organizar los vuelos por fecha y hora de salida\n"
                    + "9. Agregar vuelo\n"
                    + "10. Mostrar Matriz de Vuelos\n"
                    + "11. Ver Matriz de Precios o Tiempos\n"
                    + "12. Salir\n"
                    + "Seleccione una opción\n"
            );

            switch (opcion) {
                case "1":
                    consultarVuelos();
                    break;
                case "2":
                    String numeroVuelo = JOptionPane.showInputDialog("Ingrese el número de vuelo a reservar ");
                    String origen = JOptionPane.showInputDialog("Ingrese el origen del vuelo ");
                    String destino = JOptionPane.showInputDialog("Ingrese el destino del vuelo ");
                    reservarVuelo(numeroVuelo, origen, destino);
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
                    String criterio = JOptionPane.showInputDialog("Ingrese el número de vuelo, origen o destino para eliminar:");
                    lista.buscarEliminarReserva(criterio);
                    break;

                case "7":
                    ListaCircular listaC = new ListaCircular();
                    listaC.navegarReservas();
                    break;

                case "8":
                    ArbolB arbolVuelos = new ArbolB();

                    // Crear vuelos y agregarlos al árbol
                    DatoC vuelo1 = new DatoC();
                    vuelo1.setOrigen("Londres");
                    vuelo1.setDestino("Paris");
                    vuelo1.setNumeroVuelo("1234");
                    vuelo1.setPrecio(150.0);
                    vuelo1.setFechaHoraSalida(LocalDateTime.of(2023, 12, 25, 10, 30));
                    arbolVuelos.insertarVuelo(vuelo1);

                    DatoC vuelo2 = new DatoC();
                    vuelo2.setOrigen("Peru");
                    vuelo2.setDestino("Brasil");
                    vuelo2.setNumeroVuelo("5678");
                    vuelo2.setPrecio(500.0);
                    vuelo2.setFechaHoraSalida(LocalDateTime.of(2023, 12, 24, 18, 0));
                    arbolVuelos.insertarVuelo(vuelo2);

                    DatoC vuelo3 = new DatoC();
                    vuelo3.setOrigen("Madrid");
                    vuelo3.setDestino("Nueva York");
                    vuelo3.setNumeroVuelo("9101");
                    vuelo3.setPrecio(300.0);
                    vuelo3.setFechaHoraSalida(LocalDateTime.of(2023, 12, 26, 7, 45));
                    arbolVuelos.insertarVuelo(vuelo3);

                    // Mostrar vuelos ordenados por fecha y hora de salida
                    System.out.println("Vuelos ordenados por fecha y hora de salida:");
                    arbolVuelos.mostrarVuelosOrdenados();
                    break;

                case "12":
                    int confirm = JOptionPane.showConfirmDialog(null,
                            "Desea salir \nPerder sus reservas no confirmadas.",
                            "Confirmar Salida",
                            JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(null, "Saliendo del sistema.");
                        System.exit(0);
                    }
                    break;

                case "9":
                    agregarVuelo();
                    break;

                case "10":
                    mostrarMatriz();
                    break;

                case "11":
                    // Ver la matriz de precios o tiempos
                    mostrarMatriz();
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Intente de nuevo.");
            }
        }
    }
}
