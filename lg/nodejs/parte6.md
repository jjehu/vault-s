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
## INSERT
## SELECT
## UPDATE
## DELETE
