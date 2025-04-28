package com.gaps.myapplication.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LocalModel(
    @PrimaryKey(autoGenerate = true) override val id: Int,
    override val data: String
) : BaseModel