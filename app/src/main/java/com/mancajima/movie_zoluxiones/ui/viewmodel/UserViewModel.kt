package com.mancajima.movie_zoluxiones.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mancajima.movie_zoluxiones.domain.usescase.LoginUseCase
import com.mancajima.movie_zoluxiones.domain.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
): ViewModel(){
    val userModel = MutableLiveData<User>()
    val isLoading = MutableLiveData<Boolean>()
    val isLoginUser = MutableLiveData<Boolean>()

    fun onInsertUser(user:String, password:String, name:String){

        viewModelScope.launch(Dispatchers.IO) {
            loginUseCase.insertUser(user, password, name)
        }
    }

    fun getUserLogin(user:String, password:String){
        Log.i("USER", "INIT_SCOPE")
        viewModelScope.launch(Dispatchers.IO) {
            isLoading.postValue(true)
            val result = loginUseCase.getUserLogin(user, password)
            delay(1500)
            if(!result.isNullOrEmpty()){
                userModel.postValue(result[0])
                isLoginUser.postValue(true)
                Log.i("USER", "FOUND/TRUE")
            }else{
                isLoginUser.postValue(false)
                Log.i("USER", "FALSE")
            }

            isLoading.postValue(false)
        }
        Log.i("USER", "END_SCOPE")
    }
}