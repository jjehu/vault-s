# Material Design 3 en Jetpack Compose
Ahora vamos a darle aspecto profesional a tu app 🚀\
Aquí es donde tu UI pasa de básica → moderna.

***🧠 ¿Qué es Material Design 3?***\
Es el sistema de diseño oficial de Android:\
✔ Colores\
✔ Tipografía\
✔ Componentes (botones, cards, etc.)\
✔ Temas (claro/oscuro)

👉 Compose ya lo incluye por defecto.

## 🎨 Tema de la app
Cuando creas un proyecto, tienes algo así:
```kt
MaterialTheme {
    // Tu UI aquí
}
```
👉 Este define:
- colores
- estilos
- formas

## 🌈 Colores
Puedes usar los colores del tema:
```kt
Text(
    text = "Hola",
    color = MaterialTheme.colorScheme.primary
)
```
## 🔤 Tipografía
```kt
Text(
    text = "Título",
    style = MaterialTheme.typography.titleLarge
)
```
## 🔘 Botones modernos
```kt
Button(onClick = {}) {
    Text("Botón")
}
```
Otros tipos:
```kt
OutlinedButton(onClick = {}) {
    Text("Outlined")
}

TextButton(onClick = {}) {
    Text("Texto")
}
```
## 🧱 Cards (muy usadas)
```kt
Card(
    modifier = Modifier.padding(16.dp)
) {
    Text(
        text = "Contenido",
        modifier = Modifier.padding(16.dp)
    )
}
```
## 🎯 Ejemplo UI PRO
```kt
@Composable
fun TarjetaUsuario(nombre: String) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {

        Column(modifier = Modifier.padding(16.dp)) {

            Text(
                text = nombre,
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = {}) {
                Text("Ver perfil")
            }
        }
    }
}
```
## 🌙 Modo oscuro
Compose lo maneja automáticamente si usas:
```kt
MaterialTheme.colorScheme
```
👉 No hardcodees colores como `Color.Red` (mala práctica en apps grandes)

## 🎨 Personalizar tema
En `ui/theme` puedes cambiar:
```kt
val LightColors = lightColorScheme(
    primary = Color.Blue,
    secondary = Color.Green
)
```
***⚠️ Buenas prácticas***\
✔ Usa MaterialTheme siempre\
✔ No uses colores fijos (usa el theme)\
✔ Reutiliza componentes\
✔ Mantén consistencia visual

***📌 Resumen***
- Material 3 = diseño moderno Android
- Usa MaterialTheme
- Botones, Cards, Tipografía incluidos
- Soporta modo oscuro automáticamente
