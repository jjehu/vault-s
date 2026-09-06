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
En programación, el signo `+` tiene una doble función: además de sumar números, sirve para unir textos (operación conocida como concatenación).\
> Regla clave: Si al menos uno de los elementos que se unen es un texto (string), el otro valor se convierte automáticamente en texto y se pegan ambos.

Ejemplo práctico\
El siguiente código muestra cómo combinar textos, números, variables y constantes utilizando el operador `+`:
```java
public class Ejemplof {
    public static void main(String[] args) {
        final String despedida = "ADIOS";
        String título = "Ingeniería";
        String carrera = "Informática";
        int año = 2020;
        float avance = 24.59f;

        // Une textos y variables
        System.out.println("Estudio " + título + " " + carrera);
        
        // Convierte el número decimal a texto y lo une
        System.out.println("Tenemos un avance de " + avance + "%");
        
        // Permite realizar operaciones matemáticas (año + 5) antes de unirlas al texto
        System.out.println("Estamos en " + año + " y pienso titularme el " + (año + 5));
        
        // Imprime una constante de texto simple
        System.out.println(despedida);
    }
}
```

## Evaluación de Expresiones
Una expresión es una combinación de literales, variables y operadores que produce un resultado. En Java, las expresiones se escriben en formato lineal y se pueden usar paréntesis para definir el orden de evaluación.

Ejemplos:\
Matemática: $\frac{-b + \sqrt{b^2 - 4ac}}{2a}$\
Lineal: (-b + raiz(b * b - 4 * a * c)) / (2 * a)

Matemática: $\frac{a + b}{a - b} + x^2$\
Lineal: (a + b) / (a - b) + x * x

Matemática: $\frac{a + \sqrt{\frac{b}{x^3 + y}}}{a - \sin(b)}$\
Lineal: (a + raiz(b / (x * x * x + y))) / (a - sin(b))

## Jerarquia de operadores
Es el conjunto de reglas que determina el orden en que se evalúan las operaciones dentro de una expresión para obtener un resultado correcto.

**Reglas básicas de evaluación**
1. Paréntesis: Siempre se resuelven primero las expresiones entre paréntesis, empezando por los más internos.
2. Precedencia: Los operadores con mayor jerarquía se calculan antes (ver tabla abajo).
3. De izquierda a derecha: Los operadores con la misma jerarquía se evalúan en el orden en que aparecen de izquierda a derecha.

| Jerarquía | Descripción | Operadores |
|---|---|---|
| 1 | Operadores posfijos | `Op++` `Op--` |
| 2 | Operadores prefijos y unarios | `++Op` `--Op` `+Op` `-Op` `!` |
| 3 | Multiplicación y división | `*` `/` `%` |
| 4 | Suma y resta | `+` `-` |
| 5 | Desplazamiento | `<<` `>>` `>>>` |
| 6 | Operadores relacionales | `<` `>` `<=` `>=` |
| 7 | Equivalencia | `==` `!=` |
| 8 | Operador AND | `&` |
| 9 | Operador XOR | `^` |
| 10 | Operador OR | `|` |
| 11 | AND booleano | `&&` |
| 12 | OR booleano | `||` |
| 13 | Condicional | `? :` |
| 14 | Operadores de asignación | `=` `+=` `-=` `/=` `*=` `%=` `&=` `^=` `|=` `<<=` `>>=` `>>>=` |

Ejemplos1:\
- Expresión: `2 + 6 < 8 * 2 || 1 - 2 > -3 && 23 < 23`
- Evaluación paso a paso:
  - Multiplicación y sumas/restas aritméticas: `8 < 16 || -1 > -3 && 23 < 23`
  - Operadores relacionales (`<`, `>`, `&&` implícito en relaciones): `true || true && false`
  - Operador AND (`&&`): `true || false`
  - Operador OR (`||`): `true`
Código en Java:
```java
public class Ejemplof {
    public static void main(String[] args) {
        System.out.println(2 + 6 < 8 * 2 || 1 - 2 > -3 && 23 < 23);
    }
}
```
Ejemplos2:\
- Expresión: `10 <= 2 * 5 && 3 < 4 || !(8 > 7) && 3 * 2 <= 4 * 2 - 1`
- Evaluación paso a pragmatic:
  - Operaciones aritméticas y negación: `10 <= 10 && 3 < 4 || false && 6 <= 7`
  - Relaciones lógicas: `true && true || false && true`
  - Operadores AND (`&&`): `true || false`
  - Operador OR (`||`): `true`

