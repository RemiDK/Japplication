package com.project.japplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.project.japplication.jlpt.Jlpt5


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val jlptButton = findViewById<Button>(R.id.jlptButton)
        jlptButton?.setOnClickListener {
            val intent = Intent(this, Jlpt5::class.java)
            startActivity(intent)
        }
    }
}
