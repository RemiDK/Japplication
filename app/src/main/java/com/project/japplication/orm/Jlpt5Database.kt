package com.project.japplication.orm

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.project.japplication.orm.dao.Jlpt5Dao
import com.project.japplication.orm.entities.Jlpt5
import com.project.japplication.orm.utilities.ListConverter

@Database(entities = [Jlpt5::class], version = 1, exportSchema = false)
@TypeConverters(ListConverter::class)
abstract class Jlpt5Database : RoomDatabase() {

    abstract fun jlpt5Dao(): Jlpt5Dao

    // We declare a companion object to get static access to the method getAppDataBase, which gives us a singleton instance of the database
    // How to do it found here : https://codelabs.developers.google.com/codelabs/android-room-with-a-view-kotlin/#7
    companion object {

        @Volatile
        private var INSTANCE: Jlpt5Database? = null

        fun getKanjisDataBase(context: Context): Jlpt5Database {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(context.applicationContext, Jlpt5Database::class.java, "jlpt5_db").allowMainThreadQueries().build()
                INSTANCE = instance
                return instance
            }
        }
    }
}