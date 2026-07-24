# Guia de Node.js con db en MySQL
[Primeros pasos](parte1.md)

# Guia corta de Node.js

## Primeros pasos
### Preparación del entorno Node.js y MySQL

1. Descargar MySQL: https://dev.mysql.com/downloads/windows/installer/
    - Instala MySQL Server y MySQL Workbench.
    - Iniciar: `MySQL 8.0 Command Line Client`
2. Descargar Node.js: https://nodejs.org/en/download

### Iniciar proyecto con Node.js
Abrir Visual Studio Code y crea una carpeta con el nombre preferido.
Abrir una nueva terminal. (Ctrl+ñ)

En la terminal ingresamos este comando para inicializar un proyecto en la carpeta dónde nos encontramos
```bash
npm init -y
```

Entre muchas cosas que nos crea, tambien se crea el `package.json` que son las configuraciones de nuestro proyecto
```json
{
 "name": "lab7",
 "version": "1.0.0",
 "description": "",
 "main": "index.js",
 "scripts": { // aqui podemos agregar comandos que sean como acortadores
 "test": "echo \"Error: no test specified\" && exit 1"
 },
 "keywords": [],
 "author": "",
 "license": "ISC",
 "type": "commonjs",
 "dependencies": {
 "body-parser": "^2.2.2",
 "express": "^5.2.1",
 "mysql2": "^3.22.3"
 }
}
```

### Instalar dependencias
Si queremos utilizar MySQL necesitamos instalar las dependencias necesarias
```bash
npm install express mysql2 body-parser
```

### Crear la base de datos en MySQL
Iniciar: `MySQL 8.0 Command Line Client`
Ingresamos nuestra contraseña
Creamos una base de datos, ejemplo:
```sql
CREATE DATABASE hotel;
USE hotel;
-- Tabla de dormitorios
CREATE TABLE dormitorios (
 id INT AUTO_INCREMENT PRIMARY KEY,
 numero INT,
 tipo VARCHAR(50),
 costo_por_dia DECIMAL(10,2)
);
-- Tabla de reservas
CREATE TABLE reservas (
 id INT AUTO_INCREMENT PRIMARY KEY,
 cliente VARCHAR(100),
 telefono VARCHAR(20),
 pais VARCHAR(50),
 dormitorio_id INT,
 dias INT,
 total DECIMAL(10,2),
 fecha DATETIME,
 FOREIGN KEY (dormitorio_id) REFERENCES dormitorios(id)
);
-- Insertar dormitorios de prueba
INSERT INTO dormitorios (numero, tipo, costo_por_dia) VALUES
(101, 'Simple', 100),
(102, 'Doble', 180),
(103, 'Suite', 300);
```
## Crear proyecto

### Crear archivos
Dentro de la carpeta principal crear los archivos:
    • db.js ⇒ conexión a MySQL.
    • app.js ⇒ servidor Express con rutas CRUD.
    • Index.html ⇒ interfaz gráfica.

Archivo `db.js`
```js
const mysql = require('mysql2');
const db = mysql.createConnection({
host: 'localhost',
user: 'root',
password: 'admin', // contraseña de nuestra base de datos
database: 'hotel'
});
module.exports = db;
```