Código en Java:
```java
public class Ejemplof {
    public static void main(String[] args) {
        System.out.println(10 <= 2 * 5 && 3 < 4 || !(8 > 7) && 3 * 2 <= 4 * 2 - 1);
    }
}
```
## Entrada de datos
La entrada de datos es el proceso mediante el cual una computadora recibe información desde diferentes dispositivos, como el teclado, el ratón, el escáner, el disco duro o una memoria flash, y la lleva a la memoria principal de la computadora.\
El teclado es el dispositivo de entrada más utilizado, ya que permite escribir números, palabras y diferentes tipos de información.

Para que un programa pueda recibir información del usuario, necesitamos crear un canal por donde puedan pasar los datos. En Java, una de las clases que permite hacer esto es `Scanner`.
Primero debemos importar la clase `Scanner` y después crear un objeto que nos permita utilizarla:
```java
import java.util.Scanner;//permite utilizar la clase Scanner

public class Ejemplo {
    public static void main(String[] args) {
        Scanner nombre = new Scanner(System.in);//crea un objeto para recibir los datos, System.in indica que los datos seran introducidos por el usuario mediante la entrada estandar, normalmente teclado
    }
}
```
La clase Scanner tiene diferentes métodos para leer distintos tipos de datos. El programa normalmente espera hasta que el usuario escriba el dato y presione Enter.
- `next()` → permite ingresar una palabra.
- `nextLine()` → permite ingresar una frase o una línea completa.
- `nextByte()` → permite ingresar un número de tipo byte.
- `nextShort()` → permite ingresar un número de tipo short.
- `nextInt()` → permite ingresar un número entero de tipo int.
- `nextLong()` → permite ingresar un número entero de tipo long.
- `nextFloat()` → permite ingresar un número decimal de tipo float.
- `nextDouble()` → permite ingresar un número decimal de tipo double.
- `nextBoolean()` → permite ingresar un valor lógico: true o false.

```
import java.util.Scanner;

public class Ejemplo {
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);

        System.out.print("Escriba un número de tipo byte: ");
        byte numero1 = tec.nextByte();
        System.out.println("Su número es: " + numero1);

        System.out.print("Escriba un número de tipo short: ");
        short numero2 = tec.nextShort();
        System.out.println("Su número es: " + numero2);

        System.out.print("Escriba un número de tipo int: ");
        int numero3 = tec.nextInt();
        System.out.println("Su número es: " + numero3);

        System.out.print("Escriba un número de tipo long: ");
        long numero4 = tec.nextLong();
        System.out.println("Su número es: " + numero4);

        System.out.print("Escriba un número de tipo float: ");
        float numero5 = tec.nextFloat();
        System.out.println("Su número es: " + numero5);

        System.out.print("Escriba un número de tipo double: ");
        double numero6 = tec.nextDouble();
        System.out.println("Su número es: " + numero6);

        System.out.print("Escriba un valor booleano: ");
        boolean logico = tec.nextBoolean();
        System.out.println("Su valor booleano es: " + logico);

        System.out.print("Escriba una palabra: ");
        String palabra = tec.next();
        System.out.println("Su palabra es: " + palabra);

        tec.nextLine();

        System.out.print("Escriba una frase: ");
        String frase = tec.nextLine();
        System.out.println("Su frase es: " + frase);
    }
}
```
**buffer**\
Cuando se transfieren datos entre dos dispositivos, es posible que uno sea mucho más rápido que el otro. Por ejemplo, la memoria RAM es mucho más rápida que una impresora.

Si ambos dispositivos se comunicaran directamente, el dispositivo más lento podría hacer que el dispositivo rápido tuviera que esperar.

Para evitar esto, se utiliza una memoria intermedia llamada buffer.

El buffer almacena temporalmente los datos mientras espera que el dispositivo más lento pueda procesarlos. De esta manera, el dispositivo rápido puede continuar trabajando sin tener que esperar constantemente al dispositivo lento.

> [!CAUTION]
> **Problema del buffer con Scanner**\
> Un problema común en Java aparece cuando utilizamos `nextInt()` y después queremos utilizar `nextLine()`.\
> Por ejemplo:
> ```java
> int n = tec.nextInt();
> String cad = tec.nextLine();
> ```
> Después de escribir el número y presionar `Enter`, `nextInt()` lee el número, pero el carácter correspondiente al salto de línea queda dentro del buffer.\
> Cuando se ejecuta `nextLine()`, este método encuentra ese salto de línea y considera que el usuario ya terminó de escribir. Por eso, la variable `cad` puede quedar vacía.
>
> **¿Cómo solucionar el problema?**\
> Para solucionar este problema, debemos utilizar un `nextLine()` adicional inmediatamente después de leer el número.
> Este `nextLine()` sirve para consumir o limpiar el salto de línea que quedó en el buffer.
> ```java
> import java.util.Scanner;
>
> public class Ejemplo {
>     public static void main(String[] args) {
>         int n;
>         String cad;
>
>         Scanner tec = new Scanner(System.in);
>
>         n = tec.nextInt();
>
>         // Limpia el salto de línea que quedó en el buffer
>         tec.nextLine();
>
>         // Ahora se puede leer correctamente la frase
>         cad = tec.nextLine();
>
>         System.out.println(n);
>         System.out.println(cad);
>     }
> }
> ```

