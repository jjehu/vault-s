# Variables y Métodos de cadenas

## Variables
definición de variables:
```python
# variable entera
var=20
# variable flotante
alt=1.75

# convertir texto ingresado por teclado
edad=int(input("Ingresar la edad de la persona:"))
altura=float(input("Ingresar la altura de la persona en metros ej:1.70:"))

# definición e inicio de una cadena de caracteres
dia="lunes"
# tambien se puede utilizar comilla simple
dia='lunes'
# cargar por teclado una cadena de caracteres
nombre=input("ingrese su nombre:")
```

## Métodos de cadenas
Podemos utilizar los operadores relacionales para identificar si dos cadenas son iguales, distintas o cual es la mayor alfabética:
```
== Igualdad
!= Desigualdad
< menor
<= menor o igual
> mayor
>= mayor o igual
```
se puede acceder a una cadena de forma individual
```python
nombre='juan'
print(nombre[0])   #se imprime una j
print(len(nombre)) #len nos devuelve la cantidad de caracteres que tiene la cadena
```
### Métodos propios de la cadena de caracteres
- upper() : devuelve una cadena de caracteres convertida todos sus caracteres a mayúsculas.
- lower() : devuelve una cadena de caracteres convertida todos sus caracteres a minúsculas.
- capitalize() : devuelve una cadena de caracteres convertida a mayúscula solo su primer caracter y todos los demás a minúsculas.

---

- capitalize() → Convierte el primer carácter a mayúscula
- casefold() → Convierte la cadena a minúsculas (más agresivo que lower)
- center() → Devuelve una cadena centrada
- count() → Devuelve el número de veces que aparece un valor en la cadena
- encode() → Devuelve una versión codificada de la cadena
- endswith() → Devuelve verdadero si la cadena termina con el valor especificado
- expandtabs() → Establece el tamaño de tabulación en la cadena
- find() → Busca un valor en la cadena y devuelve su posición
- format() → Da formato a valores dentro de una cadena
- format_map() → Da formato a valores dentro de una cadena (usando un diccionario)
- index() → Busca un valor en la cadena y devuelve su posición
- isalnum() → Devuelve verdadero si todos los caracteres son alfanuméricos
- isalpha() → Devuelve verdadero si todos los caracteres son letras
- isascii() → Devuelve verdadero si todos los caracteres son ASCII
- isdecimal() → Devuelve verdadero si todos los caracteres son decimales
- isdigit() → Devuelve verdadero si todos los caracteres son dígitos
- isidentifier() → Devuelve verdadero si la cadena es un identificador válido
- islower() → Devuelve verdadero si todos los caracteres están en minúscula
- isnumeric() → Devuelve verdadero si todos los caracteres son numéricos
- isprintable() → Devuelve verdadero si todos los caracteres son imprimibles
- isspace() → Devuelve verdadero si todos los caracteres son espacios en blanco
- istitle() → Devuelve verdadero si la cadena cumple formato de título
- isupper() → Devuelve verdadero si todos los caracteres están en mayúscula
- join() → Une elementos de un iterable en una cadena
- ljust() → Devuelve la cadena alineada a la izquierda
- lower() → Convierte la cadena a minúsculas
- lstrip() → Elimina espacios (u otros caracteres) a la izquierda
- maketrans() → Crea una tabla de traducción para usar en translate()
- partition() → Divide la cadena en tres partes y devuelve una tupla
- replace() → Reemplaza un valor por otro en la cadena
- rfind() → Busca un valor y devuelve la última posición encontrada
- rindex() → Busca un valor y devuelve la última posición encontrada
- rjust() → Devuelve la cadena alineada a la derecha
- rpartition() → Divide la cadena en tres partes desde la derecha
- rsplit() → Divide la cadena desde la derecha y devuelve una lista
- rstrip() → Elimina espacios (u otros caracteres) a la derecha
- split() → Divide la cadena y devuelve una lista
- splitlines() → Divide la cadena en líneas y devuelve una lista
- startswith() → Devuelve verdadero si la cadena comienza con el valor especificado
- strip() → Elimina espacios (u otros caracteres) al inicio y al final
- swapcase() → Intercambia mayúsculas por minúsculas y viceversa
- title() → Convierte la primera letra de cada palabra a mayúscula
- translate() → Devuelve una cadena traducida según una tabla
- upper() → Convierte la cadena a mayúsculas
- zfill() → Rellena la cadena con ceros al inicio