Archivo `app.js`
```js
const express = require('express');
const bodyParser = require('body-parser');
const path = require('path');
const db = require('./db');

const app = express();

app.use(bodyParser.json());

/* =========================
   REGISTRAR RESERVA
========================= */
app.post('/reservas', (req, res) => {
    const { cliente, telefono, pais, dormitorio_id, dias } = req.body;

    db.query(
        'SELECT costo_por_dia FROM dormitorios WHERE id = ?',
        [dormitorio_id],
        (err, result) => {
            if (err || result.length === 0) {
                return res.status(400).json({
                    error: 'Dormitorio inválido'
                });
            }

            const costo = result[0].costo_por_dia;
            const total = costo * dias;

            db.query(
                `INSERT INTO reservas
                (cliente, telefono, pais, dormitorio_id, dias, total, fecha)
                VALUES (?, ?, ?, ?, ?, ?, NOW())`,
                [cliente, telefono, pais, dormitorio_id, dias, total],
                (err, r) => {
                    if (err) {
                        return res.status(500).json({
                            error: 'Error al registrar reserva'
                        });
                    }

                    res.json({
                        mensaje: 'Reserva registrada',
                        id: r.insertId,
                        total
                    });
                }
            );
        }
    );
});

/* =========================
   LISTAR RESERVAS
========================= */
app.get('/reservas', (req, res) => {
    db.query(
        `SELECT
            r.id,
            r.cliente,
            r.telefono,
            r.pais,
            r.dormitorio_id,
            d.numero,
            d.tipo,
            d.costo_por_dia AS precio_por_dia,
            r.dias,
            r.total,
            r.fecha
        FROM reservas r
        JOIN dormitorios d
            ON r.dormitorio_id = d.id`,
        (err, results) => {
            if (err) {
                return res.status(500).json({
                    error: 'Error al listar reservas'
                });
            }

            res.json(results);
        }
    );
});

/* =========================
   MODIFICAR RESERVA
========================= */
app.put('/reservas/:id', (req, res) => {
    const { cliente, telefono, pais, dormitorio_id, dias } = req.body;
    const { id } = req.params;

    db.query(
        'SELECT costo_por_dia FROM dormitorios WHERE id = ?',
        [dormitorio_id],
        (err, result) => {
            if (err || result.length === 0) {
                return res.status(400).json({
                    error: 'Dormitorio inválido'
                });
            }

            const costo = result[0].costo_por_dia;
            const total = costo * dias;

            db.query(
                `UPDATE reservas
                SET
                    cliente = ?,
                    telefono = ?,
                    pais = ?,
                    dormitorio_id = ?,
                    dias = ?,
                    total = ?
                WHERE id = ?`,
                [cliente, telefono, pais, dormitorio_id, dias, total, id],
                (err, r) => {
                    if (err) {
                        return res.status(500).json({
                            error: 'Error al actualizar reserva'
                        });
                    }

                    res.json({
                        mensaje: 'Reserva actualizada correctamente',
                        total
                    });
                }
            );
        }
    );
});

/* =========================
   ELIMINAR RESERVA
========================= */
app.delete('/reservas/:id', (req, res) => {
    const { id } = req.params;

    db.query(
        'DELETE FROM reservas WHERE id = ?',
        [id],
        (err, result) => {
            if (err) {
                return res.status(500).json({
                    error: 'Error al eliminar reserva'
                });
            }

            res.json({
                mensaje: 'Reserva eliminada correctamente'
            });
        }
    );
});

/* =========================
   SERVIR HTML
========================= */
app.get('/', (req, res) => {
    res.sendFile(path.join(__dirname, 'index.html'));
});

/* =========================
   SERVIDOR
========================= */
const PORT = 3000;

db.connect(err => {
    if (err) {
        console.error('Error conexión MySQL:', err.message || err);
        process.exit(1);
    }

    console.log('Conectado a MySQL');

    app.listen(PORT, () => {
        console.log(`Servidor en http://localhost:${PORT}`);
    });
});
```

Archivo `index.html`
```html
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Sistema de Hotel</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }

        input,
        button,
        select {
            margin: 5px;
            padding: 8px;
        }

        table {
            border-collapse: collapse;
            margin-top: 20px;
            width: 100%;
        }

        th,
        td {
            border: 1px solid #ccc;
            padding: 8px;
            text-align: center;
        }

        .acciones button {
            margin: 2px;
            padding: 5px 10px;
        }
    </style>
</head>

