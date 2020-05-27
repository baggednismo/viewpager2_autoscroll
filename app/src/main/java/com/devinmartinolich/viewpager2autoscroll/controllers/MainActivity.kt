package com.devinmartinolich.viewpager2autoscroll.controllers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import com.devinmartinolich.viewpager2autoscroll.R
import com.devinmartinolich.viewpager2autoscroll.views.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
                .beginTransaction()
                .replace(
                        R.id.flContainer,
                        Fragment.instantiate(this, MainFragment::class.java.name))
                .commit()
    }

}
