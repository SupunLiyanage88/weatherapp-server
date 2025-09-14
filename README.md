🌦️ Weather App Backend

This is the backend service for the Weather App, built with Spring Boot.
It provides secure RESTful APIs to fetch and serve weather information for different cities, with authentication and authorization features.

🚀 Features

Fetch current weather data by city.

JWT-based authentication & authorization.

User login & registration APIs.

Integration with external weather API (e.g., OpenWeatherMap).

Secure RESTful endpoints following best practices.

🛠️ Tech Stack

Java 17+

Spring Boot 3+

Spring Security + JWT

Spring Data JPA (Hibernate)

MySQL / H2 (for development)

Maven

📂 Project Structure
weatherapp-backend/
 ├── src/main/java/com/example/weatherapp
 │    ├── controller    # REST controllers
 │    ├── model         # Entity models
 │    ├── repository    # JPA repositories
 │    ├── config        # JWT & Spring Security configs
 │    ├── service       # Business logic
 │    ├── filter        # JWT filter
 │    └── WeatherAppApplication.java
 ├── src/main/resources
 │    ├── application.properties
 └── pom.xml

⚙️ Setup & Installation
Prerequisites

Install Java 17+

Install Maven 3.9+

Set up MySQL (or use H2 for dev mode)

Clone the Repository
git clone https://github.com/yourusername/weatherapp-backend.git
cd weatherapp-backend

Configure Database

Update src/main/resources/application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/weatherapp
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update

# JWT Secret
app.jwt.secret=your_secret_key
app.jwt.expiration=3600000

Run the Application
mvn spring-boot:run


App will start on:
👉 http://localhost:8080

🔐 Authentication Flow

Register → Create an account

Login → Receive JWT token

Access Weather APIs → Send token in Authorization header:

📡 API Endpoints
Auth
Method	Endpoint	Description
POST	/api/auth/register	Register new user
POST	/api/auth/login	Authenticate & get token
Weather
Method	Endpoint	Description
GET	/api/weather/{city}	Get current weather by city


mvn clean package
java -jar target/weatherapp-0.0.1-SNAPSHOT.jar

👨‍💻 Author

Developed by L.S.B Hemaratne
📧 Contact: supunhemaratne@example.com
