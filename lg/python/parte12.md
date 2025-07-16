# Recursividad
## Conceptos básicos
La recursividad es una técnica de programación en la que una función se llama a sí misma, permitiendo que un bloque de instrucciones se ejecute repetidamente hasta alcanzar una condición de salida. Es útil cuando un problema se puede dividir en subproblemas más pequeños del mismo tipo. Sin embargo, la recursividad debe ser utilizada con cuidado, ya que sin una condición base o de salida, el programa puede entrar en un ciclo infinito y consumir demasiada memoria.

> [!NOTE]
> 1. Llamadas recursivas:
>
> - Una función recursiva es aquella que se llama a sí misma dentro de su propio cuerpo.
> - Cada vez que se hace una llamada recursiva, se agregan más variables locales y parámetros a la pila de ejecución.
> - Cuando una llamada recursiva finaliza, se liberan esos valores y se continúa la ejecución.
>
> 2. Problema de desbordamiento de pila:
>
> - Si la función recursiva no tiene una condición de salida adecuada, el programa puede bloquearse debido a que la pila de llamadas se llena y no se liberan los recursos.
> - Este error es común en recursiones mal manejadas, y puede llevar a un `RecursionError`.

Ejemplos prácticos:
Problema1: función recursiva infinita
```python
def repetir():
    repetir()

repetir()
```
Este código genera un RecursionError porque la función repetir se llama a sí misma sin una condición base para detenerse. La pila de memoria se llena y el programa se bloquea.

Problema 2: Recursión decreciente sin condición de salida
```python
def imprimir(x):
    print(x)
    imprimir(x-1)

imprimir(5)
```
En este ejemplo, la función imprimir se llama a sí misma con un valor decrementado de x. Esto sigue ocurriendo hasta que la pila se llena, imprimiendo números negativos hasta que el programa se bloquea.

Problema 3: Función recursiva con una condición de salida:
```python
def imprimir(x):
    if x > 0:
        print(x)
        imprimir(x-1)

imprimir(5)
```
Aquí la función recursiva imprime los números del 5 al 1. La condición if x > 0 evita que la recursión continúe indefinidamente. Cuando x llega a 0, la recursión finaliza.
> ¿Qué sucede cuando x == 0?
> 
> Cuando x llega a 0, la condición if x > 0 se evalúa como falsa y el programa deja de hacer más llamadas recursivas. En ese punto, el programa comienza a desapilar las llamadas y termina correctamente.

Problema 4: Recursión ascendente (1 a 5):
```python
def imprimir(x):
    if x > 0:
        imprimir(x-1)
        print(x)

imprimir(5)
```
En este caso, los números del 1 al 5 se imprimen en orden ascendente. Aunque imprimir comienza con el valor 5, la recursión se llama primero con 4, luego con 3, y así sucesivamente. Cuando x == 0, la función comienza a "desapilar" y a imprimir los números en orden ascendente.

Problema 5: Factorial de un número:
El factorial de un número es el resultado de multiplicar ese número por todos los números enteros menores que él hasta llegar a 1. Por ejemplo, el factorial de 4 es:

4 * 3 * 2 * 1 = 24

```python
def factorial(fact):
    if fact > 0:
        valor = fact * factorial(fact-1)
        return valor
    else:
        return 1

print(f"El factorial de 4 es {factorial(4)}")
```
- Función recursiva: La función factorial se llama a sí misma, multiplicando fact por el resultado de factorial(fact-1).

- Cuando fact llega a 0, la condición base devuelve 1, y luego los resultados se "desapilan" para obtener el valor final del factorial.

Problema 6: Ordenamiento recursivo (algoritmo de burbuja):
```python
def ordenar(lista, cant):
    if cant > 1:
        for f in range(0, cant-1):
            if lista[f] > lista[f + 1]:
                aux = lista[f]
                lista[f] = lista[f + 1]
                lista[f + 1] = aux
        ordenar(lista, cant - 1)

datos = [60, 44, 22, 33, 2]
print(datos)
ordenar(datos, len(datos))
print(datos)
```
Este ejemplo muestra cómo ordenar una lista usando recursividad (implementación del algoritmo de burbuja).

- La función compara los elementos adyacentes de la lista y los intercambia si es necesario.
- Luego, la función se llama a sí misma con el tamaño de la lista reducido hasta que los elementos estén ordenados.

> [!TIP]
> Condición base: Asegúrate de que siempre haya una condición que termine la recursión; de lo contrario, el programa se bloqueará.
> Evitar recursiones profundas: Si un algoritmo puede ser resuelto con un bucle, es preferible usar un enfoque iterativo en lugar de recursivo, ya que consume menos memoria.
