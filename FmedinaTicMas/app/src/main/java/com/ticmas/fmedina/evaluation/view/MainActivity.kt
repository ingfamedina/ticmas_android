package com.ticmas.fmedina.evaluation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.ticmas.fmedina.evaluation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()
/*
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.comparador.observe(this) {
            println("Recibimos un nuevo valor de comparador. $it")
            binding.lblResultado.text = "${it.resultado}"
        }

        binding.btnComparar.setOnClickListener {
            mainViewModel.fnComparar(binding.txtPalabra1.text.toString(),binding.txtPalabra2.text.toString())
        }

    }
}