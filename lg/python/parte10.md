# Archivos
Un archivo de texto contiene un conjunto de caracteres estructurados en distintas líneas. Es un formato de archivo ampliamente utilizado como pueden ser:
- El código fuente de un script en Python se almacena en un archivo de texto (igual que cualquier otro lenguaje de programación)
- Archivos HTML, CSS, XML se almacenan en archivos de texto.
- Archivos JSON etc.

## Escritura de un archivo de texto
Ejercicio ejemplo:
Crear un archivo de texto llamado 'datos.txt', almacenar tres líneas de texto. Abrir luego el archivo creado con un editor de texto.
```python
archi1=open("datos.txt","w") 
archi1.write("Primer línea.\n") 
archi1.write("Segunda línea.\n") 
archi1.write("Tercer línea.\n")  
archi1.close() 
```
> [!NOTE]
> Para crear un archivo de texto debemos llamar a la función open y pasar dos parámetros, el primero indica el nombre del archivo a crear y el segundo un string con el caracter "w" (la "w" write indica crear el archivo de texto):
> ```python
> archi1=open("datos.txt","w") 
> ```
> `Si el archivo 'datos.txt' ya existe luego se crea uno nuevo y se borra el actual.`
> El archivo se crea en la misma carpeta donde se está ejecutando el script de Python, si necesitamos que se cree en otra carpeta podemos indicar el path del mismo:
> ```python
> archi1 = open("c:/administracion/datos.txt","w") 
> ```
> Si indicamos un path inexistente se genera un error.
> Para grabar caracteres en el archivo de texto utilizamos el método 'write' y le pasamos un string a grabar:
> ```python
> archi1.write("Primer línea.\n") 
> ```
> Mediante la sintaxis \n indicamos que debe almacenarse un salto de línea en el archivo de texto.
> Si no incluimos los respectivos \n: El archivo de texto solo tendra una linea.
> Luego de trabajar con el archivo de texto debemos liberarlo para que otro programa pueda acceder a su contenido:
> ```python
> archi1.close()
> ```

## Lectura de un archivo de texto
```python
# Llamamos a la función 'open' y le pasamos el nombre del archivo a leer y un string con el caracter "r" (read)
archi1=open("datos.txt","r")
contenido=archi1.read() # El método 'read' recupera todas las líneas del archivo de texto (recupera el archivo completo)
print(contenido) # Luego de trabajar con el archivo de texto debemos liberarlo para que otro programa pueda acceder a su contenido
archi1.close()
```
Opcionalmente al metodo .read() podemos pasar un entero que represente la cantidad de caracteres a leer:
```python
contenido=archi1.read(6)
```

### Lextura linea por linea
Para realizar una lectura linea por linea utilizamos el metodo `readline` (este método inclusive retorna el caracter `\n`)
```python
archi1=open("datos.txt","r")
linea=archi1.readline()  # Antes de la estructura repetitiva 'while' leemos la primer lína del archivo de texto:
while linea!='':
# Luego mientras la variable 'linea' sea distinta a un string vacío imprimimos el contenido de la variable 'linea' evitando que
# genere un salto de línea la función print mediante la asignación del parámetro end con el valor de ''
    print(linea, end='')
    linea=archi1.readline()
archi1.close()
```
lo mismo pero con for
```python
archi1=open("datos.txt","r")
for linea in archi1:
    print(linea, end='')
archi1.close()
```
## Almacenar archivo en lista
```python
archi1=open("datos.txt","r")
lineas=archi1.readlines()
print('El archivo tiene', len(lineas), 'líneas')
print('El contenido del archivo')
for linea in lineas:
    print(linea, end='')
archi1.close()
```
## Abrir archivo para añadir lineas
```python
archi1=open("datos.txt","a")
archi1.write("nueva línea 1\n")
archi1.write("nueva línea 2\n")
archi1.close()
archi1=open("datos.txt","r")
contenido=archi1.read()
print(contenido)
archi1.close()
```
## Abrir archivo para leer y agregar datos
```python
archi1=open("datos.txt","r+") 
contenido=archi1.read()
print(contenido)
archi1.write("Otra línea 1\n")
archi1.write("Otra línea 2\n")
archi1.close()
```
## Codificación de caracteres utf-8
```python
archi1=open("datos.txt","w", encoding="utf-8") 
archi1.write("Primer línea.\n") 
archi1.write("Segunda línea.\n") 
archi1.write("Tercer línea.\n")  
archi1.close()
```
