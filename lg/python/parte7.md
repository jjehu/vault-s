
# POO
Un objeto contiene información pública, lo que necesitan los otros objetos para interactuar con él e información privada, interna, lo que necesita el objeto para operar y que es irrelevante para los otros objetos de la aplicación.

## Clase y Objetos
Para crear una clase hacemos uso de la palabra `class` seguido del nombre de la clase y por ultimo el caracter `:`
```python
class Nombre_de_clase:
```
Para crear los objetos se debe realizar dentro de la clase. Se hace uso de la palabra `def` seguido del nombre del objeto y seguido de `():`
```python
class Nombre_de_clase:
    def nombre_objeto():
        print("Hola Mundo")
```
Para esto en el bloque principal se deberia crear y hacer uso de la clase y sus objetos:
```python
# bloque principal

clase1=Nombre_de_clase()
clase1.imprimir()

clase2=Nombre_de_clase()
clase2.imprimir()
```
`Esto de momento no tiene mucho sentido, pero nos ayuda a crear multiples clases con objetos y a reutilizarlos`

ejercicio ejemplo:
Implementar una clase llamada Alumno que tenga como atributos su nombre y su nota. Definir los métodos para inicializar sus atributos, imprimirlos y mostrar un mensaje si está regular (nota mayor o igual a 4)

Definir dos objetos de la clase Alumno.

```python
class Alumno:

    def inicializar(self,nombre,nota):
        self.nombre=nombre
        self.nota=nota

    def imprimir(self):
        print("Nombre:",self.nombre)
        print("Nota:",self.nota)

    def mostrar_estado(self):
        if self.nota>=4:
            print("Regular")
        else:
            print("Libre")


# bloque principal

alumno1=Alumno()
alumno1.inicializar("diego",2)
alumno1.imprimir()
alumno1.mostrar_estado()

alumno2=Alumno()
alumno2.inicializar("ana",10)
alumno2.imprimir()
alumno2.mostrar_estado()
```
`En el método inicializar llegan como parámetros a parte del self el nombre y nota del alumno`

self en python es como el this en otros lenguajes

## Metodo __init__ de la clase
El método __init__ es un método especial de una clase en Python. El objetivo fundamental del método __init__ es inicializar los atributos del objeto que creamos. El metodo __init__ reemplaza al metodo inicializar que se habia utilizado en el concepto anterior.
Caracteristicas del metodo __init__:
- Se ejecuta inmediatamente luego de crear un objeto.
- El método __init__ no puede retornar dato.
- el método __init__ puede recibir parámetros que se utilizan normalmente para inicializar atributos.
- El método __init__ es un método opcional, de todos modos es muy común declararlo.

sintaxis del constructor:
```python
def __init__([parámetros]):
        [algoritmo]
```
