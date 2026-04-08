# Controles

No siempre es necesario esto:
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
> `LinearLayout` se utiliza para aplicar estilos y organizar los elementos que se encuentran en su interior.
> 
> `android:layout_width="match_parent"` hace que el layout ocupe todo el ancho disponible.
> 
> `android:layout_height="wrap_content"` ajusta la altura del layout al tamaño del contenido.
>
> `android:orientation="vertical"` hace que los elementos de su interior esten aliniados de forma vertical.
> 
> `android:gravity="center"` centra los elementos, de forma horizontal y vertical.

```kt
package com.example.brood

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        // aqui va el codigo
    }
}
```
> [!NOTE]
> `setContentView(R.layout.activity_main)` crea la vista.
> 
> `super.onCreate(savedInstanceState)` crea la pantalla.

## Layout de texto
Nos permite mostrar un texto
```xml
<TextView
            android:id="@+id/textoMensaje"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Hola mundo" <!-- se asigna un texto -->
            />
```
> [!IMPORTANT]
> `android:id="@+id/textoMensaje"` es necesario asignarle un id para identificar el elemento y trabajar con el en la parte de logica.

`MainActivity.kt`
```kt
  val mensaje=findViewById<TextView>(R.id.textoMensaje) // identificacion del elemento de tipo TextView con el id textoMensaje
  mensaje.text = "Hola mundo" // Asignación de un mensaje desde la lógica
```

## Captura de texto
El elemento `EditText` nos permite capturar texto ingresado desde el teclado
```xml
<EditText
            android:id="@+id/numero1"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_margin="10dp"
            android:hint="Ingrese el primer valor" <!-- EditText nos permite tener como un mensaje mediante hint -->
            android:inputType="number" /> <!-- En este caso solo permitira que se ingresen numeros de tipo entero -->
```
> [!NOTE]
> Ademas de `number` existe otros tipos de datos
```kt
val num1=findViewById<EditText>(R.id.numero1) // No olvidar poner el id y tipo de elemento
val numero1 = num1.text.toString().toIntOrNull() // Se puede almacenar en una variable el dato ingresado
```
> [!IMPORTANT]
> `val numero1 = num1.text.toString().toIntOrNull()` es importante convertir el .text a un String ya que nos generaria error. El .toIntOrNull() es en caso de que no se agrege un dato de tipo Int se convertira en uno de tipo Null.

## Button
El `Button` nos permite realizar acciones cuando se presiona a este.
```xml
<Button
            android:id="@+id/accion"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_margin="10dp"
            android:text="Operar" />
```
```kt
val botonAccion=findViewById<Button>(R.id.accion)
botonAccion.setOnClickListener {
  // aqui realizamos la logica en caso de que botonAccion sea presionado
}
```

## RadioGroup
El `RadioGroup` agrupa un grupo de `RadioButton`
```xml
<RadioGroup
            android:id="@+id/grupo1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:orientation="horizontal"> <!-- En este caso se orienta de forma horizontal -->

            <!-- Aqui se ingresa los RadioButton -->
</RadioGroup>
```

## RadioButton
Los `RadioButton` nos permite seleccionar un opcion entre varias
```xml
<RadioButton
                android:id="@+id/operacionSuma"
                android:text="Sumar"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_margin="3dp"/>
```
```kt
val sumar=findViewById<RadioButton>(R.id.operacionSuma)
if (sumar.isChecked) // Si el boton sumar esta selecionado
  mensaje.text = "Resultado: ${numero1 + numero2}"
```

## CheckBox
## Spinner
## ListView
## ImageButton
