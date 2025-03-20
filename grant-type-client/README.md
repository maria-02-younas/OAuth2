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
A "Client" refers to an application or service that requests access to protected resources on behalf of a user. The Client is typically a third-party application that seeks authorization from the resource owner (user) to access specific resources hosted on a resource server. To initiate the OAuth 2.0 flow, the Client presents its credentials to the Authorization Server, which then issues an authorization code. The Client can exchange this code for an access token, allowing it to access the requested resources on behalf of the user. The Client plays a crucial role in ensuring secure and controlled access to protected resources, enhancing the overall security and user experience in modern web and mobile applications. 

## Configuration

### Application.yml
We register clients in Spring client because it allows us to configure the OAuth 2.0 clients that the client will use to access protected resources. This is important because it ensures that the client has the correct authorization to access the resources.

### DefaultSecurityConfig.java
You are setting up default security configuration like login page and any url needs to be authenticated.

### WebClientConfig.java
You are setting up a WebClient bean in a Spring application for making authenticated requests to other services using OAuth 2.0. This WebClient will be able to make requests on behalf of an authorized user using the OAuth 2.0 authorization code flow.

## Controller

### StudentController.java
In this controller, the apis are redirected to the resource server to retrieve the data. 

When client hits the endpoint using client's port, after authentication & authorization, it will redirect to the resource and display the content of the requested endpoint.

## API References

### Port

The port of authorization server is 8080.

### Endpoint

In Client, you can access the protected resources using webclient, and can also define some other endpoints, only for client.
## Dependencies

- spring-boot-starter-web
-  spring-boot-starter-data-jpa
- mysql-connector-j
- spring-boot-starter-security
- spring-boot-starter-oauth2-client
- spring-webflux