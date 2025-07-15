# Canvas

## Captura de eventos del mouse
![Canvas](recursos/canvas1.jpg)

```python
import tkinter as tk

class Aplicacion:
    def __init__(self):
        self.ventana1=tk.Tk()
# Luego de crear el objeto de la clase Canvas procedemos a llamar al método bind e indicar el nombre de evento a capturar y el método que lo capturará
        self.canvas1=tk.Canvas(self.ventana1, width=600, height=400, background="black")
        self.canvas1.bind("<Motion>", self.mover_mouse)  # la captura del desplazamiento de la flecha del mouse debemos especificar 'Motion'
        self.canvas1.bind("<Button-1>", self.presion_mouse)  # la presión del botón izquierdo del mouse debemos especificar ''Button-1'

        self.canvas1.grid(column=0, row=1)
        self.ventana1.mainloop()

# El método 'presion_mouse' se dispara cuando presionamos el botón izquierdo del mouse dentro del objeto canvas1. Dibujamos un círculo teniendo en cuenta donde se encuentra la flecha del mouse en este momento
    def presion_mouse(self, evento):
        self.canvas1.create_oval(evento.x-5,evento.y-5,evento.x+5,evento.y+5, fill="red")

# Cada vez que se produce un desplazamiento de la flecha del mouse dentro de la componente canvas1 se ejecuta el método 'mover_mouse'
    def mover_mouse(self, evento):        
        self.ventana1.title(str(evento.x)+"-"+str(evento.y))

aplicacion1=Aplicacion()
```

> [!NOTE]
> La diversidad de eventos que podemos capturar es muy grande, veamos algunos ejemplos:
> - Para capturar el evento clic del botón izquierdo del mouse indicamos en el método bind <Button-1>, el botón central <Button-2> y el botón derecho del mouse <Button-3>
> - Si necesitamos capturar el evento clic del botón derecho del mouse y a su vez que se encuentre presionada la tecla Shift tenemos que codificar:
> ```python
> self.canvas1.bind("<Shift Button-1>", self.presion_mouse)
> ```
> En lugar de Shift podemos verificar si se está presionando la tecla control:
> ```python
> self.canvas1.bind("<Control Button-1>", self.presion_mouse)
> ```
> Inclusive detectar el evento si se presiona Shift, Control y el botón izquierdo del mouse:
> ```python
> self.canvas1.bind("<Control Shift Button-1>", self.presion_mouse)
> ```
> La tecla Alt, Shift, Control y el botón izquierdo del mouse:
> ```python
> self.canvas1.bind("<Control Shift Alt Button-1>", self.presion_mouse)
> ```
> - Si necesitamos hacer algo cuando la flecha del mouse entra al control podemos plantear la captura del evento:
> ```python
> self.canvas1.bind("<Enter>", self.entrada)
> ```
> Y si queremos detectar cuando la flecha del mouse sale de la componente:
> ```python
> self.canvas1.bind("<Leave>", self.salida)
> ```
> - Para detectar el doble clic de un botón del mouse:
> ```python
> self.canvas1.bind("<Double-Button-1>", self.presion_mouse)
> ```

![Canvas](recursos/canvas2.jpg)

```python
import tkinter as tk

class Aplicacion:

    def __init__(self):
        self.ventana1=tk.Tk()
        self.canvas1=tk.Canvas(self.ventana1, width=600, height=400, background="black")
        self.canvas1.grid(column=0,row=0)
        self.canvas1.bind("<ButtonPress-1>",self.boton_presion)
        self.canvas1.bind("<Motion>", self.mover_mouse)
        self.canvas1.bind("<ButtonRelease-1>",self.boton_soltar)
        self.presionado=False
        self.ventana1.mainloop()

    def boton_presion(self, evento):
        self.presionado=True
        self.origenx=evento.x
        self.origeny=evento.y

    def mover_mouse(self, evento):
        if self.presionado:
            self.canvas1.create_line(self.origenx,self.origeny,evento.x,evento.y, fill="red")
            self.origenx=evento.x
            self.origeny=evento.y
    
    def boton_soltar(self,evento):
        self.presionado=False

aplicacion1=Aplicacion()
```

## Borrar figuras mediante Ids y Tags
![Canvas](recursos/canvas3.jpg)

```python
```

## Desplazar una figura mediante el método move
![Canvas](recursos/canvas4.jpg)

```python
```

## Mostrar una imagen
![Canvas](recursos/canvas5.jpg)

```python
```

## Mover una figura
![Canvas](recursos/canvas6.jpg)

```python
```
