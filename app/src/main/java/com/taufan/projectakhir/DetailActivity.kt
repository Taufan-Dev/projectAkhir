package com.taufan.projectakhir

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.taufan.projectakhir.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val dataWisata = intent.getParcelableExtra<Wisata>("EXTRA_WISATA")

        if (dataWisata != null) {
            binding.apply {
                ivDetailGambar.setImageResource(dataWisata.gambar)
                tvDetailJudul.text = dataWisata.nama
                tvDetailLokasi.text = "📍 ${dataWisata.lokasi}"
                tvDetailHarga.text = dataWisata.harga
                tvDetailDeskripsi.text = dataWisata.deskripsi
                tvDetailRating.text = dataWisata.rating

                cbFavorite.isChecked = FavoriteManager.isFavorite(dataWisata)

                cbFavorite.setOnCheckedChangeListener { _, isChecked ->
                    if (isChecked) {
                        FavoriteManager.addFavorite(dataWisata)
                        Toast.makeText(this@DetailActivity, "Simpan ke Favorit ❤️", Toast.LENGTH_SHORT).show()
                    } else {
                        FavoriteManager.removeFavorite(dataWisata)
                    }
                }

                btnBeliTiket.setOnClickListener {
                    Toast.makeText(this@DetailActivity, "Menuju pembayaran...", Toast.LENGTH_SHORT).show()
                }

                // Sekarang sudah aman!
                ivBack.setOnClickListener {
                    onBackPressedDispatcher.onBackPressed()
                }
            }
        }
    }
}