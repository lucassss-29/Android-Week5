package com.thesis.week5.activity.welcome

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.thesis.week5.R
import com.google.android.material.button.MaterialButton
import android.widget.TextView
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.thesis.week5.SignInActivity
import com.thesis.week5.SignUpActivity
import androidx.fragment.app.replace

class WelcomeActivity : Fragment() {
    private lateinit var btnStart : MaterialButton
    private lateinit var btnSignIn: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_welcome, container, false)
        return view
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
//        findViewsById()
//        setupViews()
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnStart = view.findViewById(R.id.btn_start)
        btnSignIn = view.findViewById(R.id.btn_sign_in)

//        btnStart.setOnClickListener {
//            parentFragmentManager.commit {
//                setReorderingAllowed(true)
//                replace<SignUpActivity>(R.id.fragment_container_view)
//                addToBackStack(null)
//            }
//        }

        btnSignIn.setOnClickListener {
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace<SignInActivity>(R.id.fragment_container_view)
                addToBackStack(null)
            }
        }
    }

    }

//    private fun findViewsById(){
//        btnStart = findViewById(R.id.btn_start)
//        btnSignIn = findViewById(R.id.btn_sign_in)
//    }
//
//    private fun setupViews(){
//        btnStart.setOnClickListener {
//            val intent = Intent(this, SignUpActivity::class.java)
//            startActivity(intent)
//        }
//
//        btnSignIn.setOnClickListener {
//            val intent = Intent(this, SignInActivity::class.java)
//            startActivity(intent)
//        }
//    }
