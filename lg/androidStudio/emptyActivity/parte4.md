> [!IMPORTANT]
> Para almacenar datos de forma permanete se realiza mediante alguno de estos métodos según el tipo de necesidades:
> - Mediante la clase SharedPreferences.
> - Mediante archivos de Texto.
> - En una base de datos con acceso a SQL.

# Almacenamiento de datos mediante la clase SharedPreferences
```kt
val num1=findViewById<EditText>(R.id.numero1)
val num2=findViewById<EditText>(R.id.numero2)
val mensaje=findViewById<TextView>(R.id.textoMensaje)
val botonGuardar=findViewById<Button>(R.id.guardar)

val preferencias = getSharedPreferences("historial", Context.MODE_PRIVATE)
num1.setText(preferencias.getInt("num1", 0).toString())
num2.setText(preferencias.getInt("num2", 0).toString())
mensaje.setText(preferencias.getString("mensaje", ""))
botonGuardar.setOnClickListener {
  val editor = preferencias.edit()
  val numero1 = num1.text.toString().toIntOrNull()
  val numero2 = num2.text.toString().toIntOrNull()
  if (numero1!=null && numero2!=null) {
    editor.putInt("num1", numero1)
    editor.putInt("num2", numero2)
    editor.putString("mensaje", mensaje.text.toString())
    editor.commit()
    finish()
    }else
      Toast.makeText(this, "Existen campos vacios. No se guardo la operacion.", Toast.LENGTH_SHORT).show()
}
```
> [!NOTE]
> **Referencia**
> ```kt
> val preferencias = getSharedPreferences("historial", Context.MODE_PRIVATE)
> ```
> - `preferencias` Se accede a un archivo llamado "datos" guardado en el dispositivo.
> - `MODE_PRIVATE` significa que solo esta aplicación puede leer esa información.
> 
> **Recuperar datos al abrir la app**
> ```kt
> num1.setText(preferencias.getInt("num1", 0).toString())
> num2.setText(preferencias.getInt("num2", 0).toString())
> mensaje.setText(preferencias.getString("mensaje", ""))
> ```
> - Estas lineas obtienen los datos previamente guardados en "preferencias" que es una referencia al archivo "historial".
> - Para la primera linea, `getInt` busca dentro del archivo la etiqueta "num1" y se optiene su valor entero que en caso de no existir ingresa `0`, todo esto se convierte en String y se asigna al `EditText` mediante `num1.setText`.
> 
> **Guardar los datos (al presionar el botón)**
> ```kt
> val editor = preferencias.edit()
> val numero1 = num1.text.toString().toIntOrNull()
> val numero2 = num2.text.toString().toIntOrNull()
> if (numero1!=null && numero2!=null) {
>   editor.putInt("num1", numero1)
>   editor.putInt("num2", numero2)
>   editor.putString("mensaje", mensaje.text.toString())
>   editor.commit()
>   finish()
> }
> ```
> - `preferencias.edit()`: Para modificar las SharedPreferences, se necesita un objeto "Editor". Es como abrir el archivo en modo edición.
> - `putInt(...)`: Le dice al editor: "Guarda lo que el usuario escribió en num1 o num2 (EditText) bajo la etiqueta 'num1' o 'num2'".
> - `putString(...)`: Le dice al editor: "Guarda lo que el usuario escribió en mensaje bajo la etiqueta 'mensaje'".
> - `commit()`: Esta es la orden final para grabar los cambios en el disco de forma inmediata. Sin esto, nada se guarda.
> - `finish()`: Cierra la aplicación (la quita de la pantalla).

> [!TIP]
> Cuando guardamos datos en el archivo de preferencias podemos almacenar distintos tipos de datos según el método que llamemos en el momento de grabar:
> ```kt
> editor.putInt("edad",3)
> editor.putBoolean("activo", true)
> editor.putFloat("altura", 2.3f)
> ```
> Cuando los recuperamos debemos indicar también que tipo de datos extraemos:
> ```kt
> val e = preferencias.getInt("edad", 0)
> val acti = preferencias.getBoolean("activo", false)
> val alt = preferencias.getFloat("altura", 0f)
> ```

# Almacenamiento de datos en un archivo de texto en la memoria interna
## 📂 Almacenamiento en Memoria Interna
La memoria interna es un espacio privado de tu aplicación. Ninguna otra app puede acceder a estos archivos y se borran si el usuario desinstala la aplicación.

### 1. Escribir datos (Grabar)
Para guardar información, se utiliza la clase `OutputStreamWriter`.

*   **Función clave:** `openFileOutput("nombre.txt", Activity.MODE_PRIVATE)`
*   **Modo:** `MODE_PRIVATE` asegura que solo tu app lea el archivo y que, si ya existe, se sobrescriba.
*   **Modo:** `MODE_APPEND` agrega contenido al archivo y no se sobreescriba.

