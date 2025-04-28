package com.gaps.myapplication.data

import android.content.Context
import com.gaps.myapplication.data.local.ModelDao
import com.gaps.myapplication.data.local.ModelDb

object LocalPersistence {

    fun getModelDao(context: Context): ModelDao {
        return ModelDb.getInstance(context).modelDao()
    }

}