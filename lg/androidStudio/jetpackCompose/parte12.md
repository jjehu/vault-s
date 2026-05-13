# Animaciones en Jetpack Compose (nivel WOW)
Aquí es donde tu app empieza a verse 🔥 profesional de verdad.

***🧠 ¿Por qué animaciones?***\
✔ Mejor experiencia de usuario\
✔ Interfaces más fluidas\
✔ Sensación de app moderna

🎯 Animación más simple: `animate*AsState`
Ejemplo: cambiar tamaño
```kt
@Composable
fun AnimacionSimple() {

    var grande by remember { mutableStateOf(false) }

    val tamaño by animateDpAsState(
        targetValue = if (grande) 150.dp else 80.dp
    )

    Box(
        modifier = Modifier
            .size(tamaño)
            .background(Color.Blue)
            .clickable {
                grande = !grande
            }
    )
}
```
👉 Click → cambia estado → se anima automáticamente

## 🎨 Animar colores
```kt
val color by animateColorAsState(
    targetValue = if (activo) Color.Green else Color.Red
)
```
## 🔄 AnimatedVisibility
Mostrar/ocultar con animación:
```kt
@Composable
fun MostrarElemento() {

    var visible by remember { mutableStateOf(true) }

    Column {

        Button(onClick = {
            visible = !visible
        }) {
            Text("Mostrar/Ocultar")
        }

        AnimatedVisibility(visible = visible) {
            Text("Hola 👋")
        }
    }
}
```
## 🔁 Crossfade (transiciones suaves)
```kt
Crossfade(targetState = pantalla) { screen ->

    when (screen) {
        "A" -> Text("Pantalla A")
        "B" -> Text("Pantalla B")
    }
}
```
## 🎯 Animaciones con transición
```kt
val escala by animateFloatAsState(
    targetValue = if (activo) 1.5f else 1f
)

Box(
    modifier = Modifier
        .scale(escala)
        .background(Color.Magenta)
)
```
## 🧠 Concepto clave
👉 Las animaciones en Compose están ligadas al estado

📌 Cambia el estado → Compose anima automáticamente

***⚠️ Buenas prácticas***\
✔ No abuses de animaciones\
✔ Usa animaciones sutiles\
✔ Mantén consistencia\
✔ Prioriza UX sobre efectos

## 🚀 Ejemplo PRO combinado
```kt
@Composable
fun TarjetaAnimada() {

    var expandido by remember { mutableStateOf(false) }

    val tamaño by animateDpAsState(
        targetValue = if (expandido) 200.dp else 100.dp
    )

    val color by animateColorAsState(
        targetValue = if (expandido) Color.Blue else Color.Gray
    )

    Box(
        modifier = Modifier
            .size(tamaño)
            .background(color)
            .clickable {
                expandido = !expandido
            }
    )
}
```
***📌 Resumen***
- Las animaciones dependen del estado
- animate*AsState es lo más usado
- AnimatedVisibility para mostrar/ocultar
- Crossfade para cambiar pantallas
- Compose hace todo automático
