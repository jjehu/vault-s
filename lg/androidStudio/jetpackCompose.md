# Jetpack Compose

¿Qué es Jetpack Compose?
Jetpack Compose es el toolkit moderno de Android para construir interfaces de usuario de forma declarativa.
- Todo se hace con Kotlin
- UI = funciones
- Más simple, más rápido, más limpio

---
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
