# 🏥 Proyecto de Microservicios - Perfulandia

Este proyecto es un sistema de microservicios listo para ser ejecutado con Docker y Maven. Contiene los servicios esenciales para una arquitectura distribuida moderna.

---

## 🛠️ Requisitos Previos

- Java 17+
- Maven 3.8+
- Docker y Docker Compose

---

## 📁 Estructura del Proyecto

```
├── docker-compose.yml
├── microservice-config
├── microservice-eureka
├── microservice-gateway
├── microservice-paciente
├── pom.xml
```

---

## 🚀 Cómo Ejecutar el Proyecto

### 1. Abrir terminal en la carpeta raíz

La raíz contiene el archivo `docker-compose.yml`.

### 2. Compilar los microservicios

```bash
./mvnw clean package -DskipTests
```

### 3. Ejecutar con Docker

```bash
docker-compose up --build
```

Este comando inicia:

| Servicio             | Puerto | Descripción                      |
|----------------------|--------|----------------------------------|
| MySQL                | 3306   | Base de datos                    |
| Config Server        | 8888   | Servidor de configuración        |
| Eureka Server        | 8761   | Registro de microservicios       |
| API Gateway          | 8080   | Entrada principal a la app       |
| Servicio Paciente    | 8090   | Microservicio REST de pacientes  |

---

## 🧪 Pruebas

### Eureka Dashboard
```
http://localhost:8761
```

### Swagger del servicio paciente
```
http://localhost:8080/doc/swagger-ui
```

### API REST
```
GET http://localhost:8080/api/pacientes
```

---

## 🧼 Apagar los servicios

```bash
CTRL+C
docker-compose down
```

---



