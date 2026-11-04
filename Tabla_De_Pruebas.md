# Tabla de pruebas

Las pruebas están en `test/CalculadoraComprasTest.java`.

| N° | Tipo | Datos de entrada | Resultado esperado | Resultado obtenido | ¿Pasó? |
|---|---|---|---|---|---|
| PRUEBA 1 | Normal | Precio 50, cantidad 2, descuento 10 % | Subtotal S/ 90.00 | S/ 90.00 | Sí |
| PRUEBA 2 | Normal | (12.50, 3, 20 %), (8, 2, 0 %), (20, 1, 45 %) | Total S/ 57.00 | S/ 57.00 | Sí |
| PRUEBA 3 | Límite | Precio 25, cantidad 4, descuento 100 % | Subtotal S/ 0.00 | S/ 0.00 | Sí |
| PRUEBA 4 | Límite | Precio 0, cantidad 1, descuento 0 % | Subtotal S/ 0.00 | S/ 0.00 | Sí |
| PRUEBA 5 | Inválida | Precio: `abc` | Mensaje de error, se vuelve a pedir el dato | Se mostró el error | Sí |
| PRUEBA 6 | Inválida | Precio: `-5` | Mensaje de error, se vuelve a pedir el dato | Se mostró el error | Sí |

Resultado: 6 de 6 pruebas pasaron.