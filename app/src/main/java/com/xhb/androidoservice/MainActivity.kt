package com.xhb.androidoservice

import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import com.xhb.androidoservice.service.EmptyService
import com.xhb.androidoservice.service.TestService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener {
            val intent = Intent(this@MainActivity, EmptyService::class.java)
                .apply {
                    putExtra("type", 1)
                }
            ContextCompat.startForegroundService(this, intent)
        }

        btn2.setOnClickListener {
            val intent = Intent(this@MainActivity, TestService::class.java)
                .apply {
                    putExtra("type", 1)
                }
            ContextCompat.startForegroundService(this, intent)
        }



        btn4.setOnClickListener {
            val intent = Intent(this@MainActivity, TestService::class.java)
            this@MainActivity.startService(intent)
        }

        btn6.setOnClickListener {
            val intent = Intent(this@MainActivity, TestService::class.java)
                .apply {
                    putExtra("type", 3)
                }
            ContextCompat.startForegroundService(this,intent)
        }
    }
}
