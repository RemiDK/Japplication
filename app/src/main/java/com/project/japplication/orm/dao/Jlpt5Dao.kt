package com.project.japplication.orm.dao

import androidx.room.*
import com.project.japplication.orm.entities.Kanji
import com.project.japplication.orm.entities.KanjiWithPronunciation
import com.project.japplication.orm.entities.Kunyoumi
import com.project.japplication.orm.entities.Onyoumi

@Dao
interface Jlpt5Dao {

    @Query("SELECT * FROM kanjis_table ORDER BY kanji_id ASC")
    fun getAll(): List<Kanji>

    @Query("SELECT * FROM kanjis_table WHERE kanji_id = :jlpt5Id")
    fun getById(jlpt5Id: Long?): Kanji

    @Query("SELECT * FROM kanjis_table WHERE name = :jlpt5Name")
    fun getByName(jlpt5Name: String?): Kanji

    @Transaction
    @Query("SELECT * FROM kanjis_table")
    fun getKanjisWithPronunciations(): List<KanjiWithPronunciation>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertKanji(kanji: Kanji)

    @Query("SELECT * FROM kanjis_table WHERE kanji_id = :kanjiId")
    fun getKanjisWithPronunciationsById(kanjiId: Long?): KanjiWithPronunciation

    @Query("DELETE FROM kanjis_table")
    fun resetTable()

    @Delete
    fun delete(kanji: Kanji)

    @Transaction
    @Query("SELECT * FROM onyoumi_table WHERE onyoumi_id = :onyoumi_id")
    fun getOnyoumiById(onyoumi_id: Long?): Onyoumi

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOnyoumi(onyoumi: Onyoumi)

    @Transaction
    @Query("SELECT * FROM kunyoumi_table WHERE kunyoumi_id = :kunyoumi_id")
    fun getKunyoumiById(kunyoumi_id: Long?): Kunyoumi

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertKunyoumi(kunyoumi: Kunyoumi)

}