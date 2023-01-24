# Movie Reactive API MicroService
<br>

## Overview
 In this project I built MicroServices using the concept of Spring WebFlux where communicating with each other and how to handling requests.
 <br>
 
## Usages
SpringBoot , Spring WebFlux , WebClient, JUnit5 test, Mongodb
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

### 3-Application.properties.yml
<br>
  
### Run the program
<br>
  * 1- run MovieInfo and add information on postman
  <img width="750" alt="movieInfo-get" src="https://user-images.githubusercontent.com/67427643/214279762-ddb80a1c-e63e-48eb-a4ef-c58a38fb6c2c.png">

  * 2- run MovieReview and add information on postman
  * 3- run Movie to get information and review about movie on postman
