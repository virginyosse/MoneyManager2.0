package org.d3if3117.assesment2.main

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if3117.assesment2.data.PengeluaranDao
import org.d3if3117.assesment2.data.PengeluaranEntity
import org.d3if3117.assesment2.model.Keuangan

class PengeluaranViewModel(private val pengeluaranDao: PengeluaranDao) : ViewModel() {
    private val pengeluaran = MutableLiveData<Keuangan?>()
    private val hasil = MutableLiveData<Keuangan?>()

    fun getAllPengeluaran(): LiveData<List<PengeluaranEntity>> =
        pengeluaranDao.getAllPengeluaran()

    fun deleteAllPengeluaran() = viewModelScope.launch {
        withContext(Dispatchers.IO) { pengeluaranDao.deleteAllPengeluaran() }
    }

    fun insertPengeluaran(keterangan: String, tanggal: String, jumlah: Int) {
        val data = PengeluaranEntity(
            keterangan = keterangan,
            tanggal = tanggal,
            jumlah = jumlah,
        )

        hasil.value = data.tampilUang()

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                pengeluaranDao.insertPengeluaran(data)
            }
        }
    }

    fun PengeluaranEntity.tampilUang(): Keuangan{
        val ket = keterangan
        val tgl = tanggal
        val uang = jumlah

        return Keuangan(ket, tgl, uang)
    }

    fun getHasil(): LiveData<Keuangan?> = hasil
}