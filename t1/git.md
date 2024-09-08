# Guia
```
git config --global user.name "name"
```
```
git config --global user.email name@gmail.com
```
```
git config --global core.editor "code --wait"
```
```
git config --global -e
```
---
windows
```
git config --global core.autocrlf true
```
linux o mac
```
git config --global core.autocrlf input
```
---
```
git config --global -h
```

### Comandos Basicos
navegar
```
cd
cd ..
ls
ls -a
pwd
```
crear
```
mkdir nombre
```
dentro de la carpeta
```
git init
```
iniciar visual studio code

```
code .
```

### ADD, STATUS y COMMIT
ver estado de la carpeta
```
git status
```
trackear archivo para commit
```
git add archivo
```
quitar archivo
```
git rm --cached archivo
```
restaurar al archivo anterior (quitar modificaciones de archivo y dejarlo hasta cuando se hizo git add al archivo)
```
git restore archivo
```
hacer commit con mensaje
```
git commit -m "mensaje"
```

### gitignore
el archivo `.gitignore` es para que el commit ignore archivos del proyecto, dentro de este arvhico se puede ingresar nombres como tipos de archivos:
ejm: 
```
.env
node_modules
*.jpg
*.mp4
```
### git diff
para ver los cambios
```
git diff
```

### visualizar commit
ver los commit
```
git log
```
ver los commit en una sola linea
```
git log --oneline
```

## git versiones

### git branch y checkout
ver sobre la rama actual que estamos
```
git branch
```
crear un nuevo branch desde la posicion actual con el nombre
```
git branch nombre
```
posicionarse sobre el commit nombre
```
git checkout nombre
```
crear y posicionarse sobre la ramaNueva
```
git checkout -b ramaNueva
```


unir el commit actual con el commit nombre
```
git merge nombre
```
posicionar el commit actual sobre el commit nombre
```
git rebase nombre
```
para posicionarse en el commit anterior con el hash
```
git checkout hash ^
```
