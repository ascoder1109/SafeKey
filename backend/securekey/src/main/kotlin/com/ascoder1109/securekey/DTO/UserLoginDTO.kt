package com.ascoder1109.securekey.DTO

import lombok.Data

@Data
data class UserLoginDTO(
    val email: String,
    val password: String
)