/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package mecanica;

/**
 *
 * @author gemzie
 */
import java.util.ArrayList;

public class Chapa_Pintura extends Reparaciones{
    //ANIADIR EXTENDS DESPUES
    private ArrayList<Pintura> pinturas;
    private double precioMaterialPintura;

    public Chapa_Pintura(ArrayList<Pintura> pinturas, String estado, String material, int idTrabajo, String descripcion, int horas, int plazo) {
        super(estado, material, idTrabajo, descripcion, horas, 21);
        this.pinturas = pinturas;
        this.precioMaterialPintura = 0;
    }

    public Chapa_Pintura(String estado, String material, int idTrabajo, String descripcion, int horas, int plazo) {
        super(estado, material, idTrabajo, descripcion, horas, 21);
        this.pinturas = new ArrayList<>();
        this.precioMaterialPintura = 0;
    }

    
    
    public double CalcularPrecioReparacion(){
        // Sintaxis: for (TipoDato nombreVariable : nombreLista)
        double totalReparacion=0;
        for (Pintura pintura : pinturas) {
            totalReparacion += pintura.getPrecio();
        }
        totalReparacion = totalReparacion * 1.3;
        return totalReparacion;
    }

    public void CalcularPrecioPintura(){
        double totalReparacion=0;
        for (Pintura pintura : pinturas) {
            totalReparacion += pintura.getPrecio();
        }
        this.precioMaterialPintura = (totalReparacion * 1.3);
        this.Preciototal = this.precioMaterialPintura  + super.cobrarPrecio(); //Asigno el precio material de reparacion Chapa y pintura + precio de trabajo por hora
    }
}
