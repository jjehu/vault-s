# ViewModel + StateFlow (nivel pro)
Ahora pasamos de mutableStateOf a algo más potente: StateFlow 🚀\
Esto es lo que se usa en apps reales con arquitectura moderna.

***🧠 ¿Qué es StateFlow?***\
Es un flujo de datos observable de Kotlin (reactivo).

👉 Permite emitir valores y que la UI los observe automáticamente.

## ⚖️ mutableStateOf vs StateFlow
mutableStateOf	| StateFlow
:--:|:--:
Simple	| Más potente
Solo Compose	| Funciona en toda la app
Local	Ideal para | arquitectura MVVM

👉 Para proyectos grandes → **StateFlow**

## 🧱 ViewModel con StateFlow
```kt
class MiViewModel : ViewModel() {

    // 🔒 Estado interno (mutable)
    private val _contador = MutableStateFlow(0)

    // 🌍 Estado expuesto (inmutable)
    val contador: StateFlow<Int> = _contador

    fun incrementar() {
        _contador.value++ // actualiza el estado
    }
}
```
## 🔍 Explicación
```kt
private val _contador = MutableStateFlow(0)
```
👉 Estado interno que SÍ se puede modificar
```kt
val contador: StateFlow<Int> = _contador
```
👉 Expones solo lectura (buena práctica 🔥)

## 👁️ UI observando StateFlow
```kt
@Composable
fun Pantalla(viewModel: MiViewModel = viewModel()) {

    // 👇 Convierte StateFlow a estado de Compose
    val contador by viewModel.contador.collectAsState()

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
## 🧠 ¿Qué hace collectAsState()?
👉 Convierte el flujo en algo que Compose puede observar.

📌 Cuando cambia:
- StateFlow emite valor
- Compose recompone automáticamente

## 🔄 Flujo completo PRO
1. Usuario hace click
2. UI llama ViewModel
3. ViewModel actualiza _contador
4. StateFlow emite nuevo valor
5. UI recibe cambio (collectAsState)
6. Compose recompone

## 🧩 Ejemplo más real
```kt
data class UiState(
    val nombre: String = "",
    val cargando: Boolean = false
)

class UsuarioViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState

    fun actualizarNombre(nuevo: String) {
        _uiState.value = _uiState.value.copy(
            nombre = nuevo
        )
    }
}
```
## 👁️ UI
```kt
@Composable
fun PantallaUsuario(viewModel: UsuarioViewModel = viewModel()) {

    val state by viewModel.uiState.collectAsState()

    Column {

        TextField(
            value = state.nombre,
            onValueChange = {
                viewModel.actualizarNombre(it)
            }
        )

        Text("Hola ${state.nombre}")
    }
}
```
***🧠 Ventajas reales***\
✔ Manejo de múltiples estados\
✔ Escalable\
✔ Compatible con APIs, DB, etc.\
✔ Ideal para apps grandes

***⚠️ Buenas prácticas***\
✔ Usar MutableStateFlow interno + StateFlow externo\
✔ Usar data class para estado\
✔ No exponer mutabilidad

***📌 Resumen***
- StateFlow = estado reactivo moderno
- ViewModel lo controla
- UI lo observa con collectAsState()
- Base de arquitectura profesional
