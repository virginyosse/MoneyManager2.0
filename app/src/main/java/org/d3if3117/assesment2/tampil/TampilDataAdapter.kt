package org.d3if3117.assesment2.tampil

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.d3if3117.assesment2.data.PengeluaranEntity
import org.d3if3117.assesment2.databinding.ListItemBinding
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class TampilDataAdapter(private val list: List<PengeluaranEntity>) :
    RecyclerView.Adapter<TampilDataAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(list[position])

    override fun getItemCount() = list.size

    class ViewHolder(
        private val binding: ListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
//        private val dateFormatter = SimpleDateFormat(
//            "dd MMMM yyyy",
//            Locale("id", "ID")
//        )

        fun bind(item: PengeluaranEntity) = with(binding) {
//            val rnd = Random()
//            val color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))

            binding.date.text = item.tanggal
            binding.ket.text = item.keterangan
            binding.jum.text = item.jumlah.toString()
        }
    }
}