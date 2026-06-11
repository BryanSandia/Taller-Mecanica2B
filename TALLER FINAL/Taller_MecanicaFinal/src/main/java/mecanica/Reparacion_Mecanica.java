
package mecanica;

/**
 *
 * @author gemzie
 */

import java.util.ArrayList;
public class Reparacion_Mecanica extends Reparaciones{
    private ArrayList<Pieza_Mecanica> piezas;
    private double precioMaterialPieza;

    public Reparacion_Mecanica(ArrayList<Pieza_Mecanica> piezas, String estado, String material, int idTrabajo, String descripcion, int horas, int plazo) {
        super(estado, material, idTrabajo, descripcion, horas, 14);
        this.piezas = piezas;
        this.precioMaterialPieza = 0;
    }

    public Reparacion_Mecanica(String estado, String material, int idTrabajo, String descripcion, int horas, int plazo) {
        super(estado, material, idTrabajo, descripcion, horas, 14);
        this.piezas = new ArrayList<>();
        this.precioMaterialPieza = 0;
    }



    public void setPiezas(ArrayList<Pieza_Mecanica> piezas) {
        this.piezas = piezas;
    }


    public void CalcularPrecioReparacion(){
        double totalReparacion=0;
        for (Pieza_Mecanica pieza : piezas) {
            totalReparacion += pieza.getPrecio();
        }
        this.precioMaterialPieza= (totalReparacion * 1.1);
        this.Preciototal = this.precioMaterialPieza + super.cobrarPrecio(); // Asigno el precio material de reparacion Mecanica + tprecio de trabajo por hora
    }
}
