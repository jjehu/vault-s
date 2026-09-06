```java
```
# Fundamentos
## Métodos
Un método es un bloque de código que realiza una tarea específica. Tiene un encabezado, nombre y parámetros. El método principal es main, que inicia la ejecución del programa. Los métodos pueden devolver valores o no (void).

Estructura general de un método:
```java
  public [static] tipoDevuelto nombreMetodo(listaParámetros)[
    // lista de instrucciones;
    [return valor];
  )
```
El método principal figura de la siguiente forma:
```java
public static void main(String[] args){
  // instrucciones;
}
```

## Identificadores
Son nombres únicos para clases, métodos, variables, etc. Deben comenzar con una letra y pueden contener letras, dígitos, guiones bajos o el símbolo $. Son sensibles a mayúsculas y minúsculas.

Ejemplo de identificador:
```
saldoCuenta
saldo_cuenta
```
Tres variables distintas (por que es sensible a mayúsculas y minúsculas):
```
contador
CONTADOR
Contador
```
## Palabras Reservadas
Java tiene palabras reservadas que no pueden usarse como identificadores:
| Column1 | Column2 | Column3 | Column4 | Column5 |
| :---: | :---: | :---: | :---: | :---: |
| abstract | continue | for | new | switch |
| assert | default | goto | package | synchronized |
| boolean | do | if | private | this |
| break | double | implements | protected | throw |
| byte | else | import | public | throws |
| case | enum | instanceof | return | transient |
| catch | extends | int | short | try |
| char | final | interface | static | void |
| class | finally | long | strictfp | volatile |
| const | float | native | super | while |

