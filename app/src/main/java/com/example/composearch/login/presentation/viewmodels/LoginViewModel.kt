package com.example.composearch.login.presentation.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composearch.login.presentation.states.LoginStates
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel(){
    private val dumUser = "ibra@gmail"
    private val dumPass = "ibra"

    private val _login = MutableLiveData<LoginStates>(LoginStates.SignedOut)
    val login: LiveData<LoginStates> = _login


    private val _loginState = MutableLiveData("Desconcetado")
    val loginState : LiveData<String> = _loginState

    private val _user = MutableLiveData("")
    val  user : LiveData<String> = _user
    fun setUser (user:String){ _user.value = user}

    private val _password = MutableLiveData("")
    val  password : LiveData<String> = _password
    fun setPassword (password:String){ _password.value = password}

    fun login(){
        viewModelScope.launch (Dispatchers.IO) {
            _loginState.postValue("Iniciando sesión")
            delay(5000)
            if (user.value == dumUser && password.value == dumPass){
                _loginState.postValue("Bienvenido")
            } else{
                _loginState.postValue("Error")
            }
        }
    }
}