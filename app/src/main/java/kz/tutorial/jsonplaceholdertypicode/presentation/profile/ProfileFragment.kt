package kz.tutorial.jsonplaceholdertypicode.presentation.profile

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.presentation.register.RetrofitClient
import kz.tutorial.jsonplaceholdertypicode.presentation.register.TokenManager
import org.json.JSONObject

class ProfileFragment : Fragment() {
    lateinit var username: TextView
    lateinit var name: TextView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        initViews(view)
        val token = TokenManager.getToken(requireContext())
        val userId = JSONObject(TokenManager.decodeToken(token)).getString("username").toInt()
        lifecycleScope.launch {
            val response = try {
                val user = RetrofitClient.apiService.getUser(userId)
                username.text = user.username
                name.text = user.name
            } catch (e: Exception) {
                Log.d("ProfileFragment", "Error: ${e.message}")
                return@launch
            }
        }

    }

    private fun initViews(view: View) {
        username = view.findViewById(R.id.titleUsername)
        name = view.findViewById(R.id.titleName)
    }

}