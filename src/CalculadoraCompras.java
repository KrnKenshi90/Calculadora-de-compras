import java.util.ArrayList;
import java.util.Scanner;

// Calculadora de compras por consola y este pide los artículos uno por uno y al final muestra los totales y subtotales

public class CalculadoraCompras {

    // Limites que usa el programa para validar los datos
    public static final double PRECIO_MAXIMO = 100000;
    public static final int CANTIDAD_MAXIMA = 1000;
    public static final double DESCUENTO_MAXIMO = 100;
    public static final String MONEDA = "S/";

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ArrayList<Articulo> carrito = new ArrayList<>();

        System.out.println("===== CALCULADORA DE COMPRAS =====");

        String respuesta;
        do {
            System.out.println("\nArtículo #" + (carrito.size() + 1));
            carrito.add(pedirArticulo(teclado));

            System.out.print("¿Desea agregar otro artículo? (s/n): ");
            respuesta = teclado.nextLine().trim().toLowerCase();
        } while (respuesta.equals("s"));

        mostrarResumen(carrito);
        teclado.close();
    }

    // Pide todos los datos del articulo y lo devuelve lo creado
    public static Articulo pedirArticulo(Scanner teclado) {
        String nombre = pedirNombre(teclado);
        double precio = pedirPrecio(teclado);
        int cantidad = pedirCantidad(teclado);
        double descuento = pedirDescuento(teclado);
        return new Articulo(nombre, precio, cantidad, descuento);
    }

    private static String pedirNombre(Scanner teclado) {
        while (true) {
            System.out.print("Nombre: ");
            String nombre = teclado.nextLine().trim();
            if (!nombre.isEmpty()) {
                return nombre;
            }
            System.out.println("  Error: el nombre no puede estar vacío.");
        }
    }

    private static double pedirPrecio(Scanner teclado) {
        while (true) {
            System.out.print("Precio unitario: ");
            try {
                double precio = convertirDecimal(teclado.nextLine());
                validarPrecio(precio);
                return precio;
            } catch (IllegalArgumentException e) {
                System.out.println("  Error: " + e.getMessage());
            }
        }
    }

    private static int pedirCantidad(Scanner teclado) {
        while (true) {
            System.out.print("Cantidad: ");
            try {
                int cantidad = Integer.parseInt(teclado.nextLine().trim());
                validarCantidad(cantidad);
                return cantidad;
            } catch (NumberFormatException e) {
                System.out.println("  Error: la cantidad debe ser un número entero.");
            } catch (IllegalArgumentException e) {
                System.out.println("  Error: " + e.getMessage());
            }
        }
    }

    private static double pedirDescuento(Scanner teclado) {
        while (true) {
            System.out.print("Descuento (%): ");
            try {
                double descuento = convertirDecimal(teclado.nextLine());
                validarDescuento(descuento);
                return descuento;
            } catch (IllegalArgumentException e) {
                System.out.println("  Error: " + e.getMessage());
            }
        }
    }

    // Convierte el texto a numero y acepta coma o punto como separador de los decimales
    public static double convertirDecimal(String texto) {
        double valor;
        try {
            valor = Double.parseDouble(texto.trim().replace(',', '.'));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("debe ingresar un número válido.");
        }
        // parseDouble acepta "NaN" asi que lo rechaza aparte
        if (Double.isNaN(valor)) {
            throw new IllegalArgumentException("debe ingresar un número válido.");
        }
        return valor;
    }

    // Validacion de los precios, cantidad y descuento

    public static void validarPrecio(double precio) {
        if (precio < 0 || precio > PRECIO_MAXIMO) {
            throw new IllegalArgumentException("el precio debe estar entre 0 y " + (int) PRECIO_MAXIMO + ".");
        }
    }

    public static void validarCantidad(int cantidad) {
        if (cantidad < 1 || cantidad > CANTIDAD_MAXIMA) {
            throw new IllegalArgumentException("la cantidad debe estar entre 1 y " + CANTIDAD_MAXIMA + ".");
        }
    }

    public static void validarDescuento(double descuento) {
        if (descuento < 0 || descuento > DESCUENTO_MAXIMO) {
            throw new IllegalArgumentException("el descuento debe estar entre 0 y 100.");
        }
    }

    // calculo de los totales y subtotales de la compra

    public static double calcularTotal(ArrayList<Articulo> carrito) {
        double total = 0;
        for (Articulo articulo : carrito) {
            total += articulo.calcularSubtotal();
        }
        return Math.round(total * 100.0) / 100.0;
    }

    private static void mostrarResumen(ArrayList<Articulo> carrito) {
        System.out.println("\n========== RESUMEN ==========");
        for (Articulo a : carrito) {
            System.out.printf("%s  x%d  (%s %.2f c/u, desc. %.2f%%)%n",
                    a.getNombre(), a.getCantidad(), MONEDA, a.getPrecio(), a.getDescuento());
            System.out.printf("   Subtotal: %s %.2f%n", MONEDA, a.calcularSubtotal());
        }
        System.out.println("-----------------------------");
        System.out.printf("TOTAL A PAGAR: %s %.2f%n", MONEDA, calcularTotal(carrito));
    }
}
