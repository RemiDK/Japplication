package com.project.japplication.jlpt

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.Button
import com.project.japplication.R
import com.project.japplication.orm.entities.Jlpt5
import com.project.japplication.orm.Jlpt5Database

class Jlpt5 : Activity() {

    private var db: Jlpt5Database? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.levelsList)
        title = "JLPT"

        // TODO Change to coroutine
        db = Jlpt5Database.getKanjisDataBase(this)

        var newKanji = Jlpt5(name = "山", onyoumi = listOf("san"), kunyoumi = listOf("yama"))
        db?.jlpt5Dao()?.insertKanji(newKanji)

        newKanji = Jlpt5(name = "一", onyoumi = listOf("ichi", "itsu"), kunyoumi = listOf("hito"))
        db?.jlpt5Dao()?.insertKanji(newKanji)

        val res = db?.jlpt5Dao()?.getAll()
        var kanjis = ""
        res?.map {
            kanjis += it.name +  " onyoumi : " + it.onyoumi + " kunyoumi : " + it.kunyoumi
        }

        val buttonJlpt5 = findViewById<Button>(R.id.buttonJlpt5)
        buttonJlpt5?.setOnClickListener {
            Log.i("TAG", kanjis)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }
}