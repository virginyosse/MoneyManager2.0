package org.d3if3117.assesment2.tampil



import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.d3if3117.assesment2.R
import org.d3if3117.assesment2.databinding.FragTampilInfoBinding



class TampilInfoFrag : Fragment() {
    private lateinit var binding: FragTampilInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragTampilInfoBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnShare.setOnClickListener { bagikanapp() }
    }

    fun bagikanapp(){
        val sharingIntent = Intent(Intent.ACTION_SEND)
        sharingIntent.type = "text/plain"
        sharingIntent.putExtra(Intent.EXTRA_SUBJECT, requireActivity().getString(R.string.app_name))
        sharingIntent.putExtra(Intent.EXTRA_TEXT, "Ayo Catat Pengeluaranmu dengan Money Manager!")
        requireActivity().startActivity(Intent.createChooser(sharingIntent, "Bagikan Melalui"))
    }
}