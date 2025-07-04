
# Tuplas y diccionarios

## Tuplas

Una tupla permite almacenar una colección de datos no necesariamente del mismo tipo. Los datos de la tupla son inmutables a diferencia de las listas que son mutables.
Una vez inicializada la tupla no podemos agregar, borrar o modificar sus elementos.
La sintaxis para definir una tupla es indicar entre paréntesis sus valores:
```python
tupla=(1, 2, 3)
```
ejercicio ejemplo:
```python
tupla=(1, 2, 3)
fecha=(25, "Diciembre", 2016)
punto=(10, 2)
persona=("Rodriguez", "Pablo", 43)
print(tupla)
print(fecha)
print(punto)
print(persona)
```
### Empaquetado y desempaquetado de tupla

`Empaquetado`
Podemos generar una tupla asignando a una variable un conjunto de variables o valores separados por coma:
```python
x=10
y=30
punto=x,y
print(punto)
```
`Desempaquetado`
tenemos dos variables enteras x e y. Luego se genera una tupla llamada punto con dos elementos.
```python
fecha=(25, "diciembre", 2016)
print(fecha)
dd,mm,aa=fecha
print("Dia",dd)
print("Mes",mm)
print("Año",aa)
```
`Conversión de tuplas a listas y viceversa.`
Otra herramienta que nos proporciona Python es la conversión de tuplas a listas y viceversa mediante las funciones:
```python
list(parametro de tipo tupla)
tuple(parametro de tipo lista)
```
### Listas y Tuplas anidadas
Se puede introducir una tupla dentro de una lista y viceversa
Recordar que los elementos de la tupla no se puede cambiar de valor pero de una lista si
```python
empleado=["juan", 53, (25, 11, 1999)]
print(empleado)
empleado.append((1, 1, 2016))
print(empleado)
alumno=("pedro",[7, 9])
print(alumno)
alumno[1].append(10)
print(alumno)
```

## Diccionarios

La estructura de datos tipo diccionario utiliza una clave para acceder a un valor. El subíndice puede ser un entero, un float, un string, una tupla etc. (en general cualquier tipo de dato inmutable)

`Definición de un diccionario por asignación.`
```python
productos={"manzanas":39, "peras":32, "lechuga":17}
print(productos)
```
ejercicio ejemplo:
```python
def cargar():
    agenda={}
    continua1="s"
    while continua1=="s":
        fecha=input("ingrese la fecha con formato dd/mm/aa:")
        continua2="s"
        lista=[]
        while continua2=="s":
            hora=input("Ingrese la hora de la actividad con formato hh:mm ")
            actividad=input("Ingrese la descripcon de la actividad:")
            lista.append((hora,actividad))
            continua2=input("Ingresa otra actividad para la misma fecha[s/n]:")
        agenda[fecha]=lista
        continua1=input("Ingresa otra fecha[s/n]:")
    return agenda


def imprimir(agenda):
    print("Listado completa de la agenda")
    for fecha in agenda:
        print("Para la fecha:",fecha)
        for hora,actividad in agenda[fecha]:
            print(hora,actividad)


def consulta_fecha(agenda):
    fecha=input("Ingrese la fecha que desea consultar:")
    if fecha in agenda:
        for hora,actividad in agenda[fecha]:
            print(hora,actividad)
    else:
        print("No hay actividades agendadas para dicha fecha")
            

# bloque principal

agenda=cargar()
imprimir(agenda)
consulta_fecha(agenda)
```
