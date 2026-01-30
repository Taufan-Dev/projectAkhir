package com.taufan.projectakhir

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Wisata(
    val nama: String,
    val lokasi: String,
    val gambar: Int,
    val kota: String,
    val harga: String,      // Menghilangkan error 'unresolved harga'
    val deskripsi: String,  // Menghilangkan error 'unresolved deskripsi'
    val rating: String = "(5.0)"
) : Parcelable // Menghilangkan error 'should be subtype of Parcelable'