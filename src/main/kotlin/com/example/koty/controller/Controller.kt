package com.example.koty.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.core.user.OAuth2User

@RestController("/")
class Controller {


    @GetMapping("hello")
    fun getHello():String {
        return "hello"
    }

    @GetMapping("/user")
    fun user(@AuthenticationPrincipal oauth2User: OAuth2User): MutableMap<String, Any>? {
        return oauth2User.attributes
    }
}