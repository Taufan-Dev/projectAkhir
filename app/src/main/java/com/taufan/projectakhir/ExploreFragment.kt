package com.taufan.projectakhir

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.tabs.TabLayout
import com.taufan.projectakhir.databinding.FragmentExploreBinding

class ExploreFragment : Fragment() {

    private var _binding: FragmentExploreBinding? = null
    private val binding get() = _binding!!
    private lateinit var exploreAdapter: ExploreAdapter

    // Data Dummy sesuai gambar referensi
    private val listSemuaWisata = listOf(
        Wisata("Gunung Papandayan", "Garut", R.drawable.hero, "Garut"),
        Wisata("Kawah Putih", "Bandung", R.drawable.hero, "Bandung"),
        Wisata("Curug Putri", "Kuningan", R.drawable.profile, "Kuningan"),
        Wisata("Situ Patenggang", "Bandung", R.drawable.hero, "Bandung"),
        Wisata("Kebun Raya", "Bogor", R.drawable.hero, "Bogor"),
        Wisata("Cirebon Waterland", "Cirebon", R.drawable.hero, "Cirebon")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentExploreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        setupTabLayout()
    }

    private fun setupRecyclerView() {
        // Menggunakan GridLayout 2 kolom agar persis seperti gambar
        exploreAdapter = ExploreAdapter(listSemuaWisata)
        binding.rvExplore.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = exploreAdapter
        }
    }

    private fun setupTabLayout() {
        val cities = listOf("All", "Bandung", "Kuningan", "Garut", "Bogor", "Cirebon")

        // Menambahkan tab kota secara dinamis
        cities.forEach { cityName ->
            binding.tabCity.addTab(binding.tabCity.newTab().setText(cityName))
        }

        // Listener untuk memfilter data saat tab diklik
        binding.tabCity.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val selectedCity = tab?.text.toString()
                filterWisata(selectedCity)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }

    private fun filterWisata(kota: String) {
        // Logika filter data: Jika "All" tampilkan semua, jika tidak filter sesuai kota
        val hasilFilter = if (kota == "All") {
            listSemuaWisata
        } else {
            listSemuaWisata.filter { it.kota == kota }
        }
        exploreAdapter.updateData(hasilFilter)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}