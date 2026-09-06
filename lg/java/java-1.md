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
- `\n` → nueva línea
- `\t` → tabulador
- `\\` → barra invertida (`\`)
- `\'` → comilla simple (`'`)
- `\"` → comilla doble (`"`)

## Variables
Una variable es un nombre asociado a un espacio de memoria para almacenar un valor. Java es fuertemente tipado, por lo que cada variable debe declararse con un tipo. Es recomendable inicializarlas para evitar errores.
Las variables se declaran empezando con el nombre del tipo de dato, seguido por el nombre o identificador de la variable, ejemplo:
```java
char caracter1;
int Contador;
boolean luzEncendida;
```

> [!IMPORTANT]
> Al declarar variables, Java no asigna un valor por defecto y en ocasiones esto provoca errores.

## Operador de Asignación
El operador = asigna un valor a una variable. La expresión a la derecha se evalúa y el resultado se almacena en la variable de la izquierda.
Ejemplo:
```java
int numero = 123456;// se hace uso del operador de asignacion = y le damos el valor 123456
char letra = 'a';
float valorReal = 31.23f
boolean luzEncendida = true;
```
> [!IMPORTANT]
> Se debe cuidar que el valor a asignar a una variable, se encuentre dentro del rango válido del tipo de dato de la variable. 

## Conversión de Tipos de Datos (Cast)
La conversión de tipos puede ser implícita (automática) o explícita (cast). Se usa para convertir valores entre tipos compatibles, cuidando los posibles errores por pérdida de información.

Tipos de datos ordenados de menor a mayor:\
Enteros: byte → short  → int → long\
Reales: float → double\
byte → short → int → float → long → double

**Conversión Implicita (automática)** se presenta cuando se convierte un valor cuyo rango de tipo de dato es menor o igual al rango destinado.\
Ejemplo
```java
public classs Ejemplo{
  public static void main(String[] args){
    int x=23;
    short y=123;
    x=y;//asignación válida.
  }
}
```
**Conversión Explícita (cast)** se presenta cuando se convierte un valor de tipo de dato de mayor rango a uno de menor rango, para ello el valor a convertir se antecede explícitamente con el tipo de dato destino, encerrado en paréntesis.\
Ejemplo
```java
public class Ejemplo{
  public static void main(String[] args){
    int x=23;
    short y=123;
    y=(short) x;
    System.out.println(x);
    System.out.println(y);
  }
}
```

> [!IMPORTANT]
> La conversión explícita corre el riesgo de la alteración del valor original cuando éste se encuentra fuera del rango del tipo destino y es de responsabilidad del programador cuidar ese aspecto.
> ```java
> public class Ejemplo (
> public static void main(String[] args) [
> int x=1000;
> byte y= (byte) x;
> System.out.printin(y);
> double d=1e100;
> float f=1f;
> f=(float) d;
> System.out.printin(f);
> ) 
> ```

## Constantes
Una constante es un valor fijo que no cambia durante la ejecución. Se declara con la palabra final.\
Ejemplo:
```java
final double pi = 3.141592653589;
final boolean verdadero = true;
```

## Salida de Datos
La salida de datos se realiza principalmente en pantalla usando:
- `System.out.print()` imprime en pantalla el contenido o argumento del parentesís.
- `System.out.println()` imprime en pantalla el contenido o argumento del parentesís, agrega un salto de linea al finalizar.
- `System.out.printf()` imprime contenido con un formato específico.
Permiten mostrar información y dar formato a la salida.

El método `printf()`, permite dar formato a la salida, para lo cuál se usan especificadores de formato, de acuerdo a la siguiente tabla:
| Especificador | Descripción |
|---|---|
| `%b`, `%B` | Imprime un valor booleano |
| `%c` | Imprime un carácter |
| `%d`, `%i` | Imprime un número decimal con signo |
| `%f` | Imprime un número de tipo `float` o `double` |
| `%s`, `%S` | Imprime una cadena (String) |
| `%u` | Imprime un número decimal sin signo |
| `%o` | Imprime un número octal sin signo |
| `%x`, `%X` | Imprime un número hexadecimal sin signo |
| `%e`, `%E` | Imprime en notación científica |
| `%n` | Nueva línea |
| `%%` | Imprime el carácter `%` |

## Operadores Aritméticos
Permiten realizar operaciones matemáticas básicas:
- Suma (`+`)
- Resta (`-`)
- Multiplicación (`*`)
- División (`/`)
- Módulo (`%`), residuo de la división entera
Existen operadores abreviados y de incremento/decremento.

Java soporta también un conjunto de operadores abreviados:
| Nombre | Operador | Descripción |
|---|---|---|
| Suma o adición | `+=` | `x += y;` equivale a `x = x + y;` |
| Resta o sustracción | `-=` | `x -= y;` equivale a `x = x - y;` |
| Multiplicación o producto | `*=` | `x *= y;` equivale a `x = x * y;` |
| Cociente de la división entera | `/=` | `x /= y;` equivale a `x = x / y;` |
| Resto de la división entera | `%=` | `x %= y;` equivale a `x = x % y;` |
| División | `/=` | `x /= y;` equivale a `x = x / y;` |
| Pre incremento | `++` | `x = ++y;` equivale a `y = y + 1; x = y;` |
| Pre decremento | `--` | `x = --y;` equivale a `y = y - 1; x = y;` |
| Post incremento | `++` | `x = y++;` equivale a `x = y; y = y + 1;` |
| Post decremento | `--` | `x = y--;` equivale a `x = y; y = y - 1;` |

> [!IMPORTANT]
> Los operadores de incremento y decremento tienen comportamientos diferentes si el operador precede o sucede a la variable:
> ```java
> public class Ejemplo (
>   public static void main(String[] args) [
>     int a=10, b=10, c, d;
>     System.out.printin(a++);
>     System.out.printin(a);
>     System.out.printin(++b);
>     System.out.printin(b);
>     c=--a*2;
>     d=b--*2;
>     System.out.printin(c);
>     System.out.printin(d);
>   }
> }
> ```

Existen valores especiales de los números reales de Java, que son:
- `Infinity` : significa infinito y se obtiene cuándo el resultado de una operación tiende a +/- infinito
- `NaN` : significa Not As Number (no es un número), y se obtiene cuando el resultado de una operación númerica no corresponde a un número.

## Operadores de Relación
Comparan dos valores y devuelven un booleano:
- Igual (`==`)
- Diferente (`!=`)
- Mayor (`>`)
- Menor (`<`)
- Mayor o igual (`>=`)
- Menor o igual (`<=`)

Ejemplo:
```java
public class Main {
    public static void main(String[] args) {
        int a = 200;
        double b = 50.5;
        char c = 'm';
        char d = 'n';

        System.out.print("a=");
        System.out.println(a);
        System.out.print("b=");
        System.out.println(b);
        System.out.print("c=");
        System.out.println(c);
        System.out.print("d=");
        System.out.println(d);

        System.out.print("a mayor que b, es: ");
        System.out.println(a > b);
        System.out.print("a igual que b, es: ");
        System.out.println(a == b);
        System.out.print("a diferente que b, es: ");
        System.out.println(a != b);
        System.out.print("a menor que b, es: ");
        System.out.println(a < b);

        System.out.print("c mayor que d, es: ");
        System.out.println(c > d);
        System.out.print("c menor que d, es: ");
        System.out.println(c < d);

        System.out.print("a mayor que c, es: ");
        System.out.println(a > c);
        System.out.print("a menor que c, es: ");
        System.out.println(a < c);

        System.out.print("b mayor que c, es: ");
        System.out.println(b > c);
        System.out.print("b menor que c, es: ");
        System.out.println(b < c);
    }
}
```

## Operadores Lógicos
Relacionan valores booleanos:
- not (`!`)
- and (`&&`)
- or (`||`)
- xor u or exclusivo (`^`)
Se usan para construir expresiones lógicas complejas.

```java
public class Ejemplo {
    public static void main(String[] args) {
        int a = 5, b = 5, c = 10;
        boolean resultado;

        System.out.println("Si: a = 5; b = 5; c = 10, entonces:");
        System.out.println();

        resultado = (a == b) && (c > b);
        System.out.print("(a == b) && (c > b) es igual a ");
        System.out.println(resultado);

        resultado = (a == b) && (c < b);
        System.out.print("(a == b) && (c < b) es igual a ");
        System.out.println(resultado);

        resultado = (a == b) || (c < b);
        System.out.print("(a == b) || (c < b) es igual a ");
        System.out.println(resultado);

        resultado = (a != b) || (c < b);
        System.out.print("(a != b) || (c < b) es igual a ");
        System.out.println(resultado);

        resultado = !(a == b);
        System.out.print("!(a == b) es igual a ");
        System.out.println(resultado);

        resultado = !(a != b);
        System.out.print("!(a != b) es igual a ");
        System.out.println(resultado);
    }
}   
```
```
Si: a = 5; b = 5; c = 10, entonces:

(a == b) && (c > b) es igual a true
(a == b) && (c < b) es igual a false
(a == b) || (c < b) es igual a true
(a != b) || (c < b) es igual a false
!(a == b) es igual a false
!(a != b) es igual a true   
```

## Operadores de Bit
Son herramientas de programación que trabajan directamente con la representación binaria de los números enteros (incluyendo el tipo char) y devuelven un resultado de tipo entero.
Operan a nivel binario sobre valores enteros:
- not (`~`)
- or (`|`)
- and (`&`)
- desplazamientos (izquierdo `<<`, derecho `>>`, derecho sin signo `>>>`)
Permiten manipular bits directamente.

### El operador Not
Cuando aplicas el operador Not a un número positivo, invierte sus ceros y unos.\
Ejemplo: Al aplicarlo a 12 (en binario 00001100), se invierte a 11110011.\
Como las computadoras usan el sistema de complemento a dos para representar números negativos, ese patrón de bits equivale exactamente a -13.

### Operadores binarios bit a bit
Salvo el Not, los demás evalúan el primer bit del primer número con el primer bit del segundo, y así sucesivamente.\
Ejemplo: Al operar 14 (00001110) y 119 (01110111) bit a bit, se obtiene 6 (00000110), ya que se comparan las posiciones correspondientes de ambos números.\

```java
import java.util.Scanner;

public class OperadoresBitsEjemplos {
    public static void main(String[] argumentos) {
        
        System.out.println("--- EJEMPLO 1: Operador Not (-) ---");
        // El operador Not (complemento a 1) invierte los bits del número.
        // En complemento a dos, invertir los bits de 12 da como resultado -13.
        
        byte a = 12;
        System.out.println("Not de byte 12: " + (-a)); // Resultado: -13
        
        short b = 12;
        System.out.println("Not de short 12: " + (-b)); // Resultado: -13
        
        int c = 12;
        System.out.println("Not de int 12: " + (-c)); // Resultado: -13
        
        long d = 12;
        System.out.println("Not de long 12: " + (-d)); // Resultado: -13


        System.out.println("\n--- EJEMPLO 2: Operador And bit a bit (&) ---");
        // El operador opera bit a bit entre dos números.
        // 14 en binario:  00001110
        // 119 en binario: 01110111
        // Resultado AND:  00000110 (que equivale a 6)
        
        byte num1 = 14;
        byte num2 = 119;
        System.out.println("Resultado byte (14 & 119): " + (num1 & num2)); // Resultado: 6

        int num3 = 14;
        int num4 = 139; // Nota: el texto original usa 139 o 119, opera bit a bit según corresponda
        System.out.println("Resultado int (14 & 139): " + (num3 & num4)); // Resultado: 6
    }
}
```
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

```java
```
