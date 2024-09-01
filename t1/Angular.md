# Angular
## Descargar
- [VisualStudioCode](https://code.visualstudio.com/)
- [node.js](https://nodejs.org/en)
ej: v20.14.0
- Angular
---
Para instalar Angular: 

*instalar angular desde la terminal (despues de descargar node.js)*
```
npm install -g @angular/cli@17
```
> [!IMPORTANT]
> *En los equipos cliente de Windows, la ejecución de scripts de PowerShell (terminal) está deshabilitada de forma predeterminada. Para permitir la ejecución de scripts de PowerShell, que es necesaria para los binarios globales de npm, debe ejecutar lo siguiente:*
> ```Set-ExecutionPolicy -Scope CurrentUser -ExecutionPolicy RemoteSigned```

*verificar version*
```
ng --version
```
*Creamos proyecto*
```
ng new nombre_proy --no-standalone
```
*Navegar a la carpeta del proyecto*
```
cd nombre-del-proyecto
```

*Lanzar proyecto*
```
ng serve --o
```

## Instalación de Boostrap
*ingresar mediante la terminal en la carpeta del proyecto dónde se quiere instalar boostrap y ingresar el siguiente comando (para la version de 5.3.3):*
```
npm i bootstrap@5.3.3
```
*En nuestro archivo `angular.json` ingresar lo siquiente:*
- En el apartado de {}build > {}options > []styles
  ``` json
  "node_modules/bootstrap/dist/css/bootstrap.min.css"
  ```
  o
  ``` json
  "./node_modules/bootstrap/dist/css/bootstrap.min.css"
  ```
- En el apartado de {}build > {}options > []scripts
  ``` json
  "node_modules/jquery/dist/jquery.min.js",
  "node_modules/@popperjs/core/dist/umd/popper.min.js",
  "node_modules/bootstrap/dist/js/bootstrap.min.js"
  ```
  o
  ``` json
  "./node_modules/bootstrap/dist/js/bootstrap.bundle.min.js"
  ```


[recomendación youtube](https://youtube.com/playlist?list=PLZ2ovOgdI-kWDh3jDh-GvgToRlVfwIUFw&si=98hyjKgdAcgion-7)
[recomendación youtube](https://youtu.be/soInCF7nbDw?t=18051)
