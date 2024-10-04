package com.ascoder1109.securekey.ui.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ascoder1109.securekey.data.model.User
import com.ascoder1109.securekey.data.repository.UserRepository
import kotlinx.coroutines.launch

class SignupViewModel(private val userRepository: UserRepository): ViewModel() {
    var name by mutableStateOf("")
    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var signupResult by mutableStateOf<Result<User>?>(null)

    fun signup(){
        viewModelScope.launch {
            signupResult = userRepository.signup(name, email, password)
        }

    }
}