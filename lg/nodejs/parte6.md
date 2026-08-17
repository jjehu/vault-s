# MySQL

## Bases de Datos
Hasta ahora, toda la información que creamos con POST o PUT desaparece si apagamos el servidor, porque la teníamos en variables en la memoria de Node.js. Para guardar la información de forma permanente, usamos Bases de Datos.

MySQL es un sistema de gestión de bases de datos relacionales. Esto significa que la información se guarda en tablas (similares a las hojas de cálculo de Excel).

Conceptos clave:

1. Base de datos (Database): Es el contenedor principal. Dentro de una base de datos puedes tener varias tablas (por ejemplo, una tabla para `usuarios`, otra para `productos`, otra para `ventas`).
2. Tabla: Es la estructura donde se guardan los datos. Está compuesta por columnas (los atributos, como `nombre`, `edad`, `email`) y filas (los registros individuales, como "Juan", "25", "juan@mail.com").
3. SQL (Structured Query Language): Es el lenguaje que usamos para comunicarnos con MySQL. Con SQL le "damos órdenes" a la base de datos en inglés para que guarde, busque, modifique o elimine información.

Ejemplo de cómo se vería una tabla usuarios:

| id | nombre | email |
|----|--------|-------|
| 1  | Carlos | carlos@mail.com |
| 2  | Ana    | ana@mail.com |

## Tablas
Como vimos, los datos se guardan en tablas. Pero antes de guardar información, debemos crear la tabla y definir su estructura (qué columnas tendrá y qué tipo de datos aceptará cada una).

Para crear tablas en MySQL usamos el comando `SQL CREATE TABLE`.

Tipos de datos más comunes:

- `INT`: Para números enteros (ej. 1, 50, 1000).
- `VARCHAR(100)`: Para texto. El número entre paréntesis es la cantidad máxima de caracteres.
- `DECIMAL(10,2)`: Para números con decimales (como precios, ej. 19.99).
- `BOOLEAN`: Para verdadero/falso (0 o 1).
Propiedades especiales:

- `PRIMARY KEY`: Define que una columna es el identificador único de cada fila. No se pueden repetir valores.
- `AUTO_INCREMENT`: Hace que MySQL genere automáticamente el ID (1, 2, 3, 4...) cada vez que agregamos un registro.

Ejemplo de código SQL:
```sql
CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    edad INT,
    email VARCHAR(150) UNIQUE
);
```
Explicación: Creamos una tabla `usuarios`. El `id` será un número entero que se incrementa solo y es la llave principal. El `nombre` es texto de máximo 100 caracteres y no puede quedar vacío (`NOT NULL`). La edad es un entero y el email es texto que no se puede repetir (`UNIQUE`).

## INSERT
Ahora que ya tenemos nuestra tabla `productos` creada (pero vacía), necesitamos agregarle información. Para insertar nuevos registros (filas) en una tabla, usamos la instrucción SQL `INSERT INTO`.

La sintaxis es la siguiente:
```sql
INSERT INTO nombre_tabla (columna1, columna2, columna3) 
VALUES (valor1, valor2, valor3);
```
Ejemplo práctico:
Si queremos agregar un usuario a nuestra tabla de usuarios:
```sql
INSERT INTO usuarios (nombre, edad, email) 
VALUES ('Carlos', 25, 'carlos@mail.com');
```
Notas importantes:

- Los valores de texto (como nombres o emails) deben ir entre comillas simples `' '`.
- Los valores numéricos (como la edad) van sin comillas.
- No necesitamos incluir la columna `id` en nuestro `INSERT` porque la configuramos como `AUTO_INCREMENT` en la lección anterior. MySQL le asignará el ID automáticamente.

## SELECT
Ahora que tenemos datos guardados en nuestra tabla, necesitamos una forma de leerlos o buscarlos. Para recuperar información de una base de datos usamos la instrucción SQL `SELECT`.

1. Seleccionar todas las columnas:\
Si quieres obtener toda la información de una tabla, usamos el asterisco `*` (que significa "todo").
```sql
SELECT * FROM productos;
```
Esto devolverá todas las filas y todas las columnas (id, nombre, precio, stock) de la tabla productos.

2. Seleccionar columnas específicas:
Si la tabla tiene muchas columnas y solo necesitas ver algunas (para ahorrar memoria y ser más rápido), puedes listar los nombres de las columnas separados por comas.
```sql
SELECT nombre, precio FROM productos;
```
Esto devolverá solo el nombre y el precio de todos los productos.

3. Filtrar resultados (WHERE):
Si no quieres ver todos los productos, sino solo los que cumplen una condición, usas la cláusula `WHERE`.
```sql
SELECT * FROM productos WHERE precio > 100;
```
Esto devolverá solo los productos que cuesten más de 100.

## UPDATE
Para modificar o actualizar datos que ya existen en una tabla, usamos la instrucción SQL `UPDATE`.

La sintaxis es la siguiente:
```sql
UPDATE nombre_tabla 
SET columna1 = valor1, columna2 = valor2 
WHERE condicion;
```

> [!CAUTION]
> ¡ADVERTENCIA MUY IMPORTANTE!\
> NUNCA olvides poner la cláusula `WHERE`. Si ejecutas un `UPDATE` sin `WHERE`, actualizará TODOS los registros de la tabla de una sola vez (por ejemplo, todos los productos pasarían a tener el mismo precio). El `WHERE` le dice a MySQL exactamente a qué fila(s) debe aplicarse el cambio, normalmente usando el `id`.

Ejemplo práctico:
Si el usuario con `id` 1 cambió de edad:
```sql
UPDATE usuarios 
SET edad = 26 
WHERE id = 1;
```
Si un producto cambió de precio y de stock al mismo tiempo:
```sql
UPDATE productos 
SET precio = 199.99, stock = 50 
WHERE id = 3;
```

## DELETE
Para eliminar por completo un registro (una fila) de una tabla, usamos la instrucción SQL `DELETE`.

La sintaxis es muy sencilla:
```sql
DELETE FROM nombre_tabla 
WHERE condicion;
```
> [!CAUTION]
> ¡MISMA ADVERTENCIA QUE CON UPDATE!\
> NUNCA olvides la cláusula `WHERE`. Si ejecutas `DELETE FROM productos;` sin el `WHERE`, borrarás TODOS los productos de la tabla y la dejarás completamente vacía. Siempre debes especificar qué fila eliminar, usualmente mediante su `id`.

Ejemplo práctico:
Si el usuario con `id` 4 canceló su cuenta y quieres borrarlo de la base de datos:
```sql
DELETE FROM usuarios 
WHERE id = 4;
```
