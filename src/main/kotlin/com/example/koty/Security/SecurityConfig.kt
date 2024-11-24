package com.example.koty.Security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.config.annotation.web.invoke
import org.springframework.web.cors.CorsConfiguration

@Configuration
@EnableWebSecurity
class SecurityConfig {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http {
            cors { corsConfiguration() }
            csrf { disable() }
            httpBasic { disable() }
            formLogin { disable() }
            
            oauth2Login {
                loginPage = "/oauth2/authorization/google"
                defaultSuccessUrl("/", true)
            }
            
            authorizeRequests {
                authorize("/", permitAll)
                authorize("/error", permitAll)
                authorize("/webjars/**", permitAll)
                authorize("/oauth2/**", permitAll)
                authorize(anyRequest, authenticated)
            }
        }

        return http.build()
    }
}

fun corsConfiguration(): CorsConfiguration {
    val corsConfiguration = CorsConfiguration()
    corsConfiguration.allowedOrigins = listOf("http://localhost:3000")
    corsConfiguration.allowedMethods = listOf("GET", "POST", "PUT", "DELETE")
    corsConfiguration.allowedHeaders = listOf("*")
    return corsConfiguration
}