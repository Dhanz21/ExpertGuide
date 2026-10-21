# ExpertGuide

A Spring Boot starter application for exposing a small REST API backed by an embedded H2 database. The project currently includes a working customer endpoint and the scaffolding for product/order-related resources.

## Overview

This project is built with:
- Java 21
- Spring Boot 3.2.2
- Spring Data JPA
- H2 in-memory database
- SpringDoc OpenAPI / Swagger UI
- Gradle

The application runs with a context path of `/api`, so endpoints are exposed under `http://localhost:8080/api`.

## Prerequisites

- Java 21 or newer
- Gradle (wrapper included: `./gradlew`)

## Getting started

### 1. Clone the project

```bash
git clone https://github.com/Dhanz21/ExpertGuide.git
cd ExpertGuide
```

### 2. Build the project

```bash
./gradlew build
```

### 3. Run the application

```bash
./gradlew bootRun
```

The app starts on:
- `http://localhost:8080`
- API base URL: `http://localhost:8080/api`

## API access

- Swagger UI: `http://localhost:8080/api/swagger-ui.html`
- OpenAPI document: `http://localhost:8080/api/v3/api-docs`
- H2 console: `http://localhost:8080/api/h2-console`

### H2 database configuration

The app uses an in-memory H2 database configured in `application.properties`:
- JDBC URL: `jdbc:h2:mem:expertguidedb`
- Username: `sa`
- Password: empty

## Available endpoints

### Customers

- `GET /api/customers` — List customers
- `GET /api/customers/{id}` — Get a customer by ID
- `POST /api/customers` — Create a customer

Example request:

```bash
curl -X POST http://localhost:8080/api/customers \
  -H "Content-Type: application/json" \
  -d '{
    "name": "John Doe",
    "email": "john@example.com"
  }'
```

Example response:

```json
{
  "id": 1,
  "name": "John Doe",
  "email": "john@example.com"
}
```

### Product and order modules

The project contains controller/service scaffolding for `Product` and `Order` resources, along with DTOs for those domains. These are not fully implemented yet and can be extended as the business model grows.

## Project structure

```text
src/
├── main/
│   ├── java/com/trekExpert/expertguide/
│   │   ├── ExpertGuideApplication.java
│   │   ├── controller/
│   │   │   ├── CustomerController.java
│   │   │   ├── ProductController.java
│   │   │   └── OrderController.java
│   │   ├── dto/
│   │   │   ├── CustomerDto.java
│   │   │   ├── ProductDto.java
│   │   │   └── OrderDto.java
│   │   ├── model/
│   │   │   └── Customer.java
│   │   ├── repository/
│   │   │   ├── CustomerRepository.java
│   │   │   ├── ProductRepository.java
│   │   │   └── OrderRepository.java
│   │   └── service/
│   │       ├── CustomerService.java
│   │       ├── ProductService.java
│   │       └── OrderService.java
│   └── resources/
│       └── application.properties
└── test/
    └── java/com/trekExpert/expertguide/controller/
        └── CustomerControllerTest.java
```

## Testing

Run the test suite with:

```bash
./gradlew test
```

This project currently includes a Spring Boot integration test for the customer API.

## Notes

- The application is configured for local development and testing with an embedded H2 database.
- The `server.servlet.context-path=/api` setting means all endpoints are grouped under the `/api` base path.
- The project appears to be in an early starter state; customer functionality is implemented, and Product/Order resources are present as scaffolding for future development.

## License

This project does not currently declare a license file in the repository. If you plan to publish or share it externally, add an appropriate license before distribution.
