# 🏥 Proyecto de Microservicios - Sistema de Gestión de Pacientes

Este proyecto implementa un sistema distribuido usando **Spring Boot** y **arquitectura de microservicios**, ideal para manejar pacientes en un entorno hospitalario.

---

## 📦 Microservicios Incluidos

| Servicio              | Puerto | Descripción                        |
|----------------------|--------|------------------------------------|
| MySQL                | 3306   | Base de datos relacional           |
| Config Server        | 8888   | Servidor centralizado de configs   |
| Eureka Server        | 8761   | Registro de microservicios         |
| Gateway API          | 8080   | Punto de entrada a la aplicación   |
| Paciente Service     | 8090   | CRUD de pacientes vía REST         |

---

## 🛠️ Requisitos Previos

- Java 17+
- Maven 3.8+
- Docker y Docker Compose

---

## 🚀 Cómo Ejecutar el Proyecto

### 1. Clonar o descomprimir el proyecto

```bash
unzip proyecto_final_listo.zip
cd proyecto_final_listo
```

### 2. (Opcional) Compilar servicios con Maven

```bash
./mvnw clean install -DskipTests
```

### 3. Ejecutar con Docker Compose

```bash
docker-compose up --build
```

---

## 🌐 Acceso a los Servicios

- **Eureka Dashboard**: [http://localhost:8761](http://localhost:8761)
- **Swagger UI**: [http://localhost:8080/doc/swagger-ui](http://localhost:8080/doc/swagger-ui)
- **API REST**:
  - `GET http://localhost:8080/api/pacientes`
  - `POST`, `PUT`, `DELETE` disponibles

---

## 🧪 Pruebas Unitarias

Ejecutar con:

```bash
mvn test
```

Incluye tests con JUnit y Mockito en:
- `PacienteServiceTest`
- `PacienteControllerTest`

---

## 🧼 Apagar los Servicios

```bash
CTRL+C
docker-compose down
```

---

## 🧪 Datos de Ejemplo Precargados

Ya vienen dos pacientes cargados automáticamente al iniciar:

- **Juan Pérez**
- **María Gómez**

---

## ✍️ Autor

Proyecto desarrollado como entrega final de sistema de microservicios. Ideal para presentaciones académicas o institucionales.

