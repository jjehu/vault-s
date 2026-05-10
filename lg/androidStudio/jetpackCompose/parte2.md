# Layouts en Jetpack Compose
Los layouts organizan los elementos en pantalla.
Los 3 más importantes son:
- `Column`
- `Row`
- `Box`

## Column
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

## Row
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

## Box
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

## Alineación
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
## Espaciado
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

## Ejemplo completo
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
## Concepto importante
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

