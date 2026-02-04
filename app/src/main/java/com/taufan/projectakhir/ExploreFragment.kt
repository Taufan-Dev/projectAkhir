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

    // Data Lengkap sesuai model Wisata yang sudah Parcelable
    private val listSemuaWisata = listOf(
        Wisata(
            "Gunung Papandayan",
            "Garut",
            R.drawable.papandayan,
            "Garut",
            "Rp 35.000",
            "Gunung api yang menawarkan pemandangan kawah dan padang edelweiss yang sangat indah."
        ),
        Wisata(
            "Kawah Putih",
            "Bandung",
            R.drawable.kawahputih,
            "Bandung",
            "Rp 28.000",
            "Danau kawah yang airnya berwarna putih kehijauan dengan suasana kabut yang estetik."
        ),
        Wisata(
            "Curug Putri",
            "Kuningan",
            R.drawable.curugputri,
            "Kuningan",
            "Rp 20.000",
            "Terletak di kaki Gunung Ciremai, Curug Putri menawarkan pesona air terjun yang memukau dan udara segar."
        ),
        Wisata(
            "Situ Patenggang",
            "Bandung",
            R.drawable.situpatenggang,
            "Bandung",
            "Rp 25.000",
            "Danau yang dikelilingi hamparan kebun teh hijau yang sangat menyejukkan mata."
        ),
        Wisata(
            "Kebun Raya",
            "Bogor",
            R.drawable.kebunraya,
            "Bogor",
            "Rp 15.000",
            "Hutan kota terbesar yang menjadi paru-paru kota Bogor dengan ribuan koleksi pohon."
        ),
        Wisata(
            "Cirebon Waterland",
            "Cirebon",
            R.drawable.cirebonwaterland,
            "Cirebon",
            "Rp 50.000",
            "Wisata air modern di pinggir pantai yang cocok untuk liburan keluarga."
        )
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
        // Inisialisasi adapter (Logika klik sudah ditangani di dalam ExploreAdapter)
        exploreAdapter = ExploreAdapter(listSemuaWisata)

        binding.rvExplore.apply {
            // Menggunakan 2 kolom agar persis seperti gambar referensi
            layoutManager = GridLayoutManager(context, 2)
            adapter = exploreAdapter
            setHasFixedSize(true)
        }
    }

    private fun setupTabLayout() {
        val cities = listOf("All", "Bandung", "Kuningan", "Garut", "Bogor", "Cirebon")

        // Menghindari duplikasi tab jika fragment di-recreate
        if (binding.tabCity.tabCount == 0) {
            cities.forEach { cityName ->
                binding.tabCity.addTab(binding.tabCity.newTab().setText(cityName))
            }
        }

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