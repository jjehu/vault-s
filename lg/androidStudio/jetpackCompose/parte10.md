# Consumo de APIs con Retrofit + Compose
Ahora entramos a algo muy importante en apps reales: obtener datos de internet 🚀

***🧠 ¿Qué es Retrofit?***\
Es una librería para hacer peticiones HTTP (APIs REST).

👉 Ejemplo: obtener usuarios, productos, posts, etc.

## ⚙️ Paso 1: Dependencias
En tu build.gradle:
```kt
implementation("com.squareup.retrofit2:retrofit:2.9.0")
implementation("com.squareup.retrofit2:converter-gson:2.9.0")
```
## 🧱 Paso 2: Crear modelo (data class)
Ejemplo de API:
```json
{
  "id": 1,
  "name": "Juan"
}
```
👉 Lo representamos así:
```kt
data class Usuario(
    val id: Int,
    val name: String
)
```
## 🔌 Paso 3: Crear interfaz API
```kt
interface ApiService {

    @GET("users")
    suspend fun obtenerUsuarios(): List<Usuario>
}
```
## 🌍 Paso 4: Crear Retrofit
```kt
object RetrofitInstance {

    val api: ApiService by lazy {

        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}
```
## 🧠 Paso 5: ViewModel (con StateFlow)
```kt
class UsuarioViewModel : ViewModel() {

    private val _usuarios = MutableStateFlow<List<Usuario>>(emptyList())
    val usuarios: StateFlow<List<Usuario>> = _usuarios

    init {
        cargarUsuarios()
    }

    private fun cargarUsuarios() {

        viewModelScope.launch {

            try {
                val respuesta = RetrofitInstance.api.obtenerUsuarios()

                _usuarios.value = respuesta

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
```
## 👁️ Paso 6: UI en Compose
```kt
@Composable
fun PantallaUsuarios(viewModel: UsuarioViewModel = viewModel()) {

    val usuarios by viewModel.usuarios.collectAsState()

    LazyColumn {

        items(usuarios) { usuario ->

            Text(
                text = usuario.name,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}
```
***🔄 Flujo completo***
1. ViewModel inicia
2. Llama API (Retrofit)
3. Recibe datos
4. Actualiza StateFlow
5. UI observa cambios
6. Lista se renderiza

***⚠️ Buenas prácticas***\
✔ Llamadas en viewModelScope\
✔ Manejar errores (try/catch)\
✔ Usar StateFlow\
✔ Separar capas (API / ViewModel / UI)

💡 Tip PRO
Puedes agregar estado de carga:
```kt
data class UiState(
    val lista: List<Usuario> = emptyList(),
    val loading: Boolean = true
)
```
***📌 Resumen***
- Retrofit conecta con APIs
- ViewModel maneja datos
- StateFlow actualiza UI
- Compose renderiza automáticamente
