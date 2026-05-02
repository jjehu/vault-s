# Controles

No siempre es necesario usar múltiples contenedores, pero este es un ejemplo común de estructura base:
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
        android:orientation="vertical"
        android:gravity="center">

        <!-- Componentes o elementos a agregar -->

    </LinearLayout>

</androidx.constraintlayout.widget.ConstraintLayout>
```

> [!NOTE]
> - `LinearLayout` se utiliza para aplicar estilos y organizar los elementos que se encuentran en su interior.
> - `android:layout_width="match_parent"` hace que el layout ocupe todo el ancho disponible.
> - `android:layout_height="wrap_content"` ajusta la altura del layout al tamaño del contenido.
> - `android:orientation="vertical"` alinea los elementos de forma vertical.
> - `android:gravity="center"` centra los elementos horizontal y verticalmente.

`MainActivity`
```kt
package com.example.brood

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        // Aquí va la lógica de la aplicación
    }
}
```
> [!NOTE]
> - `setContentView(R.layout.activity_main)` inicializa la actividad.
> - `super.onCreate(savedInstanceState)` carga el layout XML en pantalla.

## Layout de texto (TextView)
Permite mostrar texto en pantalla:
```xml
<TextView
    android:id="@+id/textoMensaje"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Hola mundo" /> <!-- se asigna un texto -->
```
> [!IMPORTANT]
> `android:id` es necesario para identificar el elemento y poder manipularlo desde Kotlin.

Uso en kotlin:
`MainActivity.kt`
```kt
val mensaje=findViewById<TextView>(R.id.textoMensaje) // identificacion del elemento de tipo TextView con el id textoMensaje
mensaje.text = "Hola mundo" // Asignación de un mensaje desde la lógica
```

## Captura de texto (EditText)
El elemento `EditText` nos permite ingresar datos desde el teclado.
```xml
<EditText
    android:id="@+id/numero1"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_margin="10dp"
    android:hint="Ingrese el primer valor"
    android:inputType="number" />
```
> [!NOTE]
> - `android:hint` muestra un texto de ayuda.
> - `android:inputType="number"` restringe la entrada a números.

Uso en kotlin:
```kt
val num1=findViewById<EditText>(R.id.numero1) // No olvidar poner el id y tipo de elemento
val numero1 = num1.text.toString().toIntOrNull() // Se puede almacenar en una variable el dato ingresado
```
> [!IMPORTANT]
> Es necesario convertir `.text` a `String`.
> `toIntOrNull()` evita errores si el usuario no ingresa un número válido.

## Button
El `Button` nos permite realizar acciones cuando sea presionado.
```xml
<Button
    android:id="@+id/accion"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_margin="10dp"
    android:text="Operar" />
```
Uso en kotlin:
```kt
val botonAccion = findViewById<Button>(R.id.accion)

botonAccion.setOnClickListener {
    // Lógica al presionar el botón
}
```

## RadioGroup y RadioButton
El `RadioGroup` agrupa un grupo de `RadioButton`. Los `RadioButton` nos permite seleccionar un opcion entre varias.
```xml
<RadioGroup
    android:id="@+id/grupo1"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:orientation="horizontal">

    <RadioButton
        android:id="@+id/operacionSuma"
        android:text="Sumar"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />

    <RadioButton
        android:id="@+id/operacionResta"
        android:text="Restar"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />

</RadioGroup>
```
Uso en kotlin:    
```kt
val sumar = findViewById<RadioButton>(R.id.operacionSuma)
val restar = findViewById<RadioButton>(R.id.operacionResta)

if (sumar.isChecked) {
    mensaje.text = "Resultado: ${numero1!! + numero2!!}"
}else if (restar.isChecked) {
    mensaje.text = "Resultado: ${numero1!! - numero2!!}"
}
```

## CheckBox
Permite seleccionar múltiples opciones:
```xml
<CheckBox
    android:id="@+id/check1"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Opción 1" />
```
Uso en Kotlin:
```kt
val check = findViewById<CheckBox>(R.id.check1)

if (check.isChecked) {
    mensaje.text = "Opción seleccionada"
}
```
## Spinner
Lista desplegable de opciones:
```xml
<Spinner
    android:id="@+id/spinnerOpciones"
    android:layout_width="match_parent"
    android:layout_height="wrap_content" />
```
Uso en Kotlin:
```kt
val spinner = findViewById<Spinner>(R.id.spinnerOpciones)

val opciones = arrayOf("Opción 1", "Opción 2", "Opción 3")
val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, opciones)

spinner.adapter = adapter
```
---
**ejemplo:**
```kt
val spinner=findViewById<Spinner>(R.id.spinner)
val lista = arrayOf("sumar", "restar", "multiplicar", "dividir")
val adaptador1 = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lista)
spinner.adapter = adaptador1

