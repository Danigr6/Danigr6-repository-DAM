# 🚀 Proyecto Final - 1º de DAM

Repositorio que contiene la memoria técnica y el código fuente del proyecto desarrollado durante el primer curso del Grado Superior en **Desarrollo de Aplicaciones Multiplataforma (DAM)**.

---

## 🛠️ Tecnologías Utilizadas

* **Lenguaje:** Java 
* **Base de Datos:** SQL / MySQL
* **Entorno:** IDE ECLIPSE
* **Conectividad:** JDBC (Java Database Connectivity) con `PreparedStatement`
* **Criptografía:** Hash MD5 para la seguridad de contraseñas
* **Control de versiones:** Git & GitHub
* **Documentación y Modelado:** UML (Casos de uso y Diagrama de Clases)

---

## 📁 Estructura del Repositorio

* `Proyecto 1º de DAM/Codigo/`: Contiene el código fuente completo de la aplicación.
* `Proyecto 1º de DAM/Memoria/`: Incluye la memoria del proyecto explicativa en formato PDF.

---

## 📋 Descripción del Proyecto
**MazeSolver** es una solución de software orientada a la carga, representación bidimensional y resolución de laberintos. El sistema gestiona autenticación de usuarios con persistencia en base de datos relacional y ofrece dos algoritmos de búsqueda para hallar rutas de escape:

1. **Búsqueda en Profundidad (DFS):** Encuentra la primera vía de salida disponible (algoritmo `longPath`).
2. **Búsqueda en Anchura (BFS):** Garantiza matemáticamente el camino óptimo con el menor número de pasos (algoritmo `shortPath`).
