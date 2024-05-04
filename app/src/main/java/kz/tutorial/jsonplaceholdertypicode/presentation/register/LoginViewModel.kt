package kz.tutorial.jsonplaceholdertypicode.presentation.register

import android.net.Uri
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.tutorial.jsonplaceholdertypicode.domain.entity.User
import kz.tutorial.jsonplaceholdertypicode.domain.use_case.LoginUseCase
import timber.log.Timber


class LoginViewModel(private val loginUseCase: LoginUseCase) : ViewModel() {

    private val _loggedInUserLiveData: MutableLiveData<User> = MutableLiveData()
    val loggedInUserLiveData: LiveData<User> = _loggedInUserLiveData


    // Method to perform login
    fun login(username: String, password: String, callback: (Boolean) -> Unit) {
        viewModelScope.launch {

                loginUseCase.login(username, password)?.apply {
                    if(isSuccessful){

                    }
                } // Update live data with logged-in user
        }
    }
}