## Estructuras de control
Las estructuras de control permiten determinar el orden en que se ejecutan las instrucciones de un programa. Gracias a ellas, un programa puede ejecutar instrucciones de manera secuencial, tomar decisiones según determinadas condiciones y repetir un conjunto de instrucciones las veces que sean necesarias.

En programación, las estructuras de control se clasifican principalmente en **estructuras secuenciales, selectivas y repetitivas**.

### Estructuras secuenciales
Las estructuras secuenciales son aquellas en las que las instrucciones se ejecutan una después de otra, siguiendo el orden en el que fueron escritas.\
Este tipo de estructura es la más sencilla, ya que no necesita condiciones ni repeticiones. Cada instrucción se ejecuta una sola vez antes de pasar a la siguiente.

Ejemplo
```java
public class Secuencial {
    public static void main(String[] args) {
        int numero1 = 10;
        int numero2 = 5;

        int suma = numero1 + numero2;

        System.out.println("El resultado es: " + suma);
    }
}
```
En este ejemplo, primero se almacenan dos números, después se realiza la suma y finalmente se muestra el resultado. Las instrucciones se ejecutan de forma secuencial.

### Estructuras selectivas
Las estructuras selectivas permiten que un programa tome decisiones. Para ello, se evalúa una condición y, dependiendo de si esta se cumple o no, se ejecuta un determinado bloque de instrucciones.

Entre las estructuras selectivas más utilizadas se encuentran `if`, `if-else`, el operador condicional y `switch`.

#### Estructura if (si)
La estructura `if` permite ejecutar un bloque de código únicamente cuando una determinada condición es verdadera.\
Su sintaxis básica es:
```java
if (condicion) {
    // Instrucciones
}
```
Ejemplo
```java
int edad = 20;

if (edad >= 18) {
    System.out.println("La persona es mayor de edad.");
}
```
En este caso, el programa comprueba si la variable `edad` es mayor o igual a 18. Si la condición es verdadera, se muestra el mensaje.\
Si la condición es falsa, el programa continúa con la siguiente instrucción sin ejecutar el contenido del `if`.

#### Estructura if else
La estructura `if-else` permite establecer dos posibles caminos. Si la condición es verdadera, se ejecuta el bloque correspondiente al `if`; si es falsa, se ejecuta el bloque correspondiente al `else`.

Su sintaxis es:
```java
if (condicion) {
    // Instrucciones si la condición es verdadera
} else {
    // Instrucciones si la condición es falsa
}
```
Ejemplo
```java
int edad = 16;

if (edad >= 18) {
    System.out.println("La persona es mayor de edad.");
} else {
    System.out.println("La persona es menor de edad.");
}
```
En este ejemplo, el programa evalúa la edad. Como el valor es menor que 18, se ejecuta el bloque `else`.

Esta estructura resulta útil cuando existen dos alternativas posibles.

#### Operador condicional
El operador condicional, también conocido como **operador ternario**, permite realizar una selección sencilla utilizando una sola línea de código.

Su sintaxis es:
```
condicion ? valorSiVerdadero : valorSiFalso;
```
Ejemplo
```java
int edad = 20;

String resultado = (edad >= 18) ? "Mayor de edad" : "Menor de edad";

System.out.println(resultado);
```
En este caso, el programa comprueba la condición `edad >= 18`.
- Si la condición es verdadera, se asigna `"Mayor de edad"`.
- Si la condición es falsa, se asigna `"Menor de edad"`.
El operador condicional es recomendable cuando la decisión es sencilla. Para situaciones más complejas, generalmente resulta más conveniente utilizar `if-else`.

#### Estructura switch
La estructura `switch` permite seleccionar una opción entre diferentes alternativas a partir del valor de una variable o expresión.

Su sintaxis básica es:
```java
switch (variable) {
    case valor1:
        // Instrucciones
        break;

    case valor2:
        // Instrucciones
        break;

    default:
        // Instrucciones
}
```
Ejemplo
```java
int dia = 3;

switch (dia) {
    case 1:
        System.out.println("Lunes");
        break;

    case 2:
        System.out.println("Martes");
        break;

    case 3:
        System.out.println("Miércoles");
        break;

    case 4:
        System.out.println("Jueves");
        break;

    case 5:
        System.out.println("Viernes");
        break;

    default:
        System.out.println("Día no válido");
}
```
En este ejemplo, el programa analiza el valor de la variable `dia`. Como su valor es `3`, se ejecuta el `case 3` y se muestra `"Miércoles"`.

