package org.d3if3117.assesment2.main

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import org.d3if3117.assesment2.databinding.FragTambahDataBinding
import org.d3if3117.assesment2.data.PengeluaranDB
import org.d3if3117.assesment2.model.Keuangan
import java.util.Calendar


class TambahDataFrag : Fragment() {
    private lateinit var binding: FragTambahDataBinding

    private val viewModel: PengeluaranViewModel by lazy {
        val db = PengeluaranDB.getInstance(requireContext())
        val factory = PengeluaranViewModelFactory(db.dao)

        ViewModelProvider(this, factory)[PengeluaranViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragTambahDataBinding.inflate(layoutInflater, container, false)
        binding.simpan.setOnClickListener { setData() }
        return binding.root
    }

    private fun setData() {
        val keterangan = binding.etKeterangan.text.toString()
        val jumlah = binding.etJmlUang.text.toString()

        val month = binding.datePicker.month + 1
        val day = binding.datePicker.dayOfMonth
        val year = binding.datePicker.year

        val tanggal = "$day/$month/$year"

        binding.datePicker.init(
            Calendar.getInstance().get(Calendar.YEAR),
            Calendar.getInstance().get(Calendar.MONTH),
            Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        ) { _, _, _, _ -> }
//        Log.i("ahh cobaa", "onCreateView: $tanggal")

        with (binding) {
            if (TextUtils.isEmpty(keterangan)) {
                etKeterangan.error = "Keterangan tidak boleh kosong"
                etKeterangan.requestFocus()
            } else if (TextUtils.isEmpty(jumlah)) {
                etJmlUang.error = "Jumlah tidak boleh kosong"
                etJmlUang.requestFocus()
            } else {
                viewModel.insertPengeluaran(
                    keterangan = keterangan,
                    tanggal = tanggal,
                    jumlah = jumlah.toInt()
                )
            }
        }
    }

    private fun showResult(result: Keuangan?) {
        if (result == null) return
    }
}
