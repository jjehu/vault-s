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

## EJEMPLO
`activity_main.xml`
```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:gravity="center_horizontal"
        android:orientation="vertical"
        >
        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Nuevo producto"
            android:padding="10dp"
            android:textSize="23dp"
            android:background="#1E0747"
            android:textColor="@color/white"
            android:fontFamily="casual"
            />

        <EditText
            android:id="@+id/et1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:hint="Ingrese el código"
            android:padding="10dp"
            android:fontFamily="sans-serif-black"
            android:inputType="number"
            />

        <EditText
            android:id="@+id/et2"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:hint="Ingrese el nombre"
            android:padding="10dp"
            android:fontFamily="sans-serif-black"
            />
        <EditText
            android:id="@+id/et3"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:hint="Ingrese el precio"
            android:padding="10dp"
            android:fontFamily="sans-serif-black"
            android:inputType="numberDecimal"
            />
        <Button
            android:id="@+id/btn_agregar"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Agregar"
            android:backgroundTint="@color/black"
            android:textColor="@color/white"
            />
        <Button
            android:id="@+id/btn_consultarCodigo"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Consultar por código"
            android:backgroundTint="@color/black"
            android:textColor="@color/white"
            />
        <Button
            android:id="@+id/btn_consultarNombre"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Consultar por nombre"
            android:backgroundTint="@color/black"
            android:textColor="@color/white"
            />
        <Button
            android:id="@+id/btn_borrar"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Borrar por código"
            android:backgroundTint="@color/black"
            android:textColor="@color/white"
            />
        <Button
            android:id="@+id/btn_modificar"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Modificar"
            android:backgroundTint="@color/black"
            android:textColor="@color/white"
            />
        <ListView
            android:id="@+id/lista_presentada"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            />
    </LinearLayout>

</androidx.constraintlayout.widget.ConstraintLayout>
```
`DBHelper.kt`
```kt
package com.example.prueka

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.content.ContentValues
import kotlin.text.insert
import com.example.prueka.articulo

// Clase que hereda de SQLiteOpenHelper para manejar la base de datos
class DBHelper (context: Context): SQLiteOpenHelper(context, "mi_base.db", null, 1){
    //Se ejecuta SOLO cuando la base de datos se crea por primera vez
    override fun onCreate(db: SQLiteDatabase) {
        val createTable = """
            CREATE TABLE articulos (
            codigo INTEGER PRIMARY KEY,
            nombre TEXT,
            precio DECIMAL
            )
            """.trimIndent()
        // si se quiere que el codigo se genere automaticamente: id INTEGER PRIMARY KEY AUTOINCREMENT,
        db.execSQL(createTable)
        // Ejecuta la sentencia SQL en la base de datos
    }
    // Se ejecuta cuando cambias la versión de la DB (version = 1 → 2, etc.)
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS articulos")
        // Borra la tabla si existe
        onCreate(db)
        // Vuelve a crear la base de datos
    }

    // -----CRUD-----
    // Insertar un usuario
    fun insertarArticulo(cod: Int, nomb: String, prec: Float): Long {
        val db = writableDatabase // abre la base de datos en modo escritura
        val values = ContentValues() // Estructura tipo mapa clave-valor
        values.put("codigo", cod) // Insertar el codigo
        values.put("nombre", nomb) // Insertar el nombre
        values.put("precio", prec) // Insertar el precio

        return db.insert("articulos", null, values)
        // Insertar en la tabla y devuelve el codigo
    }


    // Obtener usuario por codigo
    //devuelve una lista de string
    fun obtener_porCodigo(cod: Int): List<String>{
        val lista = mutableListOf<String>()
        val db = readableDatabase // Abre la base de datos en modo lectura
        val cursor = db.rawQuery("SELECT * FROM articulos WHERE codigo = ?", arrayOf(cod.toString()))
        // Ejecuta consulta SQL
        if (cursor.moveToFirst()){
            do {
                val codigo = cursor.getString(0)
                val nombre = cursor.getString(1)
                val precio = cursor.getString(2)
                lista.add("$codigo - $nombre - $precio")
            }while (cursor.moveToNext())
        }
        cursor.close()// Cierra el cursor para evitar fugas de memoria
        return lista
    }
    //devuelve una lista de articulo (clase propia)
    fun obtener_porNombre(nom: String): List<articulo>{
        val lista = mutableListOf<articulo>()
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM articulos WHERE nombre = ?", arrayOf(nom))
        if (cursor.moveToFirst()){
            do {
                val codigo = cursor.getInt(0)
                val nombre = cursor.getString(1)
                val precio = cursor.getFloat(2)
                lista.add(articulo(codigo, nombre, precio))
            }while (cursor.moveToNext())
        }
        cursor.close()
        return lista
    }
    fun borrar(cod: Int): Int{
        val db = writableDatabase

        return db.delete(
            "articulos",
            "codigo = ?",
            arrayOf(cod.toString())
        )
    }
    fun modificar(cod: Int, nomb: String, prec: Float): Int {
        val db = writableDatabase
        val values = ContentValues()
        values.put("nombre", nomb)
        values.put("precio", prec)

        return db.update("articulos",
            values,
            "codigo = ?",
            arrayOf(cod.toString())
        )
    }
}
```
`MainActivity.kt`
```kt
package com.example.prueka

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Variable que contendrá la base de datos
    lateinit var dbHelper: DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val in_cod = findViewById<EditText>(R.id.et1)
        val in_nom = findViewById<EditText>(R.id.et2)
        val in_pre = findViewById<EditText>(R.id.et3)
        val btn_agr = findViewById<Button>(R.id.btn_agregar)
        val btn_cod = findViewById<Button>(R.id.btn_consultarCodigo)
        val btn_nom = findViewById<Button>(R.id.btn_consultarNombre)
        val btn_bor = findViewById<Button>(R.id.btn_borrar)
        val btn_mod = findViewById<Button>(R.id.btn_modificar)
        val list_pres = findViewById<ListView>(R.id.lista_presentada)

        // Inicializa la base de datos
        dbHelper = DBHelper(this)

        // Agregar
        btn_agr.setOnClickListener {
            val codigo = in_cod.text.toString().toIntOrNull()
            val nombre = in_nom.text.toString()
            val precio = in_pre.text.toString().toFloatOrNull()

            if (codigo!=null && nombre.isNotEmpty() && precio!=null){
                val res = dbHelper.insertarArticulo(codigo, nombre, precio)
                if (res != -1L){
                    Toast.makeText(this, "Articulo agregado a la base correctamente", Toast.LENGTH_SHORT).show()
                    in_cod.text.clear()
                    in_nom.text.clear()
                    in_pre.text.clear()
                }else
                    Toast.makeText(this, "Error, el código ya existe", Toast.LENGTH_SHORT).show()
            }else
                Toast.makeText(this, "Faltan campos a completar", Toast.LENGTH_SHORT).show()
        }
        // Buscar por codigo
        btn_cod.setOnClickListener {
            val codigo = in_cod.text.toString().toIntOrNull()
            if (codigo != null) {
                val lista = dbHelper.obtener_porCodigo(codigo)
                list_pres.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, lista)
            } else Toast.makeText(this, "Ingrese un código", Toast.LENGTH_SHORT).show()
        }
        // Buscar por nombre
        btn_nom.setOnClickListener {
            val nombre = in_nom.text.toString()
            if (nombre.isNotEmpty()) {
                val listaArticulos = dbHelper.obtener_porNombre(nombre)
                // Al usar la clase 'articulo' con toString(), el adaptador funciona directo
                list_pres.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaArticulos)
            } else Toast.makeText(this, "Ingrese nombre", Toast.LENGTH_SHORT).show()
        }
        // Borrar con el codigo
        btn_bor.setOnClickListener {
            val codigo = in_cod.text.toString().toIntOrNull()
            if (codigo != null) {
                val cant = dbHelper.borrar(codigo)
                in_cod.text.clear()
                if (cant > 0) Toast.makeText(this, "Eliminado", Toast.LENGTH_SHORT).show()
                else Toast.makeText(this, "No existe ese código", Toast.LENGTH_SHORT).show()
            } else Toast.makeText(this, "Ingrese código para borrar", Toast.LENGTH_SHORT).show()
        }
        // Modificar
        btn_mod.setOnClickListener {
            val codigo = in_cod.text.toString().toIntOrNull()
            val nombre = in_nom.text.toString()
            val precio = in_pre.text.toString().toFloatOrNull()

            if (codigo != null && nombre.isNotEmpty() && precio != null) {
                val cant = dbHelper.modificar(codigo, nombre, precio)
                if (cant > 0) Toast.makeText(this, "Modificado con éxito", Toast.LENGTH_SHORT).show()
                else Toast.makeText(this, "No se encontró el código", Toast.LENGTH_SHORT).show()
            } else Toast.makeText(this, "Complete todos los campos para modificar", Toast.LENGTH_SHORT).show()
        }
    }
}
```

---
## 🚀 Siguientes pasos (si quieres avanzar)

Una vez domines esto, te recomiendo aprender:

* Uso de **Room (recomendado por Google)** en lugar de SQLite directo
* RecyclerView para mostrar datos
* Arquitectura MVVM

