package com.example.c1moviles.drogstore.registerStrore.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.c1moviles.drogstore.registerStrore.data.datasource.postStore
import com.example.c1moviles.drogstore.registerStrore.data.model.Farmacia
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterStoreViewModel  @Inject constructor() : ViewModel() {
    // LiveData para los datos del formulario
    private val _name = MutableLiveData("")
    val name: LiveData<String> = _name
    private val _place = MutableLiveData("")
    val place: LiveData<String> = _place



    private val _registrationStatus = MutableLiveData<Boolean>()
    val registrationStatus: LiveData<Boolean> = _registrationStatus


    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage


    fun onChangeName(name: String) { _name.value = name }
    fun onChangePlace(place: String) { _place.value = place }


    fun registerStore() {
        viewModelScope.launch {
            Log.d("RegisterStoreViewModel", "Llamando a postStore()")
            val farmacia = Farmacia(
                name = _name.value ?: "",
                place = _place.value ?: ""
            )
            val result = postStore(farmacia)

            if (result) {
                _registrationStatus.value = true
                _errorMessage.value = null  // Limpia cualquier error anterior
            } else {
                _registrationStatus.value = false
                _errorMessage.value = "Error al registrar. Verifica los datos e inténtalo nuevamente."
            }

            Log.d("RegisterViewModel", "Resultado de postUser(): $result")
        }
    }
}