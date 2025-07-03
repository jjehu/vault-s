
# Listas

## Estructura de datos tipo Lista

`Creación de la lista por asignación`

Para crear una lista por asignación debemos indicar sus elementos encerrados entre corchetes y separados por coma.
```python
lista1=[10, 5, 3]                       # lista de enteros
lista2=[1.78, 2.66, 1.55, 89,4]         # lista de valores float
lista3=["lunes", "martes", "miercoles"] # lista de string
lista4=["juan", 45, 1.92]               # lista con elementos de distinto tipo
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
