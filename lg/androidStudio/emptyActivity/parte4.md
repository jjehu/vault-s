> [!IMPORTANT]
> Para almacenar datos de forma permanete se realiza mediante alguno de estos métodos según el tipo de necesidades:
> - Mediante la clase SharedPreferences.
> - Mediante archivos de Texto.
> - En una base de datos con acceso a SQL.

## Almacenamiento de datos mediante la clase SharedPreferences
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

## Almacenamiento de datos en un archivo de texto en la memoria interna
```kt
```
## Almacenamiento de datos en un archivo de texto localizado en una tarjeta SD
```kt
```
## Almacenamiento en una base de datos SQLite
```kt
```
