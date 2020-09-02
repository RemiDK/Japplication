package com.project.japplication.orm.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "kunyoumi_table")
data class Kunyoumi (

    @PrimaryKey(autoGenerate = true)
    val kunyoumi_id: Long? = null,
    @ColumnInfo(name = "pronunciation") val pronunciation: List<String> = emptyList(),
    @ColumnInfo(name = "example") val example: List<String> = emptyList(),
    @ColumnInfo(name = "translation") val translation: List<String> = emptyList()
)