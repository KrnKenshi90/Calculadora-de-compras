# Calculadora de compras

Programa de consola en Java que registra los artículos de una compra (nombre, precio, cantidad y descuento) y al final muestra el subtotal de cada uno y el total a pagar.

## Archivos

- `src/Articulo.java`: clase con los datos de cada artículo y el cálculo de su subtotal.
- `src/CalculadoraCompras.java`: programa principal (lectura de datos, validaciones y resumen).
- `test/CalculadoraComprasTest.java`: pruebas del programa.
- `Tabla_De_Pruebas.md`: tabla con los casos de prueba.
- `Explicacion.md`: explicación de la solución.

## Cómo ejecutarlo

Se necesita tener instalado el JDK (versión 11 o superior). Desde la carpeta del proyecto:

```
javac -encoding UTF-8 -d out src/*.java test/*.java
java -cp out CalculadoraCompras
```

Para correr las pruebas:

```
java -cp out CalculadoraComprasTest
```

También se puede abrir la carpeta en IntelliJ o NetBeans y ejecutar el `main` de cada clase.

## Uso

El programa pide los datos de un artículo y luego pregunta si se quiere agregar otro (`s` / `n`). Al responder `n` se muestra el resumen.

Ejemplo:

```
Artículo #1
Nombre: Cuaderno
Precio unitario: 50
Cantidad: 2
Descuento (%): 10
¿Desea agregar otro artículo? (s/n): n

========== RESUMEN ==========
Cuaderno  x2  (S/ 50.00 c/u, desc. 10.00%)
   Subtotal: S/ 90.00
-----------------------------
TOTAL A PAGAR: S/ 90.00
```

## Validaciones

| Dato | Valores permitidos |
|---|---|
| Nombre | No puede estar vacío |
| Precio | De 0 a 100000 (se acepta punto o coma decimal) |
| Cantidad | Número entero de 1 a 1000 |
| Descuento | De 0 a 100 % |

Si se ingresa un dato incorrecto (letras, negativos, fuera de rango) el programa muestra un mensaje de error y vuelve a pedir el mismo dato, sin cerrarse.

## Cálculo

```
importe   = precio × cantidad
descuento = importe × porcentaje / 100
subtotal  = importe − descuento
total     = suma de todos los subtotales
```

Los valores se redondean a 2 decimales.
