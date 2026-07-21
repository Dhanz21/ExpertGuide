# ExpertGuide

Expert Guide Application - REST API with Swagger Documentation

## 🚀 Getting Started

### Prerequisites

- Java 11+
- Maven 3.6+

### Project Setup

This project has been configured with Spring Boot, JPA, H2 Database, and Swagger/SpringDoc for local REST API testing.

### Running the Application

1. **Build the project:**
```bash
mvn clean install
```

2. **Run the application:**
```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

### 📡 Access the API

- **API Base URL:** `http://localhost:8080/api`
- **Swagger UI:** `http://localhost:8080/api/swagger-ui.html`
- **API Documentation (OpenAPI):** `http://localhost:8080/api/v3/api-docs`
- **H2 Console (Database):** `http://localhost:8080/api/h2-console`

### 🗄️ Database Configuration

The application uses **H2 Database** - an embedded in-memory database perfect for local testing.

**H2 Console Access:**
- URL: `http://localhost:8080/api/h2-console`
- JDBC URL: `jdbc:h2:mem:expertguidedb`
- Username: `sa`
- Password: (leave empty)

### 📚 API Endpoints

#### Expert Management
- **GET** `/api/experts` - Get all experts
- **GET** `/api/experts/{id}` - Get expert by ID
- **GET** `/api/experts/email/{email}` - Get expert by email
- **GET** `/api/experts/expertise/{expertise}` - Get experts by expertise area
- **GET** `/api/experts/active` - Get all active experts
- **POST** `/api/experts` - Create a new expert
- **PUT** `/api/experts/{id}` - Update an expert
- **DELETE** `/api/experts/{id}` - Delete an expert

### ✅ Testing

Run all tests:
```bash
mvn test
```

Run integration tests:
```bash
mvn verify
```

### 💡 Example Request/Response

**Create Expert:**
```bash
curl -X POST http://localhost:8080/api/experts \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Jane Smith",
    "email": "jane@example.com",
    "expertise": "Python",
    "bio": "Expert Python developer",
    "yearsExperience": 8,
    "isActive": true
  }'
```

**Response:**
```json
{
  "id": 1,
  "name": "Jane Smith",
  "email": "jane@example.com",
  "expertise": "Python",
  "bio": "Expert Python developer",
  "yearsExperience": 8,
  "isActive": true
}
```

## 🏗️ Architecture

```
src/
├── main/
│   ├── java/com/trekExpert/expertguide/
│   │   ├── ExpertGuideApplication.java (Spring Boot Main)
│   │   ├── controller/
│   │   │   └── ExpertController.java (REST Endpoints)
│   │   ├── service/
│   │   │   └── ExpertService.java (Business Logic)
│   │   ├── model/
│   │   │   └── Expert.java (JPA Entity)
│   │   └── repository/
│   │       └── ExpertRepository.java (Data Access)
│   └── resources/
│       └── application.properties (Configuration)
└── test/
    └── java/com/trekExpert/expertguide/
        └── controller/
            └── ExpertControllerTest.java (Tests)
```

## 🛠️ Technologies Used

- **Spring Boot 2.7.14** - Web framework
- **Spring Data JPA** - Database ORM
- **H2 Database 2.1.214** - Embedded database for testing
- **SpringDoc OpenAPI 1.7.0** - Swagger/OpenAPI documentation
- **Lombok** - Reduce boilerplate code
- **JUnit 5** - Unit testing
- **Mockito** - Mocking framework
- **Cucumber** - BDD testing

## 💻 Development

### Adding New Endpoints

1. Create a new method in the service class
2. Create a corresponding controller method with `@GetMapping`, `@PostMapping`, etc.
3. Add Swagger annotations (`@Operation`, `@ApiResponse`, etc.)
4. Write tests in the test directory

### Database Schema

The application uses Hibernate with `ddl-auto=create-drop`, which automatically creates and drops the schema on startup. Tables are created from JPA entity annotations.

## 🔧 Troubleshooting

**H2 Driver Not Found Error:**
If you get "Cannot load driver class: org.h2.Driver", run:
```bash
mvn clean install
```
This ensures all dependencies are properly downloaded.

**Port already in use:**
```bash
mvn spring-boot:run -Dspring-boot.run.arguments="--server.port=8081"
```

**View SQL queries:**
In `application.properties`, set:
```properties
spring.jpa.show-sql=true
logging.level.org.hibernate.SQL=DEBUG
```

## 📝 License

MIT License

## 📞 Support

For issues or questions, please refer to the project's issue tracker.
