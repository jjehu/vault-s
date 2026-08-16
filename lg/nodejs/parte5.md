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
## POST
## PUT
## DELETE
## JSON
