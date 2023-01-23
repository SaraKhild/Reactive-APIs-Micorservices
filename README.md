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

  - src folder for MovieInfo
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
  *Add dependencies Maven pom.xml
  *mvn install
  
### Run the program
<br>
 *fist of all run MovieInfo and add information on postman:
 
 
 
 
 ---
  
 , MovieReview , Movie
 * each of them has own port, after adding information  MovieInfo and MovieReview THEN user port Movie to get data.
 
 

 
