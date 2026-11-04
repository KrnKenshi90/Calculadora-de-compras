# Explicación

Teniendo en cuenta trabajo que se hizo para la calculadora de compras que funciona por terminal. El usuario va ingresando los artículos uno por uno con su nombre, precio, cantidad y el porcentaje de descuento. Después de cada artículo el programa pregunta si quiere agregar otro, y cuando ya no, muestra un resumen con el subtotal de cada artículo y el total a pagar.

Dividí el programa en dos clases. La clase Articulo guarda los datos de cada producto y tiene los métodos para calcular el importe, el monto del descuento y el subtotal. La clase CalculadoraCompras tiene el main y se encarga de pedir los datos, validarlos y mostrar el resumen. Separé cada tarea en su propio método (pedirPrecio, validarCantidad, calcularTotal, etc.) para que el código sea más fácil de leer y de probar.

Los límites, como el precio máximo o la cantidad máxima, están guardados en constantes, así si hay que cambiarlos solo se modifica una línea. Para las validaciones usé excepciones: si el usuario escribe letras o un número fuera de rango, se captura el error, se muestra un mensaje y se vuelve a pedir el dato, así el programa no se cae.

Un problema que tuve fue que al multiplicar decimales salían resultados como 89.99999, por eso redondeé los montos a dos decimales. Por último, hice seis pruebas: dos casos normales, dos casos límite y dos con datos inválidos, y todas pasaron.