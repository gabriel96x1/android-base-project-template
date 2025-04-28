package com.gaps.myapplication.models

import java.io.Serializable

data class RemoteModel(
    override val id: Int,
    override val data: String
) : BaseModel, Serializable