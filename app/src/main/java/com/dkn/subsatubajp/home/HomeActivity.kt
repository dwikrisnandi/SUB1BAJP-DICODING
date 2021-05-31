package com.dkn.subsatubajp.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dkn.subsatubajp.databinding.ActivityHomeBinding
import com.dkn.subsatubajp.main.SectionsPagerAdapter

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        binding.viewPager.apply {
            adapter = sectionsPagerAdapter
            binding.tabs.setupWithViewPager(this)
        }

    }
}