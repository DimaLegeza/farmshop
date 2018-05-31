# Description
Back-end part of application for farmshop maintenance. 

# API
Method | Endpoint | Description
------ | -------- | -----------
GET | /farmshop/flock | Endpoint to get list of all animals at farm
GET | /farmshop/stock | Gets current stock state.
PUT | /farmshop/flock | Re-initializes farm with new flock
POST | /farmshop/order | Place an order for particular amount of wool and milk. [Unprocessable entity](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/422) code will be returned in case stock cannot supply ordered amount of resources

# Dependencies
Production environment: Docker
Development environment: JDK 8, Docker

# Technological stack
REST back-end was build on top of spring-boot-starter, so following technologies used:
* Spring web for REST API and serving endpoints
* Swagger for API documentation
* Jackson XML serialization for initial data load 

# Running on developer machine
**Running with IDE:**
* Execute FarmshopApplication

**Running using gradle (with initial data):**
* run ```gradlew clean bootRun```

**Running using gradle (without initial data):**
* run ```gradlew clean -Dspring.profiles.active=no-data bootRun```

# Docker
As production-ready solution, back-end docker image can be build on top of alpine-openjdk8 image

**Building Docker image:**
```gradlew clean distDocker```

**Running Docker image:**
Project has pre-build docker-compose file (for integration with front-end or other services) that will sire back-end up in integrated environment.
To run with docker-compose:
```docker-compose up```

# Running instance
By default farmshop back-end instance will be running on port 8080