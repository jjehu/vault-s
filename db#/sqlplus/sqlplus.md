##Guia sqlplus

### Leccion 1

**Crear tipo de objeto**
``` sql
CREATE TYPE Persona AS OBJECT (
id NUMBER,
nombre VARCHAR2(50),
edad NUMBER
);
```
**Crear tabla basada en objeto**
``` sql
CREATE TABLE Personas OF Persona;
```
### Leccion2

**Definir un método en un tipo de objeto**
``` sql
CREATE TYPE Persona AS OBJECT (
id NUMBER,
nombre VARCHAR2(50),
edad NUMBER,
MEMBER FUNCTION esMayorEdad RETURN VARCHAR2
);
```
**Implementar el método**
``` sql
CREATE TYPE BODY Persona AS
MEMBER FUNCTION esMayorEdad RETURN VARCHAR2 IS
BEGIN
IF edad >= 18 THEN
RETURN 'Sí';
ELSE
RETURN 'No';
END IF;
END;
END;
```
**Uso de métodos**
``` sql
SELECT p.esMayorEdad()
FROM Personas p
WHERE p.nombre = 'Juan';
```
### Leccion3

**Crear una tabla con una referencia**
``` sql
CREATE TYPE Empleado AS OBJECT (
emp_id NUMBER,
posicion VARCHAR2(50),
supervisor REF Persona
);
```
**Crear la tabla para almacenar objetos**
``` sql
CREATE TABLE Empleados OF Empleado;
```
**Insertar datos con referencias**
``` sql
DECLARE
ref_persona REF Persona;
BEGIN
SELECT REF(p) INTO ref_persona FROM Personas p WHERE [p.id](http://p.id/) = 1;
INSERT INTO Empleados VALUES (100, 'Desarrollador', ref_persona);
END;
```
### Leccion4

**Crear un subtipo basado en un tipo existente**
``` sql
CREATE TYPE Empleado UNDER Persona (
emp_id NUMBER,
posicion VARCHAR2(50)
);
```
**Crear una tabla para el subtipo**
``` sql
CREATE TABLE Empleados OF Empleado;
```
**Insertar datos en la tabla del subtipo**
``` sql
INSERT INTO Empleados VALUES (Persona(1, 'Carlos', 28), 200, 'Gerente');
```
### Lección 5: Uso de REF y DEREF en Consultas

En Oracle, puedes usar las funciones REF y DEREF para trabajar con referencias a objetos y obtener los valores de los atributos apuntados por esas referencias.

**Uso de REF**

La función REF se utiliza para obtener una referencia a una fila de una tabla basada en un tipo de objeto, como vimos en la lección anterior. Por ejemplo:

``` sql
SELECT REF(p)
FROM Personas p
WHERE p.nombre = 'Juan';
```

Esto devuelve una referencia al objeto Persona donde el nombre es "Juan".

**Uso de DEREF**

La función DEREF se utiliza para desreferenciar una variable de tipo REF y obtener los valores del objeto al que apunta.

Ejemplo para obtener los atributos de un objeto a partir de una referencia almacenada:

``` sql
SELECT DEREF(e.supervisor).nombre, DEREF(e.supervisor).edad
FROM Empleados e;
```

En este caso:

DEREF(e.supervisor) devuelve el objeto completo al que apunta la referencia supervisor.

.nombre y .edad acceden a los atributos del objeto desreferenciado.

**Consultas con REF y DEREF**

Puedes combinar REF y DEREF para realizar consultas complejas que involucren referencias entre tablas:

``` sql
SELECT e.emp_id, e.posicion, DEREF(e.supervisor).nombre AS NombreSupervisor
FROM Empleados e
WHERE DEREF(e.supervisor).edad > 30;
```
Esta consulta muestra el emp_id, posicion del empleado y el nombre del supervisor solo si el supervisor tiene más de 30 años.

Las funciones REF y DEREF son útiles para trabajar con relaciones complejas y modelar datos orientados a objetos en la base de datos.

Con esto, hemos cubierto los temas básicos. ¿Te gustaría profundizar en algún tema o tienes otra solicitud?
