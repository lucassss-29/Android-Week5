package com.thesis.week5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
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
        setContentView(R.layout.activity_splash)
//        supportFragmentManager.commit {
//            setReorderingAllowed(true)
//            add<Onboarding1Activity>(R.id.fragment_container_view)
//        }

        Handler().postDelayed({
            setContentView(R.layout.activity_main)
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<Onboarding1Activity>(R.id.fragment_container_view)
            }
        }, 3000)

    }
}