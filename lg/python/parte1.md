
# Estructuras condicionales y repetitivas

## Condicionales - IF, ELSE, ELIF
Condicinal simple:
```python
sueldo=int(input("Ingrese cual es su sueldo:"))
if sueldo>3000:
    print("Esta persona debe abonar impuestos")
```
Condicional compuesto: está tiene actividades por la rama vardadero y falso
```python
num1=int(input("Ingrese primer valor:"))
num2=int(input("ingrese segundo valor:"))
print("El valor mayor es")
if num1>num2:
    print(num1)
else:
    print(num2)
```
Condicionales anidados: cuando por la rama del verdadero o el falso de una estructura condicional hay otra estructura condicional
```python
nota1=int(input("Ingrese primer nota:"))
nota2=int(input("Ingrese segunda nota:"))
nota3=int(input("Ingrese tercer nota:"))
prom=(nota1+nota2+nota3)/3
if prom>=7:
    print("Promocionado")
else:
    if prom>=4:
        print("Regular")
    else:
        print("Reprobado")
```

## Repetitivas - WHILE, FOR
While: En primer lugar se verifica la condición, si la misma resulta verdadera se ejecutan las operaciones que indicamos por la rama del Verdadero. En caso que la condición sea Falsa continúa por la rama del Falso y sale de la estructura repetitiva para continuar con la ejecución del algoritmo.
```python
x=1
while x<=100:
    print(x)
    x=x+1
    #x=+1
```
For: en general se usa en aquellas situaciones en las cuales queremos que una variable vaya tomando un valor de una lista definida de valores.
```python
for x in range(101):
    print(x)
```
range nos sirve para má situaciones
```python
#imprime los números del 20 al 30
for x in range(20,31):
    print(x)

#imprime los números impares que hay desde el 1 al 100
for x in range(1,100,2):
    print(x)

#tambien se puede leer los elementos de una estructura de datos
lista=[1, 2, 3, 4, 5]
for x in lista:
    print(x)
```

## Operadores
En una condición deben disponerse únicamente variables, valores constantes y operadores relacionales.
- operadores relacionales: 
```
== Igualdad
!= Desigualdad
< menor
<= menor o igual
> mayor
>= mayor o igual
```
- operadores matemáticos:
```
+ suma
- resta
* multiplicación
/ división de flotantes
// división de enteros
% resto de una división
** exponenciación
```
- operadores lógicos:
```
and
or
```
