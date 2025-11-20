package id.ac.pnm.fitin

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textViewUsername = view.findViewById<TextView>(R.id.textViewUsername)
        textViewUsername.text = "Hey there"
        val searchView = view.findViewById<SearchView>(R.id.searchView)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewCatalog)
        recyclerView.adapter = CatalogAdapter(getCatalog(), ::openDetailProduct)
    }

    fun getCatalog(): List<Catalog> {
        val data = mutableListOf<Catalog>()
        data.add(Catalog(
            R.drawable.celana,
            "Cattwin Reworked pants",
            "Rp. 250.000",
            "Celana baggy jeans dengan bahan yang ringan",
            Category.Celana
        ))
        data.add(Catalog(
            R.drawable.knit,
            "Totoro day's",
            "Rp. 200.000",
            "knitt dirajut dengan benang woll dan motif unik",
            Category.Knit
        ))
        data.add(Catalog(
            R.drawable.jaket,
            "Memorable autumn in collage",
            "Rp. 250.000",
            "jaket boxy terbuat dari bahan kulit tebal",
            Category.Jaket
        ))
        data.add(Catalog(
            R.drawable.kemeja,
            "Fragmenta caeli",
            "200.000",
            "Kemeja berbahan fanell dengan motif yang unik",
            Category.Kemeja
        ))
        data.add(Catalog(
            R.drawable.dasi,
            "Dasi Mix Collection",
            "Rp. 50.000",
            "Dasi memiliki panjang 30cm dengan motif bunga",
            Category.Dasi
        ))
        data.add(Catalog(
            R.drawable.cardigan,
            "Doctorium cardigan",
            "Rp. 150.000",
            "cardigan terbuat dari bahan wol dengan ketebalan ..",
            Category.Cardigan
        ))
        return data
    }

     fun openDetailProduct(catalog: Catalog) {
        val intentMainToDetail = Intent(requireContext(), DetailProductActivity::class.java)
        intentMainToDetail.putExtra("judul", catalog.Name)
        intentMainToDetail.putExtra("img", catalog.Image)
        intentMainToDetail.putExtra("harga", catalog.Price)
        intentMainToDetail.putExtra("deskripsi", catalog.Deskripsi)
        intentMainToDetail.putExtra("kategori", catalog.Category.name)
        startActivity(intentMainToDetail)
    }
}