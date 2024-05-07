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
import androidx.navigation.fragment.findNavController
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.constants.POST_ID_KEY
import kz.tutorial.jsonplaceholdertypicode.presentation.post_details.PostDetailsFragment
import kz.tutorial.jsonplaceholdertypicode.presentation.post_details.PostDetailsFragmentDirections
import retrofit2.Call
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch


/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {

    lateinit var tvRegister: TextView
    lateinit var btnLogin: Button
    lateinit var username: EditText
    lateinit var password: EditText


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        initViews(view)
        tvRegister.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToRegisterFragment())
        }
        btnLogin.setOnClickListener {
            val username = username.text.toString()
            val password = password.text.toString()

            val request = LoginRequest(username, password)

                lifecycleScope.launch {
                    val response = try {
                        RetrofitClient.apiService.login(request)
                    } catch (e: Exception) {
                        Log.d("LoginFragment", "Error: ${e.message}")
                        return@launch
                    }

                    if (response.isSuccessful) {
                        val token = response.body()?.token
                        if (token != null) {
                            TokenManager.saveToken(requireContext(), token)
                            Log.d("LoginFragment", "Token: $token")
                        }
                    } else {
                        Log.d("LoginFragment", "Error: ${response.errorBody()?.string()}")
                    }
                }
        }
    }

    private fun initViews(view: View) {
        tvRegister = view.findViewById(R.id.tv_register)
        btnLogin = view.findViewById(R.id.login_btn)
        username = view.findViewById(R.id.username_input)
        password = view.findViewById(R.id.password_input)
    }

}