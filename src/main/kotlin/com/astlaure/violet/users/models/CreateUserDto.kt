package com.astlaure.violet.users.models

class CreateUserDto(
    val name: String,
    val username: String,
    val password: String,
    val confirmation: String,
) { }