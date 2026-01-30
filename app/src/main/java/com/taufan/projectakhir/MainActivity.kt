package com.taufan.projectakhir

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.taufan.projectakhir.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. Set Halaman Pertama (HomeFragment) saat aplikasi dibuka
        if (savedInstanceState == null) {
            loadFragment(HomeFragment())
        }

        // 2. Logika Logout (Jika ada TextView/Button logout di Main)
        // Jika tvLogOut tidak ada di layout activity_main, bagian ini bisa dihapus/pindah ke Profile
        binding.tvLogOut?.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finishAffinity()
        }

        // 3. Handling Navigasi Bawah
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.navigation_explore -> {
                    loadFragment(ExploreFragment())
                    true
                }
                R.id.navigation_favorite -> {
                    loadFragment(FavoriteFragment())
                    true
                }
                R.id.navigation_profile -> {
                    // SEKARANG MEMANGGIL PROFILEFRAGMENT
                    loadFragment(ProfileFragment())
                    true
                }
                else -> false
            }
        }

        // 4. Handling pindah ke Favorite otomatis (Jika dikirim dari DetailActivity)
        val openFavorite = intent.getBooleanExtra("OPEN_FAVORITE", false)
        if (openFavorite) {
            moveToFavorite()
        }
    }

    // Fungsi inti untuk menukar Fragment di fragment_container
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    // Fungsi navigasi ke Explore (bisa dipanggil dari fragment lain)
    fun moveToExplore() {
        binding.bottomNavigation.selectedItemId = R.id.navigation_explore
    }

    // Fungsi navigasi ke Favorite (bisa dipanggil dari fragment lain)
    fun moveToFavorite() {
        binding.bottomNavigation.selectedItemId = R.id.navigation_favorite
    }
}