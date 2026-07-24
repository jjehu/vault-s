# npm (Node Package Manager)

npm (Node Package Manager) es el gestor de paquetes por defecto de Node.js. Cuando se instala Node.js, npm se instala automáticamente junto con él.

**¿Para qué sirve npm?**
En el mundo de la programación, no necesitas reinventar la rueda. Si quieres agregar validaciones, crear un servidor web o conectar una base de datos, es muy probable que otro desarrollador ya haya creado código para eso. npm te permite descargar y usar ese código (llamado paquetes o librerías) en propios proyectos de manera muy sencilla.

**Conceptos y comandos clave:**

1. `npm init`: Inicializa un proyecto nuevo de Node.js. Te hará algunas preguntas y al final creará un archivo llamado `package.json`.
2. `npm install <nombre-del-paquete>` (o `npm i`): Descarga un paquete de internet y lo guarda en una carpeta llamada `node_modules` dentro de tu proyecto.
Ejemplo: `npm install express` (descarga la librería Express que usaremos mas adelante).
3. `node_modules`: Es una carpeta que se genera automáticamente al instalar paquetes. Contiene todo el código real de las librerías que descargaste. NUNCA debes subir esta carpeta a GitHub o compartirla, ya que ocupa mucho espacio.
4. `package-lock.json`: Archivo que registra las versiones exactas de los paquetes instalados.
