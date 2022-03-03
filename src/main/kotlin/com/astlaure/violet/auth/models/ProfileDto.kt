package com.astlaure.violet.auth.models

import com.astlaure.violet.users.enums.UserRole

class ProfileDto(
    val id: Long,
    val name: String,
    val username: String,
    val role: UserRole,
) { }