# Demo Recipes Project

Welcome to the Demo Recipes project! This project showcases a simple recipe management application built using Spring Boot and Gradle.

# Technologies Used
* Java
* Spring Boot
* Spring Data JPA
* Hibernate
* H2 Database
* RESTful API

# Project Description
The Demo Recipes project is a web application that allows users to manage recipes. It provides the following features:

* Retrieving a list of all recipes
* Retrieving a recipe by its ID
* Creating a new recipe
* Updating an existing recipe
* Deleting a recipe

The project is built using Spring Boot, which provides a powerful and easy-to-use framework for developing Java-based web applications. The application uses the Gradle build tool for managing dependencies and building the project.

# Installation
To run the Demo Recipes project locally, follow these steps:

1. Clone the repository to your local machine:

`  git clone https://github.com/dare889/demo-recipes.git
`

2. Navigate to the project directory:

`cd demo-recipes`

3. Build the project using Gradle:

`./gradlew build`
4. Run the application:

`./gradlew bootRun`

The application will start running on http://localhost:8080/recipes.

# Usage
Once the application is up and running, you can use a REST client (e.g., Postman) to interact with the API endpoints. Here are some example API endpoints you can try:

* GET /recipes - Retrieve a list of all recipes
* GET /recipes/{id} - Retrieve a recipe by its ID
* POST /recipes - Create a new recipe
* PUT /recipes/{id} - Update an existing recipe
* DELETE /recipes/{id} - Delete a recipe by its ID

Make sure to provide the necessary request payload and parameters as specified in the API documentation.

# Contributing
Contributions to the Demo Recipes project are welcome! If you would like to contribute, please follow these steps:

1. Fork the repository to your GitHub account.
2. Create a new branch for your feature or bug fix.
3. Make your changes and commit them to your branch.
4. Push the changes to your forked repository.
5. Submit a pull request from your branch to the main repository.

Please ensure that your code adheres to the existing coding style and conventions used in the project. Also, provide a clear description of the changes you made and any relevant information for review.