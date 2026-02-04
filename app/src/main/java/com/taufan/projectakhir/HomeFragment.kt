package com.taufan.projectakhir

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.taufan.projectakhir.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    // 1. Siapkan Data Wisata (Ambil 4-5 saja untuk tampilan Home)
    private val listWisataPopuler = listOf(
        Wisata(
            "Gunung Papandayan",
            "Garut",
            R.drawable.papandayan,
            "Garut",
            "Rp 35.000",
            "Gunung api yang menawarkan pemandangan kawah dan padang edelweiss."
        ),
        Wisata(
            "Curug Putri",
            "Kuningan",
            R.drawable.curugputri,
            "Kuningan",
            "Rp 20.000",
            "Terletak di kaki Gunung Ciremai, menawarkan pesona air terjun memukau."
        ),
        Wisata(
            "Kawah Putih",
            "Bandung",
            R.drawable.kawahputih,
            "Bandung",
            "Rp 28.000",
            "Danau kawah yang airnya berwarna putih kehijauan yang sangat estetik."
        ),
        Wisata(
            "Situ Patenggang",
            "Bandung",
            R.drawable.situpatenggang,
            "Bandung",
            "Rp 25.000",
            "Danau yang dikelilingi hamparan kebun teh hijau yang menyejukkan."
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 2. Jalankan setup RecyclerView Populer
        setupPopulerRecyclerView()

        // 3. Logika klik "Lihat Semua" pindah ke Explore
        binding.tvLihatSemua.setOnClickListener {
            (activity as? MainActivity)?.moveToExplore()
        }
    }

    private fun setupPopulerRecyclerView() {
        // Inisialisasi adapter khusus horizontal yang sudah kita buat sebelumnya
        val populerAdapter = PopulerAdapter(listWisataPopuler)

        binding.rvPopuler.apply {
            // Set layout menyamping (Horizontal)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = populerAdapter
            setHasFixedSize(true) // Optimasi performa
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}