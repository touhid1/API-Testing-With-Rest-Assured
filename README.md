# API Testing With Rest Assured

This project demonstrates how to perform API testing using **Java**, **Rest Assured**, **JUnit**, and **Maven**. It follows a modular and maintainable test automation structure.

---

## 🗂 Project Structure

```
src/test/java/api
├── base
│   └── BaseAPI.java                  # Common setup for Rest Assured (base URI, headers, etc.)
├── endpoints
│   ├── AuthEndpoint.java             # Authentication-related API calls
│   └── BookingEndpoint.java          # Booking API calls
├── model
│   └── Booking.java                  # POJO for Booking request/response
├── tests
│   └── BookingTests.java             # JUnit test cases for Booking APIs
└── utils
    ├── ConfigReader.java             # Reads from config.properties
    ├── RequestBodyBuilder.java       # Builds JSON bodies for API requests
    └── WriteJson.java                # Utility for writing response data to JSON
```

---

## 🧪 Tech Stack

- **Java 17+**
- **Rest Assured**
- **JUnit 4.13.2**
- **Maven**
- **Maven Surefire Plugin**

---

## ⚙️ Setup & Run

### 1. Clone the Repository

```bash
git clone https://github.com/touhid1/AutomationExercise.git
cd AutomationExercise
```

### 2. Install Dependencies

```bash
mvn clean install
```

### 3. Run Tests

```bash
mvn test
```

---

## 📝 Configuration

Use `ConfigReader.java` to read from a `config.properties` file:

### Example: `config.properties`

```properties
base.url=https://api.example.com
username=admin
password=admin123
```

---

## 🔍 Example Test

```java
@Test
public void testGetBookingById() {
    given()
        .when()
        .get("/booking/1")
        .then()
        .statusCode(200);
}
```

---

## 📦 Key Dependencies (`pom.xml`)

```xml
<dependencies>
  <dependency>
    <groupId>io.rest-assured</groupId>
    <artifactId>rest-assured</artifactId>
    <version>5.4.0</version>
    <scope>test</scope>
  </dependency>
  <dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.13.2</version>
    <scope>test</scope>
  </dependency>
</dependencies>
```

---

## 👤 Author

**Md Touhedul Islam**  
GitHub: [touhid1](https://github.com/touhid1)

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).
