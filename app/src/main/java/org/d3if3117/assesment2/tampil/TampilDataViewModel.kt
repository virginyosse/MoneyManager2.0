package org.d3if3117.assesment2.tampil

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if3117.assesment2.data.PengeluaranDao


class TampilDataViewModel(private val db: PengeluaranDao) : ViewModel() {
    val data = db.getAllPengeluaran()
    fun hapusData() = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            db.deleteAllPengeluaran()
        }
    }
}