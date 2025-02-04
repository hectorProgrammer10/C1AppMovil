package com.example.c1moviles.drogstore.home.presentations
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel



class ProductosViewModel () : ViewModel() {
    private var _nombre = MutableLiveData<String>()
    val nombre : LiveData<String> = _nombre

    private var _precio = MutableLiveData<Float>()
    val precio : LiveData<Float> = _precio

    private var _cantidad = MutableLiveData<Int>()
    val cantidad : LiveData<Int> = _cantidad

    private var _receta = MutableLiveData<String>()
    val receta : LiveData<String> = _receta
    /////////////////////////////////////
    fun onChangeNombre(nombre : String) {
        _nombre.value = nombre
    }
    fun onChangePrecio(precio : Float) {
        _precio.value = precio
    }
    fun onChangeCantidad(cantidad : Int) {
        _cantidad.value = cantidad
    }
    fun onChangeReceta(receta : String) {
        _receta.value = receta
    }

}