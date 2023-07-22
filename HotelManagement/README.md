# Hotel Management Application

![hotel_management_logo](https://tse1.mm.bing.net/th?id=OIP.67HNwvRJeJUPSGbQsSHfawHaDn&pid=Api&P=0&h=180) 

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
- [Configuration](#configuration)
- [Usage](#usage)
- [API Documentation](#api-documentation)
- [Contributing](#contributing)
- [License](#license)

## Introduction

The Hotel Management Application is a web-based system designed to manage hotel rooms and bookings. It allows hotel administrators to add, update, and delete room information, as well as handle customer reservations.

## Features

- View a list of all hotel rooms.
- View details of a specific hotel room by its ID.
- Add a new hotel room to the system.
- Update an existing hotel room's details.
- Delete a hotel room from the system.
- Check the availability of a hotel room for booking.
- Make a reservation for a hotel room.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- H2 Database


## Getting Started

To run the Hotel Management Application locally, follow these steps:

1. Clone the repository: `git clone https://github.com/your-username/hotel-management.git`
2. Navigate to the project directory: `cd hotel-management`
3. If you are using an IDE, import the project as a Maven project.
4. Build the application: `mvn clean install`
5. Run the application: `mvn spring-boot:run`
6. The application will start, and you can access it at `http://localhost:8080`

## Configuration

The application configuration can be found in the `application.properties` file. You may need to modify the database connection settings, server port, or any other properties based on your requirements.

## Usage

Once the application is up and running, you can access the following endpoints:

- `/api/hotelrooms` - View a list of all hotel rooms (REST API).
- `/api/hotelrooms/{id}` - View details of a specific hotel room by its ID (REST API).
- `/api/hotelrooms/create` - Add a new hotel room to the system (REST API).
- `/api/hotelrooms/{id}/update` - Update an existing hotel room's details (REST API).
- `/api/hotelrooms/{id}/delete` - Delete a hotel room from the system (REST API).
- `/h2-console` - Access the H2 database console (Development only).
- `/` - Homepage (if applicable).

## API Documentation

API documentation is generated automatically using SpringDoc and can be accessed at `http://localhost:8080/swagger-ui.html` (when the application is running). It provides detailed information about the available REST endpoints, request parameters, and responses.

## Contributing

We welcome contributions to improve the Hotel Management Application. If you find any issues or want to add new features, please create a pull request, and we will review it together.



