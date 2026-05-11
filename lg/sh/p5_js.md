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
> En cada ejecución de draw():\
> 1. Se limpia la pantalla con background(20).\
> 2. Se dibuja el círculo en la posición actual.\
> 3. Luego x aumenta en 3.\
> 4. En el siguiente ciclo, el círculo aparece un poco más a la derecha.\
> Ese pequeño cambio repetido muchas veces produce la sensación de movimiento.

## 💠 VELOCIDAD


💠