<body>

    <h1>Sistema de Hotel – Alquiler de Dormitorios</h1>

    <!-- BOTONES -->
    <button onclick="mostrarFormulario()">
        Nueva Reserva
    </button>

    <button onclick="listarReservas()">
        Listar Reservas
    </button>

    <!-- FORMULARIO -->
    <div id="formulario" style="display:none;">

        <input type="hidden" id="id">

        <input
            type="text"
            id="cliente"
            placeholder="Nombre del cliente"
        >

        <input
            type="text"
            id="telefono"
            placeholder="Teléfono"
        >

        <input
            type="text"
            id="pais"
            placeholder="País"
        >

        <select id="dormitorio_id">
            <option value="1">
                Dormitorio 101 - Simple
            </option>

            <option value="2">
                Dormitorio 102 - Doble
            </option>

            <option value="3">
                Dormitorio 103 - Suite
            </option>
        </select>

        <input
            type="number"
            id="dias"
            placeholder="Cantidad de días"
        >

        <br>

        <button onclick="guardarReserva()">
            Guardar
        </button>

        <button onclick="cancelar()">
            Cancelar
        </button>
    </div>

    <!-- TABLA -->
    <table id="tablaReservas">

        <thead>
            <tr>
                <th>ID</th>
                <th>Cliente</th>
                <th>Teléfono</th>
                <th>País</th>
                <th>Dormitorio</th>
                <th>Tipo</th>
                <th>Precio/día</th>
                <th>Días</th>
                <th>Total</th>
                <th>Fecha</th>
                <th>Acción</th>
            </tr>
        </thead>

        <tbody></tbody>

    </table>

    <script>

        const API_URL = "http://localhost:3000/reservas";

        /* =========================
           MOSTRAR FORMULARIO
        ========================= */
        function mostrarFormulario(
            id = null,
            cliente = "",
            telefono = "",
            pais = "",
            dormitorio_id = 1,
            dias = 1
        ) {

            document.getElementById("formulario").style.display = "block";

            document.getElementById("id").value = id || "";
            document.getElementById("cliente").value = cliente;
            document.getElementById("telefono").value = telefono;
            document.getElementById("pais").value = pais;
            document.getElementById("dormitorio_id").value = dormitorio_id;
            document.getElementById("dias").value = dias;
        }

        /* =========================
           CANCELAR
        ========================= */
        function cancelar() {
            document.getElementById("formulario").style.display = "none";
        }

        /* =========================
           GUARDAR RESERVA
        ========================= */
        function guardarReserva() {

            const id = document.getElementById("id").value;

            const cliente = document.getElementById("cliente").value;
            const telefono = document.getElementById("telefono").value;
            const pais = document.getElementById("pais").value;

            const dormitorio_id =
                document.getElementById("dormitorio_id").value;

            const dias =
                document.getElementById("dias").value;

            if (id) {

                // ACTUALIZAR
                fetch(`${API_URL}/${id}`, {
                    method: "PUT",
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body: JSON.stringify({
                        cliente,
                        telefono,
                        pais,
                        dormitorio_id,
                        dias
                    })
                })
                .then(res => res.json())
                .then(alert)
                .then(listarReservas);

            } else {

                // CREAR
                fetch(API_URL, {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body: JSON.stringify({
                        cliente,
                        telefono,
                        pais,
                        dormitorio_id,
                        dias
                    })
                })
                .then(res => res.json())
                .then(alert)
                .then(listarReservas);
            }

            cancelar();
        }

        /* =========================
           BORRAR RESERVA
        ========================= */
        function borrarReserva(id) {

            fetch(`${API_URL}/${id}`, {
                method: "DELETE"
            })
            .then(res => res.json())
            .then(alert)
            .then(listarReservas);
        }

        /* =========================
           LISTAR RESERVAS
        ========================= */
        function listarReservas() {

            fetch(API_URL)
                .then(res => res.json())
                .then(data => {

                    const tbody =
                        document.querySelector("#tablaReservas tbody");

                    tbody.innerHTML = "";

                    data.forEach(r => {

                        tbody.innerHTML += `
                            <tr>
                                <td>${r.id}</td>
                                <td>${r.cliente}</td>
                                <td>${r.telefono}</td>
                                <td>${r.pais}</td>
                                <td>${r.numero}</td>
                                <td>${r.tipo}</td>
                                <td>${r.precio_por_dia || ''}</td>
                                <td>${r.dias}</td>
                                <td>${r.total}</td>
                                <td>${r.fecha}</td>

                                <td class="acciones">

                                    <button
                                        style="background:green;color:white;"
                                        onclick="mostrarFormulario(
                                            ${r.id},
                                            '${r.cliente}',
                                            '${r.telefono}',
                                            '${r.pais}',
                                            ${r.dormitorio_id || 1},
                                            ${r.dias}
                                        )"
                                    >
                                        Editar
                                    </button>

                                    <button
                                        style="background:red;color:white;"
                                        onclick="borrarReserva(${r.id})"
                                    >
                                        Borrar
                                    </button>

                                </td>
                            </tr>
                        `;
                    });
                });
        }

    </script>

</body>
</html>
```

## Ejecutar servidor

```bash
node app.js
```
Si queremos que se actualice cuando hagamos cambios
```bash
node --watch app.js
```
En este caso se esta ejecutando en la url: http://localhost:3000/
