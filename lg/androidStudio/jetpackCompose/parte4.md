# Estado y Recomposición en Jetpack Compose
Este es el concepto más importante de todo Compose. Si entiendes esto bien, ya estás en otro nivel 🚀

## ¿Qué es el estado?
El **estado** es cualquier dato que puede cambiar en la UI.

Ejemplos:
- texto de un input
- contador
- si un botón está activado
- lista de elementos

## ❌ Problema sin estado
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

## ✅ Solución: usar estado (State)
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

## ¿Qué es la recomposición?
Cuando cambia el estado:
1. Compose detecta el cambio
2. Vuelve a ejecutar el composable
3. Actualiza SOLO lo necesario
📌 No redibuja toda la pantalla, solo partes afectadas.

## Ejemplo claro
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

# Algunas aclaraciones
***¿Qué es onValueChange?***\
`onValueChange` → es simplemente una función lambda de Kotlin.\
Pero su uso así es típico de Jetpack Compose porque:
- Compose trabaja con estado + eventos
- Los componentes (como TextField) no guardan estado interno automáticamente, se lo tiene que pasar el estado.

```kt
onValueChange = { nombre = it }
```
Es lo mismo que:
```kt
onValueChange = { nuevoValor ->
    nombre = nuevoValor
}
```
`it` = el nuevo texto que el usuario escribio.


## 🔥 Estado Elevado (State Hoisting) — explicación
Este concepto es CLAVE para apps grandes.

### ❌ Forma incorrecta (estado interno)
```kt
@Composable
fun ContadorMalo() { //<-------
    // ❌ El estado vive dentro del componente
    var count by remember { mutableStateOf(0) } //<-------

    Button(onClick = {
        count++ // cambia el estado interno
    }) {
        Text("Clicks: $count")
    }
}
```
🚫 Problemas:
- No puedes reutilizarlo bien
- Difícil de testear
- Nadie más puede controlar ese estado

### ✅ Forma correcta (Estado Elevado)
```kt
@Composable
fun ContadorBueno( //<-------
    count: Int,                  // 🔹 Estado viene desde afuera
    onIncrement: () -> Unit      // 🔹 Evento también viene desde afuera
) {
    Button(
        onClick = onIncrement    // 🔹 Solo ejecuta la acción, NO maneja estado
    ) {
        Text("Clicks: $count")   // 🔹 Muestra el estado
    }
}
```
**🧩 ¿Dónde vive el estado entonces?**       \
En el componente padre:
```kt
@Composable
fun Pantalla() {

    // ✅ Estado centralizado aquí
    var count by remember { mutableStateOf(0) } //<-------

    ContadorBueno(
        count = count,           // 🔹 Le pasamos el estado
        onIncrement = {
            count++              // 🔹 Aquí se modifica el estado
        }
    )
}
```
**🧠 ¿Qué está pasando realmente?**\
📌 Flujo completo:
- Usuario hace click
- ContadorBueno llama a onIncrement
- Pantalla cambia count
- Compose recompone
- UI se actualiza

🎯 Regla de oro
- 👉 Los composables deben ser "tontos" (stateless)
- 👉 El estado vive arriba (stateful)

🚀 Beneficios reales\
✔ Reutilizable\
✔ Testeable\
✔ Escalable\
✔ Separación clara de responsabilidades

