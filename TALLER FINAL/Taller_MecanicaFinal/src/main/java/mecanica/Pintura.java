/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package mecanica;

/**
 *
 * @author gemzie
 */
public class Pintura {
    private String idPintura;
    private String nombre;
    private double precio;

    public Pintura(String nombre, double precio, String idPieza) {
        this.idPintura = idPieza;
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getidPintura() {
        return idPintura;
    }

    public void setidPintura(String idPintura) {
        this.idPintura = idPintura;
    }

}
