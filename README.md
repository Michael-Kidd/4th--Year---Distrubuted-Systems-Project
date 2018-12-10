# Distributed Systems Final Year Project

----------

- Author of Documentation/Programmer : Michael Kidd

----------

## Introduction to the Program

----------

This program has been given as part of a Distributed Systems project for our final year in GMIT, studying software development.
- A Jax-rs service that makes RMI calls to invoke methods to read and write a System for a Car Hire company.
- The user should be able to make hire a vehicle using a web client or external program.
- The Web client should use REST requests to show and evaluate information that the users has access to.

## Running Tests on the program
----------

#### Cloning the Repo
----------

To clone the Repo for testing or deployment, Open a command line terminal change to the directory were you would like to store the program and run the following command:

````
$ git clone https://github.com/Michael-Kidd/4th--Year---Distrubuted-Systems-Project
````
As the program is not completed, it cannot be tested by the console, or webpages.
It can be tested by running within an IDE and tested there.

In the folder there is the source code for the project. Along with a WAR file which contains the tomcat clients, the JAX-rs service and the Web Client. There is also a Jar file which contains the database program.

#### How the Program works
----------

- A web client displays JSP pages and the user can view lists of the different Customers, the different Vehicles and the bookings which contain a matching customer along with the vehicle they have booked.
- At the moment cannot edit the records or post to them because I have not include code to send the input fields to the Jax-rs service using rest, there is a way to do this using streams but I had been trying to avoid using this as it was not the objective of the project.
- The web client communicates with the service using REST Requests, GET, POST, DELETE, and PUT. This section works as intended but due to the lack of input, cannot be verified on screen, can be verified in code.
- Once the Service gets a REST request, it will use RMI to Create, Read, Update or Delete those entries into a H2 Database that is included in the program.
- When the program starts, it will pre populate the database with values for testing purposes.