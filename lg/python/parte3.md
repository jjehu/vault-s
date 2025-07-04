
# Listas

## Estructura de datos tipo Lista

`Creación de la lista por asignación`

Definimos una lista vacia
```python
lista=[]
```

Para crear una lista por asignación debemos indicar sus elementos encerrados entre corchetes y separados por coma.
```python
lista1=[10, 5, 3]                       # lista de enteros
lista2=[1.78, 2.66, 1.55, 89,4]         # lista de valores float
lista3=["lunes", "martes", "miercoles"] # lista de string
lista4=["juan", 45, 1.92]               # lista con elementos de distinto tipo
notas=[[4,5], [6,9], [7,3]]             # Lista de tipo lista
```

La función len nos sirve para conocer la cantidad de elementos de la lista
```python
lista1=[10, 5, 3]   # lista de enteros
print(len(lista1))  # imprime un 3
```

Si llamamos a print y pasamos solo el nombre de la lista luego se nos muestra todos los elementos
```python
meses=["enero", "febrero", "marzo", "abril"]
print(meses[0]) # se muestra enero
print(meses[3]) # se muestra abril
print(meses) # se muestra ["enero", "febrero", "marzo", "abril"]
```

## Carga por teclado

.append() nos permite agregar a la lista el elemento pasado por parametro
```python
lista=[10, 20, 30]
print(len(lista))    # imprime un 3
lista.append(100)
print(len(lista))    # imprime un 4
print(lista[0])      # imprime un 10
print(lista[3])      # imprime un 100
```
## Eliminación de un elemento

.pop() nos permite eliminar el elmento con el indice pasado por parametro, hay que hacer notar que cuando un elemento de la lista se elimina no queda una posición vacía, sino se desplazan todos los elementos de la derecha una posición.
El método pop retorna el valor almacenado en la lista en la posición indicada, aparte de borrarlo.
```python
lista=[1,2,3,4,5,6,7,8,9]
print(lista)

posicion=0
while posicion<len(lista):
    if lista[posicion]==5:
        lista.pop(posicion)
    else:
        posicion=posicion+1
    
print(lista) 
```
