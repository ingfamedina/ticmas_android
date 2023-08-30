package com.ticmas.fmedina.evaluation.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ticmas.fmedina.evaluation.model.Comparador
import kotlinx.coroutines.launch
import java.util.Date

class MainViewModel: ViewModel() {

    // Solo queremos que se pueda leer el comparador
    val comparador: LiveData<Comparador> get() = _comparador
    // no nos interesa que se modifique por fuera del ViewModel
    private var _comparador = MutableLiveData<Comparador>(Comparador("", Date()))

    fun fnComparar(p1: String, p2: String) {
        val next: String
        if (p1 == p2) {
            next = "IGUALES"
        }
        else{
            next = "DISTINTOS"
        }
        updateResultado(next)
    }

    private fun updateResultado(next: String) {
        viewModelScope.launch {
            _comparador.value = Comparador(next, Date())
        }
    }
}