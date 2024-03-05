package com.example.mk1.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.models.Products
import com.example.domain.models.SaveUserName
import com.example.domain.models.UserName
import com.example.domain.usecase.GetUserNameUseCase
import com.example.domain.usecase.SaveUserNameUseCase

class MainViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
    ) : ViewModel() {


    private var listResultLiveMutable = MutableLiveData<Products>()
    private var textResultLiveMutable = MutableLiveData<String>()
    val resultText: LiveData<String> = textResultLiveMutable


    //-------------------------------------------------------
    private var resultLiveMutable = MutableLiveData<String>()
    val resultLive: LiveData<String> = resultLiveMutable

    init {
        Log.e("AAA", "VM created")
    }

    override fun onCleared() {
        Log.e("AAA", "VM cleared")
        super.onCleared()
    }
    // --------------------------------------------------------



    fun loadFromServer(){

//        val products
//        listResultLiveMutable.value
    }








    //-----------------------------------------------------------

    fun save(text: String){
        val params = SaveUserName(name = text)
        val result : Boolean = saveUserNameUseCase.execute(param = params)
        resultLiveMutable.value = "result = $result"
    }

    fun load(){
        val userName : UserName = getUserNameUseCase.execute()
        resultLiveMutable.value = "${userName.firstName} ${userName.lastName}"

    }
}