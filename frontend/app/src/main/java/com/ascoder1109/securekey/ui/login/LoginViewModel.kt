package com.ascoder1109.securekey.ui.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ascoder1109.securekey.data.model.User
import com.ascoder1109.securekey.data.repository.UserRepository
import kotlinx.coroutines.launch

class LoginViewModel (private val userRepository: UserRepository) : ViewModel(){
    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var loginResult by mutableStateOf<Result<User>?>(null)

    fun login(){
        viewModelScope.launch {
            loginResult = userRepository.login(email,password)
        }
    }
}