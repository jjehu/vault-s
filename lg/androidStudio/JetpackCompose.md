
# Jetpack Compose

¿Qué es Jetpack Compose?
Jetpack Compose es el toolkit moderno de Android para construir interfaces de usuario de forma declarativa.
- Todo se hace con Kotlin
- UI = funciones
- Más simple, más rápido, más limpio

---

[Introducción a Jetpack Compose](https://github.com/jjehu/vault-s/blob/main/lg/androidStudio/jetpackCompose.md#introduccion-a-jetpack-compose)
Introducción y Configuración del entorno
1. [Conceptos básicos de Compose](jetpackCompose/parte1.md)
2. [Layouts (Column, Row, Box)](jetpackCompose/parte2.md)
3. [Modifiers](jetpackCompose/parte3.md)
4. [Estado y recomposición](jetpackCompose/parte4.md)
5. [Eventos y manejo de usuario](jetpackCompose/parte5.md)
6. [Listas (LazyColumn, LazyRow)](jetpackCompose/parte6.md)
7. [Navegación](jetpackCompose/parte7.md)
8. [Arquitectura (MVVM)](jetpackCompose/parte8.md)
9. [ViewModel + StateFlow](jetpackCompose/parte9.md)
10. [Consumo de APIs (Retrofit)](jetpackCompose/parte10.md)
11. [Material Design 3](jetpackCompose/parte11.md)
12. [Animaciones](jetpackCompose/parte12.md)
13. [Testing en Compose](jetpackCompose/parte13.md)
14. [Proyecto final](jetpackCompose/parte14.md)

---
## Introduccion a Jetpack Compose
**Primera funcion Compose**
```kt
@Composable
fun Saludo() {
    Text(text = "Hola mundo 👋")
}
```
> [!NOTE]
> - @Composable: indica que esta función dibuja UI
> - Text(): componente básico para mostrar texto

---

**Vista previa (preview)**
```kt
@Preview(showBackground = true)
@Composable
fun PreviewSaludo() {
    Saludo()
}
```

## Configuración del entorno
### Crear un proyecto con Jetpack Compose
> Pasos
> 1. Abrir Android Studio
> 2. Click en New Project
> 3. Elegir:
> - Empty Activity
> 4. Verifica que esté marcado:
> - Use Kotlin
> - Use Jetpack Compose

### Estructura básica de un proyecto
```kt
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MiApp()
        }
    }
}
```
> [!TIP]
> `setContent {}` reemplaza al antiguo `setContentView()`
> Todo lo que se ponga dentro será UI Compose

> [!WARNING]
> - Android Studio ya soporta Compose nativamente
> - setContent {} inicia la UI
> - Los composables son funciones Kotlin
> - Compose usa Material Design 3 por defecto





## Estado y Recomposición en Jetpack Compose
Este es el concepto más importante de todo Compose. Si entiendes esto bien, ya estás en otro nivel 🚀

### ¿Qué es el estado?
El **estado** es cualquier dato que puede cambiar en la UI.

Ejemplos:
- texto de un input
- contador
- si un botón está activado
- lista de elementos

### ❌ Problema sin estado
```kt
@Composable
fun Contador() {
    var numero = 0

    Button(onClick = {
        numero++
    }) {
        Text("Clicks: $numero")
    }
}
```
> Esto **NO funciona** correctamente
Porque Compose no detecta cambios en variables normales.

### ✅ Solución: usar estado (State)
```kt
@Composable
fun Contador() {
    var numero by remember { mutableStateOf(0) }

    Button(onClick = {
        numero++
    }) {
        Text("Clicks: $numero")
    }
}
```
> [!NOTE]
> ***🔍 ¿Qué está pasando aquí?***
> `remember`: Guarda el valor aunque la UI se redibuje.
> `mutableStateOf`: Crea un estado observable.
>
> Cuando cambia:
> Compose recompone automáticamente la UI

### ¿Qué es la recomposición?
Cuando cambia el estado:
1. Compose detecta el cambio
2. Vuelve a ejecutar el composable
3. Actualiza SOLO lo necesario
📌 No redibuja toda la pantalla, solo partes afectadas.

### Ejemplo claro
```kt
@Composable
fun Pantalla() {
    var nombre by remember { mutableStateOf("") }

    Column {
        TextField(
            value = nombre,
            onValueChange = { nombre = it }
        )

        Text("Hola $nombre")
    }
}
```
👉 Escribes en el input → el texto se actualiza automáticamente.

> [!CAUTION]
> Regla importante\
> 💡 La UI debe depender del estado, no al revés\
> ✔ Correcto:
> ```kt
> Text("Total: $total")
> ```
> ❌ Incorrecto:\
> modificar UI manualmente como en Android antiguo

> [!IMPORTANT]
> 🧩 Estado elevado (State Hoisting)\
> Mala práctica:
> ```kt
> @Composable
> fun BotonContador() {
>     var count by remember { mutableStateOf(0) }
> }
> ```
> Mejor:
> ```kt
> @Composable
> fun BotonContador(count: Int, onIncrement: () -> Unit) {
>     Button(onClick = onIncrement) {
>         Text("Clicks: $count")
>     }
> }
> ```
> 👉 El estado se controla desde afuera.

***🧠 Beneficios***\
✔ Código más limpio\
✔ Fácil de testear\
✔ Reutilizable\
✔ Escalable

📌 Resumen
- El estado controla la UI
- Usa remember + mutableStateOf
- Compose se recompone automáticamente
- Evita variables normales
- Usa state hoisting para escalar
