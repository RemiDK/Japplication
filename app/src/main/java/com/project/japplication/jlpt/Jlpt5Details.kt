package com.project.japplication.jlpt

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import com.project.japplication.R
import com.project.japplication.orm.Jlpt5Database

class Jlpt5Details : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.jlpt5_details)
        title = "JLPT 5"

        // Get kanji by using his ID
        val intent: Intent = intent
        val bundle: Bundle? = intent.extras
        val kanjiId = bundle?.getInt("kanji")

        // Find it in db
        val kanji = Jlpt5Database.getKanjisDataBase(this).jlpt5Dao().getById(kanjiId)

        val textView : TextView = findViewById(R.id.jlpt5_details_name)
        textView.text = kanji.name
    }
}