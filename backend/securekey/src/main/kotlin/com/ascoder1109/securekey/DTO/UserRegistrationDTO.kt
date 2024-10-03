package com.ascoder1109.securekey.DTO

import lombok.Data

@Data
data class UserRegistrationDTO(
    val name: String,
    val email: String,
    val password: String
)