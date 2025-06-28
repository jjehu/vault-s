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
