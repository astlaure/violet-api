package com.astlaure.violet.users

import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*

@ExtendWith(MockitoExtension::class)
class UserServiceTests {
    @Mock
    lateinit var userRepository: UserRepository

    @Test
    fun `return user on successful load`() {
        val userService = UserService(userRepository)
        Mockito.`when`(userRepository.findByUsername(Mockito.anyString()))
            .thenReturn(Optional.of(User(
                name = "Bob The Builder",
                username = "bob@test.io",
                password = "encodedPassword",
            )))

        val userDetails = userService.loadUserByUsername("bob@test.io")
        MatcherAssert.assertThat(userDetails.username, Matchers.`is`("bob@test.io"))
    }
}