```kotlin
try {
    val archivo = OutputStreamWriter(openFileOutput("notas.txt", Activity.MODE_PRIVATE))
    archivo.write(et1.text.toString()) // Escribe el contenido
    archivo.flush() // Asegura que se escriban todos los datos
    archivo.close()
} catch (e: IOException) {
    // Manejo de errores
}
```

### 2. Leer datos (Recuperar)
Para leer, usamos `InputStreamReader` combinado con `BufferedReader` para procesar el texto línea por línea.

*   **Verificación:** Es vital usar `fileList().contains("nombre.txt")` para no intentar abrir algo que no existe.

```kotlin
if (fileList().contains("notas.txt")) {
    try {
        val archivo = InputStreamReader(openFileInput("notas.txt"))
        val br = BufferedReader(archivo)
        val todo = StringBuilder()
        var linea = br.readLine()
        
        while (linea != null) {
            todo.append(linea + "\n")
            linea = br.readLine()
        }
        br.close()
        archivo.close()
        et1.setText(todo) // Muestra el texto en la interfaz
    } catch (e: IOException) {}
}
```

## 🛠️ Casos Prácticos

### Proyecto A: Bloc de Notas Simple
*   **Interfaz:** Un `EditText` (Multiline) y un `Button`.
*   **Lógica:** Al abrir la app (`onCreate`), se busca el archivo. Si existe, se carga el texto automáticamente. Al presionar el botón, se guarda lo escrito y se cierra la app.

### Proyecto B: Agenda por Fechas
*   **Interfaz:** Un `EditText` de tipo **Date**, un `EditText` para notas y dos botones (Grabar/Recuperar).
*   **Regla de Oro:** Los nombres de archivos no aceptan el carácter `/`. Por eso, al usar fechas, debemos reemplazar las barras por guiones:
    `val nombre = etFecha.text.toString().replace('/', '-')`

---

> [!TIP]
> Tips de Diseño en Android Studio
> 1.  **Multiline Text:** Usa un `EditText` con la propiedad `inputType="textMultiLine"`.
> 2.  **Gravedad:** Para que el texto empiece arriba a la izquierda (y no centrado), busca la propiedad `gravity` y marca `top` y `left`.
> 3.  **Color de fondo:** Propiedad `background`. Puedes usar hexadecimales como `#ffff00` (amarillo).

> [!IMPORTANT]
> **Recuerda:** Siempre envuelve las operaciones de lectura/escritura en bloques `try-catch` para evitar que la aplicación se detenga si ocurre un error de entrada/salida (IOException).

# Almacenamiento de datos en un archivo de texto localizado en una tarjeta SD
## 💾 Almacenamiento en Tarjeta SD
A diferencia de la memoria interna, el almacenamiento externo permite guardar archivos con mayor capacidad y facilita compartirlos. Sin embargo, requiere permisos específicos y no todos los dispositivos cuentan con ella.

### 1. Configuración de Permisos
Antes de programar, debes declarar que tu app usará el almacenamiento en el archivo `AndroidManifest.xml`:

```xml
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
```
*Agrégalo fuera de la etiqueta `<application>` pero dentro de `<manifest>`.*

---

### 2. Escritura de Datos (Grabar)
Para guardar, primero obtenemos la ruta de la tarjeta SD y luego creamos el flujo de escritura.



```kotlin
boton1.setOnClickListener {
    try {
        // Obtenemos la ruta de la carpeta de archivos externos
        val tarjeta = getExternalFilesDir(null)
        // Creamos la referencia al archivo con el nombre indicado en et1
        val file = File(tarjeta?.absolutePath, et1.text.toString())
        
        val osw = OutputStreamWriter(FileOutputStream(file))
        osw.write(et2.text.toString()) // Escribimos el contenido de et2
        osw.flush()
        osw.close()
        
        Toast.makeText(this, "Guardado en SD", Toast.LENGTH_SHORT).show()
    } catch (e: IOException) {
        Toast.makeText(this, "Error al grabar", Toast.LENGTH_SHORT).show()
    }
}
```

---

### 3. Lectura de Datos (Recuperar)
Para leer, usamos `FileInputStream` para acceder al archivo físico en la SD.

```kotlin
boton2.setOnClickListener {
    val tarjeta = getExternalFilesDir(null)
    val file = File(tarjeta?.absolutePath, et1.text.toString())
    
    try {
        val fIn = FileInputStream(file)
        val archivo = InputStreamReader(fIn)
        val br = BufferedReader(archivo)
        
        val contenido = br.readLines().joinToString("\n") // Forma rápida de leer todo
        
        br.close()
        archivo.close()
        et2.setText(contenido)
    } catch (e: IOException) {
        Toast.makeText(this, "No se pudo leer", Toast.LENGTH_SHORT).show()
    }
}
```

---

## ⚠️ Nota Importante sobre Emuladores
Si el emulador por defecto (como el Pixel 3) no soporta tarjeta SD, el programa fallará. Para solucionarlo:
1. Ve a **AVD Manager** en Android Studio.
2. Crea un nuevo dispositivo (ej. un teléfono genérico).
3. En **Advanced Settings**, asegúrate de que la opción **SD Card** tenga asignado espacio (ej. 512 MB).

