package com.gaps.myapplication.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.gaps.myapplication.models.LocalModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(
    entities = [LocalModel::class],
    version = 1,
    exportSchema = true
)
abstract class ModelDb : RoomDatabase() {

    abstract fun dao(): ModelDao

    companion object {
        private var INSTANCE: ModelDb? = null

        fun getInstance(context: Context): ModelDb {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context = context.applicationContext,
                        ModelDb::class.java,
                        "model_db"
                    ).addCallback(object : Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            CoroutineScope(Dispatchers.IO).launch {
                                //prePopulateDb(context)
                            }
                        }
                    }).build()

                    INSTANCE = instance
                }

                return instance
            }
        }

        fun prePopulateDb(context: Context) {
            val dao = getInstance(context = context).dao()
            dao.insertModel(LocalModel(1, "String"))
        }
    }

}

