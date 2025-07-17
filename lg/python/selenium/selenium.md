# Selenium

> [!IMPORTANT]
> - Para instalar selenium utilizamos el instalador de paquetes `pip`
> ```python
> pip install selenium
> ```

> [!CAUTION]
> Tambien necesitamos instalar un webdriver para el navegador que utilizara selenium
> - **DESCARGA MANUAL**
> 
> Ejemplo de descarga con Chrome:
> 1. Tenemos que verificar la versión del navegador que tenemos instalado y descargar la version correspondiente para dicho navegador `chrome://version` y anotar la versión (por ejemplo, 114.0.5735.90).
> 2. Descargar el webdriver desde:
>   Chrome:  https://sites.google.com/chromium.org/driver/ - 
>   Edge:  https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/ - 
>   Firefox:  https://github.com/mozilla/geckodriver/releases - 
>   Safari:  https://webkit.org/blog/6900/webdriver-support-in-safari-10/
>
> 3. Extraer el archivo y colocarlo en una ruta conocida (por ejemplo, C:\chromedriver\chromedriver.exe o /usr/local/bin/chromedriver).
> 4. Comenzar a utilizar nuestro codigo con esto:
> ```python
> from selenium import webdriver
> from selenium.webdriver.chrome.service import Service
>
> service = Service("C:/ruta/a/chromedriver.exe") # se guarda la ruta donde se encuentra el webdriver
> driver = webdriver.Chrome(service=service) # se guarda el navegador
>
> driver.get("https://www.google.com")# se abre la página de google
> ```
> - **DESCARGA AUTOMATICA**
> 
> Una forma de ahorrase todos los anterios pasos en python es descargar automaticamente el webdriver:
> ```python
> from selenium import webdriver
> from selenium.webdriver.chrome.service import Service
> from webdriver_manager.chrome import ChromeDriverManager
>
> # Configurar el driver
> service = Service(ChromeDriverManager().install())
> driver = webdriver.Chrome(service=service)
> ```

[Parte1](selenium-p1.md)
