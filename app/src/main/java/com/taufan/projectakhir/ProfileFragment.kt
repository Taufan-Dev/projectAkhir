package com.taufan.projectakhir

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.taufan.projectakhir.R

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Jika R.layout.fragment_profile merah, pastikan file fragment_profile.xml ada di folder layout
        val view = inflater.inflate(R.layout.activity_profile_fragment, container, false)

        // Jika findViewById merah, pastikan Button sudah diimport (import android.widget.Button)
        val btnSimpan = view.findViewById<Button>(R.id.btnSimpan)

        btnSimpan.setOnClickListener {
            Toast.makeText(requireContext(), "Profil Berhasil Disimpan!", Toast.LENGTH_SHORT).show()
        }

        return view
    }
}