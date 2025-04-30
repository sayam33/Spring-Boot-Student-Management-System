✅Summary for Project
📌 Project Name := Student Management System :– 
📝 Description:_ 
Student Management System built using Spring Boot, JSP, and MySQL. Includes RESTful API support, web views with JSP, Hibernate validation, and full CRUD functionality. Ideal for learning Java web development using Spring MVC and JPA. It includes features like adding, updating, deleting, and viewing students with proper validations, exception handling, and MySQL integration.

🔧 Tech Stack:
Backend Language: Java 8.
Framework: Spring Boot 2.4.13.
Persistence: Spring Data JPA.
Database: MySQL V:= mysql-connector-j (8.3.0).
View Layer: JSP (via tomcat-embed-jasper) JSTL.
API Support: Spring REST Controller (`@RestController`).
Validation: Hibernate Validator (via spring-boot-starter-validation (@Valid)).
Build Tool: Maven.
IDE Compatible: Eclipse (.classpath, .project).
Logging: Uses log files (app.log) / SLF4J / Logback.
Hot Reloading: Spring Boot DevTools.


💡 Key Features:
Create, Read, Update, Delete (CRUD) for student entities.
Validations on input forms.
JSP-based front-end views.
Maven-based build and dependency management.
Structured for rapid development using Spring Boot.

🚀 Features :-
✅ Full CRUD operations for Student Entity.
✅ REST API using @RestController (API-first backend development).
✅ Web UI using @Controller + JSP views.
✅ Validations using @Valid and Hibernate Validator.
✅ Global Exception Handling.
✅ MySQL database integration.
✅ Logging with SLF4J/Logback.
✅ Eclipse IDE ready.
✅ Hot reload with Spring Boot DevTools.


✅Access via browser: http://localhost:8080


🌐 API Examples;-
| Method | Endpoint         | Description          |
|--------|------------------|----------------------|
| GET    | `/students`      | Get all students     |
| POST   | `/students`      | Add new student      |
| PUT    | `/students`      | Update a student     |
| DELETE | `/students`      | Delete a student     |

📁 Folder Structure Highlights:
src/main/java – Contains controllers, models, services.
src/main/resources/static – Static content (if any).
src/main/webapp/WEB-INF/jsp – JSP views.
pom.xml – Project dependencies and configuration.
.settings/, .classpath, .project – Eclipse project metadata.



