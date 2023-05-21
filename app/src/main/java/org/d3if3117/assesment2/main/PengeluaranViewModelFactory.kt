package org.d3if3117.assesment2.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3if3117.assesment2.data.PengeluaranDao

@Suppress("UNCHECKED_CAST")
class PengeluaranViewModelFactory(private val pengeluaranDao: PengeluaranDao) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PengeluaranViewModel::class.java)) return PengeluaranViewModel(
            pengeluaranDao
        ) as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}