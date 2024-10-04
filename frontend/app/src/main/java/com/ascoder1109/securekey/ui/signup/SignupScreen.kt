package com.ascoder1109.securekey.ui.signup

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.PasswordVisualTransformation

@Composable
fun SignupScreen(viewModel: SignupViewModel) {
    Column {
        TextField(
            value = viewModel.email,
            onValueChange = { viewModel.email = it },
            label = { Text("Email") }
        )
        TextField(
            value = viewModel.password,
            onValueChange = { viewModel.password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation()
        )
        Button(onClick = { viewModel.signup() }) {
            Text("Signup")
        }
        viewModel.signupResult?.let { result ->
            // Handle signup result
        }
    }
}