La sentencia `break` permite finalizar el `switch` una vez encontrada la opción correspondiente. El bloque `default` se ejecuta cuando ninguno de los casos coincide con el valor evaluado.

### Estructuras repetitivas
Las estructuras repetitivas permiten ejecutar un bloque de instrucciones varias veces mientras se cumpla una determinada condición o durante un número específico de repeticiones.\
Estas estructuras también reciben el nombre de bucles o ciclos.

Las estructuras repetitivas más utilizadas son `for`, `while` y `do-while`.

#### Estructura for
La estructura `for` se utiliza principalmente cuando se conoce de antemano la cantidad de veces que debe repetirse un bloque de código.

Su sintaxis es:
```java
for (inicialización; condición; actualización) {
    // Instrucciones
}
```
Ejemplo
```java
for (int i = 1; i <= 5; i++) {
    System.out.println("Número: " + i);
}
```
El funcionamiento del ciclo es el siguiente:
1. Se inicializa la variable `i` con el valor `1`.
2. Se comprueba si `i <= 5`.
3. Si la condición es verdadera, se ejecuta el bloque de código.
4. Se incrementa `i` en uno.
5. El proceso se repite hasta que la condición sea falsa.

Como resultado, se muestran los números del 1 al 5.

#### Estructura while
La estructura `while` permite repetir un bloque de instrucciones mientras una condición sea verdadera.

Su sintaxis es:
```java
while (condicion) {
    // Instrucciones
}
```

La condición se evalúa **antes** de ejecutar el bloque. Por esta razón, es posible que el bloque no se ejecute ninguna vez si la condición es falsa desde el comienzo.

Ejemplo
```java
int contador = 1;

while (contador <= 5) {
    System.out.println("Número: " + contador);
    contador++;
}
```
En este ejemplo, el programa comienza con `contador` igual a 1. Mientras el valor sea menor o igual a 5, se muestra el número y posteriormente se incrementa el contador.\
Cuando `contador` alcanza el valor 6, la condición deja de cumplirse y el ciclo termina.

#### Estructura do-while
La estructura `do-while` también permite repetir instrucciones mientras una condición sea verdadera. La diferencia principal respecto a `while` es que en `do-while` el bloque de instrucciones se ejecuta al menos una vez, ya que la condición se evalúa al final.

Su sintaxis es:
```java
do {
    // Instrucciones
} while (condicion);
```
Ejemplo
```java
int contador = 1;

do {
    System.out.println("Número: " + contador);
    contador++;
} while (contador <= 5);
```
En este caso, el bloque se ejecuta primero y después se comprueba la condición. El proceso continúa mientras `contador` sea menor o igual a 5.

Una característica importante es que, aunque la condición fuera falsa desde el inicio, el bloque se ejecutaría una vez.

Por ejemplo:
```java
int numero = 10;

do {
    System.out.println("Este mensaje se muestra una vez.");
} while (numero < 5);
```
Aunque `numero < 5` es falso, el mensaje se muestra una vez porque la condición se comprueba después de ejecutar el bloque.

#### Sentencias break y continue
Las sentencias `break` y `continue` permiten modificar el comportamiento normal de los ciclos.

**Sentencia break**\
La sentencia `break` permite terminar inmediatamente un ciclo o una estructura `switch`.

Ejemplo
```java
for (int i = 1; i <= 10; i++) {
    if (i == 5) {
        break;
    }

    System.out.println(i);
}
```
En este ejemplo, el ciclo normalmente llegaría hasta 10. Sin embargo, cuando `i` alcanza el valor 5, se ejecuta `break` y el ciclo termina.

Por lo tanto, se muestran los números del 1 al 4.

**Sentencia continue**\
La sentencia `continue` permite omitir la iteración actual y continuar con la siguiente repetición del ciclo.

Ejemplo
```java
for (int i = 1; i <= 5; i++) {
    if (i == 3) {
        continue;
    }

    System.out.println(i);
}
```
Cuando `i` tiene el valor 3, se ejecuta `continue`. Esto hace que el programa omita esa iteración y continúe con el siguiente valor.

El resultado será:
```
1
2
4
5
```

Por lo tanto, mientras `break` termina completamente el ciclo, `continue` omite únicamente la iteración actual.

## Contadores y acumuladores
Los contadores y acumuladores son variables que permiten almacenar información durante la ejecución de un programa. Son especialmente útiles cuando se necesita contar elementos, calcular sumas o realizar operaciones sobre un conjunto de datos.

