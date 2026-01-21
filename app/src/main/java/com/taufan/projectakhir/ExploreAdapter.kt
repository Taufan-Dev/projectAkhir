package com.taufan.projectakhir

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.taufan.projectakhir.databinding.ItemExploreBinding

class ExploreAdapter(private var listWisata: List<Wisata>) :
    RecyclerView.Adapter<ExploreAdapter.WisataViewHolder>() {

    // Menghubungkan ke layout item_explore.xml menggunakan Binding
    inner class WisataViewHolder(val binding: ItemExploreBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WisataViewHolder {
        val binding = ItemExploreBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return WisataViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WisataViewHolder, position: Int) {
        val data = listWisata[position]

        // Memasukkan data ke dalam View
        holder.binding.apply {
            tvNamaWisata.text = data.nama
            tvLokasi.text = "📍 ${data.lokasi}"
            ivWisata.setImageResource(data.gambar)
            // Jika kamu ada TextView rating di item_explore.xml:
            // tvRating.text = data.rating
        }
    }

    override fun getItemCount(): Int = listWisata.size

    // Fungsi penting untuk update data saat klik tab kota
    fun updateData(newList: List<Wisata>) {
        listWisata = newList
        notifyDataSetChanged() // Memberitahu RecyclerView bahwa data berubah
    }
}