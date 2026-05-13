# Arquitectura MVVM en Jetpack Compose
Aquí empezamos nivel profesional 🚀\
Esto es lo que usan apps reales.

***🧠 ¿Qué es MVVM?***
- MVVM = Model → datos
- View → UI (Compose)
- ViewModel → lógica + estado

***🎯 Objetivo***\
Separar responsabilidades:\
❌ Todo en un composable → desorden\
✅ Cada parte tiene su rol → limpio y escalable

***🧱 Estructura***
```
UI (Compose)
   ↓
ViewModel
   ↓
Model (datos / API / DB)
```
## 👁️ View (UI en Compose)
```kt
@Composable
fun Pantalla(viewModel: MiViewModel = viewModel()) {

    val contador = viewModel.contador

    Column {
        Text("Clicks: $contador")

        Button(onClick = {
            viewModel.incrementar()
        }) {
            Text("Sumar")
        }
    }
}
```
👉 La UI:\
- muestra datos
- envía eventos

## 🧠 ViewModel
```kt
class MiViewModel : ViewModel() {

    // 🔹 Estado
    var contador by mutableStateOf(0)
        private set

    // 🔹 Lógica
    fun incrementar() {
        contador++
    }
}
```
## 🔍 Explicación línea por línea
```kt
class MiViewModel : ViewModel() {
```
👉 Creamos una clase que sobrevive a rotaciones (importante en Android)
```kt
var contador by mutableStateOf(0)
```
👉 Estado observable (Compose escucha cambios)
```kt
private set
```
👉 Nadie desde fuera puede modificarlo directamente
```kt
fun incrementar() {
    contador++
}
```
👉 Única forma de cambiar el estado

## 🔄 Flujo completo
1. Usuario hace click
2. UI llama a `viewModel.incrementar()`
3. ViewModel cambia estado
4. Compose detecta cambio
5. UI se actualiza

> [!IMPORTANT]
> ⚠️ Importante\
> 👉 El ViewModel NO conoce la UI\
> 👉 La UI NO contiene lógica de negocio

## ❌ Error común
Meter lógica en el Composable:
```kt
// ❌ MAL
Button(onClick = {
    contador++
})
```
## ✅ Correcto
```kt
// ✔ BIEN
Button(onClick = {
    viewModel.incrementar()
})
```

***🧩 Ventajas reales***\
✔ Código organizado\
✔ Fácil mantenimiento\
✔ Escalable\
✔ Testeable\
✔ Separación clara

***📌 Resumen***
- View = UI (Compose)
- ViewModel = estado + lógica
- Model = datos
- La UI observa el estado
- El ViewModel lo modifica
