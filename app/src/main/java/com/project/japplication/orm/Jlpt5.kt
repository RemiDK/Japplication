package com.project.japplication.orm

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Jlpt5(

    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo(name = "onyoumi") val onyoumi: String,
    @ColumnInfo(name = "kunyoumi") val kunyoumi: String
)