# Product Rate Service

This is a simple Spring Boot application that provides a RESTful API for managing product rates. 

## Description

# Product Rate Service

This is a Spring Boot application that provides a RESTful API for managing product rates. It is written in Java and uses SQL for data persistence, Maven for dependency management, and Spring Boot for creating stand-alone, production-grade Spring-based applications.

The application follows the Hexagonal Architecture (also known as Ports and Adapters) design pattern. This architectural pattern allows the separation of concerns, making the application more maintainable and adaptable to changes. It isolates the core logic of the application from external concerns like user interfaces, databases, web services, etc.

## Functionalities

The application provides the following functionalities:

1. **Get Product Rate**: This functionality allows users to retrieve the rate of a product based on the brand, product, and application date. The rate is retrieved from the database using the `GetProductRateUseCase` and `GetRateUseCase`.

2. **Error Handling**: The application handles errors gracefully and throws a `BusinessException` when a rate does not exist or when there is an issue with the rate query.

The application is tested thoroughly with unit tests to ensure the correctness of the functionalities.

**Product Rate Endpoint Details**

- **GET /product-rate**: This endpoint retrieves the rate of a product based on the brand, product, and application date. The request parameters are as follows:

  - `brand`: The brand of the product.
  - `product`: The name of the product.
  - `applicationDate`: The date of the application in the format `yyyy-MM-dd`.

  The response is a JSON object containing the rate of the product.

  Example Request:
  ```bash
    curl --location 'localhost:8080/products/35455/rates?brandId=1&applicationDate=2020-06-15%2010%3A00%3A00'
  ```

  Example Response:
  ```json
    {
        "id": 3,
        "brandId": 1,
        "productId": 35455,
        "applicationDate": "2020-06-15T10:00:00",
        "price": 30.50,
        "currency": "EUR"
    }
  ```

## Hexagonal Architecture

In the context of this application, the Hexagonal Architecture is implemented as follows:

- **Inside**: The application's business logic resides here. This includes entities like `ProductRate` and `Rate`, and use cases like `GetProductRateUseCase` and `GetRateUseCase`.

- **Outside**: All the details about the outside world like databases, web services, etc. are here. This includes the `RatesRepository` which is an interface to the database.

- **Ports**: These are the interfaces that allow the inside and outside of the application to interact. The `RatesRepository` is an example of a port.

- **Adapters**: These are the implementations of the ports. They convert the data from the format most convenient for the entities and use cases, to the format most convenient for things like databases, web services, etc. In this application, the `RatesRepository` would have an adapter that would implement the database interactions.

## Getting Started

### Prerequisites

- Java JDK 21
- Maven
- Spring Boot
- H2 database

### Installation

Provide step by step series of examples that tell you how to get a development environment running.

```bash
# Clone the repository
git clone https://github.com/ponies3/ecommerce.git

# Navigate into the directory
cd ecommerce

# Install dependencies
mvn install

# Run the application
mvn spring-boot:run

```
### Running the tests
Unit test in usecase and repository layer and integration test in controller layer.

```bash
mvn test
```