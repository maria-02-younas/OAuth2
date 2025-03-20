# Spring Security OAuth2

## Versions
- *Spring Version: 3.1.1*
- *Java version: 17*

# What is OAuth2?
OAuth2 is a concept of authenticating and authorizing a user. It is an industry-standard authorization framework that enables third-party applications to access the resources of a user on a separate service without exposing the user's credentials. It provides a secure and standardized way for users to grant limited access to their resources (such as data or services) to external applications without sharing their login credentials.

## Pillars of OAuth2:
- **Authorization Server:** The server responsible for authenticating the user and granting access tokens to the client. It verifies the user's identity and permissions.


- **Resource Server:** The server that hosts the user's protected resources. It requires an access token to grant the client access to those resources.


- **Resource Owner:** The user who owns the resources that the client wants to access.


- **Client:** The application that wants to access a user's resources. It can be a web or mobile application, a server, or any other type of software.

## Grant Types:

Authorization Server can authorize the user based on its grant types, which are as follows:
- **Client Credentials:** This grant type is used when the client needs to obtain an access token without having to involve the user. The client sends its client credentials to the authorization server, and the authorization server then grants the client an access token.


- **Authorization Code:** When a client hits the endpoint, the request will be redirected to authorization server which will authenticate the user by verifying its client id, client secret and also the user details. In return, it will give authorization code which in exchange gives access token and when client hits the endpoint using that valid access token, the client will easily access it.


- **Refresh Token:** This grant type is used to obtain a new access token when the old access token has expired. The client sends the authorization server its refresh token, and the authorization server then grants the client a new access token.

## Introduction
The Resource Server is a critical component responsible for managing and serving protected resources on behalf of authenticated users. It acts as a gatekeeper, controlling access to sensitive data and services. Upon receiving a valid access token from the Authorization Server, the Resource Server verifies its authenticity and authorization scope by sending the access token back to authorization server before granting access to the requested resources. This secure setup enables seamless and controlled access to protected resources, ensuring the privacy and integrity of user data in modern web and mobile applications.

## Configuration

### ResourceServerConfig.java

This file configures resource server. Those api endpoints will be defined here that are authenticated and requires access token to authenticate. 

When a client hits the endpoint, the request will be redirected to authorization server which will authenticate the user by verifying its client id and client secret and also the user details. In return, it will give access token and when client hits the endpoint using that valid access token, the client will easily access it.

## Entity, Controller, and Repository

- **StudentsController** - This is my test url.
- **Student** - This is the student entity that represents a persistent data entity in a relational database.
- **StudentRepository** - It extends JPARepository that provides various CRUD operations and other data access methods. 

## API References

### Port

The port of resource server is 8090.

### Endpoint

There will be two endpoints. 
    
    - "/test"
    - "/students"
    - "/students/{id}"

* The CRUD operations of "/students" endpoint will be depend on its method like 
    
        - POST --> to create any student
        - GET --> to retrieve any student
        - PUT --> to update any student
        - DELETE --> to delete any student

* If you need to get/delete/update data of a particular student, you will simply replace *"{id}"*, from "/students/{id}" endpoint, to an id of that particular student. The methods used will be GET, POST, DELETE only.

- ### /students - Endpoint
    - #### POST Method
        - In the body section, you will provide the data (in JSON format) of that student that you need to create or add in database. 
      
                {
                  "firstName" : "Alex",
                  "lastName" : "Henry",
                  "emailAddress" : "alex.henry@exmp.com"
                }
        - Upon successfully hitting the url, you will get *"201 created"* response code and the below data.
          
                    {
                          "firstName": "Alex",
                          "lastName": "Henry",
                          "emailAddress": "alex.henry@exmp.com",
                          "_links": {
                              "self": {
                                "href": "http://127.0.0.1:8090/students/7"
                              },
                              "student": {
                                "href": "http://127.0.0.1:8090/students/7"
                              }
                          }
                      }
        - On error.
            - Duplicate entry - 409 Conflict
              
                  {
                      "cause": {
                          "cause": {
                                "cause": null,
                                "message": "Duplicate entry 'alex.henry@exmp.com' for key 'student.email_address'"
                          },
                          "message": "could not execute statement [Duplicate entry 'alex.henry@exmp.com' for key 'student.email_address'] [insert into student (email_address,first_name,last_name) values (?,?,?)]"
                      },
                      "message": "could not execute statement [Duplicate entry 'alex.henry@exmp.com' for key 'student.email_address'] [insert into student (email_address,first_name,last_name) values (?,?,?)]; SQL [insert into student (email_address,first_name,last_name) values (?,?,?)]; constraint [student.email_address]"
                  }
          - Null entry - 409 Conflict (If last_name, can be either first_name or email_address , not given)

                {
                    "cause": {
                        "cause": {
                              "cause": null,
                                          "message": "Column 'last_name' cannot be null"
                        },
                        "message": "could not execute statement [Column 'last_name' cannot be null] [insert into student (email_address,first_name,last_name) values (?,?,?)]"
                    },
                    "message": "could not execute statement [Column 'last_name' cannot be null] [insert into student (email_address,first_name,last_name) values (?,?,?)]; SQL [insert into student (email_address,first_name,last_name) values (?,?,?)]; constraint [null]"
                }

## Dependencies

- spring-boot-starter-web
- spring-boot-starter-data-rest
- spring-boot-starter-data-jpa
- mysql-connector-j
- spring-boot-starter-security
- spring-boot-starter-oauth2-resource-server
