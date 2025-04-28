package com.gaps.myapplication.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gaps.myapplication.models.LocalModel
import kotlinx.coroutines.flow.Flow

@Dao
interface ModelDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertModel(model: LocalModel)

    @Query("SELECT * FROM localmodel WHERE id =:id")
    fun getModel(id: Int): Flow<LocalModel>

    @Query("SELECT * FROM localmodel")
    fun getAllModels(): Flow<List<LocalModel>>

    @Delete
    fun deleteModel(model: LocalModel)
}