Here is a concise guide on how to integrate MongoDB in a Spring Boot application in 10 steps:

Step 1: Set Up Your Spring Boot Project:
Create a new Spring Boot project using your preferred IDE or by using Spring Initializr. Include the necessary dependencies, including the MongoDB driver.

Step 2: Define a MongoDB Configuration:
Create a configuration class with the necessary configurations for connecting to MongoDB, including the host, port, and database name.

Step 3: Define a MongoDB Entity:
Create a POJO (Plain Old Java Object) class to represent your data model. Annotate this class with the necessary MongoDB annotations to define the collection name and field mappings.

Step 4: Create a Repository Interface:
Define a repository interface that extends the appropriate MongoDB repository interface. This interface will handle the CRUD (Create, Read, Update, Delete) operations for your MongoDB entity.

Step 5: Implement Service Layer:
Create a service class to handle business logic and interact with the MongoDB repository. Define methods for data manipulation and retrieval.

Step 6: Implement Data Initialization (Optional):
If required, initialize data in the database during application startup using data initialization scripts or methods.

Step 7: Implement Controller for REST API:
Create a controller class to define REST endpoints for interacting with the MongoDB data. Implement methods for handling HTTP requests, utilizing the service layer.

Step 8: Test Endpoints:
Test the REST API endpoints using tools like Postman or any other HTTP client to ensure the proper functioning of the MongoDB integration.

Step 9: Run and Test the Application:
Run the Spring Boot application and verify the integration by performing CRUD operations through the defined REST API endpoints.

Step 10: Handle Exception and Error Scenarios:
Implement error handling mechanisms to gracefully manage exceptions and errors that might occur during MongoDB integration. Implement proper logging and error response handling.