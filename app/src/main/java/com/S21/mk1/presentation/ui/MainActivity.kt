package com.S21.mk1.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.S21.mk1.databinding.ActivityMainBinding
import com.S21.mk1.myapp.MyApp
import com.S21.mk1.presentation.viewmodels.MainViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    @Inject
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as MyApp).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnGetData = binding.btnGetData

        btnGetData.setOnClickListener {
            mainViewModel.getProducts()
        }

    }
}