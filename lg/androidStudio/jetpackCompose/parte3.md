# Modifiers en Jetpack Compose
Los `Modifier` son una de las piezas más importantes de Compose.
Sirven para:
- tamaño
- color
- padding
- posición
- clics
- bordes
- fondos
- animaciones
- y mucho más

## Sintaxis básica
```kt
Text(
    text = "Hola",
    modifier = Modifier.padding(16.dp)
)
```
`modifier` modifica el componente.

## Tamaño
**width y height**
```kt
Modifier
    .width(200.dp)
    .height(80.dp)
```
**fillMaxWidth**: 
Ocupa todo el ancho disponible.
```kt
Modifier.fillMaxWidth()
```
**fillMaxSize**: 
Ocupa toda la pantalla.
```kt
Modifier.fillMaxSize()
```
## Padding
Espacio interno/alrededor.
```kt
Modifier.padding(16.dp)
```
También:
```kt
Modifier.padding(
    horizontal = 20.dp,
    vertical = 8.dp
)
```
## Background
```kt
Modifier.background(Color.Blue)
```
## Bordes
```kt
Modifier.border(
    width = 2.dp,
    color = Color.Red
)
```
## Forma redondeada
```kt
Modifier.clip(RoundedCornerShape(16.dp))
```
Ejemplo completo:
```kt
Text(
    text = "Compose",
    modifier = Modifier
        .background(Color.Gray)
        .padding(16.dp)
        .clip(RoundedCornerShape(12.dp))
)
```
## Clicks
```kt
Modifier.clickable {
    println("Click")
}
```
## Espaciadores
**Spacer**: 
Crea separación entre elementos.
```kt
Spacer(modifier = Modifier.height(20.dp))
```
## Encadenamiento
Los modifiers se pueden encadenar:
```kt
Modifier
    .fillMaxWidth()
    .padding(16.dp)
    .background(Color.LightGray)
```
📌 El orden importa.

## Ejemplo real
```kt
@Composable
fun Tarjeta() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.LightGray)
            .padding(16.dp)
    ) {

        Text(
            text = "Jetpack Compose",
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = {}) {
            Text("Aprender")
        }
    }
}
```
> [!IMPORTANT]
> 🧠 Concepto importante
> En Compose:
> - los layouts organizan
> - los modifiers decoran y controlan comportamiento

> Resumen
> - Modifier personaliza componentes
> - Puedes cambiar tamaño, color, padding y comportamiento
> - Los modifiers se encadenan
> - El orden de los modifiers afecta el resultado
