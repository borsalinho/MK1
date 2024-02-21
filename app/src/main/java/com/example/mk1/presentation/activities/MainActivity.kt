package com.example.mk1.presentation.activities


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.mk1.R
import com.example.data.repository.UserRepositoryImpl
import com.example.data.storage.SharedPrefUserStorage
import com.example.data.storage.UserStorage
import com.example.domain.models.SaveUserName
import com.example.domain.models.UserName
import com.example.domain.usecase.GetUserNameUseCase
import com.example.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {

    // инициализация usecase'ов, потом перенесу на di
    private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
        UserRepositoryImpl(userStorage = SharedPrefUserStorage(context = applicationContext))
    }
    private val getUserNameUseCase  by lazy(LazyThreadSafetyMode.NONE) {
        GetUserNameUseCase(userRepository = userRepository)
    }
    private val saveUserNameUseCase  by lazy(LazyThreadSafetyMode.NONE) {
        SaveUserNameUseCase(userRepository = userRepository)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var dataTextEdit = findViewById<EditText>(R.id.editTextSetData)
        var dataTextView = findViewById<TextView>(R.id.textView)
        val sendButton = findViewById<Button>(R.id.btnSetData)
        val receiveButton = findViewById<Button>(R.id.btnShowData)

        sendButton.setOnClickListener(){
            val text = dataTextEdit.text.toString()
            val params = com.example.domain.models.SaveUserName(name = text)
            val result : Boolean = saveUserNameUseCase.execute(param = params)
            dataTextView.text = "result = $result"
        }

        receiveButton.setOnClickListener(){
            val userName : com.example.domain.models.UserName = getUserNameUseCase.execute()
            dataTextView.text = "${userName.firstName} ${userName.lastName}"
        }
    }
}
