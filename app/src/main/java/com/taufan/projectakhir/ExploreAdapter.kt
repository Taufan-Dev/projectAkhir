package com.taufan.projectakhir

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.taufan.projectakhir.databinding.ItemExploreBinding

class ExploreAdapter(private var listWisata: List<Wisata>) :
    RecyclerView.Adapter<ExploreAdapter.WisataViewHolder>() {

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

        holder.binding.apply {
            // 1. Memasukkan data ke View
            tvNamaWisata.text = data.nama
            tvLokasi.text = "📍 ${data.lokasi}"
            ivWisata.setImageResource(data.gambar)

            // 2. Logika klik kartu untuk pindah ke Detail
            root.setOnClickListener {
                val intent = Intent(root.context, DetailActivity::class.java)
                // Mengirim data wisata yang diklik
                intent.putExtra("EXTRA_WISATA", data)
                root.context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int = listWisata.size

    // Fungsi untuk update data saat tab filter diklik
    fun updateData(newList: List<Wisata>) {
        listWisata = newList
        notifyDataSetChanged()
    }
}