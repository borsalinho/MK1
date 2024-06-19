package com.s21.domain.repository

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Repository(
    private val dataRepository: DataRepository,
    private val networkRepository: NetworkRepository
) {

    fun getData(){
        Log.e("MyLogs", "i am a getData")
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val res = networkRepository.getDataFromApi()
                Log.e("MyLogs", res.toString())
            } catch (e:Exception){
                Log.e("MyLogs", e.toString())
            }
        }

    }
}