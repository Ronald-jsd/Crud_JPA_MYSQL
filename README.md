# ✨ Sistema de Gestión de Productos ☕

Este proyecto es una aplicación Java que permite gestionar productos a través de operaciones CRUD (Crear, Leer, Actualizar y Eliminar). 
Utiliza una base de datos de MYSQL conectada mediante un repositorio JPA para almacenar y recuperar datos. 

## 📊 Características

- **➕ Crear productos:** Registra nuevos productos con detalles como nombre, descripción, stock, precio y fecha.
- **🔄 Actualizar productos:** Modifica los detalles de productos existentes.
- **🔍 Consultar productos:** Lista todos los productos registrados o busca uno por su ID.
- **❌ Eliminar productos:** Borra productos específicos del sistema.
- **⌛ Manejo eficiente de recursos:** Cierra conexiones y limpia recursos al finalizar las operaciones.

## 🗃️ Estructura del Proyecto

```
├── edu.cibertec.jpa
│   └── App.java (Clase principal)
├── models
│   └── Producto.java (Modelo del producto)
├── repository
│   └── ProductoRepository.java (Operaciones CRUD con la base de datos)
```

## 🔹 Opciones Disponibles en la Aplicación

- `1`: Registrar un nuevo producto ➕.
- `2`: Actualizar los detalles de un producto existente 🔄.
- `3`: Listar todos los productos 🔍.
- `4`: Buscar un producto por su ID 🔑.
- `5`: Eliminar un producto por su ID ❌.
- `0`: Cerrar la aplicación ✔.

## 📊 Ejemplo de Uso

1. **Registrar un producto:**
   - Ingresa el nombre, descripción, stock, precio y fecha del producto.

2. **Actualizar un producto:**
   - Selecciona un producto de la lista y edita sus detalles.

3. **Listar productos:**
   - Visualiza todos los productos disponibles en el sistema.

4. **Buscar producto por ID:**
   - Ingresa el ID del producto para obtener sus detalles.

5. **Eliminar producto:**
   - Selecciona el ID del producto a eliminar.

## 🚀 Tecnologías Utilizadas

- **Java** ☕: Lenguaje principal.
- **JPA/Hibernate** 🔍: Para la gestión de datos.
- **MySQL/PostgreSQL** 🏢: Base de datos recomendada.
