/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_estructuradatos;

/**
 *
 *
 */
public class Pasajero {

    private String nombre;
    private String ID;
    private String nacionalidad;

    public Pasajero(String nombre, String ID, String nacionalidad) {
        this.nombre = nombre;
        this.ID = ID;
        this.nacionalidad = nacionalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDocumentoIdentidad() {
        return ID;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    @Override
    public String toString() {
        return "Pasajero{"
                + "nombre='" + nombre + '\''
                + ", documentoIdentidad='" + ID + '\''
                + ", nacionalidad='" + nacionalidad + '\''
                + '}';
    }

}
