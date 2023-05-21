package org.d3if3117.assesment2.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "pengeluaran")
data class PengeluaranEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    var tanggal: String,
    var keterangan: String,
    var jumlah: Int
): Parcelable
