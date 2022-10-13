package com.example.composearch.login.presentation.composables

import android.widget.Button
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearch.login.presentation.states.LoginStates
import com.example.composearch.login.presentation.viewmodels.LoginViewModel

//@Preview(showBackground = true)
@Composable
fun LoginFormComposable(viewModel: LoginViewModel, actionButton: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val state = viewModel.loginState.observeAsState("")
        val user = viewModel.user.observeAsState("")
        val password = viewModel.password.observeAsState("")

        Text(text = "Bienvenido",
            color = Color.LightGray,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(10.dp)
        )
        OutlinedTextField(
            value = user.value,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            label = { Text(text = "Nombre")},
            onValueChange = {
                viewModel.setUser(it)
            }
        )
        OutlinedTextField(
            value = password.value,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            label = { Text(text = "Contraseña")},
            onValueChange = {
                viewModel.setPassword(it)
            }
        )
        Button(onClick = actionButton,
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = "Acceder")
        }
        Text(text = state.value)

    }
}

@Composable
fun LoginStateText(state: LoginStates?){
    state.let {
        if(state is LoginStates.SignedOut)
            Text(text = "Desconectado")
        if(state is LoginStates.SignIn)
            Text(text = "Conectado")
        if(state is LoginStates.Error)
            Text(text = "Error")
        if(state is LoginStates.InProgress)
            Text(text = "Cargando")
    }
}