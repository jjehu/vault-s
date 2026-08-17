# Node + MySQL
Para que Node.js pueda comunicarse con MySQL y enviarle esas consultas SQL (INSERT, SELECT, etc.) que acabamos de aprender, necesitamos instalar un paquete (librería) que sirva de puente. El más usado es `mysql2`.
```
npm install mysql2
```
## Conexión
Pasos para conectar Node con MySQL:

1. Instalar el paquete: En tu terminal ejecutas `npm install mysql2`.
2. Importar y configurar la conexión: En tu código de Node, importas la librería y le proporcionas los datos de acceso a tu base de datos (host, usuario, contraseña y nombre de la base de datos).
```js
// 1. Importar el paquete (usamos la versión con promesas 'promise')
const mysql = require('mysql2/promise');

// 2. Crear la conexión
const conexion = mysql.createConnection({
    host: 'localhost',       // Donde está la BD (local)
    user: 'root',            // Tu usuario de MySQL
    password: '123456',      // Tu contraseña
    database: 'mi_tienda'    // El nombre de la base de datos
});

// 3. Probar que funciona (normalmente con async/await, pero aqui un ejemplo simple)
conexion.connect()
    .then(() => console.log("¡Conectado a MySQL!"))
    .catch(err => console.error("Error al conectar:", err));
```

Nota: Hoy en día se suele usar `mysql2/promise` porque permite usar `async/await` para hacer las consultas, lo que hace que el código sea más limpio y fácil de leer.

## Consultas
Ya tenemos la conexión lista. Ahora, ¿cómo le enviamos un `SELECT` o un `INSERT` a MySQL desde nuestro código en Node.js?

Como las consultas a la base de datos toman un tiempo en responder (son operaciones asíncronas), debemos usar `async/await`. Esto le dice a Node: "Espera a que la base de datos responda antes de continuar con la siguiente línea de código".

Usamos el método `conexion.execute(sql)` y le pasamos nuestra consulta SQL como un string.

Nota importante: La librería `mysql2/promise` devuelve los resultados dentro de un arreglo. El primer elemento del arreglo son los datos (las filas) y el segundo elemento son los metadatos de las columnas. Por eso, solemos usar desestructuración de arreglos (Lección 10) para quedarnos solo con los datos.

Ejemplo de código (Consultar usuarios):
```js
app.get('/usuarios', async (req, res) => {
    try {
        // Ejecutamos la consulta SQL y esperamos (await) la respuesta
        const [filas] = await conexion.execute('SELECT * FROM usuarios');
        
        // Enviamos los datos como JSON
        res.json(filas);
    } catch (error) {
        // Si hay un error en la consulta SQL, lo capturamos
        console.error(error);
        res.send("Error al obtener los usuarios");
    }
});
```

## CRUD
CRUD son las siglas de Create (Crear), Read (Leer), Update (Actualizar) y Delete (Eliminar). Es el conjunto básico de operaciones para gestionar datos en una aplicación.

Ya sabemos hacer el Read (Leer) con `SELECT`. Ahora nos faltan las otras tres operaciones desde Node.js.

El concepto más importante de esta lección: Consultas Parametrizadas (`?`)\
Cuando enviemos datos desde Node.js a MySQL (para INSERT, UPDATE o DELETE), NUNCA debemos poner las variables directamente dentro del string SQL usando Template Strings (ej: `INSERT INTO productos VALUES (${nombre})`).\
Si hiciéramos eso, seríamos vulnerables a un ataque llamado SQL Injection (donde un usuario malintencionado podría borrar nuestra base de datos).

En su lugar, usamos el símbolo de interrogación `?` donde irá el valor, y pasamos las variables en un arreglo aparte. La librería `mysql2` se encarga de limpiar los datos de forma segura.

Ejemplo de INSERT (Create):
```js
app.post('/productos', async (req, res) => {
    const { nombre, precio } = req.body;
    try {
        // Usamos ? en lugar de las variables directamente
        await conexion.execute(
            'INSERT INTO productos (nombre, precio) VALUES (?, ?)', 
            [nombre, precio] // Aquí pasamos las variables en orden
        );
        res.json({ mensaje: "Producto creado correctamente" });
    } catch (error) {
        res.send("Error al crear el producto");
    }
});
```
