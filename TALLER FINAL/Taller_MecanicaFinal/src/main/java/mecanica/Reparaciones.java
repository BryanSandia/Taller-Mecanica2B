/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package mecanica;

/**
 *
 * @author gemzie
 */
public class Reparaciones extends Trabajo{

    protected String estado;
    protected String material;
    protected double Preciototal;

    public Reparaciones(String estado, String material, int idTrabajo, String descripcion, int horas, int plazo) {
        super(idTrabajo, descripcion, horas, plazo);
        this.estado = estado;
        this.material = material;
        this.Preciototal =0;
    }



    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getPreciototal() {
        return Preciototal;
    }

    public void setPreciototal(double Preciototal) {
        this.Preciototal = Preciototal;
    }



}
