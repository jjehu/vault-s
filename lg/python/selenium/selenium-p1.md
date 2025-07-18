
**Importar webdriver**
```python
from selenium import webdriver
from selenium.webdriver.common.by import By # para utilizar la busqueda de elementos con el By

driver = webdriver.Chrome('(aquí viene la ruta de carpeta donde se encuentra el webdriver)') 
```

**Abrir y cerrar la página**
```python
driver.get("https://www.google.com/")

driver.quit() # buena práctica cerrar la página
```

**Validar título**
```python
title = driver.title
assert title == 'Google'
```

**Tiempo de pausa**
```python
driver.implicitly_wait(0.5)
```

**buscar elementos**
```python
googlebuscar_selenium = driver.find_element(by=By.NAME, value='q') # en este caso buscamos por nombre
presionarbusqueda_google = driver.find_element(by=By.NAME, value='btnK')
```

**Ingresar datos y hacer click**
```python
# Para los anteriores elementos de google
googlebuscar_selenium.send_keys('Selenium')  # se ingresa la palabra Selenium
presionarbusqueda_google.click()  # se realiza un click sobre el boton de busqueda
```
```python
```
```python
```
```python
```
```python
```

```python
```
```python
```
```python
```
```python
```
```python
```
```python
```
```python
```
```python
```
```python
```
```python
```
```python
```
```python
```
```python
```
```python
```
```python
```
```python
```
```python
```
```python
```
```python
```
```python
```
```python
```
