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


        val kanjiNameView : TextView = findViewById(R.id.jlpt5_details_name)
        kanjiNameView.text = kanji.name

        val kanjiDescriptionView: TextView = findViewById(R.id.jlpt5_details_description)
        kanjiDescriptionView.text = kanji.description

        val kanjiOnyoumiView : TextView = findViewById(R.id.jlpt5_details_onyoumi)
        val onyoumiToString = kanji.onyoumi.toString()
            .replace("[", "")
            .replace("]", "")
        val onYoumiToDisplay = getString(R.string.jlpt5_onyoumi, onyoumiToString)
        kanjiOnyoumiView.text = onYoumiToDisplay

        val kanjiKunyoumi : TextView = findViewById(R.id.jlpt5_details_kunyoumi)
        val kunyoumiToString = kanji.kunyoumi.toString()
            .replace("[", "")
            .replace("]", "")
        val kunyoumiToDisplay = getString(R.string.jlpt5_kunyoumi, kunyoumiToString)
        kanjiKunyoumi.text = kunyoumiToDisplay
    }
}