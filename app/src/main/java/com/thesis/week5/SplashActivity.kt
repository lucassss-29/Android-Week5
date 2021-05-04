package com.thesis.week5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.thesis.week5.Restaurant.RestaurantActivity

//import com.thesis.week5.Onboarding.Onboarding1Activity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
//            setContentView(R.layout.activity_main)
//            supportFragmentManager.commit {
//                setReorderingAllowed(true)
//                add<RestaurantActivity>(R.id.fragment_container_view)
//            }
            val intent = Intent(this, RestaurantActivity::class.java)
            startActivity(intent)
        }, 3000)
    }
}