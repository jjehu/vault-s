# Eventos y manejo de usuario

## ¿Qué es un evento?
Un evento es cualquier acción del usuario:
- click
- escribir texto
- seleccionar algo
- deslizar

### 🔘 Evento básico: click
```kt
Button(
    onClick = {
        println("Botón presionado")
    }
) {
    Text("Presionar")
}
```
> 👉 `onClick` es una función que se ejecuta cuando el usuario toca el botón.

### ✍️ Evento en inputs (TextField)
```kt
@Composable
fun InputNombre() {
    var nombre by remember { mutableStateOf("") }

    TextField(
        value = nombre,                  // estado actual
        onValueChange = { nuevoTexto ->  // evento
            nombre = nuevoTexto          // actualizamos estado
        }
    )
}
```
📌 Flujo:
> Usuario escribe → evento → actualizas estado → UI cambia

### 🎯 Eventos + State Hoisting (forma correcta)
```kt
@Composable
fun CampoTexto(
    texto: String,                        // estado
    onTextoCambio: (String) -> Unit       // evento
) {
    TextField(
        value = texto,
        onValueChange = onTextoCambio     // delega el cambio
    )
}
```
Uso:
```kt
@Composable
fun Pantalla() {
    var nombre by remember { mutableStateOf("") }

    CampoTexto(
        texto = nombre,
        onTextoCambio = { nuevo ->
            nombre = nuevo               // aquí controlas el estado
        }
    )
}
```
👆 `Modifier.clickable`\
También se puede hacer clickeables otros elementos:
```kt
Text(
    text = "Haz click aquí",
    modifier = Modifier.clickable {
        println("Texto clickeado")
    }
)
```
### 🧩 Eventos comunes
- onClick
- onValueChange
- onCheckedChange (Checkbox)
- onDismiss (diálogos)
- onItemClick (listas personalizadas)

---

> [!IMPORTANT]
> Buenas prácticas\
> ✔ Los eventos no deben contener lógica pesada\
> ✔ Solo delegan acciones\
> ✔ El estado se modifica fuera (hoisting)

**📌 Resumen**\
Los eventos capturan acciones del usuario
- Siempre actualizan estado
- UI se actualiza automáticamente
- Combinar eventos + estado = apps reactivas
