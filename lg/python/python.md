# APUNTES DE PYTHON🐍

## Introducción

> [!NOTE]
> - [Instalar Python](https://www.python.org/downloads/)
> - [Visual Studio](https://code.visualstudio.com/)

### `Errores de sintaxis y lógicos`
Los erres de sintaxis son errores tipográficos, como por ejemplo indicar el nombre incorrecto de la función, nombres de variables incorrectas, falta de paréntesis, palabras claves mal escritas, etc.
Un programa no se puede ejecutar por completo sin corregir absolutamente todos los errores sintácticos.
Ejemplo: 
```py
lado=int(input("Ingrese la medida del lado del cuadrado:"))
superficie=lado*lado
print("La superficie del cuadrado es")
print(Superficie)
# Es incorrecto la impresión de una variable nunca inicializada: "Superficie" (debemos respetar como la iniciamos en las líneas anteriores)
```
Existe otro tipo de errores llamados ERRORES LOGICOS. Este tipo de errores en programas grandes (miles de líneas) son más difíciles de localizar. Por ejemplo un programa que permite hacer la facturación pero la salida de datos por impresora es incorrecta.
Ejemplo: 
```py
lado=int(input("Ingrese la medida del lado del cuadrado:"))
superficie=lado*lado*lado
print("La superficie del cuadrado es")
print(superficie)
# no presenta ningún error sintáctico, pero luego de ingresar el valor del lado del cuadrado (por ejemplo el valor 10) obtenemos como resultado un valor incorrecto (imprime el 1000), esto debido que definimos incorrectamente la fórmula para calcular la superficie del cuadrado:
```
