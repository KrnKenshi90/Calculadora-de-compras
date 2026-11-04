//Guarda los datos de un artículo de la compra y calcula su subtotal

public class Articulo {

    private String nombre;
    private double precio;
    private int cantidad;
    private double descuento; // En porcentaje por ejemplo 10 = 10%

    public Articulo(String nombre, double precio, int cantidad, double descuento) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.descuento = descuento;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getDescuento() {
        return descuento;
    }

    // Precio por cantidad esto antes de aplicar el descuento
    public double calcularImporte() {
        return precio * cantidad;
    }

    // Cuanto dinero se descuenta segun el porcentaje
    public double calcularMontoDescuento() {
        return redondear(calcularImporte() * descuento / 100);
    }

    public double calcularSubtotal() {
        return redondear(calcularImporte() - calcularMontoDescuento());
    }

    // Redondea a 2 decimales para evitar resultados como 89.9999
    private static double redondear(double valor) {
        return Math.round(valor * 100.0) / 100.0;
    }
}
