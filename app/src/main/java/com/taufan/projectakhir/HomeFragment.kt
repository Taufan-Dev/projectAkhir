package com.taufan.projectakhir

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.taufan.projectakhir.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // PINDAHKAN LOGIKA KLIK "Lihat Semua" ke sini jika tombolnya ada di fragment_home
        binding.tvLihatSemua.setOnClickListener {
            // Karena tombol ini sekarang di dalam Fragment, kita panggil MainActivity
            (activity as? MainActivity)?.moveToExplore()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}