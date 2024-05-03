package kz.tutorial.jsonplaceholdertypicode.presentation.users.user_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.constants.ID
import kz.tutorial.jsonplaceholdertypicode.constants.USER_ID
import kz.tutorial.jsonplaceholdertypicode.domain.entity.User
import kz.tutorial.jsonplaceholdertypicode.presentation.extensions.openEmailWithAddress
import kz.tutorial.jsonplaceholdertypicode.presentation.users.UsersAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class UserDetailsFragment : Fragment() {


    private val vm: UserViewModel by viewModel {
        parametersOf(arguments?.getInt(ID, USER_ID) ?: USER_ID)
    }
    private val user: Boolean by lazy {
        (arguments?.getInt(ID, USER_ID) ?: USER_ID) == USER_ID
    }

    lateinit var username_title: TextView
    lateinit var user_info_email: TextView
    lateinit var user_info_fist_name: TextView
    lateinit var user_last_name: TextView
    lateinit var user_info_website: TextView
    lateinit var cvUserInfo: CardView
    lateinit var cvUserCompany: CardView
    lateinit var cvUserAddress: CardView

    lateinit var userAdapter: UsersAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_user_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initViews(view)
        initAdapter()
        initObservers()
    }

    private fun initViews(view: View) {
        username_title = view.findViewById(R.id.tv_username_title)
        user_info_email = view.findViewById(R.id.tv_user_info_email)
        user_info_fist_name = view.findViewById(R.id.tv_user_info_name)
        user_last_name = view.findViewById(R.id.tv_user_info_phone)
        user_info_website = view.findViewById(R.id.tv_user_info_website)
        cvUserInfo = view.findViewById(R.id.user_info_card)
        cvUserCompany = view.findViewById(R.id.user_company_card)
        cvUserAddress = view.findViewById(R.id.tv_author)
    }

    private fun initAdapter() {
        userAdapter = UsersAdapter(layoutInflater) { email ->
            context?.openEmailWithAddress(email)
        }
    }

    private fun initObservers() {
        vm.userDetailsLiveData.observe(viewLifecycleOwner){ user->
            user?.let {
                username_title.text = user.username
                initInfo(user)
                view?.findViewById<TextView>(R.id.tv_user_company_name)?.text = "company"
//                view?.findViewById<TextView>(R.id.tv_user_address)?.text = user.address
            }
        }
    }

    private fun initInfo(user: User) {
        user_info_email.text = user.email
        user_info_fist_name.text = user.first_name
        user_last_name.text = user.last_name
        user_info_website.text = "empty"
    }


}