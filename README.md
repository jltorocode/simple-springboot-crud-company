# 🏢 simple-springboot-crud-company

Este proyecto es un microservicio REST desarrollado con **Spring Boot 3.5** que permite realizar operaciones CRUD (crear, leer, actualizar y eliminar) sobre entidades de tipo **Company**. Está diseñado para ser consumido por otros microservicios, como `productcrud`, mediante HTTP (`RestTemplate` o `WebClient`).

---

## 📦 Tecnologías utilizadas

- Java 17
- Spring Boot 3.5
- Spring Web
- Spring Data JPA
- H2 Database (modo embebido para desarrollo)
- Maven
- Swagger (OpenAPI 3)
- Lombok
- DTO Pattern
- CORS configurado
- Comunicación REST con microservicios externos

---

## 🚀 Endpoints disponibles (Company API)

Base URL: `http://localhost:8081/api/companies`

| Método | Endpoint              | Descripción                     |
|--------|-----------------------|---------------------------------|
| GET    | `/`                   | Listar todas las compañías      |
| GET    | `/{id}`               | Obtener una compañía por ID     |
| POST   | `/`                   | Crear una nueva compañía        |
| PUT    | `/{id}`               | Actualizar una compañía         |
| DELETE | `/{id}`               | Eliminar una compañía por ID    |

---

## 📁 Estructura del Proyecto

```
src/
├── controller/        # Controladores REST
├── dto/               # Clases DTO (Data Transfer Object)
├── entity/            # Entidades JPA
├── repository/        # Interfaces JpaRepository
├── service/           # Lógica de negocio
├── exception/         # Manejo de errores personalizado
└── config/            # Configuración global (CORS, Swagger)
```

---

## 🧪 Swagger UI

Una vez levantado el servicio, accede a la documentación interactiva en:

```
http://localhost:8081/swagger-ui/index.html
```

---

## 🧪 Cómo correr el proyecto

1. Clona el repositorio:
   ```bash
   git clone https://github.com/tuusuario/simple-springboot-crud-company.git
   cd simple-springboot-crud-company
   ```

2. Compila el proyecto:
   ```bash
   mvn clean install
   ```

3. Corre el microservicio:
   ```bash
   mvn spring-boot:run
   ```

---

## 🔗 Relación con `productcrud`

Este microservicio es consumido desde `productcrud` mediante un `RestTemplate`, el cual solicita información de la compañía al momento de crear o consultar productos. Asegúrate de que este servicio esté activo antes de hacer peticiones desde `productcrud`.

---

## 🧰 Variables de entorno (opcional)

Puedes configurar el puerto y otras propiedades en `src/main/resources/application.properties`:

```properties
server.port=8081
spring.datasource.url=jdbc:h2:mem:companydb
spring.datasource.driver-class-name=org.h2.Driver
spring.jpa.hibernate.ddl-auto=update
```

---

## ✅ Ejemplo de entidad

```json
{
  "id": 1,
  "name": "Acme Corp",
  "address": "Santiago, Chile"
}
```

---

## 📚 Recursos

- [Spring Boot Docs](https://docs.spring.io/spring-boot/docs/current/reference/html/)
- [H2 Console](http://localhost:8081/h2-console) → JDBC URL: `jdbc:h2:mem:companydb`

---

## 🪪 Licencia

MIT © 2025 - Este proyecto es parte del ecosistema de microservicios de Wuizio.
