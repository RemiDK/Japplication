package com.project.japplication.orm.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "jlpt5_table")
class Jlpt5(

    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "onyoumi") val onyoumi: String,
    @ColumnInfo(name = "kunyoumi") val kunyoumi: String
)