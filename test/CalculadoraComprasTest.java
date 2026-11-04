import java.util.ArrayList;

// Pruebas de la calculadora y se ejecutan con main

public class CalculadoraComprasTest {

    static int pasadas = 0;
    static int fallidas = 0;

    public static void main(String[] args) {
        System.out.println("Ejecutando pruebas...\n");

        pruebaNormalUnArticulo();
        pruebaNormalVariosArticulos();
        pruebaLimiteDescuentoCien();
        pruebaLimiteCantidadMinimaPrecioCero();
        pruebaEntradaInvalidaTexto();
        pruebaEntradaInvalidaNegativo();

        System.out.println("\nPasadas: " + pasadas + " | Fallidas: " + fallidas);
    }

    // Prueba 1 - Normal: 2 unidades de 50 con 10% de descuento
    static void pruebaNormalUnArticulo() {
        Articulo a = new Articulo("Cuaderno", 50, 2, 10);
        verificar("P1 Normal - un artículo", 90.00, a.calcularSubtotal());
    }

    // Prueba 2 - Normal: varios artículos, se revisa el total
    static void pruebaNormalVariosArticulos() {
        ArrayList<Articulo> carrito = new ArrayList<>();
        carrito.add(new Articulo("Lapicero", 12.50, 3, 20)); // 30.00
        carrito.add(new Articulo("Borrador", 8, 2, 0));       // 16.00
        carrito.add(new Articulo("Mochila", 20, 1, 45));      // 11.00
        verificar("P2 Normal - varios artículos", 57.00, CalculadoraCompras.calcularTotal(carrito));
    }

    // Prueba 3 - Límite: descuento del 100%, el subtotal debe quedar en 0
    static void pruebaLimiteDescuentoCien() {
        Articulo a = new Articulo("Regalo", 25, 4, 100);
        verificar("P3 Límite - descuento 100%", 0.00, a.calcularSubtotal());
    }

    // Prueba 4 - Límite: precio 0 y cantidad mínima (1)
    static void pruebaLimiteCantidadMinimaPrecioCero() {
        Articulo a = new Articulo("Muestra", 0, 1, 0);
        verificar("P4 Límite - precio 0 y cantidad 1", 0.00, a.calcularSubtotal());
    }

    // Prueba 5 - Inválida: el usuario escribe letras en el precio
    static void pruebaEntradaInvalidaTexto() {
        try {
            CalculadoraCompras.convertirDecimal("abc");
            fallo("P5 Inválida - precio con letras", "no lanzó error");
        } catch (IllegalArgumentException e) {
            paso("P5 Inválida - precio con letras");
        }
    }

    // Prueba 6 - Inválida: precio negativo
    static void pruebaEntradaInvalidaNegativo() {
        try {
            CalculadoraCompras.validarPrecio(-5);
            fallo("P6 Inválida - precio negativo", "no lanzó error");
        } catch (IllegalArgumentException e) {
            paso("P6 Inválida - precio negativo");
        }
    }

    // Metodos de apoyo para verificar resultados

    static void verificar(String nombre, double esperado, double obtenido) {
        if (Math.abs(esperado - obtenido) < 0.001) {
            paso(nombre);
        } else {
            fallo(nombre, "esperado " + esperado + ", obtenido " + obtenido);
        }
    }

    static void paso(String nombre) {
        pasadas++;
        System.out.println("[OK]    " + nombre);
    }

    static void fallo(String nombre, String detalle) {
        fallidas++;
        System.out.println("[FALLO] " + nombre + " -> " + detalle);
    }
}
