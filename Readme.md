## Credit Score Calculation

### Pre requisites
- Java 1.8
- Maven 3.3.0 +
- Docker

#### Run the application:

Maven:
-  mvn spring-boot:run

Docker:

- $ mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)
- $ docker build -t test/credit-score .
- $ docker run -p 8080:8080 -t test/credit-score

### Swagger:
Use this URL to open swagger UI: 
- http://localhost:8080/swagger-ui.html#

Assumptions:
- From the requirement, category for numberOfEmployees is given as 
    - 11 to 15	-> 32
    - 15 to 20	-> 55
    - In this case, if numberOfEmployees is 15 which value we need to consider. So assumed as:
        - 11 to 15	-> 32
        - 16 to 20	-> 55
        
        