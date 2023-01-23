# Movie Reactive API MicroService
<br>

## Overview
 In this project I built MicroServices using the concept of Spring WebFlux where communicating with each other and how to handling requests.
 <br>
 
## Usages
<br> 
SpringBoot , Spring WebFlux , WebClient, JUnit5 test

## Architecture of the Project:
<br>

 ### src folder:
 
  - MovieInfo
    - controllers folder
    - models folder
    - services folder
    - repositories
    
  - src folder for MovieReview
    - exceptions folder
    - handlers folder
    - models folder
    - services folder
    - repositories folder
    - routers folder
    
  - src folder for Movie
    - Client folder
    - controllers folder
    - exceptions folder
    - handlers folder   
    - models folder

## Installation
<br>
   * Add dependencies pom.xml
   
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
		<!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-mongodb-reactive -->
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
   * mvn install
  
### Run the program
<br>
  * fist of all run MovieInfo and add information on postman:
 
 
 
 

  
 , MovieReview , Movie
 * each of them has own port, after adding information  MovieInfo and MovieReview THEN user port Movie to get data.
 
 

 
