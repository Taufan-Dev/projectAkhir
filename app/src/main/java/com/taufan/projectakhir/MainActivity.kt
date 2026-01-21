package com.taufan.projectakhir

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.taufan.projectakhir.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 1. Inisialisasi View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 2. Logika Klik Logout (Header)
        binding.tvLogOut.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            // Menutup semua activity agar tidak bisa kembali ke dashboard tanpa login
            finishAffinity()
        }

        // 3. Logika Klik "Lihat semua"
        // Mengarahkan ke tab Explore di navigasi bawah
        binding.tvLihatSemua.setOnClickListener {
            binding.bottomNavigation.selectedItemId = R.id.navigation_explore
            Toast.makeText(this, "Membuka Explore Wisata", Toast.LENGTH_SHORT).show()
        }

        // 4. Set Item Navigasi yang Terpilih Pertama Kali
        binding.bottomNavigation.selectedItemId = R.id.navigation_home

        // 5. Handling Klik Navigasi Bawah
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    Toast.makeText(this, "Beranda Wisata", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.navigation_explore -> {
                    Toast.makeText(this, "Cari Tempat Menarik", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.navigation_favorite -> {
                    Toast.makeText(this, "Wisata Favorit Anda", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.navigation_profile -> {
                    Toast.makeText(this, "Profil Pengguna", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }
}