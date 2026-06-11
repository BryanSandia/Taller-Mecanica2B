/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package mecanica;

/**
 *
 * @author gemzie
 */
public class Trabajo {
   protected int idTrabajo;
    protected String descripcion;
    protected int horas;
    protected int plazo;
    protected boolean finalizado;

    public Trabajo(int idTrabajo, String descripcion, int horas, int plazo) {
        this.idTrabajo = idTrabajo;
        this.descripcion = descripcion;
        this.horas = horas;
        this.plazo = plazo;
        this.finalizado = false;
    }

    public int getIdTrabajo() {
        return idTrabajo;
    }

    public void setIdTrabajo(int idTrabajo) {
        this.idTrabajo = idTrabajo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        if (!this.finalizado) {
            this.horas = horas;
        }
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void finalizar() {
        this.finalizado = true;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public double cobrarPrecio(){
        double Preciototal = horas * 30;
     return Preciototal;   
    }
    
}
