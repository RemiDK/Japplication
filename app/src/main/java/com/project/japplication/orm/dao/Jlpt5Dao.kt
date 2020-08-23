package com.project.japplication.orm.dao

import androidx.room.*
import com.project.japplication.orm.Jlpt5

@Dao
interface Jlpt5Dao {

    @Query("SELECT * FROM jlpt5_table ORDER BY id ASC")
    fun getAll(): List<Jlpt5>

    @Query("SELECT * FROM jlpt5_table WHERE id = :jlpt5Id")
    fun getById(jlpt5Id: Int): Jlpt5

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertKanji(jlpt5: Jlpt5)

    @Delete
    fun delete(jlpt5: Jlpt5)
}