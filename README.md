# Employee Management System
The system is a Spring Boot Application designed to manage employee across different departments within a company.

## Prerequisties
Before running the application, ensure you have the following installed:
- Maven with version: **3.9.6**
- Java 17 or above
- Github Desktop
  
## Installation
1. Clone the repository
2. Navigate to the project directory
3. Build the application using Maven with cmd "mvn clean install"
4. Run the application with cmd "mvn spring-boot:run"

## Usage API endpoints
Once the application is running, you can access the following endpoints:
### Employee
1. GET /employees : Retrieve all employees
2. GET /employees/{id} : Retrieve an employee by ID
3. POST /employees : Create a new employee
4. PUT /employees/{id} : Update an existing employee
5. DELETE /employees/{id} : Delete an existing employee by ID
### Department
1. GET /departments : Retrieve all departments
2. GET /departments/{id} : Retrieve an department by ID
3. POST /departments : Create a new department
4. PUT /departments/{id} : Update an existing department
5. DELETE /departments/{id} : Delete an existing department by ID
### Project
1. GET /projects : Retrieve all projects
2. GET /projects/{id} : Retrieve an project by ID
3. POST /projects : Create a new project
4. PUT /projects/{id} : Update an existing project  
5. DELETE /projects/{id} : Delete an existing project by ID
