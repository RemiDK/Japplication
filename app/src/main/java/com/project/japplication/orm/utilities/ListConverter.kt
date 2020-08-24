package com.project.japplication.orm.utilities

import androidx.room.TypeConverter

// Help found here : https://stackoverflow.com/questions/44986626/android-room-database-how-to-handle-arraylist-in-an-entity

class ListConverter {
    @TypeConverter
    fun fromString(listConverter: String): List<String> {
        return listConverter.split(",").map { it }
    }

    @TypeConverter
    fun toString(stringList: List<String>): String {
        return stringList.joinToString(separator = ",")
    }
}