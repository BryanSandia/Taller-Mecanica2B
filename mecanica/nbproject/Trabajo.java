
package mecanica;


public class Trabajo {
    protected int idTrabajo;
    protected String descripcion;
    protected int horas;
    protected int plazo;

    public Trabajo(int idTrabajo, String descripcion, int horas, int plazo) {
        this.idTrabajo = idTrabajo;
        this.descripcion = descripcion;
        this.horas = horas;
        this.plazo = plazo;
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
        this.horas = horas;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public double cobrarPrecio(){
        
    }
    
   
    
    
  
}
