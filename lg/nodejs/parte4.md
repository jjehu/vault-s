# Crear proyectos
Ahora que sabemos qué es Node, npm y el archivo `package.json`, vamos a unir todas las piezas para entender cuál es el flujo de trabajo real al crear un proyecto de backend desde cero.

Pasos para crear un proyecto de Node.js:

3. Crear la carpeta: Creas una carpeta en tu computadora para tu proyecto (por ejemplo, `mi-primer-servidor`) y abres esa carpeta en tu editor de código (como VS Code) y en tu terminal.
2. Inicializar el proyecto: En la terminal, escribes `npm init -y`.
> El modificador `-y` (de "yes") le dice a npm que cree el `package.json` con valores por defecto sin hacerte todas las preguntas aburridas.
3. Instalar dependencias: Si necesitas alguna librería, la instalas. Por ejemplo: `npm install express`.
> También se pueden instalar multiples dependencias, ejemplo: `npm install express mysql2 body-parser`.
4. Crear el archivo principal: Creas un archivo, normalmente llamado `index.js` o `app.js`, donde se ecribirá el código principal.
5. El archivo `.gitignore`: Si vas a usar Git (para subir a GitHub), creas un archivo llamado `.gitignore` y dentro de él escribes `node_modules`. Esto le dice a Git que ignore esa carpeta y no la suba.
6. Ejecutar: Escribes `node index.js` en la terminal para correr tu código.
> Para correr el código y cada vez que se cambie algo de codigo no se tenga que estar nuevamente ejecutando `node index.js` se puede hacer con `node --watch index.js`.

```
mi-primer-servidor/
│
├── node_modules/    (Carpeta pesada, no se comparte)
├── index.js         (Tu código)
├── package.json     (La configuración del proyecto)
├── package-lock.json (Registro de versiones exactas)
└── .gitignore       (Archivo para ignorar carpetas en Git)
```
