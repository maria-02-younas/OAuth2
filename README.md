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

# Introduction

Here, I have implemented Authorization Server of OAuth2 for grant type authorization code. The flow begins with the resource server redirecting the user to the Authorization Server for authentication. Upon successful login and user consent, the Authorization Server generates an authorization code and sends it back to the specified redirect URI. The client then exchanges this code with the Authorization Server for an access token and, optionally, a refresh token. The Authorization Server validates the code, checks user permissions, and issues the tokens accordingly. The resource server uses the access token to request and access protected resources on behalf of the user.

## Configuration

### AuthServerConfig.java

This file configures authorization server. First, it registers client using client-id, client-secret, defines authentication method, authorization grant types, redirect uris, scope etc. Then , you need to do configuration for access token like generate RSA Key, public key, private key, and then decide it. You need to define issuer url in */etc/hosts* file on your computer to remove any conflicts when working on resource server and client.

This configuration first gives you authorization code and from that authorization code, you will get access token which is used to access your protected endpoint. 

### WebConfig.java

In this file, your web configuration will be defined and also, the user too. You will also configure authentication provider to manage authentication and verifying the users.

## API References

### Port

The port of authorization server is 9000.

### Endpoint

There will be multiple endpoints for multiple functionalities. You can check all those endpoints in _".well-known/configuration"_ endpoint.

## Dependencies

- spring-boot-starter-web
- spring-boot-starter-security
- spring-security-oauth2-authorization-server
