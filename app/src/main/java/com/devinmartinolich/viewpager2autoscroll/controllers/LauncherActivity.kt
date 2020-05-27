package com.devinmartinolich.viewpager2autoscroll.controllers

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle
import android.view.ContextMenu
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.devinmartinolich.viewpager2autoscroll.R
import com.devinmartinolich.viewpager2autoscroll.adapters.ViewPagerAdapter
import com.devinmartinolich.viewpager2autoscroll.models.UpdatesSeriesModel
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_launcher.*

class LauncherActivity : AppCompatActivity(){
    companion object {
        private const val TAG = "LauncherActivity"
        private const val timerDelay: Long = 10 * 1000 // 10 seconds in milliseconds
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val handler = Handler()

        setContentView(R.layout.activity_launcher)

        val updates = listOf(
            UpdatesSeriesModel(
                "New updates available!",
                "Everything you\'ve been asking for.",
                "Take the quick tour.",
                R.drawable.device_frame
            ),
            UpdatesSeriesModel(
                "What?! New?!",
                "Productivity like never before.",
                "Get it done faster.",
                R.drawable.device_frame
            ),
            UpdatesSeriesModel(
                "Cool ViewPager2",
                "Don\'t let it bore you, make it work!",
                "Make it look better.",
                R.drawable.device_frame
            )
        )

        pager.adapter = ViewPagerAdapter(updates)

        TabLayoutMediator(tabIndicator, pager) { tab, position ->
            pager.setCurrentItem(tab.position, true)
        }.attach()

        pager.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                handler.removeMessages(0)

                if (position == 0) btnBack.visibility = View.GONE
                else btnBack.visibility = View.VISIBLE

                val runnable = Runnable { pager.currentItem = position + 1 }

                if (position < pager.adapter?.itemCount ?: 0) {
                    handler.postDelayed(runnable, timerDelay)
                }
            }
        })

        btnSkip.setOnClickListener { loadMain() }

        btnBack.setOnClickListener { onBackPressed() }

        btnForward.setOnClickListener {
            if (pager.currentItem < pager.adapter?.itemCount!! - 1) {
                pager.currentItem = ++pager.currentItem
            } else loadMain()
        }
    }

    override fun onBackPressed() {
        if (pager.currentItem == 0) super.onBackPressed()
        else pager.currentItem = --pager.currentItem
    }

    fun loadMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        this.finish()
    }
}