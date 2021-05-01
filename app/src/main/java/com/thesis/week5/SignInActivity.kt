package com.thesis.week5

import com.thesis.week5.R
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.thesis.week5.databinding.ActivitySignInBinding
import androidx.fragment.app.replace


class SignInActivity : Fragment() {

    companion object {
        const val USER_KEY = "USER_KEY"
    }

    private lateinit var binding: ActivitySignInBinding
    private lateinit var viewModel: SignInViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : ActivitySignInBinding = DataBindingUtil.inflate(inflater, R.layout.activity_sign_in,container,false)
        val view : View = binding.getRoot()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModelBinding()
    }

    private fun setupViewModelBinding() {
        viewModel = ViewModelProvider(this).get(SignInViewModel::class.java)
        binding.lifecycleOwner = this
        binding.signInViewModel = viewModel
        binding.apply {
            btnSignUp.setOnClickListener {
                parentFragmentManager.commit {
                    setReorderingAllowed(true)
                    replace<SignUpActivity>(R.id.fragment_container_view)
                    addToBackStack(null)
                }
            }

        }

        viewModel.isSignInSucceed.observe(this, Observer { user ->
            user?.let {
                showToastMessage("Sign in Successful")
                startRestaurantActivity(user)
            }

        })

        viewModel.errorMessage.observe(this, Observer { message ->
            message?.let {
                showToastMessage(message)
            }
        })
    }

    private fun startRestaurantActivity(user: User) {
//        val bundle = Bundle()
//        bundle.putParcelable(USER_KEY, user)
        parentFragmentManager.commit {
            setReorderingAllowed(true)
            replace<RestaurantActivity>(R.id.fragment_container_view)
            addToBackStack(null)
        }
    }

    private fun showToastMessage(value: String) {
        Toast.makeText(this@SignInActivity, value, Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        viewModel.clear()
    }
}