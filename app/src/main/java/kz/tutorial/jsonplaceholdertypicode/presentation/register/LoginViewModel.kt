package kz.tutorial.jsonplaceholdertypicode.presentation.register

import android.net.Uri
import android.os.Handler
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kz.tutorial.jsonplaceholdertypicode.domain.entity.User
import kz.tutorial.jsonplaceholdertypicode.domain.use_case.LoginUseCase
import timber.log.Timber
import kotlin.system.exitProcess


class LoginViewModel(private val loginUseCase: LoginUseCase) : ViewModel() {

    private val _loggedInUserLiveData: MutableLiveData<User> = MutableLiveData()
    val loggedInUserLiveData: LiveData<User> = _loggedInUserLiveData

    // Method to perform login
    // Update the login method in LoginViewModel to accept a callback lambda

    // Update the login method in LoginViewModel to use withContext
    fun login(username: String, password: String, callback: (Boolean) -> Unit) {
        viewModelScope.launch {
            try {
                // Perform the network call on the IO dispatcher
                val response = withContext(Dispatchers.IO) {
                    loginUseCase.login(username, password)
                }

                // Check if response is not null and is successful
                if (response == null)
                    callback(false)
                else {
                    callback(true)
                }

            } catch (e: Exception) {
                // Handle exceptions
                Timber.e(e)
                // In case of an exception, notify the callback of failure
                callback(false)
            }
        }
    }


}
