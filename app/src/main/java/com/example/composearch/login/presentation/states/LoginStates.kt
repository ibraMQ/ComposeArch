package com.example.composearch.login.presentation.states

sealed class LoginStates {
    object SignedOut: LoginStates()
    object InProgress: LoginStates()
    object Error: LoginStates()
    object SignIn: LoginStates()
}