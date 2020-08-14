package com.project.japplication.jlpt

import android.app.Activity
import android.os.Bundle
import android.view.Menu
import com.project.japplication.R

class Jlpt5 : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.jlpt5)
        title = "JLPT"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }
}