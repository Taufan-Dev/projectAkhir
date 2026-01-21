package com.taufan.projectakhir

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.taufan.projectakhir.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 1. Inisialisasi View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 2. Set Halaman Pertama yang muncul (HomeFragment)
        if (savedInstanceState == null) {
            loadFragment(HomeFragment())
        }

        // 3. Logika Klik Logout (Tetap di Header MainActivity)
        binding.tvLogOut.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            // Menutup semua activity agar tidak bisa kembali ke dashboard tanpa login
            finishAffinity()
        }

        // 4. Handling Klik Navigasi Bawah
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.navigation_explore -> {
                    loadFragment(ExploreFragment()) // Membuka tampilan yang ada tab kota
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

    /**
     * Fungsi untuk menukar Fragment di dalam FrameLayout (fragment_container)
     */
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    /**
     * Fungsi yang dipanggil dari HomeFragment saat klik "Lihat Semua"
     */
    fun moveToExplore() {
        // Ini akan memicu listener setOnItemSelectedListener di atas
        binding.bottomNavigation.selectedItemId = R.id.navigation_explore
    }
}