## Comentarios
Los comentarios documentan el código y pueden ser de línea (//) o de bloque (/* y */). Son ignorados por el compilador y ayudan a entender el programa.
Ejemplo de comentarios:
```java
// Este es un comentario de linea
/* Programa
demostrativo
Hola Mundo
*/
public class Ejemplo{
  public static void main(String[] args){
    System.out.println("Hola Mundo");// Esta es una instruccion de impresion, en este caso imprime "Hola Mundo"
  }
}
```

## Tipos de Datos Primitivos
Java tiene tipos de datos primitivos: enteros (byte, short, int, long), reales (float, double), caracteres (char) y booleanos (boolean). Cada uno tiene un rango y tamaño específico en memoria.
Las diferencias entre los diferentes tipos enteros y entre los diferentes tipos reales se encuentran en el rango que soportan los mismos y en el tamaño de memoria que
requieren:

| TIPO | DESCRIPCIÓN | BYTES | RANGO |
| :---: | :---: | :---: | :---: |
| byte | Entero de 1 byte | 1 | -128 a +127 |
| short | Entero pequeño | 2 | -32768 a +32767 |
| int | Entero | 4 | -2147483648 a 2147483647 |
| long | Entero grande | 8 | -9223372036854775808 a 9223372036854775807 |
| float | Real simple precisión | 4 | ±1.40239846e -44 a ±3.40282347e +38 |
| double | Real doble precisión | 8 | ±4.9406564584124e-308 a ±1.7976931348623e +308 |
| char | Carácter UNICODE | 2 | \u0000 a \uffff (hex) o \000 a \777 (octal)  |
| boolean | Booleano |  | false o true |

> [!NOTE]
> El rango de cada tipo queda definido por las diferentes combinaciones de los valores binarios que caben en la cantidad de bytes de la memoria RAM que utiliza cada tipo; por ejemplo, el tipo byte, ocupa 1 byte, equivalente a 8 bits; y con 8 bits, se tiene una combinación de 2⁸ = 256 valores binarios diferentes, de los cuales, la mitad se asigna a los valores negativos (-1 a -128) y la mitad a los valores positivos (0 a +127).\
> Los valores límites de los tipos de datos numéricos se pueden obtener a través de las constantes `MIN_VALUE` Y `MAX_VALUE` asociados a las clases de esos tipos. Por ejemplo: `Integer.MAX_VALUE`. 

## Literales
Los literales son valores fijos en el código, como números, caracteres, booleanos y cadenas. Pueden escribirse en diferentes bases (decimal, hexadecimal, octal) y con notación científica para reales.
Los literales son valores que se escriben directamente dentro de un programa, como números, caracteres, palabras o valores lógicos.

### Literales enteros
Son números sin decimales, como `23`, `-345` o `100`.
- Por defecto, los números enteros son de tipo **int**.
- Para indicar que un número es de tipo long, se agrega `L` al final. Ejemplo: `1234L`.
- Los números hexadecimales comienzan con `0x`. Ejemplo: `0x58` o `0xFF`.
- Los números octales comienzan con `0`. Ejemplo: `077` o `023`.

Ejemplo:
```java
System.out.println(12345);
System.out.println(12345L);
System.out.println(077);
System.out.println(0xFF);
```
### Literales reales
Son números que contienen decimales, por ejemplo `2.0`, `4.232` o `-23.44`.
- Por defecto, estos números son de tipo **double**.
- Para indicar que son de tipo float, se agrega `f` o `F`. Ejemplo: `23.32f`.
- También pueden escribirse usando notación científica, como `3.456e3` o `1.2E-300`.

Ejemplo:
```java
System.out.println(123.456f);
System.out.println(222.222);
System.out.println(-3.e38f);
```
### Literales de tipo carácter (char)
Representan un solo carácter, como una letra, número o símbolo. Se escriben entre **comillas simples**.

Ejemplos:
```java
'A'
'a'
'5'
```
También es posible representar un carácter utilizando su código ASCII. Por ejemplo, el número `65` corresponde a `'A'` y el `97` corresponde a `'a'`.
```java
System.out.println((char)65);
System.out.println((char)97);
```
Otra forma es utilizar Unicode, que permite representar una gran variedad de caracteres. Se escribe utilizando `\u` seguido de un código hexadecimal.

Es importante utilizar una codificación adecuada, como UTF-8, para que caracteres especiales como `á`, `ñ` o `é` se muestren correctamente.

### Literales booleanos
Los valores booleanos solo pueden tener dos opciones:
- `true` → verdadero.
- `false` → falso.
Ejemplo:
```java
System.out.println(true);
System.out.println(false);
```
### Literales de tipo cadena (String)
Una cadena es un conjunto de cero o más caracteres y se escribe entre comillas dobles.

Ejemplos:
```java
"Hola"
"Programación"
"Esta es una cadena"
""
```
Es importante diferenciar una cadena de un carácter:
- `"a"` → es una cadena (String).
- `'a'` → es un carácter (char).

## Secuencias de Escape
Son caracteres especiales dentro de cadenas, como: 
`\n` nueva línea\
`\t` tabulador\
`\\` barra invertida (`\`)\
`\'` comilla simple (`'`)\
`\"` comilla doble (`"`)

## Variables
Una variable es un nombre asociado a un espacio de memoria para almacenar un valor. Java es fuertemente tipado, por lo que cada variable debe declararse con un tipo. Es recomendable inicializarlas para evitar errores.
## Operador de Asignación
El operador = asigna un valor a una variable. La expresión a la derecha se evalúa y el resultado se almacena en la variable de la izquierda.
## Conversión de Tipos de Datos (Cast)
La conversión de tipos puede ser implícita (automática) o explícita (cast). Se usa para convertir valores entre tipos compatibles, cuidando los posibles errores por pérdida de información.
## Constantes
Una constante es un valor fijo que no cambia durante la ejecución. Se declara con la palabra final.
## Salida de Datos
La salida de datos se realiza principalmente en pantalla usando System.out.print(), System.out.println() y System.out.printf(). Permiten mostrar información y dar formato a la salida.
## Operadores Aritméticos
Permiten realizar operaciones matemáticas básicas: suma (+), resta (-), multiplicación (*), división (/) y módulo (%). Existen operadores abreviados y de incremento/decremento.
## Operadores de Relación
Comparan dos valores y devuelven un booleano: igual (==), diferente (!=), mayor (>), menor (<), mayor o igual (>=), menor o igual (<=).
## Operadores Lógicos
Relacionan valores booleanos: not (!), and (&&), or (||), xor. Se usan para construir expresiones lógicas complejas.
## Operadores de Bit
Operan a nivel binario sobre valores enteros: not (~), or (|), and (&), desplazamientos (<<, >>, >>>). Permiten manipular bits directamente.
## Operador de Concatenación
El operador + une cadenas de texto. Si uno de los operandos es una cadena, el otro se convierte automáticamente a cadena.
## Evaluación de Expresiones
Una expresión es una combinación de literales, variables y operadores que produce un resultado. En Java, las expresiones se escriben en formato lineal y se pueden usar paréntesis para definir el orden de evaluación.

## Jerarquia de operadores
## Entrada de datos
## Estructuras de control
## Contadores y acumuladores
## Metodos definidos por el usuario
## Bibliotecas predefinidas
## Ambito de variables
## Creacion y ejecucion de un programa Java desde consola
## Codigo Ascii
## Codigo Unicode
