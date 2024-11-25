package com.example.koty.controller

import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController("/")
class Controller {


    @GetMapping("hello")
    fun getHello():String {
        return "hello"
    }

    @GetMapping("world")
    @PreAuthorize("hasRole('USER')")
    fun getWorld():String {
        return "world"
    }
}