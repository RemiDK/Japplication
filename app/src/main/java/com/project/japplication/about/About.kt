package com.project.japplication.about

import android.app.Activity
import android.os.Bundle
import android.view.Menu
import com.project.japplication.R

class About : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.about)
        title="A propos"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }
}