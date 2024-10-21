/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_estructuradatos;

public class Proyecto_EstructuraDatos {

    public static void main(String[] args) {
       ReservaVuelos vuelos = new ReservaVuelos();
       vuelos.mostrarMenu();

        Cola cola = new Cola();
        
        DatoC datoVuelo = new DatoC();
        datoVuelo.setOrigen("Nueva York");
        datoVuelo.setDestino("Toronto");
        datoVuelo.setNumeroVuelo("12-E");
        datoVuelo.setPrecio(200);

    
        cola.encolar(datoVuelo);

    
        cola.imprimirCola();
    }
    
}
