package org.d3if3117.assesment2.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

//@Dao
//interface PengeluaranDao {
//    @Query("SELECT * FROM pengeluaran")
//    fun getAllPengeluaran(): Flow<List<Pengeluaran>>
//
//    @Insert
//    suspend fun insertPengeluaran(pengeluaran: Pengeluaran)
//
////    @Query("TRUNCATE pengeluaran")
////    suspend fun deleteAllPengeluaran()
//
//    @Query("DELETE FROM pengeluaran")
//    fun deleteAllPengeluaran()

@Dao
interface PengeluaranDao {
    @Insert
    fun insertPengeluaran(pengeluaran: PengeluaranEntity)

    @Query("SELECT * FROM pengeluaran ORDER BY id")
    fun getAllPengeluaran(): LiveData<List<PengeluaranEntity>>

    @Query("DELETE FROM pengeluaran")
    fun deleteAllPengeluaran()
}

