
package mecanica;


public class Reparacion extends Trabajo{
    protected double precioMaterial;
    protected String estado;
    protected String material;

     public Raparaciones(double precioMaterial, String estado, String material) {
        super(idTrabajo,descripcion,horas,plazo);
        this.precioMaterial = precioMaterial;
        this.estado = estado;
        this.material = material;
    }

    public double getPrecioMaterial() {
        return precioMaterial;
    }

    public void setPrecioMaterial(double precioMaterial) {
        this.precioMaterial = precioMaterial;
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
        this.material = material;12
    }
}

