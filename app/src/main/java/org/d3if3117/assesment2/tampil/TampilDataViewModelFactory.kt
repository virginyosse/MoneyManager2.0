package org.d3if3117.assesment2.tampil

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3if3117.assesment2.data.PengeluaranDao

class TampilDataViewModelFactory(
    private val db: PengeluaranDao
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TampilDataViewModel::class.java)) {
            return TampilDataViewModel(db) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}