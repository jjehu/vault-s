# Tkinter: Controles Básicos

## Interfaz gráfica tkinter
Son fundamentales cuando queremos implementar programas para usuarios finales que faciliten la entrada y salida de datos.

Para utilizar tkinter hay que importarlo:
```python
import tkinter as tk
```
`Importamos tkinter como tk ya que es mas facil escribir cada vez que se utiliza tk que  tkinter`

`La librería tkinter está codificada con la metodología de programación orientada a objetos. El módulo 'tkinter' tiene una clase llamada 'Tk' que representa una ventana.`

Este es un Hola Mundo en tkinter:
```python
import tkinter as tk

class Aplicacion:
    def __init__(self):
        self.ventana1=tk.Tk()    # se crea la ventano
        self.ventana1.title("Hola Mundo")    # se le da un titulo a la ventana
        self.ventana1.mainloop()    # para que se muestre la ventana en el monitor

# bloque principal
aplicacion1=Aplicacion()
```
## Control: Button y Label
```python
import tkinter as tk

class Aplicacion:
    def __init__(self):
        self.valor=1
        self.ventana1=tk.Tk()    # se crea la ventana
        self.ventana1.title("Controles Button y Label")    # se le da un titulo a la ventana
        self.label1=tk.Label(self.ventana1, text=self.valor)    # se crea un label, se le pasa la ventana que pertenece y se pasa el valor que tendra el texto
        self.label1.grid(column=0, row=0)    # mediante el grid se ajusta la posición del label
        self.label1.configure(foreground="red")    # se le asigna el texto de color rojo

        self.boton1=tk.Button(self.ventana1, text="Incrementar", command=self.incrementar)    # se crea uel boton1, se le pasa la ventana, el texto del botón y lo que se ejecutara al presionarlo
        self.boton1.grid(column=0, row=1)    # mediante grid se ajusta la posición del boton

        self.boton2=tk.Button(self.ventana1, text="Decrementar", command=self.decrementar)    # se crea uel boton2, se le pasa la ventana, el texto del botón y lo que se ejecutara al presionarlo
        self.boton2.grid(column=0, row=2)    # mediante grid se ajusta la posición del boton

        self.ventana1.mainloop()


    def incrementar(self):
        self.valor=self.valor+1
        self.label1.config(text=self.valor)    # se puede configurar un label despues de ser creado

    def decrementar(self):
        self.valor=self.valor-1
        self.label1.config(text=self.valor)        


aplicacion1=Aplicacion() 
```

`La creación de los componentes se realizan dentro de __init__ ya que queremos que estos existan desde el principio.`
## Control: Entry

## Control: Radiobutton
## Control: Checkbutton
## Control: Listbox
