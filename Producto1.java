public class Producto1 {
    public String codProducto;
    public String nombre;
    public double precio;
    private double costo;
    public String descrip;

    public Producto1(String codProducto, String nombre, double precio, double costo, String descrip) {
        this.codProducto = codProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.costo = costo;
        this.descrip = descrip;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

}
