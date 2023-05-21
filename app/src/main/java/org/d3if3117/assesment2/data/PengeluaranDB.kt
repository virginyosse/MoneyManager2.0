package org.d3if3117.assesment2.data

import android.content.Context
import androidx.room.*

//@Database(entities = [Pengeluaran::class], version = 1, exportSchema = false)
//class PengeluaranDB {
//}
@Database(entities = [PengeluaranEntity::class], version = 2, exportSchema = false)
abstract class PengeluaranDB : RoomDatabase() {
    abstract val dao: PengeluaranDao
    companion object {
        @Volatile
        private var INSTANCE: PengeluaranDB? = null
        fun getInstance(context: Context): PengeluaranDB {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        PengeluaranDB::class.java,
                        "pengeluaran.db"
                    )
                        .allowMainThreadQueries()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}

