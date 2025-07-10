
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

ejercicio ejemplo:
Confeccionar una clase que represente un empleado. Definir como atributos su nombre y su sueldo. En el método __init__ cargar los atributos por teclado y luego en otro método imprimir sus datos y por último uno que imprima un mensaje si debe pagar impuestos (si el sueldo supera a 3000)
```python
class Empleado:

    def __init__(self):
        self.nombre=input("Ingrese el nombre del empleado:")
        self.sueldo=float(input("Ingrese el sueldo:"))

    def imprimir(self):
        print("Nombre:",self.nombre)
        print("Sueldo:",self.sueldo)

    def paga_impuestos(self):
        if self.sueldo>3000:
            print("Debe pagar impuestos")
        else:
            print("No paga impuestos")


# bloque principal

empleado1=Empleado()
empleado1.imprimir()
empleado1.paga_impuestos()
```
> [!CAUTION]
> - El método __init__ carga por teclado el nombre del empleado y su sueldo, este método se ejecuta despues de que se crea un objeto de la clase Empleado
> - El metodo __init__ puede tener mas parametros adeamas de self, encaso de que tenga más parametros ademas de self al crearse la clase se tendria que pasar los paramatros que esten en el metodo __ini__

> [!TIP]
> Se puede realizar la llamada de un método desde otro método de la clase haciendo uso de `self.` seguido del metodo o la variable de la clase, esto es como el `this` en otros lenguajes

## Colaboración de clases
Normalmente un problema resuelto con la metodología de programación orientada a objetos no interviene una sola clase, sino que hay muchas clases que interactúan y se comunican.

ejercicio ejemplo:
Un banco tiene 3 clientes que pueden hacer depósitos y extracciones. También el banco requiere que al final del día calcule la cantidad de dinero que hay depositado.
Lo primero que hacemos es identificar las clases:
Podemos identificar la clase Cliente y la clase Banco.
Luego debemos definir los atributos y los métodos de cada clase:
```
Cliente		
    atributos
        nombre
        monto
    métodos
        __init__
        depositar
        extraer
        retornar_monto

Banco
    atributos
        3 Cliente (3 objetos de la clase Cliente)
    métodos
        __init__
        operar
        depositos_totales
```
```python
class Cliente:

    def __init__(self,nombre):
        self.nombre=nombre
        self.monto=0

    def depositar(self,monto):
        self.monto=self.monto+monto

    def extraer(self,monto):
        self.monto=self.monto-monto

    def retornar_monto(self):
        return self.monto

    def imprimir(self):
        print(self.nombre,"tiene depositado la suma de",self.monto)


class Banco:

    def __init__(self):
        self.cliente1=Cliente("Juan")
        self.cliente2=Cliente("Ana")
        self.cliente3=Cliente("Diego")

    def operar(self):
        self.cliente1.depositar(100)
        self.cliente2.depositar(150)
        self.cliente3.depositar(200)
        self.cliente3.extraer(150)

    def depositos_totales(self):
        total=self.cliente1.retornar_monto()+self.cliente2.retornar_monto()+self.cliente3.retornar_monto()
        print("El total de dinero del banco es:",total)
        self.cliente1.imprimir()
        self.cliente2.imprimir()
        self.cliente3.imprimir()


# bloque principal        

banco1=Banco()
banco1.operar()
banco1.depositos_totales()
```

## Herencia
La herencia significa que se pueden crear nuevas clases partiendo de clases existentes, que tendrá todas los atributos y los métodos de su 'superclase' o 'clase padre' y además se le podrán añadir otros atributos y métodos propios.

clase padre
Clase de la que desciende o deriva una clase. Las clases hijas (descendientes) heredan (incorporan) automáticamente los atributos y métodos de la la clase padre.

Subclase
Clase descendiente de otra. Hereda automáticamente los atributos y métodos de su superclase. Es una especialización de otra clase.
Admiten la definición de nuevos atributos y métodos para aumentar la especialización de la clase.

Se realiza la herencia de una clase de la siguiente manera:
```python
class Nombre_de_subclase(Nombre_de_clase_padre):
```
Para heredar las funciones se hace uso de super(). seguido del metodo a heredar (esto se hace dentro de la funcion a heredar):
```python
    super().__init__()
```

ejercicio ejemplo:
Ahora plantearemos otro problema empleando herencia. Supongamos que necesitamos implementar dos clases que llamaremos Suma y Resta. Cada clase tiene como atributo valor1, valor2 y resultado. Los métodos a definir son cargar1 (que inicializa el atributo valor1), carga2 (que inicializa el atributo valor2), operar (que en el caso de la clase "Suma" suma los dos atributos y en el caso de la clase "Resta" hace la diferencia entre valor1 y valor2), y otro método mostrar_resultado.

Si analizamos ambas clases encontramos que muchos atributos y métodos son idénticos. En estos casos es bueno definir una clase padre que agrupe dichos atributos y responsabilidades comunes.

La relación de herencia que podemos disponer para este problema es:
```
  Operacion
    |    |
Resta   Suma
```
Solamente el método operar es distinto para las clases Suma y Resta (esto hace que no lo podamos disponer en la clase Operacion en principio), luego los métodos cargar1, cargar2 y mostrar_resultado son idénticos a las dos clases, esto hace que podamos disponerlos en la clase Operacion. Lo mismo los atributos valor1, valor2 y resultado se definirán en la clase padre Operacion.
```python
class Operacion:

    def __init__(self):
        self.valor1=0
        self.valor2=0
        self.resultado=0

    def cargar1(self):
        self.valor1=int(input("Ingrese primer valor:"))

    def cargar2(self):
        self.valor2=int(input("Ingrese segundo valor:"))

    def mostrar_resultado(self):
        print(self.resultado)

    def operar(self):
        pass


class Suma(Operacion):

    def operar(self):
        self.resultado=self.valor1+self.valor2


class Resta(Operacion):

    def operar(self):
        self.resultado=self.valor1-self.valor2


# bloque princpipal

suma1=Suma()
suma1.cargar1()
suma1.cargar2()
suma1.operar()
print("La suma de los dos valores es")
suma1.mostrar_resultado()

resta1=Resta()
resta1.cargar1()
resta1.cargar2()
resta1.operar()
print("La resta de los valores es:")
resta1.mostrar_resultado()
```
```python
```
