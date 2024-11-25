package com.example.koty.entity

import jakarta.persistence.*

@Entity
@Table(name = "oauth2_clients")
class OAuth2Client(
    @Id
    var id: String,
    
    var clientId: String,
    var clientSecret: String,
    var clientAuthenticationMethods: String, // Stored as comma-separated values
    var authorizationGrantTypes: String, // Stored as comma-separated values
    var redirectUris: String, // Stored as comma-separated values
    var scopes: String, // Stored as comma-separated values
) 