### Contadores
Un contador es una variable que permite llevar la cuenta de cuántas veces ocurre una determinada acción o proceso.\
Generalmente, un contador comienza con un valor inicial, normalmente `0`, y aumenta o disminuye mediante una cantidad fija, por ejemplo:
```
contador++
```
También puede utilizarse:
```
contador--
```
El operador `++` incrementa el valor de la variable en 1, mientras que `--` lo disminuye en 1.

Ejemplo\
Si se desea contar cuántos números son positivos, se puede utilizar una variable llamada `positivos`:
```java
int positivos = 0;

if (numero >= 0) {
    positivos++;
}
```
Cada vez que se encuentra un número positivo, el contador aumenta en uno.

### Acumuladores
Un acumulador es una variable que almacena progresivamente un resultado a medida que el programa procesa diferentes valores.

A diferencia de un contador, que normalmente aumenta o disminuye en una cantidad fija, un acumulador puede modificarse utilizando diferentes valores.

Por ejemplo:
```java
int suma = 0;

suma = suma + numero;
```
En este caso, cada número leído se agrega al contenido anterior de suma.

También puede escribirse de una manera más corta:
```java
suma += numero;
```
Los acumuladores son utilizados frecuentemente para calcular sumas, productos, promedios y otros resultados que dependen de varios valores.

**Ejemplo:**
```java
import java.util.Scanner;

public class Ejemplo78 {
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);

        int n = tec.nextInt();
        int numero;
        int positivos = 0;
        int negativos = 0;

        for (int i = 0; i < n; i++) {
            numero = tec.nextInt();

            if (numero >= 0) {
                positivos++;
            } else {
                negativos++;
            }
        }

        System.out.println(
            "Son " + positivos + " positivos y " + negativos + " negativos."
        );
    }
}
```

## Metodos definidos por el usuario
Java cuenta con miles de clases y métodos que permiten realizar diferentes tareas y reutilizar código. Los métodos ayudan a **dividir un problema en partes más pequeñas**, organizar los algoritmos y hacer que los programas sean más fáciles de desarrollar, revisar, depurar y ampliar.

Además de utilizar los métodos que proporciona Java, el programador puede **crear sus propios métodos** e incluso agruparlos en clases y bibliotecas para utilizarlos posteriormente.

Un programa puede contener muchos métodos. Sin embargo, normalmente existe un único método principal llamado `main`, que se encarga de iniciar la ejecución del programa y puede llamar a otros métodos. Estos, a su vez, pueden llamar a otros métodos.

### Estructura de un método

La estructura general de un método es:

```
public [static] tipoDevuelto nombreMetodo([listaParametros]) {
    // instrucciones
    [return valor];
}
```

Los elementos entre corchetes son opcionales.

- **`public`**: permite que el método pueda ser utilizado desde otras clases.
- **`static`**: indica que el método pertenece a la clase y puede utilizarse sin crear un objeto.
- **`tipoDevuelto`**: indica el tipo de dato que devuelve el método. Si no devuelve ningún valor, se utiliza `void`.
- **`nombreMetodo`**: identifica al método.
- **`listaParametros`**: contiene los datos que recibe el método, indicando el tipo de cada uno.
- **`return`**: devuelve un valor cuando el método tiene un tipo de retorno diferente de `void`.

Un método puede recibir **cero o más parámetros** y puede devolver **cero o un solo valor**.

### Ejemplo: método `saludo()`

El siguiente ejemplo muestra un método que imprime varios mensajes. El método `main` lo llama y posteriormente imprime `"Fin"`.

```
public class Ejemplo {

    public static void saludo() {
        System.out.println("Hola Mundo");
        System.out.println("¡¡estudio informática!!");
    }

    public static void main(String[] args) {
        saludo();
        System.out.println("Fin");
    }
}
```

**Salida:**

```
Hola Mundo
¡¡estudio informática!!
Fin
```

### Ejemplo: método `ordenar3()`

El método `ordenar3()` recibe tres números enteros y los imprime de menor a mayor. El método `main` se encarga de leer los valores y enviarlos al método.

```
public static void ordenar3(int a, int b, int c) {
    if (a <= b && b <= c)
        System.out.println(a + " " + b + " " + c);
    else if (a <= c && c <= b)
        System.out.println(a + " " + c + " " + b);
    else if (b <= a && a <= c)
        System.out.println(b + " " + a + " " + c);
    else if (b <= c && c <= a)
        System.out.println(b + " " + c + " " + a);
    else if (c <= a && a <= b)
        System.out.println(c + " " + a + " " + b);
    else
        System.out.println(c + " " + b + " " + a);
}
```

