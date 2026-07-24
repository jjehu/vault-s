# package.json
Al ejecutar `npm init` se crea un archivo llamado `package.json`. Este archivo es el corazón de cualquier proyecto de Node.js.

El `package.json` es un archivo de texto en formato JSON que actúa como el "documento de identidad" del proyecto. Guarda toda la configuración y metadatos del mismo.

**Partes más importantes del `package.json`:**

1. Metadatos básicos: Como el `name` (nombre del proyecto) y `version`.
2. `scripts`: Son atajos para ejecutar comandos en la terminal. Por ejemplo, en lugar de escribir `node index.js`, se puede crear un script llamado "start" que ejecute ese comando. Luego solo se escribe en la terminal `npm run start` (o simplemente `npm start`).
3. `dependencies`: Aquí se guarda la lista de todos los paquetes (librerías) que el proyecto necesita para funcionar en producción (como `express` o `mysql2`).
4. `devDependencies`: Aquí se guardan los paquetes que solo se necesita durante el desarrollo (como herramientas de testing o nodemon). Se instalan usando `npm install --save-dev <paquete>`.

Lo mejor de todo: Si se borra la carpeta `node_modules` (que es muy pesada), se puede recuperar todas las librerías simplemente ejecutando `npm install` en la terminal. Node leerá el `package.json` y descargará todo lo que falte automáticamente.

ejemplo de `package.json`:
```
{
  "name": "api-rest-tienda",
  "version": "1.0.0",
  "scripts": {
    "start": "node app.js",
    "dev": "nodemon app.js"
  },
  "dependencies": {
    "express": "^4.18.2"
  }
}
```
