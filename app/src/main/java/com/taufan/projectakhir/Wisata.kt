package com.taufan.projectakhir

// Model untuk menampung data setiap tempat wisata
data class Wisata(
    val nama: String,
    val lokasi: String,
    val gambar: Int, // Kita pakai Int karena mengambil dari R.drawable
    val kota: String, // Untuk filter di TabLayout
    val rating: String = "(5.0)" // Nilai default rating
)