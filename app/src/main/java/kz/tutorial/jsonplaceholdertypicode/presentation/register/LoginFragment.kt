package kz.tutorial.jsonplaceholdertypicode.presentation.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.constants.POST_ID_KEY
import kz.tutorial.jsonplaceholdertypicode.presentation.post_details.PostDetailsFragmentDirections

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {

    lateinit var tvRegister: TextView
    lateinit var btnLogin: Button


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
//            findNavController().navigate(MenuPo)
        }
    }

    private fun initViews(view: View) {
        tvRegister = view.findViewById(R.id.tv_register)
        btnLogin = view.findViewById(R.id.login_btn)
    }

}