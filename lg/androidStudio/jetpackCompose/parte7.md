# Navegación en Jetpack Compose
Ahora aprenderás a moverte entre pantallas 🚀 (como Login → Home → Detalle).

***🧱 ¿Qué usamos para navegar?***\
Jetpack Compose usa:
- NavController
- NavHost
👉 Esto viene de la librería Navigation Compose

## ⚙️ Paso 1: Dependencia
En tu build.gradle:
```xml
implementation("androidx.navigation:navigation-compose:2.7.7")
```
## 🧠 Concepto clave
- NavController → controla la navegación
- NavHost → define las pantallas
- route → nombre de cada pantalla

---

## 🚀 Ejemplo básico
```kt
@Composable
fun AppNavegacion() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

        composable("home") {
            PantallaHome(navController)
        }

        composable("detalle") {
            PantallaDetalle()
        }
    }
}
```
## 🏠 Pantalla Home
```kt
@Composable
fun PantallaHome(navController: NavController) {

    Button(onClick = {
        navController.navigate("detalle") // 👉 navegar
    }) {
        Text("Ir a detalle")
    }
}
```
## 📄 Pantalla Detalle
```kt
@Composable
fun PantallaDetalle() {

    Text("Pantalla de detalle")
}
```
## 🔙 Volver atrás
```kt
navController.popBackStack()
```
Ejemplo:
```kt
Button(onClick = {
    navController.popBackStack()
}) {
    Text("Volver")
}
```
## 📦 Pasar datos entre pantallas
```kt
navController.navigate("detalle/Juan")
NavHost:

composable("detalle/{nombre}") { backStackEntry ->

    val nombre = backStackEntry.arguments?.getString("nombre")

    Text("Hola $nombre")
}
```
***🧠 Flujo mental***
1. Defines rutas
2. Navegas con navigate()
3. Recibes datos en la otra pantalla

> [!TIP]
> ***⚠️ Buenas prácticas***\
> ✔ Usa rutas claras ("home", "login", etc.)\
> ✔ Centraliza navegación si la app crece\
> ✔ No pongas lógica pesada en composables

***📌 Resumen***\
- NavController maneja navegación
- NavHost define pantallas
- Puedes navegar y pasar datos
- popBackStack() vuelve atrás
