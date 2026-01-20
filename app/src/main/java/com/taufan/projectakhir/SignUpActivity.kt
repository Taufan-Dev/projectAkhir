package com.taufan.projectakhir // Sesuaikan dengan package Anda

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        // 1. Definisikan tombol/teks Sign In
        val tvSignIn = findViewById<TextView>(R.id.tvSignIn)

        // 2. Beri aksi ketika diklik
        tvSignIn.setOnClickListener {
            // Membuat Intent untuk pindah dari SignUpActivity ke LoginActivity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

            // (Opsional) Tambahkan finish() jika Anda ingin agar saat user menekan tombol Back,
            // aplikasi tidak kembali ke halaman Sign Up, melainkan keluar atau ke halaman sebelumnya.
            // finish()
        }

        // ... (Kode logika Register lainnya tetap di sini)
    }
}