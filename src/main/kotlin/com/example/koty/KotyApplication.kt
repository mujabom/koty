package com.example.koty

import com.example.koty.repository.User
import com.example.koty.repository.UserRepository
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.security.crypto.password.PasswordEncoder

@SpringBootApplication
class KotyApplication {
    @Bean
    fun init(userRepository: UserRepository,passwordEncoder: PasswordEncoder) = CommandLineRunner {
        // Check if user exists
        if (userRepository.findByUsername("user") == null) {
            // Create dummy user
            val user = User(
                username = "user",
                //encode password
                password = passwordEncoder.encode("password"),
                roles = "USER"
            )
            userRepository.save(user)
        }
    }
}

fun main(args: Array<String>) {
    runApplication<KotyApplication>(*args)
}
