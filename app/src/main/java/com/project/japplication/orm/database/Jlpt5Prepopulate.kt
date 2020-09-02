package com.project.japplication.orm.database

import android.content.Context
import com.project.japplication.orm.Jlpt5Database
import com.project.japplication.orm.entities.Kanji
import com.project.japplication.orm.entities.KanjiWithPronunciation
import com.project.japplication.orm.entities.Kunyoumi
import com.project.japplication.orm.entities.Onyoumi

fun prepopulateDbJlpt5(context: Context) {

    val db = Jlpt5Database.getKanjisDataBase(context)
    db.jlpt5Dao().resetTable()

    var newKanji = Kanji(name = "山", description = "Montagne")
    db.jlpt5Dao().insertKanji(newKanji)

    var newOnyoumi = Onyoumi(pronunciation = listOf("san"), example = listOf("test"), translation = listOf("tra", "trtr"))
    db.jlpt5Dao().insertOnyoumi(newOnyoumi)

    var newKunyoumi = Kunyoumi(pronunciation = listOf("yama"), example = listOf("pouet"), translation = listOf("Bob"))
    db.jlpt5Dao().insertKunyoumi(newKunyoumi)

    newKanji = Kanji(name = "一", description = "Un")
    db.jlpt5Dao().insertKanji(newKanji)

    newOnyoumi = Onyoumi(pronunciation = listOf("ichi, itsu"))
    db.jlpt5Dao().insertOnyoumi(newOnyoumi)

    newKunyoumi = Kunyoumi(pronunciation = listOf("hito"), example = listOf("一つ"), translation = listOf("Un (pour une chose)"))
    db.jlpt5Dao().insertKunyoumi(newKunyoumi)

}