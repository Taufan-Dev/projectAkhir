package com.taufan.projectakhir

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.taufan.projectakhir.databinding.ActivitySignUpBinding // Gunakan Binding agar lebih rapi

class SignUpActivity : AppCompatActivity() {

    // Menggunakan View Binding agar selaras dengan MainActivity/Fragment lainnya
    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. Aksi Tombol Register
        binding.btnRegister.setOnClickListener {
            val name = binding.etName.text.toString()
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            // Logika Cek Input (Jangan sampai kosong)
            if (name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {

                // Menampilkan Pesan Berhasil
                Toast.makeText(this, "Registrasi Berhasil! Silakan Login", Toast.LENGTH_LONG).show()

                // Pindah ke LoginActivity
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)

                // Finish agar user tidak bisa balik lagi ke halaman Sign Up dengan tombol back
                finish()

            } else {
                // Pesan Jika ada yang kosong
                Toast.makeText(this, "Mohon isi semua data!", Toast.LENGTH_SHORT).show()
            }
        }

        // 2. Aksi Teks "Sign In" (Jika sudah punya akun)
        binding.tvSignin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        // 3. Tombol Back (Arrow di pojok kiri atas)
        binding.btnBack.setOnClickListener {
            onBackPressed()
        }
    }
}