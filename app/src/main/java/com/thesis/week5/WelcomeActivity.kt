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
import com.thesis.week5.SignInActivity
import com.thesis.week5.SignUpActivity

class WelcomeActivity : AppCompatActivity() {
    private lateinit var btnStart : MaterialButton
    private lateinit var btnSignIn: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_welcome)
        findViewsById()
        setupViews()
    }

    private fun findViewsById(){
        btnStart = findViewById(R.id.btn_start)
        btnSignIn = findViewById(R.id.btn_sign_in)
    }

    private fun setupViews(){
        btnStart.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        btnSignIn.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }
    }
}