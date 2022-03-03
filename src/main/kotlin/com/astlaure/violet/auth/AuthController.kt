package com.astlaure.violet.auth

import com.astlaure.violet.auth.models.ProfileDto
import com.astlaure.violet.users.User
import com.astlaure.violet.users.UserService
import com.astlaure.violet.users.models.CreateUserDto
import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/auth")
class AuthController(
    private val userService: UserService,
) {

    @GetMapping("/profile")
    fun getProfile(authentication: Authentication): ResponseEntity<ProfileDto> {
        val user = authentication.principal as User
        return ResponseEntity.status(200).body(ProfileDto(
            id = user.id!!,
            name = user.name,
            username = user.username,
            role = user.role,
        ))
    }

    @PostMapping("/register")
    fun postRegister(@RequestBody createUser: CreateUserDto): ResponseEntity<Any> {
        userService.create(createUser)
        return ResponseEntity.status(201).build()
    }
}