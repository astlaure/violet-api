package com.astlaure.violet.users

import com.astlaure.violet.users.enums.UserRole
import com.astlaure.violet.users.models.CreateUserDto
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
) : UserDetailsService {
    fun create(createUser: CreateUserDto) {
        val user = User(
            name = createUser.name,
            username = createUser.username,
            password = passwordEncoder.encode(createUser.password),
        )
        userRepository.save(user)
    }

    override fun loadUserByUsername(username: String): UserDetails {
        return userRepository.findByUsername(username).orElseThrow {
            UsernameNotFoundException("Provided username not found.")
        }
    }
}