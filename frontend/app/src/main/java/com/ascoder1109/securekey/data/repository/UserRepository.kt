package com.ascoder1109.securekey.data.repository

import com.ascoder1109.securekey.data.model.User

class UserRepository{
    suspend fun login(email: String, password: String): Result<User>{

    }

    suspend fun signup(name: String, email: String, password: String): Result<User>{

    }
}