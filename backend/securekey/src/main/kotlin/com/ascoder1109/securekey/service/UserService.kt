package com.ascoder1109.securekey.service

import com.ascoder1109.securekey.model.User
import com.ascoder1109.securekey.repository.UserRepository
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    private val passwordEncoder = BCryptPasswordEncoder()

    fun registerUser(name: String, email: String, password: String): User {
        if (userRepository.findByEmail(email) != null) {
            throw IllegalArgumentException("User with email $email already exists")
        }
        val encodedPassword = passwordEncoder.encode(password)
        val user = User(name = name, email = email, password = encodedPassword)
        return userRepository.save(user)
    }

    fun authenticateUser(email: String, password: String): User? {
        val user = userRepository.findByEmail(email) ?: return null
        return if (passwordEncoder.matches(password, user.password)) user else null
    }
}