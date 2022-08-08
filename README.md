#### Employee Management Project: Spring Boot + Spring Data JPA ( Hibernate)+ Spring Security + Bootstrap5 + Thymeleaf and Postgresql Database

## I- The First Part:
**** Employee Module:
- Get all Employee 

- Add a new Employee 

- Update Employee By ID

- Delete Employee By ID

- Pagination Employee

- Sorting Table Employee By Name

## II- Add Spring Boot actuator helps you monitor and manage your Spring boot application
 - All the actuator endpoints will be available at http://localhost:8181/actuator.
 - enable all of the built-in endpoints of Actuator. To do so, set the configuration in the application.properties file: 
 management.endpoints.web.exposure.include=* 
 - add HAL and the HAL explorer:  is a simple format that gives a consistent and easy way to hyperlink between resources in our API:
       
       <dependency>
            <groupId>org.springframework.data</groupId>
            <artifactId>spring-data-rest-hal-explorer</artifactId>
       </dependency>
