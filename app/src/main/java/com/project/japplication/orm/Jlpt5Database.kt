package com.project.japplication.orm

import androidx.room.Database
import androidx.room.RoomDatabase
import com.project.japplication.orm.dao.Jlpt5Dao

@Database(entities = [Jlpt5::class], version = 1)
abstract class Jlpt5Database : RoomDatabase() {

    abstract fun jlpt5Dao(): Jlpt5Dao
}