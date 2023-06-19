# employee-management-system app

## Table of contents
* [General info](#general-info)
* [Video demo](#video-demo)
* [Technologies](#technologies)
* [Setup](#setup)



## General info
This project is a web application designed to track employees within a company. The primary focus of the project is on security techniques, with the implementation of Role-Based Access Control (RBAC) and HTTPS/SSL protocols. Additionally, the application includes logging functionalities to capture and record unsuccessful login attempts and unauthorized access attempts to restricted resources. These logging mechanisms contribute to a more secure environment by enabling the monitoring and identification of potential security breaches or suspicious activities.

## Video demo
v:1.0 https://www.youtube.com/watch?v=lDHI2XftEus&ab_channel=BojanRadovic

## Technologies
Project is created with:
* Java Spring Boot 3.0.6
* Angular 9.5.1
* PostgreSQL Database

## Setup
1. Clone this repository: git clone https://github.com/rbojan2000/employee-management-system.git
2. Install backend dependencies: cd backend && mvn install
3. Start the backend server: mvn spring-boot:run
4. Install frontend dependencies: cd ../frontend/employee-management-system && npm install
5. Start the frontend server: npm start
6. Open your browser and go to https://localhost:4200

