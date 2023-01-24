# Movie Reactive API MicroService
<br>

## Overview
 In this project I built MicroServices using the concept of Spring WebFlux where communicating with each other by WebClient and handling requests.
 <br>
 
## Usages
SpringBoot, Spring WebFlux, WebClient, JUnit5 test, Mongodb
<br> 

## Architecture of the Project

 ### 1-src folder
 
  - MovieInfo
    - controllers folder
    - models folder
    - services folder
    - repositories
    
  - MovieReview
    - exceptions folder
    - handlers folder
    - models folder
    - services folder
    - repositories folder
    - routers folder
    
  - Movie
    - Client folder
    - controllers folder
    - exceptions folder
    - handlers folder   
    - models folder

### 2-Maven pom.xml
    - MoiveInfo and MovieReview pom.xml:
```
<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-webflux</artifactId>
		</dependency>
  
  <dependency>
			<groupId>io.projectreactor</groupId>
			<artifactId>reactor-test</artifactId>
			<scope>test</scope>
		</dependency>
  
  <dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<version>1.18.20</version>
			<scope>provided</scope>
		</dependency>
  
  	<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-mongodb-reactive</artifactId>
			<version>2.7.4</version>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
			<exclusions>
				<exclusion>
					<groupId>junit</groupId>
					<artifactId>junit</artifactId>
				</exclusion>
			</exclusions>
		</dependency>
  
		<dependency>
			<groupId>org.junit.jupiter</groupId>
			<artifactId>junit-jupiter-engine</artifactId>
			<scope>test</scope>
		</dependency>

		<dependency>
			<groupId>io.projectreactor</groupId>
			<artifactId>reactor-test</artifactId>
			<scope>test</scope>
		</dependency>
  
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
			<version>2.7.4</version>
		</dependency>
	</dependencies>
 
 
 
  - Movie pom.xml:  
```
  <dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-webflux</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
 
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-contract-wiremock</artifactId>
			<version>3.1.4</version>
		</dependency>

		<dependency>
			<groupId>com.github.tomakehurst</groupId>
			<artifactId>wiremock-jre8</artifactId>
			<version>2.34.0</version>
			<scope>test</scope>
		</dependency>

		<dependency>
			<groupId>io.projectreactor</groupId>
			<artifactId>reactor-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<version>1.18.20</version>
			<scope>provided</scope>
		</dependency>
 
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-mongodb-reactive</artifactId>
			<version>2.7.4</version>
		</dependency>

		<dependency>
			<groupId>com.github.tomakehurst</groupId>
			<artifactId>wiremock-standalone</artifactId>
			<version>2.27.2</version>
			<scope>test</scope>
		</dependency>
	</dependencies>

### 3-Application.properties.yml

```
spring:
    data:
       mongodb:
         database: moviedb
         host: localhost
         port: 27017

spring.datasource.username: moviedb
spring.datasource.password: nFLhPPKOnkW1FA1e
spring.data.mongodb.auto-index-creation: "true"     
  
### Run the program
<br>


  * 1- run MovieInfo and add information on postman
  <img width="750" alt="movieInfo-get" src="https://user-images.githubusercontent.com/67427643/214279762-ddb80a1c-e63e-48eb-a4ef-c58a38fb6c2c.png">

  * 2- run MovieReview and add information on postman
  <img width="767" alt="movieReview-get" src="https://user-images.githubusercontent.com/67427643/214281321-1cf3f998-7250-420e-8747-20f348b633c1.png">
  
  * 3- run Movie to get information and review about movie by id on postman
  <img width="761" alt="movie-get" src="https://user-images.githubusercontent.com/67427643/214282384-c41c1c48-8884-41b0-ab67-821cf07d2a74.png">

