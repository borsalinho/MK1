package com.example.mk1.presentation.activities


import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.mk1.R
import com.example.mk1.app.App
import com.example.mk1.presentation.MainViewModelFactory
import com.example.mk1.presentation.viewmodel.MainViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: MainViewModelFactory

    private lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (applicationContext as App).appComponent.inject(this)

        Log.e("AAA", "Activity created")

        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(MainViewModel::class.java)








        val btnRes = findViewById<Button>(R.id.btnGet)
        btnRes.setOnClickListener{

        }









        /// ----------------------------------------------------
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
