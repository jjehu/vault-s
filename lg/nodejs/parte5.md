# Express
Express.js es el framework (conjunto de herramientas) más popular de Node.js. Nos facilita enormemente la creación de servidores web y la gestión de las rutas (las URLs de nuestra aplicación) en comparación con usar solo Node.js puro.

## Servidor
Para crear un servidor básico con Express, siempre seguimos estos 4 pasos:

1. Importar Express: Usamos `require` para traer la librería que instalamos con `npm install express`.
```
npm install express
```
2. Crear la instancia: Guardamos la aplicación en una variable, normalmente llamada `app`.
3. Definir el puerto: El puerto por donde nuestro servidor escuchará las peticiones (normalmente el 3000 para desarrollo).
4. Encender el servidor: Usamos el método `app.listen()`.

Ejemplo de un servidor básico:
```js
// 1. Importar
const express = require('express');

// 2. Crear instancia
const app = express();

// 3. Definir puerto
const PORT = 3000;

// 4. Encender el servidor
app.listen(PORT, () => {
    console.log(`Servidor corriendo en el puerto ${PORT}`);
});
```

Al ejecutar `node index.js` con este código, se vera el mensaje en la terminal y el servidor estará activo esperando peticiones (aunque de momento no sabe qué responder al hacer una petición).

## Rutas GET

Un servidor web no sirve de mucho si no responde cuando alguien visita una página. Las rutas definen qué debe hacer el servidor cuando recibe una petición en una URL específica.\
El método más común es GET, que se utiliza para obtener o leer información (como cuando se entra a `www.google.com` y se recibe la página de inicio).

En Express, definimos una ruta GET usando `app.get()`. Este método recibe dos parámetros:

1. La ruta (URL) a escuchar, por ejemplo: `'/'` (la ruta principal o inicio) o `'/contacto'`.\
2. Una función callback que se ejecuta cuando alguien visita esa ruta. Esta función recibe dos parámetros importantes:
  - `req` (request): Contiene la información de la petición del usuario.
  - `res` (response): Contiene las herramientas para enviar una respuesta al usuario.

```js
const express = require('express');
const app = express();

// Cuando alguien visite la ruta principal '/'
app.get('/', (req, res) => {
    res.send('¡Hola! Bienvenido a la página principal.');
});

// Cuando alguien visite la ruta '/about'
app.get('/about', (req, res) => {
    res.send('Esta es la página de acerca de nosotros.');
});
```
Nota: `res.send()` es el método que usamos para enviarle una respuesta de vuelta al navegador del usuario. Si no envías una respuesta, la página se quedará cargando infinitamente.

## Parámetros

A veces no queremos crear una ruta para cada elemento individual (como `/producto/1`, `/producto/2`, `/producto/3`). Sería ineficiente. En su lugar, usamos Parámetros de Ruta (Route Parameters).

Los parámetros nos permiten crear rutas dinámicas. Se definen en la URL poniendo dos puntos (`:`) antes del nombre del parámetro.

Ejemplo:
```js
app.get('/usuario/:id', (req, res) => {
    // Extraemos el parámetro 'id' de la URL usando req.params
    const idUsuario = req.params.id;
    res.send(`Estás viendo el perfil del usuario ${idUsuario}`);
});
```

Si un cliente visita en su navegador la URL `tu-servidor.com/usuario/5`, Express captura ese `5` y lo guarda en `req.params.id`. La respuesta en pantalla será: "Estás viendo el perfil del usuario 5".

Diferencia clave:

- `/usuario` es una ruta fija.
- `/usuario/:id` es una ruta dinámica que espera un valor en ese lugar.

## POST
Hasta ahora, con las rutas GET, hemos podido leer información del servidor. Pero, ¿qué pasa si queremos enviar información al servidor? Por ejemplo, cuando llenas un formulario de registro en una página web. Para eso existe el método POST.

En Express, definimos una ruta POST usando `app.post()`. La estructura es igual a la de GET, pero cambia el método.

**El gran detalle de POST: `req.body`**\
La información que el usuario envía mediante POST no viene en la URL (como los parámetros), sino que viene "oculta" en el cuerpo (body) de la petición. Para leer esta información en Express, usamos `req.body`.

Sin embargo, Express por defecto no sabe cómo interpretar esa información si viene en formato JSON. Por eso, antes de definir nuestras rutas, debemos activar un "middleware" (una función intermedia) que le enseñe a Express a leer JSON.

Código de ejemplo:
```js
const express = require('express');
const app = express();

// ESTO ES OBLIGATORIO para poder usar req.body
app.use(express.json()); 

app.post('/usuarios', (req, res) => {
    // Extraemos la información del cuerpo de la petición
    const nuevoUsuario = req.body;
    
    // Respondemos confirmando que se recibió
    res.send(`Usuario ${nuevoUsuario.nombre} creado correctamente.`);
});
```

Si un cliente envía una petición POST a `/usuarios` con el cuerpo `{ "nombre": "Lucas" }`, el servidor leerá `req.body.nombre`, lo cual será "Lucas", y responderá el mensaje.

## PUT
El método PUT se utiliza para actualizar datos que ya existen en el servidor.

Funciona de manera muy similar a POST: la información de los cambios se envía en el cuerpo de la petición (`req.body`). Sin embargo, por convención, al usar PUT también solemos recibir un parámetro en la URL (`req.params`) para saber qué elemento exacto queremos actualizar.

Ejemplo de código:
```js
// Actualizaremos el usuario con ID 5: /usuarios/5
app.put('/usuarios/:id', (req, res) => {
    const { id } = req.params; // Sabemos a quién actualizar
    const { nombre } = req.body; // Sabemos qué nuevo nombre ponerle
    
    res.send(`Usuario ${id} actualizado. Nuevo nombre: ${nombre}`);
});
```
Es decir, PUT suele ser la combinación de Parámetros (`.params`) y Body (`.body`).

## DELETE
El método DELETE se utiliza para eliminar un recurso del servidor.

Es la ruta más sencilla de todas, ya que normalmente solo necesitamos saber qué elemento eliminar. Por lo tanto, solemos usar parámetros de ruta (`req.params`), igual que hacíamos con GET para buscar un elemento individual. No necesitamos `req.body` porque no estamos enviando datos para crear o actualizar, solo el identificador de lo que queremos borrar.

Ejemplo de código:
```js
app.delete('/tareas/:id', (req, res) => {
    const { id } = req.params;
    res.send(`Tarea con ID ${id} eliminada correctamente.`);
});
```
## JSON
Hasta ahora, en todas nuestras respuestas hemos usado `res.send("Texto...")`. Sin embargo, en el mundo real, los servidores no suelen responder con texto plano. Responden con datos estructurados que las aplicaciones (como una app móvil o un frontend web) puedan entender fácilmente. El formato estándar para esto es JSON (JavaScript Object Notation).

JSON es básicamente la sintaxis de los objetos de JavaScript, pero en formato texto.

En Express, para enviar una respuesta en formato JSON, en lugar de usar `res.send()`, usamos `res.json()`. Este método convierte automáticamente un objeto o arreglo de JavaScript en una respuesta JSON válida, y le avisa al navegador que lo que está recibiendo es JSON (mediante las cabeceras HTTP).

Ejemplo de código:
```js
app.get('/api/usuario', (req, res) => {
    // Creamos un objeto de JavaScript normal
    const usuario = {
        id: 1,
        nombre: "Ana",
        edad: 30,
        activo: true
    };
    
    // Lo enviamos como JSON
    res.json(usuario);
});
```
Si visitas esa ruta en el navegador, verás el objeto JSON estructurado en pantalla.
