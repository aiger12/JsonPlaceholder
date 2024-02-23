package kz.tutorial.jsonplaceholdertypicode.presentation.users.user_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.constants.ID
import kz.tutorial.jsonplaceholdertypicode.constants.USER_ID
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class UserDetailsFragment : Fragment() {

    private val user: Boolean by lazy {
        (arguments?.getInt(ID, USER_ID) ?: USER_ID) == USER_ID
    }
    private val vm: UserViewModel by viewModel {
        parametersOf(arguments?.getInt(ID, USER_ID) ?: USER_ID)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_user_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        initAdapter()
//        initRecycler()
//        initObservers()
    }


}