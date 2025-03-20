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

## Dependencies

- spring-boot-starter-web
- spring-boot-starter-security
- spring-security-oauth2-authorization-server
