# p5.js

[Editor online](https://editor.p5js.org/)

Estructura básica
```js
function setup() {
  createCanvas(800 , 500);
}

function draw() {
  background (220);
}
```
> [!NOTE]
> La función `setup()` se ejecuta una sola vez al iniciar el programa.\
> Se usa para:\
> • Crear el canvas.\
> • Definir configuraciones iniciales.\
> • Preparar variables.\
> • Establecer condiciones iniciales.

> [!NOTE]
> La función `draw()` se ejecuta muchas veces por segundo. Por eso permite animar.\
> Si algo cambia dentro de `draw()`, ese cambio se repite constantemente.

## 💠 COORDENADAS Y LIENZO
> [!IMPORTANT]
> En p5.js trabajamos con coordenadas:\
> • X indica posición horizontal.\
> • Y indica posición vertical.\
> • El punto (0,0) está en la esquina superior izquierda.\
> • X aumenta hacia la derecha.\
> • Y aumenta hacia abajo.

## 💠 FIGURAS BÁSICAS
### Punto
*Marca una coordenada*
```js
point(x,y)
```
### Línea
*Une dos puntos*
```js
line(x1,y1,x2,y2)
```
### Rectángulo
*Dibuja una caja*
```js
rect(x,y,w,h)
```
### Círculo
*Dibuja un círculo*
```js
circle(x,y,d)
```
### Elipse
*Círculo deformado*
```js
ellipse(x,y,w,h)
```

## 💠 COLOR, BORDE Y RELLENO
> [!IMPORTANT]
> Antes de dibujar una figura podemos definir su color.\
> • `background()` cambia el fondo.\
> • `fill()` cambia el relleno.\
> • `stroke()` cambia el borde.\
> • `strokeWeight()` cambia el grosor del borde.\
> • `noStroke()` elimina el borde.\
> • `noFill()` elimina el relleno.

Ejemplo:
```js
function setup() {
  createCanvas(800 , 500);
}

function draw() {
  background(20, 30, 60);

  fill(255 , 180, 0);
  stroke(255);
  strokeWeight(4);
  circle(250 , 250, 120);

  noStroke();
  fill(0, 200, 180);
  rect(450 , 190, 160, 120);
}
```

> [!WARNING]
> El color que se coloca antes de una figura afecta a esa figura y a las siguientes, hasta que se cambie nuevamente el color.

## 💠 VARIABLES
> [!IMPORTANT]
> Una variable guarda un valor que puede cambiar.\
> En programación gráfica, las variables sirven para recordar:\
> • La posición de un objeto.\
> • Su velocidad.\
> • Su tamaño.\
> • Su color.\
> • Su estado.

```js
let x = 100;

function setup() {
  createCanvas(800 , 500);
}

function draw() {
  background (230);
  circle(x, 250, 80);
}
```
## 💠 MOVIMIENTO
> [!TIP]
> Formula mental:\
> Movimiento = posición + cambio constante

```js
let x = 50;

function setup() {
  createCanvas(800 , 500);
}

function draw() {
  background(20);

  fill(255 , 180, 0);
  noStroke();
  circle(x, 250, 70);

  x = x + 3;
}
```
> [!NOTE]
> En cada ejecución de draw():
> 1. Se limpia la pantalla con background(20).
> 2. Se dibuja el círculo en la posición actual.
> 3. Luego x aumenta en 3.
> 4. En el siguiente ciclo, el círculo aparece un poco más a la derecha.
> Ese pequeño cambio repetido muchas veces produce la sensación de movimiento.

## 💠 VELOCIDAD
> [!IMPORTANT]
> La velocidad es la cantidad que se suma a la posición en cada ciclo.\
> En vez de escribir:
> ```js
> x = x + 3;
> ```
> Podemos escribir:
> ```js
> x = x + velocidad;
> ```

Ejemplo:
```js
let x = 50;
let velocidad = 4;

function setup() {
  createCanvas(800 , 500);
}

function draw() {
  background(15);

  fill(0, 200, 255);
  circle(x, 250, 70);

  x = x + velocidad ;
}
```
> [!TIP]
> Usar una variable llamada velocidad hace que el código sea más claro.\
> Además, si queremos que el objeto vaya más rápido, solo cambiamos el valor de velocidad.

## 💠 CONDICIONES Y REBOTE
Las condiciones permiten que un objeto tome decisiones.
Un círculo puede preguntar:\
`¿Llegué al borde?`\
Si la respuesta es sí, cambia su dirección.

Ejemplo:
```js
let x = 100;
let velocidad = 4;

function setup() {
  createCanvas(800 , 500);
}

function draw() {
  background(20);

  fill(255 , 100, 100);
  circle(x, 250, 70);

  x = x + velocidad ;

  if (x > width || x < 0) {
    velocidad = velocidad * -1;
  }
}
```
> [!NOTE]
> **Explicación línea por línea**\
> • `x` guarda la posición horizontal.\
> • `velocidad` define cuánto avanza.\
> • `x = x + velocidad` mueve el círculo.\
> • `if` revisa si llegó a un borde.\
> • `velocidad * -1` invierte la dirección.

## 💠 REBOTE CORRECTO USANDO RADIO
> [!IMPORTANT]
> Si el círculo tiene diámetro 70, su radio es 35.\
> Para evitar que medio círculo se salga de la pantalla, debemos revisar:\
> • Borde izquierdo: `x - radio < 0`\
> • Borde derecho: `x + radio > width`

Ejemplo:
```js
let x = 100;
let velocidad = 4;
let radio = 35;

function setup() {
  createCanvas(800 , 500);
}

function draw() {
  background(10, 20, 40);

  fill(255 , 220, 0);
  circle(x, 250, radio * 2);

  x = x + velocidad ;

  if (x + radio > width || x - radio < 0) {
    velocidad = velocidad * -1;
  }
}
```
## 💠 MOVIMIENTO EN X Y EN Y
> [!IMPORTANT]
> Para mover un objeto en dos direcciones necesitamos:\
> • Una posición horizontal: x\
> • Una posición vertical: y\
> • Una velocidad horizontal: vx\
> • Una velocidad vertical: vy

Ejemplo:
```js
let x = 200;
let y = 150;
let vx = 4;
let vy = 3;
let radio = 30;

function setup() {
  createCanvas(800 , 500);
}

function draw() {
  background(5, 10, 30);

  fill(0, 255, 180);
  noStroke();
  circle(x, y, radio * 2);

  x = x + vx;
  y = y + vy;

  if (x + radio > width || x - radio < 0) {
    vx = vx * -1;
  }

  if (y + radio > height || y - radio < 0) {
    vy = vy * -1;
  }
}
```
## 💠 INTERACCIÓN CON EL MOUSE
> [!IMPORTANT]
> p5.js tiene variables especiales:\
> • `mouseX`: posición horizontal del mouse.\
> • `mouseY`: posición vertical del mouse.\
> Estas variables permiten que el dibujo siga al usuario.

Ejemplo:
```js
function setup() {
  createCanvas(800 , 500);
}

function draw() {
  background(20);

  fill(255 , 100, 200);
  circle(mouseX , mouseY , 60);
}
```
> [!NOTE]
> El círculo ya no depende de una posición fija.\
> Ahora depende directamente del usuario.\
> Esto convierte un dibujo estático en una experiencia interactiva.

## 💠 EVENTOS DEL MOUSE
> [!IMPORTANT]
> La función `mousePressed()` se ejecuta cuando el usuario hace clic.\
> Es útil para:\
> • Cambiar colores.\
> • Crear objetos.\
> • Activar modos.\
> • Reiniciar una animación.

Ejemplo:
```js
let r = 255;
let g = 100;
let b = 50;

function setup() {
  createCanvas(800 , 500);
}

function draw() {
  background(30);

  fill(r, g, b);
  circle(400 , 250, 120);
}

function mousePressed() {
  r = random(255);
  g = random(255);
  b = random(255);
}
```
> [!NOTE]
> `random(255)` genera un valor aleatorio entre 0 y 255. Sirve mucho para colores, tamaños y posiciones.

## 💠 INTERACCIÓN CON TECLADO
> [!IMPORTANT]
> Para mover un objeto con el teclado podemos revisar qué tecla está presionada.\
> Una forma sencilla es usar `keyIsDown()`.

Ejemplo:
```js
let x = 400;
let y = 250;

function setup() {
  createCanvas(800 , 500);
}

function draw() {
  background(10, 20, 40);

  if (keyIsDown(LEFT_ARROW)) {
    x = x - 4;
  }

  if (keyIsDown(RIGHT_ARROW)) {
    x = x + 4;
  }

  if (keyIsDown(UP_ARROW)) {
    y = y - 4;
  }

  if (keyIsDown(DOWN_ARROW)) {
    y = y + 4;
  }

  fill(0, 200, 255);
  circle(x, y, 70);
}
```
> [!NOTE]
> El teclado no dibuja directamente.\
> El teclado modifica variables.\
> Y esas variables cambian la posición del objeto.

## 💠 BACKGROUND Y RASTROS
> [!IMPORTANT]
> Si colocamos `background()` dentro de `draw()`, la pantalla se limpia en cada ciclo.\
> Esto produce animación limpia.

Ejemplo:
```js
let x = 0;

function setup() {
  createCanvas(800 , 500);
}

function draw() {
  background (240);
  circle(x, 250, 60);
  x = x + 3;
}
```

> [!WARNING]
> Si no limpiamos la pantalla, las posiciones anteriores quedan marcadas.\
> Eso puede ser un error o puede usarse como efecto visual.
> ```js
> let x = 0;
>
> function setup() {
>   createCanvas(800 , 500);
>   background(10);
> }
>
> function draw() {
>   fill(255 , 180, 0);
>   circle(x, 250, 30);
>   x = x + 3;
> }
> ```


## 🔶 Ejemplo 1:
```js
let x = 200;
let y = 150;
let vx = 4;
let vy = 3;
let radio = 35;

let r = 0;
let g = 200;
let b = 255;

function setup() {
  createCanvas(800, 500);
  textSize(18);
}
function draw() {
  background(8, 15, 35);
  fill(255);
  text("Repaso p5.js- Segundo Parcial", 20, 30);
  fill(r, g, b);
  noStroke();
  circle(x, y, radio * 2);
  stroke(255);
  noFill();
  text("Haz clic para cambiar el color del orbe", 20, 55);
  circle(mouseX, mouseY, 30);
  x = x + vx;
  y = y + vy;
  if (x + radio > width || x- radio < 0) {
    vx = vx *-1;
  }
  if (y + radio > height || y- radio < 0) {
    vy = vy *-1;
  }
}
function mousePressed() {
  r = random(255);
  g = random(255);
  b = random(255);
}
```
## 🔶 Ejemplo 2:
```js
// ==========================================================
// PROGRAMA EDUCATIVO DE FIGURAS 3D EN P5.JS
// ==========================================================
// Este ejemplo enseña:
//
// 1. Cómo usar WEBGL para trabajar en 3D
// 2. Cómo crear figuras 3D
// 3. Cómo hacer que las figuras roten/orbiten
// 4. Cómo mover la cámara
// 5. Cómo cambiar colores
// 6. Cómo usar luces
// 7. Cómo mover objetos con el teclado
//
// Puedes probar este código en:
// https://editor.p5js.org/
// ==========================================================

// ----------------------------------------------------------
// VARIABLES GLOBALES
// ----------------------------------------------------------

// Ángulo para animaciones
let angulo = 0;

// Variables para mover la cámara
let camX = 0;
let camY = 0;
let camZ = 600;

// Posición de una esfera
let esferaX = 0;
let esferaY = 0;

// ==========================================================
// SETUP
// ==========================================================
// setup() se ejecuta UNA SOLA VEZ al iniciar
// ==========================================================

function setup() {

  // createCanvas con WEBGL activa el modo 3D
  createCanvas(1000, 700, WEBGL);

}

// ==========================================================
// DRAW
// ==========================================================
// draw() se ejecuta MUCHAS veces por segundo
// Aquí colocamos las animaciones
// ==========================================================

function draw() {

  // --------------------------------------------------------
  // COLOR DE FONDO
  // --------------------------------------------------------

  // Fondo oscuro
  background(15);

  // --------------------------------------------------------
  // CONFIGURACIÓN DE CÁMARA
  // --------------------------------------------------------
  // camera():
  // camera(posX, posY, posZ, objetivoX, objetivoY, objetivoZ, arribaX, arribaY, arribaZ)

  camera(
    camX, camY, camZ, // posición de la cámara
    0, 0, 0,          // hacia dónde mira
    0, 1, 0           // cuál es arriba
  );

  // --------------------------------------------------------
  // ILUMINACIÓN
  // --------------------------------------------------------

  // Luz ambiental suave
  ambientLight(80);

  // Luz direccional
  directionalLight(
    255, 255, 255, // color de la luz
    1, 1, -1       // dirección
  );

  // --------------------------------------------------------
  // DIBUJAR EJES DE REFERENCIA
  // --------------------------------------------------------
  // Esto ayuda a entender el espacio 3D

  dibujarEjes();

  // ========================================================
  // CUBO GIRATORIO
  // ========================================================

  // push() guarda la posición actual
  push();

  // Movemos el cubo hacia la izquierda
  translate(-250, 0, 0);

  // Rotación en eje X
  rotateX(angulo);

  // Rotación en eje Y
  rotateY(angulo * 0.7);

  // Cambiamos color
  fill(255, 0, 0);

  // Color del borde
  stroke(255);

  // Dibujar caja 3D
  // box(tamaño)
  box(120);

  // pop() restaura la posición original
  pop();

  // ========================================================
  // ESFERA ORBITANDO
  // ========================================================

  push();

  // --------------------------------------------------------
  // HACER ORBITA
  // --------------------------------------------------------
  // rotateY hace girar todo el sistema

  rotateY(angulo);

  // Movemos la esfera lejos del centro
  translate(250, 0, 0);

  // Color azul
  fill(0, 100, 255);

  // Dibujar esfera
  sphere(60);

  pop();

  // ========================================================
  // TOROIDE GIRATORIO
  // ========================================================

  push();

  // Mover arriba
  translate(0, -180, 0);

  // Rotaciones
  rotateX(angulo);
  rotateZ(angulo);

  // Color verde
  fill(0, 255, 100);

  // torus(radio, grosor)
  torus(70, 20);

  pop();

  // ========================================================
  // CONO GIRATORIO
  // ========================================================

  push();

  // Mover abajo
  translate(0, 180, 0);

  // Rotar
  rotateY(angulo);

  // Color naranja
  fill(255, 150, 0);

  // cone(radio, altura)
  cone(60, 120);

  pop();

  // ========================================================
  // ESFERA CONTROLADA POR TECLADO
  // ========================================================

  push();

  // Posición controlada por teclado
  translate(esferaX, esferaY, 200);

  // Color amarillo
  fill(255, 255, 0);

  sphere(40);

  pop();

  // --------------------------------------------------------
  // AUMENTAR ANGULO
  // --------------------------------------------------------
  // Esto produce la animación

  angulo += 0.02;

  // --------------------------------------------------------
  // TEXTO INFORMATIVO
  // --------------------------------------------------------

  mostrarInstrucciones();

}

// ==========================================================
// FUNCION PARA DIBUJAR EJES
// ==========================================================

function dibujarEjes() {

  // EJE X = ROJO
  stroke(255, 0, 0);
  line(0, 0, 0, 300, 0, 0);

  // EJE Y = VERDE
  stroke(0, 255, 0);
  line(0, 0, 0, 0, 300, 0);

  // EJE Z = AZUL
  stroke(0, 100, 255);
  line(0, 0, 0, 0, 0, 300);

}

// ==========================================================
// CONTROL DE TECLADO
// ==========================================================

function keyPressed() {

  // --------------------------------------------------------
  // MOVER CAMARA
  // --------------------------------------------------------

  // A = izquierda
  if (key === 'a') {
    camX -= 20;
  }

  // D = derecha
  if (key === 'd') {
    camX += 20;
  }

  // W = acercar cámara
  if (key === 'w') {
    camZ -= 20;
  }

  // S = alejar cámara
  if (key === 's') {
    camZ += 20;
  }

  // Q = subir cámara
  if (key === 'q') {
    camY -= 20;
  }

  // E = bajar cámara
  if (key === 'e') {
    camY += 20;
  }

  // --------------------------------------------------------
  // MOVER ESFERA
  // --------------------------------------------------------

  // Flecha izquierda
  if (keyCode === LEFT_ARROW) {
    esferaX -= 20;
  }

  // Flecha derecha
  if (keyCode === RIGHT_ARROW) {
    esferaX += 20;
  }

  // Flecha arriba
  if (keyCode === UP_ARROW) {
    esferaY -= 20;
  }

  // Flecha abajo
  if (keyCode === DOWN_ARROW) {
    esferaY += 20;
  }

}

// ==========================================================
// MOSTRAR INSTRUCCIONES
// ==========================================================

function mostrarInstrucciones() {

  // resetMatrix evita que el texto se deforme en 3D
  resetMatrix();

  // Estilo de texto
  fill(255);
  textSize(16);

  // Mostrar controles
  text("CONTROLES:", 20 - width/2, 30 - height/2);

  text("W/S = Zoom cámara", 20 - width/2, 60 - height/2);
  text("A/D = Mover cámara izquierda/derecha", 20 - width/2, 90 - height/2);
  text("Q/E = Mover cámara arriba/abajo", 20 - width/2, 120 - height/2);

  text("Flechas = mover esfera amarilla", 20 - width/2, 170 - height/2);

}
```
