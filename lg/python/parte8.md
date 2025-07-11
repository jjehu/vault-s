# PIP - Instalador de paquetes

pip es un programa que viene con Python y nos permite instalar paquetes de terceros con el objetivo de valernos de librerías de código desarrolladas por la comunidad de Python.
Se puede buscar paquetes en [pypi.org](pypi.org)
Existen paquetes en Python que nos pueden facilitar el desarrollo de programas en una diversidad de temas muy amplio.

## Instalación de un paquete
Para conocer los pasos en la instalación de un paquete almacenado en pypi elegiremos el paquete `wxPython`
Desde la línea de comandos debemos ejecutar:
```
pip install wxPython
```
Después de esto ya podemos implementar aplicaciones en Python que hagan uso del paquete `wxPython`.
Programa que muestra una ventana con el mensaje "Hola Mundo" empleando el paquete `wxPython`:
```python
import wx

aplicacion = wx.App()
ventana = wx.Frame(parent=None,title="Hola Mundo")
ventana.Show()
aplicacion.MainLoop()
```
Si lo ejecutamos al programa podemos comprobar que nuestra aplicación no se ejecuta en la consola del sistema operativo sino que aparece una interfaz visual.

> [!CAUTION]
> Para instalar un paquete:
> ```pip install [nombre del paquete]```
> Para desinstalar un paquete
> ```pip uninstall [nombre del paquete]```
> Para conocer todos los archivos que tiene un paquete instalado:
> ```pip show --files [nombre del paquete]```
> ```pip show -f [nombre del paquete]```
> Para conocer todos los paquetes instalados:
> ```pip list```
> Para ver los paquetes desactualizados:
> ```pip list --outdated```
> Para instalar una versión antigua:
> ```pip install [nombre del paquete]==4.0.2```
> Para actualizar un paquete ya instalado:
> ```pip install --upgrade [nombre del paquete]```
