package com.project.japplication.jlpt

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import com.project.japplication.R
import com.project.japplication.orm.Jlpt5Database
import com.project.japplication.orm.entities.Kunyoumi

class Jlpt5Details : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.jlpt5_details)
        title = "JLPT 5"

        // Get kanji by using his ID
        val intent: Intent = intent
        val bundle: Bundle? = intent.extras
        val kanjiId = bundle?.getLong("kanji")

        // Find it in db
        val kanjiWithPronunciation = Jlpt5Database.getKanjisDataBase(this).jlpt5Dao().getKanjisWithPronunciationsById(kanjiId)

        val kanjiNameView : TextView = findViewById(R.id.jlpt5_details_name)
        kanjiNameView.text = kanjiWithPronunciation.kanji.name

        val kanjiDescriptionView: TextView = findViewById(R.id.jlpt5_details_description)
        kanjiDescriptionView.text = kanjiWithPronunciation.kanji.description

        // Onyoumi
        // Change Onyoumi's list into string
        val kanjiOnyoumiView : TextView = findViewById(R.id.jlpt5_details_onyoumi)
        var onyoumiToString = ""
        for (onyoumi in kanjiWithPronunciation.onyoumi) {
            for(item in onyoumi.pronunciation) {
                onyoumiToString += "$item "
            }
        }
        val onYoumiToDisplay = getString(R.string.jlpt5_onyoumi, onyoumiToString)
        kanjiOnyoumiView.text = onYoumiToDisplay

        // Create a string with examples and translations
        val kanjiOnyoumiExample : TextView = findViewById(R.id.jlpt5_details_onyoumi_example)
        var onyoumiExampleToString = ""
        for (onyoumi in kanjiWithPronunciation.onyoumi) {
            var i = 0
            while (i < onyoumi.example.size) {
                onyoumiExampleToString += onyoumi.example[i] + " = "
                onyoumiExampleToString += onyoumi.translation[i]
                if (i < onyoumi.example.size - 1) {
                    onyoumiExampleToString += "\n"
                }

                i++
            }
        }
        kanjiOnyoumiExample.text = onyoumiExampleToString


        // Kunyoumi
        // Change kunyoumi's list into string
        val kanjiKunyoumi : TextView = findViewById(R.id.jlpt5_details_kunyoumi)
        var kunyoumiToString = ""
        for (kunyoumi in kanjiWithPronunciation.kunyoumi) {
            for (item in kunyoumi.pronunciation) {
                kunyoumiToString += "$item "
            }
        }
        val kunyoumiToDisplay = getString(R.string.jlpt5_kunyoumi, kunyoumiToString)
        kanjiKunyoumi.text = kunyoumiToDisplay

        // Create a string with examples and translations
        val kanjiKunyoumiExample : TextView = findViewById(R.id.jlpt5_details_kunyoumi_example)
        var kunyoumiExampleToString = ""
        for (kunyoumi in kanjiWithPronunciation.kunyoumi) {
            var i = 0
            while (i < kunyoumi.example.size) {
                kunyoumiExampleToString += kunyoumi.example[i] + " = "
                kunyoumiExampleToString += kunyoumi.translation[i]
                if (i < kunyoumi.example.size - 1) {
                    kunyoumiExampleToString += "\n"
                }

                i++
            }
        }
        kanjiKunyoumiExample.text = kunyoumiExampleToString
    }
}