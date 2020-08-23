package com.project.japplication.jlpt

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.Button
import com.project.japplication.R
import com.project.japplication.orm.Jlpt5
import com.project.japplication.orm.JlptDatabase
import com.project.japplication.orm.dao.Jlpt5Dao
import io.reactivex.Observable
import io.reactivex.Observable.fromCallable
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import io.reactivex.schedulers.Schedulers.io
import io.reactivex.android.schedulers.AndroidSchedulers;

class Jlpt5 : Activity() {

    private var db: JlptDatabase? = null
    private var jlpt5Dao: Jlpt5Dao? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.jlpt5)
        title = "JLPT"

        // TODO Change to coroutine
        val newKanji = Jlpt5(onyoumi = "ma", kunyoumi = "rche")
        db = JlptDatabase.getKanjisDataBase(this)
        db?.jlpt5Dao()?.insertKanji(newKanji)
        val res = db?.jlpt5Dao()?.getAll()
        var kanjis = ""
        res?.map {
            kanjis += "onyoumi " + it.onyoumi + "kunyoumi " + it.kunyoumi
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