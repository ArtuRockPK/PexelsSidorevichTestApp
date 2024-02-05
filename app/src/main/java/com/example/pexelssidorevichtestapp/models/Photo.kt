package com.example.pexelssidorevichtestapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
@Entity(
    tableName = "photos"
)
data class Photo(
    @PrimaryKey(autoGenerate = true)
    val alt: String,
    val avg_color: String,
    val height: Int,
    val id: Int,
    val liked: Boolean,
    val photographer: String,
    val photographer_id: Int,
    val photographer_url: String,
    val src: SrcX,
    val url: String,
    val width: Int
) : Serializable