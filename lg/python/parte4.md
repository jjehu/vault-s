# Funciones

Una función es un conjunto de instrucciones en Python que resuelven un problema específico.
El lenguaje Python ya tiene incorporada algunas funciones básicas. Algunas de ellas ya las utilizamos en conceptos anteriores como son las funciones: print, len y range.

Ejemplo de función
```python
def nombre_de_funcion(nombre_parametro):
  return 'Hola'
```
## Parámetros


Se puede pasar mas de un parámetro
```python
def nombre_de_funcion(val1, val2):
  return 'Hola'
```
Se puede pasar parametros de tipo lista
```python
def sumarizar(lista):
    suma=0
    for x in range(len(lista)):
        suma=suma+lista[x]
    return suma

# bloque principal del programa

listavalores=[10, 56, 23, 120, 94]
print("La lista completa es")
print(listavalores)
print("La suma de todos su elementos es", sumarizar(listavalores))
```
Se puede definir un parametro con un valor por defecto
```python
def titulo_subrayado(titulo,caracter="*"):
    print(titulo)
    print(caracter*len(titulo))

# bloque principal

titulo_subrayado("Sistema de Administracion")
titulo_subrayado("Ventas","-")
```

Al crear una lista se guarda en la variable una referencia que es lo que retorna la función
```python
def cargar_datos():
    nom=[]
    ed=[]
    for x in range(5):
        v1=input("Ingrese el nombre de la persona:")
        nom.append(v1)
        v2=int(input("Ingrese la edad:"))
        ed.append(v2)
    return [nom,ed]


def mayores_edad(nom,ed):
    print("Nombres de personas mayores de edad")
    for x in range(len(nom)):
        if ed[x]>=18:
            print(nom[x])


def promedio_edades(ed):
    suma=0
    for x in range(len(ed)):
        suma=suma+ed[x]
    promedio=suma//5
    print("Edad promedio de las personas:",promedio)
    

# bloque principal

nombres,edades=cargar_datos()
mayores_edad(nombres,edades)
promedio_edades(edades)
```
