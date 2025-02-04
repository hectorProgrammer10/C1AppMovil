package com.example.c1moviles.drogstore.register.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegisterViewModel() : ViewModel() {
    //private var _username = MutableLiveData<String>()
    private var _username = MutableLiveData<String>()
    val username : LiveData<String> = _username

    private var _password = MutableLiveData<String>()
    val password : LiveData<String> = _password

    private var _email = MutableLiveData<String>()
    val email : LiveData<String> = _email

    private var _nombre = MutableLiveData<String>()
    val nombre: LiveData<String> = _nombre

    fun onChangeUsername(username : String) {
        _username.value = username
    }

    fun onChangePassword (password : String) {
        _password.value = password
    }

    fun onChangeEmail (email : String) {
        _email.value = email
    }

    fun onChangeNombre (nombre : String) {
        _nombre.value = nombre
    }
}