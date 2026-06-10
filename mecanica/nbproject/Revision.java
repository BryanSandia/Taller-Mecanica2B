
package mecanica;


public class Revision {
  
    public Revision() {
        super(idTrabajo,descripcion,horas,plazo);
    }
    
    public double calcularPrecioRevision(){
        double precio;
        precio = super.cobrarprecio();
        return precio + 20;
    }
    
}
