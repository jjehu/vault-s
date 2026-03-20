# Variables

Variables de tipo numerico enteros:
```kotlin
Byte
Short
Int
Long
```
`Estas variables se utilizan dependiendo de cuanta memoria queremos reservar para la variable y lo que haremos con ella:`
```
Tipo de vatiable                   mínimo                          máximo
Byte                                 -128                            +127
Short                             -32 768                         +32 767
Int                        -2 147 483 648                  +2 147 483 647
Long           -9 223 372 036 854 775 808      +9 223 372 036 854 775 807
```
En caso de que necesitemos almacenar un valor con decimal se utilizan las variables de tipo `Double` o `Float`
```kotlin
Double
Float
```
La variable de tipo `String` permiten almacenar un conjunto de caracteres:
```kotlin
String
```
Las variables en Kotlin pueden ser inmutables (que no cambia de valor) o mutables (que pueden cambiar de valor).
Para definir una variable en Kotlin inmutable utilizamos la palabra clave `val`, por ejemplo:
```kotlin
    val edad: Int
    edad = 48
    val sueldo: Float
    sueldo = 1200.55f
    val total: Double
    total = 70000.24
    val titulo: String
    titulo = "Sistema de Ventas"
```
Las variables inmutables una vez definidas ya no pueden cambiar de valor, en caso de que se intente el compilador generará un error

Las variables mutables pueden ser cambiadas de valor después de ser declaradas:
```kotlin
    var mes: Int
    mes = 1
    // algunas líneas más de código
    mes = 2
```
En caso de que necesitemos almacenar un único caracter se utilizan la variable de tipo `Char`
```kotlin
Char
```
ejemplo
```kotlin
var continua:Char='s'
```
Podemos hacer que lo infiera el compilador de Kotlin:
```kotlin
var continua='s'
```
En caso de que necesitemos almacenar un valor de tipo lógico se utilizan la variable de tipo `Boolean`
```kotlin
var fin:Boolean=false
```
