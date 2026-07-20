# Test Suite Documentation

## Overview
This project includes comprehensive testing with both **Unit Tests** and **Cucumber BDD Tests**.

## Test Structure

```
src/test/
├── java/
│   └── com/trekExpert/expertguide/
│       ├── CucumberRunnerIT.java           # Cucumber test runner
│       ├── ExpertGuideApplicationTests.java # Application context tests
│       ├── stepdefs/
│       │   └── CustomerStepDefinitions.java # Cucumber step definitions
│       └── repository/
│           └── CustomerRepositoryTest.java  # Unit tests for repository
└── resources/
    ├── application-test.properties          # Test configuration
    └── features/
        └── customer.feature                 # Cucumber feature file
```

## Running Tests

### Run All Tests
```bash
mvn clean test
```

### Run Unit Tests Only
```bash
mvn clean test -Dtest=**/*Test.java
```

### Run Cucumber Tests Only
```bash
mvn clean test -Dtest=**/*IT.java
```

### Run Specific Test Class
```bash
mvn clean test -Dtest=CustomerRepositoryTest
```

### Run Tests with Coverage
```bash
mvn clean test jacoco:report
```

## Test Types

### Unit Tests
Located in `src/test/java/com/trekExpert/expertguide/repository/`

- **CustomerRepositoryTest.java**: Tests for the CustomerRepository
  - Verifies repository injection
  - Validates Spring component registration
  - Tests entity manager availability

- **ExpertGuideApplicationTests.java**: Application context tests
  - Verifies application context loads
  - Tests bean creation
  - Validates bean registration

### Cucumber BDD Tests
Located in `src/test/java/com/trekExpert/expertguide/stepdefs/`

- **CustomerStepDefinitions.java**: Step definitions for customer features
  - Given: Initialize and setup scenarios
  - When: Execute actions
  - Then: Verify outcomes

**Feature Files** (`src/test/resources/features/`)
- **customer.feature**: Defines customer management scenarios using Gherkin syntax

## Test Configuration

The test profile uses H2 in-memory database for fast test execution:
- Database: H2 in-memory (`testDb`)
- JPA Provider: Hibernate
- DDL Strategy: `create-drop` (creates fresh schema for each test)

## Dependencies

- **JUnit 5 (Jupiter)**: Modern Java testing framework
- **Cucumber 7.14.0**: BDD testing framework
- **AssertJ**: Fluent assertion library
- **Mockito**: Mocking framework
- **Spring Boot Test**: Spring testing utilities
- **H2 Database**: In-memory test database

## Writing New Tests

### Adding Unit Tests
1. Create a test class in `src/test/java` matching the class you're testing
2. Use `@SpringBootTest` or `@DataJpaTest` annotation
3. Use AssertJ for assertions
4. Follow the AAA pattern (Arrange, Act, Assert)

Example:
```java
@Test
@DisplayName("Should perform some operation")
public void shouldPerformSomeOperation() {
    // Arrange
    // Act
    // Assert
}
```

### Adding Cucumber Tests
1. Add scenarios to `src/test/resources/features/*.feature`
2. Create step definitions in `src/test/java/com/trekExpert/expertguide/stepdefs/`
3. Use `@Given`, `@When`, `@Then` annotations
4. Follow Gherkin syntax

Example Feature:
```gherkin
Scenario: Perform action
    Given a precondition
    When I perform an action
    Then I expect a result
```

## Best Practices

1. **Test Naming**: Use descriptive names with `@DisplayName`
2. **Test Isolation**: Each test should be independent
3. **Use Profiles**: Run tests with `@ActiveProfiles("test")`
4. **Mock External Services**: Use Mockito for external dependencies
5. **Arrange-Act-Assert**: Follow the AAA pattern
6. **One Assertion Per Scenario**: Keep tests focused

## CI/CD Integration

These tests can be integrated into CI/CD pipelines:
```yaml
# Example GitHub Actions
- name: Run Tests
  run: mvn clean test
```

## Troubleshooting

### Tests fail with "No beans found"
- Ensure `@SpringBootTest` or `@DataJpaTest` is used
- Check that classes have proper `@Repository`, `@Service` annotations

### Cucumber tests not running
- Verify feature files are in `src/test/resources/features/`
- Check step definitions are in `com.trekExpert.expertguide.stepdefs` package
- Ensure `CucumberRunnerIT.java` exists

### H2 database connection issues
- Check `application-test.properties` configuration
- Ensure test profile is active (`@ActiveProfiles("test")`)
- Verify H2 dependency is included in pom.xml
