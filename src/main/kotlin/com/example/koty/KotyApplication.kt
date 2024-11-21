package com.example.koty

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotyApplication

fun main(args: Array<String>) {
    runApplication<KotyApplication>(*args)
}
