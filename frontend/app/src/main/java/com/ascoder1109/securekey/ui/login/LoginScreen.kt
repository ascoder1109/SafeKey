package com.ascoder1109.securekey.ui.login

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.PasswordVisualTransformation

@Composable
fun LoginScreen(viewModel: LoginViewModel){
    TextField(
        value =  viewModel.email,
        onValueChange = {viewModel.email = it},
        label = { Text("Email")}
    )
    TextField(
        value =  viewModel.password,
        onValueChange = {viewModel.password = it},
        label = { Text("Password")},
        visualTransformation = PasswordVisualTransformation()
    )
    Button(onClick = { viewModel.login() }) {
        Text("Login")
    }
    viewModel.loginResult?.let { result ->
        // Handle login result
    }
}