### Resumen de Claves:
*   **`getExternalFilesDir(null)`**: Obtiene la ruta de la SD vinculada a tu app.
*   **`File(ruta, nombre)`**: Une la carpeta y el nombre del archivo.
*   **`try-catch`**: Imprescindible para evitar cierres inesperados si la SD no está disponible.

# Almacenamiento en una base de datos SQLite
SQLite es la base de datos nativa para almacenar datos estructurados de forma persistente.

## 1. La Clase Administradora (`SQLiteOpenHelper`)
Para trabajar con SQLite, primero necesitas una clase que gestione la creación y actualización de la base de datos.

*   **`onCreate`**: Se ejecuta una sola vez para crear las tablas.
*   **`onUpgrade`**: Se usa si decides cambiar la estructura de la tabla más adelante.

## 🗄️ 2. Crear la base de datos (SQLiteOpenHelper)

Creamos una clase que gestione la base de datos.

📄 `DatabaseHelper.kt`

```kotlin
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

// Clase que hereda de SQLiteOpenHelper para manejar la base de datos
class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, "mi_base.db", null, 1) {

    // Se ejecuta SOLO cuando la base de datos se crea por primera vez
    override fun onCreate(db: SQLiteDatabase) {
        // SQL para crear una tabla
        val createTable = """
            CREATE TABLE usuarios (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nombre TEXT,
                edad INTEGER
            )
        """.trimIndent()

        db.execSQL(createTable) 
        // Ejecuta la sentencia SQL en la base de datos
    }

    // Se ejecuta cuando cambias la versión de la DB (version = 1 → 2, etc.)
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS usuarios")
        // Borra la tabla si existe

        onCreate(db)
        // Vuelve a crear la base de datos
    }
}
```

---

## 🧠 3. Operaciones CRUD (Crear, Leer, etc.)

Agregamos funciones dentro de la misma clase:

```kotlin
import android.content.ContentValues

// Insertar un usuario
fun insertarUsuario(nombre: String, edad: Int): Long {
    val db = writableDatabase 
    // Abre la base de datos en modo escritura

    val values = ContentValues()
    // Estructura tipo mapa clave-valor

    values.put("nombre", nombre)
    // Inserta el nombre

    values.put("edad", edad)
    // Inserta la edad

    return db.insert("usuarios", null, values)
    // Inserta en la tabla y devuelve el ID generado
}
```

---

```kotlin
// Obtener todos los usuarios
fun obtenerUsuarios(): List<String> {
    val lista = mutableListOf<String>()

    val db = readableDatabase
    // Abre la base de datos en modo lectura

    val cursor = db.rawQuery("SELECT * FROM usuarios", null)
    // Ejecuta consulta SQL

    if (cursor.moveToFirst()) {
        do {
            val nombre = cursor.getString(1)
            // Columna 1 = nombre

            val edad = cursor.getInt(2)
            // Columna 2 = edad

            lista.add("$nombre - $edad")
            // Agrega al listado
        } while (cursor.moveToNext())
    }

    cursor.close()
    // Cierra el cursor para evitar fugas de memoria

    return lista
}
```

---

## 📱 4. Usar la base de datos en la Activity

📄 `MainActivity.kt`

```kotlin
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var dbHelper: DatabaseHelper
    // Variable que contendrá la base de datos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dbHelper = DatabaseHelper(this)
        // Inicializa la base de datos

        val btnInsertar = findViewById<Button>(R.id.btnInsertar)
        val btnMostrar = findViewById<Button>(R.id.btnMostrar)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)

        btnInsertar.setOnClickListener {
            dbHelper.insertarUsuario("Juan", 25)
            // Inserta un usuario de prueba
        }

        btnMostrar.setOnClickListener {
            val usuarios = dbHelper.obtenerUsuarios()
            // Obtiene la lista de usuarios

            txtResultado.text = usuarios.joinToString("\n")
            // Muestra los usuarios en pantalla
        }
    }
}
```

---

## 🧾 5. Layout básico

📄 `activity_main.xml`

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical"
    android:padding="16dp"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <Button
        android:id="@+id/btnInsertar"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Insertar usuario"/>

    <Button
        android:id="@+id/btnMostrar"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Mostrar usuarios"/>

    <TextView
        android:id="@+id/txtResultado"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Resultados"/>
</LinearLayout>
```

---

## 🧩 Conceptos clave (muy importante)

* **SQLite**: base de datos local dentro del dispositivo
* **SQLiteOpenHelper**: clase que gestiona creación y versión
* **Cursor**: resultado de una consulta
* **ContentValues**: estructura para insertar datos
* **writableDatabase / readableDatabase**: modos de acceso

---

## 🚀 Siguientes pasos (si quieres avanzar)

Una vez domines esto, te recomiendo aprender:

* Uso de **Room (recomendado por Google)** en lugar de SQLite directo
* RecyclerView para mostrar datos
* Arquitectura MVVM

