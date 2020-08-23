package com.project.japplication.orm

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.project.japplication.orm.dao.Jlpt5Dao

@Database(entities = [Jlpt5::class], version = 1, exportSchema = false)
public abstract class JlptDatabase : RoomDatabase() {

    abstract fun jlpt5Dao(): Jlpt5Dao

    // We declare a companion object to get static access to the method getAppDataBase, which gives us a singleton instance of the database
    // How to do it found here : https://codelabs.developers.google.com/codelabs/android-room-with-a-view-kotlin/#7
    companion object {

        @Volatile
        private var INSTANCE: JlptDatabase? = null

        fun getKanjisDataBase(context: Context): JlptDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(context.applicationContext, JlptDatabase::class.java, "jlpt5_table").allowMainThreadQueries().build()
                INSTANCE = instance
                return instance
            }
        }
    }
}