package com.taufan.projectakhir

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.taufan.projectakhir.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. Tombol Login (ID XML: btn_login -> Kotlin: btnLogin)
        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString() // ID XML: et_email
            val password = binding.etPassword.text.toString() // ID XML: et_password

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Email dan Password wajib diisi", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Login diklik (dummy)", Toast.LENGTH_SHORT).show()
                // Contoh jika ingin langsung ke MainActivity:
                // startActivity(Intent(this, MainActivity::class.java))
            }
        }

        // 2. Pindah ke Sign Up (ID XML: tv_signup -> Kotlin: tvSignup)
        binding.tvSignup.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}