# Test exercise for BCNC

The current code belongs to an exercise for Inditex group. 
The goal was to build a Rest API endpoint using spring boot, to retrieve the price of a given product and a given 
brand at a specific point in time.

Decisions made:
* Using hexagonal architecture.

The decision was made to simplify understanding of the process and leaving all the components as loose as possible from any external factors. 
Also because if using a TDD approach it become easier to build the tests before development as all components are easily identified. 
The project is split in 3 parts, the domain and most important layer as it is the core business logic. The application layer, being the part that is exposed to the outside.
Last the infrastructure layer, as it is the layer that contains the logic needed to run the application

* Using Spring JPA (Hibernate embedded)

For many reasons, but the main one is to prevent using standard hardcoded queries, if case of breach, SQL injecting is much easier.
Also allows to abstract further from the infrastructure and domain.

# Local

application is a Spring Boot 3 application with the following settings:

* Java 17 / Spring Boot 3.2.2
* Database H2
* Maven

# Install
In order to run the application you need the following dependencies:

1. Java 17
2. Maven
