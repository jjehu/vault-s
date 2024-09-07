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
