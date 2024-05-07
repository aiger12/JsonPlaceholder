package kz.tutorial.jsonplaceholdertypicode.presentation.register

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.domain.request.LoginRequest
import org.koin.androidx.viewmodel.ext.android.viewModel
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {

    lateinit var tvRegister: TextView
    lateinit var btnLogin: Button
    lateinit var usernameInput: EditText
    lateinit var passwordInput: EditText

    private val loginViewModel: LoginViewModel by viewModel()



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)

        tvRegister.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToRegisterFragment())
        }

        btnLogin.setOnClickListener {
            val username = usernameInput.text.toString()
            val password = passwordInput.text.toString()
            val loginRequest = LoginRequest(username, password)
            loginViewModel.login(username, password) { success ->
                if (success) {
                    findNavController().navigate(R.id.action_loginFragment_to_nav_second)
                } else {
                    // Handle login failure
                }
            }

        }


    }

    private fun initViews(view: View) {
        tvRegister = view.findViewById(R.id.tv_register)
        btnLogin = view.findViewById(R.id.login_btn)
        usernameInput = view.findViewById(R.id.username_input)
        passwordInput = view.findViewById(R.id.password_input)
    }

    private fun login(loginRequest: LoginRequest) {
        CoroutineScope(Dispatchers.IO).launch {
        }
    }


}
