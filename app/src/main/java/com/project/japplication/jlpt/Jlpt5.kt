package com.project.japplication.jlpt

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.Button
import androidx.room.Room
import com.project.japplication.R
import com.project.japplication.orm.Jlpt5
import com.project.japplication.orm.Jlpt5Database

class Jlpt5 : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.jlpt5)
        title = "JLPT"

        val db = Room.databaseBuilder(applicationContext, Jlpt5Database::class.java, "jlpt5.db").build()
        val newKanji = Jlpt5(onyoumi = "ma", kunyoumi = "rche")

        val buttonJlpt5 = findViewById<Button>(R.id.buttonJlpt5)
        buttonJlpt5?.setOnClickListener {
            db.jlpt5Dao().insertKanji(newKanji)
            Log.i("TAG", newKanji.toString())
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }
}