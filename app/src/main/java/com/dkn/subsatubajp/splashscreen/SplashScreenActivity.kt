package com.dkn.subsatubajp.splashscreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.dkn.subsatubajp.databinding.ActivitySplashScreenBinding
import com.dkn.subsatubajp.home.HomeActivity

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var splashBinding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashBinding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(splashBinding.root)

        setUpSplashScreen()
    }

    private fun setUpSplashScreen() {
        Handler(Looper.getMainLooper()).postDelayed({
            Intent(this, HomeActivity::class.java).apply {
                startActivity(this)
                finish()
            }
        }, 1000)
    }
}