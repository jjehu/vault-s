# Testing en Jetpack Compose + Buenas prácticas
Ya estás en nivel avanzado 🔥\
Ahora veremos cómo asegurar calidad en tu app.

***🧠 ¿Por qué hacer testing?***\
✔ Detectar errores\
✔ Evitar romper cosas al cambiar código\
✔ Apps más confiables

## 🧱 Tipos de testing en Compose
1. Unit Test → lógica (ViewModel)
2. UI Test → interfaz (Compose)

## 🔬 UI Testing en Compose
Compose tiene su propio sistema de testing.

## ✅ Ejemplo básico
```kt
@get:Rule
val composeTestRule = createComposeRule()

@Test
fun testTextoVisible() {

    composeTestRule.setContent {
        Text("Hola Mundo")
    }

    composeTestRule
        .onNodeWithText("Hola Mundo")
        .assertIsDisplayed()
}
```
## 🔍 Explicación
```kt
createComposeRule()
```
👉 Inicializa entorno de testing
```kt
setContent { }
```
👉 Renderiza UI para test
```kt
onNodeWithText("Hola Mundo")
```
👉 Busca el componente
```kt
assertIsDisplayed()
```
👉 Verifica que esté en pantalla

## 🎯 Test con interacción
```kt
@Test
fun testClickBoton() {

    composeTestRule.setContent {

        var count by remember { mutableStateOf(0) }

        Button(onClick = { count++ }) {
            Text("Clicks: $count")
        }
    }

    composeTestRule
        .onNodeWithText("Clicks: 0")
        .performClick()

    composeTestRule
        .onNodeWithText("Clicks: 1")
        .assertExists()
}
```
## 🧠 Testing del ViewModel
```kt
@Test
fun testIncrementar() {

    val vm = MiViewModel()

    vm.incrementar()

    assert(vm.contador == 1)
}
```
***⚠️ Buenas prácticas de testing***\
✔ Tests pequeños y claros\
✔ Probar lógica crítica\
✔ No testear TODO (enfócate en lo importante)

## 🧠 Buenas prácticas generales (MUY IMPORTANTES)
***🧩 Arquitectura***\
✔ Usa MVVM\
✔ Usa StateFlow\
✔ Separa UI / lógica

***🎨 UI***\
✔ Usa MaterialTheme\
✔ Componentes reutilizables\
✔ Evita código duplicado

***⚡ Rendimiento***\
✔ Usa LazyColumn para listas\
✔ Evita recomposición innecesaria\
✔ Mantén composables pequeños

***🧼 Código limpio***\
✔ Nombres claros\
✔ Funciones simples\
✔ Divide en archivos

***🚀 Proyecto final (reto)***\
Te dejo un reto para consolidar todo:

👉 Crear una app con:

- Lista de usuarios (API)
- Navegación a detalle
- ViewModel + StateFlow
- UI con Material 3
- Animaciones básicas