Por ejemplo, para la entrada:

```
85 2 29
```

La salida será:

```
2 29 85
```

### Ejemplo: método `fibo()`

El método `fibo()` recibe un número natural `n` e imprime los primeros `n` términos de la serie de Fibonacci.

```
public static void fibo(int n) {
    int a = 1, b = 1, c;

    if (n == 1) {
        System.out.println(1);
    } else if (n >= 2) {
        System.out.print("1 1 ");

        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
            System.out.print(c + " ");
        }
    }
}
```

Para una entrada de `8`, el resultado es:

```
1 1 2 3 5 8 13 21
```

### Ejemplo: método `factorial()`

A diferencia de los métodos anteriores, `factorial()` **devuelve un valor**. Recibe un número natural y calcula su factorial.

```
public static int factorial(int n) {
    int fact = 1;

    for (int i = 1; i <= n; i++) {
        fact = fact * i;
    }

    return fact;
}
```

El método `main` puede utilizar el valor devuelto de la siguiente manera:

```
public static void main(String[] args) {
    Scanner tec = new Scanner(System.in);
    int n = tec.nextInt();

    System.out.println(factorial(n));
}
```

Para la entrada:

```
5
```

La salida será:

```
120
```

### Ejemplo: método `esFactorial()`
El método `esFactorial()` recibe un número natural y devuelve un valor booleano: `true` si el número corresponde al factorial de algún número y `false` en caso contrario.

```
public static boolean esFactorial(int n) {
    boolean factorial = true;

    if (n == 1) {
        return true;
    }

    if (n >= 2) {
        int divisor = 2;

        while (factorial && n > 1) {
            if (n % divisor != 0) {
                factorial = false;
            }

            n = n / divisor;
            divisor++;
        }
    }

    return factorial;
}
```

El método `main` utiliza el resultado para mostrar un mensaje:

```
if (esFactorial(n))
    System.out.println(n + ", es un factorial");
else
    System.out.println(n + ", no es un factorial");
```

Para la entrada:

```
120
```

La salida será:

```
120, es un factorial
```
## Bibliotecas predefinidas

Java incluye una gran cantidad de **bibliotecas predefinidas** que contienen clases y métodos ya implementados y probados. Estas herramientas permiten realizar diferentes tareas sin tener que programar todo desde cero.

Entre las clases más utilizadas se encuentran `Scanner`, `Math` y `String`.

### Clase `Math`

La clase `Math` contiene constantes y métodos estáticos relacionados con operaciones matemáticas. Los métodos estáticos se utilizan escribiendo primero el nombre de la clase, seguido de un punto y el nombre del método.

Por ejemplo:

```
Math.sqrt(25);
```

Esto calcula la raíz cuadrada de `25`.

### Constantes de `Math`

Las constantes más utilizadas son:

| Constante | Descripción |
| --- | --- |
| `Math.PI` | Representa el valor de π. |
| `Math.E` | Representa el número de Euler o número neperiano. |

### Métodos matemáticos más utilizados

| Método | Descripción |
| --- | --- |
| `Math.abs(x)` | Obtiene el valor absoluto de `x`. |
| `Math.sin(x)` | Calcula el seno de `x`. |
| `Math.cos(x)` | Calcula el coseno de `x`. |
| `Math.tan(x)` | Calcula la tangente de `x`. |
| `Math.asin(x)` | Calcula el arco seno. |
| `Math.acos(x)` | Calcula el arco coseno. |
| `Math.atan(x)` | Calcula el arco tangente. |
| `Math.atan2(y, x)` | Calcula el arco tangente teniendo en cuenta el cuadrante. |
| `Math.exp(x)` | Calcula `e` elevado a `x`. |
| `Math.log(x)` | Calcula el logaritmo natural. |
| `Math.log10(x)` | Calcula el logaritmo en base 10. |
| `Math.sqrt(x)` | Calcula la raíz cuadrada. |
| `Math.ceil(x)` | Redondea hacia arriba. |
| `Math.floor(x)` | Redondea hacia abajo. |
| `Math.rint(x)` | Devuelve el entero más cercano como número real. |
| `Math.pow(a, b)` | Calcula `a` elevado a `b`. |
| `Math.round(x)` | Redondea al entero más cercano. |
| `Math.random()` | Genera un número aleatorio entre `0.0` y `1.0`. |
| `Math.max(a, b)` | Devuelve el mayor entre `a` y `b`. |
| `Math.min(a, b)` | Devuelve el menor entre `a` y `b`. |
| `Math.toDegrees(x)` | Convierte radianes a grados. |
| `Math.toRadians(x)` | Convierte grados a radianes. |

