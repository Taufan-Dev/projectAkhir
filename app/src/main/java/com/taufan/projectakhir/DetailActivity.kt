package com.taufan.projectakhir

import android.content.Intent
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

        // Mengatur padding agar tidak tertutup sistem bar (Edge-to-Edge)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 1. Menangkap data Parcelable dari Intent
        val dataWisata = intent.getParcelableExtra<Wisata>("EXTRA_WISATA")

        if (dataWisata != null) {
            binding.apply {
                // 2. Set data ke komponen UI
                ivDetailGambar.setImageResource(dataWisata.gambar)
                tvDetailJudul.text = dataWisata.nama
                tvDetailLokasi.text = "📍 ${dataWisata.lokasi}"
                tvDetailHarga.text = dataWisata.harga
                tvDetailDeskripsi.text = dataWisata.deskripsi
                tvDetailRating.text = dataWisata.rating

                // 3. Logika Favorite (Cek status dari manager)
                cbFavorite.isChecked = FavoriteManager.isFavorite(dataWisata)

                cbFavorite.setOnCheckedChangeListener { _, isChecked ->
                    if (isChecked) {
                        FavoriteManager.addFavorite(dataWisata)
                        Toast.makeText(this@DetailActivity, "Simpan ke Favorit ❤️", Toast.LENGTH_SHORT).show()
                    } else {
                        FavoriteManager.removeFavorite(dataWisata)
                        Toast.makeText(this@DetailActivity, "Dihapus dari Favorit", Toast.LENGTH_SHORT).show()
                    }
                }

                // 4. Logika Tombol Beli Tiket (Pindah ke Konfirmasi Pembayaran)
                btnBeliTiket.setOnClickListener {
                    val intentBayar = Intent(this@DetailActivity, KonfirmasiPembayaranActivity::class.java)

                    // Mengirimkan data yang dibutuhkan ke halaman pembayaran
                    intentBayar.putExtra("NAMA_WISATA", dataWisata.nama)
                    intentBayar.putExtra("HARGA_WISATA", dataWisata.harga)
                    intentBayar.putExtra("LOKASI_WISATA", dataWisata.lokasi)
                    intentBayar.putExtra("GAMBAR_WISATA", dataWisata.gambar)

                    startActivity(intentBayar)
                }

                // 5. Tombol Back
                ivBack.setOnClickListener {
                    onBackPressedDispatcher.onBackPressed()
                }
            }
        }
    }
}