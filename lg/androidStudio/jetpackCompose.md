
# Jetpack Compose

¿Qué es Jetpack Compose?
Jetpack Compose es el toolkit moderno de Android para construir interfaces de usuario de forma declarativa.
- Todo se hace con Kotlin
- UI = funciones
- Más simple, más rápido, más limpio

---

[Introducción a Jetpack Compose](https://github.com/jjehu/vault-s/blob/main/lg/androidStudio/jetpackCompose.md#introduccion-a-jetpack-compose)
Configuración del entorno
Conceptos básicos de Compose
Layouts (Column, Row, Box)
Modifiers
Estado y recomposición
Eventos y manejo de usuario
Listas (LazyColumn, LazyRow)
Navegación
Arquitectura (MVVM)
ViewModel + StateFlow
Consumo de APIs (Retrofit)
Material Design 3
Animaciones
Testing en Compose
Proyecto final

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

## Conceptos básicos de Jetpack Compose
### ¿Que es Composable?
Un `Composable` es una funcion que dibija UI.
```kt
@Composable
fun Mensaje() {
    Text("Hola Android")
}
```
> [!TIP]
> La anotación `@Composable` le dice a Compose:
> `esta función crea una interfaz gráfica`

### Componentes Básicos
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

### Personalizando componentes
Tamaño y color de texto
```kt
Text(
    text = "Hola",
    fontSize = 24.sp,
    color = Color.Blue
)
```
### Parámetros
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
### Organizando UI
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

### Preview avanzado
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

## Layouts en Jetpack Compose
Los layouts organizan los elementos en pantalla.
Los 3 más importantes son:
- `Column`
- `Row`
- `Box`

### Column
Organiza elementos verticalmente
```kt
@Composable
fun EjemploColumn() {
    Column {
        Text("Nombre")
        Text("Apellido")
        Button(onClick = {}) {
            Text("Guardar")
        }
    }
}
```
> Resultado
> - Nombre
> - Apellido
> - Botón
> Uno detrás de otro

### Row
Organiza elementos horizontalmente
```kt
@Composable
fun EjemploRow() {
    Row {
        Text("Inicio")
        Text("Perfil")
        Text("Configuración")
    }
}
```
> Resultado
> Inicio | Perfil | Configuración

### Box
Permite poner elementos encima de otros
```kt
@Composable
fun EjemploBox() {
    Box {
        Text("Fondo")
        Button(onClick = {}) {
            Text("Botón")
        }
    }
}
```
> Muy usado para:
> - overlays
> - badges
> - imágenes con texto
> - pantallas completas

### Alineación
**En column**
```kt
Column(
    horizontalAlignment = Alignment.CenterHorizontally
) {
    Text("Hola")
}
```
**En row**
```kt
Row(
    verticalAlignment = Alignment.CenterVertically
) {
    Text("Hola")
}
```
### Espaciado
***Arrangement**
```kt
Column(
    verticalArrangement = Arrangement.SpaceEvenly
)
```
> Opciones comunes
> - `SpaceBetween`
> - `SpaceAround`
> - `Center`
> - `SpaceEvenly`

### Ejemplo completo
```kt
@Composable
fun Perfil() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("Juan Pérez")

        Row {
            Button(onClick = {}) {
                Text("Seguir")
            }

            Button(onClick = {}) {
                Text("Mensaje")
            }
        }
    }
}
```
### Concepto importante
Los layouts pueden anidarse:
```kt
Column {
    Row {

    }

    Box {

    }
}
```
Asi se construyen interfaces complejas

---
```kt
```
