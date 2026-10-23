# 📌 Lotería – Backend (Spring Boot)

Backend desarrollado en **Java 17 + Spring Boot**, que expone servicios REST para gestionar:

- 🎟️ **Sorteos**
- 👥 **Clientes**
- 🧾 **Billetes**
- 🛒 **Historial de compra**

Compatible con ejecución local o mediante **Docker**.

---

## ✅ Tecnologías utilizadas

- Java 17  
- Spring Boot  
- Spring Data JPA  
- H2 Database (en memoria)  
- Maven Wrapper  
- Docker / Docker Compose  

---

## ✅ Requerimientos

### Para ejecución manual
- Java 17  
- Maven (opcional, incluye `mvnw`)  
- Git  

### Para ejecución con Docker
- Docker  
- Docker Compose  

---

## ✅ Estructura del proyecto

loteria-backend/
│── src/
│── database/ (en la raíz del proyecto general)
│── Dockerfile
│── pom.xml
└── README.md

yaml
Copiar código

---

## ✅ Base de datos

El backend utiliza **H2 en memoria**, cargando automáticamente:

- `schema.sql` → creación de tablas  
- `data.sql` → datos de ejemplo  

### Acceso a H2 Console
http://localhost:8080/h2-console

yaml
Copiar código

**Credenciales:**

- JDBC URL: `jdbc:h2:mem:loteria_db`
- Usuario: `sa`
- Password: *(vacío)*

---

## ✅ Endpoints principales
Recurso	Método	Endpoint
Sorteos	GET	/api/sorteos
Clientes	GET	/api/clientes
Billetes	GET	/api/billetes
Venta de billete	POST	/api/billetes/vender

(Los endpoints exactos pueden variar según tus controladores.)






