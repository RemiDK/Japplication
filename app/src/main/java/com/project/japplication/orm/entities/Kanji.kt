package com.project.japplication.orm.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "kanjis_table")
data class Kanji(

    @PrimaryKey(autoGenerate = true)
    val kanji_id: Long? = null,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "description") val description: String
)