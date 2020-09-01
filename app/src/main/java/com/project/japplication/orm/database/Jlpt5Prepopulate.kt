package com.project.japplication.orm.database

import android.content.Context
import com.project.japplication.orm.Jlpt5Database
import com.project.japplication.orm.entities.Jlpt5

fun prepopulateDbJlpt5(context: Context) {

    val db = Jlpt5Database.getKanjisDataBase(context)
    db.jlpt5Dao().resetTable()

    var newKanji = Jlpt5(name = "山", onyoumi = listOf("san"), kunyoumi = listOf("yama"), description = "Montagne")
    db.jlpt5Dao().insertKanji(newKanji)

    newKanji = Jlpt5(name = "一", onyoumi = listOf("ichi", "itsu"), kunyoumi = listOf("hito"), description = "Un")
    db.jlpt5Dao().insertKanji(newKanji)

    newKanji = Jlpt5(name = "二", onyoumi = listOf("ni", "ji"), kunyoumi = listOf("futa", "futata"), description = "Deux, test, retest")
    db.jlpt5Dao().insertKanji(newKanji)
}