/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reservavuelos;

/**
 *
 * @author sebas
 */
public class DatoC {
    private String Origen;
    private String Destino;
    private String NumeroVuelo;
    private double Precio;

    public DatoC() {
        this.Origen = "";
        this.Destino = "";
        this.NumeroVuelo = "";
        this.Precio = 0;
    }
    
    

    public String getOrigen() {
        return Origen;
    }

    public void setOrigen(String Origen) {
        this.Origen = Origen;
    }

    public String getDestino() {
        return Destino;
    }

    public void setDestino(String Destino) {
        this.Destino = Destino;
    }

    public String getNumeroVuelo() {
        return NumeroVuelo;
    }

    public void setNumeroVuelo(String NumeroVuelo) {
        this.NumeroVuelo = NumeroVuelo;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }
    @Override
    public String toString() {
        return "Vuelo desde " + Origen + " a " + Destino + 
               " (Número de vuelo: " + NumeroVuelo + 
               ", Precio: $" + Precio + ")";
    }
    
}