### Ejemplo: `Math.max()` y `Math.min()`

Los métodos `max()` y `min()` permiten obtener, respectivamente, el valor mayor y menor entre dos números.

```
public class Ejemplo {
    public static void main(String[] args) {
        System.out.println("El menor de 53 y 46 es: " + Math.min(53, 46));
        System.out.println("El mayor de 53 y 46 es: " + Math.max(53, 46));
    }
}
```

**Salida:**

```
El menor de 53 y 46 es: 46
El mayor de 53 y 46 es: 53
```

### Ejemplo: potencias y logaritmos

La clase `Math` también permite trabajar con potencias, raíces y logaritmos.

```
public class Ejemplo {
    public static void main(String[] args) {
        double x = 25;
        double y = 4;

        System.out.println("Potencia: " + Math.pow(x, y));
        System.out.println("Raíz cuadrada: " + Math.sqrt(x));
        System.out.println("Exponencial: " + Math.exp(y));
        System.out.println("Logaritmo natural: " + Math.log(x));
        System.out.println("Logaritmo decimal: " + Math.log10(x));
    }
}
```

Por ejemplo, `Math.pow(25, 4)` calcula `25⁴`, mientras que `Math.sqrt(25)` devuelve `5`.

### Métodos de redondeo

Java proporciona diferentes métodos para redondear números:

- `Math.round(x)`: redondea al entero más cercano.
- `Math.ceil(x)`: redondea hacia arriba.
- `Math.floor(x)`: redondea hacia abajo.

Ejemplo:

```
System.out.println(Math.round(2.6)); // 3
System.out.println(Math.ceil(2.4));  // 3.0
System.out.println(Math.floor(2.6)); // 2.0
```

### Funciones trigonométricas

Los métodos trigonométricos de `Math`, como `sin()`, `cos()` y `tan()`, trabajan con **radianes**. Por eso, cuando se tiene un ángulo en grados, primero debe convertirse.

```
public class Ejemplo {
    public static void main(String[] args) {
        double grados = 30.0;
        double radianes = Math.toRadians(grados);

        System.out.println("sin(30) = " + Math.sin(radianes));
        System.out.println("cos(30) = " + Math.cos(radianes));
        System.out.println("tan(30) = " + Math.tan(radianes));
    }
}
```

Para convertir entre grados y radianes se utilizan:

```
Math.toRadians(grados);
Math.toDegrees(radianes);
```

### Generación de números aleatorios

El método:

```
Math.random();
```

genera un número decimal aleatorio que cumple:

```
0.0 <= número < 1.0
```

Para generar un número dentro de un intervalo `[a, b)`, se puede utilizar:

```
double numero = Math.random() * (b - a) + a;
```

Por ejemplo:

```
double numero = Math.random() * (10 - 5) + 5;
```

Esto genera un número aleatorio entre `5` y `10`, sin incluir el `10`.

### Ejemplo: lanzar cinco dados

`Math.random()` también puede utilizarse para simular el lanzamiento de dados:

```
public class Ejemplo {
    public static void main(String[] args) {
        int a = 1, b = 6;

        for (int i = 0; i < 5; i++) {
            int dado = (int) (Math.random() * (b + 1 - a)) + a;
            System.out.print(dado + " ");
        }
    }
}
```

El programa genera cinco valores aleatorios entre `1` y `6`, simulando cinco dados.

### Clase `String`

La clase `String` contiene diferentes métodos para trabajar con **cadenas de texto**. Las cadenas son fundamentales para el manejo de información textual en Java.

Algunos ejemplos de operaciones que pueden realizarse con `String` son obtener la longitud de un texto, comparar cadenas, buscar caracteres y modificar o extraer partes de una cadena.

El estudio detallado de esta clase se puede realizar posteriormente, ya que posee una gran cantidad de métodos y funcionalidades.


Claro. Lo dejo con el mismo estilo de las secciones anteriores: **resumido, en tercera persona, entendible y listo para copiar en un `README.md`**.

 Ámbito de las variables y ejecución de programas Java

## Ámbito de las variables

El **ámbito de una variable** es la parte del programa en la que dicha variable puede ser utilizada o es "visible".

En Java existen principalmente tres tipos de ámbito:

- **Variable global o de clase:** se declara fuera de cualquier método. Es un atributo de la clase y puede ser utilizada dentro de los métodos de esa clase.
- **Variable local o de método:** se declara dentro de un método, pero fuera de otros bloques internos. Puede utilizarse durante todo el método.
- **Variable de bloque:** se declara dentro de un bloque de código, como un `if`, `for`, `while` o cualquier conjunto de instrucciones encerrado entre `{}`. Solo puede utilizarse dentro de ese bloque.

