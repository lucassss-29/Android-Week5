package com.thesis.week5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.thesis.week5.activity.welcome.WelcomeActivity
import com.thesis.week5.onboarding.Onboarding1Activity

//class SplashActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        supportFragmentManager.commit {
//            setReorderingAllowed(true)
//            add<WelcomeActivity>(R.id.fragment_container_view)
//        }
//    }
//}

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(this, RestaurantActivity::class.java)
        startActivity(intent)
    }
}