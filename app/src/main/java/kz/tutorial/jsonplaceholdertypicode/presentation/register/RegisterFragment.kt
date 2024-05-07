package kz.tutorial.jsonplaceholdertypicode.presentation.register

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import kz.tutorial.jsonplaceholdertypicode.R
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 * A simple [Fragment] subclass.
 * Use the [RegisterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegisterFragment : Fragment() {
    lateinit var username: EditText
    lateinit var password: EditText
    lateinit var firstname: EditText
    lateinit var lastname: EditText
    lateinit var email: EditText
    lateinit var repeatPassword: EditText
    lateinit var btnRegister: Button



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initViews(view)
        btnRegister.setOnClickListener {
            val usernameText = username.text.toString()
            val passwordText = password.text.toString()
            val firstnameText = firstname.text.toString()
            val lastnameText = lastname.text.toString()
            val emailText = email.text.toString()
            val repeatPasswordText = repeatPassword.text.toString()
//          Log.i("", "username: $usernameText")
//            Log.i("", "firstname: $firstnameText")
//            Log.i("", "lastname: $lastnameText")
//            Log.i("", "password: $passwordText")
//            Log.i("", "rep password: $repeatPasswordText")
//            Log.i("", "email: $emailText")
//            Log.i("", "createdAt: $createdAt")


        }
    }

    private fun initViews(view: View) {
        username = view.findViewById(R.id.username_input)
        password = view.findViewById(R.id.password_input)
        firstname = view.findViewById(R.id.firstname_input)
        lastname = view.findViewById(R.id.lastname_input)
        email = view.findViewById(R.id.email_input)
        repeatPassword = view.findViewById(R.id.repeat_password_input)
        btnRegister =  view.findViewById(R.id.register_btn)
    }
}