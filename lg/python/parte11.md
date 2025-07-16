# Exepciones

## Manejo de exepciones
Las excepciones en Python son errores que ocurren durante la ejecución de un programa. Pueden hacer que el programa se detenga si no se manejan correctamente. Sin embargo, se puede escribir un manejador de excepciones para evitar que el programa se detenga y manejar la situación de manera controlada.

Exepciones comunes:
- Conversión fallida: Intentar convertir una cadena de texto a un número, cuando la cadena no es numérica.
- División por cero: Intentar dividir por cero.
- Acceso a un archivo inexistente.
- Conexión a un servidor que no está activo.
- Acceso a índices fuera de rango en listas o tuplas.
- Llamar a un método o función inexistente.
- Intentar importar un módulo que no existe.

> [!CAUTION]
> `¿Por qué es importante manejar exepciones?`
> Cuando un programa lanza una excepción, se interrumpe y se detiene. Si no manejas esas excepciones, el usuario podría enfrentarse a errores inesperados. Al capturar las excepciones, el programa puede recuperarse y mostrar un mensaje adecuado sin cerrarse.
```python
while True:
    valor1 = int(input("Ingrese primer valor:"))
    valor2 = int(input("Ingrese segundo valor:"))
    suma = valor1 + valor2
    print("La suma es", suma)
    respuesta = input("Desea ingresar otro par de valores?[s/n]")
    if respuesta == "n":
        break
```
> [!NOTE]
> Este programa funciona bien, pero si el usuario introduce algo que no es un número (como "juan"), el programa se detiene con un error de excepción. Esto no es ideal si otras personas van a usar el programa, porque no saben cómo manejar este error.

### Solución: Manejo de excepciones con `try` y `except`
```python
while True:
    try:    
        valor1 = int(input("Ingrese primer valor:"))
        valor2 = int(input("Ingrese segundo valor:"))
        suma = valor1 + valor2
        print("La suma es", suma)
    except ValueError:
        print("Debe ingresar números.")
    
    respuesta = input("Desea ingresar otro par de valores?[s/n]")
    if respuesta == "n":
        break
```
> Explicación
> 
> `try`: Aquí es donde colocamos el código que podría generar una excepción. En este caso, el bloque `try` intenta convertir los valores ingresados a enteros y luego sumarlos.
> 
> `except`: Si se produce una excepción (en este caso, un ValueError, que ocurre cuando el usuario no ingresa un número válido), el bloque `except` captura la excepción y muestra un mensaje de error al usuario sin interrumpir el programa.

> [!NOTE]
> - Si el usuario ingresa un número válido, el programa ejecuta el bloque `try` y calcula la suma.
> - Si el usuario ingresa un valor no numérico (como "juan"), el bloque `except` se activa y muestra el mensaje "Debe ingresar números", y luego el programa continúa funcionando normalmente.

## Exepciones estándar en python
Python tiene un conjunto de excepciones predefinidas que puedes usar para manejar errores específicos en tus programas. Estas excepciones ayudan a que tu programa sea más robusto y no se cierre inesperadamente por errores comunes.

### Algunas de las excepciones más comunes

1. `ValueError`: Se lanza cuando una función o operación recibe un argumento que tiene un valor inapropiado. Ejemplo: intentar convertir un string que no es un número a un entero.
2. `IndexError`: Se genera cuando intentas acceder a un índice fuera del rango válido en una secuencia (lista, tupla, cadena). Ejemplo: acceder a un índice de una lista que no existe.
3. `NameError`: Aparece cuando intentas usar una variable o función que no está definida o no existe en el ámbito actual.
4. `TypeError`: Se genera cuando intentas realizar una operación con un tipo de dato inapropiado. Ejemplo: sumar un número y una cadena de texto.
5. `ModuleNotFoundError`: Se produce cuando intentas importar un módulo que no existe.
6. `ZeroDivisionError`: Ocurre cuando intentas dividir un número por cero.
7. `OverflowError`: Aparece cuando el resultado de una operación aritmética es demasiado grande para ser representado.
8. `KeyError`: Se genera cuando intentas acceder a una clave que no existe en un diccionario.

Ejemplos práticos:

1. Capturar una excepción `ZeroDivisionError` (división por cero):

Supón que necesitas dividir dos números ingresados por el usuario. Si el divisor es 0, se generará una excepción `ZeroDivisionError`.
```python
try:
    valor1 = int(input("Ingrese dividendo:"))
    valor2 = int(input("Ingrese divisor:"))
    division = valor1 / valor2
    print("El resultado de la división es", division)
except ZeroDivisionError:
    print("No se puede dividir por cero.")
```
> Si el divisor es 0, el programa no se detendrá, sino que mostrará el mensaje "No se puede dividir por cero."

2. Capturar una excepción `IndexError` (índice fuera de rango):

Supongamos que tienes una tupla con los nombres de los meses y el usuario ingresa un número de mes. Si el número ingresado está fuera del rango 1-12, se generará una excepción `IndexError`.

```python
meses = ("enero", "febrero", "marzo", "abril", "mayo", "junio", 
         "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre")

try:
    nromes = int(input("Ingrese un número de mes [1-12]:"))
    print(meses[nromes - 1])
except IndexError:
    print("El número de mes debe estar entre 1 y 12.")
```

> En este caso, si el usuario ingresa un número mayor a 12 o menor a 1, se capturará el IndexError y se le informará al usuario sobre el rango válido.

3. Capturar múltiples excepciones (por ejemplo, `ZeroDivisionError` y `ValueError`):

Puedes capturar diferentes excepciones en bloques separados. Si quieres manejar errores como la división por cero o ingresar valores no numéricos, puedes hacerlo de esta forma:

```python
try:
    valor1 = int(input("Ingrese dividendo:"))
    valor2 = int(input("Ingrese divisor:"))
    division = valor1 / valor2
    print("El resultado de la división es", division)
except ZeroDivisionError:
    print("No se puede dividir por cero.")
except ValueError:
    print("Los valores ingresados deben ser enteros.")
```
> Este código captura dos tipos de errores:
> - `ZeroDivisionError`: cuando intentas dividir por 0.
> - `ValueError`: cuando los valores ingresados no son enteros.

4. Capturar cualquier tipo de excepción sin discriminar (captura general):

A veces, es útil capturar cualquier tipo de excepción, sin especificar cuál. Esto puede ser útil si no sabes qué tipo de error puede ocurrir, pero prefieres manejar cualquier excepción de forma general.
```python
try:
    valor1 = int(input("Ingrese dividendo:"))
    valor2 = int(input("Ingrese divisor:"))
    division = valor1 / valor2
    print("El resultado de la división es", division)
except:
    print("Problemas con la entrada u operación.")
```
> En este caso, cualquier excepción (como un error de tipo, división por cero o un valor no numérico) se manejará de manera genérica con el mensaje "Problemas con la entrada u operación".