button.setOnClickListener {
            when (spinner.selectedItem.toString()) {
                "sumar" -> tv1.text = "Resultado: ${et1.text.toString().toInt() + et2.text.toString().toInt()}"
                "restar" -> tv1.text = "Resultado: ${et1.text.toString().toInt() - et2.text.toString().toInt()}"
                "multiplicar" -> tv1.text = "Resultado: ${et1.text.toString().toInt() * et2.text.toString().toInt()}"
                "dividir" -> tv1.text = "Resultado: ${et1.text.toString().toInt() / et2.text.toString().toInt()}"
            }
}
```
> [!NOTE]
> - **1linea** - ubicamos el spinner por id
> - **2linea** - definimos un vector con la lista de String que mostrará el Spinner
> - **3linea** - definimos y creamos un objeto de la clase ArrayAdapter. Al constructor le pasamos como primer parámetro la referencia de nuestro MainActivity (this), el segundo parámetro indica el tipo de Spinner, pudiendo ser las constantes
> `android.R.layout.simple_spinner_item`
> `android.R.layout.simple_spinner_dropdown_item`
> - El tercer parámetro es la referencia del vector que se mostrará.
> - **4linea** - le asignamos a la propiedad adapter del Spinner el objeto de la clase ArrayAdapter que acabamos de crear
> - **6linea...** - en la lambda registrada para el botón verificamos que item se encuentra seleccionada en el Spinner y procedemos a efectuar la operación respectiva

## ListView (con un lista de String)
Permite mostrar listas de elementos:
```xml
<ListView
    android:id="@+id/lista"
    android:layout_width="match_parent"
    android:layout_height="wrap_content" />
```
Uso en Kotlin:
```kt
val lista = findViewById<ListView>(R.id.lista)

val datos = arrayOf("Elemento 1", "Elemento 2", "Elemento 3")
val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, datos)

lista.adapter = adapter
```
---
**ejemplo:**
```kt
val list1=findViewById<ListView>(R.id.list1)
val paises = arrayOf( "Argentina", "Chile", "Paraguay", "Bolivia", "Peru", "Ecuador", "Brasil", "Colombia", "Venezuela", "Uruguay")
var habitantes = arrayOf(40_000_000, 17_000_000, 6_500_000, 10_000_000, 30_000_000, 14_000_000, 183_000_000, 44_000_000, 31_000_000, 3_500_000)
val adaptador1 = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, paises)
list1.adapter = adaptador1
list1.setOnItemClickListener { adapterView, view, i, l ->
tv1.text = "Población de: ${habitantes[i]}"
}
```
> [!NOTE]
> - **1linea** - ubicamos la lista mediante el id
> - **2-3linea** - definimos dos arreglos paralelos donde almacenamos en uno los nombres de países y en el otro almacenamos la cantidad de habitantes de dichos países
> - **4-5linea** - creamos un objeto de la clase ArrayAdapter de forma similar a como lo hicimos cuando vimos la clase Spinner y lo enlazamos con el ListView
> - **6linea** - llamamos al método setOnItemClicListener de la clase ListView y le pasamos como parámetro una lambda que se ejecutará cada vez que el usuario seleccione un item del ListView


## ImageButton
Botón con imagen:
```xml
<ImageButton
    android:id="@+id/botonImagen"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:src="@android:drawable/ic_menu_camera" />
```
Uso en Kotlin:
```kt
val imgBtn = findViewById<ImageButton>(R.id.botonImagen)

imgBtn.setOnClickListener {
    mensaje.text = "Imagen presionada"
}
```
> [!TIP]
> - imagen en formato jpg de 50 por 50 píxeles
> - MyAplication/app/src/main/res/mipmap-mdpi
> - En la ventana "Project" cambiamos a vista "Project Files" y navegamos hasta la carpeta donde copiamos el archivo

> [!NOTE]
> - hay otras carpetas con nombres similares donde se puede guardar el archivo:
> - mipmap-mdpi - (guardamos la imagen con el tamaño original)
> - mipmap-hdpi - (guardamos la imagen con el tamaño del 150% con respecto al de la carpeta mipmap-mdpi)
> - mipmap-xhdpi - (guardamos la imagen con el tamaño del 200% con respecto al de la carpeta mipmap-mdpi)
> - mipmap-xxhdpi - (guardamos la imagen con el tamaño del 300% con respecto al de la carpeta mipmap-mdpi)
> - mipmap-xxxhdpi - (guardamos la imagen con el tamaño del 400% con respecto al de la carpeta mipmap-mdpi)
> - mipmap-anydpi-v26
