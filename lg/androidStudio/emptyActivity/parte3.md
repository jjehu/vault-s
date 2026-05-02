# Toast (notificaciones sencillas)
Mostramos mediante la clase Toast un mensaje con el número
```xml
```
```kt
val et1=findViewById<EditText>(R.id.et1)
        val numero = (Math.random() * 100_001).toInt()
        Toast.makeText(this, "Número a recordar: ${numero}", Toast.LENGTH_LONG).show()
        val boton1=findViewById<Button>(R.id.button)
        boton1.setOnClickListener {
            if (numero == et1.text.toString().toInt())
                Toast.makeText(this, "Muy bien recordaste el número mostrado.", Toast.LENGTH_LONG).show()
            else
                Toast.makeText(this, "Lo siento pero no es el número que mostré.", Toast.LENGTH_LONG).show()
        }
```
Se llama al método estático makeText de la clase Toast. A partir del objeto devuelto llamamos al método show.
```kt
Toast.makeText(this, "Número a recordar: ${numero}", Toast.LENGTH_LONG).show()
```
El método makeText tiene tres parámetros: el primero hace referencia a la ventana o Activity donde aparece (this), el segundo es un String que se mostrará en pantalla y por último es una constante que indica que la notificación se mostrará por un tiempo largo o corto.

# Lanzar un segundo "Activity"

Para esto hacemos clic con el botón derecho del mouse en la ventana de Project donde dice "app" y seleccionamos New -> Activity -> Empty Activity
Aparece un diálogo donde debemos definir el nombre del Activity "Activity Name" y le asignaremos como nombre "AcercaDe" (se crearán dos archivos AcercaDe.kt y activity_acerca_de.xml).

Creamos un objeto de la clase Intent y le pasamos como parámetros la referencia del objeto de esta clase (this) y la referencia del otro Activity (AcercaDe::class.java)
Llamamos posteriormente al método startActivity pasando el objeto de la clase Intent (con esto ya tenemos en pantalla la ventana del segundo Activity):

            val intento1 = Intent(this, AcercaDe::class.java)
            startActivity(intento1)

> ![NOT]
> `AcercaDe` es el nombre de la clase con el que se creo el empty activity
> ```kt
> val intento1 = Intent(this, AcercaDe::class.java)
> ```
AcercaDe boton salir:
```kt
val botonsalir =findViewById<Button>(R.id.botonsalir)
        botonsalir.setOnClickListener{
            finish()
        }
```

# Segundo "Activity" con parámetros
