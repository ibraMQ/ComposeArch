package com.example.composearch.login.presentation.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.composearch.login.presentation.composables.LoginFormComposable
import com.example.composearch.login.presentation.viewmodels.LoginViewModel
import com.example.composearch.login.presentation.viewmodels.LoginViewModelFactory
import com.example.composearch.ui.theme.ComposeArchTheme

class LoginActivity : ComponentActivity() {
    private val viewModel: LoginViewModel by viewModels { LoginViewModelFactory() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: LoginViewModel by viewModels { LoginViewModelFactory() }

        setContent {
            ComposeArchTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LoginFormComposable(viewModel,{
                        viewModel.login()
                    })
                }
            }
        }
    }
}
