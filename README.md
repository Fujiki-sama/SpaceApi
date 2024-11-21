# API Testing with Cucumber and RestAssured

## Prerequisites
1. Install Java 11 or higher.
2. Install Maven.
3. Clone this repository.

## Setup
1. Navigate to the project directory.
2. Run `mvn clean install` to install dependencies.

## Running the Tests
1. Execute the tests using the command: 
    mvn test
2. Test reports will be generated in `target/cucumber-report.html`.

## Project Structure
- `features`: Contains Gherkin feature files.
- `stepDefinitions`: Contains Java implementations of the steps.
- `runner`: Contains the test runner for executing scenarios.

## API Source
[Reqres](https://reqres.in/) - Free API for testing and prototyping.
