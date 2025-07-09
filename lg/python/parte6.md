
# Bibliotecas

En Python se incluye una biblioteca extra de funciones, variables, clases etc. que nos facilitan la resolución de problemas en una gran diversidad de áreas como matemáticas, estadísticas, compresión de datos, internet, interfaces visuales etc.

## Import

Para importar un módulo de la biblioteca estándar de Python utilizamos la palabra clave import seguida por el nombre del módulo que necesitamos importar:
```python
import random    # para importar una biblioteca hacemos uso de la palabra import
```

## Bibliotecas estandar de python
`random`
nos permite hacer uso de funciones para obtener resultados aleatorios:
```python
import random

dado1=random.randint(1,6)  # se le pasa desde que valor se quiere hasta el limite
dado2=random.randint(1,6)
print("Primer dado:",dado1)
print("Segundo dado:",dado2)
suma=dado1+dado2
if suma==7:
    print("Gano")
else:
    print("Perdio")
```
`math`
nos permite hacer uso de funciones para realizar calculos matematicos
```python
from math import sqrt, pow

valor=int(input("Ingrese un valor entero:"))
r1=sqrt(valor)    # sqrt - para obtener la raíz cuadrada
r2=pow(valor,3)   # pow - para elevar un valor a cierta potencia
print("La raiz cuadrada es",r1)
print("El cubo es",r2)
```

## Tipos de importaciones

### Importación de algunas funcionalidades de un modulo
En Python tenemos otra sintaxis para las situaciones que queremos acceder a una o pocas funcionalidades de un módulo.
Por ejemplo si queremos acceder solo a la función randint del módulo random en Python lo podemos expresar con la siguiente sintaxis:
```python
from random import randint
```

También cambia como utilizamos la función randint dentro de nuestro módulo:
```python
valor=randint(1,10)
print(valor)
```

### Definición de un alias para una funcionalidad
tambien se puede definir un nombre distinto para una funcionalidad que importamos de otro módulo.
```python
from math import sqrt as raiz, pow as elevar # definimos sqrt como raiz y pow como elevar

valor=int(input("Ingrese un valor entero:"))
r1=raiz(valor)
r2=elevar(valor,3)
print("La raiz cuadrada es",r1)
print("El cubo es",r2)
```

## Aplicaciones con varios módulos

En Python podemos agrupar funciones en distintos archivos (módulos) y luego importarlos en otros módulos.

ejercicio ejemplo:

Confeccionar un módulo que implemente dos funciones, una que retorne el mayor de dos enteros y otra que retorne el menor de dos enteros.
En el módulo principal importar solo la función que retorne el mayor, luego cargar dos enteros y mostrar el mayor de ellos
Crear una carpeta y dentro de la misma crear dos módulos llamados:
mayormenor.py
principal.py
El módulo mayormenor.py contiene las dos funciones que identifican el mayor de dos enteros por un lado y el menor de dos enteros.
```python
def mayor(x1,x2):
    if x1>x2:
        return x1
    else:
        return x2


def menor(x1,x2):
    if x1<x2:
        return x1
    else:
        return x2
```
Por otro lado el programa principal que importa solo la función mayor es:
```python
from mayormenor import mayor

valor1=int(input("Ingrese primer valor:"))
valor2=int(input("Ingrese segundo valor:"))
print("El mayor de los dos valores es",mayor(valor1,valor2))  
```
`Para este ejemplo creamos: mayormenor.py, principal.py. El modulo que ejecutamos es el principal.py y este modulo importa y hace uso de mayormenor.py`
