# Java
Java es uno de los lenguajes de programación más utilizado a nivel mundial para la programación de computadoras y el desarrollo de aplicaciones y sistemas, porque presenta varias características ventajosas en relación a otros lenguajes de programación.

## Instalación
1. Primero debe obtenerse el instalador:
http://www.oracle.com/technetwork/java/javase/downloads/index.html
2. Una vez descargado y descomprimido, es necesario realizar su configuración:
  - Agregar a `Variables de Entorno del Sistema` la variable `JAVA_HOME` especificando la ruta de la carpeta dónde se descomprimió Java.
  - Agregar a la propiedad `Path` la ruta de la carpeta `\bin` (se encuentra dentro de la carpeta dónde se descomprimió Java).
  - Abrir una consola e invocar a los archivos `java.exe` y `javac.exe` los cuales deben dar respuestas de como utilizar esos comandos.
3. IDE
Un IDE es un entorno de desarrollo integrado, es un programa que facilita el desarrollo, ejecución y depuración de los programas.
IDE ECLIPSE: https://www.eclipse.org/downloads/

Una vez instalado:
- Agregar un proyecto Java a Ellipse
- Darle un nombre sin usar espacios
- Al proyecto se le debe añadir una clase

## Fundamentos
### Métodos
Un método es un bloque de código que realiza una tarea específica. Tiene un encabezado, nombre y parámetros. El método principal es main, que inicia la ejecución del programa. Los métodos pueden devolver valores o no (void).
### Identificadores
Son nombres únicos para clases, métodos, variables, etc. Deben comenzar con una letra y pueden contener letras, dígitos, guiones bajos o el símbolo $. Son sensibles a mayúsculas y minúsculas.
### Palabras Reservadas
Java tiene palabras reservadas que no pueden usarse como identificadores, como class, public, static, if, else, entre otras.
### Comentarios
Los comentarios documentan el código y pueden ser de línea (//) o de bloque (/* ... */). Son ignorados por el compilador y ayudan a entender el programa.
### Tipos de Datos Primitivos
Java tiene tipos de datos primitivos: enteros (byte, short, int, long), reales (float, double), caracteres (char) y booleanos (boolean). Cada uno tiene un rango y tamaño específico en memoria.
### Literales
Los literales son valores fijos en el código, como números, caracteres, booleanos y cadenas. Pueden escribirse en diferentes bases (decimal, hexadecimal, octal) y con notación científica para reales.
### Secuencias de Escape
Son caracteres especiales dentro de cadenas, como   (nueva línea), \t (tabulador), \ (barra invertida), \' (comilla simple) y " (comilla doble).
### Variables
Una variable es un nombre asociado a un espacio de memoria para almacenar un valor. Java es fuertemente tipado, por lo que cada variable debe declararse con un tipo. Es recomendable inicializarlas para evitar errores.
### Operador de Asignación
El operador = asigna un valor a una variable. La expresión a la derecha se evalúa y el resultado se almacena en la variable de la izquierda.
### Conversión de Tipos de Datos (Cast)
La conversión de tipos puede ser implícita (automática) o explícita (cast). Se usa para convertir valores entre tipos compatibles, cuidando los posibles errores por pérdida de información.
### Constantes
Una constante es un valor fijo que no cambia durante la ejecución. Se declara con la palabra final.
### Salida de Datos
La salida de datos se realiza principalmente en pantalla usando System.out.print(), System.out.println() y System.out.printf(). Permiten mostrar información y dar formato a la salida.
### Operadores Aritméticos
Permiten realizar operaciones matemáticas básicas: suma (+), resta (-), multiplicación (*), división (/) y módulo (%). Existen operadores abreviados y de incremento/decremento.
### Operadores de Relación
Comparan dos valores y devuelven un booleano: igual (==), diferente (!=), mayor (>), menor (<), mayor o igual (>=), menor o igual (<=).
### Operadores Lógicos
Relacionan valores booleanos: not (!), and (&&), or (||), xor. Se usan para construir expresiones lógicas complejas.
### Operadores de Bit
Operan a nivel binario sobre valores enteros: not (~), or (|), and (&), desplazamientos (<<, >>, >>>). Permiten manipular bits directamente.
### Operador de Concatenación
El operador + une cadenas de texto. Si uno de los operandos es una cadena, el otro se convierte automáticamente a cadena.
### Evaluación de Expresiones
Una expresión es una combinación de literales, variables y operadores que produce un resultado. En Java, las expresiones se escriben en formato lineal y se pueden usar paréntesis para definir el orden de evaluación.

### Jerarquia de operadores
### Entrada de datos
### Estructuras de control
### Contadores y acumuladores
### Metodos definidos por el usuario
### Bibliotecas predefinidas
### Ambito de variables
### Creacion y ejecucion de un programa Java desde consola
### Codigo Ascii
### Codigo Unicode
