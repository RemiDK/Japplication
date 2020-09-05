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

    // Un
    var newKanji = Kanji(name = "一", description = "Un")
    db.jlpt5Dao().insertKanji(newKanji)
    var  newOnyoumi = Onyoumi(pronunciation = listOf("いち"), example = listOf("一 (いち)"), translation = listOf("Un"))
    db.jlpt5Dao().insertOnyoumi(newOnyoumi)
    var newKunyoumi = Kunyoumi(pronunciation = listOf("ひとつ"), example = listOf("一つ (ひと)"), translation = listOf("Un (pour une chose)"))
    db.jlpt5Dao().insertKunyoumi(newKunyoumi)

    // Deux
    newKanji = Kanji(name = "二", description = "Deux")
    db.jlpt5Dao().insertKanji(newKanji)
    newOnyoumi = Onyoumi(pronunciation = listOf("に"), example = listOf("二 (に)"), translation = listOf("Deux"))
    db.jlpt5Dao().insertOnyoumi(newOnyoumi)
    newKunyoumi = Kunyoumi(pronunciation = listOf("ふた"), example = listOf("二つ (ふたつ)"), translation = listOf("Deux (pour une chose)"))
    db.jlpt5Dao().insertKunyoumi(newKunyoumi)

    //Trois
    newKanji = Kanji(name = "三", description = "Trois")
    db.jlpt5Dao().insertKanji(newKanji)
    newOnyoumi = Onyoumi(pronunciation = listOf("さん"), example = listOf("三 (さん)"), translation = listOf("Trois"))
    db.jlpt5Dao().insertOnyoumi(newOnyoumi)
    newKunyoumi = Kunyoumi(pronunciation = listOf("みっ、", "み"), example = listOf("三つ (みっつ)", "三島 (みしま)"), translation = listOf("Trois (pour une chose)", "Mishima (nom de famille japonais)"))
    db.jlpt5Dao().insertKunyoumi(newKunyoumi)

    //Montagne
    newKanji = Kanji(name = "山", description = "Montagne")
    db.jlpt5Dao().insertKanji(newKanji)
    newOnyoumi = Onyoumi(pronunciation = listOf("san"), example = listOf("富士山 (fujisan)"), translation = listOf("Mont Fuji"))
    db.jlpt5Dao().insertOnyoumi(newOnyoumi)
    newKunyoumi = Kunyoumi(pronunciation = listOf("yama"), example = listOf("山 (yama)"), translation = listOf("Montagne"))
    db.jlpt5Dao().insertKunyoumi(newKunyoumi)


}