package com.ascoder1109.securekey.controller

import com.ascoder1109.securekey.DTO.LoginRequestDTO
import com.ascoder1109.securekey.model.User
import com.ascoder1109.securekey.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class UserController(private val userService: UserService) {

    @PostMapping("/register")
    fun registerUser(@RequestBody user: User): ResponseEntity<Any> {
        return try {
            val registeredUser = userService.registerUser(user.name, user.email, user.password)
            ResponseEntity.ok(registeredUser)
        } catch (e: IllegalArgumentException) {
            ResponseEntity.status(HttpStatus.CONFLICT).body(mapOf("error" to e.message))
        }
    }

    @PostMapping("/login")
    fun loginUser(@RequestBody loginRequest: LoginRequestDTO): ResponseEntity<Any> {
        val user = userService.authenticateUser(loginRequest.email, loginRequest.password)
        return if (user != null) {
            ResponseEntity.ok(user)
        } else {
            ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(mapOf("error" to "Invalid email or password"))
        }
    }

    @ExceptionHandler(Exception::class)
    fun handleException(e: Exception): ResponseEntity<Map<String, String>> {
        val errorResponse = mapOf("error" to (e.message ?: "An error occurred"))
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse)
    }
}