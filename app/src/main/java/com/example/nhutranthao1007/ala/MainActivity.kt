package com.example.nhutranthao1007.ala

import android.app.Service
import android.content.Intent
import android.media.AsyncPlayer
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.widget.Button
import android.widget.TimePicker
import java.lang.UnsupportedOperationException
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var timePicker: TimePicker
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val setBtn = findViewById<Button>(R.id.startalambtn)
        val stopBtn = findViewById<Button>(R.id.stopalambtn)
        timePicker = findViewById<TimePicker>(R.id.TimePicker)
        val timerServiceIntent = Intent(this,AlarmService::class.java)
        setBtn.setOnClickListener{
            val hour = timePicker.hour
            val minute = timePicker.minute
            timerServiceIntent.putExtra("hour",hour)
            timerServiceIntent.putExtra("minute",minute)
            startService(timerServiceIntent)
        }
        stopBtn.setOnClickListener {
            stopService(timerServiceIntent)
        }
    }
}