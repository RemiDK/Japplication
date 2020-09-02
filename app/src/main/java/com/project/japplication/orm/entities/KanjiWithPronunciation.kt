package com.project.japplication.orm.entities

import androidx.room.Embedded
import androidx.room.Relation

data class KanjiWithPronunciation (

    @Embedded val kanji: Kanji,
    @Relation(
        parentColumn = "kanji_id",
        entityColumn = "onyoumi_id"
    )
    val onyoumi: List<Onyoumi>,

    @Relation(
        parentColumn = "kanji_id",
        entityColumn = "kunyoumi_id"
    )
    val kunyoumi: List<Kunyoumi>
)