### Ejemplo de los diferentes ámbitos

```
public class UnaClase {

    private int numero1; // Variable de clase

    public void calcular() {
        int a = 1; // Variable local del método

        if (a > 0) {
            int b = 2; // Variable de bloque

            System.out.println(a + ", " + b);

            for (int c = 0; c < 3; c++) {
                System.out.println(a + ", " + b + ", " + c);
            }

            // c ya no existe aquí
        }

        // b ya no existe aquí
        System.out.println(a);

        // a deja de existir al finalizar el método
    }

    // numero1 deja de existir al finalizar la clase
}
```

Una variable solo puede utilizarse dentro de su ámbito. Cuando el programa sale del bloque donde fue declarada, esa variable deja de estar disponible.

### Variables con el mismo nombre

Puede ocurrir que una variable de ámbito general y otra de ámbito interno tengan el mismo nombre. En ese caso, la variable del ámbito más interno **oculta temporalmente** a la variable externa.

Cuando termina el ámbito de la variable interna, la variable externa vuelve a estar disponible y conserva su valor original.

Por ejemplo:

```
public class Ejemplo {

    static int a = 3; // Variable de clase

    public static void main(String[] args) {

        for (int a = 0; a < 5; a++) {
            System.out.print(a + " ");
        }

        System.out.println();

        System.out.println(a);
    }
}
```

**Salida:**

```
0 1 2 3 4
3
```

Dentro del `for`, la variable `a` local oculta temporalmente a la variable `a` de la clase. Al terminar el ciclo, vuelve a utilizarse la variable de clase, cuyo valor sigue siendo `3`.

---

## Creación y ejecución de un programa Java desde consola

Para crear y ejecutar un programa Java desde la consola, primero es necesario tener **Java instalado y configurado** correctamente.

El proceso básico es el siguiente:

### 1\. Crear el archivo Java

Se crea un archivo con extensión `.java`, por ejemplo:

```
Ejemplo.java
```

Dentro del archivo se puede escribir un programa como el siguiente:

```
import java.util.Scanner;

public class Ejemplo {

    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);

        System.out.println("PROGRAMA QUE SUMA DOS NUMEROS");

        System.out.print("Escriba el primer número: ");
        int a = tec.nextInt();

        System.out.print("Escriba el segundo número: ");
        int b = tec.nextInt();

        System.out.println("La suma de " + a + " y " + b + " es: " + (a + b));
    }
}
```

### 2\. Abrir la consola

Se debe abrir una terminal o consola y acceder a la carpeta donde se encuentra el archivo.

Algunos comandos básicos son:

| Comando | Función |
| --- | --- |
| `D:` | Cambia a la unidad `D:`. |
| `cd nombreCarpeta` | Entra en una carpeta. |
| `cd ..` | Regresa a la carpeta anterior. |
| `dir` | Muestra el contenido de la carpeta actual. |

### 3\. Compilar el programa

Una vez ubicada la consola en la carpeta que contiene `Ejemplo.java`, se utiliza:

```
javac Ejemplo.java
```

El comando `javac` **compila el código fuente** y genera el archivo `.class` correspondiente.

### 4\. Ejecutar el programa

Después de compilarlo, se ejecuta mediante:

```
java Ejemplo
```

No es necesario escribir la extensión `.java` al utilizar el comando `java`.

El proceso básico puede resumirse así:

```
Ejemplo.java
     ↓
javac Ejemplo.java
     ↓
Ejemplo.class
     ↓
java Ejemplo
     ↓
Programa ejecutándose
```

---

## Anexo: Código ASCII

El **código ASCII** (_American Standard Code for Information Interchange_) es un sistema utilizado para representar caracteres mediante valores numéricos. Permite representar letras, números, símbolos y algunos caracteres especiales.

El código ASCII original fue definido en **1963** y utiliza **7 bits**, permitiendo representar **128 caracteres**, numerados del `0` al `127`.

Los primeros 32 valores corresponden principalmente a caracteres de control y no son imprimibles.

Posteriormente apareció el denominado **ASCII extendido**, que utiliza 8 bits y permite representar hasta **256 valores diferentes**, incorporando caracteres adicionales.

### Resumen

| Característica | ASCII |
| --- | --- |
| Año de definición | 1963 |
| Bits originales | 7 bits |
| Cantidad de caracteres | 128 |
| Rango | 0 - 127 |
| ASCII extendido | 8 bits |
| Valores del extendido | Hasta 256 |

El código ASCII permite que las computadoras puedan **representar y procesar caracteres mediante valores numéricos**, siendo uno de los sistemas fundamentales utilizados históricamente para la representación de texto.## Codigo Unicode

```java
```
