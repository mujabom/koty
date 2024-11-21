package com.example.koty.Security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.config.annotation.web.invoke

@Configuration
@EnableWebSecurity
class SecurityConfig {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http {
            cors {
                disable()
            }
            csrf { }
            httpBasic { }
            formLogin { }
            authorizeRequests { authorize("/hello", authenticated) }
            authorizeRequests { authorize(anyRequest, permitAll) }

        }

        return http.build()
    }

}
