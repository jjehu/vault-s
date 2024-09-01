# Angular
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
