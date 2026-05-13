# Conceptos básicos de Jetpack Compose
## ¿Que es Composable?
Un `Composable` es una funcion que dibuja UI.
```kt
@Composable
fun Mensaje() {
    Text("Hola Android")
}
```
> [!TIP]
> La anotación `@Composable` le dice a Compose:
> `esta función crea una interfaz gráfica`

## Componentes Básicos
> **Text**
> ```kt
> Text("Hola mundo")
> ```
> *Muestra texto en pantalla*


> **Button**
> ```kt
> Button(onClick = { }) {
>     Text("Presionar")
> }
> ```
> *`onClick` ejecuta acciones*

> **Image**
> ```kt
> Image(
>     painter = painterResource(id = R.drawable.logo),
>     contentDescription = "Logo"
> )
> ```
> *Muestra imagenes*

## Personalizando componentes
Tamaño y color de texto
```kt
Text(
    text = "Hola",
    fontSize = 24.sp,
    color = Color.Blue
)
```
## Parámetros
Los composables pueden recibir datos
```kt
@Composable
fun Saludo(nombre: String) {
    Text("Hola $nombre")
}
```
Uso:
```kt
Saludo("Juan")
```
## Organizando UI
Se puede combinar composables:
```kt
@Composable
fun Pantalla() {
    Column {
        Text("Título")
        Button(onClick = { }) {
            Text("Aceptar")
        }
    }
}
```
> [!NOTE]
> Compose actualiza SOLO lo necesario. Si cambia un dato Compose vuelve a dibujar únicamente esa parte.
> 
> Esto se llama: 🔄 Recomposición

## Preview avanzado
Se puede tener multiples previews
```kt
@Preview(showBackground = true)
@Composable
fun PreviewPantalla() {
    Pantalla()
}
```

> [!NOTE]
> Buenas prácticas
> - ✅ Nombres descriptivos
> - ✅ Un composable = una responsabilidad
> - ✅ Reutilizar componentes
> - ✅ Mantener funciones pequeñas
