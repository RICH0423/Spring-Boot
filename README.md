### [Spring-Boot] (http://projects.spring.io/spring-boot/)

##### Purpose:
- Takes an opinionated view of building production-ready Spring applications. 
 Spring Boot favors convention over configuration and is designed to get you up and running as quickly as possible.
- To further simplify Spring application development.

##### Main features:
- Spring Boot starters
- Autoconfiguration
- Command-line interface (CLI)
- Actuator

---------------
##### Spring Boot related projects
- [SpringBoot-Jersey-Swagger-Docker] (https://github.com/RICH0423/Spring-Boot/tree/master/SpringBoot-Jersey-Swagger-Docker): Developing   Microservices using Spring Boot, Jersey, Swagger and Docker
- [SpringBoot-REST] (https://github.com/RICH0423/Spring-Boot/tree/master/SpringBoot-REST) Use Spring-Boot to build RESTful web service.
- [SpringBoot-MVC] (https://github.com/RICH0423/Spring-Boot/tree/master/SpringBoot-MVC): Use Spring-Boot to build MVC web application.
- [SpringBoot-MongoDB] (https://github.com/RICH0423/Spring-Boot/tree/master/SpringBoot-MongoDB): Use Spring-Boot to build Restful API     with MongoDB
- [SpringBoot-Cache] (https://github.com/RICH0423/Spring-Boot/tree/master/SpringBoot-Cache): Caching with EhCache in Spring Boot

---------------
##### SpringBoot-MongoDB
Embedded MongoDB: de.flapdoodle.embed.mongo (GitHub https://github.com/flapdoodle-oss/de.flapdoodle.embed.mongo)

Maven dependency:
```xml
    <dependency>
        <groupId>de.flapdoodle.embed</groupId>
        <artifactId>de.flapdoodle.embed.mongo</artifactId>
        <version>1.50.2</version>
    </dependency>
 ```
---
##### SpringBoot-Jersey-Swagger-Docker
- Build Docker image
```bash
mvn -U package docker:build
```

- Start up container with the build image
```bash
docker run -idt -p 8000:8000 rich/springboot-jersey-swagger-docker
```
