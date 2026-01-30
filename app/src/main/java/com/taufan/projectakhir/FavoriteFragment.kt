package com.taufan.projectakhir

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.taufan.projectakhir.databinding.FragmentFavoriteBinding

class FavoriteFragment : Fragment(R.layout.fragment_favorite) {
    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFavoriteBinding.bind(view)

        // Contoh data dummy yang difavoritkan
        val dataFav = listOf(
            Wisata("Curug Putri", "Kuningan", R.drawable.profile, "Kuningan", "Rp 20.000", "Deskripsi..."),
            Wisata("Riung Gunung", "Bandung", R.drawable.hero, "Bandung", "Rp 15.000", "Deskripsi...")
        )

        binding.rvFavorite.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = FavoriteAdapter(dataFav)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}