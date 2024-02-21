package com.example.mk1.presentation.activities


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mk1.R
import com.example.data.repository.UserRepositoryImpl
import com.example.data.storage.SharedPrefUserStorage
import com.example.data.storage.UserStorage
import com.example.domain.models.SaveUserName
import com.example.domain.models.UserName
import com.example.domain.usecase.GetUserNameUseCase
import com.example.domain.usecase.SaveUserNameUseCase
import com.example.mk1.presentation.MainViewModelFactory
import com.example.mk1.presentation.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.e("AAA", "Activity created")

        viewModel = ViewModelProvider(this, MainViewModelFactory(this))
            .get(MainViewModel::class.java)


        var dataTextEdit = findViewById<EditText>(R.id.editTextSetData)
        var dataTextView = findViewById<TextView>(R.id.textView)
        val sendButton = findViewById<Button>(R.id.btnSetData)
        val receiveButton = findViewById<Button>(R.id.btnShowData)


        viewModel.resultLive.observe(this) { text ->
            dataTextView.text = text
        }

        sendButton.setOnClickListener(){
            val text = dataTextEdit.text.toString()
            viewModel.save(text)
        }

        receiveButton.setOnClickListener(){
            viewModel.load()
        }
    }
}
