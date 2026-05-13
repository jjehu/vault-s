# Listas en Jetpack Compose (LazyColumn y LazyRow)
Es este tema se aprendera a mostrar listas dinámicas, algo esencial en cualquier app (feeds, chats, productos, etc.).

***🧱 ¿Qué es LazyColumn?***\
Es como un RecyclerView, pero en Compose.

👉 Solo renderiza los elementos visibles (optimización automática).

## ✅ Ejemplo básico
```kt
@Composable
fun ListaSimple() {

    val nombres = listOf("Juan", "Ana", "Pedro", "Luis")

    LazyColumn {
        items(nombres) { nombre ->
            Text(text = nombre)
        }
    }
}
```
**🔍 ¿Qué está pasando?**
```kt
LazyColumn {              // contenedor vertical eficiente

    items(nombres) {      // recorre la lista
        nombre ->         // cada elemento

        Text(nombre)      // UI por item
    }
}
```
**📏 Espaciado entre elementos**
```kt
LazyColumn(
    verticalArrangement = Arrangement.spacedBy(8.dp)
) {
    items(nombres) {
        Text(it)
    }
}
```
## 🧩 Lista con diseño (más real)
```kt
@Composable
fun ListaBonita() {

    val nombres = listOf("Juan", "Ana", "Pedro")

    LazyColumn {
        items(nombres) { nombre ->

            Text(
                text = nombre,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .background(Color.LightGray)
                    .padding(16.dp)
            )
        }
    }
}
```
## ↔️ LazyRow (horizontal)
```kt
@Composable
fun ListaHorizontal() {

    val items = listOf("A", "B", "C")

    LazyRow {
        items(items) { item ->
            Text(
                text = item,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}
```
## 🎯 Eventos en listas
```kt
items(nombres) { nombre ->

    Text(
        text = nombre,
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                println("Click en $nombre")
            }
            .padding(16.dp)
    )
}
```
## 🧠 Lista con estado
```kt
@Composable
fun ListaConEstado() {

    var seleccionado by remember { mutableStateOf("") }

    val nombres = listOf("Juan", "Ana", "Pedro")

    LazyColumn {
        items(nombres) { nombre ->

            Text(
                text = nombre,
                color = if (nombre == seleccionado) Color.Red else Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        seleccionado = nombre
                    }
                    .padding(16.dp)
            )
        }
    }
}
```
> [!TIP]
> ***⚠️ Buenas prácticas***\
> ✔ Usa LazyColumn en vez de Column para listas grandes\
> ✔ Evita lógica pesada dentro de items\
> ✔ Usa claves (key) si la lista cambia dinámicamente (nivel más avanzado)

***📌 Resumen***
- LazyColumn → listas verticales
- LazyRow → listas horizontales
- Solo renderizan lo visible (eficiente)
- Puedes manejar eventos y estado dentro
