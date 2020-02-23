### Traditional Java Test Framework

Web Page been tested: "https://www.mercadolibre.com.ar".

## Architecture

Using POM (Page Object Model) pattern and Page Factory technique along with easy readable test cases.
Includes modular Framework architecture to build interactions between *Tests* and *Web Application*. 

## Pre-requisites

Need to install:

- Java 8 or higher, used OpenJDK 11.
- Maven.
- Chromedriver or Docker

## How to run

### Locally

In order to run the test first you have to install Chromedriver in your machine and include it in your PATH.
**This project does not contains Chromedriver** executor to maintain the Package's small size.
You have to install the Chromedriver correspondent for you current Chrome browser version.

From OS based on Unix:

```
make test
```

From Windows, using maven:

```
mvn clean verify
```

### With Docker

In order to run with docker, firstly you have to install docker and docker-compose.

From OS based on Unix:

```
make docker-test
```

From Windows, using docker-compose:

```
docker-compose up --build
```

## Pending to include

- Reports.
- Selenium Grid.
- Include more tests.
- Parallel execution.

## Available commands

To see available commands write in command line:

```
make help
```
