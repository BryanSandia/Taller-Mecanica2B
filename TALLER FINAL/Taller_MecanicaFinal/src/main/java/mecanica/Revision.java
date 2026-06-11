/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package mecanica;

/**
 *
 * @author gemzie
 */
public class Revision extends Trabajo{

    public Revision(int idTrabajo, String descripcion, int horas, int plazo) {
        super(idTrabajo, descripcion, horas, 7);
    }

    public double calcularPrecioRevision(){
        double precio;
        precio = super.cobrarPrecio();
        return precio + 20;
    }

}
